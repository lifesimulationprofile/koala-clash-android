package androidx.camera.core.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.camera.core.CameraSelector;
import androidx.core.widget.TextViewCompat;
import coil.request.RequestService;
import java.util.LinkedHashSet;
import kotlin.LazyKt__LazyJVMKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class CameraValidator {
    public static final CameraSelector EXTERNAL_LENS_FACING;

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class CameraIdListIncorrectException extends Exception {
        public final int mAvailableCameraCount;

        public CameraIdListIncorrectException(String str, int i, IllegalArgumentException illegalArgumentException) {
            super(str, illegalArgumentException);
            this.mAvailableCameraCount = i;
        }
    }

    static {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new LensFacingCameraFilter(2));
        EXTERNAL_LENS_FACING = new CameraSelector(linkedHashSet);
    }

    public static void validateCameras(Context context, RequestService requestService, CameraSelector cameraSelector) throws CameraIdListIncorrectException {
        Integer lensFacing;
        int i = 0;
        IllegalArgumentException illegalArgumentException = null;
        if (Build.VERSION.SDK_INT >= 34 && TextViewCompat.Api34Impl.getDeviceId(context) != 0) {
            LinkedHashSet cameras = requestService.getCameras();
            if (cameras.isEmpty()) {
                throw new CameraIdListIncorrectException("No cameras available", 0, null);
            }
            LazyKt__LazyJVMKt.d("CameraValidator", "Virtual device with ID: " + TextViewCompat.Api34Impl.getDeviceId(context) + " has " + cameras.size() + " cameras. Skipping validation.");
            return;
        }
        if (cameraSelector != null) {
            try {
                lensFacing = cameraSelector.getLensFacing();
                if (lensFacing == null) {
                    LazyKt__LazyJVMKt.w("CameraValidator", "No lens facing info in the availableCamerasSelector, don't verify the camera lens facing.");
                    return;
                }
            } catch (IllegalStateException e) {
                LazyKt__LazyJVMKt.e("CameraValidator", "Cannot get lens facing from the availableCamerasSelector don't verify the camera lens facing.", e);
                return;
            }
        } else {
            lensFacing = null;
        }
        LazyKt__LazyJVMKt.d("CameraValidator", "Verifying camera lens facing on " + Build.DEVICE + ", lensFacingInteger: " + lensFacing);
        PackageManager packageManager = context.getPackageManager();
        try {
            if (packageManager.hasSystemFeature("android.hardware.camera") && (cameraSelector == null || lensFacing.intValue() == 1)) {
                CameraSelector.DEFAULT_BACK_CAMERA.select(requestService.getCameras());
                i = 1;
            }
        } catch (IllegalArgumentException e2) {
            illegalArgumentException = e2;
            LazyKt__LazyJVMKt.w("CameraValidator", "Camera LENS_FACING_BACK verification failed", illegalArgumentException);
        }
        try {
            if (packageManager.hasSystemFeature("android.hardware.camera.front") && (cameraSelector == null || lensFacing.intValue() == 0)) {
                CameraSelector.DEFAULT_FRONT_CAMERA.select(requestService.getCameras());
                i++;
            }
        } catch (IllegalArgumentException e3) {
            illegalArgumentException = e3;
            LazyKt__LazyJVMKt.w("CameraValidator", "Camera LENS_FACING_FRONT verification failed", illegalArgumentException);
        }
        try {
            EXTERNAL_LENS_FACING.select(requestService.getCameras());
            LazyKt__LazyJVMKt.d("CameraValidator", "Found a LENS_FACING_EXTERNAL camera");
            i++;
        } catch (IllegalArgumentException unused) {
        }
        if (illegalArgumentException == null) {
            return;
        }
        LazyKt__LazyJVMKt.e("CameraValidator", "Camera LensFacing verification failed, existing cameras: " + requestService.getCameras());
        throw new CameraIdListIncorrectException("Expected camera missing from device.", i, illegalArgumentException);
    }
}
