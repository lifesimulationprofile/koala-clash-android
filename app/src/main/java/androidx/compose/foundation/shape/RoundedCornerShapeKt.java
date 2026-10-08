package androidx.compose.foundation.shape;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class RoundedCornerShapeKt {
    public static final RoundedCornerShape CircleShape;

    static {
        PercentCornerSize percentCornerSize = new PercentCornerSize(50);
        CircleShape = new RoundedCornerShape(percentCornerSize, percentCornerSize, percentCornerSize, percentCornerSize);
    }

    /* JADX INFO: renamed from: RoundedCornerShape-0680j_4, reason: not valid java name */
    public static final RoundedCornerShape m156RoundedCornerShape0680j_4(float f) {
        DpCornerSize dpCornerSize = new DpCornerSize(f);
        return new RoundedCornerShape(dpCornerSize, dpCornerSize, dpCornerSize, dpCornerSize);
    }
}
