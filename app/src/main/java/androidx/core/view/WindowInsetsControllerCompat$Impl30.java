package androidx.core.view;

import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public class WindowInsetsControllerCompat$Impl30 extends WindowInsetsControllerCompat$Impl {
    public final WindowInsetsController mInsetsController;
    public final Window mWindow;

    public WindowInsetsControllerCompat$Impl30(Window window) {
        this.mInsetsController = window.getInsetsController();
        this.mWindow = window;
    }

    @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
    public final void setAppearanceLightNavigationBars(boolean z) {
        Window window = this.mWindow;
        if (z) {
            if (window != null) {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 16);
            }
            this.mInsetsController.setSystemBarsAppearance(16, 16);
            return;
        }
        if (window != null) {
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-17));
        }
        this.mInsetsController.setSystemBarsAppearance(0, 16);
    }

    @Override // androidx.core.view.WindowInsetsControllerCompat$Impl
    public final void setAppearanceLightStatusBars(boolean z) {
        Window window = this.mWindow;
        if (z) {
            if (window != null) {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 8192);
            }
            this.mInsetsController.setSystemBarsAppearance(8, 8);
            return;
        }
        if (window != null) {
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-8193));
        }
        this.mInsetsController.setSystemBarsAppearance(0, 8);
    }
}
