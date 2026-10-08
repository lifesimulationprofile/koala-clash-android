package androidx.compose.animation.core;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Transition$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Transition f$0;

    public /* synthetic */ Transition$$ExternalSyntheticLambda0(Transition transition, int i) {
        this.$r8$classId = i;
        this.f$0 = transition;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                Transition transition = this.f$0;
                return Boolean.valueOf((Intrinsics.areEqual(transition.targetState$delegate.getValue(), transition.transitionState.mo767getCurrentState()) && transition.startTimeNanos$delegate.getLongValue() == Long.MIN_VALUE && !((Boolean) transition.updateChildrenNeeded$delegate.getValue()).booleanValue()) ? false : true);
            default:
                return Long.valueOf(this.f$0.calculateTotalDurationNanos());
        }
    }
}
