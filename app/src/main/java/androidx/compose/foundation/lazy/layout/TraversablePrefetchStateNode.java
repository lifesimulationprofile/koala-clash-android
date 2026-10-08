package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.TraversableNode;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class TraversablePrefetchStateNode extends Modifier.Node implements TraversableNode {
    public LazyLayoutPrefetchState prefetchState;

    @Override // androidx.compose.ui.node.TraversableNode
    public final /* bridge */ /* synthetic */ Object getTraverseKey() {
        return "androidx.compose.foundation.lazy.layout.TraversablePrefetchStateNode";
    }
}
