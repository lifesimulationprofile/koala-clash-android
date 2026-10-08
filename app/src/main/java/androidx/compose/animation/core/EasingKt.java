package androidx.compose.animation.core;

import androidx.camera.camera2.internal.ZslControlImpl$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class EasingKt {
    public static final CubicBezierEasing FastOutLinearInEasing;
    public static final CubicBezierEasing FastOutSlowInEasing = new CubicBezierEasing(0.4f, 0.0f, 0.2f, 1.0f);
    public static final ZslControlImpl$$ExternalSyntheticLambda0 LinearEasing;

    static {
        new CubicBezierEasing(0.0f, 0.0f, 0.2f, 1.0f);
        FastOutLinearInEasing = new CubicBezierEasing(0.4f, 0.0f, 1.0f, 1.0f);
        LinearEasing = new ZslControlImpl$$ExternalSyntheticLambda0(6);
    }
}
