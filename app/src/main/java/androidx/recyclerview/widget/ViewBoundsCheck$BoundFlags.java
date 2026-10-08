package androidx.recyclerview.widget;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewBoundsCheck$BoundFlags {
    public int mBoundFlags;
    public int mChildEnd;
    public int mChildStart;
    public int mRvEnd;
    public int mRvStart;

    public final boolean boundsMatch() {
        int i;
        int i2;
        int i3;
        int i4 = this.mBoundFlags;
        int i5 = 2;
        if ((i4 & 7) != 0) {
            int i6 = this.mChildStart;
            int i7 = this.mRvStart;
            if (i6 > i7) {
                i3 = 1;
            } else {
                i3 = i6 == i7 ? 2 : 4;
            }
            if ((i3 & i4) == 0) {
                return false;
            }
        }
        if ((i4 & 112) != 0) {
            int i8 = this.mChildStart;
            int i9 = this.mRvEnd;
            if (i8 > i9) {
                i2 = 1;
            } else {
                i2 = i8 == i9 ? 2 : 4;
            }
            if (((i2 << 4) & i4) == 0) {
                return false;
            }
        }
        if ((i4 & 1792) != 0) {
            int i10 = this.mChildEnd;
            int i11 = this.mRvStart;
            if (i10 > i11) {
                i = 1;
            } else {
                i = i10 == i11 ? 2 : 4;
            }
            if (((i << 8) & i4) == 0) {
                return false;
            }
        }
        if ((i4 & 28672) != 0) {
            int i12 = this.mChildEnd;
            int i13 = this.mRvEnd;
            if (i12 > i13) {
                i5 = 1;
            } else if (i12 != i13) {
                i5 = 4;
            }
            if ((i4 & (i5 << 12)) == 0) {
                return false;
            }
        }
        return true;
    }
}
