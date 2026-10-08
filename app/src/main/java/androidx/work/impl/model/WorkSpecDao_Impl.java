package androidx.work.impl.model;

import android.database.Cursor;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.compose.material3.tokens.TypeScaleTokens;
import androidx.compose.material3.tokens.TypographyTokensKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.GenericFontFamily;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.impl.WorkDatabase_Impl;
import coil.network.HttpException;
import com.github.kr328.clash.service.data.Database_Impl;
import com.github.kr328.clash.service.data.Imported;
import java.util.ArrayList;
import java.util.UUID;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class WorkSpecDao_Impl {
    public final Object __db;
    public final Object __insertionAdapterOfWorkSpec;
    public final Object __preparedStmtOfDelete;
    public final Object __preparedStmtOfIncrementPeriodCount;
    public final Object __preparedStmtOfIncrementWorkSpecRunAttemptCount;
    public final Object __preparedStmtOfMarkWorkSpecScheduled;
    public final Object __preparedStmtOfResetScheduledState;
    public final Object __preparedStmtOfResetWorkSpecNextScheduleTimeOverride;
    public final Object __preparedStmtOfResetWorkSpecRunAttemptCount;
    public final Object __preparedStmtOfSetCancelledState;
    public final Object __preparedStmtOfSetLastEnqueueTime;
    public final Object __preparedStmtOfSetOutput;
    public final Object __preparedStmtOfSetState;
    public final Object __preparedStmtOfSetStopReason;
    public final Object __updateAdapterOfWorkSpec;

    /* JADX INFO: renamed from: androidx.work.impl.model.WorkSpecDao_Impl$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class AnonymousClass2 extends EntityInsertionAdapter {
        public final /* synthetic */ int $r8$classId = 0;

        public /* synthetic */ AnonymousClass2(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        public final void bind(FrameworkSQLiteStatement frameworkSQLiteStatement, Object obj) throws Throwable {
            int i;
            switch (this.$r8$classId) {
                case 0:
                    WorkSpec workSpec = (WorkSpec) obj;
                    String str = workSpec.id;
                    int i2 = 1;
                    if (str == null) {
                        frameworkSQLiteStatement.bindNull(1);
                    } else {
                        frameworkSQLiteStatement.bindString(str, 1);
                    }
                    frameworkSQLiteStatement.bindLong(2, WorkTypeConverters.stateToInt(workSpec.state));
                    String str2 = workSpec.workerClassName;
                    if (str2 == null) {
                        frameworkSQLiteStatement.bindNull(3);
                    } else {
                        frameworkSQLiteStatement.bindString(str2, 3);
                    }
                    String str3 = workSpec.inputMergerClassName;
                    if (str3 == null) {
                        frameworkSQLiteStatement.bindNull(4);
                    } else {
                        frameworkSQLiteStatement.bindString(str3, 4);
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
                    } else {
                        frameworkSQLiteStatement.bindNull(23);
                        frameworkSQLiteStatement.bindNull(24);
                        frameworkSQLiteStatement.bindNull(25);
                        frameworkSQLiteStatement.bindNull(26);
                        frameworkSQLiteStatement.bindNull(27);
                        frameworkSQLiteStatement.bindNull(28);
                        frameworkSQLiteStatement.bindNull(29);
                        frameworkSQLiteStatement.bindNull(30);
                    }
                    if (str == null) {
                        frameworkSQLiteStatement.bindNull(31);
                        return;
                    } else {
                        frameworkSQLiteStatement.bindString(str, 31);
                        return;
                    }
                default:
                    Imported imported = (Imported) obj;
                    UUID uuid = imported.uuid;
                    frameworkSQLiteStatement.bindString(uuid.toString(), 1);
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
                    String str4 = imported.announce;
                    if (str4 == null) {
                        frameworkSQLiteStatement.bindNull(12);
                    } else {
                        frameworkSQLiteStatement.bindString(str4, 12);
                    }
                    String str5 = imported.supportURL;
                    if (str5 == null) {
                        frameworkSQLiteStatement.bindNull(13);
                    } else {
                        frameworkSQLiteStatement.bindString(str5, 13);
                    }
                    byte[] bArr = imported.profileImage;
                    if (bArr == null) {
                        frameworkSQLiteStatement.bindNull(14);
                    } else {
                        frameworkSQLiteStatement.bindBlob(14, bArr);
                    }
                    frameworkSQLiteStatement.bindLong(15, imported.modeSwitchAllowed ? 1L : 0L);
                    frameworkSQLiteStatement.bindString(uuid.toString(), 16);
                    return;
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            switch (this.$r8$classId) {
                case 0:
                    return "UPDATE OR ABORT `WorkSpec` SET `id` = ?,`state` = ?,`worker_class_name` = ?,`input_merger_class_name` = ?,`input` = ?,`output` = ?,`initial_delay` = ?,`interval_duration` = ?,`flex_duration` = ?,`run_attempt_count` = ?,`backoff_policy` = ?,`backoff_delay_duration` = ?,`last_enqueue_time` = ?,`minimum_retention_duration` = ?,`schedule_requested_at` = ?,`run_in_foreground` = ?,`out_of_quota_policy` = ?,`period_count` = ?,`generation` = ?,`next_schedule_time_override` = ?,`next_schedule_time_override_generation` = ?,`stop_reason` = ?,`required_network_type` = ?,`requires_charging` = ?,`requires_device_idle` = ?,`requires_battery_not_low` = ?,`requires_storage_not_low` = ?,`trigger_content_update_delay` = ?,`trigger_max_content_delay` = ?,`content_uri_triggers` = ? WHERE `id` = ?";
                default:
                    return "UPDATE OR ABORT `imported` SET `uuid` = ?,`name` = ?,`type` = ?,`source` = ?,`interval` = ?,`upload` = ?,`download` = ?,`total` = ?,`expire` = ?,`createdAt` = ?,`updatedAt` = ?,`announce` = ?,`supportURL` = ?,`profileImage` = ?,`modeSwitchAllowed` = ? WHERE `uuid` = ?";
            }
        }

        public AnonymousClass2(Dispatcher dispatcher, Database_Impl database_Impl) {
            super(database_Impl);
        }
    }

    public WorkSpecDao_Impl() {
        TextStyle textStyle = TypographyTokensKt.DefaultTextStyle;
        GenericFontFamily genericFontFamily = TypeScaleTokens.BodyLargeFont;
        FontWeight fontWeight = TypeScaleTokens.BodyLargeWeight;
        this.__db = TextStyle.m645copyp1EtxEg$default(textStyle, 0L, TypeScaleTokens.BodyLargeSize, fontWeight, genericFontFamily, TypeScaleTokens.BodyLargeTracking, TypeScaleTokens.BodyLargeLineHeight, null, 16645977);
        GenericFontFamily genericFontFamily2 = TypeScaleTokens.BodyMediumFont;
        FontWeight fontWeight2 = TypeScaleTokens.BodyMediumWeight;
        this.__insertionAdapterOfWorkSpec = TextStyle.m645copyp1EtxEg$default(textStyle, 0L, TypeScaleTokens.BodyMediumSize, fontWeight2, genericFontFamily2, TypeScaleTokens.BodyMediumTracking, TypeScaleTokens.BodyMediumLineHeight, null, 16645977);
        GenericFontFamily genericFontFamily3 = TypeScaleTokens.BodySmallFont;
        FontWeight fontWeight3 = TypeScaleTokens.BodySmallWeight;
        this.__updateAdapterOfWorkSpec = TextStyle.m645copyp1EtxEg$default(textStyle, 0L, TypeScaleTokens.BodySmallSize, fontWeight3, genericFontFamily3, TypeScaleTokens.BodySmallTracking, TypeScaleTokens.BodySmallLineHeight, null, 16645977);
        GenericFontFamily genericFontFamily4 = TypeScaleTokens.DisplayLargeFont;
        FontWeight fontWeight4 = TypeScaleTokens.DisplayLargeWeight;
        this.__preparedStmtOfDelete = TextStyle.m645copyp1EtxEg$default(textStyle, 0L, TypeScaleTokens.DisplayLargeSize, fontWeight4, genericFontFamily4, TypeScaleTokens.DisplayLargeTracking, TypeScaleTokens.DisplayLargeLineHeight, null, 16645977);
        GenericFontFamily genericFontFamily5 = TypeScaleTokens.DisplayMediumFont;
        FontWeight fontWeight5 = TypeScaleTokens.DisplayMediumWeight;
        this.__preparedStmtOfSetState = TextStyle.m645copyp1EtxEg$default(textStyle, 0L, TypeScaleTokens.DisplayMediumSize, fontWeight5, genericFontFamily5, TypeScaleTokens.DisplayMediumTracking, TypeScaleTokens.DisplayMediumLineHeight, null, 16645977);
        GenericFontFamily genericFontFamily6 = TypeScaleTokens.DisplaySmallFont;
        FontWeight fontWeight6 = TypeScaleTokens.DisplaySmallWeight;
        this.__preparedStmtOfSetCancelledState = TextStyle.m645copyp1EtxEg$default(textStyle, 0L, TypeScaleTokens.DisplaySmallSize, fontWeight6, genericFontFamily6, TypeScaleTokens.DisplaySmallTracking, TypeScaleTokens.DisplaySmallLineHeight, null, 16645977);
        GenericFontFamily genericFontFamily7 = TypeScaleTokens.HeadlineLargeFont;
        FontWeight fontWeight7 = TypeScaleTokens.HeadlineLargeWeight;
        this.__preparedStmtOfIncrementPeriodCount = TextStyle.m645copyp1EtxEg$default(textStyle, 0L, TypeScaleTokens.HeadlineLargeSize, fontWeight7, genericFontFamily7, TypeScaleTokens.HeadlineLargeTracking, TypeScaleTokens.HeadlineLargeLineHeight, null, 16645977);
        GenericFontFamily genericFontFamily8 = TypeScaleTokens.HeadlineMediumFont;
        FontWeight fontWeight8 = TypeScaleTokens.HeadlineMediumWeight;
        this.__preparedStmtOfSetOutput = TextStyle.m645copyp1EtxEg$default(textStyle, 0L, TypeScaleTokens.HeadlineMediumSize, fontWeight8, genericFontFamily8, TypeScaleTokens.HeadlineMediumTracking, TypeScaleTokens.HeadlineMediumLineHeight, null, 16645977);
        GenericFontFamily genericFontFamily9 = TypeScaleTokens.HeadlineSmallFont;
        FontWeight fontWeight9 = TypeScaleTokens.HeadlineSmallWeight;
        this.__preparedStmtOfSetLastEnqueueTime = TextStyle.m645copyp1EtxEg$default(textStyle, 0L, TypeScaleTokens.HeadlineSmallSize, fontWeight9, genericFontFamily9, TypeScaleTokens.HeadlineSmallTracking, TypeScaleTokens.HeadlineSmallLineHeight, null, 16645977);
        GenericFontFamily genericFontFamily10 = TypeScaleTokens.LabelLargeFont;
        FontWeight fontWeight10 = TypeScaleTokens.LabelLargeWeight;
        this.__preparedStmtOfIncrementWorkSpecRunAttemptCount = TextStyle.m645copyp1EtxEg$default(textStyle, 0L, TypeScaleTokens.LabelLargeSize, fontWeight10, genericFontFamily10, TypeScaleTokens.LabelLargeTracking, TypeScaleTokens.LabelLargeLineHeight, null, 16645977);
        GenericFontFamily genericFontFamily11 = TypeScaleTokens.LabelMediumFont;
        FontWeight fontWeight11 = TypeScaleTokens.LabelMediumWeight;
        this.__preparedStmtOfResetWorkSpecRunAttemptCount = TextStyle.m645copyp1EtxEg$default(textStyle, 0L, TypeScaleTokens.LabelMediumSize, fontWeight11, genericFontFamily11, TypeScaleTokens.LabelMediumTracking, TypeScaleTokens.LabelMediumLineHeight, null, 16645977);
        GenericFontFamily genericFontFamily12 = TypeScaleTokens.LabelSmallFont;
        FontWeight fontWeight12 = TypeScaleTokens.LabelSmallWeight;
        this.__preparedStmtOfResetWorkSpecNextScheduleTimeOverride = TextStyle.m645copyp1EtxEg$default(textStyle, 0L, TypeScaleTokens.LabelSmallSize, fontWeight12, genericFontFamily12, TypeScaleTokens.LabelSmallTracking, TypeScaleTokens.LabelSmallLineHeight, null, 16645977);
        GenericFontFamily genericFontFamily13 = TypeScaleTokens.TitleLargeFont;
        FontWeight fontWeight13 = TypeScaleTokens.TitleLargeWeight;
        this.__preparedStmtOfMarkWorkSpecScheduled = TextStyle.m645copyp1EtxEg$default(textStyle, 0L, TypeScaleTokens.TitleLargeSize, fontWeight13, genericFontFamily13, TypeScaleTokens.TitleLargeTracking, TypeScaleTokens.TitleLargeLineHeight, null, 16645977);
        GenericFontFamily genericFontFamily14 = TypeScaleTokens.TitleMediumFont;
        FontWeight fontWeight14 = TypeScaleTokens.TitleMediumWeight;
        this.__preparedStmtOfResetScheduledState = TextStyle.m645copyp1EtxEg$default(textStyle, 0L, TypeScaleTokens.TitleMediumSize, fontWeight14, genericFontFamily14, TypeScaleTokens.TitleMediumTracking, TypeScaleTokens.TitleMediumLineHeight, null, 16645977);
        GenericFontFamily genericFontFamily15 = TypeScaleTokens.TitleSmallFont;
        FontWeight fontWeight15 = TypeScaleTokens.TitleSmallWeight;
        this.__preparedStmtOfSetStopReason = TextStyle.m645copyp1EtxEg$default(textStyle, 0L, TypeScaleTokens.TitleSmallSize, fontWeight15, genericFontFamily15, TypeScaleTokens.TitleSmallTracking, TypeScaleTokens.TitleSmallLineHeight, null, 16645977);
        GenericFontFamily genericFontFamily16 = TypeScaleTokens.BodyLargeEmphasizedFont;
        FontWeight fontWeight16 = TypeScaleTokens.BodyLargeEmphasizedWeight;
        TextStyle.m645copyp1EtxEg$default(textStyle, 0L, TypeScaleTokens.BodyLargeEmphasizedSize, fontWeight16, genericFontFamily16, TypeScaleTokens.BodyLargeEmphasizedTracking, TypeScaleTokens.BodyLargeEmphasizedLineHeight, null, 16645977);
        GenericFontFamily genericFontFamily17 = TypeScaleTokens.BodyMediumEmphasizedFont;
        FontWeight fontWeight17 = TypeScaleTokens.BodyMediumEmphasizedWeight;
        TextStyle.m645copyp1EtxEg$default(textStyle, 0L, TypeScaleTokens.BodyMediumEmphasizedSize, fontWeight17, genericFontFamily17, TypeScaleTokens.BodyMediumEmphasizedTracking, TypeScaleTokens.BodyMediumEmphasizedLineHeight, null, 16645977);
        GenericFontFamily genericFontFamily18 = TypeScaleTokens.BodySmallEmphasizedFont;
        FontWeight fontWeight18 = TypeScaleTokens.BodySmallEmphasizedWeight;
        TextStyle.m645copyp1EtxEg$default(textStyle, 0L, TypeScaleTokens.BodySmallEmphasizedSize, fontWeight18, genericFontFamily18, TypeScaleTokens.BodySmallEmphasizedTracking, TypeScaleTokens.BodySmallEmphasizedLineHeight, null, 16645977);
        GenericFontFamily genericFontFamily19 = TypeScaleTokens.DisplayLargeEmphasizedFont;
        FontWeight fontWeight19 = TypeScaleTokens.DisplayLargeEmphasizedWeight;
        TextStyle.m645copyp1EtxEg$default(textStyle, 0L, TypeScaleTokens.DisplayLargeEmphasizedSize, fontWeight19, genericFontFamily19, TypeScaleTokens.DisplayLargeEmphasizedTracking, TypeScaleTokens.DisplayLargeEmphasizedLineHeight, null, 16645977);
        GenericFontFamily genericFontFamily20 = TypeScaleTokens.DisplayMediumEmphasizedFont;
        FontWeight fontWeight20 = TypeScaleTokens.DisplayMediumEmphasizedWeight;
        TextStyle.m645copyp1EtxEg$default(textStyle, 0L, TypeScaleTokens.DisplayMediumEmphasizedSize, fontWeight20, genericFontFamily20, TypeScaleTokens.DisplayMediumEmphasizedTracking, TypeScaleTokens.DisplayMediumEmphasizedLineHeight, null, 16645977);
        GenericFontFamily genericFontFamily21 = TypeScaleTokens.DisplaySmallEmphasizedFont;
        FontWeight fontWeight21 = TypeScaleTokens.DisplaySmallEmphasizedWeight;
        TextStyle.m645copyp1EtxEg$default(textStyle, 0L, TypeScaleTokens.DisplaySmallEmphasizedSize, fontWeight21, genericFontFamily21, TypeScaleTokens.DisplaySmallEmphasizedTracking, TypeScaleTokens.DisplaySmallEmphasizedLineHeight, null, 16645977);
        GenericFontFamily genericFontFamily22 = TypeScaleTokens.HeadlineLargeEmphasizedFont;
        FontWeight fontWeight22 = TypeScaleTokens.HeadlineLargeEmphasizedWeight;
        TextStyle.m645copyp1EtxEg$default(textStyle, 0L, TypeScaleTokens.HeadlineLargeEmphasizedSize, fontWeight22, genericFontFamily22, TypeScaleTokens.HeadlineLargeEmphasizedTracking, TypeScaleTokens.HeadlineLargeEmphasizedLineHeight, null, 16645977);
        GenericFontFamily genericFontFamily23 = TypeScaleTokens.HeadlineMediumEmphasizedFont;
        FontWeight fontWeight23 = TypeScaleTokens.HeadlineMediumEmphasizedWeight;
        TextStyle.m645copyp1EtxEg$default(textStyle, 0L, TypeScaleTokens.HeadlineMediumEmphasizedSize, fontWeight23, genericFontFamily23, TypeScaleTokens.HeadlineMediumEmphasizedTracking, TypeScaleTokens.HeadlineMediumEmphasizedLineHeight, null, 16645977);
        GenericFontFamily genericFontFamily24 = TypeScaleTokens.HeadlineSmallEmphasizedFont;
        FontWeight fontWeight24 = TypeScaleTokens.HeadlineSmallEmphasizedWeight;
        TextStyle.m645copyp1EtxEg$default(textStyle, 0L, TypeScaleTokens.HeadlineSmallEmphasizedSize, fontWeight24, genericFontFamily24, TypeScaleTokens.HeadlineSmallEmphasizedTracking, TypeScaleTokens.HeadlineSmallEmphasizedLineHeight, null, 16645977);
        GenericFontFamily genericFontFamily25 = TypeScaleTokens.LabelLargeEmphasizedFont;
        FontWeight fontWeight25 = TypeScaleTokens.LabelLargeEmphasizedWeight;
        TextStyle.m645copyp1EtxEg$default(textStyle, 0L, TypeScaleTokens.LabelLargeEmphasizedSize, fontWeight25, genericFontFamily25, TypeScaleTokens.LabelLargeEmphasizedTracking, TypeScaleTokens.LabelLargeEmphasizedLineHeight, null, 16645977);
        GenericFontFamily genericFontFamily26 = TypeScaleTokens.LabelMediumEmphasizedFont;
        FontWeight fontWeight26 = TypeScaleTokens.LabelMediumEmphasizedWeight;
        TextStyle.m645copyp1EtxEg$default(textStyle, 0L, TypeScaleTokens.LabelMediumEmphasizedSize, fontWeight26, genericFontFamily26, TypeScaleTokens.LabelMediumEmphasizedTracking, TypeScaleTokens.LabelMediumEmphasizedLineHeight, null, 16645977);
        GenericFontFamily genericFontFamily27 = TypeScaleTokens.LabelSmallEmphasizedFont;
        FontWeight fontWeight27 = TypeScaleTokens.LabelSmallEmphasizedWeight;
        TextStyle.m645copyp1EtxEg$default(textStyle, 0L, TypeScaleTokens.LabelSmallEmphasizedSize, fontWeight27, genericFontFamily27, TypeScaleTokens.LabelSmallEmphasizedTracking, TypeScaleTokens.LabelSmallEmphasizedLineHeight, null, 16645977);
        GenericFontFamily genericFontFamily28 = TypeScaleTokens.TitleLargeEmphasizedFont;
        FontWeight fontWeight28 = TypeScaleTokens.TitleLargeEmphasizedWeight;
        TextStyle.m645copyp1EtxEg$default(textStyle, 0L, TypeScaleTokens.TitleLargeEmphasizedSize, fontWeight28, genericFontFamily28, TypeScaleTokens.TitleLargeEmphasizedTracking, TypeScaleTokens.TitleLargeEmphasizedLineHeight, null, 16645977);
        GenericFontFamily genericFontFamily29 = TypeScaleTokens.TitleMediumEmphasizedFont;
        FontWeight fontWeight29 = TypeScaleTokens.TitleMediumEmphasizedWeight;
        TextStyle.m645copyp1EtxEg$default(textStyle, 0L, TypeScaleTokens.TitleMediumEmphasizedSize, fontWeight29, genericFontFamily29, TypeScaleTokens.TitleMediumEmphasizedTracking, TypeScaleTokens.TitleMediumEmphasizedLineHeight, null, 16645977);
        GenericFontFamily genericFontFamily30 = TypeScaleTokens.TitleSmallEmphasizedFont;
        FontWeight fontWeight30 = TypeScaleTokens.TitleSmallEmphasizedWeight;
        TextStyle.m645copyp1EtxEg$default(textStyle, 0L, TypeScaleTokens.TitleSmallEmphasizedSize, fontWeight30, genericFontFamily30, TypeScaleTokens.TitleSmallEmphasizedTracking, TypeScaleTokens.TitleSmallEmphasizedLineHeight, null, 16645977);
    }

    public void delete(String str) {
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.__db;
        workDatabase_Impl.assertNotSuspendingTransaction();
        WorkTagDao_Impl$2 workTagDao_Impl$2 = (WorkTagDao_Impl$2) this.__preparedStmtOfDelete;
        FrameworkSQLiteStatement frameworkSQLiteStatementAcquire = workTagDao_Impl$2.acquire();
        if (str == null) {
            frameworkSQLiteStatementAcquire.bindNull(1);
        } else {
            frameworkSQLiteStatementAcquire.bindString(str, 1);
        }
        workDatabase_Impl.beginTransaction();
        try {
            frameworkSQLiteStatementAcquire.executeUpdateDelete();
            workDatabase_Impl.setTransactionSuccessful();
        } finally {
            workDatabase_Impl.internalEndTransaction();
            workTagDao_Impl$2.release(frameworkSQLiteStatementAcquire);
        }
    }

    public ArrayList getAllEligibleWorkSpecsForScheduling() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=0 ORDER BY last_enqueue_time LIMIT ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, 200);
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.__db;
        workDatabase_Impl.assertNotSuspendingTransaction();
        Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "state");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "worker_class_name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "input_merger_class_name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "input");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "output");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "initial_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "interval_duration");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flex_duration");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_attempt_count");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backoff_policy");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backoff_delay_duration");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_enqueue_time");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "minimum_retention_duration");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "schedule_requested_at");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_in_foreground");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "out_of_quota_policy");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "period_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "generation");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "next_schedule_time_override");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "next_schedule_time_override_generation");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "stop_reason");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "required_network_type");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_charging");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_device_idle");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_battery_not_low");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_storage_not_low");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trigger_content_update_delay");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trigger_max_content_delay");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "content_uri_triggers");
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    byte[] blob = null;
                    String string = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                    int iIntToState = WorkTypeConverters.intToState(cursorQuery.getInt(columnIndexOrThrow2));
                    String string2 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                    String string3 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                    Data dataFromByteArray = Data.fromByteArray(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getBlob(columnIndexOrThrow5));
                    Data dataFromByteArray2 = Data.fromByteArray(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getBlob(columnIndexOrThrow6));
                    long j = cursorQuery.getLong(columnIndexOrThrow7);
                    long j2 = cursorQuery.getLong(columnIndexOrThrow8);
                    long j3 = cursorQuery.getLong(columnIndexOrThrow9);
                    int i2 = cursorQuery.getInt(columnIndexOrThrow10);
                    int iIntToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(cursorQuery.getInt(columnIndexOrThrow11));
                    long j4 = cursorQuery.getLong(columnIndexOrThrow12);
                    long j5 = cursorQuery.getLong(columnIndexOrThrow13);
                    int i3 = i;
                    long j6 = cursorQuery.getLong(i3);
                    int i4 = columnIndexOrThrow;
                    int i5 = columnIndexOrThrow15;
                    long j7 = cursorQuery.getLong(i5);
                    columnIndexOrThrow15 = i5;
                    int i6 = columnIndexOrThrow16;
                    boolean z = cursorQuery.getInt(i6) != 0;
                    columnIndexOrThrow16 = i6;
                    int i7 = columnIndexOrThrow17;
                    int iIntToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(cursorQuery.getInt(i7));
                    columnIndexOrThrow17 = i7;
                    int i8 = columnIndexOrThrow18;
                    int i9 = cursorQuery.getInt(i8);
                    columnIndexOrThrow18 = i8;
                    int i10 = columnIndexOrThrow19;
                    int i11 = cursorQuery.getInt(i10);
                    columnIndexOrThrow19 = i10;
                    int i12 = columnIndexOrThrow20;
                    long j8 = cursorQuery.getLong(i12);
                    columnIndexOrThrow20 = i12;
                    int i13 = columnIndexOrThrow21;
                    int i14 = cursorQuery.getInt(i13);
                    columnIndexOrThrow21 = i13;
                    int i15 = columnIndexOrThrow22;
                    int i16 = cursorQuery.getInt(i15);
                    columnIndexOrThrow22 = i15;
                    int i17 = columnIndexOrThrow23;
                    int iIntToNetworkType = WorkTypeConverters.intToNetworkType(cursorQuery.getInt(i17));
                    columnIndexOrThrow23 = i17;
                    int i18 = columnIndexOrThrow24;
                    boolean z2 = cursorQuery.getInt(i18) != 0;
                    columnIndexOrThrow24 = i18;
                    int i19 = columnIndexOrThrow25;
                    boolean z3 = cursorQuery.getInt(i19) != 0;
                    columnIndexOrThrow25 = i19;
                    int i20 = columnIndexOrThrow26;
                    boolean z4 = cursorQuery.getInt(i20) != 0;
                    columnIndexOrThrow26 = i20;
                    int i21 = columnIndexOrThrow27;
                    boolean z5 = cursorQuery.getInt(i21) != 0;
                    columnIndexOrThrow27 = i21;
                    int i22 = columnIndexOrThrow28;
                    long j9 = cursorQuery.getLong(i22);
                    columnIndexOrThrow28 = i22;
                    int i23 = columnIndexOrThrow29;
                    long j10 = cursorQuery.getLong(i23);
                    columnIndexOrThrow29 = i23;
                    int i24 = columnIndexOrThrow30;
                    if (!cursorQuery.isNull(i24)) {
                        blob = cursorQuery.getBlob(i24);
                    }
                    columnIndexOrThrow30 = i24;
                    arrayList.add(new WorkSpec(string, iIntToState, string2, string3, dataFromByteArray, dataFromByteArray2, j, j2, j3, new Constraints(iIntToNetworkType, z2, z3, z4, z5, j9, j10, WorkTypeConverters.byteArrayToSetOfTriggers(blob)), i2, iIntToBackoffPolicy, j4, j5, j6, j7, z, iIntToOutOfQuotaPolicy, i9, i11, j8, i14, i16));
                    columnIndexOrThrow = i4;
                    i = i3;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    public ArrayList getEligibleWorkForScheduling(int i) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY last_enqueue_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND LENGTH(content_uri_triggers)=0 AND state NOT IN (2, 3, 5))", 1);
        roomSQLiteQueryAcquire.bindLong(1, i);
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.__db;
        workDatabase_Impl.assertNotSuspendingTransaction();
        Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "state");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "worker_class_name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "input_merger_class_name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "input");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "output");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "initial_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "interval_duration");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flex_duration");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_attempt_count");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backoff_policy");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backoff_delay_duration");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_enqueue_time");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "minimum_retention_duration");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "schedule_requested_at");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_in_foreground");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "out_of_quota_policy");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "period_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "generation");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "next_schedule_time_override");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "next_schedule_time_override_generation");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "stop_reason");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "required_network_type");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_charging");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_device_idle");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_battery_not_low");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_storage_not_low");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trigger_content_update_delay");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trigger_max_content_delay");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "content_uri_triggers");
                int i2 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    byte[] blob = null;
                    String string = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                    int iIntToState = WorkTypeConverters.intToState(cursorQuery.getInt(columnIndexOrThrow2));
                    String string2 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                    String string3 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                    Data dataFromByteArray = Data.fromByteArray(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getBlob(columnIndexOrThrow5));
                    Data dataFromByteArray2 = Data.fromByteArray(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getBlob(columnIndexOrThrow6));
                    long j = cursorQuery.getLong(columnIndexOrThrow7);
                    long j2 = cursorQuery.getLong(columnIndexOrThrow8);
                    long j3 = cursorQuery.getLong(columnIndexOrThrow9);
                    int i3 = cursorQuery.getInt(columnIndexOrThrow10);
                    int iIntToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(cursorQuery.getInt(columnIndexOrThrow11));
                    long j4 = cursorQuery.getLong(columnIndexOrThrow12);
                    long j5 = cursorQuery.getLong(columnIndexOrThrow13);
                    int i4 = i2;
                    long j6 = cursorQuery.getLong(i4);
                    int i5 = columnIndexOrThrow;
                    int i6 = columnIndexOrThrow15;
                    long j7 = cursorQuery.getLong(i6);
                    columnIndexOrThrow15 = i6;
                    int i7 = columnIndexOrThrow16;
                    boolean z = cursorQuery.getInt(i7) != 0;
                    columnIndexOrThrow16 = i7;
                    int i8 = columnIndexOrThrow17;
                    int iIntToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(cursorQuery.getInt(i8));
                    columnIndexOrThrow17 = i8;
                    int i9 = columnIndexOrThrow18;
                    int i10 = cursorQuery.getInt(i9);
                    columnIndexOrThrow18 = i9;
                    int i11 = columnIndexOrThrow19;
                    int i12 = cursorQuery.getInt(i11);
                    columnIndexOrThrow19 = i11;
                    int i13 = columnIndexOrThrow20;
                    long j8 = cursorQuery.getLong(i13);
                    columnIndexOrThrow20 = i13;
                    int i14 = columnIndexOrThrow21;
                    int i15 = cursorQuery.getInt(i14);
                    columnIndexOrThrow21 = i14;
                    int i16 = columnIndexOrThrow22;
                    int i17 = cursorQuery.getInt(i16);
                    columnIndexOrThrow22 = i16;
                    int i18 = columnIndexOrThrow23;
                    int iIntToNetworkType = WorkTypeConverters.intToNetworkType(cursorQuery.getInt(i18));
                    columnIndexOrThrow23 = i18;
                    int i19 = columnIndexOrThrow24;
                    boolean z2 = cursorQuery.getInt(i19) != 0;
                    columnIndexOrThrow24 = i19;
                    int i20 = columnIndexOrThrow25;
                    boolean z3 = cursorQuery.getInt(i20) != 0;
                    columnIndexOrThrow25 = i20;
                    int i21 = columnIndexOrThrow26;
                    boolean z4 = cursorQuery.getInt(i21) != 0;
                    columnIndexOrThrow26 = i21;
                    int i22 = columnIndexOrThrow27;
                    boolean z5 = cursorQuery.getInt(i22) != 0;
                    columnIndexOrThrow27 = i22;
                    int i23 = columnIndexOrThrow28;
                    long j9 = cursorQuery.getLong(i23);
                    columnIndexOrThrow28 = i23;
                    int i24 = columnIndexOrThrow29;
                    long j10 = cursorQuery.getLong(i24);
                    columnIndexOrThrow29 = i24;
                    int i25 = columnIndexOrThrow30;
                    if (!cursorQuery.isNull(i25)) {
                        blob = cursorQuery.getBlob(i25);
                    }
                    columnIndexOrThrow30 = i25;
                    arrayList.add(new WorkSpec(string, iIntToState, string2, string3, dataFromByteArray, dataFromByteArray2, j, j2, j3, new Constraints(iIntToNetworkType, z2, z3, z4, z5, j9, j10, WorkTypeConverters.byteArrayToSetOfTriggers(blob)), i3, iIntToBackoffPolicy, j4, j5, j6, j7, z, iIntToOutOfQuotaPolicy, i10, i12, j8, i15, i17));
                    columnIndexOrThrow = i5;
                    i2 = i4;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    public ArrayList getEligibleWorkForSchedulingWithContentUris() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 AND LENGTH(content_uri_triggers)<>0 ORDER BY last_enqueue_time", 0);
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.__db;
        workDatabase_Impl.assertNotSuspendingTransaction();
        Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "state");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "worker_class_name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "input_merger_class_name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "input");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "output");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "initial_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "interval_duration");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flex_duration");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_attempt_count");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backoff_policy");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backoff_delay_duration");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_enqueue_time");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "minimum_retention_duration");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "schedule_requested_at");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_in_foreground");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "out_of_quota_policy");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "period_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "generation");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "next_schedule_time_override");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "next_schedule_time_override_generation");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "stop_reason");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "required_network_type");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_charging");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_device_idle");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_battery_not_low");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_storage_not_low");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trigger_content_update_delay");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trigger_max_content_delay");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "content_uri_triggers");
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    byte[] blob = null;
                    String string = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                    int iIntToState = WorkTypeConverters.intToState(cursorQuery.getInt(columnIndexOrThrow2));
                    String string2 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                    String string3 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                    Data dataFromByteArray = Data.fromByteArray(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getBlob(columnIndexOrThrow5));
                    Data dataFromByteArray2 = Data.fromByteArray(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getBlob(columnIndexOrThrow6));
                    long j = cursorQuery.getLong(columnIndexOrThrow7);
                    long j2 = cursorQuery.getLong(columnIndexOrThrow8);
                    long j3 = cursorQuery.getLong(columnIndexOrThrow9);
                    int i2 = cursorQuery.getInt(columnIndexOrThrow10);
                    int iIntToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(cursorQuery.getInt(columnIndexOrThrow11));
                    long j4 = cursorQuery.getLong(columnIndexOrThrow12);
                    long j5 = cursorQuery.getLong(columnIndexOrThrow13);
                    int i3 = i;
                    long j6 = cursorQuery.getLong(i3);
                    int i4 = columnIndexOrThrow;
                    int i5 = columnIndexOrThrow15;
                    long j7 = cursorQuery.getLong(i5);
                    columnIndexOrThrow15 = i5;
                    int i6 = columnIndexOrThrow16;
                    boolean z = cursorQuery.getInt(i6) != 0;
                    columnIndexOrThrow16 = i6;
                    int i7 = columnIndexOrThrow17;
                    int iIntToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(cursorQuery.getInt(i7));
                    columnIndexOrThrow17 = i7;
                    int i8 = columnIndexOrThrow18;
                    int i9 = cursorQuery.getInt(i8);
                    columnIndexOrThrow18 = i8;
                    int i10 = columnIndexOrThrow19;
                    int i11 = cursorQuery.getInt(i10);
                    columnIndexOrThrow19 = i10;
                    int i12 = columnIndexOrThrow20;
                    long j8 = cursorQuery.getLong(i12);
                    columnIndexOrThrow20 = i12;
                    int i13 = columnIndexOrThrow21;
                    int i14 = cursorQuery.getInt(i13);
                    columnIndexOrThrow21 = i13;
                    int i15 = columnIndexOrThrow22;
                    int i16 = cursorQuery.getInt(i15);
                    columnIndexOrThrow22 = i15;
                    int i17 = columnIndexOrThrow23;
                    int iIntToNetworkType = WorkTypeConverters.intToNetworkType(cursorQuery.getInt(i17));
                    columnIndexOrThrow23 = i17;
                    int i18 = columnIndexOrThrow24;
                    boolean z2 = cursorQuery.getInt(i18) != 0;
                    columnIndexOrThrow24 = i18;
                    int i19 = columnIndexOrThrow25;
                    boolean z3 = cursorQuery.getInt(i19) != 0;
                    columnIndexOrThrow25 = i19;
                    int i20 = columnIndexOrThrow26;
                    boolean z4 = cursorQuery.getInt(i20) != 0;
                    columnIndexOrThrow26 = i20;
                    int i21 = columnIndexOrThrow27;
                    boolean z5 = cursorQuery.getInt(i21) != 0;
                    columnIndexOrThrow27 = i21;
                    int i22 = columnIndexOrThrow28;
                    long j9 = cursorQuery.getLong(i22);
                    columnIndexOrThrow28 = i22;
                    int i23 = columnIndexOrThrow29;
                    long j10 = cursorQuery.getLong(i23);
                    columnIndexOrThrow29 = i23;
                    int i24 = columnIndexOrThrow30;
                    if (!cursorQuery.isNull(i24)) {
                        blob = cursorQuery.getBlob(i24);
                    }
                    columnIndexOrThrow30 = i24;
                    arrayList.add(new WorkSpec(string, iIntToState, string2, string3, dataFromByteArray, dataFromByteArray2, j, j2, j3, new Constraints(iIntToNetworkType, z2, z3, z4, z5, j9, j10, WorkTypeConverters.byteArrayToSetOfTriggers(blob)), i2, iIntToBackoffPolicy, j4, j5, j6, j7, z, iIntToOutOfQuotaPolicy, i9, i11, j8, i14, i16));
                    columnIndexOrThrow = i4;
                    i = i3;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    public ArrayList getRunningWork() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=1", 0);
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.__db;
        workDatabase_Impl.assertNotSuspendingTransaction();
        Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "state");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "worker_class_name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "input_merger_class_name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "input");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "output");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "initial_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "interval_duration");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flex_duration");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_attempt_count");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backoff_policy");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backoff_delay_duration");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_enqueue_time");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "minimum_retention_duration");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "schedule_requested_at");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_in_foreground");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "out_of_quota_policy");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "period_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "generation");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "next_schedule_time_override");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "next_schedule_time_override_generation");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "stop_reason");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "required_network_type");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_charging");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_device_idle");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_battery_not_low");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_storage_not_low");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trigger_content_update_delay");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trigger_max_content_delay");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "content_uri_triggers");
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    byte[] blob = null;
                    String string = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                    int iIntToState = WorkTypeConverters.intToState(cursorQuery.getInt(columnIndexOrThrow2));
                    String string2 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                    String string3 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                    Data dataFromByteArray = Data.fromByteArray(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getBlob(columnIndexOrThrow5));
                    Data dataFromByteArray2 = Data.fromByteArray(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getBlob(columnIndexOrThrow6));
                    long j = cursorQuery.getLong(columnIndexOrThrow7);
                    long j2 = cursorQuery.getLong(columnIndexOrThrow8);
                    long j3 = cursorQuery.getLong(columnIndexOrThrow9);
                    int i2 = cursorQuery.getInt(columnIndexOrThrow10);
                    int iIntToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(cursorQuery.getInt(columnIndexOrThrow11));
                    long j4 = cursorQuery.getLong(columnIndexOrThrow12);
                    long j5 = cursorQuery.getLong(columnIndexOrThrow13);
                    int i3 = i;
                    long j6 = cursorQuery.getLong(i3);
                    int i4 = columnIndexOrThrow;
                    int i5 = columnIndexOrThrow15;
                    long j7 = cursorQuery.getLong(i5);
                    columnIndexOrThrow15 = i5;
                    int i6 = columnIndexOrThrow16;
                    boolean z = cursorQuery.getInt(i6) != 0;
                    columnIndexOrThrow16 = i6;
                    int i7 = columnIndexOrThrow17;
                    int iIntToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(cursorQuery.getInt(i7));
                    columnIndexOrThrow17 = i7;
                    int i8 = columnIndexOrThrow18;
                    int i9 = cursorQuery.getInt(i8);
                    columnIndexOrThrow18 = i8;
                    int i10 = columnIndexOrThrow19;
                    int i11 = cursorQuery.getInt(i10);
                    columnIndexOrThrow19 = i10;
                    int i12 = columnIndexOrThrow20;
                    long j8 = cursorQuery.getLong(i12);
                    columnIndexOrThrow20 = i12;
                    int i13 = columnIndexOrThrow21;
                    int i14 = cursorQuery.getInt(i13);
                    columnIndexOrThrow21 = i13;
                    int i15 = columnIndexOrThrow22;
                    int i16 = cursorQuery.getInt(i15);
                    columnIndexOrThrow22 = i15;
                    int i17 = columnIndexOrThrow23;
                    int iIntToNetworkType = WorkTypeConverters.intToNetworkType(cursorQuery.getInt(i17));
                    columnIndexOrThrow23 = i17;
                    int i18 = columnIndexOrThrow24;
                    boolean z2 = cursorQuery.getInt(i18) != 0;
                    columnIndexOrThrow24 = i18;
                    int i19 = columnIndexOrThrow25;
                    boolean z3 = cursorQuery.getInt(i19) != 0;
                    columnIndexOrThrow25 = i19;
                    int i20 = columnIndexOrThrow26;
                    boolean z4 = cursorQuery.getInt(i20) != 0;
                    columnIndexOrThrow26 = i20;
                    int i21 = columnIndexOrThrow27;
                    boolean z5 = cursorQuery.getInt(i21) != 0;
                    columnIndexOrThrow27 = i21;
                    int i22 = columnIndexOrThrow28;
                    long j9 = cursorQuery.getLong(i22);
                    columnIndexOrThrow28 = i22;
                    int i23 = columnIndexOrThrow29;
                    long j10 = cursorQuery.getLong(i23);
                    columnIndexOrThrow29 = i23;
                    int i24 = columnIndexOrThrow30;
                    if (!cursorQuery.isNull(i24)) {
                        blob = cursorQuery.getBlob(i24);
                    }
                    columnIndexOrThrow30 = i24;
                    arrayList.add(new WorkSpec(string, iIntToState, string2, string3, dataFromByteArray, dataFromByteArray2, j, j2, j3, new Constraints(iIntToNetworkType, z2, z3, z4, z5, j9, j10, WorkTypeConverters.byteArrayToSetOfTriggers(blob)), i2, iIntToBackoffPolicy, j4, j5, j6, j7, z, iIntToOutOfQuotaPolicy, i9, i11, j8, i14, i16));
                    columnIndexOrThrow = i4;
                    i = i3;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    public ArrayList getScheduledWork() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.__db;
        workDatabase_Impl.assertNotSuspendingTransaction();
        Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "state");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "worker_class_name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "input_merger_class_name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "input");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "output");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "initial_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "interval_duration");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flex_duration");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_attempt_count");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backoff_policy");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backoff_delay_duration");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_enqueue_time");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "minimum_retention_duration");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "schedule_requested_at");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_in_foreground");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "out_of_quota_policy");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "period_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "generation");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "next_schedule_time_override");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "next_schedule_time_override_generation");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "stop_reason");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "required_network_type");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_charging");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_device_idle");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_battery_not_low");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_storage_not_low");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trigger_content_update_delay");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trigger_max_content_delay");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "content_uri_triggers");
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    byte[] blob = null;
                    String string = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                    int iIntToState = WorkTypeConverters.intToState(cursorQuery.getInt(columnIndexOrThrow2));
                    String string2 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                    String string3 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                    Data dataFromByteArray = Data.fromByteArray(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getBlob(columnIndexOrThrow5));
                    Data dataFromByteArray2 = Data.fromByteArray(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getBlob(columnIndexOrThrow6));
                    long j = cursorQuery.getLong(columnIndexOrThrow7);
                    long j2 = cursorQuery.getLong(columnIndexOrThrow8);
                    long j3 = cursorQuery.getLong(columnIndexOrThrow9);
                    int i2 = cursorQuery.getInt(columnIndexOrThrow10);
                    int iIntToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(cursorQuery.getInt(columnIndexOrThrow11));
                    long j4 = cursorQuery.getLong(columnIndexOrThrow12);
                    long j5 = cursorQuery.getLong(columnIndexOrThrow13);
                    int i3 = i;
                    long j6 = cursorQuery.getLong(i3);
                    int i4 = columnIndexOrThrow;
                    int i5 = columnIndexOrThrow15;
                    long j7 = cursorQuery.getLong(i5);
                    columnIndexOrThrow15 = i5;
                    int i6 = columnIndexOrThrow16;
                    boolean z = cursorQuery.getInt(i6) != 0;
                    columnIndexOrThrow16 = i6;
                    int i7 = columnIndexOrThrow17;
                    int iIntToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(cursorQuery.getInt(i7));
                    columnIndexOrThrow17 = i7;
                    int i8 = columnIndexOrThrow18;
                    int i9 = cursorQuery.getInt(i8);
                    columnIndexOrThrow18 = i8;
                    int i10 = columnIndexOrThrow19;
                    int i11 = cursorQuery.getInt(i10);
                    columnIndexOrThrow19 = i10;
                    int i12 = columnIndexOrThrow20;
                    long j8 = cursorQuery.getLong(i12);
                    columnIndexOrThrow20 = i12;
                    int i13 = columnIndexOrThrow21;
                    int i14 = cursorQuery.getInt(i13);
                    columnIndexOrThrow21 = i13;
                    int i15 = columnIndexOrThrow22;
                    int i16 = cursorQuery.getInt(i15);
                    columnIndexOrThrow22 = i15;
                    int i17 = columnIndexOrThrow23;
                    int iIntToNetworkType = WorkTypeConverters.intToNetworkType(cursorQuery.getInt(i17));
                    columnIndexOrThrow23 = i17;
                    int i18 = columnIndexOrThrow24;
                    boolean z2 = cursorQuery.getInt(i18) != 0;
                    columnIndexOrThrow24 = i18;
                    int i19 = columnIndexOrThrow25;
                    boolean z3 = cursorQuery.getInt(i19) != 0;
                    columnIndexOrThrow25 = i19;
                    int i20 = columnIndexOrThrow26;
                    boolean z4 = cursorQuery.getInt(i20) != 0;
                    columnIndexOrThrow26 = i20;
                    int i21 = columnIndexOrThrow27;
                    boolean z5 = cursorQuery.getInt(i21) != 0;
                    columnIndexOrThrow27 = i21;
                    int i22 = columnIndexOrThrow28;
                    long j9 = cursorQuery.getLong(i22);
                    columnIndexOrThrow28 = i22;
                    int i23 = columnIndexOrThrow29;
                    long j10 = cursorQuery.getLong(i23);
                    columnIndexOrThrow29 = i23;
                    int i24 = columnIndexOrThrow30;
                    if (!cursorQuery.isNull(i24)) {
                        blob = cursorQuery.getBlob(i24);
                    }
                    columnIndexOrThrow30 = i24;
                    arrayList.add(new WorkSpec(string, iIntToState, string2, string3, dataFromByteArray, dataFromByteArray2, j, j2, j3, new Constraints(iIntToNetworkType, z2, z3, z4, z5, j9, j10, WorkTypeConverters.byteArrayToSetOfTriggers(blob)), i2, iIntToBackoffPolicy, j4, j5, j6, j7, z, iIntToOutOfQuotaPolicy, i9, i11, j8, i14, i16));
                    columnIndexOrThrow = i4;
                    i = i3;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    public int getState(String str) {
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.__db;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT state FROM workspec WHERE id=?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(str, 1);
        }
        workDatabase_Impl.assertNotSuspendingTransaction();
        Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
        try {
            int iIntToState = 0;
            if (cursorQuery.moveToFirst()) {
                Integer numValueOf = cursorQuery.isNull(0) ? null : Integer.valueOf(cursorQuery.getInt(0));
                if (numValueOf != null) {
                    iIntToState = WorkTypeConverters.intToState(numValueOf.intValue());
                }
            }
            return iIntToState;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    public ArrayList getUnfinishedWorkWithName(String str) {
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.__db;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(str, 1);
        }
        workDatabase_Impl.assertNotSuspendingTransaction();
        Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    public WorkSpec getWorkSpec(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.__db;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE id=?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(str, 1);
        }
        workDatabase_Impl.assertNotSuspendingTransaction();
        Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "state");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "worker_class_name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "input_merger_class_name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "input");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "output");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "initial_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "interval_duration");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flex_duration");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_attempt_count");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backoff_policy");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backoff_delay_duration");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_enqueue_time");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "minimum_retention_duration");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "schedule_requested_at");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_in_foreground");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "out_of_quota_policy");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "period_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "generation");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "next_schedule_time_override");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "next_schedule_time_override_generation");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "stop_reason");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "required_network_type");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_charging");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_device_idle");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_battery_not_low");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_storage_not_low");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trigger_content_update_delay");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trigger_max_content_delay");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "content_uri_triggers");
                WorkSpec workSpec = null;
                byte[] blob = null;
                if (cursorQuery.moveToFirst()) {
                    String string = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                    int iIntToState = WorkTypeConverters.intToState(cursorQuery.getInt(columnIndexOrThrow2));
                    String string2 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                    String string3 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                    Data dataFromByteArray = Data.fromByteArray(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getBlob(columnIndexOrThrow5));
                    Data dataFromByteArray2 = Data.fromByteArray(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getBlob(columnIndexOrThrow6));
                    long j = cursorQuery.getLong(columnIndexOrThrow7);
                    long j2 = cursorQuery.getLong(columnIndexOrThrow8);
                    long j3 = cursorQuery.getLong(columnIndexOrThrow9);
                    int i = cursorQuery.getInt(columnIndexOrThrow10);
                    int iIntToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(cursorQuery.getInt(columnIndexOrThrow11));
                    long j4 = cursorQuery.getLong(columnIndexOrThrow12);
                    long j5 = cursorQuery.getLong(columnIndexOrThrow13);
                    long j6 = cursorQuery.getLong(columnIndexOrThrow14);
                    long j7 = cursorQuery.getLong(columnIndexOrThrow15);
                    boolean z = cursorQuery.getInt(columnIndexOrThrow16) != 0;
                    int iIntToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(cursorQuery.getInt(columnIndexOrThrow17));
                    int i2 = cursorQuery.getInt(columnIndexOrThrow18);
                    int i3 = cursorQuery.getInt(columnIndexOrThrow19);
                    long j8 = cursorQuery.getLong(columnIndexOrThrow20);
                    int i4 = cursorQuery.getInt(columnIndexOrThrow21);
                    int i5 = cursorQuery.getInt(columnIndexOrThrow22);
                    int iIntToNetworkType = WorkTypeConverters.intToNetworkType(cursorQuery.getInt(columnIndexOrThrow23));
                    boolean z2 = cursorQuery.getInt(columnIndexOrThrow24) != 0;
                    boolean z3 = cursorQuery.getInt(columnIndexOrThrow25) != 0;
                    boolean z4 = cursorQuery.getInt(columnIndexOrThrow26) != 0;
                    boolean z5 = cursorQuery.getInt(columnIndexOrThrow27) != 0;
                    long j9 = cursorQuery.getLong(columnIndexOrThrow28);
                    long j10 = cursorQuery.getLong(columnIndexOrThrow29);
                    if (!cursorQuery.isNull(columnIndexOrThrow30)) {
                        blob = cursorQuery.getBlob(columnIndexOrThrow30);
                    }
                    workSpec = new WorkSpec(string, iIntToState, string2, string3, dataFromByteArray, dataFromByteArray2, j, j2, j3, new Constraints(iIntToNetworkType, z2, z3, z4, z5, j9, j10, WorkTypeConverters.byteArrayToSetOfTriggers(blob)), i, iIntToBackoffPolicy, j4, j5, j6, j7, z, iIntToOutOfQuotaPolicy, i2, i3, j8, i4, i5);
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return workSpec;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    public ArrayList getWorkSpecIdAndStatesForName(String str) {
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.__db;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(str, 1);
        }
        workDatabase_Impl.assertNotSuspendingTransaction();
        Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                String string = cursorQuery.isNull(0) ? null : cursorQuery.getString(0);
                int iIntToState = WorkTypeConverters.intToState(cursorQuery.getInt(1));
                WorkSpec.IdAndState idAndState = new WorkSpec.IdAndState();
                idAndState.id = string;
                idAndState.state = iIntToState;
                arrayList.add(idAndState);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    public void markWorkSpecScheduled(String str, long j) {
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.__db;
        workDatabase_Impl.assertNotSuspendingTransaction();
        WorkTagDao_Impl$2 workTagDao_Impl$2 = (WorkTagDao_Impl$2) this.__preparedStmtOfMarkWorkSpecScheduled;
        FrameworkSQLiteStatement frameworkSQLiteStatementAcquire = workTagDao_Impl$2.acquire();
        frameworkSQLiteStatementAcquire.bindLong(1, j);
        if (str == null) {
            frameworkSQLiteStatementAcquire.bindNull(2);
        } else {
            frameworkSQLiteStatementAcquire.bindString(str, 2);
        }
        workDatabase_Impl.beginTransaction();
        try {
            frameworkSQLiteStatementAcquire.executeUpdateDelete();
            workDatabase_Impl.setTransactionSuccessful();
        } finally {
            workDatabase_Impl.internalEndTransaction();
            workTagDao_Impl$2.release(frameworkSQLiteStatementAcquire);
        }
    }

    public void resetWorkSpecNextScheduleTimeOverride(String str, int i) {
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.__db;
        workDatabase_Impl.assertNotSuspendingTransaction();
        WorkTagDao_Impl$2 workTagDao_Impl$2 = (WorkTagDao_Impl$2) this.__preparedStmtOfResetWorkSpecNextScheduleTimeOverride;
        FrameworkSQLiteStatement frameworkSQLiteStatementAcquire = workTagDao_Impl$2.acquire();
        if (str == null) {
            frameworkSQLiteStatementAcquire.bindNull(1);
        } else {
            frameworkSQLiteStatementAcquire.bindString(str, 1);
        }
        frameworkSQLiteStatementAcquire.bindLong(2, i);
        workDatabase_Impl.beginTransaction();
        try {
            frameworkSQLiteStatementAcquire.executeUpdateDelete();
            workDatabase_Impl.setTransactionSuccessful();
        } finally {
            workDatabase_Impl.internalEndTransaction();
            workTagDao_Impl$2.release(frameworkSQLiteStatementAcquire);
        }
    }

    public void setLastEnqueueTime(String str, long j) {
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.__db;
        workDatabase_Impl.assertNotSuspendingTransaction();
        WorkTagDao_Impl$2 workTagDao_Impl$2 = (WorkTagDao_Impl$2) this.__preparedStmtOfSetLastEnqueueTime;
        FrameworkSQLiteStatement frameworkSQLiteStatementAcquire = workTagDao_Impl$2.acquire();
        frameworkSQLiteStatementAcquire.bindLong(1, j);
        if (str == null) {
            frameworkSQLiteStatementAcquire.bindNull(2);
        } else {
            frameworkSQLiteStatementAcquire.bindString(str, 2);
        }
        workDatabase_Impl.beginTransaction();
        try {
            frameworkSQLiteStatementAcquire.executeUpdateDelete();
            workDatabase_Impl.setTransactionSuccessful();
        } finally {
            workDatabase_Impl.internalEndTransaction();
            workTagDao_Impl$2.release(frameworkSQLiteStatementAcquire);
        }
    }

    public void setOutput(String str, Data data) throws Throwable {
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.__db;
        workDatabase_Impl.assertNotSuspendingTransaction();
        WorkTagDao_Impl$2 workTagDao_Impl$2 = (WorkTagDao_Impl$2) this.__preparedStmtOfSetOutput;
        FrameworkSQLiteStatement frameworkSQLiteStatementAcquire = workTagDao_Impl$2.acquire();
        byte[] byteArrayInternal = Data.toByteArrayInternal(data);
        if (byteArrayInternal == null) {
            frameworkSQLiteStatementAcquire.bindNull(1);
        } else {
            frameworkSQLiteStatementAcquire.bindBlob(1, byteArrayInternal);
        }
        if (str == null) {
            frameworkSQLiteStatementAcquire.bindNull(2);
        } else {
            frameworkSQLiteStatementAcquire.bindString(str, 2);
        }
        workDatabase_Impl.beginTransaction();
        try {
            frameworkSQLiteStatementAcquire.executeUpdateDelete();
            workDatabase_Impl.setTransactionSuccessful();
        } finally {
            workDatabase_Impl.internalEndTransaction();
            workTagDao_Impl$2.release(frameworkSQLiteStatementAcquire);
        }
    }

    public void setState(String str, int i) {
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.__db;
        workDatabase_Impl.assertNotSuspendingTransaction();
        WorkTagDao_Impl$2 workTagDao_Impl$2 = (WorkTagDao_Impl$2) this.__preparedStmtOfSetState;
        FrameworkSQLiteStatement frameworkSQLiteStatementAcquire = workTagDao_Impl$2.acquire();
        frameworkSQLiteStatementAcquire.bindLong(1, WorkTypeConverters.stateToInt(i));
        if (str == null) {
            frameworkSQLiteStatementAcquire.bindNull(2);
        } else {
            frameworkSQLiteStatementAcquire.bindString(str, 2);
        }
        workDatabase_Impl.beginTransaction();
        try {
            frameworkSQLiteStatementAcquire.executeUpdateDelete();
            workDatabase_Impl.setTransactionSuccessful();
        } finally {
            workDatabase_Impl.internalEndTransaction();
            workTagDao_Impl$2.release(frameworkSQLiteStatementAcquire);
        }
    }

    public void setStopReason(String str, int i) {
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.__db;
        workDatabase_Impl.assertNotSuspendingTransaction();
        WorkTagDao_Impl$2 workTagDao_Impl$2 = (WorkTagDao_Impl$2) this.__preparedStmtOfSetStopReason;
        FrameworkSQLiteStatement frameworkSQLiteStatementAcquire = workTagDao_Impl$2.acquire();
        frameworkSQLiteStatementAcquire.bindLong(1, i);
        if (str == null) {
            frameworkSQLiteStatementAcquire.bindNull(2);
        } else {
            frameworkSQLiteStatementAcquire.bindString(str, 2);
        }
        workDatabase_Impl.beginTransaction();
        try {
            frameworkSQLiteStatementAcquire.executeUpdateDelete();
            workDatabase_Impl.setTransactionSuccessful();
        } finally {
            workDatabase_Impl.internalEndTransaction();
            workTagDao_Impl$2.release(frameworkSQLiteStatementAcquire);
        }
    }

    public WorkSpecDao_Impl(WorkDatabase_Impl workDatabase_Impl) {
        this.__db = workDatabase_Impl;
        this.__insertionAdapterOfWorkSpec = new WorkTagDao_Impl$1(workDatabase_Impl, 6);
        this.__updateAdapterOfWorkSpec = new AnonymousClass2(workDatabase_Impl);
        this.__preparedStmtOfDelete = new WorkTagDao_Impl$2(workDatabase_Impl, 13);
        this.__preparedStmtOfSetState = new WorkTagDao_Impl$2(workDatabase_Impl, 14);
        this.__preparedStmtOfSetCancelledState = new WorkTagDao_Impl$2(workDatabase_Impl, 15);
        this.__preparedStmtOfIncrementPeriodCount = new WorkTagDao_Impl$2(workDatabase_Impl, 16);
        this.__preparedStmtOfSetOutput = new WorkTagDao_Impl$2(workDatabase_Impl, 17);
        this.__preparedStmtOfSetLastEnqueueTime = new WorkTagDao_Impl$2(workDatabase_Impl, 18);
        this.__preparedStmtOfIncrementWorkSpecRunAttemptCount = new WorkTagDao_Impl$2(workDatabase_Impl, 19);
        this.__preparedStmtOfResetWorkSpecRunAttemptCount = new WorkTagDao_Impl$2(workDatabase_Impl, 5);
        new WorkTagDao_Impl$2(workDatabase_Impl, 6);
        this.__preparedStmtOfResetWorkSpecNextScheduleTimeOverride = new WorkTagDao_Impl$2(workDatabase_Impl, 7);
        this.__preparedStmtOfMarkWorkSpecScheduled = new WorkTagDao_Impl$2(workDatabase_Impl, 8);
        this.__preparedStmtOfResetScheduledState = new WorkTagDao_Impl$2(workDatabase_Impl, 9);
        new WorkTagDao_Impl$2(workDatabase_Impl, 10);
        new WorkTagDao_Impl$2(workDatabase_Impl, 11);
        this.__preparedStmtOfSetStopReason = new WorkTagDao_Impl$2(workDatabase_Impl, 12);
    }
}
