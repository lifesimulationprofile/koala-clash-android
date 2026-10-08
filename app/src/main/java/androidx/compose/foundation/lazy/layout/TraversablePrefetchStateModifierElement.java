package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
final class TraversablePrefetchStateModifierElement extends ModifierNodeElement {
    public final LazyLayoutPrefetchState prefetchState;

    public TraversablePrefetchStateModifierElement(LazyLayoutPrefetchState lazyLayoutPrefetchState) {
        this.prefetchState = lazyLayoutPrefetchState;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        TraversablePrefetchStateNode traversablePrefetchStateNode = new TraversablePrefetchStateNode();
        traversablePrefetchStateNode.prefetchState = this.prefetchState;
        return traversablePrefetchStateNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TraversablePrefetchStateModifierElement) && Intrinsics.areEqual(this.prefetchState, ((TraversablePrefetchStateModifierElement) obj).prefetchState);
    }

    public final int hashCode() {
        return this.prefetchState.hashCode();
    }

    public final String toString() {
        return "TraversablePrefetchStateModifierElement(prefetchState=" + this.prefetchState + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        ((TraversablePrefetchStateNode) node).prefetchState = this.prefetchState;
    }
}
