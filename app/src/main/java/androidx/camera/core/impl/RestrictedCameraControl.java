package androidx.camera.core.impl;

import androidx.lifecycle.Lifecycle;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class RestrictedCameraControl extends Lifecycle {
    public final CameraControlInternal mCameraControl;

    public RestrictedCameraControl(CameraControlInternal cameraControlInternal) {
        super(cameraControlInternal);
        this.mCameraControl = cameraControlInternal;
    }

    @Override // androidx.lifecycle.Lifecycle, androidx.camera.core.impl.CameraControlInternal
    public final ListenableFuture enableTorch(boolean z) {
        return this.mCameraControl.enableTorch(z);
    }
}
