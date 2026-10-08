package androidx.compose.foundation.layout;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.collection.IntIntPair;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import coil.network.HttpException;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class FlowLayoutOverflowState {
    public Measurable collapseMeasurable;
    public Placeable collapsePlaceable;
    public IntIntPair collapseSize;
    public Measurable seeMoreMeasurable;
    public Placeable seeMorePlaceable;
    public IntIntPair seeMoreSize;

    /* JADX INFO: renamed from: ellipsisSize-F35zm-w$foundation_layout, reason: not valid java name */
    public final IntIntPair m112ellipsisSizeF35zmw$foundation_layout(int i, int i2, boolean z) {
        int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(2);
        if (iOrdinal == 0 || iOrdinal == 1) {
            return null;
        }
        if (iOrdinal == 2) {
            if (z) {
                return this.seeMoreSize;
            }
            return null;
        }
        if (iOrdinal != 3) {
            throw new HttpException();
        }
        if (z) {
            return this.seeMoreSize;
        }
        if (i + 1 < 0 || i2 < 0) {
            return null;
        }
        return this.collapseSize;
    }

    public final boolean equals(Object obj) {
        return this == obj || (obj instanceof FlowLayoutOverflowState);
    }

    public final int hashCode() {
        return CaptureSession$State$EnumUnboxingLocalUtility.ordinal(2) * 961;
    }

    /* JADX INFO: renamed from: setOverflowMeasurables--hBUhpc$foundation_layout, reason: not valid java name */
    public final void m113setOverflowMeasurableshBUhpc$foundation_layout(Measurable measurable, Measurable measurable2, long j) {
        long jM122constructorimpl = OffsetKt.m122constructorimpl(1, j);
        if (measurable != null) {
            int iMinIntrinsicWidth = measurable.minIntrinsicWidth(Constraints.m680getMaxHeightimpl(jM122constructorimpl));
            this.seeMoreSize = new IntIntPair(IntIntPair.m18constructorimpl(iMinIntrinsicWidth, measurable.minIntrinsicHeight(iMinIntrinsicWidth)));
            this.seeMoreMeasurable = measurable instanceof Measurable ? measurable : null;
            this.seeMorePlaceable = null;
        }
        if (measurable2 != null) {
            int iMinIntrinsicWidth2 = measurable2.minIntrinsicWidth(Constraints.m680getMaxHeightimpl(jM122constructorimpl));
            this.collapseSize = new IntIntPair(IntIntPair.m18constructorimpl(iMinIntrinsicWidth2, measurable2.minIntrinsicHeight(iMinIntrinsicWidth2)));
            this.collapseMeasurable = measurable2 instanceof Measurable ? measurable2 : null;
            this.collapsePlaceable = null;
        }
    }

    public final String toString() {
        return ImageAnalysis$$ExternalSyntheticLambda1.m$1("FlowLayoutOverflowState(type=", "Clip", ", minLinesToShowCollapse=0, minCrossAxisSizeToShowCollapse=0)");
    }
}
