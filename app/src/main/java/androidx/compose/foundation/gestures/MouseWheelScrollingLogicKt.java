package androidx.compose.foundation.gestures;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class MouseWheelScrollingLogicKt {
    public static final float AnimationThreshold = 6;
    public static final float AnimationSpeed = 1;

    public static final boolean access$isLowScrollingDelta(float f) {
        return Float.isNaN(f) || Math.abs(f) < 0.5f;
    }
}
