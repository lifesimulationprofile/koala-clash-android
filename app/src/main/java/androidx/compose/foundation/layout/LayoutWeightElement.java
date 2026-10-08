package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class LayoutWeightElement extends ModifierNodeElement {
    public final boolean fill;
    public final float weight;

    public LayoutWeightElement(float f, boolean z) {
        this.weight = f;
        this.fill = z;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        LayoutWeightNode layoutWeightNode = new LayoutWeightNode();
        layoutWeightNode.weight = this.weight;
        layoutWeightNode.fill = this.fill;
        return layoutWeightNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        LayoutWeightElement layoutWeightElement = obj instanceof LayoutWeightElement ? (LayoutWeightElement) obj : null;
        return layoutWeightElement != null && this.weight == layoutWeightElement.weight && this.fill == layoutWeightElement.fill;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.weight) * 31) + (this.fill ? 1231 : 1237);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        LayoutWeightNode layoutWeightNode = (LayoutWeightNode) node;
        layoutWeightNode.weight = this.weight;
        layoutWeightNode.fill = this.fill;
    }
}
