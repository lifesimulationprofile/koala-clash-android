package androidx.compose.foundation.interaction;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlowImpl;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class MutableInteractionSourceImpl {
    public final SharedFlowImpl interactions = FlowKt.MutableSharedFlow$default(2, 1);

    public final Object emit(Interaction interaction, Continuation continuation) throws Throwable {
        Object objEmit = this.interactions.emit(interaction, continuation);
        return objEmit == CoroutineSingletons.COROUTINE_SUSPENDED ? objEmit : Unit.INSTANCE;
    }

    public final void tryEmit(Interaction interaction) {
        this.interactions.tryEmit(interaction);
    }
}
