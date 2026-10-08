package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
final class DrawWithCacheElement extends ModifierNodeElement {
    public final Function1 onBuildDrawCache;

    public DrawWithCacheElement(Function1 function1) {
        this.onBuildDrawCache = function1;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        return new CacheDrawModifierNodeImpl(new CacheDrawScope(), this.onBuildDrawCache);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DrawWithCacheElement) {
            return this.onBuildDrawCache == ((DrawWithCacheElement) obj).onBuildDrawCache;
        }
        return false;
    }

    public final int hashCode() {
        return this.onBuildDrawCache.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        CacheDrawModifierNodeImpl cacheDrawModifierNodeImpl = (CacheDrawModifierNodeImpl) node;
        cacheDrawModifierNodeImpl.block = this.onBuildDrawCache;
        cacheDrawModifierNodeImpl.invalidateDrawCache();
    }
}
