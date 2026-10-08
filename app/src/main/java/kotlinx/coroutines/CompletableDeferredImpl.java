package kotlinx.coroutines;

import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.selects.SelectClause1;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class CompletableDeferredImpl extends JobSupport implements CompletableDeferred {
    @Override // kotlinx.coroutines.CompletableDeferred
    public final boolean completeExceptionally(Throwable th) {
        return makeCompleting$kotlinx_coroutines_core(new CompletedExceptionally(th, false));
    }

    @Override // kotlinx.coroutines.CompletableDeferred
    public final Object getCompleted() throws Throwable {
        Object obj = JobSupport._state$volatile$FU.get(this);
        if (obj instanceof Incomplete) {
            throw new IllegalStateException("This job has not completed yet");
        }
        if (obj instanceof CompletedExceptionally) {
            throw ((CompletedExceptionally) obj).cause;
        }
        return JobKt.unboxState(obj);
    }

    @Override // kotlinx.coroutines.CompletableDeferred
    public final SelectClause1 getOnAwait() {
        JobSupport$onAwaitInternal$1 jobSupport$onAwaitInternal$1 = JobSupport$onAwaitInternal$1.INSTANCE;
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(3, jobSupport$onAwaitInternal$1);
        JobSupport$onAwaitInternal$2 jobSupport$onAwaitInternal$2 = JobSupport$onAwaitInternal$2.INSTANCE;
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(3, jobSupport$onAwaitInternal$2);
        return new Request.Builder(this, jobSupport$onAwaitInternal$1, jobSupport$onAwaitInternal$2, null);
    }
}
