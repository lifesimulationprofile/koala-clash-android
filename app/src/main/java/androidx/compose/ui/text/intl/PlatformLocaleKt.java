package androidx.compose.ui.text.intl;

import android.os.Build;
import coil.network.RealNetworkObserver;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class PlatformLocaleKt {
    public static final PlatformLocaleDelegate platformLocaleDelegate;

    static {
        platformLocaleDelegate = Build.VERSION.SDK_INT >= 24 ? new RealNetworkObserver(9) : new Path.Companion(8);
    }
}
