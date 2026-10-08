package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.node.ModifierNodeElement;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
final class FocusGroupElement extends ModifierNodeElement {
    public static final FocusGroupElement INSTANCE = new FocusGroupElement();

    private FocusGroupElement() {
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        FocusGroupNode focusGroupNode = new FocusGroupNode();
        focusGroupNode.delegate(new FocusTargetNode(2, null, 10));
        return focusGroupNode;
    }

    public final boolean equals(Object obj) {
        return obj == this;
    }

    public final int hashCode() {
        return -1063782265;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final /* bridge */ /* synthetic */ void update(Modifier.Node node) {
    }
}
