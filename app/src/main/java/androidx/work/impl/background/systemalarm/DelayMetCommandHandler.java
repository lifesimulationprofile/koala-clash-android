package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.PowerManager;
import androidx.appcompat.widget.AppCompatTextHelper;
import androidx.camera.core.impl.utils.executor.HighPriorityExecutor;
import androidx.room.TransactionExecutor;
import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.OnConstraintsStateChangedListener;
import androidx.work.impl.constraints.WorkConstraintsTrackerKt;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.WorkTimer;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import coil.memory.EmptyStrongMemoryCache;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.ExecutorCoroutineDispatcherImpl;
import kotlinx.coroutines.JobImpl;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class DelayMetCommandHandler implements OnConstraintsStateChangedListener, WorkTimer.TimeLimitExceededListener {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("DelayMetCommandHandler");
    public final Context mContext;
    public final ExecutorCoroutineDispatcherImpl mCoroutineDispatcher;
    public int mCurrentState;
    public final SystemAlarmDispatcher mDispatcher;
    public boolean mHasConstraints;
    public volatile JobImpl mJob;
    public final Object mLock;
    public final HighPriorityExecutor mMainThreadExecutor;
    public final TransactionExecutor mSerialExecutor;
    public final int mStartId;
    public final StartStopToken mToken;
    public PowerManager.WakeLock mWakeLock;
    public final EmptyStrongMemoryCache mWorkConstraintsTracker;
    public final WorkGenerationalId mWorkGenerationalId;

    /* JADX INFO: renamed from: $r8$lambda$82vXfMh9MXtN-tLNgTa3KWbb4VE, reason: not valid java name */
    public static void m771$r8$lambda$82vXfMh9MXtNtLNgTa3KWbb4VE(DelayMetCommandHandler delayMetCommandHandler) {
        int i = delayMetCommandHandler.mStartId;
        HighPriorityExecutor highPriorityExecutor = delayMetCommandHandler.mMainThreadExecutor;
        Context context = delayMetCommandHandler.mContext;
        SystemAlarmDispatcher systemAlarmDispatcher = delayMetCommandHandler.mDispatcher;
        WorkGenerationalId workGenerationalId = delayMetCommandHandler.mWorkGenerationalId;
        String str = workGenerationalId.workSpecId;
        int i2 = delayMetCommandHandler.mCurrentState;
        String str2 = TAG;
        if (i2 >= 2) {
            Logger$LogcatLogger.get().debug(str2, "Already stopped work for " + str);
            return;
        }
        delayMetCommandHandler.mCurrentState = 2;
        Logger$LogcatLogger.get().debug(str2, "Stopping work for WorkSpec " + str);
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_STOP_WORK");
        CommandHandler.writeWorkGenerationalId(intent, workGenerationalId);
        highPriorityExecutor.execute(new AppCompatTextHelper.AnonymousClass2(systemAlarmDispatcher, intent, i, 2));
        if (!systemAlarmDispatcher.mProcessor.isEnqueued(str)) {
            Logger$LogcatLogger.get().debug(str2, "Processor does not have WorkSpec " + str + ". No need to reschedule");
            return;
        }
        Logger$LogcatLogger.get().debug(str2, "WorkSpec " + str + " needs to be rescheduled");
        Intent intent2 = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent2.setAction("ACTION_SCHEDULE_WORK");
        CommandHandler.writeWorkGenerationalId(intent2, workGenerationalId);
        highPriorityExecutor.execute(new AppCompatTextHelper.AnonymousClass2(systemAlarmDispatcher, intent2, i, 2));
    }

    /* JADX INFO: renamed from: $r8$lambda$r8ATJco-vysxdAeSwS9XE6krknU, reason: not valid java name */
    public static void m772$r8$lambda$r8ATJcovysxdAeSwS9XE6krknU(DelayMetCommandHandler delayMetCommandHandler) {
        if (delayMetCommandHandler.mCurrentState != 0) {
            Logger$LogcatLogger.get().debug(TAG, "Already started work for " + delayMetCommandHandler.mWorkGenerationalId);
            return;
        }
        delayMetCommandHandler.mCurrentState = 1;
        Logger$LogcatLogger.get().debug(TAG, "onAllConstraintsMet for " + delayMetCommandHandler.mWorkGenerationalId);
        if (!delayMetCommandHandler.mDispatcher.mProcessor.startWork(delayMetCommandHandler.mToken, null)) {
            delayMetCommandHandler.cleanUp();
            return;
        }
        WorkTimer workTimer = delayMetCommandHandler.mDispatcher.mWorkTimer;
        WorkGenerationalId workGenerationalId = delayMetCommandHandler.mWorkGenerationalId;
        synchronized (workTimer.mLock) {
            Logger$LogcatLogger.get().debug(WorkTimer.TAG, "Starting timer for " + workGenerationalId);
            workTimer.stopTimer(workGenerationalId);
            WorkTimer.WorkTimerRunnable workTimerRunnable = new WorkTimer.WorkTimerRunnable(workTimer, workGenerationalId);
            workTimer.mTimerMap.put(workGenerationalId, workTimerRunnable);
            workTimer.mListeners.put(workGenerationalId, delayMetCommandHandler);
            ((Handler) workTimer.mRunnableScheduler.editor).postDelayed(workTimerRunnable, 600000L);
        }
    }

    public DelayMetCommandHandler(Context context, int i, SystemAlarmDispatcher systemAlarmDispatcher, StartStopToken startStopToken) {
        this.mContext = context;
        this.mStartId = i;
        this.mDispatcher = systemAlarmDispatcher;
        this.mWorkGenerationalId = startStopToken.id;
        this.mToken = startStopToken;
        Trackers trackers = systemAlarmDispatcher.mWorkManager.mTrackers;
        WorkManagerTaskExecutor workManagerTaskExecutor = systemAlarmDispatcher.mTaskExecutor;
        this.mSerialExecutor = workManagerTaskExecutor.mBackgroundExecutor;
        this.mMainThreadExecutor = workManagerTaskExecutor.mMainThreadExecutor;
        this.mCoroutineDispatcher = workManagerTaskExecutor.mTaskDispatcher;
        this.mWorkConstraintsTracker = new EmptyStrongMemoryCache(trackers);
        this.mHasConstraints = false;
        this.mCurrentState = 0;
        this.mLock = new Object();
    }

    public final void cleanUp() {
        synchronized (this.mLock) {
            try {
                if (this.mJob != null) {
                    this.mJob.cancel((CancellationException) null);
                }
                this.mDispatcher.mWorkTimer.stopTimer(this.mWorkGenerationalId);
                PowerManager.WakeLock wakeLock = this.mWakeLock;
                if (wakeLock != null && wakeLock.isHeld()) {
                    Logger$LogcatLogger.get().debug(TAG, "Releasing wakelock " + this.mWakeLock + "for WorkSpec " + this.mWorkGenerationalId);
                    this.mWakeLock.release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void handleProcessWork() {
        String str = this.mWorkGenerationalId.workSpecId;
        this.mWakeLock = WakeLocks.newWakeLock(this.mContext, str + " (" + this.mStartId + ")");
        Logger$LogcatLogger logger$LogcatLogger = Logger$LogcatLogger.get();
        String str2 = TAG;
        logger$LogcatLogger.debug(str2, "Acquiring wakelock " + this.mWakeLock + "for WorkSpec " + str);
        this.mWakeLock.acquire();
        WorkSpec workSpec = this.mDispatcher.mWorkManager.mWorkDatabase.workSpecDao().getWorkSpec(str);
        if (workSpec == null) {
            this.mSerialExecutor.execute(new DelayMetCommandHandler$$ExternalSyntheticLambda0(this, 0));
            return;
        }
        boolean zHasConstraints = workSpec.hasConstraints();
        this.mHasConstraints = zHasConstraints;
        if (zHasConstraints) {
            this.mJob = WorkConstraintsTrackerKt.listen(this.mWorkConstraintsTracker, workSpec, this.mCoroutineDispatcher, this);
            return;
        }
        Logger$LogcatLogger.get().debug(str2, "No constraints for " + str);
        this.mSerialExecutor.execute(new DelayMetCommandHandler$$ExternalSyntheticLambda0(this, 1));
    }

    @Override // androidx.work.impl.constraints.OnConstraintsStateChangedListener
    public final void onConstraintsStateChanged(WorkSpec workSpec, ConstraintsState constraintsState) {
        boolean z = constraintsState instanceof ConstraintsState.ConstraintsMet;
        TransactionExecutor transactionExecutor = this.mSerialExecutor;
        if (z) {
            transactionExecutor.execute(new DelayMetCommandHandler$$ExternalSyntheticLambda0(this, 1));
        } else {
            transactionExecutor.execute(new DelayMetCommandHandler$$ExternalSyntheticLambda0(this, 0));
        }
    }

    public final void onExecuted(boolean z) {
        Logger$LogcatLogger logger$LogcatLogger = Logger$LogcatLogger.get();
        StringBuilder sb = new StringBuilder("onExecuted ");
        WorkGenerationalId workGenerationalId = this.mWorkGenerationalId;
        sb.append(workGenerationalId);
        sb.append(", ");
        sb.append(z);
        logger$LogcatLogger.debug(TAG, sb.toString());
        cleanUp();
        int i = this.mStartId;
        SystemAlarmDispatcher systemAlarmDispatcher = this.mDispatcher;
        HighPriorityExecutor highPriorityExecutor = this.mMainThreadExecutor;
        Context context = this.mContext;
        if (z) {
            Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
            intent.setAction("ACTION_SCHEDULE_WORK");
            CommandHandler.writeWorkGenerationalId(intent, workGenerationalId);
            highPriorityExecutor.execute(new AppCompatTextHelper.AnonymousClass2(systemAlarmDispatcher, intent, i, 2));
        }
        if (this.mHasConstraints) {
            Intent intent2 = new Intent(context, (Class<?>) SystemAlarmService.class);
            intent2.setAction("ACTION_CONSTRAINTS_CHANGED");
            highPriorityExecutor.execute(new AppCompatTextHelper.AnonymousClass2(systemAlarmDispatcher, intent2, i, 2));
        }
    }
}
