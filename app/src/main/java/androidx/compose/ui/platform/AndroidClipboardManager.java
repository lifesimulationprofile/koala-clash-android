package androidx.compose.ui.platform;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidClipboardManager implements ClipboardManager {
    public android.content.ClipboardManager _clipboardManager;
    public final Context context;

    public AndroidClipboardManager(Context context) {
        this.context = context;
    }

    public final android.content.ClipboardManager getClipboardManager() {
        android.content.ClipboardManager clipboardManager = this._clipboardManager;
        if (clipboardManager != null) {
            return clipboardManager;
        }
        android.content.ClipboardManager clipboardManager2 = (android.content.ClipboardManager) this.context.getSystemService("clipboard");
        this._clipboardManager = clipboardManager2;
        return clipboardManager2;
    }
}
