package androidx.work.impl.workers;

import android.content.Context;
import android.database.Cursor;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.Logger$LogcatLogger;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkTypeConverters;
import coil.ImageLoader$Builder;
import coil.request.RequestService;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class DiagnosticsWorker extends Worker {
    public DiagnosticsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    @Override // androidx.work.Worker
    public final ListenableWorker.Result.Success doWork() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        Request.Builder builder;
        RequestService requestService;
        ImageLoader$Builder imageLoader$Builder;
        WorkManagerImpl instance$1 = WorkManagerImpl.getInstance$1(this.mAppContext);
        WorkDatabase workDatabase = instance$1.mWorkDatabase;
        WorkSpecDao_Impl workSpecDao_ImplWorkSpecDao = workDatabase.workSpecDao();
        RequestService requestServiceWorkNameDao = workDatabase.workNameDao();
        ImageLoader$Builder imageLoader$BuilderWorkTagDao = workDatabase.workTagDao();
        Request.Builder builderSystemIdInfoDao = workDatabase.systemIdInfoDao();
        instance$1.mConfiguration.clock.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1L);
        workSpecDao_ImplWorkSpecDao.getClass();
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE last_enqueue_time >= ? AND state IN (2, 3, 5) ORDER BY last_enqueue_time DESC", 1);
        roomSQLiteQueryAcquire.bindLong(1, jCurrentTimeMillis);
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) workSpecDao_ImplWorkSpecDao.__db;
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
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backoff_delay_duration");
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_enqueue_time");
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
                ArrayList runningWork = workSpecDao_ImplWorkSpecDao.getRunningWork();
                ArrayList allEligibleWorkSpecsForScheduling = workSpecDao_ImplWorkSpecDao.getAllEligibleWorkSpecsForScheduling();
                if (arrayList.isEmpty()) {
                    builder = builderSystemIdInfoDao;
                    requestService = requestServiceWorkNameDao;
                    imageLoader$Builder = imageLoader$BuilderWorkTagDao;
                } else {
                    Logger$LogcatLogger logger$LogcatLogger = Logger$LogcatLogger.get();
                    String str = DiagnosticsWorkerKt.TAG;
                    logger$LogcatLogger.info(str, "Recently completed work:\n\n");
                    builder = builderSystemIdInfoDao;
                    requestService = requestServiceWorkNameDao;
                    imageLoader$Builder = imageLoader$BuilderWorkTagDao;
                    Logger$LogcatLogger.get().info(str, DiagnosticsWorkerKt.access$workSpecRows(requestService, imageLoader$Builder, builder, arrayList));
                }
                if (!runningWork.isEmpty()) {
                    Logger$LogcatLogger logger$LogcatLogger2 = Logger$LogcatLogger.get();
                    String str2 = DiagnosticsWorkerKt.TAG;
                    logger$LogcatLogger2.info(str2, "Running work:\n\n");
                    Logger$LogcatLogger.get().info(str2, DiagnosticsWorkerKt.access$workSpecRows(requestService, imageLoader$Builder, builder, runningWork));
                }
                if (!allEligibleWorkSpecsForScheduling.isEmpty()) {
                    Logger$LogcatLogger logger$LogcatLogger3 = Logger$LogcatLogger.get();
                    String str3 = DiagnosticsWorkerKt.TAG;
                    logger$LogcatLogger3.info(str3, "Enqueued work:\n\n");
                    Logger$LogcatLogger.get().info(str3, DiagnosticsWorkerKt.access$workSpecRows(requestService, imageLoader$Builder, builder, allEligibleWorkSpecsForScheduling));
                }
                return new ListenableWorker.Result.Success(Data.EMPTY);
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
}
