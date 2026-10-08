package kotlinx.coroutines.internal;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import com.google.mlkit.common.sdkinternal.zzb;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DefaultExecutorKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.TimeoutCoroutine;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class LimitedDispatcher extends CoroutineDispatcher implements Delay {
    public static final /* synthetic */ AtomicIntegerFieldUpdater runningWorkers$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(LimitedDispatcher.class, "runningWorkers$volatile");
    public final /* synthetic */ Delay $$delegate_0;
    public final CoroutineDispatcher dispatcher;
    public final int parallelism;
    public final LockFreeTaskQueue queue;
    private volatile /* synthetic */ int runningWorkers$volatile;
    public final Object workerAllocationLock;

    /* JADX WARN: Multi-variable type inference failed */
    public LimitedDispatcher(CoroutineDispatcher coroutineDispatcher, int i) {
        Delay delay = coroutineDispatcher instanceof Delay ? (Delay) coroutineDispatcher : null;
        this.$$delegate_0 = delay == null ? DefaultExecutorKt.DefaultDelay : delay;
        this.dispatcher = coroutineDispatcher;
        this.parallelism = i;
        this.queue = new LockFreeTaskQueue();
        this.workerAllocationLock = new Object();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        Runnable runnableObtainTaskOrDeallocateWorker;
        this.queue.addLast(runnable);
        if (runningWorkers$volatile$FU.get(this) >= this.parallelism || !tryAllocateWorker() || (runnableObtainTaskOrDeallocateWorker = obtainTaskOrDeallocateWorker()) == null) {
            return;
        }
        InlineList.safeDispatch(this.dispatcher, this, new zzb(this, runnableObtainTaskOrDeallocateWorker));
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        Runnable runnableObtainTaskOrDeallocateWorker;
        this.queue.addLast(runnable);
        if (runningWorkers$volatile$FU.get(this) >= this.parallelism || !tryAllocateWorker() || (runnableObtainTaskOrDeallocateWorker = obtainTaskOrDeallocateWorker()) == null) {
            return;
        }
        this.dispatcher.dispatchYield(this, new zzb(this, runnableObtainTaskOrDeallocateWorker));
    }

    @Override // kotlinx.coroutines.Delay
    public final DisposableHandle invokeOnTimeout(long j, TimeoutCoroutine timeoutCoroutine, CoroutineContext coroutineContext) {
        return this.$$delegate_0.invokeOnTimeout(j, timeoutCoroutine, coroutineContext);
    }

    public final Runnable obtainTaskOrDeallocateWorker() {
        while (true) {
            Runnable runnable = (Runnable) this.queue.removeFirstOrNull();
            if (runnable != null) {
                return runnable;
            }
            synchronized (this.workerAllocationLock) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = runningWorkers$volatile$FU;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.queue.getSize() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }

    @Override // kotlinx.coroutines.Delay
    public final void scheduleResumeAfterDelay(long j, CancellableContinuationImpl cancellableContinuationImpl) {
        this.$$delegate_0.scheduleResumeAfterDelay(j, cancellableContinuationImpl);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.dispatcher);
        sb.append(".limitedParallelism(");
        return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, this.parallelism, ')');
    }

    public final boolean tryAllocateWorker() {
        synchronized (this.workerAllocationLock) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = runningWorkers$volatile$FU;
            if (atomicIntegerFieldUpdater.get(this) >= this.parallelism) {
                return false;
            }
            atomicIntegerFieldUpdater.incrementAndGet(this);
            return true;
        }
    }
}
