package androidx.compose.material3.internal;

import androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDragScope$1;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.lazy.LazyListScrollScopeKt$LazyLayoutScrollScope$1;
import androidx.work.impl.StartStopTokens;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref$FloatRef;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class MaterialAnchoredDraggableState$anchoredDrag$4 extends SuspendLambda implements Function3 {
    public final /* synthetic */ Ref$FloatRef $consumedVelocity;
    public final /* synthetic */ FlingBehavior $flingBehavior;
    public final /* synthetic */ float $initialVelocity;
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ StartStopTokens this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaterialAnchoredDraggableState$anchoredDrag$4(Ref$FloatRef ref$FloatRef, FlingBehavior flingBehavior, StartStopTokens startStopTokens, float f, Continuation continuation) {
        super(3, continuation);
        this.$consumedVelocity = ref$FloatRef;
        this.$flingBehavior = flingBehavior;
        this.this$0 = startStopTokens;
        this.$initialVelocity = f;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        StartStopTokens startStopTokens = this.this$0;
        float f = this.$initialVelocity;
        MaterialAnchoredDraggableState$anchoredDrag$4 materialAnchoredDraggableState$anchoredDrag$4 = new MaterialAnchoredDraggableState$anchoredDrag$4(this.$consumedVelocity, this.$flingBehavior, startStopTokens, f, (Continuation) obj3);
        materialAnchoredDraggableState$anchoredDrag$4.L$0 = (AnchoredDraggableState$anchoredDragScope$1) obj;
        return materialAnchoredDraggableState$anchoredDrag$4.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Ref$FloatRef ref$FloatRef;
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LazyListScrollScopeKt$LazyLayoutScrollScope$1 lazyListScrollScopeKt$LazyLayoutScrollScope$1 = new LazyListScrollScopeKt$LazyLayoutScrollScope$1(3, this.this$0, (AnchoredDraggableState$anchoredDragScope$1) this.L$0);
            Ref$FloatRef ref$FloatRef2 = this.$consumedVelocity;
            this.L$0 = ref$FloatRef2;
            this.label = 1;
            Object objPerformFling = this.$flingBehavior.performFling(lazyListScrollScopeKt$LazyLayoutScrollScope$1, this.$initialVelocity, this);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objPerformFling == coroutineSingletons) {
                return coroutineSingletons;
            }
            ref$FloatRef = ref$FloatRef2;
            obj = objPerformFling;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ref$FloatRef = (Ref$FloatRef) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        ref$FloatRef.element = ((Number) obj).floatValue();
        return Unit.INSTANCE;
    }
}
