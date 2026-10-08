package androidx.compose.ui.text.platform;

import androidx.emoji2.text.EmojiCompat;
import coil.disk.RealDiskCache;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class EmojiCompatStatus {
    public static final RealDiskCache.RealEditor delegate;

    static {
        RealDiskCache.RealEditor realEditor = new RealDiskCache.RealEditor(13, false);
        realEditor.editor = EmojiCompat.isConfigured() ? realEditor.getFontLoadState() : null;
        delegate = realEditor;
    }
}
