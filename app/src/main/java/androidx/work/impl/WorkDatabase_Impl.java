package androidx.work.impl;

import androidx.appcompat.app.AlertController;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkTagDao_Impl$1;
import androidx.work.impl.model.WorkTagDao_Impl$2;
import coil.ImageLoader$Builder;
import coil.memory.RealStrongMemoryCache;
import coil.request.RequestService;
import com.caverock.androidsvg.SVG;
import com.github.kr328.clash.service.data.Database_Impl;
import com.google.android.gms.common.internal.zzv;
import com.google.android.material.internal.CheckableGroup;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class WorkDatabase_Impl extends WorkDatabase {
    public volatile WorkLauncherImpl _dependencyDao;
    public volatile RealStrongMemoryCache _preferenceDao;
    public volatile Request.Builder _systemIdInfoDao;
    public volatile RequestService _workNameDao;
    public volatile SVG _workProgressDao;
    public volatile WorkSpecDao_Impl _workSpecDao;
    public volatile ImageLoader$Builder _workTagDao;

    /* JADX INFO: renamed from: androidx.work.impl.WorkDatabase_Impl$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class AnonymousClass1 {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ RoomDatabase this$0;
        public final int version;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Database_Impl database_Impl) {
            this(4);
            this.$r8$classId = 1;
            this.this$0 = database_Impl;
        }

        public final void createAllTables(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
            switch (this.$r8$classId) {
                case 0:
                    frameworkSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                    frameworkSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
                    frameworkSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
                    frameworkSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT NOT NULL, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `last_enqueue_time` INTEGER NOT NULL DEFAULT -1, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `run_in_foreground` INTEGER NOT NULL, `out_of_quota_policy` INTEGER NOT NULL, `period_count` INTEGER NOT NULL DEFAULT 0, `generation` INTEGER NOT NULL DEFAULT 0, `next_schedule_time_override` INTEGER NOT NULL DEFAULT 9223372036854775807, `next_schedule_time_override_generation` INTEGER NOT NULL DEFAULT 0, `stop_reason` INTEGER NOT NULL DEFAULT -256, `required_network_type` INTEGER NOT NULL, `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB NOT NULL, PRIMARY KEY(`id`))");
                    frameworkSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
                    frameworkSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_last_enqueue_time` ON `WorkSpec` (`last_enqueue_time`)");
                    frameworkSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                    frameworkSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
                    frameworkSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `generation` INTEGER NOT NULL DEFAULT 0, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`, `generation`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                    frameworkSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                    frameworkSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
                    frameworkSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                    frameworkSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
                    frameworkSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                    frameworkSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '7d73d21f1bd82c9e5268b6dcf9fde2cb')");
                    break;
                default:
                    frameworkSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `imported` (`uuid` TEXT NOT NULL, `name` TEXT NOT NULL, `type` TEXT NOT NULL, `source` TEXT NOT NULL, `interval` INTEGER NOT NULL, `upload` INTEGER NOT NULL, `download` INTEGER NOT NULL, `total` INTEGER NOT NULL, `expire` INTEGER NOT NULL, `createdAt` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL DEFAULT 0, `announce` TEXT, `supportURL` TEXT, `profileImage` BLOB, `modeSwitchAllowed` INTEGER NOT NULL DEFAULT 1, PRIMARY KEY(`uuid`))");
                    frameworkSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `selections` (`uuid` TEXT NOT NULL, `proxy` TEXT NOT NULL, `selected` TEXT NOT NULL, PRIMARY KEY(`uuid`, `proxy`), FOREIGN KEY(`uuid`) REFERENCES `imported`(`uuid`) ON UPDATE CASCADE ON DELETE CASCADE )");
                    frameworkSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                    frameworkSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '8c35d7d374f413febfcb9ee273005d53')");
                    break;
            }
        }

        public final zzv onValidateSchema(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
            switch (this.$r8$classId) {
                case 0:
                    HashMap map = new HashMap(2);
                    map.put("work_spec_id", new TableInfo.Column("work_spec_id", "TEXT", true, 1, null, 1));
                    map.put("prerequisite_id", new TableInfo.Column("prerequisite_id", "TEXT", true, 2, null, 1));
                    HashSet hashSet = new HashSet(2);
                    hashSet.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
                    hashSet.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("prerequisite_id"), Arrays.asList("id")));
                    HashSet hashSet2 = new HashSet(2);
                    hashSet2.add(new TableInfo.Index("index_Dependency_work_spec_id", false, Arrays.asList("work_spec_id"), Arrays.asList("ASC")));
                    hashSet2.add(new TableInfo.Index("index_Dependency_prerequisite_id", false, Arrays.asList("prerequisite_id"), Arrays.asList("ASC")));
                    TableInfo tableInfo = new TableInfo("Dependency", map, hashSet, hashSet2);
                    TableInfo tableInfo2 = TableInfo.read(frameworkSQLiteDatabase, "Dependency");
                    if (!tableInfo.equals(tableInfo2)) {
                        return new zzv(false, "Dependency(androidx.work.impl.model.Dependency).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
                    }
                    HashMap map2 = new HashMap(30);
                    map2.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, 1));
                    map2.put("state", new TableInfo.Column("state", "INTEGER", true, 0, null, 1));
                    map2.put("worker_class_name", new TableInfo.Column("worker_class_name", "TEXT", true, 0, null, 1));
                    map2.put("input_merger_class_name", new TableInfo.Column("input_merger_class_name", "TEXT", true, 0, null, 1));
                    map2.put("input", new TableInfo.Column("input", "BLOB", true, 0, null, 1));
                    map2.put("output", new TableInfo.Column("output", "BLOB", true, 0, null, 1));
                    map2.put("initial_delay", new TableInfo.Column("initial_delay", "INTEGER", true, 0, null, 1));
                    map2.put("interval_duration", new TableInfo.Column("interval_duration", "INTEGER", true, 0, null, 1));
                    map2.put("flex_duration", new TableInfo.Column("flex_duration", "INTEGER", true, 0, null, 1));
                    map2.put("run_attempt_count", new TableInfo.Column("run_attempt_count", "INTEGER", true, 0, null, 1));
                    map2.put("backoff_policy", new TableInfo.Column("backoff_policy", "INTEGER", true, 0, null, 1));
                    map2.put("backoff_delay_duration", new TableInfo.Column("backoff_delay_duration", "INTEGER", true, 0, null, 1));
                    map2.put("last_enqueue_time", new TableInfo.Column("last_enqueue_time", "INTEGER", true, 0, "-1", 1));
                    map2.put("minimum_retention_duration", new TableInfo.Column("minimum_retention_duration", "INTEGER", true, 0, null, 1));
                    map2.put("schedule_requested_at", new TableInfo.Column("schedule_requested_at", "INTEGER", true, 0, null, 1));
                    map2.put("run_in_foreground", new TableInfo.Column("run_in_foreground", "INTEGER", true, 0, null, 1));
                    map2.put("out_of_quota_policy", new TableInfo.Column("out_of_quota_policy", "INTEGER", true, 0, null, 1));
                    map2.put("period_count", new TableInfo.Column("period_count", "INTEGER", true, 0, "0", 1));
                    map2.put("generation", new TableInfo.Column("generation", "INTEGER", true, 0, "0", 1));
                    map2.put("next_schedule_time_override", new TableInfo.Column("next_schedule_time_override", "INTEGER", true, 0, "9223372036854775807", 1));
                    map2.put("next_schedule_time_override_generation", new TableInfo.Column("next_schedule_time_override_generation", "INTEGER", true, 0, "0", 1));
                    map2.put("stop_reason", new TableInfo.Column("stop_reason", "INTEGER", true, 0, "-256", 1));
                    map2.put("required_network_type", new TableInfo.Column("required_network_type", "INTEGER", true, 0, null, 1));
                    map2.put("requires_charging", new TableInfo.Column("requires_charging", "INTEGER", true, 0, null, 1));
                    map2.put("requires_device_idle", new TableInfo.Column("requires_device_idle", "INTEGER", true, 0, null, 1));
                    map2.put("requires_battery_not_low", new TableInfo.Column("requires_battery_not_low", "INTEGER", true, 0, null, 1));
                    map2.put("requires_storage_not_low", new TableInfo.Column("requires_storage_not_low", "INTEGER", true, 0, null, 1));
                    map2.put("trigger_content_update_delay", new TableInfo.Column("trigger_content_update_delay", "INTEGER", true, 0, null, 1));
                    map2.put("trigger_max_content_delay", new TableInfo.Column("trigger_max_content_delay", "INTEGER", true, 0, null, 1));
                    map2.put("content_uri_triggers", new TableInfo.Column("content_uri_triggers", "BLOB", true, 0, null, 1));
                    HashSet hashSet3 = new HashSet(0);
                    HashSet hashSet4 = new HashSet(2);
                    hashSet4.add(new TableInfo.Index("index_WorkSpec_schedule_requested_at", false, Arrays.asList("schedule_requested_at"), Arrays.asList("ASC")));
                    hashSet4.add(new TableInfo.Index("index_WorkSpec_last_enqueue_time", false, Arrays.asList("last_enqueue_time"), Arrays.asList("ASC")));
                    TableInfo tableInfo3 = new TableInfo("WorkSpec", map2, hashSet3, hashSet4);
                    TableInfo tableInfo4 = TableInfo.read(frameworkSQLiteDatabase, "WorkSpec");
                    if (!tableInfo3.equals(tableInfo4)) {
                        return new zzv(false, "WorkSpec(androidx.work.impl.model.WorkSpec).\n Expected:\n" + tableInfo3 + "\n Found:\n" + tableInfo4);
                    }
                    HashMap map3 = new HashMap(2);
                    map3.put("tag", new TableInfo.Column("tag", "TEXT", true, 1, null, 1));
                    map3.put("work_spec_id", new TableInfo.Column("work_spec_id", "TEXT", true, 2, null, 1));
                    HashSet hashSet5 = new HashSet(1);
                    hashSet5.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
                    HashSet hashSet6 = new HashSet(1);
                    hashSet6.add(new TableInfo.Index("index_WorkTag_work_spec_id", false, Arrays.asList("work_spec_id"), Arrays.asList("ASC")));
                    TableInfo tableInfo5 = new TableInfo("WorkTag", map3, hashSet5, hashSet6);
                    TableInfo tableInfo6 = TableInfo.read(frameworkSQLiteDatabase, "WorkTag");
                    if (!tableInfo5.equals(tableInfo6)) {
                        return new zzv(false, "WorkTag(androidx.work.impl.model.WorkTag).\n Expected:\n" + tableInfo5 + "\n Found:\n" + tableInfo6);
                    }
                    HashMap map4 = new HashMap(3);
                    map4.put("work_spec_id", new TableInfo.Column("work_spec_id", "TEXT", true, 1, null, 1));
                    map4.put("generation", new TableInfo.Column("generation", "INTEGER", true, 2, "0", 1));
                    map4.put("system_id", new TableInfo.Column("system_id", "INTEGER", true, 0, null, 1));
                    HashSet hashSet7 = new HashSet(1);
                    hashSet7.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
                    TableInfo tableInfo7 = new TableInfo("SystemIdInfo", map4, hashSet7, new HashSet(0));
                    TableInfo tableInfo8 = TableInfo.read(frameworkSQLiteDatabase, "SystemIdInfo");
                    if (!tableInfo7.equals(tableInfo8)) {
                        return new zzv(false, "SystemIdInfo(androidx.work.impl.model.SystemIdInfo).\n Expected:\n" + tableInfo7 + "\n Found:\n" + tableInfo8);
                    }
                    HashMap map5 = new HashMap(2);
                    map5.put("name", new TableInfo.Column("name", "TEXT", true, 1, null, 1));
                    map5.put("work_spec_id", new TableInfo.Column("work_spec_id", "TEXT", true, 2, null, 1));
                    HashSet hashSet8 = new HashSet(1);
                    hashSet8.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
                    HashSet hashSet9 = new HashSet(1);
                    hashSet9.add(new TableInfo.Index("index_WorkName_work_spec_id", false, Arrays.asList("work_spec_id"), Arrays.asList("ASC")));
                    TableInfo tableInfo9 = new TableInfo("WorkName", map5, hashSet8, hashSet9);
                    TableInfo tableInfo10 = TableInfo.read(frameworkSQLiteDatabase, "WorkName");
                    if (!tableInfo9.equals(tableInfo10)) {
                        return new zzv(false, "WorkName(androidx.work.impl.model.WorkName).\n Expected:\n" + tableInfo9 + "\n Found:\n" + tableInfo10);
                    }
                    HashMap map6 = new HashMap(2);
                    map6.put("work_spec_id", new TableInfo.Column("work_spec_id", "TEXT", true, 1, null, 1));
                    map6.put("progress", new TableInfo.Column("progress", "BLOB", true, 0, null, 1));
                    HashSet hashSet10 = new HashSet(1);
                    hashSet10.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
                    TableInfo tableInfo11 = new TableInfo("WorkProgress", map6, hashSet10, new HashSet(0));
                    TableInfo tableInfo12 = TableInfo.read(frameworkSQLiteDatabase, "WorkProgress");
                    if (!tableInfo11.equals(tableInfo12)) {
                        return new zzv(false, "WorkProgress(androidx.work.impl.model.WorkProgress).\n Expected:\n" + tableInfo11 + "\n Found:\n" + tableInfo12);
                    }
                    HashMap map7 = new HashMap(2);
                    map7.put("key", new TableInfo.Column("key", "TEXT", true, 1, null, 1));
                    map7.put("long_value", new TableInfo.Column("long_value", "INTEGER", false, 0, null, 1));
                    TableInfo tableInfo13 = new TableInfo("Preference", map7, new HashSet(0), new HashSet(0));
                    TableInfo tableInfo14 = TableInfo.read(frameworkSQLiteDatabase, "Preference");
                    if (tableInfo13.equals(tableInfo14)) {
                        return new zzv(true, (String) null);
                    }
                    return new zzv(false, "Preference(androidx.work.impl.model.Preference).\n Expected:\n" + tableInfo13 + "\n Found:\n" + tableInfo14);
                default:
                    HashMap map8 = new HashMap(15);
                    map8.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 1, null, 1));
                    map8.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, 1));
                    map8.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, 1));
                    map8.put("source", new TableInfo.Column("source", "TEXT", true, 0, null, 1));
                    map8.put("interval", new TableInfo.Column("interval", "INTEGER", true, 0, null, 1));
                    map8.put("upload", new TableInfo.Column("upload", "INTEGER", true, 0, null, 1));
                    map8.put("download", new TableInfo.Column("download", "INTEGER", true, 0, null, 1));
                    map8.put("total", new TableInfo.Column("total", "INTEGER", true, 0, null, 1));
                    map8.put("expire", new TableInfo.Column("expire", "INTEGER", true, 0, null, 1));
                    map8.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, 1));
                    map8.put("updatedAt", new TableInfo.Column("updatedAt", "INTEGER", true, 0, "0", 1));
                    map8.put("announce", new TableInfo.Column("announce", "TEXT", false, 0, null, 1));
                    map8.put("supportURL", new TableInfo.Column("supportURL", "TEXT", false, 0, null, 1));
                    map8.put("profileImage", new TableInfo.Column("profileImage", "BLOB", false, 0, null, 1));
                    map8.put("modeSwitchAllowed", new TableInfo.Column("modeSwitchAllowed", "INTEGER", true, 0, "1", 1));
                    TableInfo tableInfo15 = new TableInfo("imported", map8, new HashSet(0), new HashSet(0));
                    TableInfo tableInfo16 = TableInfo.read(frameworkSQLiteDatabase, "imported");
                    if (!tableInfo15.equals(tableInfo16)) {
                        return new zzv(false, "imported(com.github.kr328.clash.service.data.Imported).\n Expected:\n" + tableInfo15 + "\n Found:\n" + tableInfo16);
                    }
                    HashMap map9 = new HashMap(3);
                    map9.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 1, null, 1));
                    map9.put("proxy", new TableInfo.Column("proxy", "TEXT", true, 2, null, 1));
                    map9.put("selected", new TableInfo.Column("selected", "TEXT", true, 0, null, 1));
                    HashSet hashSet11 = new HashSet(1);
                    hashSet11.add(new TableInfo.ForeignKey("imported", "CASCADE", "CASCADE", Arrays.asList("uuid"), Arrays.asList("uuid")));
                    TableInfo tableInfo17 = new TableInfo("selections", map9, hashSet11, new HashSet(0));
                    TableInfo tableInfo18 = TableInfo.read(frameworkSQLiteDatabase, "selections");
                    if (tableInfo17.equals(tableInfo18)) {
                        return new zzv(true, (String) null);
                    }
                    return new zzv(false, "selections(com.github.kr328.clash.service.data.Selection).\n Expected:\n" + tableInfo17 + "\n Found:\n" + tableInfo18);
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(WorkDatabase_Impl workDatabase_Impl) {
            this(20);
            this.$r8$classId = 0;
            this.this$0 = workDatabase_Impl;
        }

        public AnonymousClass1(int i) {
            this.version = i;
        }
    }

    @Override // androidx.room.RoomDatabase
    public final InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName", "WorkProgress", "Preference");
    }

    @Override // androidx.room.RoomDatabase
    public final SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(new CheckableGroup(databaseConfiguration.context, databaseConfiguration.name, new RoomOpenHelper(databaseConfiguration, new AnonymousClass1(this), "7d73d21f1bd82c9e5268b6dcf9fde2cb", "3071c8717539de5d5353f4c8cd59a032"), false, false));
    }

    @Override // androidx.work.impl.WorkDatabase
    public final WorkLauncherImpl dependencyDao() {
        WorkLauncherImpl workLauncherImpl;
        if (this._dependencyDao != null) {
            return this._dependencyDao;
        }
        synchronized (this) {
            try {
                if (this._dependencyDao == null) {
                    this._dependencyDao = new WorkLauncherImpl(this);
                }
                workLauncherImpl = this._dependencyDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return workLauncherImpl;
    }

    @Override // androidx.room.RoomDatabase
    public final List getAutoMigrations() {
        int i = 13;
        int i2 = 14;
        int i3 = 17;
        int i4 = 18;
        return Arrays.asList(new Migration_1_2(i, i2, 10), new Migration_1_2(11), new Migration_1_2(16, i3, 12), new Migration_1_2(i3, i4, i), new Migration_1_2(i4, 19, i2), new Migration_1_2(15));
    }

    @Override // androidx.room.RoomDatabase
    public final Set getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    public final Map getRequiredTypeConverters() {
        HashMap map = new HashMap();
        List list = Collections.EMPTY_LIST;
        map.put(WorkSpecDao_Impl.class, list);
        map.put(WorkLauncherImpl.class, list);
        map.put(ImageLoader$Builder.class, list);
        map.put(Request.Builder.class, list);
        map.put(RequestService.class, list);
        map.put(SVG.class, list);
        map.put(RealStrongMemoryCache.class, list);
        map.put(AlertController.AnonymousClass2.class, list);
        return map;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final RealStrongMemoryCache preferenceDao() {
        RealStrongMemoryCache realStrongMemoryCache;
        if (this._preferenceDao != null) {
            return this._preferenceDao;
        }
        synchronized (this) {
            try {
                if (this._preferenceDao == null) {
                    this._preferenceDao = new RealStrongMemoryCache(this);
                }
                realStrongMemoryCache = this._preferenceDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return realStrongMemoryCache;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final Request.Builder systemIdInfoDao() {
        Request.Builder builder;
        if (this._systemIdInfoDao != null) {
            return this._systemIdInfoDao;
        }
        synchronized (this) {
            try {
                if (this._systemIdInfoDao == null) {
                    Request.Builder builder2 = new Request.Builder();
                    builder2.url = this;
                    builder2.method = new WorkTagDao_Impl$1(this, 3);
                    builder2.headers = new WorkTagDao_Impl$2(this, 1);
                    builder2.tags = new WorkTagDao_Impl$2(this, 2);
                    this._systemIdInfoDao = builder2;
                }
                builder = this._systemIdInfoDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return builder;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final RequestService workNameDao() {
        RequestService requestService;
        if (this._workNameDao != null) {
            return this._workNameDao;
        }
        synchronized (this) {
            try {
                if (this._workNameDao == null) {
                    this._workNameDao = new RequestService(this);
                }
                requestService = this._workNameDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return requestService;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final SVG workProgressDao() {
        SVG svg;
        if (this._workProgressDao != null) {
            return this._workProgressDao;
        }
        synchronized (this) {
            try {
                if (this._workProgressDao == null) {
                    this._workProgressDao = new SVG(this);
                }
                svg = this._workProgressDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return svg;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final WorkSpecDao_Impl workSpecDao() {
        WorkSpecDao_Impl workSpecDao_Impl;
        if (this._workSpecDao != null) {
            return this._workSpecDao;
        }
        synchronized (this) {
            try {
                if (this._workSpecDao == null) {
                    this._workSpecDao = new WorkSpecDao_Impl(this);
                }
                workSpecDao_Impl = this._workSpecDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return workSpecDao_Impl;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final ImageLoader$Builder workTagDao() {
        ImageLoader$Builder imageLoader$Builder;
        if (this._workTagDao != null) {
            return this._workTagDao;
        }
        synchronized (this) {
            try {
                if (this._workTagDao == null) {
                    this._workTagDao = new ImageLoader$Builder(this);
                }
                imageLoader$Builder = this._workTagDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return imageLoader$Builder;
    }
}
