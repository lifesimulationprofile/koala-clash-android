package androidx.compose.ui.unit;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class Dp implements Comparable {
    public final float value;

    /* JADX INFO: renamed from: compareTo-0680j_4, reason: not valid java name */
    public static int m700compareTo0680j_4(float f, float f2) {
        if (Float.isNaN(f) || Float.isNaN(f2)) {
            return 0;
        }
        return Float.compare(f, f2);
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m701equalsimpl0(float f, float f2) {
        return Float.compare(f, f2) == 0;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m702toStringimpl(float f) {
        if (Float.isNaN(f)) {
            return "Dp.Unspecified";
        }
        return f + ".dp";
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return m700compareTo0680j_4(this.value, ((Dp) obj).value);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Dp) {
            return Float.compare(this.value, ((Dp) obj).value) == 0;
        }
        return false;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.value);
    }

    public final String toString() {
        return m702toStringimpl(this.value);
    }
}
