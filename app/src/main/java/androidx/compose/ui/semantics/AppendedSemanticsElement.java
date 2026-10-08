package androidx.compose.ui.semantics;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AppendedSemanticsElement extends ModifierNodeElement implements Modifier.Element {
    public final boolean mergeDescendants;
    public final Function1 properties;

    public AppendedSemanticsElement(Function1 function1, boolean z) {
        this.mergeDescendants = z;
        this.properties = function1;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        return new CoreSemanticsModifierNode(this.mergeDescendants, false, this.properties);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppendedSemanticsElement)) {
            return false;
        }
        AppendedSemanticsElement appendedSemanticsElement = (AppendedSemanticsElement) obj;
        return this.mergeDescendants == appendedSemanticsElement.mergeDescendants && this.properties == appendedSemanticsElement.properties;
    }

    public final int hashCode() {
        return this.properties.hashCode() + ((this.mergeDescendants ? 1231 : 1237) * 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        CoreSemanticsModifierNode coreSemanticsModifierNode = (CoreSemanticsModifierNode) node;
        coreSemanticsModifierNode.mergeDescendants = this.mergeDescendants;
        coreSemanticsModifierNode.properties = this.properties;
    }
}
