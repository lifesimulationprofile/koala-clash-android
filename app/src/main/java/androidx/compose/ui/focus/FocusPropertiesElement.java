package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
final class FocusPropertiesElement extends ModifierNodeElement {
    public final FocusPropertiesKt$sam$androidx_compose_ui_focus_FocusPropertiesScope$0 scope;

    public FocusPropertiesElement(FocusPropertiesKt$sam$androidx_compose_ui_focus_FocusPropertiesScope$0 focusPropertiesKt$sam$androidx_compose_ui_focus_FocusPropertiesScope$0) {
        this.scope = focusPropertiesKt$sam$androidx_compose_ui_focus_FocusPropertiesScope$0;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        FocusPropertiesNode focusPropertiesNode = new FocusPropertiesNode();
        focusPropertiesNode.focusPropertiesScope = this.scope;
        return focusPropertiesNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FocusPropertiesElement) && Intrinsics.areEqual(this.scope, ((FocusPropertiesElement) obj).scope);
    }

    public final int hashCode() {
        return this.scope.function.hashCode();
    }

    public final String toString() {
        return "FocusPropertiesElement(scope=" + this.scope + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        ((FocusPropertiesNode) node).focusPropertiesScope = this.scope;
    }
}
