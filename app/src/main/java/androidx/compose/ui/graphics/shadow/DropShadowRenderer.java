package androidx.compose.ui.graphics.shadow;

import android.graphics.Bitmap;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidImageBitmap;
import androidx.compose.ui.graphics.AndroidPaint;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.BrushKt$ShaderBrush$1;
import androidx.compose.ui.graphics.CompositeShaderBrush;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import coil.disk.RealDiskCache;
import kotlin.Unit;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class DropShadowRenderer extends ShadowRenderer {
    public CompositeShaderBrush compositeShader;
    public final AndroidPaint paint;
    public final Shadow shadow;
    public AndroidImageBitmap shadowBitmap;

    public DropShadowRenderer(Shadow shadow, BrushKt brushKt) {
        super(brushKt);
        this.shadow = shadow;
        this.paint = BrushKt.Paint();
    }

    @Override // androidx.compose.ui.graphics.shadow.ShadowRenderer
    /* JADX INFO: renamed from: buildShadow-_SMYjrA, reason: not valid java name */
    public final void mo496buildShadow_SMYjrA(LayoutNodeDrawScope layoutNodeDrawScope, long j, long j2, AndroidPath androidPath) {
        AndroidImageBitmap androidImageBitmapM410ImageBitmapx__hDU$default;
        Shadow shadow = this.shadow;
        float fMo89toPx0680j_4 = layoutNodeDrawScope.mo89toPx0680j_4(shadow.radius);
        float fMo89toPx0680j_5 = layoutNodeDrawScope.mo89toPx0680j_4(shadow.spread);
        AndroidPaint androidPaint = this.paint;
        if (androidPath != null) {
            float f = 2;
            float f2 = (f * fMo89toPx0680j_5) + (fMo89toPx0680j_4 * f);
            androidImageBitmapM410ImageBitmapx__hDU$default = BrushKt.m410ImageBitmapx__hDU$default((int) Math.ceil(Float.intBitsToFloat((int) (j >> 32)) + f2), (int) Math.ceil(Float.intBitsToFloat((int) (j & 4294967295L)) + f2), 1);
            AndroidCanvas androidCanvasCanvas = BrushKt.Canvas(androidImageBitmapM410ImageBitmapx__hDU$default);
            if (fMo89toPx0680j_5 > 0.0f) {
                float f3 = fMo89toPx0680j_4 + fMo89toPx0680j_5;
                androidCanvasCanvas.translate(f3, f3);
                androidCanvasCanvas.drawPath(androidPath, BlurKt.m495configureShadowFoewPVk$default(androidPaint, 0, fMo89toPx0680j_4 > 0.0f ? Blur_androidKt.BlurFilter(fMo89toPx0680j_4) : null, 11));
                AndroidPaint androidPaintM495configureShadowFoewPVk$default = BlurKt.m495configureShadowFoewPVk$default(androidPaint, 0, fMo89toPx0680j_4 > 0.0f ? Blur_androidKt.BlurFilter(fMo89toPx0680j_4) : null, 3);
                androidPaintM495configureShadowFoewPVk$default.setStrokeWidth(fMo89toPx0680j_5 * 2.0f);
                Unit unit = Unit.INSTANCE;
                androidCanvasCanvas.drawPath(androidPath, androidPaintM495configureShadowFoewPVk$default);
            } else {
                BlurKt.m495configureShadowFoewPVk$default(androidPaint, 0, fMo89toPx0680j_4 > 0.0f ? Blur_androidKt.BlurFilter(fMo89toPx0680j_4) : null, 11);
                androidCanvasCanvas.translate(fMo89toPx0680j_4, fMo89toPx0680j_4);
                androidCanvasCanvas.drawPath(androidPath, androidPaint);
            }
        } else {
            float f4 = 2;
            float f5 = (fMo89toPx0680j_5 * f4) + (fMo89toPx0680j_4 * f4);
            float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) + f5;
            float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L)) + f5;
            androidImageBitmapM410ImageBitmapx__hDU$default = BrushKt.m410ImageBitmapx__hDU$default((int) Math.ceil(fIntBitsToFloat), (int) Math.ceil(fIntBitsToFloat2), 1);
            BrushKt.Canvas(androidImageBitmapM410ImageBitmapx__hDU$default).drawRoundRect(fMo89toPx0680j_4, fMo89toPx0680j_4, fIntBitsToFloat - fMo89toPx0680j_4, fIntBitsToFloat2 - fMo89toPx0680j_4, Float.intBitsToFloat((int) (j2 >> 32)), Float.intBitsToFloat((int) (j2 & 4294967295L)), BlurKt.m495configureShadowFoewPVk$default(androidPaint, 0, fMo89toPx0680j_4 > 0.0f ? Blur_androidKt.BlurFilter(fMo89toPx0680j_4) : null, 11));
        }
        this.shadowBitmap = androidImageBitmapM410ImageBitmapx__hDU$default;
    }

    @Override // androidx.compose.ui.graphics.shadow.ShadowRenderer
    /* JADX INFO: renamed from: onDrawShadow-MLmccfk, reason: not valid java name */
    public final void mo497onDrawShadowMLmccfk(LayoutNodeDrawScope layoutNodeDrawScope, long j, AndroidPath androidPath, float f, BlendModeColorFilter blendModeColorFilter, Brush brush, int i) {
        long j2;
        CompositeShaderBrush compositeShaderBrush;
        Brush brushKt$ShaderBrush$1 = brush;
        CanvasDrawScope canvasDrawScope = layoutNodeDrawScope.canvasDrawScope;
        AndroidImageBitmap androidImageBitmap = this.shadowBitmap;
        if (androidImageBitmap != null) {
            Bitmap bitmap = androidImageBitmap.bitmap;
            Shadow shadow = this.shadow;
            float f2 = -(layoutNodeDrawScope.mo89toPx0680j_4(shadow.spread) + layoutNodeDrawScope.mo89toPx0680j_4(shadow.radius));
            if (brushKt$ShaderBrush$1 == null || blendModeColorFilter != null) {
                Modifier.CC.m309drawImagegbVJVH8$default(layoutNodeDrawScope, androidImageBitmap, (((long) Float.floatToRawIntBits(f2)) << 32) | (((long) Float.floatToRawIntBits(f2)) & 4294967295L), f, blendModeColorFilter, i, 8);
                return;
            }
            CompositeShaderBrush compositeShaderBrush2 = this.compositeShader;
            if (compositeShaderBrush2 == null || !compositeShaderBrush2.srcBrush.equals(brushKt$ShaderBrush$1)) {
                BrushKt$ShaderBrush$1 brushKt$ShaderBrush$2 = new BrushKt$ShaderBrush$1(BrushKt.m411ImageShaderF49vj9s$default(androidImageBitmap));
                if (brushKt$ShaderBrush$1 instanceof ShaderBrush) {
                    float width = bitmap.getWidth();
                    j2 = 4294967295L;
                    brushKt$ShaderBrush$1 = new BrushKt$ShaderBrush$1(((ShaderBrush) brushKt$ShaderBrush$1).mo429createShaderuvyYCjk((((long) Float.floatToRawIntBits(bitmap.getHeight())) & 4294967295L) | (Float.floatToRawIntBits(width) << 32)));
                } else {
                    j2 = 4294967295L;
                }
                compositeShaderBrush = new CompositeShaderBrush(BrushKt.toShaderBrush(brushKt$ShaderBrush$2), BrushKt.toShaderBrush(brushKt$ShaderBrush$1));
                this.compositeShader = compositeShaderBrush;
            } else {
                compositeShaderBrush = compositeShaderBrush2;
                j2 = 4294967295L;
            }
            ((RealDiskCache.RealEditor) canvasDrawScope.drawContext.rootElement).translate(f2, f2);
            try {
                float width2 = bitmap.getWidth();
                Modifier.CC.m313drawRectAsUm42w$default(layoutNodeDrawScope, compositeShaderBrush, 0L, (((long) Float.floatToRawIntBits(bitmap.getHeight())) & j2) | (Float.floatToRawIntBits(width2) << 32), f, null, null, i, 50);
            } finally {
                float f3 = -f2;
                ((RealDiskCache.RealEditor) canvasDrawScope.drawContext.rootElement).translate(f3, f3);
            }
        }
    }
}
