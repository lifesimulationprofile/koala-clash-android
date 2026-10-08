package coil.decode;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import coil.network.HttpException;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class DecodeUtils {
    public static final double computeSizeMultiplier(int i, int i2, int i3, int i4, int i5) {
        double d = ((double) i3) / ((double) i);
        double d2 = ((double) i4) / ((double) i2);
        int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i5);
        if (iOrdinal == 0) {
            return Math.max(d, d2);
        }
        if (iOrdinal == 1) {
            return Math.min(d, d2);
        }
        throw new HttpException();
    }
}
