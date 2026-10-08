package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.material3.tokens.SwitchTokens;
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
import androidx.compose.ui.unit.InlineClassHelperKt;
import androidx.work.CoroutineWorker;
import kotlin.collections.EmptyMap;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ThumbNode extends Modifier.Node implements LayoutModifierNode {
    public FiniteAnimationSpec animationSpec;
    public boolean checked;
    public float initialOffset;
    public float initialSize;
    public MutableInteractionSourceImpl interactionSource;
    public boolean isPressed;
    public Animatable offsetAnim;
    public Animatable sizeAnim;

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

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
        float f;
        boolean z = (measurable.maxIntrinsicHeight(Constraints.m681getMaxWidthimpl(j)) == 0 || measurable.maxIntrinsicWidth(Constraints.m680getMaxHeightimpl(j)) == 0) ? false : true;
        if (this.isPressed) {
            f = SwitchTokens.PressedHandleWidth;
        } else {
            f = (z || this.checked) ? SwitchKt.ThumbDiameter : SwitchKt.UncheckedThumbDiameter;
        }
        float fMo89toPx0680j_4 = measureScope.mo89toPx0680j_4(f);
        Animatable animatable = this.sizeAnim;
        int iFloatValue = (int) (animatable != null ? ((Number) animatable.getValue()).floatValue() : fMo89toPx0680j_4);
        if (!((iFloatValue >= 0) & (iFloatValue >= 0))) {
            InlineClassHelperKt.throwIllegalArgumentException("width and height must be >= 0");
        }
        Placeable placeableMo515measureBRTryo0 = measurable.mo515measureBRTryo0(ConstraintsKt.createConstraints(iFloatValue, iFloatValue, iFloatValue, iFloatValue));
        float fMo89toPx0680j_5 = measureScope.mo89toPx0680j_4((SwitchKt.SwitchHeight - measureScope.mo85toDpu2uoSUM(fMo89toPx0680j_4)) / 2.0f);
        float fMo89toPx0680j_6 = measureScope.mo89toPx0680j_4((SwitchKt.SwitchWidth - SwitchKt.ThumbDiameter) - SwitchKt.ThumbPadding);
        boolean z2 = this.isPressed;
        if (z2 && this.checked) {
            fMo89toPx0680j_5 = fMo89toPx0680j_6 - measureScope.mo89toPx0680j_4(SwitchTokens.TrackOutlineWidth);
        } else if (z2 && !this.checked) {
            fMo89toPx0680j_5 = measureScope.mo89toPx0680j_4(SwitchTokens.TrackOutlineWidth);
        } else if (this.checked) {
            fMo89toPx0680j_5 = fMo89toPx0680j_6;
        }
        Animatable animatable2 = this.sizeAnim;
        Continuation continuation = null;
        Float f2 = animatable2 != null ? (Float) animatable2.targetValue$delegate.getValue() : null;
        if (f2 == null || f2.floatValue() != fMo89toPx0680j_4) {
            JobKt.launch$default(getCoroutineScope(), null, new ThumbNode$measure$1(this, fMo89toPx0680j_4, continuation, 0), 3);
        }
        Animatable animatable3 = this.offsetAnim;
        Float f3 = animatable3 != null ? (Float) animatable3.targetValue$delegate.getValue() : null;
        if (f3 == null || f3.floatValue() != fMo89toPx0680j_5) {
            JobKt.launch$default(getCoroutineScope(), null, new ThumbNode$measure$1(this, fMo89toPx0680j_5, continuation, 1), 3);
        }
        if (Float.isNaN(this.initialSize) && Float.isNaN(this.initialOffset)) {
            this.initialSize = fMo89toPx0680j_4;
            this.initialOffset = fMo89toPx0680j_5;
        }
        return measureScope.layout(iFloatValue, iFloatValue, EmptyMap.INSTANCE, new ThumbNode$$ExternalSyntheticLambda0(placeableMo515measureBRTryo0, this, fMo89toPx0680j_5));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final /* synthetic */ int minIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return mo22measure3p2s80s(new IntrinsicsMeasureScope(lookaheadCapablePlaceable, lookaheadCapablePlaceable.getLayoutDirection()), new DefaultIntrinsicMeasurable(measurable, 1, 2, 2), ConstraintsKt.Constraints$default(0, i, 0, 0, 13)).getHeight();
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final /* synthetic */ int minIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return Modifier.CC.$default$minIntrinsicWidth(this, lookaheadCapablePlaceable, measurable, i);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        JobKt.launch$default(getCoroutineScope(), null, new CoroutineWorker.AnonymousClass1(this, (Continuation) null, 11), 3);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onReset() {
        this.offsetAnim = null;
        this.sizeAnim = null;
        this.initialSize = Float.NaN;
        this.initialOffset = Float.NaN;
    }
}
