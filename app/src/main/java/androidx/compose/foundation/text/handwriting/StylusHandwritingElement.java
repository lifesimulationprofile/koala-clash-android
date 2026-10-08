package androidx.compose.foundation.text.handwriting;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
final class StylusHandwritingElement extends ModifierNodeElement {
    public final Function0 onHandwritingSlopExceeded;

    public StylusHandwritingElement(Function0 function0) {
        this.onHandwritingSlopExceeded = function0;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        return new StylusHandwritingNode(this.onHandwritingSlopExceeded);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StylusHandwritingElement) {
            return this.onHandwritingSlopExceeded == ((StylusHandwritingElement) obj).onHandwritingSlopExceeded;
        }
        return false;
    }

    public final int hashCode() {
        return this.onHandwritingSlopExceeded.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        ((StylusHandwritingNode) node).onHandwritingSlopExceeded = this.onHandwritingSlopExceeded;
    }
}
