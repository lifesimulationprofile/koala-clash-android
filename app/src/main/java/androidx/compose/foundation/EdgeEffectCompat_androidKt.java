package androidx.compose.foundation;

import android.view.ViewConfiguration;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class EdgeEffectCompat_androidKt {
    public static final double DecelMinusOne;
    public static final double DecelerationRate;
    public static final float PlatformFlingScrollFriction = ViewConfiguration.getScrollFriction();

    static {
        double dLog = Math.log(0.78d) / Math.log(0.9d);
        DecelerationRate = dLog;
        DecelMinusOne = dLog - 1.0d;
    }
}
