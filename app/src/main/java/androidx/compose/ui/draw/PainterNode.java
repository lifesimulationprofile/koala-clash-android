package androidx.compose.ui.draw;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import coil.disk.RealDiskCache;
import kotlin.collections.EmptyMap;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class PainterNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode {
    public Alignment alignment;
    public float alpha;
    public BlendModeColorFilter colorFilter;
    public ContentScale contentScale;
    public Painter painter;
    public boolean sizeToIntrinsics;

    /* JADX INFO: renamed from: hasSpecifiedAndFiniteHeight-uvyYCjk, reason: not valid java name */
    public static boolean m338hasSpecifiedAndFiniteHeightuvyYCjk(long j) {
        return !Size.m382equalsimpl0(j, 9205357640488583168L) && (Float.floatToRawIntBits(Float.intBitsToFloat((int) (j & 4294967295L))) & Integer.MAX_VALUE) < 2139095040;
    }

    /* JADX INFO: renamed from: hasSpecifiedAndFiniteWidth-uvyYCjk, reason: not valid java name */
    public static boolean m339hasSpecifiedAndFiniteWidthuvyYCjk(long j) {
        return !Size.m382equalsimpl0(j, 9205357640488583168L) && (Float.floatToRawIntBits(Float.intBitsToFloat((int) (j >> 32))) & Integer.MAX_VALUE) < 2139095040;
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final void draw(LayoutNodeDrawScope layoutNodeDrawScope) {
        CanvasDrawScope canvasDrawScope = layoutNodeDrawScope.canvasDrawScope;
        long jMo490getIntrinsicSizeNHjbRc = this.painter.mo490getIntrinsicSizeNHjbRc();
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(m339hasSpecifiedAndFiniteWidthuvyYCjk(jMo490getIntrinsicSizeNHjbRc) ? Float.intBitsToFloat((int) (jMo490getIntrinsicSizeNHjbRc >> 32)) : Float.intBitsToFloat((int) (canvasDrawScope.drawContext.m795getSizeNHjbRc() >> 32)))) << 32) | (((long) Float.floatToRawIntBits(m338hasSpecifiedAndFiniteHeightuvyYCjk(jMo490getIntrinsicSizeNHjbRc) ? Float.intBitsToFloat((int) (jMo490getIntrinsicSizeNHjbRc & 4294967295L)) : Float.intBitsToFloat((int) (canvasDrawScope.drawContext.m795getSizeNHjbRc() & 4294967295L)))) & 4294967295L);
        long jM537timesUQTWf7w = (Float.intBitsToFloat((int) (canvasDrawScope.drawContext.m795getSizeNHjbRc() >> 32)) == 0.0f || Float.intBitsToFloat((int) (canvasDrawScope.drawContext.m795getSizeNHjbRc() & 4294967295L)) == 0.0f) ? 0L : RulerKt.m537timesUQTWf7w(jFloatToRawIntBits, this.contentScale.mo514computeScaleFactorH7hwNQA(jFloatToRawIntBits, canvasDrawScope.drawContext.m795getSizeNHjbRc()));
        long jMo304alignKFBX0sM = this.alignment.mo304alignKFBX0sM((((long) Math.round(Float.intBitsToFloat((int) (jM537timesUQTWf7w >> 32)))) << 32) | (((long) Math.round(Float.intBitsToFloat((int) (jM537timesUQTWf7w & 4294967295L)))) & 4294967295L), (((long) Math.round(Float.intBitsToFloat((int) (canvasDrawScope.drawContext.m795getSizeNHjbRc() >> 32)))) << 32) | (((long) Math.round(Float.intBitsToFloat((int) (canvasDrawScope.drawContext.m795getSizeNHjbRc() & 4294967295L)))) & 4294967295L), layoutNodeDrawScope.getLayoutDirection());
        float f = (int) (jMo304alignKFBX0sM >> 32);
        float f2 = (int) (jMo304alignKFBX0sM & 4294967295L);
        ((RealDiskCache.RealEditor) canvasDrawScope.drawContext.rootElement).translate(f, f2);
        try {
            this.painter.m493drawx_KDEd0(layoutNodeDrawScope, jM537timesUQTWf7w, this.alpha, this.colorFilter);
            ((RealDiskCache.RealEditor) canvasDrawScope.drawContext.rootElement).translate(-f, -f2);
            layoutNodeDrawScope.drawContent();
        } catch (Throwable th) {
            ((RealDiskCache.RealEditor) canvasDrawScope.drawContext.rootElement).translate(-f, -f2);
            throw th;
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    public final boolean getUseIntrinsicSize() {
        return this.sizeToIntrinsics && this.painter.mo490getIntrinsicSizeNHjbRc() != 9205357640488583168L;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        if (!getUseIntrinsicSize()) {
            return measurable.maxIntrinsicHeight(i);
        }
        long jM340modifyConstraintsZezNO4M = m340modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13));
        return Math.max(Constraints.m682getMinHeightimpl(jM340modifyConstraintsZezNO4M), measurable.maxIntrinsicHeight(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        if (!getUseIntrinsicSize()) {
            return measurable.maxIntrinsicWidth(i);
        }
        long jM340modifyConstraintsZezNO4M = m340modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7));
        return Math.max(Constraints.m683getMinWidthimpl(jM340modifyConstraintsZezNO4M), measurable.maxIntrinsicWidth(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo22measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        Placeable placeableMo515measureBRTryo0 = measurable.mo515measureBRTryo0(m340modifyConstraintsZezNO4M(j));
        return measureScope.layout(placeableMo515measureBRTryo0.width, placeableMo515measureBRTryo0.height, EmptyMap.INSTANCE, new PainterNode$measure$1(placeableMo515measureBRTryo0, 0));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        if (!getUseIntrinsicSize()) {
            return measurable.minIntrinsicHeight(i);
        }
        long jM340modifyConstraintsZezNO4M = m340modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13));
        return Math.max(Constraints.m682getMinHeightimpl(jM340modifyConstraintsZezNO4M), measurable.minIntrinsicHeight(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        if (!getUseIntrinsicSize()) {
            return measurable.minIntrinsicWidth(i);
        }
        long jM340modifyConstraintsZezNO4M = m340modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7));
        return Math.max(Constraints.m683getMinWidthimpl(jM340modifyConstraintsZezNO4M), measurable.minIntrinsicWidth(i));
    }

    /* JADX INFO: renamed from: modifyConstraints-ZezNO4M, reason: not valid java name */
    public final long m340modifyConstraintsZezNO4M(long j) {
        boolean z = false;
        boolean z2 = Constraints.m677getHasBoundedWidthimpl(j) && Constraints.m676getHasBoundedHeightimpl(j);
        if (Constraints.m679getHasFixedWidthimpl(j) && Constraints.m678getHasFixedHeightimpl(j)) {
            z = true;
        }
        if ((!getUseIntrinsicSize() && z2) || z) {
            return Constraints.m674copyZbe2FdA$default(j, Constraints.m681getMaxWidthimpl(j), 0, Constraints.m680getMaxHeightimpl(j), 0, 10);
        }
        long jMo490getIntrinsicSizeNHjbRc = this.painter.mo490getIntrinsicSizeNHjbRc();
        int iRound = m339hasSpecifiedAndFiniteWidthuvyYCjk(jMo490getIntrinsicSizeNHjbRc) ? Math.round(Float.intBitsToFloat((int) (jMo490getIntrinsicSizeNHjbRc >> 32))) : Constraints.m683getMinWidthimpl(j);
        int iRound2 = m338hasSpecifiedAndFiniteHeightuvyYCjk(jMo490getIntrinsicSizeNHjbRc) ? Math.round(Float.intBitsToFloat((int) (jMo490getIntrinsicSizeNHjbRc & 4294967295L))) : Constraints.m682getMinHeightimpl(j);
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(ConstraintsKt.m689constrainHeightK40F9xA(iRound2, j))) & 4294967295L) | (((long) Float.floatToRawIntBits(ConstraintsKt.m690constrainWidthK40F9xA(iRound, j))) << 32);
        if (getUseIntrinsicSize()) {
            long jFloatToRawIntBits2 = (((long) Float.floatToRawIntBits(!m339hasSpecifiedAndFiniteWidthuvyYCjk(this.painter.mo490getIntrinsicSizeNHjbRc()) ? Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32)) : Float.intBitsToFloat((int) (this.painter.mo490getIntrinsicSizeNHjbRc() >> 32)))) << 32) | (((long) Float.floatToRawIntBits(!m338hasSpecifiedAndFiniteHeightuvyYCjk(this.painter.mo490getIntrinsicSizeNHjbRc()) ? Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L)) : Float.intBitsToFloat((int) (this.painter.mo490getIntrinsicSizeNHjbRc() & 4294967295L)))) & 4294967295L);
            jFloatToRawIntBits = (Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32)) == 0.0f || Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L)) == 0.0f) ? 0L : RulerKt.m537timesUQTWf7w(jFloatToRawIntBits2, this.contentScale.mo514computeScaleFactorH7hwNQA(jFloatToRawIntBits2, jFloatToRawIntBits));
        }
        return Constraints.m674copyZbe2FdA$default(j, ConstraintsKt.m690constrainWidthK40F9xA(Math.round(Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32))), j), 0, ConstraintsKt.m689constrainHeightK40F9xA(Math.round(Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L))), j), 0, 10);
    }

    public final String toString() {
        return "PainterModifier(painter=" + this.painter + ", sizeToIntrinsics=" + this.sizeToIntrinsics + ", alignment=" + this.alignment + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + ')';
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final /* synthetic */ void onMeasureResultChanged() {
    }
}
