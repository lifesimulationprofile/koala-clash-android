package androidx.compose.ui.graphics.drawscope;

import android.graphics.Paint;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidImageBitmap;
import androidx.compose.ui.graphics.AndroidPaint;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.navigation.NavController$handleDeepLink$2;
import coil.network.HttpException;
import com.caverock.androidsvg.SVG;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class CanvasDrawScope implements DrawScope {
    public final SVG drawContext;
    public final DrawParams drawParams;
    public AndroidPaint fillPaint;
    public AndroidPaint strokePaint;

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class DrawParams {
        public Canvas canvas;
        public Density density;
        public LayoutDirection layoutDirection;
        public long size;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DrawParams)) {
                return false;
            }
            DrawParams drawParams = (DrawParams) obj;
            return Intrinsics.areEqual(this.density, drawParams.density) && this.layoutDirection == drawParams.layoutDirection && Intrinsics.areEqual(this.canvas, drawParams.canvas) && Size.m382equalsimpl0(this.size, drawParams.size);
        }

        public final int hashCode() {
            int iHashCode = (this.canvas.hashCode() + ((this.layoutDirection.hashCode() + (this.density.hashCode() * 31)) * 31)) * 31;
            long j = this.size;
            return ((int) (j ^ (j >>> 32))) + iHashCode;
        }

        public final String toString() {
            return "DrawParams(density=" + this.density + ", layoutDirection=" + this.layoutDirection + ", canvas=" + this.canvas + ", size=" + ((Object) Size.m388toStringimpl(this.size)) + ')';
        }
    }

    public CanvasDrawScope() {
        DrawParams drawParams = new DrawParams();
        drawParams.density = DrawContextKt.DefaultDensity;
        drawParams.layoutDirection = LayoutDirection.Ltr;
        drawParams.canvas = EmptyCanvas.INSTANCE;
        drawParams.size = 0L;
        this.drawParams = drawParams;
        this.drawContext = new SVG(this);
    }

    /* JADX INFO: renamed from: configurePaint-2qPWKa0$default, reason: not valid java name */
    public static AndroidPaint m458configurePaint2qPWKa0$default(CanvasDrawScope canvasDrawScope, long j, DrawStyle drawStyle, float f, int i) {
        AndroidPaint androidPaintSelectPaint = canvasDrawScope.selectPaint(drawStyle);
        if (f != 1.0f) {
            j = BrushKt.Color(Color.m438getRedimpl(j), Color.m437getGreenimpl(j), Color.m435getBlueimpl(j), Color.m434getAlphaimpl(j) * f, Color.m436getColorSpaceimpl(j));
        }
        Paint paint = androidPaintSelectPaint.internalPaint;
        if (!Color.m433equalsimpl0(BrushKt.Color(paint.getColor()), j)) {
            androidPaintSelectPaint.m402setColor8_81llA(j);
        }
        if (androidPaintSelectPaint.internalShader != null) {
            androidPaintSelectPaint.setShader(null);
        }
        if (!Intrinsics.areEqual(androidPaintSelectPaint.internalColorFilter, null)) {
            androidPaintSelectPaint.setColorFilter(null);
        }
        if (androidPaintSelectPaint._blendMode != i) {
            androidPaintSelectPaint.m401setBlendModes9anfk8(i);
        }
        if (paint.isFilterBitmap()) {
            return androidPaintSelectPaint;
        }
        androidPaintSelectPaint.m403setFilterQualityvDHp3xo(1);
        return androidPaintSelectPaint;
    }

    /* JADX INFO: renamed from: configurePaint-swdJneE, reason: not valid java name */
    public final AndroidPaint m459configurePaintswdJneE(Brush brush, DrawStyle drawStyle, float f, BlendModeColorFilter blendModeColorFilter, int i, int i2) {
        AndroidPaint androidPaintSelectPaint = selectPaint(drawStyle);
        if (brush != null) {
            brush.mo409applyToPq9zytI(f, this.drawContext.m795getSizeNHjbRc(), androidPaintSelectPaint);
        } else {
            Paint paint = androidPaintSelectPaint.internalPaint;
            if (androidPaintSelectPaint.internalShader != null) {
                androidPaintSelectPaint.setShader(null);
            }
            long jColor = BrushKt.Color(paint.getColor());
            long j = Color.Black;
            if (!Color.m433equalsimpl0(jColor, j)) {
                androidPaintSelectPaint.m402setColor8_81llA(j);
            }
            if (paint.getAlpha() / 255.0f != f) {
                androidPaintSelectPaint.setAlpha(f);
            }
        }
        if (!Intrinsics.areEqual(androidPaintSelectPaint.internalColorFilter, blendModeColorFilter)) {
            androidPaintSelectPaint.setColorFilter(blendModeColorFilter);
        }
        if (androidPaintSelectPaint._blendMode != i) {
            androidPaintSelectPaint.m401setBlendModes9anfk8(i);
        }
        if (androidPaintSelectPaint.internalPaint.isFilterBitmap() == i2) {
            return androidPaintSelectPaint;
        }
        androidPaintSelectPaint.m403setFilterQualityvDHp3xo(i2);
        return androidPaintSelectPaint;
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawArc-yD3GUKo, reason: not valid java name */
    public final void mo460drawArcyD3GUKo(long j, float f, float f2, long j2, long j3, DrawStyle drawStyle) {
        int i = (int) (j2 >> 32);
        int i2 = (int) (j2 & 4294967295L);
        this.drawParams.canvas.drawArc(Float.intBitsToFloat(i), Float.intBitsToFloat(i2), Float.intBitsToFloat((int) (j3 >> 32)) + Float.intBitsToFloat(i), Float.intBitsToFloat((int) (j3 & 4294967295L)) + Float.intBitsToFloat(i2), f, f2, m458configurePaint2qPWKa0$default(this, j, drawStyle, 1.0f, 3));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawCircle-VaOC9Bg, reason: not valid java name */
    public final void mo461drawCircleVaOC9Bg(long j, float f, long j2, DrawStyle drawStyle) {
        this.drawParams.canvas.mo394drawCircle9KIMszo(f, j2, m458configurePaint2qPWKa0$default(this, j, drawStyle, 1.0f, 3));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawImage-AZ2fEMs, reason: not valid java name */
    public final void mo462drawImageAZ2fEMs(AndroidImageBitmap androidImageBitmap, long j, long j2, long j3, float f, BlendModeColorFilter blendModeColorFilter, int i) {
        this.drawParams.canvas.mo396drawImageRectHPBpro0(androidImageBitmap, j, j2, j3, m459configurePaintswdJneE(null, Fill.INSTANCE, f, blendModeColorFilter, 3, i));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawImage-gbVJVH8, reason: not valid java name */
    public final void mo463drawImagegbVJVH8(AndroidImageBitmap androidImageBitmap, long j, float f, BlendModeColorFilter blendModeColorFilter, int i) {
        this.drawParams.canvas.mo395drawImaged4ec7I(androidImageBitmap, j, m459configurePaintswdJneE(null, Fill.INSTANCE, f, blendModeColorFilter, i, 1));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawLine-NGM6Ib0, reason: not valid java name */
    public final void mo464drawLineNGM6Ib0(long j, long j2, long j3, float f, int i) {
        Canvas canvas = this.drawParams.canvas;
        AndroidPaint androidPaintPaint = this.strokePaint;
        if (androidPaintPaint == null) {
            androidPaintPaint = BrushKt.Paint();
            androidPaintPaint.m406setStylek9PVt8s(1);
            this.strokePaint = androidPaintPaint;
        }
        Paint paint = androidPaintPaint.internalPaint;
        if (!Color.m433equalsimpl0(BrushKt.Color(paint.getColor()), j)) {
            androidPaintPaint.m402setColor8_81llA(j);
        }
        if (androidPaintPaint.internalShader != null) {
            androidPaintPaint.setShader(null);
        }
        if (!Intrinsics.areEqual(androidPaintPaint.internalColorFilter, null)) {
            androidPaintPaint.setColorFilter(null);
        }
        if (androidPaintPaint._blendMode != 3) {
            androidPaintPaint.m401setBlendModes9anfk8(3);
        }
        if (paint.getStrokeWidth() != f) {
            androidPaintPaint.setStrokeWidth(f);
        }
        if (paint.getStrokeMiter() != 4.0f) {
            paint.setStrokeMiter(4.0f);
        }
        if (androidPaintPaint.m399getStrokeCapKaPHkGw() != i) {
            androidPaintPaint.m404setStrokeCapBeK7IIE(i);
        }
        if (androidPaintPaint.m400getStrokeJoinLxFBmk8() != 0) {
            androidPaintPaint.m405setStrokeJoinWw9F2mQ(0);
        }
        if (!paint.isFilterBitmap()) {
            androidPaintPaint.m403setFilterQualityvDHp3xo(1);
        }
        canvas.mo397drawLineWko1d7g(j2, j3, androidPaintPaint);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawPath-GBMwjPU, reason: not valid java name */
    public final void mo465drawPathGBMwjPU(AndroidPath androidPath, Brush brush, float f, DrawStyle drawStyle, BlendModeColorFilter blendModeColorFilter, int i) {
        this.drawParams.canvas.drawPath(androidPath, m459configurePaintswdJneE(brush, drawStyle, f, blendModeColorFilter, i, 1));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawPath-LG529CI, reason: not valid java name */
    public final void mo466drawPathLG529CI(AndroidPath androidPath, long j, DrawStyle drawStyle) {
        this.drawParams.canvas.drawPath(androidPath, m458configurePaint2qPWKa0$default(this, j, drawStyle, 1.0f, 3));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRect-AsUm42w, reason: not valid java name */
    public final void mo467drawRectAsUm42w(Brush brush, long j, long j2, float f, DrawStyle drawStyle, BlendModeColorFilter blendModeColorFilter, int i) {
        int i2 = (int) (j >> 32);
        int i3 = (int) (j & 4294967295L);
        this.drawParams.canvas.drawRect(Float.intBitsToFloat(i2), Float.intBitsToFloat(i3), Float.intBitsToFloat((int) (j2 >> 32)) + Float.intBitsToFloat(i2), Float.intBitsToFloat((int) (4294967295L & j2)) + Float.intBitsToFloat(i3), m459configurePaintswdJneE(brush, drawStyle, f, blendModeColorFilter, i, 1));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRect-n-J9OG0, reason: not valid java name */
    public final void mo468drawRectnJ9OG0(long j, long j2, long j3, float f, int i) {
        int i2 = (int) (j2 >> 32);
        int i3 = (int) (j2 & 4294967295L);
        this.drawParams.canvas.drawRect(Float.intBitsToFloat(i2), Float.intBitsToFloat(i3), Float.intBitsToFloat((int) (j3 >> 32)) + Float.intBitsToFloat(i2), Float.intBitsToFloat((int) (4294967295L & j3)) + Float.intBitsToFloat(i3), m458configurePaint2qPWKa0$default(this, j, Fill.INSTANCE, f, i));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRoundRect-ZuiqVtQ, reason: not valid java name */
    public final void mo469drawRoundRectZuiqVtQ(Brush brush, long j, long j2, long j3, float f, DrawStyle drawStyle, BlendModeColorFilter blendModeColorFilter, int i) {
        int i2 = (int) (j >> 32);
        int i3 = (int) (j & 4294967295L);
        this.drawParams.canvas.drawRoundRect(Float.intBitsToFloat(i2), Float.intBitsToFloat(i3), Float.intBitsToFloat((int) (j2 >> 32)) + Float.intBitsToFloat(i2), Float.intBitsToFloat((int) (j2 & 4294967295L)) + Float.intBitsToFloat(i3), Float.intBitsToFloat((int) (j3 >> 32)), Float.intBitsToFloat((int) (j3 & 4294967295L)), m459configurePaintswdJneE(brush, drawStyle, f, blendModeColorFilter, i, 1));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRoundRect-u-Aw5IA, reason: not valid java name */
    public final void mo470drawRoundRectuAw5IA(long j, long j2, long j3, long j4, DrawStyle drawStyle) {
        int i = (int) (j2 >> 32);
        int i2 = (int) (j2 & 4294967295L);
        this.drawParams.canvas.drawRoundRect(Float.intBitsToFloat(i), Float.intBitsToFloat(i2), Float.intBitsToFloat((int) (j3 >> 32)) + Float.intBitsToFloat(i), Float.intBitsToFloat((int) (j3 & 4294967295L)) + Float.intBitsToFloat(i2), Float.intBitsToFloat((int) (j4 >> 32)), Float.intBitsToFloat((int) (j4 & 4294967295L)), m458configurePaint2qPWKa0$default(this, j, drawStyle, 1.0f, 3));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: getCenter-F1C5BW0, reason: not valid java name */
    public final long mo471getCenterF1C5BW0() {
        return SizeKt.m389getCenteruvyYCjk(this.drawContext.m795getSizeNHjbRc());
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getDensity() {
        return this.drawParams.density.getDensity();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public final SVG getDrawContext() {
        return this.drawContext;
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getFontScale() {
        return this.drawParams.density.getFontScale();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public final LayoutDirection getLayoutDirection() {
        return this.drawParams.layoutDirection;
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
    public final long mo472getSizeNHjbRc() {
        return this.drawContext.m795getSizeNHjbRc();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: record-JVtK1S4, reason: not valid java name */
    public final void mo473recordJVtK1S4(GraphicsLayer graphicsLayer, long j, Function1 function1) {
        graphicsLayer.m474recordmLhObY(this, this.drawParams.layoutDirection, j, new NavController$handleDeepLink$2(4, this, function1));
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    public final /* synthetic */ int mo83roundToPx0680j_4(float f) {
        return Density.CC.m693$default$roundToPx0680j_4(this, f);
    }

    public final AndroidPaint selectPaint(DrawStyle drawStyle) {
        if (Intrinsics.areEqual(drawStyle, Fill.INSTANCE)) {
            AndroidPaint androidPaint = this.fillPaint;
            if (androidPaint != null) {
                return androidPaint;
            }
            AndroidPaint androidPaintPaint = BrushKt.Paint();
            androidPaintPaint.m406setStylek9PVt8s(0);
            this.fillPaint = androidPaintPaint;
            return androidPaintPaint;
        }
        if (!(drawStyle instanceof Stroke)) {
            throw new HttpException();
        }
        AndroidPaint androidPaintPaint2 = this.strokePaint;
        if (androidPaintPaint2 == null) {
            androidPaintPaint2 = BrushKt.Paint();
            androidPaintPaint2.m406setStylek9PVt8s(1);
            this.strokePaint = androidPaintPaint2;
        }
        Paint paint = androidPaintPaint2.internalPaint;
        float strokeWidth = paint.getStrokeWidth();
        Stroke stroke = (Stroke) drawStyle;
        float f = stroke.width;
        if (strokeWidth != f) {
            androidPaintPaint2.setStrokeWidth(f);
        }
        int iM399getStrokeCapKaPHkGw = androidPaintPaint2.m399getStrokeCapKaPHkGw();
        int i = stroke.cap;
        if (iM399getStrokeCapKaPHkGw != i) {
            androidPaintPaint2.m404setStrokeCapBeK7IIE(i);
        }
        float strokeMiter = paint.getStrokeMiter();
        float f2 = stroke.miter;
        if (strokeMiter != f2) {
            paint.setStrokeMiter(f2);
        }
        int iM400getStrokeJoinLxFBmk8 = androidPaintPaint2.m400getStrokeJoinLxFBmk8();
        int i2 = stroke.join;
        if (iM400getStrokeJoinLxFBmk8 == i2) {
            return androidPaintPaint2;
        }
        androidPaintPaint2.m405setStrokeJoinWw9F2mQ(i2);
        return androidPaintPaint2;
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-GaN1DYA */
    public final /* synthetic */ float mo84toDpGaN1DYA(long j) {
        return Density.CC.m694$default$toDpGaN1DYA(j, this);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public final float mo86toDpu2uoSUM(int i) {
        return i / getDensity();
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    public final /* synthetic */ long mo87toDpSizekrfVVM(long j) {
        return Density.CC.m695$default$toDpSizekrfVVM(j, this);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx--R2X_6o */
    public final /* synthetic */ float mo88toPxR2X_6o(long j) {
        return Density.CC.m696$default$toPxR2X_6o(j, this);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx-0680j_4 */
    public final float mo89toPx0680j_4(float f) {
        return getDensity() * f;
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    public final /* synthetic */ long mo90toSizeXkaWNTQ(long j) {
        return Density.CC.m697$default$toSizeXkaWNTQ(j, this);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public final long mo91toSpkPz2Gy4(float f) {
        return Density.CC.m698$default$toSp0xMU5do(this, mo85toDpu2uoSUM(f));
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public final float mo85toDpu2uoSUM(float f) {
        return f / getDensity();
    }
}
