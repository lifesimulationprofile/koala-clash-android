package androidx.camera.core.streamsharing;

import androidx.appcompat.widget.Toolbar;
import androidx.camera.camera2.internal.ZslControlImpl$$ExternalSyntheticLambda0;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraConfigs;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.ForwardingCameraInfo;
import androidx.camera.core.impl.Observable;
import java.util.ArrayList;
import kotlin.collections.MapsKt__MapsKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class VirtualCamera implements CameraInternal {
    public final CameraInternal mParentCamera;
    public final VirtualCameraAdapter mStateChangeCallback;
    public final VirtualCameraControl mVirtualCameraControl;
    public final VirtualCameraInfo mVirtualCameraInfo;

    public VirtualCamera(CameraInternal cameraInternal, VirtualCameraAdapter virtualCameraAdapter, ZslControlImpl$$ExternalSyntheticLambda0 zslControlImpl$$ExternalSyntheticLambda0) {
        this.mParentCamera = cameraInternal;
        this.mStateChangeCallback = virtualCameraAdapter;
        this.mVirtualCameraControl = new VirtualCameraControl(cameraInternal.getCameraControlInternal());
        this.mVirtualCameraInfo = new VirtualCameraInfo(cameraInternal.getCameraInfoInternal());
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public final void attachUseCases(ArrayList arrayList) {
        throw new UnsupportedOperationException("Operation not supported by VirtualCamera.");
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public final void detachUseCases(ArrayList arrayList) {
        throw new UnsupportedOperationException("Operation not supported by VirtualCamera.");
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public final CameraControlInternal getCameraControlInternal() {
        return this.mVirtualCameraControl;
    }

    @Override // androidx.camera.core.impl.CameraInternal, androidx.camera.core.Camera
    public final CameraInfoInternal getCameraInfo() {
        return getCameraInfoInternal();
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public final CameraInfoInternal getCameraInfoInternal() {
        return this.mVirtualCameraInfo;
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public final Observable getCameraState() {
        return this.mParentCamera.getCameraState();
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public final CameraConfig getExtendedConfig() {
        return CameraConfigs.DEFAULT_CAMERA_CONFIG;
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public final boolean getHasTransform() {
        return false;
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public final boolean isFrontFacing() {
        return ((ForwardingCameraInfo) getCameraInfo()).getLensFacing() == 0;
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public final void onUseCaseActive(UseCase useCase) {
        MapsKt__MapsKt.checkMainThread();
        this.mStateChangeCallback.onUseCaseActive(useCase);
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public final void onUseCaseInactive(UseCase useCase) {
        MapsKt__MapsKt.checkMainThread();
        this.mStateChangeCallback.onUseCaseInactive(useCase);
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public final void onUseCaseReset(UseCase useCase) {
        MapsKt__MapsKt.checkMainThread();
        this.mStateChangeCallback.onUseCaseReset(useCase);
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public final void onUseCaseUpdated(UseCase useCase) {
        MapsKt__MapsKt.checkMainThread();
        this.mStateChangeCallback.onUseCaseUpdated(useCase);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public final /* synthetic */ void setActiveResumingMode(boolean z) {
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public final /* synthetic */ void setExtendedConfig(Toolbar.AnonymousClass1 anonymousClass1) {
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public final /* synthetic */ void setPrimary(boolean z) {
    }
}
