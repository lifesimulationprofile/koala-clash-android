package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
final class FocusableElement extends ModifierNodeElement {
    public final MutableInteractionSourceImpl interactionSource;

    public FocusableElement(MutableInteractionSourceImpl mutableInteractionSourceImpl) {
        this.interactionSource = mutableInteractionSourceImpl;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        return new FocusableNode(this.interactionSource, 1, null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FocusableElement) {
            return Intrinsics.areEqual(this.interactionSource, ((FocusableElement) obj).interactionSource);
        }
        return false;
    }

    public final int hashCode() {
        MutableInteractionSourceImpl mutableInteractionSourceImpl = this.interactionSource;
        if (mutableInteractionSourceImpl != null) {
            return mutableInteractionSourceImpl.hashCode();
        }
        return 0;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        ((FocusableNode) node).update(this.interactionSource);
    }
}
