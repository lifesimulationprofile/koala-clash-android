package androidx.compose.ui.platform;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidComposeViewVerificationHelperMethodsO {
    public static final AndroidComposeViewVerificationHelperMethodsO INSTANCE = new AndroidComposeViewVerificationHelperMethodsO();

    public final void focusable(View view, int i, boolean z) {
        view.setFocusable(i);
        view.setDefaultFocusHighlightEnabled(z);
    }
}
