package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.flow.internal.ChildCancelledException;
import kotlinx.coroutines.internal.ScopeCoroutine;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class SupervisorCoroutine extends ScopeCoroutine {
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SupervisorCoroutine(CoroutineContext coroutineContext, Continuation continuation, int i) {
        super(continuation, coroutineContext);
        this.$r8$classId = i;
    }

    @Override // kotlinx.coroutines.JobSupport
    public final boolean childCancelled(Throwable th) {
        switch (this.$r8$classId) {
            case 0:
                return false;
            default:
                if (th instanceof ChildCancelledException) {
                    return true;
                }
                return cancelImpl$kotlinx_coroutines_core(th);
        }
    }
}
