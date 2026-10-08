package androidx.compose.foundation.text.contextmenu.modifier;

import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda0;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.TraversableNode;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AddTextContextMenuDataComponentsNode extends Modifier.Node implements TraversableNode {
    public Recomposer$$ExternalSyntheticLambda0 builder;

    @Override // androidx.compose.ui.node.TraversableNode
    public final Object getTraverseKey() {
        return TextContextMenuDataTraverseKey.INSTANCE;
    }
}
