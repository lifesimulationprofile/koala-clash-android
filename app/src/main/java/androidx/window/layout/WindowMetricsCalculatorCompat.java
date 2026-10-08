package androidx.window.layout;

import android.os.Build;
import androidx.camera.core.impl.utils.MatrixExt;
import androidx.window.layout.util.BoundsHelperApi16Impl;
import androidx.window.layout.util.DensityCompatHelper;
import androidx.window.layout.util.DensityCompatHelperApi34Impl;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class WindowMetricsCalculatorCompat implements WindowMetricsCalculator {
    public final DensityCompatHelper densityCompatHelper;

    public WindowMetricsCalculatorCompat() {
        this.densityCompatHelper = Build.VERSION.SDK_INT >= 34 ? DensityCompatHelperApi34Impl.INSTANCE : BoundsHelperApi16Impl.INSTANCE$4;
        MatrixExt.arrayListOf(1, 2, 4, 8, 16, 32, 64, 128);
    }
}
