package androidx.compose.ui.unit;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class DpSize {
    public final long packedValue;

    /* JADX INFO: renamed from: getHeight-D9Ej5fM, reason: not valid java name */
    public static final float m707getHeightD9Ej5fM(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* JADX INFO: renamed from: getWidth-D9Ej5fM, reason: not valid java name */
    public static final float m708getWidthD9Ej5fM(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof DpSize) {
            return this.packedValue == ((DpSize) obj).packedValue;
        }
        return false;
    }

    public final int hashCode() {
        long j = this.packedValue;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        long j = this.packedValue;
        if (j == 9205357640488583168L) {
            return "DpSize.Unspecified";
        }
        return ((Object) Dp.m702toStringimpl(m708getWidthD9Ej5fM(j))) + " x " + ((Object) Dp.m702toStringimpl(m707getHeightD9Ej5fM(j)));
    }
}
