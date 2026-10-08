package androidx.room;

import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.compose.ui.unit.Density;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import androidx.work.Worker;
import coil.disk.DiskLruCache;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class InvalidationTracker {
    public static final String[] TRIGGERS = {"UPDATE", "DELETE", "INSERT"};
    public volatile FrameworkSQLiteStatement cleanupStatement;
    public final RoomDatabase database;
    public volatile boolean initialized;
    public final DiskLruCache.Editor observedTableTracker;
    public final SafeIterableMap observerMap;
    public final AtomicBoolean pendingRefresh = new AtomicBoolean(false);
    public final Worker.AnonymousClass1 refreshRunnable;
    public final HashMap shadowTablesMap;
    public final Object syncTriggersLock;
    public final LinkedHashMap tableIdLookup;
    public final String[] tablesNames;
    public final Object trackerLock;

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public abstract class ObserverWrapper {
        public abstract void notifyByTableInvalidStatus$room_runtime_release(Set set);
    }

    public InvalidationTracker(RoomDatabase roomDatabase, HashMap map, HashMap map2, String... strArr) {
        this.database = roomDatabase;
        this.shadowTablesMap = map;
        this.observedTableTracker = new DiskLruCache.Editor(strArr.length);
        Collections.newSetFromMap(new IdentityHashMap());
        this.observerMap = new SafeIterableMap();
        this.syncTriggersLock = new Object();
        this.trackerLock = new Object();
        this.tableIdLookup = new LinkedHashMap();
        int length = strArr.length;
        String[] strArr2 = new String[length];
        for (int i = 0; i < length; i++) {
            String str = strArr[i];
            Locale locale = Locale.US;
            String lowerCase = str.toLowerCase(locale);
            this.tableIdLookup.put(lowerCase, Integer.valueOf(i));
            String str2 = (String) this.shadowTablesMap.get(strArr[i]);
            String lowerCase2 = str2 != null ? str2.toLowerCase(locale) : null;
            if (lowerCase2 != null) {
                lowerCase = lowerCase2;
            }
            strArr2[i] = lowerCase;
        }
        this.tablesNames = strArr2;
        for (Map.Entry entry : this.shadowTablesMap.entrySet()) {
            String str3 = (String) entry.getValue();
            Locale locale2 = Locale.US;
            String lowerCase3 = str3.toLowerCase(locale2);
            if (this.tableIdLookup.containsKey(lowerCase3)) {
                String lowerCase4 = ((String) entry.getKey()).toLowerCase(locale2);
                LinkedHashMap linkedHashMap = this.tableIdLookup;
                linkedHashMap.put(lowerCase4, MapsKt__MapsKt.getValue(lowerCase3, linkedHashMap));
            }
        }
        this.refreshRunnable = new Worker.AnonymousClass1(18, this);
    }

    public final boolean ensureInitialization$room_runtime_release() {
        if (!this.database.isOpenInternal()) {
            return false;
        }
        if (!this.initialized) {
            this.database.getOpenHelper().getWritableDatabase();
        }
        if (this.initialized) {
            return true;
        }
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    }

    public final void startTrackingTable(FrameworkSQLiteDatabase frameworkSQLiteDatabase, int i) {
        frameworkSQLiteDatabase.execSQL("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i + ", 0)");
        String str = this.tablesNames[i];
        for (int i2 = 0; i2 < 3; i2++) {
            String str2 = TRIGGERS[i2];
            StringBuilder sb = new StringBuilder("CREATE TEMP TRIGGER IF NOT EXISTS ");
            Density.CC.m(sb, "`room_table_modification_trigger_" + str + '_' + str2 + '`', " AFTER ", str2, " ON `");
            sb.append(str);
            sb.append("` BEGIN UPDATE room_table_modification_log SET invalidated = 1 WHERE table_id = ");
            sb.append(i);
            sb.append(" AND invalidated = 0; END");
            frameworkSQLiteDatabase.execSQL(sb.toString());
        }
    }

    public final void syncTriggers$room_runtime_release(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
        if (frameworkSQLiteDatabase.inTransaction()) {
            return;
        }
        try {
            ReentrantReadWriteLock.ReadLock lock = this.database.readWriteLock.readLock();
            lock.lock();
            try {
                synchronized (this.syncTriggersLock) {
                    try {
                        int[] tablesToSync = this.observedTableTracker.getTablesToSync();
                        if (tablesToSync != null) {
                            if (frameworkSQLiteDatabase.isWriteAheadLoggingEnabled()) {
                                frameworkSQLiteDatabase.beginTransactionNonExclusive();
                            } else {
                                frameworkSQLiteDatabase.beginTransaction();
                            }
                            try {
                                int length = tablesToSync.length;
                                int i = 0;
                                int i2 = 0;
                                while (i < length) {
                                    int i3 = tablesToSync[i];
                                    int i4 = i2 + 1;
                                    if (i3 == 1) {
                                        startTrackingTable(frameworkSQLiteDatabase, i2);
                                    } else if (i3 == 2) {
                                        String str = this.tablesNames[i2];
                                        String[] strArr = TRIGGERS;
                                        for (int i5 = 0; i5 < 3; i5++) {
                                            String str2 = strArr[i5];
                                            StringBuilder sb = new StringBuilder("DROP TRIGGER IF EXISTS ");
                                            sb.append("`room_table_modification_trigger_" + str + '_' + str2 + '`');
                                            frameworkSQLiteDatabase.execSQL(sb.toString());
                                        }
                                    }
                                    i++;
                                    i2 = i4;
                                }
                                frameworkSQLiteDatabase.setTransactionSuccessful();
                                frameworkSQLiteDatabase.endTransaction();
                                Unit unit = Unit.INSTANCE;
                            } catch (Throwable th) {
                                frameworkSQLiteDatabase.endTransaction();
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                lock.unlock();
            } catch (Throwable th3) {
                lock.unlock();
                throw th3;
            }
        } catch (SQLiteException e) {
            Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e);
        } catch (IllegalStateException e2) {
            Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e2);
        }
    }
}
