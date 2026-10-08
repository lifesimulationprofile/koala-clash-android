package androidx.camera.core.impl;

import androidx.camera.view.PreviewStreamStateObserver$2;
import androidx.lifecycle.LiveData;
import java.util.List;
import java.util.concurrent.Executor;
import okhttp3.Headers;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface CameraInfoInternal {
    void addSessionCaptureCallback(Executor executor, PreviewStreamStateObserver$2 previewStreamStateObserver$2);

    String getCameraId();

    Headers.Builder getCameraQuirks();

    CameraInfoInternal getImplementation();

    String getImplementationType();

    int getLensFacing();

    int getSensorRotationDegrees();

    int getSensorRotationDegrees(int i);

    List getSupportedResolutions(int i);

    LiveData getTorchState();

    boolean hasFlashUnit();

    void removeSessionCaptureCallback(CameraCaptureCallback cameraCaptureCallback);
}
