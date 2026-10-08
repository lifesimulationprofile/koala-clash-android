package androidx.compose.foundation;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.runtime.DynamicProvidableCompositionLocal;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.HitTestResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AbstractClickableNode$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ AbstractClickableNode f$0;

    public /* synthetic */ AbstractClickableNode$$ExternalSyntheticLambda0(AbstractClickableNode abstractClickableNode, int i) {
        this.$r8$classId = i;
        this.f$0 = abstractClickableNode;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        DelegatableNode delegatableNode;
        switch (this.$r8$classId) {
            case 0:
                DynamicProvidableCompositionLocal dynamicProvidableCompositionLocal = IndicationKt.LocalIndication;
                AbstractClickableNode abstractClickableNode = this.f$0;
                IndicationNodeFactory indicationNodeFactory = (IndicationNodeFactory) HitTestResultKt.currentValueOf(abstractClickableNode, dynamicProvidableCompositionLocal);
                if (indicationNodeFactory == null) {
                    InlineClassHelperKt.throwIllegalArgumentException("clickable only supports IndicationNodeFactory instances provided to LocalIndication, but Indication was provided instead. Either migrate the Indication implementation to implement IndicationNodeFactory, or use the other clickable overload that takes an Indication parameter, and explicitly pass LocalIndication.current there. The Indication instance provided here was: " + indicationNodeFactory);
                }
                IndicationNodeFactory indicationNodeFactory2 = abstractClickableNode.localIndicationNodeFactory;
                abstractClickableNode.localIndicationNodeFactory = indicationNodeFactory;
                if (indicationNodeFactory2 != null && !Intrinsics.areEqual(indicationNodeFactory, indicationNodeFactory2) && ((delegatableNode = abstractClickableNode.indicationNode) != null || !abstractClickableNode.lazilyCreateIndication)) {
                    if (delegatableNode != null) {
                        abstractClickableNode.undelegate(delegatableNode);
                    }
                    abstractClickableNode.indicationNode = null;
                    abstractClickableNode.initializeIndicationAndInteractionSourceIfNeeded();
                }
                return Unit.INSTANCE;
            default:
                this.f$0.onClick.invoke();
                return Boolean.TRUE;
        }
    }
}
