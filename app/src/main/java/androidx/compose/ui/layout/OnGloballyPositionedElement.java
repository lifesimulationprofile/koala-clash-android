package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
final class OnGloballyPositionedElement extends ModifierNodeElement {
    public final Function1 onGloballyPositioned;

    public OnGloballyPositionedElement(Function1 function1) {
        this.onGloballyPositioned = function1;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        OnGloballyPositionedNode onGloballyPositionedNode = new OnGloballyPositionedNode();
        onGloballyPositionedNode.callback = this.onGloballyPositioned;
        return onGloballyPositionedNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OnGloballyPositionedElement) {
            return this.onGloballyPositioned == ((OnGloballyPositionedElement) obj).onGloballyPositioned;
        }
        return false;
    }

    public final int hashCode() {
        return this.onGloballyPositioned.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        ((OnGloballyPositionedNode) node).callback = this.onGloballyPositioned;
    }
}
