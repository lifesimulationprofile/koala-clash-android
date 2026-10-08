package androidx.camera.camera2.internal;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import androidx.activity.OnBackPressedDispatcher$$ExternalSyntheticLambda0;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.impl.utils.executor.SequentialExecutor;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.lifecycle.MutableLiveData;
import io.github.g00fy2.quickie.extensions.BarcodeExtensionsKt;
import kotlin.collections.MapsKt__MapsKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class TorchControl {
    public final Camera2CameraControlImpl mCamera2CameraControlImpl;
    public CallbackToFutureAdapter.Completer mEnableTorchCompleter;
    public final SequentialExecutor mExecutor;
    public final boolean mHasFlashUnit;
    public boolean mIsActive;
    public boolean mTargetTorchEnabled;
    public final MutableLiveData mTorchState = new MutableLiveData(0);

    public TorchControl(Camera2CameraControlImpl camera2CameraControlImpl, CameraCharacteristicsCompat cameraCharacteristicsCompat, SequentialExecutor sequentialExecutor) {
        this.mCamera2CameraControlImpl = camera2CameraControlImpl;
        this.mExecutor = sequentialExecutor;
        this.mHasFlashUnit = BarcodeExtensionsKt.isFlashAvailable(new OnBackPressedDispatcher$$ExternalSyntheticLambda0(3, cameraCharacteristicsCompat));
        camera2CameraControlImpl.addCaptureResultListener(new Camera2CameraControlImpl.CaptureResultListener() { // from class: androidx.camera.camera2.internal.TorchControl$$ExternalSyntheticLambda1
            @Override // androidx.camera.camera2.internal.Camera2CameraControlImpl.CaptureResultListener
            public final boolean onCaptureResult(TotalCaptureResult totalCaptureResult) {
                TorchControl torchControl = this.f$0;
                if (torchControl.mEnableTorchCompleter != null) {
                    Integer num = (Integer) totalCaptureResult.getRequest().get(CaptureRequest.FLASH_MODE);
                    if ((num != null && num.intValue() == 2) == torchControl.mTargetTorchEnabled) {
                        torchControl.mEnableTorchCompleter.set(null);
                        torchControl.mEnableTorchCompleter = null;
                    }
                }
                return false;
            }
        });
    }

    public static void setLiveDataValue(MutableLiveData mutableLiveData, Integer num) {
        if (MapsKt__MapsKt.isMainThread()) {
            mutableLiveData.setValue(num);
        } else {
            mutableLiveData.postValue(num);
        }
    }
}
