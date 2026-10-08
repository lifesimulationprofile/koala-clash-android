package androidx.work.impl.background.greedy;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import androidx.work.Configuration;
import androidx.work.Constraints;
import androidx.work.Logger$LogcatLogger;
import androidx.work.Worker;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Processor;
import androidx.work.impl.Scheduler;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.StartStopTokens;
import androidx.work.impl.WorkLauncherImpl;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.OnConstraintsStateChangedListener;
import androidx.work.impl.constraints.WorkConstraintsTrackerKt;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.ProcessUtils;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import coil.disk.RealDiskCache;
import coil.memory.EmptyStrongMemoryCache;
import java.util.HashMap;
import java.util.HashSet;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class GreedyScheduler implements Scheduler, OnConstraintsStateChangedListener, ExecutionListener {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("GreedyScheduler");
    public final Configuration mConfiguration;
    public final EmptyStrongMemoryCache mConstraintsTracker;
    public final Context mContext;
    public final DelayedWorkTracker mDelayedWorkTracker;
    public Boolean mInDefaultProcess;
    public final Processor mProcessor;
    public boolean mRegisteredExecutionListener;
    public final WorkManagerTaskExecutor mTaskExecutor;
    public final TimeLimiter mTimeLimiter;
    public final WorkLauncherImpl mWorkLauncher;
    public final HashMap mConstrainedWorkSpecs = new HashMap();
    public final Object mLock = new Object();
    public final StartStopTokens mStartStopTokens = new StartStopTokens(0);
    public final HashMap mFirstRunAttempts = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class AttemptData {
        public final int mRunAttemptCount;
        public final long mTimeStamp;

        public AttemptData(int i, long j) {
            this.mRunAttemptCount = i;
            this.mTimeStamp = j;
        }
    }

    public GreedyScheduler(Context context, Configuration configuration, Trackers trackers, Processor processor, WorkLauncherImpl workLauncherImpl, WorkManagerTaskExecutor workManagerTaskExecutor) {
        this.mContext = context;
        RealDiskCache.RealEditor realEditor = configuration.runnableScheduler;
        this.mDelayedWorkTracker = new DelayedWorkTracker(this, realEditor, configuration.clock);
        this.mTimeLimiter = new TimeLimiter(realEditor, workLauncherImpl);
        this.mTaskExecutor = workManagerTaskExecutor;
        this.mConstraintsTracker = new EmptyStrongMemoryCache(trackers);
        this.mConfiguration = configuration;
        this.mProcessor = processor;
        this.mWorkLauncher = workLauncherImpl;
    }

    @Override // androidx.work.impl.Scheduler
    public final void cancel(String str) {
        Runnable runnable;
        if (this.mInDefaultProcess == null) {
            this.mInDefaultProcess = Boolean.valueOf(ProcessUtils.isDefaultProcess(this.mContext));
        }
        boolean zBooleanValue = this.mInDefaultProcess.booleanValue();
        String str2 = TAG;
        if (!zBooleanValue) {
            Logger$LogcatLogger.get().info(str2, "Ignoring schedule request in non-main process");
            return;
        }
        if (!this.mRegisteredExecutionListener) {
            this.mProcessor.addExecutionListener(this);
            this.mRegisteredExecutionListener = true;
        }
        Logger$LogcatLogger.get().debug(str2, "Cancelling work ID " + str);
        DelayedWorkTracker delayedWorkTracker = this.mDelayedWorkTracker;
        if (delayedWorkTracker != null && (runnable = (Runnable) delayedWorkTracker.mRunnables.remove(str)) != null) {
            ((Handler) delayedWorkTracker.mRunnableScheduler.editor).removeCallbacks(runnable);
        }
        for (StartStopToken startStopToken : this.mStartStopTokens.remove(str)) {
            this.mTimeLimiter.cancel(startStopToken);
            this.mWorkLauncher.stopWork(startStopToken, -512);
        }
    }

    @Override // androidx.work.impl.Scheduler
    public final boolean hasLimitedSchedulingSlots() {
        return false;
    }

    @Override // androidx.work.impl.constraints.OnConstraintsStateChangedListener
    public final void onConstraintsStateChanged(WorkSpec workSpec, ConstraintsState constraintsState) {
        WorkGenerationalId workGenerationalIdGenerationalId = WorkSpecKt.generationalId(workSpec);
        boolean z = constraintsState instanceof ConstraintsState.ConstraintsMet;
        WorkLauncherImpl workLauncherImpl = this.mWorkLauncher;
        TimeLimiter timeLimiter = this.mTimeLimiter;
        String str = TAG;
        StartStopTokens startStopTokens = this.mStartStopTokens;
        if (z) {
            if (startStopTokens.contains(workGenerationalIdGenerationalId)) {
                return;
            }
            Logger$LogcatLogger.get().debug(str, "Constraints met: Scheduling work ID " + workGenerationalIdGenerationalId);
            StartStopToken startStopToken = startStopTokens.tokenFor(workGenerationalIdGenerationalId);
            timeLimiter.track(startStopToken);
            workLauncherImpl.startWork(startStopToken, null);
            return;
        }
        Logger$LogcatLogger.get().debug(str, "Constraints not met: Cancelling work ID " + workGenerationalIdGenerationalId);
        StartStopToken startStopTokenRemove = startStopTokens.remove(workGenerationalIdGenerationalId);
        if (startStopTokenRemove != null) {
            timeLimiter.cancel(startStopTokenRemove);
            workLauncherImpl.stopWork(startStopTokenRemove, ((ConstraintsState.ConstraintsNotMet) constraintsState).reason);
        }
    }

    @Override // androidx.work.impl.ExecutionListener
    public final void onExecuted(WorkGenerationalId workGenerationalId, boolean z) {
        StartStopToken startStopTokenRemove = this.mStartStopTokens.remove(workGenerationalId);
        if (startStopTokenRemove != null) {
            this.mTimeLimiter.cancel(startStopTokenRemove);
        }
        removeConstraintTrackingFor(workGenerationalId);
        if (z) {
            return;
        }
        synchronized (this.mLock) {
            this.mFirstRunAttempts.remove(workGenerationalId);
        }
    }

    public final void removeConstraintTrackingFor(WorkGenerationalId workGenerationalId) {
        Job job;
        synchronized (this.mLock) {
            job = (Job) this.mConstrainedWorkSpecs.remove(workGenerationalId);
        }
        if (job != null) {
            Logger$LogcatLogger.get().debug(TAG, "Stopping tracking for " + workGenerationalId);
            job.cancel(null);
        }
    }

    @Override // androidx.work.impl.Scheduler
    public final void schedule(WorkSpec... workSpecArr) {
        if (this.mInDefaultProcess == null) {
            this.mInDefaultProcess = Boolean.valueOf(ProcessUtils.isDefaultProcess(this.mContext));
        }
        if (!this.mInDefaultProcess.booleanValue()) {
            Logger$LogcatLogger.get().info(TAG, "Ignoring schedule request in a secondary process");
            return;
        }
        if (!this.mRegisteredExecutionListener) {
            this.mProcessor.addExecutionListener(this);
            this.mRegisteredExecutionListener = true;
        }
        HashSet<WorkSpec> hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (WorkSpec workSpec : workSpecArr) {
            if (!this.mStartStopTokens.contains(WorkSpecKt.generationalId(workSpec))) {
                long jMax = Math.max(workSpec.calculateNextRunTime(), throttleIfNeeded(workSpec));
                this.mConfiguration.clock.getClass();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (workSpec.state == 1) {
                    if (jCurrentTimeMillis < jMax) {
                        DelayedWorkTracker delayedWorkTracker = this.mDelayedWorkTracker;
                        if (delayedWorkTracker != null) {
                            RealDiskCache.RealEditor realEditor = delayedWorkTracker.mRunnableScheduler;
                            HashMap map = delayedWorkTracker.mRunnables;
                            Runnable runnable = (Runnable) map.remove(workSpec.id);
                            if (runnable != null) {
                                ((Handler) realEditor.editor).removeCallbacks(runnable);
                            }
                            Worker.AnonymousClass2 anonymousClass2 = new Worker.AnonymousClass2(11, delayedWorkTracker, workSpec, false);
                            map.put(workSpec.id, anonymousClass2);
                            delayedWorkTracker.mClock.getClass();
                            ((Handler) realEditor.editor).postDelayed(anonymousClass2, jMax - System.currentTimeMillis());
                        }
                    } else if (workSpec.hasConstraints()) {
                        int i = Build.VERSION.SDK_INT;
                        Constraints constraints = workSpec.constraints;
                        if (constraints.requiresDeviceIdle) {
                            Logger$LogcatLogger.get().debug(TAG, "Ignoring " + workSpec + ". Requires device idle.");
                        } else if (i < 24 || !constraints.hasContentUriTriggers()) {
                            hashSet.add(workSpec);
                            hashSet2.add(workSpec.id);
                        } else {
                            Logger$LogcatLogger.get().debug(TAG, "Ignoring " + workSpec + ". Requires ContentUri triggers.");
                        }
                    } else if (!this.mStartStopTokens.contains(WorkSpecKt.generationalId(workSpec))) {
                        Logger$LogcatLogger.get().debug(TAG, "Starting work for " + workSpec.id);
                        StartStopToken startStopToken = this.mStartStopTokens.tokenFor(WorkSpecKt.generationalId(workSpec));
                        this.mTimeLimiter.track(startStopToken);
                        this.mWorkLauncher.startWork(startStopToken, null);
                    }
                }
            }
        }
        synchronized (this.mLock) {
            try {
                if (!hashSet.isEmpty()) {
                    Logger$LogcatLogger.get().debug(TAG, "Starting tracking for " + TextUtils.join(",", hashSet2));
                    for (WorkSpec workSpec2 : hashSet) {
                        WorkGenerationalId workGenerationalIdGenerationalId = WorkSpecKt.generationalId(workSpec2);
                        if (!this.mConstrainedWorkSpecs.containsKey(workGenerationalIdGenerationalId)) {
                            this.mConstrainedWorkSpecs.put(workGenerationalIdGenerationalId, WorkConstraintsTrackerKt.listen(this.mConstraintsTracker, workSpec2, this.mTaskExecutor.mTaskDispatcher, this));
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final long throttleIfNeeded(WorkSpec workSpec) {
        long jMax;
        synchronized (this.mLock) {
            try {
                WorkGenerationalId workGenerationalIdGenerationalId = WorkSpecKt.generationalId(workSpec);
                AttemptData attemptData = (AttemptData) this.mFirstRunAttempts.get(workGenerationalIdGenerationalId);
                if (attemptData == null) {
                    int i = workSpec.runAttemptCount;
                    this.mConfiguration.clock.getClass();
                    attemptData = new AttemptData(i, System.currentTimeMillis());
                    this.mFirstRunAttempts.put(workGenerationalIdGenerationalId, attemptData);
                }
                jMax = (((long) Math.max((workSpec.runAttemptCount - attemptData.mRunAttemptCount) - 5, 0)) * 30000) + attemptData.mTimeStamp;
            } catch (Throwable th) {
                throw th;
            }
        }
        return jMax;
    }
}
