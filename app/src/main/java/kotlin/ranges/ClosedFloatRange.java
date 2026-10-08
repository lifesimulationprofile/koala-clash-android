package kotlin.ranges;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ClosedFloatRange {
    public final boolean equals(Object obj) {
        return obj instanceof ClosedFloatRange;
    }

    public final int hashCode() {
        return Float.floatToIntBits(0.0f) + (Float.floatToIntBits(0.0f) * 31);
    }

    public final String toString() {
        return "0.0..0.0";
    }
}
