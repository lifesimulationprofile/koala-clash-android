package androidx.compose.foundation.layout;

import androidx.activity.compose.BackHandlerKt$$ExternalSyntheticLambda2;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.DefaultIntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicsMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.collections.EmptyMap;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class PaddingNode extends Modifier.Node implements LayoutModifierNode {
    public float bottom;
    public float end;
    public boolean rtlAware;
    public float start;
    public float top;

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
        int iMo83roundToPx0680j_4 = measureScope.mo83roundToPx0680j_4(this.end) + measureScope.mo83roundToPx0680j_4(this.start);
        int iMo83roundToPx0680j_5 = measureScope.mo83roundToPx0680j_4(this.bottom) + measureScope.mo83roundToPx0680j_4(this.top);
        Placeable placeableMo515measureBRTryo0 = measurable.mo515measureBRTryo0(ConstraintsKt.m691offsetNN6EwU(-iMo83roundToPx0680j_4, -iMo83roundToPx0680j_5, j));
        return measureScope.layout(ConstraintsKt.m690constrainWidthK40F9xA(placeableMo515measureBRTryo0.width + iMo83roundToPx0680j_4, j), ConstraintsKt.m689constrainHeightK40F9xA(placeableMo515measureBRTryo0.height + iMo83roundToPx0680j_5, j), EmptyMap.INSTANCE, new BackHandlerKt$$ExternalSyntheticLambda2(20, this, placeableMo515measureBRTryo0));
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
