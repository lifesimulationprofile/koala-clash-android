package androidx.compose.ui.focus;

import androidx.compose.ui.geometry.Rect;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class FocusPropertiesImpl implements FocusProperties {
    public boolean canFocus;
    public FocusRequester down;
    public FocusRequester end;
    public Rect focusRect;
    public FocusRequester left;
    public FocusRequester next;
    public FocusPropertiesImpl$onExit$1 onEnter;
    public FocusPropertiesImpl$onExit$1 onExit;
    public FocusRequester previous;
    public FocusRequester right;
    public FocusRequester start;
    public FocusRequester up;

    @Override // androidx.compose.ui.focus.FocusProperties
    public final boolean getCanFocus() {
        return this.canFocus;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public final void setLeft(FocusRequester focusRequester) {
        this.left = focusRequester;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public final void setRight(FocusRequester focusRequester) {
        this.right = focusRequester;
    }
}
