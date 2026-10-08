package androidx.work.impl;

import android.content.Context;
import android.database.Cursor;
import androidx.appcompat.widget.TooltipPopup;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.camera.core.Preview$$ExternalSyntheticLambda1;
import androidx.compose.ui.unit.Density;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import androidx.work.Configuration;
import androidx.work.Data;
import androidx.work.InputMerger;
import androidx.work.InputMergerKt;
import androidx.work.ListenableWorker;
import androidx.work.Logger$LogcatLogger;
import androidx.work.SystemClock;
import androidx.work.Worker;
import androidx.work.WorkerFactory$1;
import androidx.work.WorkerParameters;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkTagDao_Impl$2;
import androidx.work.impl.utils.PackageManagerHelper;
import androidx.work.impl.utils.WorkForegroundRunnable;
import androidx.work.impl.utils.WorkForegroundUpdater;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import com.google.android.gms.tasks.zzt;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.UUID;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class WorkerWrapper implements Runnable {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("WorkerWrapper");
    public final Context mAppContext;
    public final SystemClock mClock;
    public final Configuration mConfiguration;
    public final WorkLauncherImpl mDependencyDao;
    public final Processor mForegroundProcessor;
    public final ArrayList mTags;
    public final WorkDatabase mWorkDatabase;
    public String mWorkDescription;
    public final WorkSpec mWorkSpec;
    public final WorkSpecDao_Impl mWorkSpecDao;
    public final String mWorkSpecId;
    public final WorkManagerTaskExecutor mWorkTaskExecutor;
    public ListenableWorker mWorker;
    public ListenableWorker.Result mResult = new ListenableWorker.Result.Failure();
    public final SettableFuture mFuture = new SettableFuture();
    public final SettableFuture mWorkerResultFuture = new SettableFuture();
    public volatile int mInterrupted = -256;

    public WorkerWrapper(TooltipPopup tooltipPopup) {
        this.mAppContext = (Context) tooltipPopup.mContext;
        this.mWorkTaskExecutor = (WorkManagerTaskExecutor) tooltipPopup.mMessageView;
        this.mForegroundProcessor = (Processor) tooltipPopup.mContentView;
        WorkSpec workSpec = (WorkSpec) tooltipPopup.mTmpAnchorPos;
        this.mWorkSpec = workSpec;
        this.mWorkSpecId = workSpec.id;
        this.mWorker = null;
        Configuration configuration = (Configuration) tooltipPopup.mLayoutParams;
        this.mConfiguration = configuration;
        this.mClock = configuration.clock;
        WorkDatabase workDatabase = (WorkDatabase) tooltipPopup.mTmpDisplayFrame;
        this.mWorkDatabase = workDatabase;
        this.mWorkSpecDao = workDatabase.workSpecDao();
        this.mDependencyDao = workDatabase.dependencyDao();
        this.mTags = (ArrayList) tooltipPopup.mTmpAppPos;
    }

    public final void handleResult(ListenableWorker.Result result) {
        boolean z = result instanceof ListenableWorker.Result.Success;
        WorkSpec workSpec = this.mWorkSpec;
        String str = TAG;
        if (!z) {
            if (result instanceof ListenableWorker.Result.Retry) {
                Logger$LogcatLogger.get().info(str, "Worker result RETRY for " + this.mWorkDescription);
                rescheduleAndResolve();
                return;
            }
            Logger$LogcatLogger.get().info(str, "Worker result FAILURE for " + this.mWorkDescription);
            if (workSpec.isPeriodic()) {
                resetPeriodicAndResolve();
                return;
            } else {
                setFailedAndResolve();
                return;
            }
        }
        Logger$LogcatLogger.get().info(str, "Worker result SUCCESS for " + this.mWorkDescription);
        if (workSpec.isPeriodic()) {
            resetPeriodicAndResolve();
            return;
        }
        WorkLauncherImpl workLauncherImpl = this.mDependencyDao;
        String str2 = this.mWorkSpecId;
        WorkSpecDao_Impl workSpecDao_Impl = this.mWorkSpecDao;
        WorkDatabase workDatabase = this.mWorkDatabase;
        workDatabase.beginTransaction();
        try {
            workSpecDao_Impl.setState(str2, 3);
            workSpecDao_Impl.setOutput(str2, ((ListenableWorker.Result.Success) this.mResult).mOutputData);
            this.mClock.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            ArrayList dependentWorkIds = workLauncherImpl.getDependentWorkIds(str2);
            int size = dependentWorkIds.size();
            int i = 0;
            while (i < size) {
                Object obj = dependentWorkIds.get(i);
                i++;
                String str3 = (String) obj;
                if (workSpecDao_Impl.getState(str3) == 5) {
                    WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) workLauncherImpl.processor;
                    RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)", 1);
                    if (str3 == null) {
                        roomSQLiteQueryAcquire.bindNull(1);
                    } else {
                        roomSQLiteQueryAcquire.bindString(str3, 1);
                    }
                    workDatabase_Impl.assertNotSuspendingTransaction();
                    Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
                    try {
                        boolean z2 = cursorQuery.moveToFirst() && cursorQuery.getInt(0) != 0;
                        cursorQuery.close();
                        roomSQLiteQueryAcquire.release();
                        if (z2) {
                            Logger$LogcatLogger.get().info(str, "Setting status to enqueued for " + str3);
                            workSpecDao_Impl.setState(str3, 1);
                            workSpecDao_Impl.setLastEnqueueTime(str3, jCurrentTimeMillis);
                        }
                    } catch (Throwable th) {
                        cursorQuery.close();
                        roomSQLiteQueryAcquire.release();
                        throw th;
                    }
                }
            }
            workDatabase.setTransactionSuccessful();
            workDatabase.internalEndTransaction();
            resolve(false);
        } catch (Throwable th2) {
            workDatabase.internalEndTransaction();
            resolve(false);
            throw th2;
        }
    }

    public final void onWorkFinished() {
        if (tryCheckForInterruptionAndResolve()) {
            return;
        }
        this.mWorkDatabase.beginTransaction();
        try {
            int state = this.mWorkSpecDao.getState(this.mWorkSpecId);
            this.mWorkDatabase.workProgressDao().delete(this.mWorkSpecId);
            if (state == 0) {
                resolve(false);
            } else if (state == 2) {
                handleResult(this.mResult);
            } else if (!Density.CC._isFinished(state)) {
                this.mInterrupted = -512;
                rescheduleAndResolve();
            }
            this.mWorkDatabase.setTransactionSuccessful();
        } finally {
            this.mWorkDatabase.internalEndTransaction();
        }
    }

    public final void rescheduleAndResolve() {
        String str = this.mWorkSpecId;
        WorkSpecDao_Impl workSpecDao_Impl = this.mWorkSpecDao;
        WorkDatabase workDatabase = this.mWorkDatabase;
        workDatabase.beginTransaction();
        try {
            workSpecDao_Impl.setState(str, 1);
            this.mClock.getClass();
            workSpecDao_Impl.setLastEnqueueTime(str, System.currentTimeMillis());
            workSpecDao_Impl.resetWorkSpecNextScheduleTimeOverride(str, this.mWorkSpec.nextScheduleTimeOverrideGeneration);
            workSpecDao_Impl.markWorkSpecScheduled(str, -1L);
            workDatabase.setTransactionSuccessful();
        } finally {
            workDatabase.internalEndTransaction();
            resolve(true);
        }
    }

    public final void resetPeriodicAndResolve() {
        String str = this.mWorkSpecId;
        WorkSpecDao_Impl workSpecDao_Impl = this.mWorkSpecDao;
        WorkDatabase workDatabase = this.mWorkDatabase;
        workDatabase.beginTransaction();
        try {
            this.mClock.getClass();
            workSpecDao_Impl.setLastEnqueueTime(str, System.currentTimeMillis());
            WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) workSpecDao_Impl.__db;
            workSpecDao_Impl.setState(str, 1);
            workDatabase_Impl.assertNotSuspendingTransaction();
            WorkTagDao_Impl$2 workTagDao_Impl$2 = (WorkTagDao_Impl$2) workSpecDao_Impl.__preparedStmtOfResetWorkSpecRunAttemptCount;
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
                workDatabase_Impl.internalEndTransaction();
                workTagDao_Impl$2.release(frameworkSQLiteStatementAcquire);
                workSpecDao_Impl.resetWorkSpecNextScheduleTimeOverride(str, this.mWorkSpec.nextScheduleTimeOverrideGeneration);
                workDatabase_Impl.assertNotSuspendingTransaction();
                WorkTagDao_Impl$2 workTagDao_Impl$3 = (WorkTagDao_Impl$2) workSpecDao_Impl.__preparedStmtOfIncrementPeriodCount;
                FrameworkSQLiteStatement frameworkSQLiteStatementAcquire2 = workTagDao_Impl$3.acquire();
                if (str == null) {
                    frameworkSQLiteStatementAcquire2.bindNull(1);
                } else {
                    frameworkSQLiteStatementAcquire2.bindString(str, 1);
                }
                workDatabase_Impl.beginTransaction();
                try {
                    frameworkSQLiteStatementAcquire2.executeUpdateDelete();
                    workDatabase_Impl.setTransactionSuccessful();
                    workDatabase_Impl.internalEndTransaction();
                    workTagDao_Impl$3.release(frameworkSQLiteStatementAcquire2);
                    workSpecDao_Impl.markWorkSpecScheduled(str, -1L);
                    workDatabase.setTransactionSuccessful();
                    workDatabase.internalEndTransaction();
                    resolve(false);
                } catch (Throwable th) {
                    workDatabase_Impl.internalEndTransaction();
                    workTagDao_Impl$3.release(frameworkSQLiteStatementAcquire2);
                    throw th;
                }
            } catch (Throwable th2) {
                workDatabase_Impl.internalEndTransaction();
                workTagDao_Impl$2.release(frameworkSQLiteStatementAcquire);
                throw th2;
            }
        } catch (Throwable th3) {
            workDatabase.internalEndTransaction();
            resolve(false);
            throw th3;
        }
    }

    public final void resolve(boolean z) {
        this.mWorkDatabase.beginTransaction();
        try {
            WorkSpecDao_Impl workSpecDao_ImplWorkSpecDao = this.mWorkDatabase.workSpecDao();
            workSpecDao_ImplWorkSpecDao.getClass();
            RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1", 0);
            WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) workSpecDao_ImplWorkSpecDao.__db;
            workDatabase_Impl.assertNotSuspendingTransaction();
            Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
            try {
                boolean z2 = cursorQuery.moveToFirst() && cursorQuery.getInt(0) != 0;
                cursorQuery.close();
                roomSQLiteQueryAcquire.release();
                if (!z2) {
                    PackageManagerHelper.setComponentEnabled(this.mAppContext, RescheduleReceiver.class, false);
                }
                if (z) {
                    this.mWorkSpecDao.setState(this.mWorkSpecId, 1);
                    this.mWorkSpecDao.setStopReason(this.mWorkSpecId, this.mInterrupted);
                    this.mWorkSpecDao.markWorkSpecScheduled(this.mWorkSpecId, -1L);
                }
                this.mWorkDatabase.setTransactionSuccessful();
                this.mWorkDatabase.internalEndTransaction();
                this.mFuture.set(Boolean.valueOf(z));
            } catch (Throwable th) {
                cursorQuery.close();
                roomSQLiteQueryAcquire.release();
                throw th;
            }
        } catch (Throwable th2) {
            this.mWorkDatabase.internalEndTransaction();
            throw th2;
        }
    }

    public final void resolveIncorrectStatus() {
        WorkSpecDao_Impl workSpecDao_Impl = this.mWorkSpecDao;
        String str = this.mWorkSpecId;
        int state = workSpecDao_Impl.getState(str);
        String str2 = TAG;
        if (state == 2) {
            Logger$LogcatLogger.get().debug(str2, "Status for " + str + " is RUNNING; not doing any work and rescheduling for later execution");
            resolve(true);
            return;
        }
        Logger$LogcatLogger logger$LogcatLogger = Logger$LogcatLogger.get();
        StringBuilder sbM13m = ImageAnalysis$$ExternalSyntheticLambda1.m13m("Status for ", str, " is ");
        sbM13m.append(Density.CC.stringValueOf$5(state));
        sbM13m.append(" ; not doing any work");
        logger$LogcatLogger.debug(str2, sbM13m.toString());
        resolve(false);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0091 A[Catch: all -> 0x007d, TryCatch #3 {all -> 0x007d, blocks: (B:13:0x004f, B:16:0x005b, B:21:0x0080, B:23:0x0086, B:34:0x00c4, B:29:0x0091, B:31:0x00a2), top: B:108:0x004f }] */
    /* JADX WARN: Code duplicated, block: B:31:0x00a2 A[Catch: all -> 0x007d, TRY_LEAVE, TryCatch #3 {all -> 0x007d, blocks: (B:13:0x004f, B:16:0x005b, B:21:0x0080, B:23:0x0086, B:34:0x00c4, B:29:0x0091, B:31:0x00a2), top: B:108:0x004f }] */
    /* JADX WARN: Instruction removed from duplicated block: B:31:0x00a2, please report this as an issue */
    @Override // java.lang.Runnable
    public final void run() {
        InputMerger inputMerger;
        Data dataMerge;
        boolean z;
        StringBuilder sb = new StringBuilder("Work [ id=");
        String str = this.mWorkSpecId;
        sb.append(str);
        sb.append(", tags={ ");
        ArrayList arrayList = this.mTags;
        int size = arrayList.size();
        boolean z2 = true;
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            String str2 = (String) obj;
            if (z2) {
                z2 = false;
            } else {
                sb.append(", ");
            }
            sb.append(str2);
        }
        sb.append(" } ]");
        this.mWorkDescription = sb.toString();
        WorkSpec workSpec = this.mWorkSpec;
        if (tryCheckForInterruptionAndResolve()) {
            return;
        }
        WorkDatabase workDatabase = this.mWorkDatabase;
        workDatabase.beginTransaction();
        try {
            int i2 = workSpec.state;
            int i3 = workSpec.runAttemptCount;
            String str3 = workSpec.inputMergerClassName;
            String str4 = workSpec.workerClassName;
            String str5 = TAG;
            if (i2 != 1) {
                resolveIncorrectStatus();
                workDatabase.setTransactionSuccessful();
                Logger$LogcatLogger.get().debug(str5, str4 + " is not in ENQUEUED state. Nothing more to do");
                workDatabase.internalEndTransaction();
                return;
            }
            if (workSpec.isPeriodic()) {
                this.mClock.getClass();
                if (System.currentTimeMillis() < workSpec.calculateNextRunTime()) {
                    Logger$LogcatLogger.get().debug(str5, "Delaying execution for " + str4 + " because it is being executed before schedule.");
                    resolve(true);
                    workDatabase.setTransactionSuccessful();
                    workDatabase.internalEndTransaction();
                    return;
                }
            } else {
                if (workSpec.state == 1 && i3 > 0) {
                    this.mClock.getClass();
                    if (System.currentTimeMillis() < workSpec.calculateNextRunTime()) {
                        Logger$LogcatLogger.get().debug(str5, "Delaying execution for " + str4 + " because it is being executed before schedule.");
                        resolve(true);
                        workDatabase.setTransactionSuccessful();
                        workDatabase.internalEndTransaction();
                        return;
                    }
                }
            }
            workDatabase.setTransactionSuccessful();
            workDatabase.internalEndTransaction();
            boolean zIsPeriodic = workSpec.isPeriodic();
            WorkSpecDao_Impl workSpecDao_Impl = this.mWorkSpecDao;
            Configuration configuration = this.mConfiguration;
            if (zIsPeriodic) {
                dataMerge = workSpec.input;
            } else {
                configuration.inputMergerFactory.getClass();
                String str6 = InputMergerKt.TAG;
                try {
                    inputMerger = (InputMerger) Class.forName(str3).getDeclaredConstructor(null).newInstance(null);
                } catch (Exception e) {
                    Logger$LogcatLogger.get().error(InputMergerKt.TAG, "Trouble instantiating ".concat(str3), e);
                    inputMerger = null;
                }
                if (inputMerger == null) {
                    Logger$LogcatLogger.get().error(str5, "Could not create Input Merger " + str3);
                    setFailedAndResolve();
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(workSpec.input);
                WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) workSpecDao_Impl.__db;
                RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT output FROM workspec WHERE id IN\n             (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
                if (str == null) {
                    roomSQLiteQueryAcquire.bindNull(1);
                } else {
                    roomSQLiteQueryAcquire.bindString(str, 1);
                }
                workDatabase_Impl.assertNotSuspendingTransaction();
                Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
                try {
                    ArrayList arrayList3 = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList3.add(Data.fromByteArray(cursorQuery.isNull(0) ? null : cursorQuery.getBlob(0)));
                    }
                    cursorQuery.close();
                    roomSQLiteQueryAcquire.release();
                    arrayList2.addAll(arrayList3);
                    dataMerge = inputMerger.merge(arrayList2);
                } catch (Throwable th) {
                    cursorQuery.close();
                    roomSQLiteQueryAcquire.release();
                    throw th;
                }
            }
            UUID uuidFromString = UUID.fromString(str);
            ExecutorService executorService = configuration.executor;
            WorkerFactory$1 workerFactory$1 = configuration.workerFactory;
            Processor processor = this.mForegroundProcessor;
            WorkManagerTaskExecutor workManagerTaskExecutor = this.mWorkTaskExecutor;
            WorkForegroundUpdater workForegroundUpdater = new WorkForegroundUpdater(workDatabase, processor, workManagerTaskExecutor);
            WorkerParameters workerParameters = new WorkerParameters();
            workerParameters.mId = uuidFromString;
            workerParameters.mInputData = dataMerge;
            new HashSet(arrayList);
            workerParameters.mRunAttemptCount = i3;
            workerParameters.mBackgroundExecutor = executorService;
            workerParameters.mWorkTaskExecutor = workManagerTaskExecutor;
            workerParameters.mWorkerFactory = workerFactory$1;
            if (this.mWorker == null) {
                workerFactory$1.getClass();
                this.mWorker = WorkerFactory$1.createWorkerWithDefaultFallback(this.mAppContext, str4, workerParameters);
            }
            ListenableWorker listenableWorker = this.mWorker;
            if (listenableWorker == null) {
                Logger$LogcatLogger.get().error(str5, "Could not create Worker " + str4);
                setFailedAndResolve();
                return;
            }
            if (listenableWorker.mUsed) {
                Logger$LogcatLogger.get().error(str5, "Received an already-used Worker " + str4 + "; Worker Factory should return new instances");
                setFailedAndResolve();
                return;
            }
            listenableWorker.mUsed = true;
            workDatabase.beginTransaction();
            try {
                if (workSpecDao_Impl.getState(str) == 1) {
                    workSpecDao_Impl.setState(str, 2);
                    WorkDatabase_Impl workDatabase_Impl2 = (WorkDatabase_Impl) workSpecDao_Impl.__db;
                    workDatabase_Impl2.assertNotSuspendingTransaction();
                    WorkTagDao_Impl$2 workTagDao_Impl$2 = (WorkTagDao_Impl$2) workSpecDao_Impl.__preparedStmtOfIncrementWorkSpecRunAttemptCount;
                    FrameworkSQLiteStatement frameworkSQLiteStatementAcquire = workTagDao_Impl$2.acquire();
                    if (str == null) {
                        z = true;
                        frameworkSQLiteStatementAcquire.bindNull(1);
                    } else {
                        z = true;
                        frameworkSQLiteStatementAcquire.bindString(str, 1);
                    }
                    workDatabase_Impl2.beginTransaction();
                    try {
                        frameworkSQLiteStatementAcquire.executeUpdateDelete();
                        workDatabase_Impl2.setTransactionSuccessful();
                        workDatabase_Impl2.internalEndTransaction();
                        workTagDao_Impl$2.release(frameworkSQLiteStatementAcquire);
                        workSpecDao_Impl.setStopReason(str, -256);
                    } catch (Throwable th2) {
                        workDatabase_Impl2.internalEndTransaction();
                        workTagDao_Impl$2.release(frameworkSQLiteStatementAcquire);
                        throw th2;
                    }
                } else {
                    z = false;
                }
                workDatabase.setTransactionSuccessful();
                workDatabase.internalEndTransaction();
                if (!z) {
                    resolveIncorrectStatus();
                    return;
                }
                if (tryCheckForInterruptionAndResolve()) {
                    return;
                }
                WorkForegroundRunnable workForegroundRunnable = new WorkForegroundRunnable(this.mAppContext, this.mWorkSpec, this.mWorker, workForegroundUpdater, this.mWorkTaskExecutor);
                workManagerTaskExecutor.mMainThreadExecutor.execute(workForegroundRunnable);
                SettableFuture settableFuture = workForegroundRunnable.mFuture;
                Preview$$ExternalSyntheticLambda1 preview$$ExternalSyntheticLambda1 = new Preview$$ExternalSyntheticLambda1(28, this, settableFuture);
                zzt zztVar = new zzt(3);
                SettableFuture settableFuture2 = this.mWorkerResultFuture;
                settableFuture2.addListener(preview$$ExternalSyntheticLambda1, zztVar);
                boolean z3 = false;
                settableFuture.addListener(new Worker.AnonymousClass2(9, this, settableFuture, z3), workManagerTaskExecutor.mMainThreadExecutor);
                settableFuture2.addListener(new Worker.AnonymousClass2(10, this, this.mWorkDescription, z3), workManagerTaskExecutor.mBackgroundExecutor);
            } catch (Throwable th3) {
                workDatabase.internalEndTransaction();
                throw th3;
            }
        } catch (Throwable th4) {
            workDatabase.internalEndTransaction();
            throw th4;
        }
    }

    public final void setFailedAndResolve() {
        String str = this.mWorkSpecId;
        WorkDatabase workDatabase = this.mWorkDatabase;
        workDatabase.beginTransaction();
        try {
            LinkedList linkedList = new LinkedList();
            linkedList.add(str);
            while (true) {
                boolean zIsEmpty = linkedList.isEmpty();
                WorkSpecDao_Impl workSpecDao_Impl = this.mWorkSpecDao;
                if (zIsEmpty) {
                    Data data = ((ListenableWorker.Result.Failure) this.mResult).mOutputData;
                    workSpecDao_Impl.resetWorkSpecNextScheduleTimeOverride(str, this.mWorkSpec.nextScheduleTimeOverrideGeneration);
                    workSpecDao_Impl.setOutput(str, data);
                    workDatabase.setTransactionSuccessful();
                    return;
                }
                String str2 = (String) linkedList.remove();
                if (workSpecDao_Impl.getState(str2) != 6) {
                    workSpecDao_Impl.setState(str2, 4);
                }
                linkedList.addAll(this.mDependencyDao.getDependentWorkIds(str2));
            }
        } finally {
            workDatabase.internalEndTransaction();
            resolve(false);
        }
    }

    public final boolean tryCheckForInterruptionAndResolve() {
        if (this.mInterrupted == -256) {
            return false;
        }
        Logger$LogcatLogger.get().debug(TAG, "Work interrupted for " + this.mWorkDescription);
        int state = this.mWorkSpecDao.getState(this.mWorkSpecId);
        if (state == 0) {
            resolve(false);
            return true;
        }
        resolve(!Density.CC._isFinished(state));
        return true;
    }
}
