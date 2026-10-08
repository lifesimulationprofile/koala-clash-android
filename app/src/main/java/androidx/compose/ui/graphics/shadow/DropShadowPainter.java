package androidx.compose.ui.graphics.shadow;

import androidx.collection.MutableScatterMap;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.LayoutDirection;
import coil.ImageLoader$Builder;
import coil.disk.RealDiskCache;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class DropShadowPainter extends Painter {
    public float alpha = 1.0f;
    public BlendModeColorFilter colorFilter;
    public final ImageLoader$Builder renderCreator;
    public final Shadow shadow;
    public final Shape shape;

    public DropShadowPainter(Shape shape, Shadow shadow, ImageLoader$Builder imageLoader$Builder) {
        this.shape = shape;
        this.shadow = shadow;
        this.renderCreator = imageLoader$Builder;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void applyAlpha(float f) {
        this.alpha = f;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void applyColorFilter(BlendModeColorFilter blendModeColorFilter) {
        this.colorFilter = blendModeColorFilter;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    public final long mo490getIntrinsicSizeNHjbRc() {
        return 9205357640488583168L;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void onDraw(LayoutNodeDrawScope layoutNodeDrawScope) {
        DropShadowRenderer dropShadowRenderer;
        ImageLoader$Builder imageLoader$Builder = this.renderCreator;
        Shape shape = this.shape;
        long jMo472getSizeNHjbRc = layoutNodeDrawScope.mo472getSizeNHjbRc();
        LayoutDirection layoutDirection = layoutNodeDrawScope.getLayoutDirection();
        Shadow shadow = this.shadow;
        synchronized (imageLoader$Builder) {
            AndroidShadowContext$ShadowKey androidShadowContext$ShadowKey = (AndroidShadowContext$ShadowKey) imageLoader$Builder.options;
            if (androidShadowContext$ShadowKey == null) {
                AndroidShadowContext$ShadowKey androidShadowContext$ShadowKey2 = new AndroidShadowContext$ShadowKey(BrushKt.RectangleShape, 0L, LayoutDirection.Ltr, 1.0f, null);
                imageLoader$Builder.options = androidShadowContext$ShadowKey2;
                androidShadowContext$ShadowKey = androidShadowContext$ShadowKey2;
            }
            androidShadowContext$ShadowKey.shape = shape;
            androidShadowContext$ShadowKey.size = jMo472getSizeNHjbRc;
            androidShadowContext$ShadowKey.layoutDirection = layoutDirection;
            androidShadowContext$ShadowKey.density = layoutNodeDrawScope.canvasDrawScope.getDensity();
            androidShadowContext$ShadowKey.shadow = new Shadow(shadow.radius, shadow.spread, 0L, shadow.color, shadow.brush, shadow.alpha, shadow.blendMode);
            MutableScatterMap mutableScatterMap = (MutableScatterMap) imageLoader$Builder.applicationContext;
            if (mutableScatterMap == null) {
                mutableScatterMap = new MutableScatterMap();
                imageLoader$Builder.applicationContext = mutableScatterMap;
            }
            dropShadowRenderer = (DropShadowRenderer) mutableScatterMap.get(androidShadowContext$ShadowKey);
            if (dropShadowRenderer == null) {
                dropShadowRenderer = new DropShadowRenderer(shadow, shape.mo57createOutlinePq9zytI(jMo472getSizeNHjbRc, layoutDirection, layoutNodeDrawScope));
                MutableScatterMap mutableScatterMap2 = (MutableScatterMap) imageLoader$Builder.applicationContext;
                if (mutableScatterMap2 == null) {
                    mutableScatterMap2 = new MutableScatterMap();
                    imageLoader$Builder.applicationContext = mutableScatterMap2;
                }
                mutableScatterMap2.set(AndroidShadowContext$ShadowKey.m494copyeZhPAX0$default(androidShadowContext$ShadowKey), dropShadowRenderer);
            }
        }
        float fMo89toPx0680j_4 = layoutNodeDrawScope.mo89toPx0680j_4(DpOffset.m704getXD9Ej5fM(this.shadow.offset));
        float fMo89toPx0680j_5 = layoutNodeDrawScope.mo89toPx0680j_4(DpOffset.m705getYD9Ej5fM(this.shadow.offset));
        ((RealDiskCache.RealEditor) layoutNodeDrawScope.canvasDrawScope.drawContext.rootElement).translate(fMo89toPx0680j_4, fMo89toPx0680j_5);
        try {
            BlendModeColorFilter blendModeColorFilter = this.colorFilter;
            long jMo472getSizeNHjbRc2 = layoutNodeDrawScope.mo472getSizeNHjbRc();
            Shadow shadow2 = dropShadowRenderer.shadow;
            dropShadowRenderer.m498drawShadowerFMhIw(layoutNodeDrawScope, blendModeColorFilter, jMo472getSizeNHjbRc2, shadow2.color, shadow2.brush, RangesKt.coerceIn(this.alpha * shadow2.alpha, 0.0f, 1.0f), dropShadowRenderer.shadow.blendMode);
        } finally {
            ((RealDiskCache.RealEditor) layoutNodeDrawScope.canvasDrawScope.drawContext.rootElement).translate(-fMo89toPx0680j_4, -fMo89toPx0680j_5);
        }
    }
}
