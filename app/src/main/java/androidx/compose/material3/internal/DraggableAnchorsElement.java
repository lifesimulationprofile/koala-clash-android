package androidx.compose.material3.internal;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.work.impl.StartStopTokens;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
final class DraggableAnchorsElement<T> extends ModifierNodeElement {
    public final Function2 anchors;
    public final StartStopTokens state;

    public DraggableAnchorsElement(StartStopTokens startStopTokens, Function2 function2) {
        this.state = startStopTokens;
        this.anchors = function2;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        DraggableAnchorsNode draggableAnchorsNode = new DraggableAnchorsNode();
        draggableAnchorsNode.state = this.state;
        draggableAnchorsNode.anchors = this.anchors;
        draggableAnchorsNode.orientation = Orientation.Vertical;
        return draggableAnchorsNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DraggableAnchorsElement)) {
            return false;
        }
        DraggableAnchorsElement draggableAnchorsElement = (DraggableAnchorsElement) obj;
        return Intrinsics.areEqual(this.state, draggableAnchorsElement.state) && this.anchors == draggableAnchorsElement.anchors;
    }

    public final int hashCode() {
        return Orientation.Vertical.hashCode() + ((this.anchors.hashCode() + (this.state.hashCode() * 31)) * 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        DraggableAnchorsNode draggableAnchorsNode = (DraggableAnchorsNode) node;
        StartStopTokens startStopTokens = draggableAnchorsNode.state;
        StartStopTokens startStopTokens2 = this.state;
        boolean zAreEqual = Intrinsics.areEqual(startStopTokens, startStopTokens2);
        draggableAnchorsNode.state = startStopTokens2;
        draggableAnchorsNode.anchors = this.anchors;
        draggableAnchorsNode.orientation = Orientation.Vertical;
        if (zAreEqual) {
            return;
        }
        draggableAnchorsNode.didInitializeAnchors = false;
        HitTestResultKt.invalidateMeasurement(draggableAnchorsNode);
    }
}
