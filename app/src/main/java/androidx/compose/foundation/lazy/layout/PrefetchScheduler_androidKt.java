package androidx.compose.foundation.lazy.layout;

import android.os.Build;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class PrefetchScheduler_androidKt {
    public static final PrefetchScheduler_androidKt$RobolectricImpl$1 RobolectricImpl;

    static {
        String str = Build.FINGERPRINT;
        RobolectricImpl = (str == null || !str.toLowerCase(Locale.ROOT).equals("robolectric")) ? null : new PrefetchScheduler_androidKt$RobolectricImpl$1();
    }
}
