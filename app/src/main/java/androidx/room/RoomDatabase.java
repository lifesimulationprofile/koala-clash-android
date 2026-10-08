package androidx.room;

import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.os.Looper;
import android.util.Log;
import androidx.activity.OnBackPressedDispatcher$$ExternalSyntheticLambda0;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.executor.ArchTaskExecutor$$ExternalSyntheticLambda0;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import coil.request.Parameters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptyMap;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class RoomDatabase {
    public boolean allowMainThreadQueries;
    public SupportSQLiteOpenHelper internalOpenHelper;
    public Executor internalQueryExecutor;
    public TransactionExecutor internalTransactionExecutor;
    public List mCallbacks;
    public volatile FrameworkSQLiteDatabase mDatabase;
    public final InvalidationTracker invalidationTracker = createInvalidationTracker();
    public final LinkedHashMap autoMigrationSpecs = new LinkedHashMap();
    public final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    public final ThreadLocal suspendingTransactionId = new ThreadLocal();
    public final Map backingFieldMap = Collections.synchronizedMap(new LinkedHashMap());
    public final LinkedHashMap typeConverters = new LinkedHashMap();

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Builder {
        public boolean allowDestructiveMigrationOnDowngrade;
        public boolean allowMainThreadQueries;
        public final Context context;
        public OnBackPressedDispatcher$$ExternalSyntheticLambda0 factory;
        public final Class klass;
        public HashSet migrationStartAndEndVersions;
        public final String name;
        public Executor queryExecutor;
        public Executor transactionExecutor;
        public final ArrayList callbacks = new ArrayList();
        public final ArrayList typeConverters = new ArrayList();
        public final ArrayList autoMigrationSpecs = new ArrayList();
        public final int journalMode = 1;
        public boolean requireMigration = true;
        public final long autoCloseTimeout = -1;
        public final Parameters.Builder migrationContainer = new Parameters.Builder(2);
        public final LinkedHashSet migrationsNotRequiredFrom = new LinkedHashSet();

        public Builder(Context context, Class cls, String str) {
            this.context = context;
            this.klass = cls;
            this.name = str;
        }

        public final void addMigrations(Migration... migrationArr) {
            if (this.migrationStartAndEndVersions == null) {
                this.migrationStartAndEndVersions = new HashSet();
            }
            for (Migration migration : migrationArr) {
                this.migrationStartAndEndVersions.add(Integer.valueOf(migration.startVersion));
                this.migrationStartAndEndVersions.add(Integer.valueOf(migration.endVersion));
            }
            this.migrationContainer.addMigrations((Migration[]) Arrays.copyOf(migrationArr, migrationArr.length));
        }

        public final RoomDatabase build() {
            boolean zContainsKey;
            Executor executor = this.queryExecutor;
            if (executor == null && this.transactionExecutor == null) {
                ArchTaskExecutor$$ExternalSyntheticLambda0 archTaskExecutor$$ExternalSyntheticLambda0 = ArchTaskExecutor.sIOThreadExecutor;
                this.transactionExecutor = archTaskExecutor$$ExternalSyntheticLambda0;
                this.queryExecutor = archTaskExecutor$$ExternalSyntheticLambda0;
            } else if (executor != null && this.transactionExecutor == null) {
                this.transactionExecutor = executor;
            } else if (executor == null) {
                this.queryExecutor = this.transactionExecutor;
            }
            HashSet hashSet = this.migrationStartAndEndVersions;
            LinkedHashSet linkedHashSet = this.migrationsNotRequiredFrom;
            if (hashSet != null) {
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    int iIntValue = ((Number) it.next()).intValue();
                    if (linkedHashSet.contains(Integer.valueOf(iIntValue))) {
                        throw new IllegalArgumentException(ImageAnalysis$$ExternalSyntheticLambda1.m("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: ", iIntValue).toString());
                    }
                }
            }
            SupportSQLiteOpenHelper.Factory companion = this.factory;
            if (companion == null) {
                companion = new ByteString.Companion(13);
            }
            SupportSQLiteOpenHelper.Factory factory = companion;
            if (this.autoCloseTimeout > 0) {
                if (this.name != null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                throw new IllegalArgumentException("Cannot create auto-closing database for an in-memory database.");
            }
            boolean z = this.allowMainThreadQueries;
            int i = this.journalMode;
            if (i == 0) {
                throw null;
            }
            Context context = this.context;
            if (i == 1) {
                Object systemService = context.getSystemService("activity");
                ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
                i = (activityManager == null || activityManager.isLowRamDevice()) ? 2 : 3;
            }
            Executor executor2 = this.queryExecutor;
            if (executor2 == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            Executor executor3 = this.transactionExecutor;
            if (executor3 == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            boolean z2 = this.requireMigration;
            boolean z3 = this.allowDestructiveMigrationOnDowngrade;
            int i2 = i;
            String str = this.name;
            Parameters.Builder builder = this.migrationContainer;
            ArrayList arrayList = this.callbacks;
            ArrayList arrayList2 = this.typeConverters;
            ArrayList arrayList3 = this.autoMigrationSpecs;
            DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration(context, str, factory, builder, arrayList, z, i2, executor2, executor3, z2, z3, linkedHashSet, arrayList2, arrayList3);
            Class cls = this.klass;
            String name = cls.getPackage().getName();
            String canonicalName = cls.getCanonicalName();
            if (name.length() != 0) {
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            String str2 = canonicalName.replace('.', '_') + "_Impl";
            try {
                RoomDatabase roomDatabase = (RoomDatabase) Class.forName(name.length() == 0 ? str2 : name + '.' + str2, true, cls.getClassLoader()).getDeclaredConstructor(null).newInstance(null);
                InvalidationTracker invalidationTracker = roomDatabase.invalidationTracker;
                LinkedHashMap linkedHashMap = roomDatabase.autoMigrationSpecs;
                roomDatabase.internalOpenHelper = roomDatabase.createOpenHelper(databaseConfiguration);
                Set requiredAutoMigrationSpecs = roomDatabase.getRequiredAutoMigrationSpecs();
                BitSet bitSet = new BitSet();
                Iterator it2 = requiredAutoMigrationSpecs.iterator();
                while (true) {
                    int i3 = -1;
                    if (!it2.hasNext()) {
                        int size = arrayList3.size() - 1;
                        if (size >= 0) {
                            while (true) {
                                int i4 = size - 1;
                                if (!bitSet.get(size)) {
                                    throw new IllegalArgumentException("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.");
                                }
                                if (i4 < 0) {
                                    break;
                                }
                                size = i4;
                            }
                        }
                        for (Migration migration : roomDatabase.getAutoMigrations()) {
                            int i5 = migration.startVersion;
                            int i6 = migration.endVersion;
                            LinkedHashMap linkedHashMap2 = builder.entries;
                            if (linkedHashMap2.containsKey(Integer.valueOf(i5))) {
                                Map map = (Map) linkedHashMap2.get(Integer.valueOf(i5));
                                if (map == null) {
                                    map = EmptyMap.INSTANCE;
                                }
                                zContainsKey = map.containsKey(Integer.valueOf(i6));
                            } else {
                                zContainsKey = false;
                            }
                            if (!zContainsKey) {
                                builder.addMigrations(migration);
                            }
                        }
                        roomDatabase.getOpenHelper().setWriteAheadLoggingEnabled(databaseConfiguration.journalMode == 3);
                        roomDatabase.mCallbacks = databaseConfiguration.callbacks;
                        roomDatabase.internalQueryExecutor = databaseConfiguration.queryExecutor;
                        roomDatabase.internalTransactionExecutor = new TransactionExecutor(databaseConfiguration.transactionExecutor, 0);
                        roomDatabase.allowMainThreadQueries = databaseConfiguration.allowMainThreadQueries;
                        Map requiredTypeConverters = roomDatabase.getRequiredTypeConverters();
                        BitSet bitSet2 = new BitSet();
                        for (Map.Entry entry : requiredTypeConverters.entrySet()) {
                            Class cls2 = (Class) entry.getKey();
                            for (Class cls3 : (List) entry.getValue()) {
                                int size2 = arrayList2.size() - 1;
                                if (size2 < 0) {
                                    size2 = -1;
                                    break;
                                }
                                while (true) {
                                    int i7 = size2 - 1;
                                    if (cls3.isAssignableFrom(arrayList2.get(size2).getClass())) {
                                        bitSet2.set(size2);
                                        break;
                                    }
                                    if (i7 < 0) {
                                        size2 = -1;
                                        break;
                                    }
                                    size2 = i7;
                                }
                                if (!(size2 >= 0)) {
                                    throw new IllegalArgumentException(("A required type converter (" + cls3 + ") for " + cls2.getCanonicalName() + " is missing in the database configuration.").toString());
                                }
                                roomDatabase.typeConverters.put(cls3, arrayList2.get(size2));
                            }
                        }
                        int size3 = arrayList2.size() - 1;
                        if (size3 >= 0) {
                            while (true) {
                                int i8 = size3 - 1;
                                if (!bitSet2.get(size3)) {
                                    throw new IllegalArgumentException("Unexpected type converter " + arrayList2.get(size3) + ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
                                }
                                if (i8 < 0) {
                                    break;
                                }
                                size3 = i8;
                            }
                        }
                        return roomDatabase;
                    }
                    Class cls4 = (Class) it2.next();
                    int size4 = arrayList3.size() - 1;
                    if (size4 >= 0) {
                        while (true) {
                            int i9 = size4 - 1;
                            if (cls4.isAssignableFrom(arrayList3.get(size4).getClass())) {
                                bitSet.set(size4);
                                i3 = size4;
                                break;
                            }
                            if (i9 < 0) {
                                break;
                            }
                            size4 = i9;
                        }
                    }
                    if (i3 < 0) {
                        throw new IllegalArgumentException(("A required auto migration spec (" + cls4.getCanonicalName() + ") is missing in the database configuration.").toString());
                    }
                    linkedHashMap.put(cls4, arrayList3.get(i3));
                }
            } catch (ClassNotFoundException unused) {
                throw new RuntimeException("Cannot find implementation for " + cls.getCanonicalName() + ". " + str2 + " does not exist");
            } catch (IllegalAccessException unused2) {
                throw new RuntimeException("Cannot access the constructor " + cls.getCanonicalName());
            } catch (InstantiationException unused3) {
                throw new RuntimeException("Failed to create an instance of " + cls.getCanonicalName());
            }
        }
    }

    public static Object unwrapOpenHelper(Class cls, SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        if (cls.isInstance(supportSQLiteOpenHelper)) {
            return supportSQLiteOpenHelper;
        }
        if (supportSQLiteOpenHelper instanceof DelegatingOpenHelper) {
            return unwrapOpenHelper(cls, ((DelegatingOpenHelper) supportSQLiteOpenHelper).getDelegate());
        }
        return null;
    }

    public final void assertNotMainThread() {
        if (!this.allowMainThreadQueries && Looper.getMainLooper().getThread() == Thread.currentThread()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public final void assertNotSuspendingTransaction() {
        if (!getOpenHelper().getWritableDatabase().inTransaction() && this.suspendingTransactionId.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    public final void beginTransaction() {
        assertNotMainThread();
        assertNotMainThread();
        FrameworkSQLiteDatabase writableDatabase = getOpenHelper().getWritableDatabase();
        this.invalidationTracker.syncTriggers$room_runtime_release(writableDatabase);
        if (writableDatabase.isWriteAheadLoggingEnabled()) {
            writableDatabase.beginTransactionNonExclusive();
        } else {
            writableDatabase.beginTransaction();
        }
    }

    public abstract InvalidationTracker createInvalidationTracker();

    public abstract SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration);

    public List getAutoMigrations() {
        return EmptyList.INSTANCE;
    }

    public final SupportSQLiteOpenHelper getOpenHelper() {
        SupportSQLiteOpenHelper supportSQLiteOpenHelper = this.internalOpenHelper;
        if (supportSQLiteOpenHelper != null) {
            return supportSQLiteOpenHelper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("internalOpenHelper");
        throw null;
    }

    public Set getRequiredAutoMigrationSpecs() {
        return EmptySet.INSTANCE;
    }

    public Map getRequiredTypeConverters() {
        return EmptyMap.INSTANCE;
    }

    public final void internalEndTransaction() {
        getOpenHelper().getWritableDatabase().endTransaction();
        if (getOpenHelper().getWritableDatabase().inTransaction()) {
            return;
        }
        InvalidationTracker invalidationTracker = this.invalidationTracker;
        if (invalidationTracker.pendingRefresh.compareAndSet(false, true)) {
            Executor executor = invalidationTracker.database.internalQueryExecutor;
            if (executor != null) {
                executor.execute(invalidationTracker.refreshRunnable);
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("internalQueryExecutor");
                throw null;
            }
        }
    }

    public final void internalInitInvalidationTracker(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
        InvalidationTracker invalidationTracker = this.invalidationTracker;
        synchronized (invalidationTracker.trackerLock) {
            if (invalidationTracker.initialized) {
                Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
                return;
            }
            frameworkSQLiteDatabase.execSQL("PRAGMA temp_store = MEMORY;");
            frameworkSQLiteDatabase.execSQL("PRAGMA recursive_triggers='ON';");
            frameworkSQLiteDatabase.execSQL("CREATE TEMP TABLE room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
            invalidationTracker.syncTriggers$room_runtime_release(frameworkSQLiteDatabase);
            invalidationTracker.cleanupStatement = frameworkSQLiteDatabase.compileStatement("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1");
            invalidationTracker.initialized = true;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean isOpenInternal() {
        FrameworkSQLiteDatabase frameworkSQLiteDatabase = this.mDatabase;
        return frameworkSQLiteDatabase != null && frameworkSQLiteDatabase.delegate.isOpen();
    }

    public final Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return getOpenHelper().getWritableDatabase().query(supportSQLiteQuery);
    }

    public final Object runInTransaction(Callable callable) {
        beginTransaction();
        try {
            Object objCall = callable.call();
            setTransactionSuccessful();
            return objCall;
        } finally {
            internalEndTransaction();
        }
    }

    public final void setTransactionSuccessful() {
        getOpenHelper().getWritableDatabase().setTransactionSuccessful();
    }
}
