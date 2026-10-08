package androidx.transition;

import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TransitionUtils {
    public static final boolean HAS_PICTURE_BITMAP;

    static {
        HAS_PICTURE_BITMAP = Build.VERSION.SDK_INT >= 28;
    }
}
