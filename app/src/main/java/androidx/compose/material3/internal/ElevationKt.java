package androidx.compose.material3.internal;

import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ElevationKt {
    public static final TweenSpec DefaultIncomingSpec;
    public static final TweenSpec DefaultOutgoingSpec;
    public static final TweenSpec HoveredOutgoingSpec;

    static {
        CubicBezierEasing cubicBezierEasing = new CubicBezierEasing(0.4f, 0.0f, 0.6f, 1.0f);
        DefaultIncomingSpec = new TweenSpec(120, 0, EasingKt.FastOutSlowInEasing);
        DefaultOutgoingSpec = new TweenSpec(150, 0, cubicBezierEasing);
        HoveredOutgoingSpec = new TweenSpec(120, 0, cubicBezierEasing);
    }
}
