package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
final class IndicationModifierElement extends ModifierNodeElement {
    public final IndicationNodeFactory indication;
    public final MutableInteractionSourceImpl interactionSource;

    public IndicationModifierElement(MutableInteractionSourceImpl mutableInteractionSourceImpl, IndicationNodeFactory indicationNodeFactory) {
        this.interactionSource = mutableInteractionSourceImpl;
        this.indication = indicationNodeFactory;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        DelegatableNode delegatableNodeCreate = this.indication.create(this.interactionSource);
        IndicationModifierNode indicationModifierNode = new IndicationModifierNode();
        indicationModifierNode.indicationNode = delegatableNodeCreate;
        indicationModifierNode.delegate(delegatableNodeCreate);
        return indicationModifierNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IndicationModifierElement)) {
            return false;
        }
        IndicationModifierElement indicationModifierElement = (IndicationModifierElement) obj;
        return Intrinsics.areEqual(this.interactionSource, indicationModifierElement.interactionSource) && Intrinsics.areEqual(this.indication, indicationModifierElement.indication);
    }

    public final int hashCode() {
        return this.indication.hashCode() + (this.interactionSource.hashCode() * 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        IndicationModifierNode indicationModifierNode = (IndicationModifierNode) node;
        DelegatableNode delegatableNodeCreate = this.indication.create(this.interactionSource);
        indicationModifierNode.undelegate(indicationModifierNode.indicationNode);
        indicationModifierNode.indicationNode = delegatableNodeCreate;
        indicationModifierNode.delegate(delegatableNodeCreate);
    }
}
