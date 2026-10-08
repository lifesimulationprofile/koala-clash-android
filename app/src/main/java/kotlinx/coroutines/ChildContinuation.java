package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ChildContinuation extends JobNode {
    public final /* synthetic */ int $r8$classId;
    public final CancellableContinuationImpl child;

    public /* synthetic */ ChildContinuation(CancellableContinuationImpl cancellableContinuationImpl, int i) {
        this.$r8$classId = i;
        this.child = cancellableContinuationImpl;
    }

    @Override // kotlinx.coroutines.JobNode
    public final boolean getOnCancelling() {
        switch (this.$r8$classId) {
            case 0:
                return true;
            default:
                return false;
        }
    }

    @Override // kotlinx.coroutines.JobNode
    public final void invoke(Throwable th) {
        switch (this.$r8$classId) {
            case 0:
                JobSupport job = getJob();
                CancellableContinuationImpl cancellableContinuationImpl = this.child;
                Throwable continuationCancellationCause = cancellableContinuationImpl.getContinuationCancellationCause(job);
                if (cancellableContinuationImpl.isReusable()) {
                    DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) cancellableContinuationImpl.delegate;
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = DispatchedContinuation._reusableCancellableContinuation$volatile$FU;
                    while (true) {
                        Object obj = atomicReferenceFieldUpdater.get(dispatchedContinuation);
                        Symbol symbol = InlineList.REUSABLE_CLAIMED;
                        if (Intrinsics.areEqual(obj, symbol)) {
                            while (!atomicReferenceFieldUpdater.compareAndSet(dispatchedContinuation, symbol, continuationCancellationCause)) {
                                if (atomicReferenceFieldUpdater.get(dispatchedContinuation) != symbol) {
                                }
                            }
                            break;
                        } else if (obj instanceof Throwable) {
                            break;
                        } else {
                            while (true) {
                                if (!atomicReferenceFieldUpdater.compareAndSet(dispatchedContinuation, obj, null)) {
                                    if (atomicReferenceFieldUpdater.get(dispatchedContinuation) != obj) {
                                    }
                                }
                            }
                        }
                    }
                }
                cancellableContinuationImpl.cancel(continuationCancellationCause);
                if (!cancellableContinuationImpl.isReusable()) {
                    cancellableContinuationImpl.detachChild$kotlinx_coroutines_core();
                }
                break;
            default:
                this.child.resumeWith(Unit.INSTANCE);
                break;
        }
    }
}
