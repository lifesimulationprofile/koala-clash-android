package androidx.compose.ui.text;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class TextRange {
    public static final /* synthetic */ int $r8$clinit = 0;
    public static final long Zero = ParagraphKt.TextRange(0, 0);
    public final long packedValue;

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m637equalsimpl(long j, Object obj) {
        return (obj instanceof TextRange) && j == ((TextRange) obj).packedValue;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m638equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: getCollapsed-impl, reason: not valid java name */
    public static final boolean m639getCollapsedimpl(long j) {
        return ((int) (j >> 32)) == ((int) (j & 4294967295L));
    }

    /* JADX INFO: renamed from: getLength-impl, reason: not valid java name */
    public static final int m640getLengthimpl(long j) {
        return m641getMaximpl(j) - m642getMinimpl(j);
    }

    /* JADX INFO: renamed from: getMax-impl, reason: not valid java name */
    public static final int m641getMaximpl(long j) {
        return Math.max((int) (j >> 32), (int) (j & 4294967295L));
    }

    /* JADX INFO: renamed from: getMin-impl, reason: not valid java name */
    public static final int m642getMinimpl(long j) {
        return Math.min((int) (j >> 32), (int) (j & 4294967295L));
    }

    /* JADX INFO: renamed from: getReversed-impl, reason: not valid java name */
    public static final boolean m643getReversedimpl(long j) {
        return ((int) (j >> 32)) > ((int) (j & 4294967295L));
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m644toStringimpl(long j) {
        StringBuilder sb = new StringBuilder("TextRange(");
        sb.append((int) (j >> 32));
        sb.append(", ");
        return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, (int) (j & 4294967295L), ')');
    }

    public final boolean equals(Object obj) {
        return m637equalsimpl(this.packedValue, obj);
    }

    public final int hashCode() {
        long j = this.packedValue;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        return m644toStringimpl(this.packedValue);
    }
}
