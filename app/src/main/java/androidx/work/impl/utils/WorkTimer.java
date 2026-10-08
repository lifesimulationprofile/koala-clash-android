package androidx.work.impl.utils;

import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.background.systemalarm.DelayMetCommandHandler;
import androidx.work.impl.background.systemalarm.DelayMetCommandHandler$$ExternalSyntheticLambda0;
import androidx.work.impl.model.WorkGenerationalId;
import coil.disk.RealDiskCache;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class WorkTimer {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("WorkTimer");
    public final RealDiskCache.RealEditor mRunnableScheduler;
    public final HashMap mTimerMap = new HashMap();
    public final HashMap mListeners = new HashMap();
    public final Object mLock = new Object();

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public interface TimeLimitExceededListener {
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class WorkTimerRunnable implements Runnable {
        public final WorkGenerationalId mWorkGenerationalId;
        public final WorkTimer mWorkTimer;

        public WorkTimerRunnable(WorkTimer workTimer, WorkGenerationalId workGenerationalId) {
            this.mWorkTimer = workTimer;
            this.mWorkGenerationalId = workGenerationalId;
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (this.mWorkTimer.mLock) {
                try {
                    if (((WorkTimerRunnable) this.mWorkTimer.mTimerMap.remove(this.mWorkGenerationalId)) != null) {
                        TimeLimitExceededListener timeLimitExceededListener = (TimeLimitExceededListener) this.mWorkTimer.mListeners.remove(this.mWorkGenerationalId);
                        if (timeLimitExceededListener != null) {
                            WorkGenerationalId workGenerationalId = this.mWorkGenerationalId;
                            DelayMetCommandHandler delayMetCommandHandler = (DelayMetCommandHandler) timeLimitExceededListener;
                            Logger$LogcatLogger.get().debug(DelayMetCommandHandler.TAG, "Exceeded time limits on execution for " + workGenerationalId);
                            delayMetCommandHandler.mSerialExecutor.execute(new DelayMetCommandHandler$$ExternalSyntheticLambda0(delayMetCommandHandler, 0));
                        }
                    } else {
                        Logger$LogcatLogger.get().debug("WrkTimerRunnable", "Timer with " + this.mWorkGenerationalId + " is already marked as complete.");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public WorkTimer(RealDiskCache.RealEditor realEditor) {
        this.mRunnableScheduler = realEditor;
    }

    public final void stopTimer(WorkGenerationalId workGenerationalId) {
        synchronized (this.mLock) {
            try {
                if (((WorkTimerRunnable) this.mTimerMap.remove(workGenerationalId)) != null) {
                    Logger$LogcatLogger.get().debug(TAG, "Stopping timer for " + workGenerationalId);
                    this.mListeners.remove(workGenerationalId);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
