package androidx.compose.ui.input.key;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
final class KeyInputElement extends ModifierNodeElement {
    public final Function1 onKeyEvent;
    public final Function1 onPreKeyEvent;

    public KeyInputElement(Function1 function1, Function1 function2) {
        this.onKeyEvent = function1;
        this.onPreKeyEvent = function2;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        KeyInputNode keyInputNode = new KeyInputNode();
        keyInputNode.onEvent = this.onKeyEvent;
        keyInputNode.onPreEvent = this.onPreKeyEvent;
        return keyInputNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeyInputElement)) {
            return false;
        }
        KeyInputElement keyInputElement = (KeyInputElement) obj;
        return this.onKeyEvent == keyInputElement.onKeyEvent && this.onPreKeyEvent == keyInputElement.onPreKeyEvent;
    }

    public final int hashCode() {
        Function1 function1 = this.onKeyEvent;
        int iHashCode = (function1 != null ? function1.hashCode() : 0) * 31;
        Function1 function2 = this.onPreKeyEvent;
        return iHashCode + (function2 != null ? function2.hashCode() : 0);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        KeyInputNode keyInputNode = (KeyInputNode) node;
        keyInputNode.onEvent = this.onKeyEvent;
        keyInputNode.onPreEvent = this.onPreKeyEvent;
    }
}
