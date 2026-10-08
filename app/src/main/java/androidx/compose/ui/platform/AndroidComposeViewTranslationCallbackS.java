package androidx.compose.ui.platform;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidComposeViewTranslationCallbackS {
    public static final AndroidComposeViewTranslationCallbackS INSTANCE = new AndroidComposeViewTranslationCallbackS();

    public final void clearViewTranslationCallback(View view) {
        view.clearViewTranslationCallback();
    }

    public final void setViewTranslationCallback(View view) {
        AndroidComposeViewTranslationCallback androidComposeViewTranslationCallback = AndroidComposeViewTranslationCallback.INSTANCE;
        AndroidComposeViewTranslationCallback androidComposeViewTranslationCallback2 = AndroidComposeViewTranslationCallback.INSTANCE;
        view.setViewTranslationCallback(AndroidComposeViewTranslationCallback.INSTANCE);
    }
}
