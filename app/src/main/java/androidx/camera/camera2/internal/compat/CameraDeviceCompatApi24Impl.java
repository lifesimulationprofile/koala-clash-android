package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.params.InputConfiguration;
import android.os.Handler;
import androidx.camera.camera2.internal.compat.params.InputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.work.impl.WorkLauncherImpl;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public class CameraDeviceCompatApi24Impl extends WorkLauncherImpl {
    @Override // androidx.work.impl.WorkLauncherImpl
    public void createCaptureSession(SessionConfigurationCompat sessionConfigurationCompat) throws CameraAccessExceptionCompat {
        CameraDevice cameraDevice = (CameraDevice) this.processor;
        WorkLauncherImpl.checkPreconditions(cameraDevice, sessionConfigurationCompat);
        SessionConfigurationCompat.SessionConfigurationCompatImpl sessionConfigurationCompatImpl = sessionConfigurationCompat.mImpl;
        CameraCaptureSessionCompat$StateCallbackExecutorWrapper cameraCaptureSessionCompat$StateCallbackExecutorWrapper = new CameraCaptureSessionCompat$StateCallbackExecutorWrapper(sessionConfigurationCompatImpl.getExecutor(), sessionConfigurationCompatImpl.getStateCallback());
        List outputConfigurations = sessionConfigurationCompatImpl.getOutputConfigurations();
        CameraDeviceCompatBaseImpl$CameraDeviceCompatParamsApi21 cameraDeviceCompatBaseImpl$CameraDeviceCompatParamsApi21 = (CameraDeviceCompatBaseImpl$CameraDeviceCompatParamsApi21) this.workTaskExecutor;
        cameraDeviceCompatBaseImpl$CameraDeviceCompatParamsApi21.getClass();
        Handler handler = cameraDeviceCompatBaseImpl$CameraDeviceCompatParamsApi21.mCompatHandler;
        InputConfigurationCompat inputConfiguration = sessionConfigurationCompatImpl.getInputConfiguration();
        try {
            if (inputConfiguration != null) {
                InputConfiguration inputConfiguration2 = inputConfiguration.mImpl.mObject;
                inputConfiguration2.getClass();
                cameraDevice.createReprocessableCaptureSessionByConfigurations(inputConfiguration2, SessionConfigurationCompat.transformFromCompat(outputConfigurations), cameraCaptureSessionCompat$StateCallbackExecutorWrapper, handler);
            } else if (sessionConfigurationCompatImpl.getSessionType() == 1) {
                cameraDevice.createConstrainedHighSpeedCaptureSession(WorkLauncherImpl.unpackSurfaces(outputConfigurations), cameraCaptureSessionCompat$StateCallbackExecutorWrapper, handler);
            } else {
                cameraDevice.createCaptureSessionByOutputConfigurations(SessionConfigurationCompat.transformFromCompat(outputConfigurations), cameraCaptureSessionCompat$StateCallbackExecutorWrapper, handler);
            }
        } catch (CameraAccessException e) {
            throw new CameraAccessExceptionCompat(e);
        }
    }
}
