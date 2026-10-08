package androidx.camera.core.impl.utils;

import android.view.Surface;
import androidx.room.TransactionElement;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SurfaceUtil {
    static {
        System.loadLibrary("surface_util_jni");
    }

    public static TransactionElement.Key getSurfaceInfo(Surface surface) {
        int[] iArrNativeGetSurfaceInfo = nativeGetSurfaceInfo(surface);
        TransactionElement.Key key = new TransactionElement.Key(5);
        int i = iArrNativeGetSurfaceInfo[0];
        int i2 = iArrNativeGetSurfaceInfo[1];
        int i3 = iArrNativeGetSurfaceInfo[2];
        return key;
    }

    private static native int[] nativeGetSurfaceInfo(Surface surface);
}
