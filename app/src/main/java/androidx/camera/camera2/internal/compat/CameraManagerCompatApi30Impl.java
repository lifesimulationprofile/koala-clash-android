package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class CameraManagerCompatApi30Impl extends CameraManagerCompatApi29Impl {
    @Override // coil.memory.RealStrongMemoryCache
    public final Set getConcurrentCameraIds() throws CameraAccessExceptionCompat {
        try {
            return ((CameraManager) this.weakMemoryCache).getConcurrentCameraIds();
        } catch (CameraAccessException e) {
            throw new CameraAccessExceptionCompat(e);
        }
    }
}
