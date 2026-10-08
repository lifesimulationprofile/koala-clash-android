package androidx.camera.core.impl.utils.executor;

import android.util.Log;
import androidx.work.Worker;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class SequentialExecutor implements Executor {
    public final Executor mExecutor;
    public final ArrayDeque mQueue = new ArrayDeque();
    public final Worker.AnonymousClass1 mWorker = new Worker.AnonymousClass1(6, this);
    public int mWorkerRunningState = 1;
    public long mWorkerRunCount = 0;

    /* JADX INFO: renamed from: androidx.camera.core.impl.utils.executor.SequentialExecutor$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class AnonymousClass1 implements Runnable {
        public final /* synthetic */ int $r8$classId;
        public final Runnable val$task;

        public /* synthetic */ AnonymousClass1(Runnable runnable, int i) {
            this.$r8$classId = i;
            this.val$task = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            switch (this.$r8$classId) {
                case 0:
                    this.val$task.run();
                    break;
                default:
                    try {
                        this.val$task.run();
                    } catch (Exception e) {
                        Log.e("TransportRuntime.".concat("Executor"), "Background execution failure.", e);
                        return;
                    }
                    break;
            }
        }
    }

    public SequentialExecutor(Executor executor) {
        executor.getClass();
        this.mExecutor = executor;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.getClass();
        synchronized (this.mQueue) {
            int i = this.mWorkerRunningState;
            if (i != 4 && i != 3) {
                long j = this.mWorkerRunCount;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(runnable, 0);
                this.mQueue.add(anonymousClass1);
                this.mWorkerRunningState = 2;
                try {
                    this.mExecutor.execute(this.mWorker);
                    if (this.mWorkerRunningState != 2) {
                        return;
                    }
                    synchronized (this.mQueue) {
                        try {
                            if (this.mWorkerRunCount == j && this.mWorkerRunningState == 2) {
                                this.mWorkerRunningState = 3;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return;
                } catch (Error | RuntimeException e) {
                    synchronized (this.mQueue) {
                        try {
                            int i2 = this.mWorkerRunningState;
                            boolean z = true;
                            if ((i2 != 1 && i2 != 2) || !this.mQueue.removeLastOccurrence(anonymousClass1)) {
                                z = false;
                            }
                            if (!(e instanceof RejectedExecutionException) || z) {
                                throw e;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    return;
                }
            }
            this.mQueue.add(runnable);
        }
    }
}
