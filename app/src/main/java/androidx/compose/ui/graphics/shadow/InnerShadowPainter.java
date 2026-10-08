package androidx.compose.ui.graphics.shadow;

import androidx.collection.MutableScatterMap;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.unit.LayoutDirection;
import coil.ImageLoader$Builder;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class InnerShadowPainter extends Painter {
    public float alpha = 1.0f;
    public BlendModeColorFilter colorFilter;
    public final ImageLoader$Builder renderCreator;
    public final Shadow shadow;
    public final Shape shape;

    public InnerShadowPainter(Shape shape, Shadow shadow, ImageLoader$Builder imageLoader$Builder) {
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
        InnerShadowRenderer innerShadowRenderer;
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
            androidShadowContext$ShadowKey.shadow = shadow;
            MutableScatterMap mutableScatterMap = (MutableScatterMap) imageLoader$Builder.defaults;
            if (mutableScatterMap == null) {
                mutableScatterMap = new MutableScatterMap();
                imageLoader$Builder.defaults = mutableScatterMap;
            }
            InnerShadowRenderer innerShadowRenderer2 = (InnerShadowRenderer) mutableScatterMap.get(androidShadowContext$ShadowKey);
            if (innerShadowRenderer2 == null) {
                innerShadowRenderer2 = new InnerShadowRenderer(shadow, shape.mo57createOutlinePq9zytI(jMo472getSizeNHjbRc, layoutDirection, layoutNodeDrawScope));
                MutableScatterMap mutableScatterMap2 = (MutableScatterMap) imageLoader$Builder.defaults;
                if (mutableScatterMap2 == null) {
                    mutableScatterMap2 = new MutableScatterMap();
                    imageLoader$Builder.defaults = mutableScatterMap2;
                }
                mutableScatterMap2.set(AndroidShadowContext$ShadowKey.m494copyeZhPAX0$default(androidShadowContext$ShadowKey), innerShadowRenderer2);
            }
            innerShadowRenderer = innerShadowRenderer2;
        }
        BlendModeColorFilter blendModeColorFilter = this.colorFilter;
        long jMo472getSizeNHjbRc2 = layoutNodeDrawScope.mo472getSizeNHjbRc();
        Shadow shadow2 = this.shadow;
        innerShadowRenderer.m498drawShadowerFMhIw(layoutNodeDrawScope, blendModeColorFilter, jMo472getSizeNHjbRc2, shadow2.color, shadow2.brush, RangesKt.coerceIn(this.alpha * shadow2.alpha, 0.0f, 1.0f), this.shadow.blendMode);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void applyLayoutDirection(LayoutDirection layoutDirection) {
    }
}
