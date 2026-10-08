package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidImageBitmap;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.caverock.androidsvg.SVG;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class LayoutNodeDrawScope implements DrawScope {
    public final CanvasDrawScope canvasDrawScope = new CanvasDrawScope();
    public DrawModifierNode drawNode;

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawArc-yD3GUKo */
    public final void mo460drawArcyD3GUKo(long j, float f, float f2, long j2, long j3, DrawStyle drawStyle) {
        this.canvasDrawScope.mo460drawArcyD3GUKo(j, f, f2, j2, j3, drawStyle);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawCircle-VaOC9Bg */
    public final void mo461drawCircleVaOC9Bg(long j, float f, long j2, DrawStyle drawStyle) {
        this.canvasDrawScope.mo461drawCircleVaOC9Bg(j, f, j2, drawStyle);
    }

    public final void drawContent() {
        CanvasDrawScope canvasDrawScope = this.canvasDrawScope;
        Canvas canvas = canvasDrawScope.drawContext.getCanvas();
        DelegatableNode delegatableNode = this.drawNode;
        if (delegatableNode == null) {
            throw Modifier.CC.m("Attempting to drawContent for a `null` node. This usually means that a call to ContentDrawScope#drawContent() has been captured inside a lambda, and is being invoked outside of the draw pass. Capturing the scope this way is unsupported - if you are trying to record drawContent with graphicsLayer.record(), make sure you are using the GraphicsLayer#record function within DrawScope, instead of the member function on GraphicsLayer.");
        }
        Modifier.Node node = (Modifier.Node) delegatableNode;
        Modifier.Node nodeAccess$pop = node.node.child;
        if (nodeAccess$pop != null && (nodeAccess$pop.aggregateChildKindSet & 4) != 0) {
            while (true) {
                if (nodeAccess$pop != null) {
                    int i = nodeAccess$pop.kindSet;
                    if ((i & 2) == 0) {
                        if ((i & 4) != 0) {
                            break;
                        } else {
                            nodeAccess$pop = nodeAccess$pop.child;
                        }
                    }
                }
                nodeAccess$pop = null;
                break;
            }
        } else {
            nodeAccess$pop = null;
            break;
        }
        if (nodeAccess$pop == null) {
            NodeCoordinator nodeCoordinatorM545requireCoordinator64DMado = HitTestResultKt.m545requireCoordinator64DMado(delegatableNode, 4);
            if (nodeCoordinatorM545requireCoordinator64DMado.getTail() == node.node) {
                nodeCoordinatorM545requireCoordinator64DMado = nodeCoordinatorM545requireCoordinator64DMado.wrapped;
            }
            nodeCoordinatorM545requireCoordinator64DMado.performDraw(canvas, (GraphicsLayer) canvasDrawScope.drawContext.cssRules);
            return;
        }
        MutableVector mutableVector = null;
        while (nodeAccess$pop != null) {
            if (nodeAccess$pop instanceof DrawModifierNode) {
                DrawModifierNode drawModifierNode = (DrawModifierNode) nodeAccess$pop;
                GraphicsLayer graphicsLayer = (GraphicsLayer) canvasDrawScope.drawContext.cssRules;
                NodeCoordinator nodeCoordinatorM545requireCoordinator64DMado2 = HitTestResultKt.m545requireCoordinator64DMado(drawModifierNode, 4);
                long jM721toSizeozmzZPI = IntSizeKt.m721toSizeozmzZPI(nodeCoordinatorM545requireCoordinator64DMado2.measuredSize);
                LayoutNode layoutNode = nodeCoordinatorM545requireCoordinator64DMado2.layoutNode;
                layoutNode.getClass();
                ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNode)).getSharedDrawScope().m549drawDirecteZhPAX0$ui(canvas, jM721toSizeozmzZPI, nodeCoordinatorM545requireCoordinator64DMado2, drawModifierNode, graphicsLayer);
            } else if ((nodeAccess$pop.kindSet & 4) != 0 && (nodeAccess$pop instanceof DelegatingNode)) {
                int i2 = 0;
                for (Modifier.Node node2 = ((DelegatingNode) nodeAccess$pop).delegate; node2 != null; node2 = node2.child) {
                    if ((node2.kindSet & 4) != 0) {
                        i2++;
                        if (i2 == 1) {
                            nodeAccess$pop = node2;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16]);
                            }
                            if (nodeAccess$pop != null) {
                                mutableVector.add(nodeAccess$pop);
                                nodeAccess$pop = null;
                            }
                            mutableVector.add(node2);
                        }
                    }
                }
                if (i2 == 1) {
                }
            }
            nodeAccess$pop = HitTestResultKt.access$pop(mutableVector);
        }
    }

    /* JADX INFO: renamed from: drawDirect-eZhPAX0$ui, reason: not valid java name */
    public final void m549drawDirecteZhPAX0$ui(Canvas canvas, long j, NodeCoordinator nodeCoordinator, DrawModifierNode drawModifierNode, GraphicsLayer graphicsLayer) {
        DrawModifierNode drawModifierNode2 = this.drawNode;
        this.drawNode = drawModifierNode;
        LayoutDirection layoutDirection = nodeCoordinator.layoutNode.layoutDirection;
        CanvasDrawScope canvasDrawScope = this.canvasDrawScope;
        Density density = canvasDrawScope.drawContext.getDensity();
        SVG svg = canvasDrawScope.drawContext;
        LayoutDirection layoutDirection2 = svg.getLayoutDirection();
        Canvas canvas2 = svg.getCanvas();
        long jM795getSizeNHjbRc = svg.m795getSizeNHjbRc();
        GraphicsLayer graphicsLayer2 = (GraphicsLayer) svg.cssRules;
        svg.setDensity(nodeCoordinator);
        svg.setLayoutDirection(layoutDirection);
        svg.setCanvas(canvas);
        svg.m797setSizeuvyYCjk(j);
        svg.cssRules = graphicsLayer;
        canvas.save();
        try {
            drawModifierNode.draw(this);
            canvas.restore();
            svg.setDensity(density);
            svg.setLayoutDirection(layoutDirection2);
            svg.setCanvas(canvas2);
            svg.m797setSizeuvyYCjk(jM795getSizeNHjbRc);
            svg.cssRules = graphicsLayer2;
            this.drawNode = drawModifierNode2;
        } catch (Throwable th) {
            canvas.restore();
            svg.setDensity(density);
            svg.setLayoutDirection(layoutDirection2);
            svg.setCanvas(canvas2);
            svg.m797setSizeuvyYCjk(jM795getSizeNHjbRc);
            svg.cssRules = graphicsLayer2;
            throw th;
        }
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawImage-AZ2fEMs */
    public final void mo462drawImageAZ2fEMs(AndroidImageBitmap androidImageBitmap, long j, long j2, long j3, float f, BlendModeColorFilter blendModeColorFilter, int i) {
        this.canvasDrawScope.mo462drawImageAZ2fEMs(androidImageBitmap, j, j2, j3, f, blendModeColorFilter, i);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawImage-gbVJVH8 */
    public final void mo463drawImagegbVJVH8(AndroidImageBitmap androidImageBitmap, long j, float f, BlendModeColorFilter blendModeColorFilter, int i) {
        this.canvasDrawScope.mo463drawImagegbVJVH8(androidImageBitmap, j, f, blendModeColorFilter, i);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawLine-NGM6Ib0 */
    public final void mo464drawLineNGM6Ib0(long j, long j2, long j3, float f, int i) {
        this.canvasDrawScope.mo464drawLineNGM6Ib0(j, j2, j3, f, i);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawPath-GBMwjPU */
    public final void mo465drawPathGBMwjPU(AndroidPath androidPath, Brush brush, float f, DrawStyle drawStyle, BlendModeColorFilter blendModeColorFilter, int i) {
        this.canvasDrawScope.mo465drawPathGBMwjPU(androidPath, brush, f, drawStyle, blendModeColorFilter, i);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawPath-LG529CI */
    public final void mo466drawPathLG529CI(AndroidPath androidPath, long j, DrawStyle drawStyle) {
        this.canvasDrawScope.mo466drawPathLG529CI(androidPath, j, drawStyle);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRect-AsUm42w */
    public final void mo467drawRectAsUm42w(Brush brush, long j, long j2, float f, DrawStyle drawStyle, BlendModeColorFilter blendModeColorFilter, int i) {
        this.canvasDrawScope.mo467drawRectAsUm42w(brush, j, j2, f, drawStyle, blendModeColorFilter, i);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRect-n-J9OG0 */
    public final void mo468drawRectnJ9OG0(long j, long j2, long j3, float f, int i) {
        this.canvasDrawScope.mo468drawRectnJ9OG0(j, j2, j3, f, i);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRoundRect-ZuiqVtQ */
    public final void mo469drawRoundRectZuiqVtQ(Brush brush, long j, long j2, long j3, float f, DrawStyle drawStyle, BlendModeColorFilter blendModeColorFilter, int i) {
        this.canvasDrawScope.mo469drawRoundRectZuiqVtQ(brush, j, j2, j3, f, drawStyle, blendModeColorFilter, i);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRoundRect-u-Aw5IA */
    public final void mo470drawRoundRectuAw5IA(long j, long j2, long j3, long j4, DrawStyle drawStyle) {
        this.canvasDrawScope.mo470drawRoundRectuAw5IA(j, j2, j3, j4, drawStyle);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: getCenter-F1C5BW0 */
    public final long mo471getCenterF1C5BW0() {
        return this.canvasDrawScope.mo471getCenterF1C5BW0();
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getDensity() {
        return this.canvasDrawScope.getDensity();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public final SVG getDrawContext() {
        return this.canvasDrawScope.drawContext;
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getFontScale() {
        return this.canvasDrawScope.getFontScale();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public final LayoutDirection getLayoutDirection() {
        return this.canvasDrawScope.drawParams.layoutDirection;
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: getSize-NH-jbRc */
    public final long mo472getSizeNHjbRc() {
        return this.canvasDrawScope.drawContext.m795getSizeNHjbRc();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: record-JVtK1S4 */
    public final void mo473recordJVtK1S4(GraphicsLayer graphicsLayer, long j, Function1 function1) {
        graphicsLayer.m474recordmLhObY(this, getLayoutDirection(), j, new LayoutNodeDrawScope$record$1(this, this.drawNode, function1, 0));
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    public final int mo83roundToPx0680j_4(float f) {
        CanvasDrawScope canvasDrawScope = this.canvasDrawScope;
        canvasDrawScope.getClass();
        return Density.CC.m693$default$roundToPx0680j_4(canvasDrawScope, f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-GaN1DYA */
    public final float mo84toDpGaN1DYA(long j) {
        CanvasDrawScope canvasDrawScope = this.canvasDrawScope;
        canvasDrawScope.getClass();
        return Density.CC.m694$default$toDpGaN1DYA(j, canvasDrawScope);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public final float mo86toDpu2uoSUM(int i) {
        return this.canvasDrawScope.mo86toDpu2uoSUM(i);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    public final long mo87toDpSizekrfVVM(long j) {
        CanvasDrawScope canvasDrawScope = this.canvasDrawScope;
        canvasDrawScope.getClass();
        return Density.CC.m695$default$toDpSizekrfVVM(j, canvasDrawScope);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx--R2X_6o */
    public final float mo88toPxR2X_6o(long j) {
        CanvasDrawScope canvasDrawScope = this.canvasDrawScope;
        canvasDrawScope.getClass();
        return Density.CC.m696$default$toPxR2X_6o(j, canvasDrawScope);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx-0680j_4 */
    public final float mo89toPx0680j_4(float f) {
        return this.canvasDrawScope.getDensity() * f;
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    public final long mo90toSizeXkaWNTQ(long j) {
        CanvasDrawScope canvasDrawScope = this.canvasDrawScope;
        canvasDrawScope.getClass();
        return Density.CC.m697$default$toSizeXkaWNTQ(j, canvasDrawScope);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public final long mo91toSpkPz2Gy4(float f) {
        return this.canvasDrawScope.mo91toSpkPz2Gy4(f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public final float mo85toDpu2uoSUM(float f) {
        return f / this.canvasDrawScope.getDensity();
    }
}
