package androidx.core.view;

import android.view.View;
import android.view.Window;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public class WindowInsetsControllerCompat$Impl23 extends WindowInsetsControllerCompat$Impl {
    public final Window mWindow;

    public WindowInsetsControllerCompat$Impl23(Window window) {
        this.mWindow = window;
    }

    @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
    public final void setAppearanceLightStatusBars(boolean z) {
        Window window = this.mWindow;
        if (!z) {
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & (-8193));
        } else {
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() | 8192);
        }
    }
}
