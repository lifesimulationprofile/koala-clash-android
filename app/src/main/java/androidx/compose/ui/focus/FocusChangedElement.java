package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
final class FocusChangedElement extends ModifierNodeElement {
    public final Function1 onFocusChanged;

    public FocusChangedElement(Function1 function1) {
        this.onFocusChanged = function1;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        FocusChangedNode focusChangedNode = new FocusChangedNode();
        focusChangedNode.onFocusChanged = this.onFocusChanged;
        return focusChangedNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FocusChangedElement) {
            return this.onFocusChanged == ((FocusChangedElement) obj).onFocusChanged;
        }
        return false;
    }

    public final int hashCode() {
        return this.onFocusChanged.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        ((FocusChangedNode) node).onFocusChanged = this.onFocusChanged;
    }
}
