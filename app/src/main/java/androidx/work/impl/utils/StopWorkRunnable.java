package androidx.work.impl.utils;

import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.Processor;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.WorkerWrapper;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class StopWorkRunnable implements Runnable {
    public final Processor processor;
    public final int reason;
    public final boolean stopInForeground;
    public final StartStopToken token;

    public StopWorkRunnable(Processor processor, StartStopToken startStopToken, boolean z, int i) {
        this.processor = processor;
        this.token = startStopToken;
        this.stopInForeground = z;
        this.reason = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zStopWork;
        WorkerWrapper workerWrapperCleanUpWorkerUnsafe;
        if (this.stopInForeground) {
            Processor processor = this.processor;
            StartStopToken startStopToken = this.token;
            int i = this.reason;
            processor.getClass();
            String str = startStopToken.id.workSpecId;
            synchronized (processor.mLock) {
                workerWrapperCleanUpWorkerUnsafe = processor.cleanUpWorkerUnsafe(str);
            }
            zStopWork = Processor.interrupt(str, workerWrapperCleanUpWorkerUnsafe, i);
        } else {
            zStopWork = this.processor.stopWork(this.token, this.reason);
        }
        Logger$LogcatLogger.get().debug(Logger$LogcatLogger.tagWithPrefix("StopWorkRunnable"), "StopWorkRunnable for " + this.token.id.workSpecId + "; Processor.stopWork = " + zStopWork);
    }
}
