package androidx.sqlite.db.framework;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.util.Pair;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.room.RoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.util.ProcessLock;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.SynchronizedLazyImpl;
import kotlin.UNINITIALIZED_VALUE;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Handshake;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class FrameworkSQLiteOpenHelper implements SupportSQLiteOpenHelper {
    public final boolean allowDataLossOnRecovery;
    public final RoomOpenHelper callback;
    public final Context context;
    public final SynchronizedLazyImpl lazyDelegate = new SynchronizedLazyImpl(new Handshake.AnonymousClass2(22, this));
    public final String name;
    public final boolean useNoBackupDirectory;
    public boolean writeAheadLoggingEnabled;

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class DBRefHolder {
        public FrameworkSQLiteDatabase db = null;
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class OpenHelper extends SQLiteOpenHelper {
        public static final /* synthetic */ int $r8$clinit = 0;
        public final boolean allowDataLossOnRecovery;
        public final RoomOpenHelper callback;
        public final Context context;
        public final DBRefHolder dbRef;
        public final ProcessLock lock;
        public boolean migrated;
        public boolean opened;

        /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
        public final class CallbackException extends RuntimeException {
            public final int callbackName;
            public final Throwable cause;

            public CallbackException(int i, Throwable th) {
                super(th);
                this.callbackName = i;
                this.cause = th;
            }

            @Override // java.lang.Throwable
            public final Throwable getCause() {
                return this.cause;
            }
        }

        public OpenHelper(Context context, String str, final DBRefHolder dBRefHolder, final RoomOpenHelper roomOpenHelper, boolean z) {
            super(context, str, null, roomOpenHelper.version, new DatabaseErrorHandler(roomOpenHelper, dBRefHolder) { // from class: androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper$$ExternalSyntheticLambda0
                public final /* synthetic */ FrameworkSQLiteOpenHelper.DBRefHolder f$1;

                {
                    this.f$1 = dBRefHolder;
                }

                @Override // android.database.DatabaseErrorHandler
                public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
                    int i = FrameworkSQLiteOpenHelper.OpenHelper.$r8$clinit;
                    FrameworkSQLiteOpenHelper.DBRefHolder dBRefHolder2 = this.f$1;
                    FrameworkSQLiteDatabase frameworkSQLiteDatabase = dBRefHolder2.db;
                    if (frameworkSQLiteDatabase == null || !Intrinsics.areEqual(frameworkSQLiteDatabase.delegate, sQLiteDatabase)) {
                        frameworkSQLiteDatabase = new FrameworkSQLiteDatabase(sQLiteDatabase);
                        dBRefHolder2.db = frameworkSQLiteDatabase;
                    }
                    SQLiteDatabase sQLiteDatabase2 = frameworkSQLiteDatabase.delegate;
                    Log.e("SupportSQLite", "Corruption reported by sqlite on database: " + frameworkSQLiteDatabase + ".path");
                    if (!sQLiteDatabase2.isOpen()) {
                        String path = sQLiteDatabase2.getPath();
                        if (path != null) {
                            RoomOpenHelper.deleteDatabaseFile(path);
                            return;
                        }
                        return;
                    }
                    List<Pair<String, String>> attachedDbs = null;
                    try {
                        try {
                            attachedDbs = sQLiteDatabase2.getAttachedDbs();
                        } catch (SQLiteException unused) {
                        }
                        try {
                            frameworkSQLiteDatabase.close();
                        } catch (IOException unused2) {
                        }
                        if (attachedDbs != null) {
                            return;
                        }
                    } finally {
                        if (attachedDbs != null) {
                            Iterator<T> it = attachedDbs.iterator();
                            while (it.hasNext()) {
                                RoomOpenHelper.deleteDatabaseFile((String) ((Pair) it.next()).second);
                            }
                        } else {
                            String path2 = sQLiteDatabase2.getPath();
                            if (path2 != null) {
                                RoomOpenHelper.deleteDatabaseFile(path2);
                            }
                        }
                    }
                }
            });
            this.context = context;
            this.dbRef = dBRefHolder;
            this.callback = roomOpenHelper;
            this.allowDataLossOnRecovery = z;
            this.lock = new ProcessLock(str == null ? UUID.randomUUID().toString() : str, context.getCacheDir(), false);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public final void close() {
            ProcessLock processLock = this.lock;
            try {
                processLock.lock(processLock.processLock);
                super.close();
                this.dbRef.db = null;
                this.opened = false;
            } finally {
                processLock.unlock();
            }
        }

        public final FrameworkSQLiteDatabase getSupportDatabase(boolean z) {
            ProcessLock processLock = this.lock;
            try {
                processLock.lock((this.opened || getDatabaseName() == null) ? false : true);
                this.migrated = false;
                SQLiteDatabase sQLiteDatabaseInnerGetDatabase = innerGetDatabase(z);
                if (!this.migrated) {
                    return getWrappedDb(sQLiteDatabaseInnerGetDatabase);
                }
                close();
                return getSupportDatabase(z);
            } finally {
                processLock.unlock();
            }
        }

        public final FrameworkSQLiteDatabase getWrappedDb(SQLiteDatabase sQLiteDatabase) {
            DBRefHolder dBRefHolder = this.dbRef;
            FrameworkSQLiteDatabase frameworkSQLiteDatabase = dBRefHolder.db;
            if (frameworkSQLiteDatabase != null && Intrinsics.areEqual(frameworkSQLiteDatabase.delegate, sQLiteDatabase)) {
                return frameworkSQLiteDatabase;
            }
            FrameworkSQLiteDatabase frameworkSQLiteDatabase2 = new FrameworkSQLiteDatabase(sQLiteDatabase);
            dBRefHolder.db = frameworkSQLiteDatabase2;
            return frameworkSQLiteDatabase2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v0, types: [boolean] */
        /* JADX WARN: Type inference failed for: r6v1 */
        /* JADX WARN: Type inference failed for: r6v12, types: [android.database.sqlite.SQLiteDatabase] */
        /* JADX WARN: Type inference failed for: r6v14 */
        /* JADX WARN: Type inference failed for: r6v15 */
        /* JADX WARN: Type inference failed for: r6v16 */
        /* JADX WARN: Type inference failed for: r6v17 */
        /* JADX WARN: Type inference failed for: r6v2 */
        /* JADX WARN: Type inference failed for: r6v9, types: [android.database.sqlite.SQLiteDatabase] */
        public final SQLiteDatabase innerGetDatabase(boolean z) throws Throwable {
            File parentFile;
            String databaseName = getDatabaseName();
            boolean z2 = this.opened;
            Context context = this.context;
            if (databaseName != null && !z2 && (parentFile = context.getDatabasePath(databaseName).getParentFile()) != null) {
                parentFile.mkdirs();
                if (!parentFile.isDirectory()) {
                    Log.w("SupportSQLite", "Invalid database parent file, not a directory: " + parentFile);
                }
            }
            try {
                z = z != 0 ? getWritableDatabase() : getReadableDatabase();
                return z;
            } catch (Throwable unused) {
                super.close();
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException unused2) {
                }
                try {
                    z = z != 0 ? getWritableDatabase() : getReadableDatabase();
                    return z;
                } catch (Throwable th) {
                    super.close();
                    if (th instanceof CallbackException) {
                        CallbackException callbackException = th;
                        int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(callbackException.callbackName);
                        Throwable th2 = callbackException.cause;
                        if (iOrdinal == 0 || iOrdinal == 1 || iOrdinal == 2 || iOrdinal == 3 || !(th2 instanceof SQLiteException)) {
                            throw th2;
                        }
                    } else if (!(th instanceof SQLiteException) || databaseName == null || !this.allowDataLossOnRecovery) {
                        throw th;
                    }
                    context.deleteDatabase(databaseName);
                    try {
                        return z != 0 ? getWritableDatabase() : getReadableDatabase();
                    } catch (CallbackException e) {
                        throw e.cause;
                    }
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onConfigure(SQLiteDatabase sQLiteDatabase) {
            boolean z = this.migrated;
            RoomOpenHelper roomOpenHelper = this.callback;
            if (!z && roomOpenHelper.version != sQLiteDatabase.getVersion()) {
                sQLiteDatabase.setMaxSqlCacheSize(1);
            }
            try {
                getWrappedDb(sQLiteDatabase);
                roomOpenHelper.getClass();
            } catch (Throwable th) {
                throw new CallbackException(1, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                this.callback.onCreate(getWrappedDb(sQLiteDatabase));
            } catch (Throwable th) {
                throw new CallbackException(2, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.migrated = true;
            try {
                this.callback.onUpgrade(getWrappedDb(sQLiteDatabase), i, i2);
            } catch (Throwable th) {
                throw new CallbackException(4, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (!this.migrated) {
                try {
                    this.callback.onOpen(getWrappedDb(sQLiteDatabase));
                } catch (Throwable th) {
                    throw new CallbackException(5, th);
                }
            }
            this.opened = true;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.migrated = true;
            try {
                this.callback.onUpgrade(getWrappedDb(sQLiteDatabase), i, i2);
            } catch (Throwable th) {
                throw new CallbackException(3, th);
            }
        }
    }

    public FrameworkSQLiteOpenHelper(Context context, String str, RoomOpenHelper roomOpenHelper, boolean z, boolean z2) {
        this.context = context;
        this.name = str;
        this.callback = roomOpenHelper;
        this.useNoBackupDirectory = z;
        this.allowDataLossOnRecovery = z2;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.lazyDelegate._value != UNINITIALIZED_VALUE.INSTANCE) {
            ((OpenHelper) this.lazyDelegate.getValue()).close();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public final FrameworkSQLiteDatabase getWritableDatabase() {
        return ((OpenHelper) this.lazyDelegate.getValue()).getSupportDatabase(true);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public final void setWriteAheadLoggingEnabled(boolean z) {
        if (this.lazyDelegate._value != UNINITIALIZED_VALUE.INSTANCE) {
            ((OpenHelper) this.lazyDelegate.getValue()).setWriteAheadLoggingEnabled(z);
        }
        this.writeAheadLoggingEnabled = z;
    }
}
