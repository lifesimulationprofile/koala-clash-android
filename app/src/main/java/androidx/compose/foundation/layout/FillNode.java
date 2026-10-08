package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.DefaultIntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicsMeasureScope;
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
public final class FillNode extends Modifier.Node implements LayoutModifierNode {
    public int direction;
    public float fraction;

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final /* synthetic */ int maxIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return Modifier.CC.$default$maxIntrinsicHeight(this, lookaheadCapablePlaceable, measurable, i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final /* synthetic */ int maxIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return mo22measure3p2s80s(new IntrinsicsMeasureScope(lookaheadCapablePlaceable, lookaheadCapablePlaceable.getLayoutDirection()), new DefaultIntrinsicMeasurable(measurable, 2, 1, 2), ConstraintsKt.Constraints$default(0, 0, 0, i, 7)).getWidth();
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo22measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        int iM683getMinWidthimpl;
        int iM681getMaxWidthimpl;
        int iM680getMaxHeightimpl;
        int iM680getMaxHeightimpl2;
        if (!Constraints.m677getHasBoundedWidthimpl(j) || this.direction == 1) {
            iM683getMinWidthimpl = Constraints.m683getMinWidthimpl(j);
            iM681getMaxWidthimpl = Constraints.m681getMaxWidthimpl(j);
        } else {
            int iRound = Math.round(Constraints.m681getMaxWidthimpl(j) * this.fraction);
            int iM683getMinWidthimpl2 = Constraints.m683getMinWidthimpl(j);
            iM683getMinWidthimpl = Constraints.m681getMaxWidthimpl(j);
            if (iRound < iM683getMinWidthimpl2) {
                iRound = iM683getMinWidthimpl2;
            }
            if (iRound <= iM683getMinWidthimpl) {
                iM683getMinWidthimpl = iRound;
            }
            iM681getMaxWidthimpl = iM683getMinWidthimpl;
        }
        if (!Constraints.m676getHasBoundedHeightimpl(j) || this.direction == 2) {
            int iM682getMinHeightimpl = Constraints.m682getMinHeightimpl(j);
            iM680getMaxHeightimpl = Constraints.m680getMaxHeightimpl(j);
            iM680getMaxHeightimpl2 = iM682getMinHeightimpl;
        } else {
            int iRound2 = Math.round(Constraints.m680getMaxHeightimpl(j) * this.fraction);
            int iM682getMinHeightimpl2 = Constraints.m682getMinHeightimpl(j);
            iM680getMaxHeightimpl2 = Constraints.m680getMaxHeightimpl(j);
            if (iRound2 < iM682getMinHeightimpl2) {
                iRound2 = iM682getMinHeightimpl2;
            }
            if (iRound2 <= iM680getMaxHeightimpl2) {
                iM680getMaxHeightimpl2 = iRound2;
            }
            iM680getMaxHeightimpl = iM680getMaxHeightimpl2;
        }
        Placeable placeableMo515measureBRTryo0 = measurable.mo515measureBRTryo0(ConstraintsKt.Constraints(iM683getMinWidthimpl, iM681getMaxWidthimpl, iM680getMaxHeightimpl2, iM680getMaxHeightimpl));
        return measureScope.layout(placeableMo515measureBRTryo0.width, placeableMo515measureBRTryo0.height, EmptyMap.INSTANCE, new ContentPainterNode$$ExternalSyntheticLambda0(placeableMo515measureBRTryo0, 1));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final /* synthetic */ int minIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return mo22measure3p2s80s(new IntrinsicsMeasureScope(lookaheadCapablePlaceable, lookaheadCapablePlaceable.getLayoutDirection()), new DefaultIntrinsicMeasurable(measurable, 1, 2, 2), ConstraintsKt.Constraints$default(0, i, 0, 0, 13)).getHeight();
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final /* synthetic */ int minIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return Modifier.CC.$default$minIntrinsicWidth(this, lookaheadCapablePlaceable, measurable, i);
    }
}
