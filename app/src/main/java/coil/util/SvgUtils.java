package coil.util;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import coil.network.HttpException;
import coil.size.Dimension;

/* JADX INFO: renamed from: coil.util.-SvgUtils, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SvgUtils {
    public static final float toPx(Dimension dimension, int i) {
        if (dimension instanceof Dimension.Pixels) {
            return ((Dimension.Pixels) dimension).px;
        }
        int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i);
        if (iOrdinal == 0) {
            return Float.MIN_VALUE;
        }
        if (iOrdinal == 1) {
            return Float.MAX_VALUE;
        }
        throw new HttpException();
    }
}
