package androidx.camera.core.internal;

import androidx.camera.core.ImageCapture;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ScreenFlashWrapper implements ImageCapture.ScreenFlash {
    public boolean isClearScreenFlashPending;
    public final Object lock = new Object();
    public final ImageCapture.ScreenFlash screenFlash;

    public ScreenFlashWrapper(ImageCapture.ScreenFlash screenFlash) {
        this.screenFlash = screenFlash;
    }

    @Override // androidx.camera.core.ImageCapture.ScreenFlash
    public final void clear() {
        completePendingScreenFlashClear();
    }

    public final void completePendingScreenFlashClear() {
        Unit unit;
        synchronized (this.lock) {
            try {
                if (this.isClearScreenFlashPending) {
                    ImageCapture.ScreenFlash screenFlash = this.screenFlash;
                    if (screenFlash != null) {
                        screenFlash.clear();
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit == null) {
                        LazyKt__LazyJVMKt.e("ScreenFlashWrapper", "completePendingScreenFlashClear: screenFlash is null!");
                    }
                } else {
                    LazyKt__LazyJVMKt.w("ScreenFlashWrapper", "completePendingScreenFlashClear: none pending!");
                }
                this.isClearScreenFlashPending = false;
                Unit unit2 = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void completePendingScreenFlashListener() {
        synchronized (this.lock) {
            Unit unit = Unit.INSTANCE;
        }
    }
}
