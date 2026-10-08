package kotlin;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class UByte implements Comparable {
    public final byte data;

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        return Intrinsics.compare(this.data & 255, ((UByte) obj).data & 255);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof UByte) {
            return this.data == ((UByte) obj).data;
        }
        return false;
    }

    public final int hashCode() {
        return this.data;
    }

    public final String toString() {
        return String.valueOf(this.data & 255);
    }
}
