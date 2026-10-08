package androidx.compose.material3;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class MinimumInteractiveModifier extends ModifierNodeElement {
    public static final MinimumInteractiveModifier INSTANCE = new MinimumInteractiveModifier();

    private MinimumInteractiveModifier() {
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        return new MinimumInteractiveModifierNode();
    }

    public final boolean equals(Object obj) {
        return obj == this;
    }

    public final int hashCode() {
        return System.identityHashCode(this);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final /* bridge */ /* synthetic */ void update(Modifier.Node node) {
    }
}
