package androidx.compose.foundation;

import android.graphics.Canvas;
import android.graphics.RecordingCanvas;
import android.graphics.RenderNode;
import android.os.Build;
import android.widget.EdgeEffect;
import androidx.appcompat.widget.DrawableUtils$$ExternalSyntheticApiModelOutline0;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import coil.disk.RealDiskCache;
import com.caverock.androidsvg.SVG;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class GlowOverscrollNode extends DelegatingNode implements DrawModifierNode {
    public final /* synthetic */ int $r8$classId = 1;
    public final EdgeEffectWrapper edgeEffectWrapper;
    public Object glowDrawPadding;
    public final AndroidEdgeEffectOverscrollEffect overscrollEffect;

    public GlowOverscrollNode(SuspendingPointerInputModifierNodeImpl suspendingPointerInputModifierNodeImpl, AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, EdgeEffectWrapper edgeEffectWrapper) {
        this.overscrollEffect = androidEdgeEffectOverscrollEffect;
        this.edgeEffectWrapper = edgeEffectWrapper;
        delegate(suspendingPointerInputModifierNodeImpl);
    }

    public static boolean drawWithRotation(float f, EdgeEffect edgeEffect, Canvas canvas) {
        if (f == 0.0f) {
            return edgeEffect.draw(canvas);
        }
        int iSave = canvas.save();
        canvas.rotate(f);
        boolean zDraw = edgeEffect.draw(canvas);
        canvas.restoreToCount(iSave);
        return zDraw;
    }

    /* JADX INFO: renamed from: drawWithRotationAndOffset-ubNVwUQ, reason: not valid java name */
    public static boolean m43drawWithRotationAndOffsetubNVwUQ(float f, long j, EdgeEffect edgeEffect, Canvas canvas) {
        int iSave = canvas.save();
        canvas.rotate(f);
        canvas.translate(Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)));
        boolean zDraw = edgeEffect.draw(canvas);
        canvas.restoreToCount(iSave);
        return zDraw;
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final void draw(LayoutNodeDrawScope layoutNodeDrawScope) {
        boolean zM43drawWithRotationAndOffsetubNVwUQ;
        char c;
        float f;
        RecordingCanvas recordingCanvas;
        boolean zDrawWithRotation;
        RecordingCanvas recordingCanvas2;
        boolean z;
        int i = this.$r8$classId;
        AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect = this.overscrollEffect;
        EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
        switch (i) {
            case 0:
                PaddingValues paddingValues = (PaddingValues) this.glowDrawPadding;
                CanvasDrawScope canvasDrawScope = layoutNodeDrawScope.canvasDrawScope;
                androidEdgeEffectOverscrollEffect.m42updateSizeuvyYCjk$foundation(canvasDrawScope.drawContext.m795getSizeNHjbRc());
                if (Size.m386isEmptyimpl(canvasDrawScope.drawContext.m795getSizeNHjbRc())) {
                    layoutNodeDrawScope.drawContent();
                    return;
                }
                layoutNodeDrawScope.drawContent();
                androidEdgeEffectOverscrollEffect.redrawSignal.getValue();
                androidx.compose.ui.graphics.Canvas canvas = canvasDrawScope.drawContext.getCanvas();
                Canvas canvas2 = AndroidCanvas_androidKt.EmptyCanvas;
                Canvas canvas3 = ((AndroidCanvas) canvas).internalCanvas;
                if (EdgeEffectWrapper.isAnimating(edgeEffectWrapper.leftEffect)) {
                    zM43drawWithRotationAndOffsetubNVwUQ = m43drawWithRotationAndOffsetubNVwUQ(270.0f, (((long) Float.floatToRawIntBits(-Float.intBitsToFloat((int) (layoutNodeDrawScope.mo472getSizeNHjbRc() & 4294967295L)))) << 32) | (((long) Float.floatToRawIntBits(layoutNodeDrawScope.mo89toPx0680j_4(paddingValues.mo115calculateLeftPaddingu2uoSUM(layoutNodeDrawScope.getLayoutDirection())))) & 4294967295L), edgeEffectWrapper.getOrCreateLeftEffect(), canvas3);
                } else {
                    zM43drawWithRotationAndOffsetubNVwUQ = false;
                }
                if (EdgeEffectWrapper.isAnimating(edgeEffectWrapper.topEffect)) {
                    zM43drawWithRotationAndOffsetubNVwUQ = m43drawWithRotationAndOffsetubNVwUQ(0.0f, (((long) Float.floatToRawIntBits(layoutNodeDrawScope.mo89toPx0680j_4(paddingValues.mo117calculateTopPaddingD9Ej5fM()))) & 4294967295L) | (((long) Float.floatToRawIntBits(0.0f)) << 32), edgeEffectWrapper.getOrCreateTopEffect(), canvas3) || zM43drawWithRotationAndOffsetubNVwUQ;
                }
                if (EdgeEffectWrapper.isAnimating(edgeEffectWrapper.rightEffect)) {
                    zM43drawWithRotationAndOffsetubNVwUQ = m43drawWithRotationAndOffsetubNVwUQ(90.0f, (((long) Float.floatToRawIntBits(layoutNodeDrawScope.mo89toPx0680j_4(paddingValues.mo116calculateRightPaddingu2uoSUM(layoutNodeDrawScope.getLayoutDirection())) + (-((float) MathKt.roundToInt(Float.intBitsToFloat((int) (layoutNodeDrawScope.mo472getSizeNHjbRc() >> 32))))))) & 4294967295L) | (((long) Float.floatToRawIntBits(0.0f)) << 32), edgeEffectWrapper.getOrCreateRightEffect(), canvas3) || zM43drawWithRotationAndOffsetubNVwUQ;
                }
                if (EdgeEffectWrapper.isAnimating(edgeEffectWrapper.bottomEffect)) {
                    EdgeEffect orCreateBottomEffect = edgeEffectWrapper.getOrCreateBottomEffect();
                    zM43drawWithRotationAndOffsetubNVwUQ = m43drawWithRotationAndOffsetubNVwUQ(180.0f, (((long) Float.floatToRawIntBits(-Float.intBitsToFloat((int) (layoutNodeDrawScope.mo472getSizeNHjbRc() >> 32)))) << 32) | (((long) Float.floatToRawIntBits((-Float.intBitsToFloat((int) (layoutNodeDrawScope.mo472getSizeNHjbRc() & 4294967295L))) + layoutNodeDrawScope.mo89toPx0680j_4(paddingValues.mo114calculateBottomPaddingD9Ej5fM()))) & 4294967295L), orCreateBottomEffect, canvas3) || zM43drawWithRotationAndOffsetubNVwUQ;
                }
                if (zM43drawWithRotationAndOffsetubNVwUQ) {
                    androidEdgeEffectOverscrollEffect.invalidateOverscroll$foundation();
                    return;
                }
                return;
            default:
                CanvasDrawScope canvasDrawScope2 = layoutNodeDrawScope.canvasDrawScope;
                androidEdgeEffectOverscrollEffect.m42updateSizeuvyYCjk$foundation(canvasDrawScope2.drawContext.m795getSizeNHjbRc());
                androidx.compose.ui.graphics.Canvas canvas4 = canvasDrawScope2.drawContext.getCanvas();
                Canvas canvas5 = AndroidCanvas_androidKt.EmptyCanvas;
                Canvas canvas6 = ((AndroidCanvas) canvas4).internalCanvas;
                androidEdgeEffectOverscrollEffect.redrawSignal.getValue();
                SVG svg = canvasDrawScope2.drawContext;
                if (Size.m386isEmptyimpl(svg.m795getSizeNHjbRc())) {
                    layoutNodeDrawScope.drawContent();
                    return;
                }
                if (!canvas6.isHardwareAccelerated()) {
                    EdgeEffect edgeEffect = edgeEffectWrapper.topEffect;
                    if (edgeEffect != null) {
                        edgeEffect.finish();
                    }
                    EdgeEffect edgeEffect2 = edgeEffectWrapper.bottomEffect;
                    if (edgeEffect2 != null) {
                        edgeEffect2.finish();
                    }
                    EdgeEffect edgeEffect3 = edgeEffectWrapper.leftEffect;
                    if (edgeEffect3 != null) {
                        edgeEffect3.finish();
                    }
                    EdgeEffect edgeEffect4 = edgeEffectWrapper.rightEffect;
                    if (edgeEffect4 != null) {
                        edgeEffect4.finish();
                    }
                    EdgeEffect edgeEffect5 = edgeEffectWrapper.topEffectNegation;
                    if (edgeEffect5 != null) {
                        edgeEffect5.finish();
                    }
                    EdgeEffect edgeEffect6 = edgeEffectWrapper.bottomEffectNegation;
                    if (edgeEffect6 != null) {
                        edgeEffect6.finish();
                    }
                    EdgeEffect edgeEffect7 = edgeEffectWrapper.leftEffectNegation;
                    if (edgeEffect7 != null) {
                        edgeEffect7.finish();
                    }
                    EdgeEffect edgeEffect8 = edgeEffectWrapper.rightEffectNegation;
                    if (edgeEffect8 != null) {
                        edgeEffect8.finish();
                    }
                    layoutNodeDrawScope.drawContent();
                    return;
                }
                float fMo89toPx0680j_4 = layoutNodeDrawScope.mo89toPx0680j_4(ClipScrollableContainerKt.MaxSupportedElevation);
                boolean z2 = EdgeEffectWrapper.isAnimating(edgeEffectWrapper.topEffect) || EdgeEffectWrapper.isStretched(edgeEffectWrapper.topEffectNegation) || EdgeEffectWrapper.isAnimating(edgeEffectWrapper.bottomEffect) || EdgeEffectWrapper.isStretched(edgeEffectWrapper.bottomEffectNegation);
                boolean z3 = EdgeEffectWrapper.isAnimating(edgeEffectWrapper.leftEffect) || EdgeEffectWrapper.isStretched(edgeEffectWrapper.leftEffectNegation) || EdgeEffectWrapper.isAnimating(edgeEffectWrapper.rightEffect) || EdgeEffectWrapper.isStretched(edgeEffectWrapper.rightEffectNegation);
                if (z2 && z3) {
                    c = ' ';
                    getRenderNode().setPosition(0, 0, canvas6.getWidth(), canvas6.getHeight());
                } else {
                    c = ' ';
                    if (z2) {
                        getRenderNode().setPosition(0, 0, (MathKt.roundToInt(fMo89toPx0680j_4) * 2) + canvas6.getWidth(), canvas6.getHeight());
                    } else {
                        if (!z3) {
                            layoutNodeDrawScope.drawContent();
                            return;
                        }
                        getRenderNode().setPosition(0, 0, canvas6.getWidth(), (MathKt.roundToInt(fMo89toPx0680j_4) * 2) + canvas6.getHeight());
                    }
                }
                RecordingCanvas recordingCanvasBeginRecording = getRenderNode().beginRecording();
                boolean zIsStretched = EdgeEffectWrapper.isStretched(edgeEffectWrapper.leftEffectNegation);
                Orientation orientation = Orientation.Horizontal;
                if (zIsStretched) {
                    EdgeEffect edgeEffectCreateEdgeEffect = edgeEffectWrapper.leftEffectNegation;
                    if (edgeEffectCreateEdgeEffect == null) {
                        edgeEffectCreateEdgeEffect = edgeEffectWrapper.createEdgeEffect(orientation);
                        edgeEffectWrapper.leftEffectNegation = edgeEffectCreateEdgeEffect;
                    }
                    drawWithRotation(90.0f, edgeEffectCreateEdgeEffect, recordingCanvasBeginRecording);
                    edgeEffectCreateEdgeEffect.finish();
                }
                if (EdgeEffectWrapper.isAnimating(edgeEffectWrapper.leftEffect)) {
                    EdgeEffect orCreateLeftEffect = edgeEffectWrapper.getOrCreateLeftEffect();
                    zDrawWithRotation = drawWithRotation(270.0f, orCreateLeftEffect, recordingCanvasBeginRecording);
                    if (EdgeEffectWrapper.isStretched(edgeEffectWrapper.leftEffect)) {
                        recordingCanvas = recordingCanvasBeginRecording;
                        float fIntBitsToFloat = Float.intBitsToFloat((int) (androidEdgeEffectOverscrollEffect.m37displacementF1C5BW0$foundation() & 4294967295L));
                        EdgeEffect edgeEffectCreateEdgeEffect2 = edgeEffectWrapper.leftEffectNegation;
                        if (edgeEffectCreateEdgeEffect2 == null) {
                            edgeEffectCreateEdgeEffect2 = edgeEffectWrapper.createEdgeEffect(orientation);
                            edgeEffectWrapper.leftEffectNegation = edgeEffectCreateEdgeEffect2;
                        }
                        int i2 = Build.VERSION.SDK_INT;
                        float distance = i2 >= 31 ? Api31Impl.getDistance(orCreateLeftEffect) : 0.0f;
                        f = fMo89toPx0680j_4;
                        float f2 = 1 - fIntBitsToFloat;
                        if (i2 >= 31) {
                            Api31Impl.onPullDistance(edgeEffectCreateEdgeEffect2, distance, f2);
                        } else {
                            edgeEffectCreateEdgeEffect2.onPull(distance, f2);
                        }
                    } else {
                        f = fMo89toPx0680j_4;
                        recordingCanvas = recordingCanvasBeginRecording;
                    }
                } else {
                    f = fMo89toPx0680j_4;
                    recordingCanvas = recordingCanvasBeginRecording;
                    zDrawWithRotation = false;
                }
                boolean zIsStretched2 = EdgeEffectWrapper.isStretched(edgeEffectWrapper.topEffectNegation);
                Orientation orientation2 = Orientation.Vertical;
                if (zIsStretched2) {
                    EdgeEffect edgeEffectCreateEdgeEffect3 = edgeEffectWrapper.topEffectNegation;
                    if (edgeEffectCreateEdgeEffect3 == null) {
                        edgeEffectCreateEdgeEffect3 = edgeEffectWrapper.createEdgeEffect(orientation2);
                        edgeEffectWrapper.topEffectNegation = edgeEffectCreateEdgeEffect3;
                    }
                    recordingCanvas2 = recordingCanvas;
                    drawWithRotation(180.0f, edgeEffectCreateEdgeEffect3, recordingCanvas2);
                    edgeEffectCreateEdgeEffect3.finish();
                } else {
                    recordingCanvas2 = recordingCanvas;
                }
                if (EdgeEffectWrapper.isAnimating(edgeEffectWrapper.topEffect)) {
                    EdgeEffect orCreateTopEffect = edgeEffectWrapper.getOrCreateTopEffect();
                    boolean z4 = drawWithRotation(0.0f, orCreateTopEffect, recordingCanvas2) || zDrawWithRotation;
                    if (EdgeEffectWrapper.isStretched(edgeEffectWrapper.topEffect)) {
                        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (androidEdgeEffectOverscrollEffect.m37displacementF1C5BW0$foundation() >> c));
                        EdgeEffect edgeEffectCreateEdgeEffect4 = edgeEffectWrapper.topEffectNegation;
                        if (edgeEffectCreateEdgeEffect4 == null) {
                            edgeEffectCreateEdgeEffect4 = edgeEffectWrapper.createEdgeEffect(orientation2);
                            edgeEffectWrapper.topEffectNegation = edgeEffectCreateEdgeEffect4;
                        }
                        int i3 = Build.VERSION.SDK_INT;
                        z = z2;
                        float distance2 = i3 >= 31 ? Api31Impl.getDistance(orCreateTopEffect) : 0.0f;
                        if (i3 >= 31) {
                            Api31Impl.onPullDistance(edgeEffectCreateEdgeEffect4, distance2, fIntBitsToFloat2);
                        } else {
                            edgeEffectCreateEdgeEffect4.onPull(distance2, fIntBitsToFloat2);
                        }
                    } else {
                        z = z2;
                        z3 = z3;
                    }
                    zDrawWithRotation = z4;
                } else {
                    z = z2;
                    z3 = z3;
                }
                if (EdgeEffectWrapper.isStretched(edgeEffectWrapper.rightEffectNegation)) {
                    EdgeEffect edgeEffectCreateEdgeEffect5 = edgeEffectWrapper.rightEffectNegation;
                    if (edgeEffectCreateEdgeEffect5 == null) {
                        edgeEffectCreateEdgeEffect5 = edgeEffectWrapper.createEdgeEffect(orientation);
                        edgeEffectWrapper.rightEffectNegation = edgeEffectCreateEdgeEffect5;
                    }
                    drawWithRotation(270.0f, edgeEffectCreateEdgeEffect5, recordingCanvas2);
                    edgeEffectCreateEdgeEffect5.finish();
                }
                if (EdgeEffectWrapper.isAnimating(edgeEffectWrapper.rightEffect)) {
                    EdgeEffect orCreateRightEffect = edgeEffectWrapper.getOrCreateRightEffect();
                    boolean z5 = drawWithRotation(90.0f, orCreateRightEffect, recordingCanvas2) || zDrawWithRotation;
                    if (EdgeEffectWrapper.isStretched(edgeEffectWrapper.rightEffect)) {
                        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (androidEdgeEffectOverscrollEffect.m37displacementF1C5BW0$foundation() & 4294967295L));
                        EdgeEffect edgeEffectCreateEdgeEffect6 = edgeEffectWrapper.rightEffectNegation;
                        if (edgeEffectCreateEdgeEffect6 == null) {
                            edgeEffectCreateEdgeEffect6 = edgeEffectWrapper.createEdgeEffect(orientation);
                            edgeEffectWrapper.rightEffectNegation = edgeEffectCreateEdgeEffect6;
                        }
                        int i4 = Build.VERSION.SDK_INT;
                        float distance3 = i4 >= 31 ? Api31Impl.getDistance(orCreateRightEffect) : 0.0f;
                        if (i4 >= 31) {
                            Api31Impl.onPullDistance(edgeEffectCreateEdgeEffect6, distance3, fIntBitsToFloat3);
                        } else {
                            edgeEffectCreateEdgeEffect6.onPull(distance3, fIntBitsToFloat3);
                        }
                    }
                    zDrawWithRotation = z5;
                }
                if (EdgeEffectWrapper.isStretched(edgeEffectWrapper.bottomEffectNegation)) {
                    EdgeEffect edgeEffectCreateEdgeEffect7 = edgeEffectWrapper.bottomEffectNegation;
                    if (edgeEffectCreateEdgeEffect7 == null) {
                        edgeEffectCreateEdgeEffect7 = edgeEffectWrapper.createEdgeEffect(orientation2);
                        edgeEffectWrapper.bottomEffectNegation = edgeEffectCreateEdgeEffect7;
                    }
                    drawWithRotation(0.0f, edgeEffectCreateEdgeEffect7, recordingCanvas2);
                    edgeEffectCreateEdgeEffect7.finish();
                }
                if (EdgeEffectWrapper.isAnimating(edgeEffectWrapper.bottomEffect)) {
                    EdgeEffect orCreateBottomEffect2 = edgeEffectWrapper.getOrCreateBottomEffect();
                    boolean z6 = drawWithRotation(180.0f, orCreateBottomEffect2, recordingCanvas2) || zDrawWithRotation;
                    if (EdgeEffectWrapper.isStretched(edgeEffectWrapper.bottomEffect)) {
                        float fIntBitsToFloat4 = Float.intBitsToFloat((int) (androidEdgeEffectOverscrollEffect.m37displacementF1C5BW0$foundation() >> c));
                        EdgeEffect edgeEffectCreateEdgeEffect8 = edgeEffectWrapper.bottomEffectNegation;
                        if (edgeEffectCreateEdgeEffect8 == null) {
                            edgeEffectCreateEdgeEffect8 = edgeEffectWrapper.createEdgeEffect(orientation2);
                            edgeEffectWrapper.bottomEffectNegation = edgeEffectCreateEdgeEffect8;
                        }
                        int i5 = Build.VERSION.SDK_INT;
                        float distance4 = i5 >= 31 ? Api31Impl.getDistance(orCreateBottomEffect2) : 0.0f;
                        float f3 = 1 - fIntBitsToFloat4;
                        if (i5 >= 31) {
                            Api31Impl.onPullDistance(edgeEffectCreateEdgeEffect8, distance4, f3);
                        } else {
                            edgeEffectCreateEdgeEffect8.onPull(distance4, f3);
                        }
                    }
                    zDrawWithRotation = z6;
                }
                if (zDrawWithRotation) {
                    androidEdgeEffectOverscrollEffect.invalidateOverscroll$foundation();
                }
                float f4 = z3 ? 0.0f : f;
                float f5 = z ? 0.0f : f;
                LayoutDirection layoutDirection = layoutNodeDrawScope.getLayoutDirection();
                AndroidCanvas androidCanvas = new AndroidCanvas();
                androidCanvas.internalCanvas = recordingCanvas2;
                long jM795getSizeNHjbRc = svg.m795getSizeNHjbRc();
                Density density = canvasDrawScope2.drawContext.getDensity();
                LayoutDirection layoutDirection2 = canvasDrawScope2.drawContext.getLayoutDirection();
                androidx.compose.ui.graphics.Canvas canvas7 = canvasDrawScope2.drawContext.getCanvas();
                long jM795getSizeNHjbRc2 = canvasDrawScope2.drawContext.m795getSizeNHjbRc();
                SVG svg2 = canvasDrawScope2.drawContext;
                GraphicsLayer graphicsLayer = (GraphicsLayer) svg2.cssRules;
                svg2.setDensity(layoutNodeDrawScope);
                svg2.setLayoutDirection(layoutDirection);
                svg2.setCanvas(androidCanvas);
                svg2.m797setSizeuvyYCjk(jM795getSizeNHjbRc);
                svg2.cssRules = null;
                androidCanvas.save();
                try {
                    ((RealDiskCache.RealEditor) canvasDrawScope2.drawContext.rootElement).translate(f4, f5);
                    try {
                        layoutNodeDrawScope.drawContent();
                        float f6 = -f4;
                        float f7 = -f5;
                        ((RealDiskCache.RealEditor) canvasDrawScope2.drawContext.rootElement).translate(f6, f7);
                        androidCanvas.restore();
                        SVG svg3 = canvasDrawScope2.drawContext;
                        svg3.setDensity(density);
                        svg3.setLayoutDirection(layoutDirection2);
                        svg3.setCanvas(canvas7);
                        svg3.m797setSizeuvyYCjk(jM795getSizeNHjbRc2);
                        svg3.cssRules = graphicsLayer;
                        getRenderNode().endRecording();
                        int iSave = canvas6.save();
                        canvas6.translate(f6, f7);
                        canvas6.drawRenderNode(getRenderNode());
                        canvas6.restoreToCount(iSave);
                        return;
                    } catch (Throwable th) {
                        ((RealDiskCache.RealEditor) canvasDrawScope2.drawContext.rootElement).translate(-f4, -f5);
                        throw th;
                    }
                } catch (Throwable th2) {
                    androidCanvas.restore();
                    SVG svg4 = canvasDrawScope2.drawContext;
                    svg4.setDensity(density);
                    svg4.setLayoutDirection(layoutDirection2);
                    svg4.setCanvas(canvas7);
                    svg4.m797setSizeuvyYCjk(jM795getSizeNHjbRc2);
                    svg4.cssRules = graphicsLayer;
                    throw th2;
                }
        }
    }

    public RenderNode getRenderNode() {
        RenderNode renderNode = (RenderNode) this.glowDrawPadding;
        if (renderNode != null) {
            return renderNode;
        }
        RenderNode renderNodeM5m = DrawableUtils$$ExternalSyntheticApiModelOutline0.m5m();
        this.glowDrawPadding = renderNodeM5m;
        return renderNodeM5m;
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final /* synthetic */ void onMeasureResultChanged() {
        int i = this.$r8$classId;
    }

    public GlowOverscrollNode(SuspendingPointerInputModifierNodeImpl suspendingPointerInputModifierNodeImpl, AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, EdgeEffectWrapper edgeEffectWrapper, PaddingValues paddingValues) {
        this.overscrollEffect = androidEdgeEffectOverscrollEffect;
        this.edgeEffectWrapper = edgeEffectWrapper;
        this.glowDrawPadding = paddingValues;
        delegate(suspendingPointerInputModifierNodeImpl);
    }

    private final /* synthetic */ void onMeasureResultChanged$androidx$compose$foundation$GlowOverscrollNode() {
    }

    private final /* synthetic */ void onMeasureResultChanged$androidx$compose$foundation$StretchOverscrollNode() {
    }
}
