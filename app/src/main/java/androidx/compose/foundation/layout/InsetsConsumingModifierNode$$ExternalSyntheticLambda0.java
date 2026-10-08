package androidx.compose.foundation.layout;

import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNode$Companion$TraverseDescendantsAction;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class InsetsConsumingModifierNode$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ InsetsConsumingModifierNode f$0;

    public /* synthetic */ InsetsConsumingModifierNode$$ExternalSyntheticLambda0(InsetsConsumingModifierNode insetsConsumingModifierNode, int i) {
        this.$r8$classId = i;
        this.f$0 = insetsConsumingModifierNode;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        TraversableNode traversableNode = (TraversableNode) obj;
        switch (this.$r8$classId) {
            case 0:
                InsetsConsumingModifierNode insetsConsumingModifierNode = (InsetsConsumingModifierNode) traversableNode;
                WindowInsets windowInsets = this.f$0.consumedInsets;
                if (!Intrinsics.areEqual(insetsConsumingModifierNode.ancestorConsumedInsets, windowInsets)) {
                    insetsConsumingModifierNode.ancestorConsumedInsets = windowInsets;
                    insetsConsumingModifierNode.insetsInvalidated();
                }
                return TraversableNode$Companion$TraverseDescendantsAction.SkipSubtreeAndContinueTraversal;
            default:
                this.f$0.ancestorConsumedInsets = ((InsetsConsumingModifierNode) traversableNode).consumedInsets;
                return Boolean.FALSE;
        }
    }
}
