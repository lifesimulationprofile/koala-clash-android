package androidx.compose.ui.unit;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class IntOffset {
    public final long packedValue;

    public /* synthetic */ IntOffset(long j) {
        this.packedValue = j;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m709equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: minus-qkQi6aY, reason: not valid java name */
    public static final long m710minusqkQi6aY(long j, long j2) {
        return (((long) (((int) (j >> 32)) - ((int) (j2 >> 32)))) << 32) | (((long) (((int) (j & 4294967295L)) - ((int) (j2 & 4294967295L)))) & 4294967295L);
    }

    /* JADX INFO: renamed from: plus-qkQi6aY, reason: not valid java name */
    public static final long m711plusqkQi6aY(long j, long j2) {
        return (((long) (((int) (j >> 32)) + ((int) (j2 >> 32)))) << 32) | (((long) (((int) (j & 4294967295L)) + ((int) (j2 & 4294967295L)))) & 4294967295L);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m712toStringimpl(long j) {
        StringBuilder sb = new StringBuilder("(");
        sb.append((int) (j >> 32));
        sb.append(", ");
        return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, (int) (j & 4294967295L), ')');
    }

    public final boolean equals(Object obj) {
        if (obj instanceof IntOffset) {
            return this.packedValue == ((IntOffset) obj).packedValue;
        }
        return false;
    }

    public final int hashCode() {
        long j = this.packedValue;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        return m712toStringimpl(this.packedValue);
    }
}
