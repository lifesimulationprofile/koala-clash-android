package androidx.camera.core.internal;

import android.util.Rational;
import android.util.Size;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.ImageOutputConfig;
import kotlin.collections.AbstractList;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class SupportedOutputSizesSorterLegacy {
    public final Rational mFullFovRatio;
    public final boolean mIsSensorLandscapeResolution;
    public final int mLensFacing;
    public final int mSensorOrientation;

    public SupportedOutputSizesSorterLegacy(CameraInfoInternal cameraInfoInternal, Rational rational) {
        this.mSensorOrientation = cameraInfoInternal.getSensorRotationDegrees();
        this.mLensFacing = cameraInfoInternal.getLensFacing();
        this.mFullFovRatio = rational;
        boolean z = true;
        if (rational != null && rational.getNumerator() < rational.getDenominator()) {
            z = false;
        }
        this.mIsSensorLandscapeResolution = z;
    }

    public final Size getTargetSize(ImageOutputConfig imageOutputConfig) {
        int targetRotation = imageOutputConfig.getTargetRotation();
        Size targetResolution = imageOutputConfig.getTargetResolution();
        if (targetResolution != null) {
            int relativeImageRotation = AbstractList.Companion.getRelativeImageRotation(AbstractList.Companion.surfaceRotationToDegrees(targetRotation), this.mSensorOrientation, 1 == this.mLensFacing);
            if (relativeImageRotation == 90 || relativeImageRotation == 270) {
                return new Size(targetResolution.getHeight(), targetResolution.getWidth());
            }
        }
        return targetResolution;
    }
}
