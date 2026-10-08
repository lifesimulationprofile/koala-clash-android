package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
final class ConsumedInsetsModifierElement extends ModifierNodeElement {
    public final Function1 block;

    public ConsumedInsetsModifierElement(Function1 function1) {
        this.block = function1;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        ConsumedInsetsModifierNode consumedInsetsModifierNode = new ConsumedInsetsModifierNode();
        consumedInsetsModifierNode.block = this.block;
        return consumedInsetsModifierNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ConsumedInsetsModifierElement) && ((ConsumedInsetsModifierElement) obj).block == this.block;
    }

    public final int hashCode() {
        return this.block.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        ConsumedInsetsModifierNode consumedInsetsModifierNode = (ConsumedInsetsModifierNode) node;
        Function1 function1 = consumedInsetsModifierNode.block;
        Function1 function2 = this.block;
        if (function2 != function1) {
            consumedInsetsModifierNode.block = function2;
        }
    }
}
