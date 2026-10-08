package androidx.compose.material3.internal;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.lifecycle.compose.LifecycleEffectKt$$ExternalSyntheticLambda1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ParentSemanticsNodeElement extends ModifierNodeElement {
    public final LifecycleEffectKt$$ExternalSyntheticLambda1 properties;

    public ParentSemanticsNodeElement(LifecycleEffectKt$$ExternalSyntheticLambda1 lifecycleEffectKt$$ExternalSyntheticLambda1) {
        this.properties = lifecycleEffectKt$$ExternalSyntheticLambda1;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        ParentSemanticsNode parentSemanticsNode = new ParentSemanticsNode();
        parentSemanticsNode.properties = this.properties;
        return parentSemanticsNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ParentSemanticsNodeElement) {
            return this.properties == ((ParentSemanticsNodeElement) obj).properties;
        }
        return false;
    }

    public final int hashCode() {
        return this.properties.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        ParentSemanticsNode parentSemanticsNode = (ParentSemanticsNode) node;
        parentSemanticsNode.properties = this.properties;
        HitTestResultKt.invalidateSemantics(parentSemanticsNode);
    }
}
