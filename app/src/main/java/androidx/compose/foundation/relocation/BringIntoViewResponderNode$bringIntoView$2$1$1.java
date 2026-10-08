package androidx.compose.foundation.relocation;

import androidx.compose.ui.node.NodeCoordinator;
import androidx.navigation.compose.DialogHostKt$DialogHost$1$1$1;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BringIntoViewResponderNode$bringIntoView$2$1$1 extends FunctionReferenceImpl implements Function0 {
    public final /* synthetic */ DialogHostKt$DialogHost$1$1$1 $boundsProvider;
    public final /* synthetic */ NodeCoordinator $childCoordinates;
    public final /* synthetic */ BringIntoViewResponderNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BringIntoViewResponderNode$bringIntoView$2$1$1(BringIntoViewResponderNode bringIntoViewResponderNode, NodeCoordinator nodeCoordinator, DialogHostKt$DialogHost$1$1$1 dialogHostKt$DialogHost$1$1$1) {
        super(0, Intrinsics.Kotlin.class, "localRect", "bringIntoView$localRect(Landroidx/compose/foundation/relocation/BringIntoViewResponderNode;Landroidx/compose/ui/layout/LayoutCoordinates;Lkotlin/jvm/functions/Function0;)Landroidx/compose/ui/geometry/Rect;", 0);
        this.this$0 = bringIntoViewResponderNode;
        this.$childCoordinates = nodeCoordinator;
        this.$boundsProvider = dialogHostKt$DialogHost$1$1$1;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return BringIntoViewResponderNode.bringIntoView$localRect(this.this$0, this.$childCoordinates, this.$boundsProvider);
    }
}
