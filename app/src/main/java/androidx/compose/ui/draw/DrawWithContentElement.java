package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
final class DrawWithContentElement extends ModifierNodeElement {
    public final Function1 onDraw;

    public DrawWithContentElement(Function1 function1) {
        this.onDraw = function1;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        DrawWithContentModifier drawWithContentModifier = new DrawWithContentModifier();
        drawWithContentModifier.onDraw = this.onDraw;
        return drawWithContentModifier;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DrawWithContentElement) {
            return this.onDraw == ((DrawWithContentElement) obj).onDraw;
        }
        return false;
    }

    public final int hashCode() {
        return this.onDraw.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        ((DrawWithContentModifier) node).onDraw = this.onDraw;
    }
}
