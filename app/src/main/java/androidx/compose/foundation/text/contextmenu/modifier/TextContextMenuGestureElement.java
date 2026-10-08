package androidx.compose.foundation.text.contextmenu.modifier;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
final class TextContextMenuGestureElement extends ModifierNodeElement {
    public final SuspendLambda onPreShowContextMenu;

    /* JADX WARN: Multi-variable type inference failed */
    public TextContextMenuGestureElement(Function2 function2) {
        this.onPreShowContextMenu = (SuspendLambda) function2;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        return new TextContextMenuGestureNode(this.onPreShowContextMenu);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TextContextMenuGestureElement) {
            return this.onPreShowContextMenu == ((TextContextMenuGestureElement) obj).onPreShowContextMenu;
        }
        return false;
    }

    public final int hashCode() {
        return this.onPreShowContextMenu.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        ((TextContextMenuGestureNode) node).onPreShowContextMenu = this.onPreShowContextMenu;
    }
}
