package coil.util;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import coil.network.HttpException;
import coil.request.DefaultRequestOptions;
import coil.request.ImageRequest;
import coil.size.DisplaySizeResolver;

/* JADX INFO: renamed from: coil.util.-Requests, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Requests {
    public static final DefaultRequestOptions DEFAULT_REQUEST_OPTIONS = new DefaultRequestOptions();

    public static final boolean getAllowInexactSize(ImageRequest imageRequest) {
        int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(imageRequest.precision);
        if (iOrdinal == 0) {
            return false;
        }
        if (iOrdinal != 1) {
            if (iOrdinal != 2) {
                throw new HttpException();
            }
            if (imageRequest.defined.sizeResolver != null || !(imageRequest.sizeResolver instanceof DisplaySizeResolver)) {
                return false;
            }
        }
        return true;
    }
}
