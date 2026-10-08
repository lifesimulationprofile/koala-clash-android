package androidx.compose.ui.unit;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ConstraintsKt {
    public static final long Constraints(int i, int i2, int i3, int i4) {
        if (!((i3 >= 0) & (i2 >= i) & (i4 >= i3) & (i >= 0))) {
            InlineClassHelperKt.throwIllegalArgumentException("maxWidth must be >= than minWidth,\nmaxHeight must be >= than minHeight,\nminWidth and minHeight must be >= 0");
        }
        return createConstraints(i, i2, i3, i4);
    }

    public static /* synthetic */ long Constraints$default(int i, int i2, int i3, int i4, int i5) {
        if ((i5 & 1) != 0) {
            i = 0;
        }
        if ((i5 & 2) != 0) {
            i2 = Integer.MAX_VALUE;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = Integer.MAX_VALUE;
        }
        return Constraints(i, i2, i3, i4);
    }

    public static final int bitsNeedForSizeUnchecked(int i) {
        if (i < 8191) {
            return 13;
        }
        if (i < 32767) {
            return 15;
        }
        if (i < 65535) {
            return 16;
        }
        return i < 262143 ? 18 : 255;
    }

    /* JADX INFO: renamed from: constrain-4WqzIAM, reason: not valid java name */
    public static final long m687constrain4WqzIAM(long j, long j2) {
        int i = (int) (j2 >> 32);
        int iM683getMinWidthimpl = Constraints.m683getMinWidthimpl(j);
        int iM681getMaxWidthimpl = Constraints.m681getMaxWidthimpl(j);
        if (i < iM683getMinWidthimpl) {
            i = iM683getMinWidthimpl;
        }
        if (i <= iM681getMaxWidthimpl) {
            iM681getMaxWidthimpl = i;
        }
        int i2 = (int) (j2 & 4294967295L);
        int iM682getMinHeightimpl = Constraints.m682getMinHeightimpl(j);
        int iM680getMaxHeightimpl = Constraints.m680getMaxHeightimpl(j);
        if (i2 < iM682getMinHeightimpl) {
            i2 = iM682getMinHeightimpl;
        }
        if (i2 <= iM680getMaxHeightimpl) {
            iM680getMaxHeightimpl = i2;
        }
        return (((long) iM681getMaxWidthimpl) << 32) | (4294967295L & ((long) iM680getMaxHeightimpl));
    }

    /* JADX INFO: renamed from: constrain-N9IONVI, reason: not valid java name */
    public static final long m688constrainN9IONVI(long j, long j2) {
        int iM683getMinWidthimpl = Constraints.m683getMinWidthimpl(j);
        int iM681getMaxWidthimpl = Constraints.m681getMaxWidthimpl(j);
        int iM682getMinHeightimpl = Constraints.m682getMinHeightimpl(j);
        int iM680getMaxHeightimpl = Constraints.m680getMaxHeightimpl(j);
        int iM683getMinWidthimpl2 = Constraints.m683getMinWidthimpl(j2);
        if (iM683getMinWidthimpl2 < iM683getMinWidthimpl) {
            iM683getMinWidthimpl2 = iM683getMinWidthimpl;
        }
        if (iM683getMinWidthimpl2 > iM681getMaxWidthimpl) {
            iM683getMinWidthimpl2 = iM681getMaxWidthimpl;
        }
        int iM681getMaxWidthimpl2 = Constraints.m681getMaxWidthimpl(j2);
        if (iM681getMaxWidthimpl2 >= iM683getMinWidthimpl) {
            iM683getMinWidthimpl = iM681getMaxWidthimpl2;
        }
        if (iM683getMinWidthimpl <= iM681getMaxWidthimpl) {
            iM681getMaxWidthimpl = iM683getMinWidthimpl;
        }
        int iM682getMinHeightimpl2 = Constraints.m682getMinHeightimpl(j2);
        if (iM682getMinHeightimpl2 < iM682getMinHeightimpl) {
            iM682getMinHeightimpl2 = iM682getMinHeightimpl;
        }
        if (iM682getMinHeightimpl2 > iM680getMaxHeightimpl) {
            iM682getMinHeightimpl2 = iM680getMaxHeightimpl;
        }
        int iM680getMaxHeightimpl2 = Constraints.m680getMaxHeightimpl(j2);
        if (iM680getMaxHeightimpl2 >= iM682getMinHeightimpl) {
            iM682getMinHeightimpl = iM680getMaxHeightimpl2;
        }
        if (iM682getMinHeightimpl <= iM680getMaxHeightimpl) {
            iM680getMaxHeightimpl = iM682getMinHeightimpl;
        }
        return Constraints(iM683getMinWidthimpl2, iM681getMaxWidthimpl, iM682getMinHeightimpl2, iM680getMaxHeightimpl);
    }

    /* JADX INFO: renamed from: constrainHeight-K40F9xA, reason: not valid java name */
    public static final int m689constrainHeightK40F9xA(int i, long j) {
        int iM682getMinHeightimpl = Constraints.m682getMinHeightimpl(j);
        int iM680getMaxHeightimpl = Constraints.m680getMaxHeightimpl(j);
        if (i < iM682getMinHeightimpl) {
            i = iM682getMinHeightimpl;
        }
        return i > iM680getMaxHeightimpl ? iM680getMaxHeightimpl : i;
    }

    /* JADX INFO: renamed from: constrainWidth-K40F9xA, reason: not valid java name */
    public static final int m690constrainWidthK40F9xA(int i, long j) {
        int iM683getMinWidthimpl = Constraints.m683getMinWidthimpl(j);
        int iM681getMaxWidthimpl = Constraints.m681getMaxWidthimpl(j);
        if (i < iM683getMinWidthimpl) {
            i = iM683getMinWidthimpl;
        }
        return i > iM681getMaxWidthimpl ? iM681getMaxWidthimpl : i;
    }

    public static final long createConstraints(int i, int i2, int i3, int i4) {
        int i5 = i4 == Integer.MAX_VALUE ? i3 : i4;
        int iBitsNeedForSizeUnchecked = bitsNeedForSizeUnchecked(i5);
        int i6 = i2 == Integer.MAX_VALUE ? i : i2;
        int iBitsNeedForSizeUnchecked2 = bitsNeedForSizeUnchecked(i6);
        if (iBitsNeedForSizeUnchecked + iBitsNeedForSizeUnchecked2 > 31) {
            throwInvalidConstraintException(i6, i5);
        }
        int i7 = i2 + 1;
        int i8 = i4 + 1;
        int i9 = iBitsNeedForSizeUnchecked2 - 13;
        return (((long) (i7 & (~(i7 >> 31)))) << 33) | ((long) ((i9 >> 1) + (i9 & 1))) | (((long) i) << 2) | (((long) i3) << (iBitsNeedForSizeUnchecked2 + 2)) | (((long) (i8 & (~(i8 >> 31)))) << (iBitsNeedForSizeUnchecked2 + 33));
    }

    /* JADX INFO: renamed from: offset-NN6Ew-U, reason: not valid java name */
    public static final long m691offsetNN6EwU(int i, int i2, long j) {
        int iM683getMinWidthimpl = Constraints.m683getMinWidthimpl(j) + i;
        if (iM683getMinWidthimpl < 0) {
            iM683getMinWidthimpl = 0;
        }
        int iM681getMaxWidthimpl = Constraints.m681getMaxWidthimpl(j);
        if (iM681getMaxWidthimpl != Integer.MAX_VALUE && (iM681getMaxWidthimpl = iM681getMaxWidthimpl + i) < 0) {
            iM681getMaxWidthimpl = 0;
        }
        int iM682getMinHeightimpl = Constraints.m682getMinHeightimpl(j) + i2;
        if (iM682getMinHeightimpl < 0) {
            iM682getMinHeightimpl = 0;
        }
        int iM680getMaxHeightimpl = Constraints.m680getMaxHeightimpl(j);
        return Constraints(iM683getMinWidthimpl, iM681getMaxWidthimpl, iM682getMinHeightimpl, (iM680getMaxHeightimpl == Integer.MAX_VALUE || (iM680getMaxHeightimpl = iM680getMaxHeightimpl + i2) >= 0) ? iM680getMaxHeightimpl : 0);
    }

    /* JADX INFO: renamed from: offset-NN6Ew-U$default, reason: not valid java name */
    public static /* synthetic */ long m692offsetNN6EwU$default(int i, int i2, int i3, long j) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return m691offsetNN6EwU(i, i2, j);
    }

    public static final void throwInvalidConstraintException(int i, int i2) {
        throw new IllegalArgumentException("Can't represent a width of " + i + " and height of " + i2 + " in Constraints");
    }

    public static final Void throwInvalidConstraintsSizeException(int i) {
        throw new IllegalArgumentException(CaptureSession$State$EnumUnboxingLocalUtility.m(i, "Can't represent a size of ", " in Constraints"));
    }
}
