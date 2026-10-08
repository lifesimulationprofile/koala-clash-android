package androidx.compose.foundation.layout;

import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ParentDataModifierNode;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class BoxChildDataNode extends Modifier.Node implements ParentDataModifierNode {
    public BiasAlignment alignment;

    @Override // androidx.compose.ui.node.ParentDataModifierNode
    public final Object modifyParentData(Object obj) {
        return this;
    }
}
