package androidx.work.impl.model;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import androidx.work.Constraints;
import androidx.work.Data;
import coil.network.HttpException;
import com.github.kr328.clash.service.data.Database_Impl;
import com.github.kr328.clash.service.data.Imported;
import com.github.kr328.clash.service.data.Selection;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class WorkTagDao_Impl$1 extends EntityInsertionAdapter {
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WorkTagDao_Impl$1(RoomDatabase roomDatabase, int i) {
        super(roomDatabase);
        this.$r8$classId = i;
    }

    @Override // androidx.room.EntityInsertionAdapter
    public final void bind(FrameworkSQLiteStatement frameworkSQLiteStatement, Object obj) throws Throwable {
        int i;
        switch (this.$r8$classId) {
            case 0:
                WorkTag workTag = (WorkTag) obj;
                String str = workTag.tag;
                if (str == null) {
                    frameworkSQLiteStatement.bindNull(1);
                } else {
                    frameworkSQLiteStatement.bindString(str, 1);
                }
                String str2 = workTag.workSpecId;
                if (str2 == null) {
                    frameworkSQLiteStatement.bindNull(2);
                    return;
                } else {
                    frameworkSQLiteStatement.bindString(str2, 2);
                    return;
                }
            case 1:
                Dependency dependency = (Dependency) obj;
                String str3 = dependency.workSpecId;
                if (str3 == null) {
                    frameworkSQLiteStatement.bindNull(1);
                } else {
                    frameworkSQLiteStatement.bindString(str3, 1);
                }
                String str4 = dependency.prerequisiteId;
                if (str4 == null) {
                    frameworkSQLiteStatement.bindNull(2);
                    return;
                } else {
                    frameworkSQLiteStatement.bindString(str4, 2);
                    return;
                }
            case 2:
                Preference preference = (Preference) obj;
                frameworkSQLiteStatement.bindString(preference.key, 1);
                frameworkSQLiteStatement.bindLong(2, preference.value.longValue());
                return;
            case 3:
                SystemIdInfo systemIdInfo = (SystemIdInfo) obj;
                String str5 = systemIdInfo.workSpecId;
                if (str5 == null) {
                    frameworkSQLiteStatement.bindNull(1);
                } else {
                    frameworkSQLiteStatement.bindString(str5, 1);
                }
                frameworkSQLiteStatement.bindLong(2, systemIdInfo.generation);
                frameworkSQLiteStatement.bindLong(3, systemIdInfo.systemId);
                return;
            case 4:
                WorkName workName = (WorkName) obj;
                String str6 = workName.name;
                if (str6 == null) {
                    frameworkSQLiteStatement.bindNull(1);
                } else {
                    frameworkSQLiteStatement.bindString(str6, 1);
                }
                String str7 = workName.workSpecId;
                if (str7 == null) {
                    frameworkSQLiteStatement.bindNull(2);
                    return;
                } else {
                    frameworkSQLiteStatement.bindString(str7, 2);
                    return;
                }
            case 5:
                throw new ClassCastException();
            case 6:
                WorkSpec workSpec = (WorkSpec) obj;
                String str8 = workSpec.id;
                int i2 = 1;
                if (str8 == null) {
                    frameworkSQLiteStatement.bindNull(1);
                } else {
                    frameworkSQLiteStatement.bindString(str8, 1);
                }
                frameworkSQLiteStatement.bindLong(2, WorkTypeConverters.stateToInt(workSpec.state));
                String str9 = workSpec.workerClassName;
                if (str9 == null) {
                    frameworkSQLiteStatement.bindNull(3);
                } else {
                    frameworkSQLiteStatement.bindString(str9, 3);
                }
                String str10 = workSpec.inputMergerClassName;
                if (str10 == null) {
                    frameworkSQLiteStatement.bindNull(4);
                } else {
                    frameworkSQLiteStatement.bindString(str10, 4);
                }
                byte[] byteArrayInternal = Data.toByteArrayInternal(workSpec.input);
                if (byteArrayInternal == null) {
                    frameworkSQLiteStatement.bindNull(5);
                } else {
                    frameworkSQLiteStatement.bindBlob(5, byteArrayInternal);
                }
                byte[] byteArrayInternal2 = Data.toByteArrayInternal(workSpec.output);
                if (byteArrayInternal2 == null) {
                    frameworkSQLiteStatement.bindNull(6);
                } else {
                    frameworkSQLiteStatement.bindBlob(6, byteArrayInternal2);
                }
                frameworkSQLiteStatement.bindLong(7, workSpec.initialDelay);
                frameworkSQLiteStatement.bindLong(8, workSpec.intervalDuration);
                frameworkSQLiteStatement.bindLong(9, workSpec.flexDuration);
                frameworkSQLiteStatement.bindLong(10, workSpec.runAttemptCount);
                int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(workSpec.backoffPolicy);
                if (iOrdinal == 0) {
                    i = 0;
                } else {
                    if (iOrdinal != 1) {
                        throw new HttpException();
                    }
                    i = 1;
                }
                frameworkSQLiteStatement.bindLong(11, i);
                frameworkSQLiteStatement.bindLong(12, workSpec.backoffDelayDuration);
                frameworkSQLiteStatement.bindLong(13, workSpec.lastEnqueueTime);
                frameworkSQLiteStatement.bindLong(14, workSpec.minimumRetentionDuration);
                frameworkSQLiteStatement.bindLong(15, workSpec.scheduleRequestedAt);
                frameworkSQLiteStatement.bindLong(16, workSpec.expedited ? 1L : 0L);
                int iOrdinal2 = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(workSpec.outOfQuotaPolicy);
                if (iOrdinal2 == 0) {
                    i2 = 0;
                } else if (iOrdinal2 != 1) {
                    throw new HttpException();
                }
                frameworkSQLiteStatement.bindLong(17, i2);
                frameworkSQLiteStatement.bindLong(18, workSpec.periodCount);
                frameworkSQLiteStatement.bindLong(19, workSpec.generation);
                frameworkSQLiteStatement.bindLong(20, workSpec.nextScheduleTimeOverride);
                frameworkSQLiteStatement.bindLong(21, workSpec.nextScheduleTimeOverrideGeneration);
                frameworkSQLiteStatement.bindLong(22, workSpec.stopReason);
                Constraints constraints = workSpec.constraints;
                if (constraints != null) {
                    frameworkSQLiteStatement.bindLong(23, WorkTypeConverters.networkTypeToInt(constraints.requiredNetworkType));
                    frameworkSQLiteStatement.bindLong(24, constraints.requiresCharging ? 1L : 0L);
                    frameworkSQLiteStatement.bindLong(25, constraints.requiresDeviceIdle ? 1L : 0L);
                    frameworkSQLiteStatement.bindLong(26, constraints.requiresBatteryNotLow ? 1L : 0L);
                    frameworkSQLiteStatement.bindLong(27, constraints.requiresStorageNotLow ? 1L : 0L);
                    frameworkSQLiteStatement.bindLong(28, constraints.contentTriggerUpdateDelayMillis);
                    frameworkSQLiteStatement.bindLong(29, constraints.contentTriggerMaxDelayMillis);
                    frameworkSQLiteStatement.bindBlob(30, WorkTypeConverters.setOfTriggersToByteArray(constraints.contentUriTriggers));
                    return;
                }
                frameworkSQLiteStatement.bindNull(23);
                frameworkSQLiteStatement.bindNull(24);
                frameworkSQLiteStatement.bindNull(25);
                frameworkSQLiteStatement.bindNull(26);
                frameworkSQLiteStatement.bindNull(27);
                frameworkSQLiteStatement.bindNull(28);
                frameworkSQLiteStatement.bindNull(29);
                frameworkSQLiteStatement.bindNull(30);
                return;
            case 7:
                Imported imported = (Imported) obj;
                frameworkSQLiteStatement.bindString(imported.uuid.toString(), 1);
                frameworkSQLiteStatement.bindString(imported.name, 2);
                frameworkSQLiteStatement.bindString(imported.type.name(), 3);
                frameworkSQLiteStatement.bindString(imported.source, 4);
                frameworkSQLiteStatement.bindLong(5, imported.interval);
                frameworkSQLiteStatement.bindLong(6, imported.upload);
                frameworkSQLiteStatement.bindLong(7, imported.download);
                frameworkSQLiteStatement.bindLong(8, imported.total);
                frameworkSQLiteStatement.bindLong(9, imported.expire);
                frameworkSQLiteStatement.bindLong(10, imported.createdAt);
                frameworkSQLiteStatement.bindLong(11, imported.updatedAt);
                String str11 = imported.announce;
                if (str11 == null) {
                    frameworkSQLiteStatement.bindNull(12);
                } else {
                    frameworkSQLiteStatement.bindString(str11, 12);
                }
                String str12 = imported.supportURL;
                if (str12 == null) {
                    frameworkSQLiteStatement.bindNull(13);
                } else {
                    frameworkSQLiteStatement.bindString(str12, 13);
                }
                byte[] bArr = imported.profileImage;
                if (bArr == null) {
                    frameworkSQLiteStatement.bindNull(14);
                } else {
                    frameworkSQLiteStatement.bindBlob(14, bArr);
                }
                frameworkSQLiteStatement.bindLong(15, imported.modeSwitchAllowed ? 1L : 0L);
                return;
            default:
                Selection selection = (Selection) obj;
                frameworkSQLiteStatement.bindString(selection.uuid.toString(), 1);
                frameworkSQLiteStatement.bindString(selection.proxy, 2);
                frameworkSQLiteStatement.bindString(selection.selected, 3);
                return;
        }
    }

    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        switch (this.$r8$classId) {
            case 0:
                return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
            case 1:
                return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
            case 2:
                return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
            case 3:
                return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`generation`,`system_id`) VALUES (?,?,?)";
            case 4:
                return "INSERT OR IGNORE INTO `WorkName` (`name`,`work_spec_id`) VALUES (?,?)";
            case 5:
                return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
            case 6:
                return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`last_enqueue_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`period_count`,`generation`,`next_schedule_time_override`,`next_schedule_time_override_generation`,`stop_reason`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            case 7:
                return "INSERT OR ABORT INTO `imported` (`uuid`,`name`,`type`,`source`,`interval`,`upload`,`download`,`total`,`expire`,`createdAt`,`updatedAt`,`announce`,`supportURL`,`profileImage`,`modeSwitchAllowed`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            default:
                return "INSERT OR REPLACE INTO `selections` (`uuid`,`proxy`,`selected`) VALUES (?,?,?)";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WorkTagDao_Impl$1(Object obj, Database_Impl database_Impl, int i) {
        super(database_Impl);
        this.$r8$classId = i;
    }
}
