package kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ULong implements Comparable {
    public final long data;

    public /* synthetic */ ULong(long j) {
        this.data = j;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m836hashCodeimpl(long j) {
        return (int) (j ^ (j >>> 32));
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return Intrinsics.compare(this.data ^ Long.MIN_VALUE, ((ULong) obj).data ^ Long.MIN_VALUE);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ULong) {
            return this.data == ((ULong) obj).data;
        }
        return false;
    }

    public final int hashCode() {
        return m836hashCodeimpl(this.data);
    }

    public final String toString() {
        long j = this.data;
        if (j >= 0) {
            CharsKt.checkRadix(10);
            return Long.toString(j, 10);
        }
        long j2 = 10;
        long j3 = ((j >>> 1) / j2) << 1;
        long j4 = j - (j3 * j2);
        if (j4 >= j2) {
            j4 -= j2;
            j3++;
        }
        CharsKt.checkRadix(10);
        String string = Long.toString(j3, 10);
        CharsKt.checkRadix(10);
        return string.concat(Long.toString(j4, 10));
    }
}
