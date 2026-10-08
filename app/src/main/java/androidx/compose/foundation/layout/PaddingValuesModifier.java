package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.DefaultIntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicsMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.text.MultiParagraph$$ExternalSyntheticLambda1;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import kotlin.collections.EmptyMap;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class PaddingValuesModifier extends Modifier.Node implements LayoutModifierNode {
    public PaddingValues paddingValues;

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
        float fMo115calculateLeftPaddingu2uoSUM = this.paddingValues.mo115calculateLeftPaddingu2uoSUM(measureScope.getLayoutDirection());
        float fMo117calculateTopPaddingD9Ej5fM = this.paddingValues.mo117calculateTopPaddingD9Ej5fM();
        float fMo116calculateRightPaddingu2uoSUM = this.paddingValues.mo116calculateRightPaddingu2uoSUM(measureScope.getLayoutDirection());
        float fMo114calculateBottomPaddingD9Ej5fM = this.paddingValues.mo114calculateBottomPaddingD9Ej5fM();
        float f = 0;
        if (!((Dp.m700compareTo0680j_4(fMo114calculateBottomPaddingD9Ej5fM, f) >= 0) & (Dp.m700compareTo0680j_4(fMo115calculateLeftPaddingu2uoSUM, f) >= 0) & (Dp.m700compareTo0680j_4(fMo117calculateTopPaddingD9Ej5fM, f) >= 0) & (Dp.m700compareTo0680j_4(fMo116calculateRightPaddingu2uoSUM, f) >= 0))) {
            InlineClassHelperKt.throwIllegalArgumentException("Padding must be non-negative");
        }
        int iMo83roundToPx0680j_4 = measureScope.mo83roundToPx0680j_4(fMo115calculateLeftPaddingu2uoSUM);
        int iMo83roundToPx0680j_5 = measureScope.mo83roundToPx0680j_4(fMo116calculateRightPaddingu2uoSUM) + iMo83roundToPx0680j_4;
        int iMo83roundToPx0680j_6 = measureScope.mo83roundToPx0680j_4(fMo117calculateTopPaddingD9Ej5fM);
        int iMo83roundToPx0680j_7 = measureScope.mo83roundToPx0680j_4(fMo114calculateBottomPaddingD9Ej5fM) + iMo83roundToPx0680j_6;
        Placeable placeableMo515measureBRTryo0 = measurable.mo515measureBRTryo0(ConstraintsKt.m691offsetNN6EwU(-iMo83roundToPx0680j_5, -iMo83roundToPx0680j_7, j));
        return measureScope.layout(ConstraintsKt.m690constrainWidthK40F9xA(placeableMo515measureBRTryo0.width + iMo83roundToPx0680j_5, j), ConstraintsKt.m689constrainHeightK40F9xA(placeableMo515measureBRTryo0.height + iMo83roundToPx0680j_7, j), EmptyMap.INSTANCE, new MultiParagraph$$ExternalSyntheticLambda1(placeableMo515measureBRTryo0, iMo83roundToPx0680j_4, iMo83roundToPx0680j_6, 2));
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
