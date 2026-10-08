package kotlin.coroutines.jvm.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.InlineList;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ContinuationImpl extends BaseContinuationImpl {
    public final CoroutineContext _context;
    public transient Continuation intercepted;

    public ContinuationImpl(Continuation continuation, CoroutineContext coroutineContext) {
        super(continuation);
        this._context = coroutineContext;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this._context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public void releaseIntercepted() {
        Continuation continuation = this.intercepted;
        if (continuation != null && continuation != this) {
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = DispatchedContinuation._reusableCancellableContinuation$volatile$FU;
            while (atomicReferenceFieldUpdater.get(dispatchedContinuation) == InlineList.REUSABLE_CLAIMED) {
            }
            Object obj = atomicReferenceFieldUpdater.get(dispatchedContinuation);
            CancellableContinuationImpl cancellableContinuationImpl = obj instanceof CancellableContinuationImpl ? (CancellableContinuationImpl) obj : null;
            if (cancellableContinuationImpl != null) {
                cancellableContinuationImpl.detachChild$kotlinx_coroutines_core();
            }
        }
        this.intercepted = CompletedContinuation.INSTANCE;
    }

    public ContinuationImpl(Continuation continuation) {
        this(continuation, continuation != null ? continuation.getContext() : null);
    }
}
