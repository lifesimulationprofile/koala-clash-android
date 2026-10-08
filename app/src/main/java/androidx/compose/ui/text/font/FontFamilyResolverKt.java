package androidx.compose.ui.text.font;

import androidx.room.TransactionElement;
import androidx.work.impl.WorkLauncherImpl;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class FontFamilyResolverKt {
    public static final WorkLauncherImpl GlobalTypefaceRequestCache = new WorkLauncherImpl(12);

    static {
        new TransactionElement.Key();
    }
}
