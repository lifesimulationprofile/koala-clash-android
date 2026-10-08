package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class FocusPropertiesNode extends Modifier.Node implements FocusPropertiesModifierNode {
    public FocusPropertiesKt$sam$androidx_compose_ui_focus_FocusPropertiesScope$0 focusPropertiesScope;

    @Override // androidx.compose.ui.focus.FocusPropertiesModifierNode
    public final void applyFocusProperties(FocusProperties focusProperties) {
        this.focusPropertiesScope.function.invoke(focusProperties);
    }
}
