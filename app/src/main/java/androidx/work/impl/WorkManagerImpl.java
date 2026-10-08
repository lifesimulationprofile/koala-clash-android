package androidx.work.impl;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Build;
import androidx.room.TransactionExecutor;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import androidx.work.Configuration;
import androidx.work.Logger$LogcatLogger;
import androidx.work.WorkManager;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkTagDao_Impl$2;
import androidx.work.impl.utils.ForceStopRunnable;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import coil.memory.EmptyStrongMemoryCache;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class WorkManagerImpl extends WorkManager {
    public static WorkManagerImpl sDefaultInstance;
    public static WorkManagerImpl sDelegatedInstance;
    public static final Object sLock;
    public final Configuration mConfiguration;
    public final Context mContext;
    public boolean mForceStopRunnableCompleted = false;
    public final EmptyStrongMemoryCache mPreferenceUtils;
    public final Processor mProcessor;
    public BroadcastReceiver.PendingResult mRescheduleReceiverResult;
    public final List mSchedulers;
    public final Trackers mTrackers;
    public final WorkDatabase mWorkDatabase;
    public final WorkManagerTaskExecutor mWorkTaskExecutor;

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public abstract class Api24Impl {
        public static boolean isDeviceProtectedStorage(Context context) {
            return context.isDeviceProtectedStorage();
        }
    }

    static {
        Logger$LogcatLogger.tagWithPrefix("WorkManagerImpl");
        sDelegatedInstance = null;
        sDefaultInstance = null;
        sLock = new Object();
    }

    public WorkManagerImpl(Context context, final Configuration configuration, WorkManagerTaskExecutor workManagerTaskExecutor, final WorkDatabase workDatabase, final List list, Processor processor, Trackers trackers) {
        Context applicationContext = context.getApplicationContext();
        if (Build.VERSION.SDK_INT >= 24 && Api24Impl.isDeviceProtectedStorage(applicationContext)) {
            throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
        }
        Logger$LogcatLogger logger$LogcatLogger = new Logger$LogcatLogger(configuration.minimumLoggingLevel);
        synchronized (Logger$LogcatLogger.sLock) {
            Logger$LogcatLogger.sLogger = logger$LogcatLogger;
        }
        this.mContext = applicationContext;
        this.mWorkTaskExecutor = workManagerTaskExecutor;
        this.mWorkDatabase = workDatabase;
        this.mProcessor = processor;
        this.mTrackers = trackers;
        this.mConfiguration = configuration;
        this.mSchedulers = list;
        this.mPreferenceUtils = new EmptyStrongMemoryCache(18, workDatabase);
        final TransactionExecutor transactionExecutor = workManagerTaskExecutor.mBackgroundExecutor;
        String str = Schedulers.TAG;
        processor.addExecutionListener(new ExecutionListener() { // from class: androidx.work.impl.Schedulers$$ExternalSyntheticLambda0
            @Override // androidx.work.impl.ExecutionListener
            public final void onExecuted(WorkGenerationalId workGenerationalId, boolean z) {
                transactionExecutor.execute(new Schedulers$$ExternalSyntheticLambda1(list, workGenerationalId, configuration, workDatabase, 0));
            }
        });
        workManagerTaskExecutor.executeOnTaskThread(new ForceStopRunnable(applicationContext, this));
    }

    public static WorkManagerImpl getInstance() {
        synchronized (sLock) {
            try {
                WorkManagerImpl workManagerImpl = sDelegatedInstance;
                if (workManagerImpl != null) {
                    return workManagerImpl;
                }
                return sDefaultInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static WorkManagerImpl getInstance$1(Context context) {
        WorkManagerImpl workManagerImpl;
        synchronized (sLock) {
            try {
                workManagerImpl = getInstance();
                if (workManagerImpl == null) {
                    context.getApplicationContext();
                    throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return workManagerImpl;
    }

    public final void onForceStopRunnableCompleted() {
        synchronized (sLock) {
            try {
                this.mForceStopRunnableCompleted = true;
                BroadcastReceiver.PendingResult pendingResult = this.mRescheduleReceiverResult;
                if (pendingResult != null) {
                    pendingResult.finish();
                    this.mRescheduleReceiverResult = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void rescheduleEligibleWork() {
        ArrayList pendingJobs;
        String str = SystemJobScheduler.TAG;
        Context context = this.mContext;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null && (pendingJobs = SystemJobScheduler.getPendingJobs(context, jobScheduler)) != null && !pendingJobs.isEmpty()) {
            int size = pendingJobs.size();
            int i = 0;
            while (i < size) {
                Object obj = pendingJobs.get(i);
                i++;
                SystemJobScheduler.cancelJobById(jobScheduler, ((JobInfo) obj).getId());
            }
        }
        WorkDatabase workDatabase = this.mWorkDatabase;
        WorkSpecDao_Impl workSpecDao_ImplWorkSpecDao = workDatabase.workSpecDao();
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) workSpecDao_ImplWorkSpecDao.__db;
        workDatabase_Impl.assertNotSuspendingTransaction();
        WorkTagDao_Impl$2 workTagDao_Impl$2 = (WorkTagDao_Impl$2) workSpecDao_ImplWorkSpecDao.__preparedStmtOfResetScheduledState;
        FrameworkSQLiteStatement frameworkSQLiteStatementAcquire = workTagDao_Impl$2.acquire();
        workDatabase_Impl.beginTransaction();
        try {
            frameworkSQLiteStatementAcquire.executeUpdateDelete();
            workDatabase_Impl.setTransactionSuccessful();
            workDatabase_Impl.internalEndTransaction();
            workTagDao_Impl$2.release(frameworkSQLiteStatementAcquire);
            Schedulers.schedule(this.mConfiguration, workDatabase, this.mSchedulers);
        } catch (Throwable th) {
            workDatabase_Impl.internalEndTransaction();
            workTagDao_Impl$2.release(frameworkSQLiteStatementAcquire);
            throw th;
        }
    }
}
