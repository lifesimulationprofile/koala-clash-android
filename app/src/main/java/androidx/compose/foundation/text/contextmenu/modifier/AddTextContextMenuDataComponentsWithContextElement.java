package androidx.compose.foundation.text.contextmenu.modifier;

import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda0;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
final class AddTextContextMenuDataComponentsWithContextElement extends ModifierNodeElement {
    public final Function2 builder;

    public AddTextContextMenuDataComponentsWithContextElement(Function2 function2) {
        this.builder = function2;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        AddTextContextMenuDataComponentsWithContextNode addTextContextMenuDataComponentsWithContextNode = new AddTextContextMenuDataComponentsWithContextNode();
        addTextContextMenuDataComponentsWithContextNode.builder = this.builder;
        Recomposer$$ExternalSyntheticLambda0 recomposer$$ExternalSyntheticLambda0 = new Recomposer$$ExternalSyntheticLambda0(17, addTextContextMenuDataComponentsWithContextNode);
        AddTextContextMenuDataComponentsNode addTextContextMenuDataComponentsNode = new AddTextContextMenuDataComponentsNode();
        addTextContextMenuDataComponentsNode.builder = recomposer$$ExternalSyntheticLambda0;
        addTextContextMenuDataComponentsWithContextNode.delegate(addTextContextMenuDataComponentsNode);
        return addTextContextMenuDataComponentsWithContextNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AddTextContextMenuDataComponentsWithContextElement) {
            return this.builder == ((AddTextContextMenuDataComponentsWithContextElement) obj).builder;
        }
        return false;
    }

    public final int hashCode() {
        return this.builder.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        ((AddTextContextMenuDataComponentsWithContextNode) node).builder = this.builder;
    }
}
