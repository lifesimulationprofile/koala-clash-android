package androidx.camera.core.impl;

import androidx.camera.view.PreviewStreamStateObserver$2;
import androidx.lifecycle.LiveData;
import java.util.List;
import java.util.concurrent.Executor;
import okhttp3.Headers;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ForwardingCameraInfo implements CameraInfoInternal {
    public final CameraInfoInternal mCameraInfoInternal;

    public ForwardingCameraInfo(CameraInfoInternal cameraInfoInternal) {
        this.mCameraInfoInternal = cameraInfoInternal;
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public final void addSessionCaptureCallback(Executor executor, PreviewStreamStateObserver$2 previewStreamStateObserver$2) {
        this.mCameraInfoInternal.addSessionCaptureCallback(executor, previewStreamStateObserver$2);
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public String getCameraId() {
        return this.mCameraInfoInternal.getCameraId();
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public final Headers.Builder getCameraQuirks() {
        return this.mCameraInfoInternal.getCameraQuirks();
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public CameraInfoInternal getImplementation() {
        return this.mCameraInfoInternal.getImplementation();
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public final String getImplementationType() {
        return this.mCameraInfoInternal.getImplementationType();
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public final int getLensFacing() {
        return this.mCameraInfoInternal.getLensFacing();
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public int getSensorRotationDegrees() {
        return this.mCameraInfoInternal.getSensorRotationDegrees();
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public final List getSupportedResolutions(int i) {
        return this.mCameraInfoInternal.getSupportedResolutions(i);
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public LiveData getTorchState() {
        return this.mCameraInfoInternal.getTorchState();
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public boolean hasFlashUnit() {
        return this.mCameraInfoInternal.hasFlashUnit();
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public final void removeSessionCaptureCallback(CameraCaptureCallback cameraCaptureCallback) {
        this.mCameraInfoInternal.removeSessionCaptureCallback(cameraCaptureCallback);
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    public int getSensorRotationDegrees(int i) {
        return this.mCameraInfoInternal.getSensorRotationDegrees(i);
    }
}
