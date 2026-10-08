package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import androidx.camera.core.impl.utils.executor.SequentialExecutor;
import androidx.work.impl.StartStopTokens;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class CameraCaptureSessionCompatApi28Impl extends StartStopTokens {
    @Override // androidx.work.impl.StartStopTokens
    public final int captureBurstRequests(ArrayList arrayList, SequentialExecutor sequentialExecutor, CameraCaptureSession.CaptureCallback captureCallback) {
        return ((CameraCaptureSession) this.runs).captureBurstRequests(arrayList, sequentialExecutor, captureCallback);
    }

    @Override // androidx.work.impl.StartStopTokens
    public final int setSingleRepeatingRequest(CaptureRequest captureRequest, SequentialExecutor sequentialExecutor, CameraCaptureSession.CaptureCallback captureCallback) {
        return ((CameraCaptureSession) this.runs).setSingleRepeatingRequest(captureRequest, sequentialExecutor, captureCallback);
    }
}
