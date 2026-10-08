package androidx.compose.ui.platform;

import androidx.compose.ui.unit.IntSize;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class DerivedSize {
    public static final DerivedSize Zero = new DerivedSize(0, 0);
    public final long dpSize;
    public final long pxSize;

    public DerivedSize(long j, long j2) {
        this.pxSize = j;
        this.dpSize = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DerivedSize) {
            DerivedSize derivedSize = (DerivedSize) obj;
            return IntSize.m717equalsimpl0(this.pxSize, derivedSize.pxSize) && this.dpSize == derivedSize.dpSize;
        }
        return false;
    }

    public final int hashCode() {
        long j = this.pxSize;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        long j2 = this.dpSize;
        return ((int) ((j2 >>> 32) ^ j2)) + i;
    }
}
