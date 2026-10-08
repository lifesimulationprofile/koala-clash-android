package androidx.compose.ui.unit;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class TextUnitType {
    public final long type;

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m728equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m729toStringimpl(long j) {
        if (m728equalsimpl0(j, 0L)) {
            return "Unspecified";
        }
        if (m728equalsimpl0(j, 4294967296L)) {
            return "Sp";
        }
        return m728equalsimpl0(j, 8589934592L) ? "Em" : "Invalid";
    }

    public final boolean equals(Object obj) {
        if (obj instanceof TextUnitType) {
            return this.type == ((TextUnitType) obj).type;
        }
        return false;
    }

    public final int hashCode() {
        long j = this.type;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        return m729toStringimpl(this.type);
    }
}
