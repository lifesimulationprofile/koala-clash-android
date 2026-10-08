package androidx.camera.camera2.impl;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import androidx.appcompat.widget.Toolbar;
import androidx.camera.core.impl.AutoValue_Config_Option;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class Camera2ImplConfig extends Toolbar.AnonymousClass1 {
    public static final AutoValue_Config_Option TEMPLATE_TYPE_OPTION = new AutoValue_Config_Option("camera2.captureRequest.templateType", Integer.TYPE, null);
    public static final AutoValue_Config_Option STREAM_USE_CASE_OPTION = new AutoValue_Config_Option("camera2.cameraCaptureSession.streamUseCase", Long.TYPE, null);
    public static final AutoValue_Config_Option DEVICE_STATE_CALLBACK_OPTION = new AutoValue_Config_Option("camera2.cameraDevice.stateCallback", CameraDevice.StateCallback.class, null);
    public static final AutoValue_Config_Option SESSION_STATE_CALLBACK_OPTION = new AutoValue_Config_Option("camera2.cameraCaptureSession.stateCallback", CameraCaptureSession.StateCallback.class, null);
    public static final AutoValue_Config_Option SESSION_CAPTURE_CALLBACK_OPTION = new AutoValue_Config_Option("camera2.cameraCaptureSession.captureCallback", CameraCaptureSession.CaptureCallback.class, null);
    public static final AutoValue_Config_Option SESSION_PHYSICAL_CAMERA_ID_OPTION = new AutoValue_Config_Option("camera2.cameraCaptureSession.physicalCameraId", String.class, null);

    public static AutoValue_Config_Option createCaptureRequestOption(CaptureRequest.Key key) {
        return new AutoValue_Config_Option("camera2.captureRequest.option." + key.getName(), Object.class, key);
    }
}
