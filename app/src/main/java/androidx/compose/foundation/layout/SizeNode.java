package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import coil.compose.ContentPainterNode$$ExternalSyntheticLambda0;
import kotlin.collections.EmptyMap;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class SizeNode extends Modifier.Node implements LayoutModifierNode {
    public boolean enforceIncoming;
    public float maxHeight;
    public float maxWidth;
    public float minHeight;
    public float minWidth;

    /* JADX WARN: Code duplicated, block: B:23:0x0041  */
    /* JADX INFO: renamed from: getTargetConstraints-OenEA2s, reason: not valid java name */
    public final long m143getTargetConstraintsOenEA2s(MeasureScope measureScope) {
        int iMo83roundToPx0680j_4;
        int iMo83roundToPx0680j_5;
        int iMo83roundToPx0680j_6;
        int i = 0;
        if (Float.isNaN(this.maxWidth)) {
            iMo83roundToPx0680j_4 = Integer.MAX_VALUE;
        } else {
            iMo83roundToPx0680j_4 = measureScope.mo83roundToPx0680j_4(this.maxWidth);
            if (iMo83roundToPx0680j_4 < 0) {
                iMo83roundToPx0680j_4 = 0;
            }
        }
        if (Float.isNaN(this.maxHeight)) {
            iMo83roundToPx0680j_5 = Integer.MAX_VALUE;
        } else {
            iMo83roundToPx0680j_5 = measureScope.mo83roundToPx0680j_4(this.maxHeight);
            if (iMo83roundToPx0680j_5 < 0) {
                iMo83roundToPx0680j_5 = 0;
            }
        }
        if (Float.isNaN(this.minWidth)) {
            iMo83roundToPx0680j_6 = 0;
        } else {
            iMo83roundToPx0680j_6 = measureScope.mo83roundToPx0680j_4(this.minWidth);
            if (iMo83roundToPx0680j_6 < 0) {
                iMo83roundToPx0680j_6 = 0;
            }
            if (iMo83roundToPx0680j_6 > iMo83roundToPx0680j_4) {
                iMo83roundToPx0680j_6 = iMo83roundToPx0680j_4;
            }
            if (iMo83roundToPx0680j_6 == Integer.MAX_VALUE) {
                iMo83roundToPx0680j_6 = 0;
            }
        }
        if (!Float.isNaN(this.minHeight)) {
            int iMo83roundToPx0680j_7 = measureScope.mo83roundToPx0680j_4(this.minHeight);
            if (iMo83roundToPx0680j_7 < 0) {
                iMo83roundToPx0680j_7 = 0;
            }
            if (iMo83roundToPx0680j_7 > iMo83roundToPx0680j_5) {
                iMo83roundToPx0680j_7 = iMo83roundToPx0680j_5;
            }
            if (iMo83roundToPx0680j_7 != Integer.MAX_VALUE) {
                i = iMo83roundToPx0680j_7;
            }
        }
        return ConstraintsKt.Constraints(iMo83roundToPx0680j_6, iMo83roundToPx0680j_4, i, iMo83roundToPx0680j_5);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        long jM143getTargetConstraintsOenEA2s = m143getTargetConstraintsOenEA2s(lookaheadCapablePlaceable);
        if (Constraints.m678getHasFixedHeightimpl(jM143getTargetConstraintsOenEA2s)) {
            return Constraints.m680getMaxHeightimpl(jM143getTargetConstraintsOenEA2s);
        }
        if (!this.enforceIncoming) {
            i = ConstraintsKt.m690constrainWidthK40F9xA(i, jM143getTargetConstraintsOenEA2s);
        }
        return ConstraintsKt.m689constrainHeightK40F9xA(measurable.maxIntrinsicHeight(i), jM143getTargetConstraintsOenEA2s);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        long jM143getTargetConstraintsOenEA2s = m143getTargetConstraintsOenEA2s(lookaheadCapablePlaceable);
        if (Constraints.m679getHasFixedWidthimpl(jM143getTargetConstraintsOenEA2s)) {
            return Constraints.m681getMaxWidthimpl(jM143getTargetConstraintsOenEA2s);
        }
        if (!this.enforceIncoming) {
            i = ConstraintsKt.m689constrainHeightK40F9xA(i, jM143getTargetConstraintsOenEA2s);
        }
        return ConstraintsKt.m690constrainWidthK40F9xA(measurable.maxIntrinsicWidth(i), jM143getTargetConstraintsOenEA2s);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo22measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        int iM683getMinWidthimpl;
        int iM681getMaxWidthimpl;
        int iM682getMinHeightimpl;
        int iM680getMaxHeightimpl;
        long jConstraints;
        long jM143getTargetConstraintsOenEA2s = m143getTargetConstraintsOenEA2s(measureScope);
        if (this.enforceIncoming) {
            jConstraints = ConstraintsKt.m688constrainN9IONVI(j, jM143getTargetConstraintsOenEA2s);
        } else {
            if (Float.isNaN(this.minWidth)) {
                iM683getMinWidthimpl = Constraints.m683getMinWidthimpl(j);
                int iM681getMaxWidthimpl2 = Constraints.m681getMaxWidthimpl(jM143getTargetConstraintsOenEA2s);
                if (iM683getMinWidthimpl > iM681getMaxWidthimpl2) {
                    iM683getMinWidthimpl = iM681getMaxWidthimpl2;
                }
            } else {
                iM683getMinWidthimpl = Constraints.m683getMinWidthimpl(jM143getTargetConstraintsOenEA2s);
            }
            if (Float.isNaN(this.maxWidth)) {
                iM681getMaxWidthimpl = Constraints.m681getMaxWidthimpl(j);
                int iM683getMinWidthimpl2 = Constraints.m683getMinWidthimpl(jM143getTargetConstraintsOenEA2s);
                if (iM681getMaxWidthimpl < iM683getMinWidthimpl2) {
                    iM681getMaxWidthimpl = iM683getMinWidthimpl2;
                }
            } else {
                iM681getMaxWidthimpl = Constraints.m681getMaxWidthimpl(jM143getTargetConstraintsOenEA2s);
            }
            if (Float.isNaN(this.minHeight)) {
                iM682getMinHeightimpl = Constraints.m682getMinHeightimpl(j);
                int iM680getMaxHeightimpl2 = Constraints.m680getMaxHeightimpl(jM143getTargetConstraintsOenEA2s);
                if (iM682getMinHeightimpl > iM680getMaxHeightimpl2) {
                    iM682getMinHeightimpl = iM680getMaxHeightimpl2;
                }
            } else {
                iM682getMinHeightimpl = Constraints.m682getMinHeightimpl(jM143getTargetConstraintsOenEA2s);
            }
            if (Float.isNaN(this.maxHeight)) {
                iM680getMaxHeightimpl = Constraints.m680getMaxHeightimpl(j);
                int iM682getMinHeightimpl2 = Constraints.m682getMinHeightimpl(jM143getTargetConstraintsOenEA2s);
                if (iM680getMaxHeightimpl < iM682getMinHeightimpl2) {
                    iM680getMaxHeightimpl = iM682getMinHeightimpl2;
                }
            } else {
                iM680getMaxHeightimpl = Constraints.m680getMaxHeightimpl(jM143getTargetConstraintsOenEA2s);
            }
            jConstraints = ConstraintsKt.Constraints(iM683getMinWidthimpl, iM681getMaxWidthimpl, iM682getMinHeightimpl, iM680getMaxHeightimpl);
        }
        Placeable placeableMo515measureBRTryo0 = measurable.mo515measureBRTryo0(jConstraints);
        return measureScope.layout(placeableMo515measureBRTryo0.width, placeableMo515measureBRTryo0.height, EmptyMap.INSTANCE, new ContentPainterNode$$ExternalSyntheticLambda0(placeableMo515measureBRTryo0, 3));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        long jM143getTargetConstraintsOenEA2s = m143getTargetConstraintsOenEA2s(lookaheadCapablePlaceable);
        if (Constraints.m678getHasFixedHeightimpl(jM143getTargetConstraintsOenEA2s)) {
            return Constraints.m680getMaxHeightimpl(jM143getTargetConstraintsOenEA2s);
        }
        if (!this.enforceIncoming) {
            i = ConstraintsKt.m690constrainWidthK40F9xA(i, jM143getTargetConstraintsOenEA2s);
        }
        return ConstraintsKt.m689constrainHeightK40F9xA(measurable.minIntrinsicHeight(i), jM143getTargetConstraintsOenEA2s);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        long jM143getTargetConstraintsOenEA2s = m143getTargetConstraintsOenEA2s(lookaheadCapablePlaceable);
        if (Constraints.m679getHasFixedWidthimpl(jM143getTargetConstraintsOenEA2s)) {
            return Constraints.m681getMaxWidthimpl(jM143getTargetConstraintsOenEA2s);
        }
        if (!this.enforceIncoming) {
            i = ConstraintsKt.m689constrainHeightK40F9xA(i, jM143getTargetConstraintsOenEA2s);
        }
        return ConstraintsKt.m690constrainWidthK40F9xA(measurable.minIntrinsicWidth(i), jM143getTargetConstraintsOenEA2s);
    }
}
