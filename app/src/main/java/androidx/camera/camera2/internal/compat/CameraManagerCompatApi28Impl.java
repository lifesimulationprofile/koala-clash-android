package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import androidx.camera.camera2.internal.Camera2CameraImpl;
import androidx.camera.core.impl.utils.executor.SequentialExecutor;
import coil.memory.RealStrongMemoryCache;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public class CameraManagerCompatApi28Impl extends RealStrongMemoryCache {
    public static boolean isDndFailCase(RuntimeException runtimeException) {
        StackTraceElement[] stackTrace;
        if (Build.VERSION.SDK_INT == 28) {
            if ((!runtimeException.getClass().equals(RuntimeException.class) || (stackTrace = runtimeException.getStackTrace()) == null || stackTrace.length < 0) ? false : "_enableShutterSound".equals(stackTrace[0].getMethodName())) {
                return true;
            }
        }
        return false;
    }

    @Override // coil.memory.RealStrongMemoryCache
    public CameraCharacteristics getCameraCharacteristics(String str) throws CameraAccessExceptionCompat {
        try {
            return super.getCameraCharacteristics(str);
        } catch (RuntimeException e) {
            if (isDndFailCase(e)) {
                throw new CameraAccessExceptionCompat(e);
            }
            throw e;
        }
    }

    @Override // coil.memory.RealStrongMemoryCache
    public void openCamera(String str, Executor executor, CameraDevice.StateCallback stateCallback) throws CameraAccessExceptionCompat {
        try {
            ((CameraManager) this.weakMemoryCache).openCamera(str, executor, stateCallback);
        } catch (CameraAccessException e) {
            throw new CameraAccessExceptionCompat(e);
        } catch (IllegalArgumentException e2) {
        } catch (SecurityException e3) {
            throw e3;
        } catch (RuntimeException e4) {
            if (!isDndFailCase(e4)) {
                throw e4;
            }
            throw new CameraAccessExceptionCompat(e4);
        }
    }

    @Override // coil.memory.RealStrongMemoryCache
    public final void registerAvailabilityCallback(SequentialExecutor sequentialExecutor, Camera2CameraImpl.CameraAvailability cameraAvailability) {
        ((CameraManager) this.weakMemoryCache).registerAvailabilityCallback(sequentialExecutor, cameraAvailability);
    }

    @Override // coil.memory.RealStrongMemoryCache
    public final void unregisterAvailabilityCallback(CameraManager.AvailabilityCallback availabilityCallback) {
        ((CameraManager) this.weakMemoryCache).unregisterAvailabilityCallback(availabilityCallback);
    }
}
