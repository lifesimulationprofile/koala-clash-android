package androidx.compose.foundation.layout;

import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
final class BoxChildDataElement extends ModifierNodeElement {
    public final BiasAlignment alignment;

    public BoxChildDataElement(BiasAlignment biasAlignment) {
        this.alignment = biasAlignment;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        BoxChildDataNode boxChildDataNode = new BoxChildDataNode();
        boxChildDataNode.alignment = this.alignment;
        return boxChildDataNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        BoxChildDataElement boxChildDataElement = obj instanceof BoxChildDataElement ? (BoxChildDataElement) obj : null;
        return boxChildDataElement != null && this.alignment.equals(boxChildDataElement.alignment);
    }

    public final int hashCode() {
        return (this.alignment.hashCode() * 31) + 1237;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        ((BoxChildDataNode) node).alignment = this.alignment;
    }
}
