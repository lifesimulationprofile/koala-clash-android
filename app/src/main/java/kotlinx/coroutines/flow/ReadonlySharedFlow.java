package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.flow.internal.FusibleFlow;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ReadonlySharedFlow implements SharedFlow, Flow, FusibleFlow {
    public final /* synthetic */ SharedFlowImpl $$delegate_0;

    public ReadonlySharedFlow(SharedFlowImpl sharedFlowImpl) {
        this.$$delegate_0 = sharedFlowImpl;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector flowCollector, Continuation continuation) throws Throwable {
        this.$$delegate_0.collect(flowCollector, continuation);
        return CoroutineSingletons.COROUTINE_SUSPENDED;
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public final Flow fuse(CoroutineContext coroutineContext, int i, int i2) {
        return FlowKt.fuseSharedFlow(this, coroutineContext, i, i2);
    }
}
