package androidx.camera.view;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.camera.core.ImageCapture;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.MapsKt__MapsKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ScreenFlashView extends View {
    public AnonymousClass1 mScreenFlash;
    public Window mScreenFlashWindow;

    private float getBrightness() {
        Window window = this.mScreenFlashWindow;
        if (window != null) {
            return window.getAttributes().screenBrightness;
        }
        LazyKt__LazyJVMKt.e("ScreenFlashView", "setBrightness: mScreenFlashWindow is null!");
        return Float.NaN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBrightness(float f) {
        if (this.mScreenFlashWindow == null) {
            LazyKt__LazyJVMKt.e("ScreenFlashView", "setBrightness: mScreenFlashWindow is null!");
            return;
        }
        if (Float.isNaN(f)) {
            LazyKt__LazyJVMKt.e("ScreenFlashView", "setBrightness: value is NaN!");
            return;
        }
        WindowManager.LayoutParams attributes = this.mScreenFlashWindow.getAttributes();
        attributes.screenBrightness = f;
        this.mScreenFlashWindow.setAttributes(attributes);
        LazyKt__LazyJVMKt.d("ScreenFlashView", "Brightness set to " + attributes.screenBrightness);
    }

    private void setScreenFlashUiInfo(ImageCapture.ScreenFlash screenFlash) {
        LazyKt__LazyJVMKt.d("ScreenFlashView", "setScreenFlashUiInfo: mCameraController is null!");
    }

    public ImageCapture.ScreenFlash getScreenFlash() {
        return this.mScreenFlash;
    }

    public long getVisibilityRampUpAnimationDurationMillis() {
        return 1000L;
    }

    public void setController(CameraController cameraController) {
        MapsKt__MapsKt.checkMainThread();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setScreenFlashWindow(Window window) {
        MapsKt__MapsKt.checkMainThread();
        if (this.mScreenFlashWindow != window) {
            this.mScreenFlash = window == null ? 0 : new ImageCapture.ScreenFlash() { // from class: androidx.camera.view.ScreenFlashView.1
                public ValueAnimator mAnimator;

                @Override // androidx.camera.core.ImageCapture.ScreenFlash
                public final void clear() {
                    LazyKt__LazyJVMKt.d("ScreenFlashView", "ScreenFlash#clearScreenFlashUi");
                    ValueAnimator valueAnimator = this.mAnimator;
                    if (valueAnimator != null) {
                        valueAnimator.cancel();
                        this.mAnimator = null;
                    }
                    ScreenFlashView screenFlashView = ScreenFlashView.this;
                    screenFlashView.setAlpha(0.0f);
                    screenFlashView.setBrightness(0.0f);
                }
            };
        }
        this.mScreenFlashWindow = window;
        setScreenFlashUiInfo(getScreenFlash());
    }
}
