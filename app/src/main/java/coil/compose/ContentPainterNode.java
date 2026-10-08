package coil.compose;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.layout.ScaleFactor;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import coil.disk.RealDiskCache;
import coil.size.RealSizeResolver;
import kotlin.collections.EmptyMap;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ContentPainterNode extends Modifier.Node implements DrawModifierNode, LayoutModifierNode {
    public Alignment alignment;
    public float alpha;
    public ContentScale contentScale;
    public AsyncImagePainter painter;

    /* JADX INFO: renamed from: calculateScaledSize-E7KxVPU$1, reason: not valid java name */
    public final long m778calculateScaledSizeE7KxVPU$1(long j) {
        if (Size.m386isEmptyimpl(j)) {
            return 0L;
        }
        long jMo490getIntrinsicSizeNHjbRc = this.painter.mo490getIntrinsicSizeNHjbRc();
        if (jMo490getIntrinsicSizeNHjbRc == 9205357640488583168L) {
            return j;
        }
        float fM385getWidthimpl = Size.m385getWidthimpl(jMo490getIntrinsicSizeNHjbRc);
        if (Float.isInfinite(fM385getWidthimpl) || Float.isNaN(fM385getWidthimpl)) {
            fM385getWidthimpl = Size.m385getWidthimpl(j);
        }
        float fM383getHeightimpl = Size.m383getHeightimpl(jMo490getIntrinsicSizeNHjbRc);
        if (Float.isInfinite(fM383getHeightimpl) || Float.isNaN(fM383getHeightimpl)) {
            fM383getHeightimpl = Size.m383getHeightimpl(j);
        }
        long jSize = SizeKt.Size(fM385getWidthimpl, fM383getHeightimpl);
        long jMo514computeScaleFactorH7hwNQA = this.contentScale.mo514computeScaleFactorH7hwNQA(jSize, j);
        int i = ScaleFactor.$r8$clinit;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jMo514computeScaleFactorH7hwNQA >> 32));
        if (Float.isInfinite(fIntBitsToFloat) || Float.isNaN(fIntBitsToFloat)) {
            return j;
        }
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (4294967295L & jMo514computeScaleFactorH7hwNQA));
        return (Float.isInfinite(fIntBitsToFloat2) || Float.isNaN(fIntBitsToFloat2)) ? j : RulerKt.m537timesUQTWf7w(jSize, jMo514computeScaleFactorH7hwNQA);
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final void draw(LayoutNodeDrawScope layoutNodeDrawScope) {
        CanvasDrawScope canvasDrawScope = layoutNodeDrawScope.canvasDrawScope;
        long jM778calculateScaledSizeE7KxVPU$1 = m778calculateScaledSizeE7KxVPU$1(canvasDrawScope.drawContext.m795getSizeNHjbRc());
        Alignment alignment = this.alignment;
        RealSizeResolver realSizeResolver = UtilsKt.OriginalSizeResolver;
        long jRoundToInt = (((long) MathKt.roundToInt(Size.m385getWidthimpl(jM778calculateScaledSizeE7KxVPU$1))) << 32) | (((long) MathKt.roundToInt(Size.m383getHeightimpl(jM778calculateScaledSizeE7KxVPU$1))) & 4294967295L);
        long jM795getSizeNHjbRc = canvasDrawScope.drawContext.m795getSizeNHjbRc();
        long jMo304alignKFBX0sM = alignment.mo304alignKFBX0sM(jRoundToInt, (((long) MathKt.roundToInt(Size.m385getWidthimpl(jM795getSizeNHjbRc))) << 32) | (((long) MathKt.roundToInt(Size.m383getHeightimpl(jM795getSizeNHjbRc))) & 4294967295L), layoutNodeDrawScope.getLayoutDirection());
        float f = (int) (jMo304alignKFBX0sM >> 32);
        float f2 = (int) (jMo304alignKFBX0sM & 4294967295L);
        ((RealDiskCache.RealEditor) canvasDrawScope.drawContext.rootElement).translate(f, f2);
        this.painter.m493drawx_KDEd0(layoutNodeDrawScope, jM778calculateScaledSizeE7KxVPU$1, this.alpha, null);
        ((RealDiskCache.RealEditor) canvasDrawScope.drawContext.rootElement).translate(-f, -f2);
        layoutNodeDrawScope.drawContent();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        if (this.painter.mo490getIntrinsicSizeNHjbRc() == 9205357640488583168L) {
            return measurable.maxIntrinsicHeight(i);
        }
        int iMaxIntrinsicHeight = measurable.maxIntrinsicHeight(Constraints.m681getMaxWidthimpl(m779modifyConstraintsZezNO4M$1(ConstraintsKt.Constraints$default(0, i, 0, 0, 13))));
        return Math.max(MathKt.roundToInt(Size.m383getHeightimpl(m778calculateScaledSizeE7KxVPU$1(SizeKt.Size(i, iMaxIntrinsicHeight)))), iMaxIntrinsicHeight);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        if (this.painter.mo490getIntrinsicSizeNHjbRc() == 9205357640488583168L) {
            return measurable.maxIntrinsicWidth(i);
        }
        int iMaxIntrinsicWidth = measurable.maxIntrinsicWidth(Constraints.m680getMaxHeightimpl(m779modifyConstraintsZezNO4M$1(ConstraintsKt.Constraints$default(0, 0, 0, i, 7))));
        return Math.max(MathKt.roundToInt(Size.m385getWidthimpl(m778calculateScaledSizeE7KxVPU$1(SizeKt.Size(iMaxIntrinsicWidth, i)))), iMaxIntrinsicWidth);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo22measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        Placeable placeableMo515measureBRTryo0 = measurable.mo515measureBRTryo0(m779modifyConstraintsZezNO4M$1(j));
        return measureScope.layout(placeableMo515measureBRTryo0.width, placeableMo515measureBRTryo0.height, EmptyMap.INSTANCE, new ContentPainterNode$$ExternalSyntheticLambda0(placeableMo515measureBRTryo0, 0));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        if (this.painter.mo490getIntrinsicSizeNHjbRc() == 9205357640488583168L) {
            return measurable.minIntrinsicHeight(i);
        }
        int iMinIntrinsicHeight = measurable.minIntrinsicHeight(Constraints.m681getMaxWidthimpl(m779modifyConstraintsZezNO4M$1(ConstraintsKt.Constraints$default(0, i, 0, 0, 13))));
        return Math.max(MathKt.roundToInt(Size.m383getHeightimpl(m778calculateScaledSizeE7KxVPU$1(SizeKt.Size(i, iMinIntrinsicHeight)))), iMinIntrinsicHeight);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        if (this.painter.mo490getIntrinsicSizeNHjbRc() == 9205357640488583168L) {
            return measurable.minIntrinsicWidth(i);
        }
        int iMinIntrinsicWidth = measurable.minIntrinsicWidth(Constraints.m680getMaxHeightimpl(m779modifyConstraintsZezNO4M$1(ConstraintsKt.Constraints$default(0, 0, 0, i, 7))));
        return Math.max(MathKt.roundToInt(Size.m385getWidthimpl(m778calculateScaledSizeE7KxVPU$1(SizeKt.Size(iMinIntrinsicWidth, i)))), iMinIntrinsicWidth);
    }

    /* JADX INFO: renamed from: modifyConstraints-ZezNO4M$1, reason: not valid java name */
    public final long m779modifyConstraintsZezNO4M$1(long j) {
        float fM683getMinWidthimpl;
        int iM682getMinHeightimpl;
        float fCoerceIn;
        boolean zM679getHasFixedWidthimpl = Constraints.m679getHasFixedWidthimpl(j);
        boolean zM678getHasFixedHeightimpl = Constraints.m678getHasFixedHeightimpl(j);
        if (!zM679getHasFixedWidthimpl || !zM678getHasFixedHeightimpl) {
            boolean z = Constraints.m677getHasBoundedWidthimpl(j) && Constraints.m676getHasBoundedHeightimpl(j);
            long jMo490getIntrinsicSizeNHjbRc = this.painter.mo490getIntrinsicSizeNHjbRc();
            if (jMo490getIntrinsicSizeNHjbRc != 9205357640488583168L) {
                if (!z || (!zM679getHasFixedWidthimpl && !zM678getHasFixedHeightimpl)) {
                    float fM385getWidthimpl = Size.m385getWidthimpl(jMo490getIntrinsicSizeNHjbRc);
                    float fM383getHeightimpl = Size.m383getHeightimpl(jMo490getIntrinsicSizeNHjbRc);
                    if (Float.isInfinite(fM385getWidthimpl) || Float.isNaN(fM385getWidthimpl)) {
                        fM683getMinWidthimpl = Constraints.m683getMinWidthimpl(j);
                    } else {
                        RealSizeResolver realSizeResolver = UtilsKt.OriginalSizeResolver;
                        fM683getMinWidthimpl = RangesKt.coerceIn(fM385getWidthimpl, Constraints.m683getMinWidthimpl(j), Constraints.m681getMaxWidthimpl(j));
                    }
                    if (Float.isInfinite(fM383getHeightimpl) || Float.isNaN(fM383getHeightimpl)) {
                        iM682getMinHeightimpl = Constraints.m682getMinHeightimpl(j);
                    } else {
                        RealSizeResolver realSizeResolver2 = UtilsKt.OriginalSizeResolver;
                        fCoerceIn = RangesKt.coerceIn(fM383getHeightimpl, Constraints.m682getMinHeightimpl(j), Constraints.m680getMaxHeightimpl(j));
                    }
                    long jM778calculateScaledSizeE7KxVPU$1 = m778calculateScaledSizeE7KxVPU$1(SizeKt.Size(fM683getMinWidthimpl, fCoerceIn));
                    return Constraints.m674copyZbe2FdA$default(j, ConstraintsKt.m690constrainWidthK40F9xA(MathKt.roundToInt(Size.m385getWidthimpl(jM778calculateScaledSizeE7KxVPU$1)), j), 0, ConstraintsKt.m689constrainHeightK40F9xA(MathKt.roundToInt(Size.m383getHeightimpl(jM778calculateScaledSizeE7KxVPU$1)), j), 0, 10);
                }
                fM683getMinWidthimpl = Constraints.m681getMaxWidthimpl(j);
                iM682getMinHeightimpl = Constraints.m680getMaxHeightimpl(j);
                fCoerceIn = iM682getMinHeightimpl;
                long jM778calculateScaledSizeE7KxVPU$2 = m778calculateScaledSizeE7KxVPU$1(SizeKt.Size(fM683getMinWidthimpl, fCoerceIn));
                return Constraints.m674copyZbe2FdA$default(j, ConstraintsKt.m690constrainWidthK40F9xA(MathKt.roundToInt(Size.m385getWidthimpl(jM778calculateScaledSizeE7KxVPU$2)), j), 0, ConstraintsKt.m689constrainHeightK40F9xA(MathKt.roundToInt(Size.m383getHeightimpl(jM778calculateScaledSizeE7KxVPU$2)), j), 0, 10);
            }
            if (z) {
                return Constraints.m674copyZbe2FdA$default(j, Constraints.m681getMaxWidthimpl(j), 0, Constraints.m680getMaxHeightimpl(j), 0, 10);
            }
        }
        return j;
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final /* synthetic */ void onMeasureResultChanged() {
    }
}
