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
import androidx.compose.ui.unit.Density;
import coil.compose.ContentPainterNode$$ExternalSyntheticLambda0;
import kotlin.collections.EmptyMap;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class UnspecifiedConstraintsNode extends Modifier.Node implements LayoutModifierNode {
    public float minHeight;
    public float minWidth;

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        int iMaxIntrinsicHeight = measurable.maxIntrinsicHeight(i);
        int iM693$default$roundToPx0680j_4 = !Float.isNaN(this.minHeight) ? Density.CC.m693$default$roundToPx0680j_4(lookaheadCapablePlaceable, this.minHeight) : 0;
        return iMaxIntrinsicHeight < iM693$default$roundToPx0680j_4 ? iM693$default$roundToPx0680j_4 : iMaxIntrinsicHeight;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        int iMaxIntrinsicWidth = measurable.maxIntrinsicWidth(i);
        int iM693$default$roundToPx0680j_4 = !Float.isNaN(this.minWidth) ? Density.CC.m693$default$roundToPx0680j_4(lookaheadCapablePlaceable, this.minWidth) : 0;
        return iMaxIntrinsicWidth < iM693$default$roundToPx0680j_4 ? iM693$default$roundToPx0680j_4 : iMaxIntrinsicWidth;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo22measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        int iM683getMinWidthimpl;
        int iM682getMinHeightimpl;
        if (Float.isNaN(this.minWidth) || Constraints.m683getMinWidthimpl(j) != 0) {
            iM683getMinWidthimpl = Constraints.m683getMinWidthimpl(j);
        } else {
            int iMo83roundToPx0680j_4 = measureScope.mo83roundToPx0680j_4(this.minWidth);
            iM683getMinWidthimpl = Constraints.m681getMaxWidthimpl(j);
            if (iMo83roundToPx0680j_4 < 0) {
                iMo83roundToPx0680j_4 = 0;
            }
            if (iMo83roundToPx0680j_4 <= iM683getMinWidthimpl) {
                iM683getMinWidthimpl = iMo83roundToPx0680j_4;
            }
        }
        int iM681getMaxWidthimpl = Constraints.m681getMaxWidthimpl(j);
        if (Float.isNaN(this.minHeight) || Constraints.m682getMinHeightimpl(j) != 0) {
            iM682getMinHeightimpl = Constraints.m682getMinHeightimpl(j);
        } else {
            int iMo83roundToPx0680j_5 = measureScope.mo83roundToPx0680j_4(this.minHeight);
            iM682getMinHeightimpl = Constraints.m680getMaxHeightimpl(j);
            int i = iMo83roundToPx0680j_5 >= 0 ? iMo83roundToPx0680j_5 : 0;
            if (i <= iM682getMinHeightimpl) {
                iM682getMinHeightimpl = i;
            }
        }
        Placeable placeableMo515measureBRTryo0 = measurable.mo515measureBRTryo0(ConstraintsKt.Constraints(iM683getMinWidthimpl, iM681getMaxWidthimpl, iM682getMinHeightimpl, Constraints.m680getMaxHeightimpl(j)));
        return measureScope.layout(placeableMo515measureBRTryo0.width, placeableMo515measureBRTryo0.height, EmptyMap.INSTANCE, new ContentPainterNode$$ExternalSyntheticLambda0(placeableMo515measureBRTryo0, 4));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        int iMinIntrinsicHeight = measurable.minIntrinsicHeight(i);
        int iM693$default$roundToPx0680j_4 = !Float.isNaN(this.minHeight) ? Density.CC.m693$default$roundToPx0680j_4(lookaheadCapablePlaceable, this.minHeight) : 0;
        return iMinIntrinsicHeight < iM693$default$roundToPx0680j_4 ? iM693$default$roundToPx0680j_4 : iMinIntrinsicHeight;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        int iMinIntrinsicWidth = measurable.minIntrinsicWidth(i);
        int iM693$default$roundToPx0680j_4 = !Float.isNaN(this.minWidth) ? Density.CC.m693$default$roundToPx0680j_4(lookaheadCapablePlaceable, this.minWidth) : 0;
        return iMinIntrinsicWidth < iM693$default$roundToPx0680j_4 ? iM693$default$roundToPx0680j_4 : iMinIntrinsicWidth;
    }
}
