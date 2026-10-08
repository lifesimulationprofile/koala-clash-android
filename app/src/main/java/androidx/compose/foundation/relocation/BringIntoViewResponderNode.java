package androidx.compose.foundation.relocation;

import androidx.compose.foundation.gestures.ContentInViewNode;
import androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda0;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.relocation.BringIntoViewModifierNode;
import androidx.navigation.compose.DialogHostKt$DialogHost$1$1$1;
import androidx.navigation.compose.NavHostKt$NavHost$33$1;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class BringIntoViewResponderNode extends Modifier.Node implements BringIntoViewModifierNode, LayoutAwareModifierNode {
    public boolean hasBeenPlaced;
    public ContentInViewNode responder;

    public static final Rect bringIntoView$localRect(BringIntoViewResponderNode bringIntoViewResponderNode, NodeCoordinator nodeCoordinator, DialogHostKt$DialogHost$1$1$1 dialogHostKt$DialogHost$1$1$1) {
        Rect rect;
        if (bringIntoViewResponderNode.isAttached && bringIntoViewResponderNode.hasBeenPlaced) {
            NodeCoordinator nodeCoordinatorRequireLayoutCoordinates = HitTestResultKt.requireLayoutCoordinates(bringIntoViewResponderNode);
            if (!nodeCoordinator.getTail().isAttached) {
                nodeCoordinator = null;
            }
            if (nodeCoordinator != null && (rect = (Rect) dialogHostKt$DialogHost$1$1$1.invoke()) != null) {
                return rect.m379translatek4lQ0M(nodeCoordinatorRequireLayoutCoordinates.localBoundingBoxOf(nodeCoordinator, false).m378getTopLeftF1C5BW0());
            }
        }
        return null;
    }

    @Override // androidx.compose.ui.relocation.BringIntoViewModifierNode
    public final Object bringIntoView(NodeCoordinator nodeCoordinator, DialogHostKt$DialogHost$1$1$1 dialogHostKt$DialogHost$1$1$1, ContinuationImpl continuationImpl) {
        Object objCoroutineScope = JobKt.coroutineScope(new NavHostKt$NavHost$33$1(this, nodeCoordinator, dialogHostKt$DialogHost$1$1$1, new GapComposer$$ExternalSyntheticLambda0(this, nodeCoordinator, dialogHostKt$DialogHost$1$1$1, 3), null), continuationImpl);
        return objCoroutineScope == CoroutineSingletons.COROUTINE_SUSPENDED ? objCoroutineScope : Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    public final void onPlaced(LayoutCoordinates layoutCoordinates) {
        this.hasBeenPlaced = true;
    }

    @Override // androidx.compose.ui.node.MeasuredSizeAwareModifierNode
    /* JADX INFO: renamed from: onRemeasured-ozmzZPI */
    public final /* synthetic */ void mo63onRemeasuredozmzZPI(long j) {
    }
}
