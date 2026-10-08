package androidx.compose.ui.unit;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class TextUnit {
    public static final TextUnitType[] TextUnitTypes = {new TextUnitType(0), new TextUnitType(4294967296L), new TextUnitType(8589934592L)};
    public static final long Unspecified = TextUnitKt.pack(Float.NaN, 0);
    public final long packedValue;

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m722equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: getType-UIouoOA, reason: not valid java name */
    public static final long m723getTypeUIouoOA(long j) {
        return TextUnitTypes[(int) ((j & 1095216660480L) >>> 32)].type;
    }

    /* JADX INFO: renamed from: getValue-impl, reason: not valid java name */
    public static final float m724getValueimpl(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m725hashCodeimpl(long j) {
        return (int) (j ^ (j >>> 32));
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m726toStringimpl(long j) {
        long jM723getTypeUIouoOA = m723getTypeUIouoOA(j);
        if (TextUnitType.m728equalsimpl0(jM723getTypeUIouoOA, 0L)) {
            return "Unspecified";
        }
        if (TextUnitType.m728equalsimpl0(jM723getTypeUIouoOA, 4294967296L)) {
            return m724getValueimpl(j) + ".sp";
        }
        if (!TextUnitType.m728equalsimpl0(jM723getTypeUIouoOA, 8589934592L)) {
            return "Invalid";
        }
        return m724getValueimpl(j) + ".em";
    }

    public final boolean equals(Object obj) {
        if (obj instanceof TextUnit) {
            return this.packedValue == ((TextUnit) obj).packedValue;
        }
        return false;
    }

    public final int hashCode() {
        return m725hashCodeimpl(this.packedValue);
    }

    public final String toString() {
        return m726toStringimpl(this.packedValue);
    }
}
