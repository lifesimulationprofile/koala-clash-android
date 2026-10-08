package androidx.compose.ui.platform;

import android.content.ClipData;
import android.os.Build;
import kotlin.Unit;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidClipboard implements Clipboard {
    public final AndroidClipboardManager androidClipboardManager;

    public AndroidClipboard(AndroidClipboardManager androidClipboardManager) {
        this.androidClipboardManager = androidClipboardManager;
    }

    public final Unit setClipEntry(ClipEntry clipEntry) {
        AndroidClipboardManager androidClipboardManager = this.androidClipboardManager;
        if (clipEntry != null) {
            androidClipboardManager.getClipboardManager().setPrimaryClip(clipEntry.clipData);
        } else if (Build.VERSION.SDK_INT >= 28) {
            androidClipboardManager.getClipboardManager().clearPrimaryClip();
        } else {
            androidClipboardManager.getClipboardManager().setPrimaryClip(ClipData.newPlainText("", ""));
        }
        return Unit.INSTANCE;
    }
}
