package androidx.compose.ui.draganddrop;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.node.LayoutNodeDrawScope$record$1;
import androidx.compose.ui.node.TraversableNode;
import coil.memory.EmptyStrongMemoryCache;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class DragAndDropNode extends Modifier.Node implements TraversableNode, LayoutAwareModifierNode {
    public DragAndDropNode lastChildDragAndDropModifierNode;
    public long size;
    public DragAndDropNode thisDragAndDropTarget;

    @Override // androidx.compose.ui.node.TraversableNode
    public final Object getTraverseKey() {
        return DragAndDropNode$Companion$DragAndDropTraversableKey.INSTANCE;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        this.thisDragAndDropTarget = null;
        this.lastChildDragAndDropModifierNode = null;
    }

    public final boolean onDrop(EmptyStrongMemoryCache emptyStrongMemoryCache) {
        DragAndDropNode dragAndDropNode = this.lastChildDragAndDropModifierNode;
        if (dragAndDropNode != null) {
            return dragAndDropNode.onDrop(emptyStrongMemoryCache);
        }
        DragAndDropNode dragAndDropNode2 = this.thisDragAndDropTarget;
        if (dragAndDropNode2 != null) {
            return dragAndDropNode2.onDrop(emptyStrongMemoryCache);
        }
        return false;
    }

    public final void onEntered(EmptyStrongMemoryCache emptyStrongMemoryCache) {
        DragAndDropNode dragAndDropNode = this.thisDragAndDropTarget;
        if (dragAndDropNode != null) {
            dragAndDropNode.onEntered(emptyStrongMemoryCache);
            return;
        }
        DragAndDropNode dragAndDropNode2 = this.lastChildDragAndDropModifierNode;
        if (dragAndDropNode2 != null) {
            dragAndDropNode2.onEntered(emptyStrongMemoryCache);
        }
    }

    public final void onExited(EmptyStrongMemoryCache emptyStrongMemoryCache) {
        DragAndDropNode dragAndDropNode = this.thisDragAndDropTarget;
        if (dragAndDropNode != null) {
            dragAndDropNode.onExited(emptyStrongMemoryCache);
        }
        DragAndDropNode dragAndDropNode2 = this.lastChildDragAndDropModifierNode;
        if (dragAndDropNode2 != null) {
            dragAndDropNode2.onExited(emptyStrongMemoryCache);
        }
        this.lastChildDragAndDropModifierNode = null;
    }

    public final void onMoved(EmptyStrongMemoryCache emptyStrongMemoryCache) {
        TraversableNode traversableNode;
        DragAndDropNode dragAndDropNode;
        DragAndDropNode dragAndDropNode2 = this.lastChildDragAndDropModifierNode;
        if (dragAndDropNode2 == null || !DragAndDropNodeKt.m335access$containsUv8p0NA(dragAndDropNode2, DragAndDrop_androidKt.getPositionInRoot(emptyStrongMemoryCache))) {
            if (this.node.isAttached) {
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                HitTestResultKt.traverseDescendants(this, new LayoutNodeDrawScope$record$1(ref$ObjectRef, this, emptyStrongMemoryCache, 4));
                traversableNode = (TraversableNode) ref$ObjectRef.element;
            } else {
                traversableNode = null;
            }
            dragAndDropNode = (DragAndDropNode) traversableNode;
        } else {
            dragAndDropNode = dragAndDropNode2;
        }
        if (dragAndDropNode != null && dragAndDropNode2 == null) {
            dragAndDropNode.onEntered(emptyStrongMemoryCache);
            dragAndDropNode.onMoved(emptyStrongMemoryCache);
            DragAndDropNode dragAndDropNode3 = this.thisDragAndDropTarget;
            if (dragAndDropNode3 != null) {
                dragAndDropNode3.onExited(emptyStrongMemoryCache);
            }
        } else if (dragAndDropNode == null && dragAndDropNode2 != null) {
            DragAndDropNode dragAndDropNode4 = this.thisDragAndDropTarget;
            if (dragAndDropNode4 != null) {
                dragAndDropNode4.onEntered(emptyStrongMemoryCache);
                dragAndDropNode4.onMoved(emptyStrongMemoryCache);
            }
            dragAndDropNode2.onExited(emptyStrongMemoryCache);
        } else if (!Intrinsics.areEqual(dragAndDropNode, dragAndDropNode2)) {
            if (dragAndDropNode != null) {
                dragAndDropNode.onEntered(emptyStrongMemoryCache);
                dragAndDropNode.onMoved(emptyStrongMemoryCache);
            }
            if (dragAndDropNode2 != null) {
                dragAndDropNode2.onExited(emptyStrongMemoryCache);
            }
        } else if (dragAndDropNode != null) {
            dragAndDropNode.onMoved(emptyStrongMemoryCache);
        } else {
            DragAndDropNode dragAndDropNode5 = this.thisDragAndDropTarget;
            if (dragAndDropNode5 != null) {
                dragAndDropNode5.onMoved(emptyStrongMemoryCache);
            }
        }
        this.lastChildDragAndDropModifierNode = dragAndDropNode;
    }

    @Override // androidx.compose.ui.node.MeasuredSizeAwareModifierNode
    /* JADX INFO: renamed from: onRemeasured-ozmzZPI */
    public final void mo63onRemeasuredozmzZPI(long j) {
        this.size = j;
    }

    public final void onStarted(EmptyStrongMemoryCache emptyStrongMemoryCache) {
        DragAndDropNode dragAndDropNode = this.thisDragAndDropTarget;
        if (dragAndDropNode != null) {
            dragAndDropNode.onStarted(emptyStrongMemoryCache);
            return;
        }
        DragAndDropNode dragAndDropNode2 = this.lastChildDragAndDropModifierNode;
        if (dragAndDropNode2 != null) {
            dragAndDropNode2.onStarted(emptyStrongMemoryCache);
        }
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    public final /* synthetic */ void onPlaced(LayoutCoordinates layoutCoordinates) {
    }
}
