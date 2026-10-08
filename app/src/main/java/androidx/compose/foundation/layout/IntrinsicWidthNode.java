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
import androidx.compose.ui.unit.InlineClassHelperKt;
import coil.compose.ContentPainterNode$$ExternalSyntheticLambda0;
import kotlin.collections.EmptyMap;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class IntrinsicWidthNode extends Modifier.Node implements LayoutModifierNode {
    public boolean enforceIncoming;
    public int width;

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return measurable.maxIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return this.width == 1 ? measurable.minIntrinsicWidth(i) : measurable.maxIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo22measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        int iMinIntrinsicWidth = this.width == 1 ? measurable.minIntrinsicWidth(Constraints.m680getMaxHeightimpl(j)) : measurable.maxIntrinsicWidth(Constraints.m680getMaxHeightimpl(j));
        if (iMinIntrinsicWidth < 0) {
            iMinIntrinsicWidth = 0;
        }
        if (iMinIntrinsicWidth < 0) {
            InlineClassHelperKt.throwIllegalArgumentException("width must be >= 0");
        }
        long jCreateConstraints = ConstraintsKt.createConstraints(iMinIntrinsicWidth, iMinIntrinsicWidth, 0, Integer.MAX_VALUE);
        if (this.enforceIncoming) {
            jCreateConstraints = ConstraintsKt.m688constrainN9IONVI(j, jCreateConstraints);
        }
        Placeable placeableMo515measureBRTryo0 = measurable.mo515measureBRTryo0(jCreateConstraints);
        return measureScope.layout(placeableMo515measureBRTryo0.width, placeableMo515measureBRTryo0.height, EmptyMap.INSTANCE, new ContentPainterNode$$ExternalSyntheticLambda0(placeableMo515measureBRTryo0, 2));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return measurable.minIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return this.width == 1 ? measurable.minIntrinsicWidth(i) : measurable.maxIntrinsicWidth(i);
    }
}
