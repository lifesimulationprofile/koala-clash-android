package androidx.compose.material3.internal.ripple;

import androidx.compose.ui.geometry.RoundRect;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class BorderKt {
    public static final RoundRect createInsetRoundedRect(float f, RoundRect roundRect) {
        return new RoundRect(f, f, roundRect.getWidth() - f, roundRect.getHeight() - f, m283shrinkKibmq7A(f, roundRect.topLeftCornerRadius), m283shrinkKibmq7A(f, roundRect.topRightCornerRadius), m283shrinkKibmq7A(f, roundRect.bottomRightCornerRadius), m283shrinkKibmq7A(f, roundRect.bottomLeftCornerRadius));
    }

    /* JADX INFO: renamed from: shrink-Kibmq7A, reason: not valid java name */
    public static final long m283shrinkKibmq7A(float f, long j) {
        float fMax = Math.max(0.0f, Float.intBitsToFloat((int) (j >> 32)) - f);
        float fMax2 = Math.max(0.0f, Float.intBitsToFloat((int) (j & 4294967295L)) - f);
        return (((long) Float.floatToRawIntBits(fMax)) << 32) | (((long) Float.floatToRawIntBits(fMax2)) & 4294967295L);
    }
}
