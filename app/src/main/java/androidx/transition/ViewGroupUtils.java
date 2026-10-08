package androidx.transition;

import android.os.Build;
import android.view.ViewGroup;
import androidx.tracing.TraceApi29Impl;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ViewGroupUtils {
    public static boolean sTryHiddenSuppressLayout = true;

    public static void suppressLayout(ViewGroup viewGroup, boolean z) {
        if (Build.VERSION.SDK_INT >= 29) {
            TraceApi29Impl.suppressLayout(viewGroup, z);
        } else if (sTryHiddenSuppressLayout) {
            try {
                TraceApi29Impl.suppressLayout(viewGroup, z);
            } catch (NoSuchMethodError unused) {
                sTryHiddenSuppressLayout = false;
            }
        }
    }
}
