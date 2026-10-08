package androidx.compose.ui.graphics.layer;

import android.graphics.Canvas;
import android.graphics.Outline;
import android.view.View;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContextKt;
import androidx.compose.ui.graphics.layer.view.DrawChildContainer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupLayout;
import com.caverock.androidsvg.SVG;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewLayer extends View {
    public static final PopupLayout.AnonymousClass2 LayerOutlineProvider = new PopupLayout.AnonymousClass2(2);
    public boolean canUseCompositingLayer;
    public final CanvasDrawScope canvasDrawScope;
    public final CanvasHolder canvasHolder;
    public Density density;
    public Lambda drawBlock;
    public boolean isInvalidated;
    public Outline layerOutline;
    public LayoutDirection layoutDirection;
    public final DrawChildContainer ownerView;
    public GraphicsLayer parentLayer;

    public ViewLayer(DrawChildContainer drawChildContainer, CanvasHolder canvasHolder, CanvasDrawScope canvasDrawScope) {
        super(drawChildContainer.getContext());
        this.ownerView = drawChildContainer;
        this.canvasHolder = canvasHolder;
        this.canvasDrawScope = canvasDrawScope;
        setOutlineProvider(LayerOutlineProvider);
        this.canUseCompositingLayer = true;
        this.density = DrawContextKt.DefaultDensity;
        this.layoutDirection = LayoutDirection.Ltr;
        GraphicsLayerImpl.Companion.getClass();
        this.drawBlock = GraphicsLayer$drawBlock$1.INSTANCE$1;
        setWillNotDraw(false);
        setClipBounds(null);
    }

    /* JADX WARN: Type inference failed for: r9v0, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
    @Override // android.view.View
    public final void dispatchDraw(Canvas canvas) {
        CanvasHolder canvasHolder = this.canvasHolder;
        AndroidCanvas androidCanvas = canvasHolder.androidCanvas;
        Canvas canvas2 = androidCanvas.internalCanvas;
        androidCanvas.internalCanvas = canvas;
        Density density = this.density;
        LayoutDirection layoutDirection = this.layoutDirection;
        float width = getWidth();
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(getHeight())) & 4294967295L) | (Float.floatToRawIntBits(width) << 32);
        GraphicsLayer graphicsLayer = this.parentLayer;
        ?? r9 = this.drawBlock;
        CanvasDrawScope canvasDrawScope = this.canvasDrawScope;
        Density density2 = canvasDrawScope.drawContext.getDensity();
        SVG svg = canvasDrawScope.drawContext;
        LayoutDirection layoutDirection2 = svg.getLayoutDirection();
        androidx.compose.ui.graphics.Canvas canvas3 = svg.getCanvas();
        long jM795getSizeNHjbRc = svg.m795getSizeNHjbRc();
        GraphicsLayer graphicsLayer2 = (GraphicsLayer) svg.cssRules;
        svg.setDensity(density);
        svg.setLayoutDirection(layoutDirection);
        svg.setCanvas(androidCanvas);
        svg.m797setSizeuvyYCjk(jFloatToRawIntBits);
        svg.cssRules = graphicsLayer;
        androidCanvas.save();
        try {
            r9.invoke(canvasDrawScope);
            androidCanvas.restore();
            svg.setDensity(density2);
            svg.setLayoutDirection(layoutDirection2);
            svg.setCanvas(canvas3);
            svg.m797setSizeuvyYCjk(jM795getSizeNHjbRc);
            svg.cssRules = graphicsLayer2;
            canvasHolder.androidCanvas.internalCanvas = canvas2;
            this.isInvalidated = false;
        } catch (Throwable th) {
            androidCanvas.restore();
            svg.setDensity(density2);
            svg.setLayoutDirection(layoutDirection2);
            svg.setCanvas(canvas3);
            svg.m797setSizeuvyYCjk(jM795getSizeNHjbRc);
            svg.cssRules = graphicsLayer2;
            throw th;
        }
    }

    public final boolean getCanUseCompositingLayer$ui_graphics() {
        return this.canUseCompositingLayer;
    }

    public final CanvasHolder getCanvasHolder() {
        return this.canvasHolder;
    }

    public final View getOwnerView() {
        return this.ownerView;
    }

    @Override // android.view.View
    public final boolean hasOverlappingRendering() {
        return this.canUseCompositingLayer;
    }

    @Override // android.view.View
    public final void invalidate() {
        if (this.isInvalidated) {
            return;
        }
        this.isInvalidated = true;
        super.invalidate();
    }

    public final void setCanUseCompositingLayer$ui_graphics(boolean z) {
        if (this.canUseCompositingLayer != z) {
            this.canUseCompositingLayer = z;
            invalidate();
        }
    }

    public final void setInvalidated(boolean z) {
        this.isInvalidated = z;
    }

    @Override // android.view.View
    public final void forceLayout() {
    }

    @Override // android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }
}
