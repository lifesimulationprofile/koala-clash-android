package androidx.room;

import androidx.camera.core.Preview$$ExternalSyntheticLambda1;
import androidx.work.Worker;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import kotlin.Unit;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class TransactionExecutor implements Executor {
    public final /* synthetic */ int $r8$classId;
    public Runnable active;
    public final Executor executor;
    public final Object syncLock;
    public final ArrayDeque tasks;

    public TransactionExecutor(Executor executor, int i) {
        this.$r8$classId = i;
        switch (i) {
            case 1:
                this.executor = executor;
                this.tasks = new ArrayDeque();
                this.syncLock = new Object();
                break;
            default:
                this.executor = executor;
                this.tasks = new ArrayDeque();
                this.syncLock = new Object();
                break;
        }
    }

    private final void execute$androidx$room$TransactionExecutor(Runnable runnable) {
        synchronized (this.syncLock) {
            try {
                this.tasks.offer(new Preview$$ExternalSyntheticLambda1(26, runnable, this));
                if (this.active == null) {
                    scheduleNext();
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.$r8$classId) {
            case 0:
                execute$androidx$room$TransactionExecutor(runnable);
                return;
            default:
                synchronized (this.syncLock) {
                    try {
                        this.tasks.add(new Worker.AnonymousClass2(13, this, runnable));
                        if (this.active == null) {
                            scheduleNext();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return;
        }
    }

    public boolean hasPendingTasks() {
        boolean z;
        synchronized (this.syncLock) {
            z = !this.tasks.isEmpty();
        }
        return z;
    }

    public final void scheduleNext() {
        switch (this.$r8$classId) {
            case 0:
                synchronized (this.syncLock) {
                    try {
                        Object objPoll = this.tasks.poll();
                        Runnable runnable = (Runnable) objPoll;
                        this.active = runnable;
                        if (objPoll != null) {
                            this.executor.execute(runnable);
                        }
                        Unit unit = Unit.INSTANCE;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
            default:
                Runnable runnable2 = (Runnable) this.tasks.poll();
                this.active = runnable2;
                if (runnable2 != null) {
                    this.executor.execute(runnable2);
                    return;
                }
                return;
        }
    }
}
