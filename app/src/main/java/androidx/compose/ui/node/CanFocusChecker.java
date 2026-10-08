package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusRequester;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class CanFocusChecker implements FocusProperties {
    public static final CanFocusChecker INSTANCE = new CanFocusChecker();

    @Override // androidx.compose.ui.focus.FocusProperties
    public final boolean getCanFocus() {
        throw Modifier.CC.m("canFocus is read before it is written");
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public final /* synthetic */ void setLeft(FocusRequester focusRequester) {
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public final /* synthetic */ void setRight(FocusRequester focusRequester) {
    }
}
