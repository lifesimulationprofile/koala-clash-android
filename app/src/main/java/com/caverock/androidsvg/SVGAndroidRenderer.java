package com.caverock.androidsvg;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.Base64;
import android.util.Log;
import androidx.appcompat.widget.TooltipPopup;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.camera2.internal.SynchronizedCaptureSessionImpl;
import coil.network.RealNetworkObserver;
import com.github.kr328.clash.log.LogcatCache;
import com.google.android.datatransport.runtime.backends.MetadataBackendRegistry;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.gms.internal.mlkit_vision_common.zzik;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.Executor;
import javax.inject.Provider;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class SVGAndroidRenderer implements Factory {
    public static HashSet supportedFeatures;
    public Object canvas;
    public Object document;
    public Object matrixStack;
    public Object parentStack;
    public Object state;
    public Object stateStack;

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class MarkerPositionCalculator implements SVG.PathInterface {
        public boolean closepathReAdjustPending;
        public MarkerVector lastPos;
        public final ArrayList markers;
        public boolean normalCubic;
        public boolean startArc;
        public float startX;
        public float startY;
        public int subpathStartIndex;

        public MarkerPositionCalculator(SVGAndroidRenderer sVGAndroidRenderer, LogcatCache logcatCache) {
            ArrayList arrayList = new ArrayList();
            this.markers = arrayList;
            this.lastPos = null;
            this.startArc = false;
            this.normalCubic = true;
            this.subpathStartIndex = -1;
            if (logcatCache == null) {
                return;
            }
            logcatCache.enumeratePath(this);
            if (this.closepathReAdjustPending) {
                this.lastPos.add((MarkerVector) arrayList.get(this.subpathStartIndex));
                arrayList.set(this.subpathStartIndex, this.lastPos);
                this.closepathReAdjustPending = false;
            }
            MarkerVector markerVector = this.lastPos;
            if (markerVector != null) {
                arrayList.add(markerVector);
            }
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public final void arcTo(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            this.startArc = true;
            this.normalCubic = false;
            MarkerVector markerVector = this.lastPos;
            SVGAndroidRenderer.access$700(markerVector.x, markerVector.y, f, f2, f3, z, z2, f4, f5, this);
            this.normalCubic = true;
            this.closepathReAdjustPending = false;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public final void close() {
            this.markers.add(this.lastPos);
            lineTo(this.startX, this.startY);
            this.closepathReAdjustPending = true;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public final void cubicTo(float f, float f2, float f3, float f4, float f5, float f6) {
            if (this.normalCubic || this.startArc) {
                this.lastPos.add(f, f2);
                this.markers.add(this.lastPos);
                this.startArc = false;
            }
            this.lastPos = new MarkerVector(f5, f6, f5 - f3, f6 - f4);
            this.closepathReAdjustPending = false;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public final void lineTo(float f, float f2) {
            this.lastPos.add(f, f2);
            this.markers.add(this.lastPos);
            MarkerVector markerVector = this.lastPos;
            this.lastPos = new MarkerVector(f, f2, f - markerVector.x, f2 - markerVector.y);
            this.closepathReAdjustPending = false;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public final void moveTo(float f, float f2) {
            boolean z = this.closepathReAdjustPending;
            ArrayList arrayList = this.markers;
            if (z) {
                this.lastPos.add((MarkerVector) arrayList.get(this.subpathStartIndex));
                arrayList.set(this.subpathStartIndex, this.lastPos);
                this.closepathReAdjustPending = false;
            }
            MarkerVector markerVector = this.lastPos;
            if (markerVector != null) {
                arrayList.add(markerVector);
            }
            this.startX = f;
            this.startY = f2;
            this.lastPos = new MarkerVector(f, f2, 0.0f, 0.0f);
            this.subpathStartIndex = arrayList.size();
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public final void quadTo(float f, float f2, float f3, float f4) {
            this.lastPos.add(f, f2);
            this.markers.add(this.lastPos);
            this.lastPos = new MarkerVector(f3, f4, f3 - f, f4 - f2);
            this.closepathReAdjustPending = false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class PathConverter implements SVG.PathInterface {
        public float lastX;
        public float lastY;
        public final Path path = new Path();

        public PathConverter(LogcatCache logcatCache) {
            if (logcatCache == null) {
                return;
            }
            logcatCache.enumeratePath(this);
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public final void arcTo(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            SVGAndroidRenderer.access$700(this.lastX, this.lastY, f, f2, f3, z, z2, f4, f5, this);
            this.lastX = f4;
            this.lastY = f5;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public final void close() {
            this.path.close();
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public final void cubicTo(float f, float f2, float f3, float f4, float f5, float f6) {
            this.path.cubicTo(f, f2, f3, f4, f5, f6);
            this.lastX = f5;
            this.lastY = f6;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public final void lineTo(float f, float f2) {
            this.path.lineTo(f, f2);
            this.lastX = f;
            this.lastY = f2;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public final void moveTo(float f, float f2) {
            this.path.moveTo(f, f2);
            this.lastX = f;
            this.lastY = f2;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public final void quadTo(float f, float f2, float f3, float f4) {
            this.path.quadTo(f, f2, f3, f4);
            this.lastX = f3;
            this.lastY = f4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class PathTextDrawer extends PlainTextDrawer {
        public final Path path;

        public PathTextDrawer(Path path, float f) {
            super(f, 0.0f);
            this.path = path;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.PlainTextDrawer, com.google.android.gms.internal.mlkit_vision_common.zzik
        public final void processText(String str) {
            SVGAndroidRenderer sVGAndroidRenderer = SVGAndroidRenderer.this;
            if (sVGAndroidRenderer.visible()) {
                RendererState rendererState = (RendererState) sVGAndroidRenderer.state;
                if (rendererState.hasFill) {
                    ((Canvas) sVGAndroidRenderer.canvas).drawTextOnPath(str, this.path, this.x, this.y, rendererState.fillPaint);
                }
                RendererState rendererState2 = (RendererState) sVGAndroidRenderer.state;
                if (rendererState2.hasStroke) {
                    ((Canvas) sVGAndroidRenderer.canvas).drawTextOnPath(str, this.path, this.x, this.y, rendererState2.strokePaint);
                }
            }
            this.x = ((RendererState) sVGAndroidRenderer.state).fillPaint.measureText(str) + this.x;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public class PlainTextDrawer extends zzik {
        public float x;
        public float y;

        public PlainTextDrawer(float f, float f2) {
            this.x = f;
            this.y = f2;
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzik
        public void processText(String str) {
            SVGAndroidRenderer sVGAndroidRenderer = SVGAndroidRenderer.this;
            if (sVGAndroidRenderer.visible()) {
                RendererState rendererState = (RendererState) sVGAndroidRenderer.state;
                if (rendererState.hasFill) {
                    ((Canvas) sVGAndroidRenderer.canvas).drawText(str, this.x, this.y, rendererState.fillPaint);
                }
                RendererState rendererState2 = (RendererState) sVGAndroidRenderer.state;
                if (rendererState2.hasStroke) {
                    ((Canvas) sVGAndroidRenderer.canvas).drawText(str, this.x, this.y, rendererState2.strokePaint);
                }
            }
            this.x = ((RendererState) sVGAndroidRenderer.state).fillPaint.measureText(str) + this.x;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class TextWidthCalculator extends zzik {
        public float x = 0.0f;

        public TextWidthCalculator() {
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzik
        public final void processText(String str) {
            this.x = ((RendererState) SVGAndroidRenderer.this.state).fillPaint.measureText(str) + this.x;
        }
    }

    public static void access$700(float f, float f2, float f3, float f4, float f5, boolean z, boolean z2, float f6, float f7, SVG.PathInterface pathInterface) {
        if (f == f6 && f2 == f7) {
            return;
        }
        if (f3 == 0.0f || f4 == 0.0f) {
            pathInterface.lineTo(f6, f7);
            return;
        }
        float fAbs = Math.abs(f3);
        float fAbs2 = Math.abs(f4);
        double radians = Math.toRadians(((double) f5) % 360.0d);
        double dCos = Math.cos(radians);
        double dSin = Math.sin(radians);
        double d = ((double) (f - f6)) / 2.0d;
        double d2 = ((double) (f2 - f7)) / 2.0d;
        double d3 = (dSin * d2) + (dCos * d);
        double d4 = (dCos * d2) + ((-dSin) * d);
        double d5 = fAbs * fAbs;
        double d6 = fAbs2 * fAbs2;
        double d7 = d3 * d3;
        double d8 = d4 * d4;
        double d9 = (d8 / d6) + (d7 / d5);
        if (d9 > 0.99999d) {
            double dSqrt = Math.sqrt(d9) * 1.00001d;
            fAbs = (float) (((double) fAbs) * dSqrt);
            fAbs2 = (float) (dSqrt * ((double) fAbs2));
            d5 = fAbs * fAbs;
            d6 = fAbs2 * fAbs2;
        }
        double d10 = z == z2 ? -1.0d : 1.0d;
        double d11 = d5 * d6;
        double d12 = d5 * d8;
        double d13 = d6 * d7;
        double d14 = ((d11 - d12) - d13) / (d12 + d13);
        if (d14 < 0.0d) {
            d14 = 0.0d;
        }
        double dSqrt2 = Math.sqrt(d14) * d10;
        double d15 = fAbs;
        double d16 = fAbs2;
        double d17 = ((d15 * d4) / d16) * dSqrt2;
        double d18 = dSqrt2 * (-((d16 * d3) / d15));
        double d19 = ((dCos * d17) - (dSin * d18)) + (((double) (f + f6)) / 2.0d);
        double d20 = (dCos * d18) + (dSin * d17) + (((double) (f2 + f7)) / 2.0d);
        double d21 = (d3 - d17) / d15;
        double d22 = (d4 - d18) / d16;
        double d23 = ((-d3) - d17) / d15;
        double d24 = ((-d4) - d18) / d16;
        double d25 = (d22 * d22) + (d21 * d21);
        double dAcos = Math.acos(d21 / Math.sqrt(d25)) * (d22 < 0.0d ? -1.0d : 1.0d);
        double dSqrt3 = Math.sqrt(((d24 * d24) + (d23 * d23)) * d25);
        double d26 = (d22 * d24) + (d21 * d23);
        double d27 = d26 / dSqrt3;
        double dAcos2 = ((d21 * d24) - (d22 * d23) < 0.0d ? -1.0d : 1.0d) * (d27 < -1.0d ? 3.141592653589793d : d27 > 1.0d ? 0.0d : Math.acos(d27));
        if (!z2 && dAcos2 > 0.0d) {
            dAcos2 -= 6.283185307179586d;
        } else if (z2 && dAcos2 < 0.0d) {
            dAcos2 += 6.283185307179586d;
        }
        double d28 = dAcos2 % 6.283185307179586d;
        double d29 = dAcos % 6.283185307179586d;
        int iCeil = (int) Math.ceil((Math.abs(d28) * 2.0d) / 3.141592653589793d);
        double d30 = d28 / ((double) iCeil);
        double d31 = d30 / 2.0d;
        double dSin2 = (Math.sin(d31) * 1.3333333333333333d) / (Math.cos(d31) + 1.0d);
        int i = iCeil * 6;
        float[] fArr = new float[i];
        int i2 = 0;
        int i3 = 0;
        while (i2 < iCeil) {
            double d32 = d29;
            double d33 = (((double) i2) * d30) + d32;
            double dCos2 = Math.cos(d33);
            double dSin3 = Math.sin(d33);
            int i4 = i2;
            int i5 = i3;
            fArr[i5] = (float) (dCos2 - (dSin2 * dSin3));
            fArr[i3 + 1] = (float) ((dCos2 * dSin2) + dSin3);
            double d34 = d33 + d30;
            double dCos3 = Math.cos(d34);
            double dSin4 = Math.sin(d34);
            fArr[i5 + 2] = (float) ((dSin2 * dSin4) + dCos3);
            fArr[i5 + 3] = (float) (dSin4 - (dSin2 * dCos3));
            fArr[i5 + 4] = (float) dCos3;
            i3 = i5 + 6;
            fArr[i5 + 5] = (float) dSin4;
            i2 = i4 + 1;
            d29 = d32;
            iCeil = iCeil;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(fAbs, fAbs2);
        matrix.postRotate(f5);
        matrix.postTranslate((float) d19, (float) d20);
        matrix.mapPoints(fArr);
        fArr[i - 2] = f6;
        fArr[i - 1] = f7;
        for (int i6 = 0; i6 < i; i6 += 6) {
            pathInterface.cubicTo(fArr[i6], fArr[i6 + 1], fArr[i6 + 2], fArr[i6 + 3], fArr[i6 + 4], fArr[i6 + 5]);
        }
    }

    public static SVG.Box calculatePathBounds(Path path) {
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        return new SVG.Box(rectF.left, rectF.top, rectF.width(), rectF.height());
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
    
        if (r7 != 9) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Matrix calculateViewBoxTransform(com.caverock.androidsvg.SVG.Box r9, com.caverock.androidsvg.SVG.Box r10, com.caverock.androidsvg.PreserveAspectRatio r11) {
        /*
            android.graphics.Matrix r0 = new android.graphics.Matrix
            r0.<init>()
            if (r11 == 0) goto L8a
            com.caverock.androidsvg.PreserveAspectRatio$Alignment r1 = r11.alignment
            if (r1 != 0) goto Ld
            goto L8a
        Ld:
            float r2 = r9.width
            float r3 = r10.width
            float r2 = r2 / r3
            float r3 = r9.height
            float r4 = r10.height
            float r3 = r3 / r4
            float r4 = r10.minX
            float r4 = -r4
            float r5 = r10.minY
            float r5 = -r5
            com.caverock.androidsvg.PreserveAspectRatio r6 = com.caverock.androidsvg.PreserveAspectRatio.STRETCH
            boolean r6 = r11.equals(r6)
            if (r6 == 0) goto L33
            float r10 = r9.minX
            float r9 = r9.minY
            r0.preTranslate(r10, r9)
            r0.preScale(r2, r3)
            r0.preTranslate(r4, r5)
            return r0
        L33:
            int r11 = r11.scale
            r6 = 2
            if (r11 != r6) goto L3d
            float r11 = java.lang.Math.max(r2, r3)
            goto L41
        L3d:
            float r11 = java.lang.Math.min(r2, r3)
        L41:
            float r2 = r9.width
            float r2 = r2 / r11
            float r3 = r9.height
            float r3 = r3 / r11
            int r7 = r1.ordinal()
            r8 = 1073741824(0x40000000, float:2.0)
            if (r7 == r6) goto L66
            r6 = 3
            if (r7 == r6) goto L61
            r6 = 5
            if (r7 == r6) goto L66
            r6 = 6
            if (r7 == r6) goto L61
            r6 = 8
            if (r7 == r6) goto L66
            r6 = 9
            if (r7 == r6) goto L61
            goto L6b
        L61:
            float r6 = r10.width
            float r6 = r6 - r2
        L64:
            float r4 = r4 - r6
            goto L6b
        L66:
            float r6 = r10.width
            float r6 = r6 - r2
            float r6 = r6 / r8
            goto L64
        L6b:
            int r1 = r1.ordinal()
            switch(r1) {
                case 4: goto L78;
                case 5: goto L78;
                case 6: goto L78;
                case 7: goto L73;
                case 8: goto L73;
                case 9: goto L73;
                default: goto L72;
            }
        L72:
            goto L7d
        L73:
            float r10 = r10.height
            float r10 = r10 - r3
        L76:
            float r5 = r5 - r10
            goto L7d
        L78:
            float r10 = r10.height
            float r10 = r10 - r3
            float r10 = r10 / r8
            goto L76
        L7d:
            float r10 = r9.minX
            float r9 = r9.minY
            r0.preTranslate(r10, r9)
            r0.preScale(r11, r11)
            r0.preTranslate(r4, r5)
        L8a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVGAndroidRenderer.calculateViewBoxTransform(com.caverock.androidsvg.SVG$Box, com.caverock.androidsvg.SVG$Box, com.caverock.androidsvg.PreserveAspectRatio):android.graphics.Matrix");
    }

    public static Typeface checkGenericFont(String str, Integer num, int i) {
        int i2;
        boolean z = i == 2;
        if (num.intValue() > 500) {
            i2 = z ? 3 : 1;
        } else {
            i2 = z ? 2 : 0;
        }
        str.getClass();
        switch (str) {
            case "sans-serif":
                return Typeface.create(Typeface.SANS_SERIF, i2);
            case "monospace":
                return Typeface.create(Typeface.MONOSPACE, i2);
            case "fantasy":
                return Typeface.create(Typeface.SANS_SERIF, i2);
            case "serif":
                return Typeface.create(Typeface.SERIF, i2);
            case "cursive":
                return Typeface.create(Typeface.SANS_SERIF, i2);
            default:
                return null;
        }
    }

    public static int colourWithOpacity(int i, float f) {
        int i2 = 255;
        int iRound = Math.round(((i >> 24) & 255) * f);
        if (iRound < 0) {
            i2 = 0;
        } else if (iRound <= 255) {
            i2 = iRound;
        }
        return (i & 16777215) | (i2 << 24);
    }

    public static void error(String str, Object... objArr) {
        Log.e("SVGAndroidRenderer", String.format(str, objArr));
    }

    public static void fillInChainedGradientFields(SVG.GradientElement gradientElement, String str) {
        SVG.SvgElementBase svgElementBaseResolveIRI = gradientElement.document.resolveIRI(str);
        if (svgElementBaseResolveIRI == null) {
            Log.w("SVGAndroidRenderer", "Gradient reference '" + str + "' not found");
            return;
        }
        if (!(svgElementBaseResolveIRI instanceof SVG.GradientElement)) {
            error("Gradient href attributes must point to other gradient elements", new Object[0]);
            return;
        }
        if (svgElementBaseResolveIRI == gradientElement) {
            error("Circular reference in gradient href attribute '%s'", str);
            return;
        }
        SVG.GradientElement gradientElement2 = (SVG.GradientElement) svgElementBaseResolveIRI;
        if (gradientElement.gradientUnitsAreUser == null) {
            gradientElement.gradientUnitsAreUser = gradientElement2.gradientUnitsAreUser;
        }
        if (gradientElement.gradientTransform == null) {
            gradientElement.gradientTransform = gradientElement2.gradientTransform;
        }
        if (gradientElement.spreadMethod == 0) {
            gradientElement.spreadMethod = gradientElement2.spreadMethod;
        }
        if (gradientElement.children.isEmpty()) {
            gradientElement.children = gradientElement2.children;
        }
        try {
            if (gradientElement instanceof SVG.SvgLinearGradient) {
                SVG.SvgLinearGradient svgLinearGradient = (SVG.SvgLinearGradient) gradientElement;
                SVG.SvgLinearGradient svgLinearGradient2 = (SVG.SvgLinearGradient) svgElementBaseResolveIRI;
                if (svgLinearGradient.x1 == null) {
                    svgLinearGradient.x1 = svgLinearGradient2.x1;
                }
                if (svgLinearGradient.y1 == null) {
                    svgLinearGradient.y1 = svgLinearGradient2.y1;
                }
                if (svgLinearGradient.x2 == null) {
                    svgLinearGradient.x2 = svgLinearGradient2.x2;
                }
                if (svgLinearGradient.y2 == null) {
                    svgLinearGradient.y2 = svgLinearGradient2.y2;
                }
            } else {
                fillInChainedGradientFields((SVG.SvgRadialGradient) gradientElement, (SVG.SvgRadialGradient) svgElementBaseResolveIRI);
            }
        } catch (ClassCastException unused) {
        }
        String str2 = gradientElement2.href;
        if (str2 != null) {
            fillInChainedGradientFields(gradientElement, str2);
        }
    }

    public static void fillInChainedPatternFields(SVG.Pattern pattern, String str) {
        SVG.SvgElementBase svgElementBaseResolveIRI = pattern.document.resolveIRI(str);
        if (svgElementBaseResolveIRI == null) {
            Log.w("SVGAndroidRenderer", "Pattern reference '" + str + "' not found");
            return;
        }
        if (!(svgElementBaseResolveIRI instanceof SVG.Pattern)) {
            error("Pattern href attributes must point to other pattern elements", new Object[0]);
            return;
        }
        if (svgElementBaseResolveIRI == pattern) {
            error("Circular reference in pattern href attribute '%s'", str);
            return;
        }
        SVG.Pattern pattern2 = (SVG.Pattern) svgElementBaseResolveIRI;
        if (pattern.patternUnitsAreUser == null) {
            pattern.patternUnitsAreUser = pattern2.patternUnitsAreUser;
        }
        if (pattern.patternContentUnitsAreUser == null) {
            pattern.patternContentUnitsAreUser = pattern2.patternContentUnitsAreUser;
        }
        if (pattern.patternTransform == null) {
            pattern.patternTransform = pattern2.patternTransform;
        }
        if (pattern.x == null) {
            pattern.x = pattern2.x;
        }
        if (pattern.y == null) {
            pattern.y = pattern2.y;
        }
        if (pattern.width == null) {
            pattern.width = pattern2.width;
        }
        if (pattern.height == null) {
            pattern.height = pattern2.height;
        }
        if (pattern.children.isEmpty()) {
            pattern.children = pattern2.children;
        }
        if (pattern.viewBox == null) {
            pattern.viewBox = pattern2.viewBox;
        }
        if (pattern.preserveAspectRatio == null) {
            pattern.preserveAspectRatio = pattern2.preserveAspectRatio;
        }
        String str2 = pattern2.href;
        if (str2 != null) {
            fillInChainedPatternFields(pattern, str2);
        }
    }

    public static boolean isSpecified(SVG.Style style, long j) {
        return (j & style.specifiedFlags) != 0;
    }

    public static void setPaintColour(RendererState rendererState, boolean z, SVG.SvgPaint svgPaint) {
        int i;
        SVG.Style style = rendererState.style;
        float fFloatValue = (z ? style.fillOpacity : style.strokeOpacity).floatValue();
        if (svgPaint instanceof SVG.Colour) {
            i = ((SVG.Colour) svgPaint).colour;
        } else if (!(svgPaint instanceof SVG.CurrentColor)) {
            return;
        } else {
            i = rendererState.style.color.colour;
        }
        int iColourWithOpacity = colourWithOpacity(i, fFloatValue);
        if (z) {
            rendererState.fillPaint.setColor(iColourWithOpacity);
        } else {
            rendererState.strokePaint.setColor(iColourWithOpacity);
        }
    }

    public Path calculateClipPath(SVG.SvgElement svgElement, SVG.Box box) {
        Path pathObjectToPath;
        SVG.SvgElementBase svgElementBaseResolveIRI = svgElement.document.resolveIRI(((RendererState) this.state).style.clipPath);
        if (svgElementBaseResolveIRI == null) {
            error("ClipPath reference '%s' not found", ((RendererState) this.state).style.clipPath);
            return null;
        }
        SVG.ClipPath clipPath = (SVG.ClipPath) svgElementBaseResolveIRI;
        ((Stack) this.stateStack).push((RendererState) this.state);
        this.state = findInheritFromAncestorState(clipPath);
        Boolean bool = clipPath.clipPathUnitsAreUser;
        boolean z = bool == null || bool.booleanValue();
        Matrix matrix = new Matrix();
        if (!z) {
            matrix.preTranslate(box.minX, box.minY);
            matrix.preScale(box.width, box.height);
        }
        Matrix matrix2 = clipPath.transform;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
        Path path = new Path();
        for (SVG.SvgObject svgObject : clipPath.children) {
            if ((svgObject instanceof SVG.SvgElement) && (pathObjectToPath = objectToPath((SVG.SvgElement) svgObject, true)) != null) {
                path.op(pathObjectToPath, Path.Op.UNION);
            }
        }
        if (((RendererState) this.state).style.clipPath != null) {
            if (clipPath.boundingBox == null) {
                clipPath.boundingBox = calculatePathBounds(path);
            }
            Path pathCalculateClipPath = calculateClipPath(clipPath, clipPath.boundingBox);
            if (pathCalculateClipPath != null) {
                path.op(pathCalculateClipPath, Path.Op.INTERSECT);
            }
        }
        path.transform(matrix);
        this.state = (RendererState) ((Stack) this.stateStack).pop();
        return path;
    }

    public float calculateTextWidth(SVG.TextContainer textContainer) {
        TextWidthCalculator textWidthCalculator = new TextWidthCalculator();
        enumerateTextSpans(textContainer, textWidthCalculator);
        return textWidthCalculator.x;
    }

    public void checkForClipPath(SVG.SvgElement svgElement, SVG.Box box) {
        Path pathCalculateClipPath;
        if (((RendererState) this.state).style.clipPath == null || (pathCalculateClipPath = calculateClipPath(svgElement, box)) == null) {
            return;
        }
        ((Canvas) this.canvas).clipPath(pathCalculateClipPath);
    }

    public void checkForGradientsAndPatterns(SVG.SvgElement svgElement) {
        SVG.SvgPaint svgPaint = ((RendererState) this.state).style.fill;
        if (svgPaint instanceof SVG.PaintReference) {
            decodePaintReference(true, svgElement.boundingBox, (SVG.PaintReference) svgPaint);
        }
        SVG.SvgPaint svgPaint2 = ((RendererState) this.state).style.stroke;
        if (svgPaint2 instanceof SVG.PaintReference) {
            decodePaintReference(false, svgElement.boundingBox, (SVG.PaintReference) svgPaint2);
        }
    }

    public void decodePaintReference(boolean z, SVG.Box box, SVG.PaintReference paintReference) {
        float fFloatValue;
        float f;
        float fFloatValue2;
        float f2;
        float f3;
        float fFloatValue3;
        float f4;
        float fFloatValue4;
        float f5;
        int i;
        SVG.SvgElementBase svgElementBaseResolveIRI = ((SVG) this.document).resolveIRI(paintReference.href);
        if (svgElementBaseResolveIRI == null) {
            error("%s reference '%s' not found", z ? "Fill" : "Stroke", paintReference.href);
            SVG.SvgPaint svgPaint = paintReference.fallback;
            if (svgPaint != null) {
                setPaintColour((RendererState) this.state, z, svgPaint);
                return;
            } else if (z) {
                ((RendererState) this.state).hasFill = false;
                return;
            } else {
                ((RendererState) this.state).hasStroke = false;
                return;
            }
        }
        boolean z2 = svgElementBaseResolveIRI instanceof SVG.SvgLinearGradient;
        SVG.Colour colour = SVG.Colour.BLACK;
        if (z2) {
            SVG.SvgLinearGradient svgLinearGradient = (SVG.SvgLinearGradient) svgElementBaseResolveIRI;
            String str = svgLinearGradient.href;
            if (str != null) {
                fillInChainedGradientFields(svgLinearGradient, str);
            }
            Boolean bool = svgLinearGradient.gradientUnitsAreUser;
            boolean z3 = bool != null && bool.booleanValue();
            RendererState rendererState = (RendererState) this.state;
            Paint paint = z ? rendererState.fillPaint : rendererState.strokePaint;
            if (z3) {
                RendererState rendererState2 = (RendererState) this.state;
                f2 = 256.0f;
                SVG.Box box2 = rendererState2.viewBox;
                if (box2 == null) {
                    box2 = rendererState2.viewPort;
                }
                SVG.Length length = svgLinearGradient.x1;
                float fFloatValueX = length != null ? length.floatValueX(this) : 0.0f;
                SVG.Length length2 = svgLinearGradient.y1;
                fFloatValue3 = length2 != null ? length2.floatValueY(this) : 0.0f;
                f3 = 0.0f;
                SVG.Length length3 = svgLinearGradient.x2;
                float fFloatValueX2 = length3 != null ? length3.floatValueX(this) : box2.width;
                SVG.Length length4 = svgLinearGradient.y2;
                f5 = fFloatValueX2;
                fFloatValue4 = length4 != null ? length4.floatValueY(this) : 0.0f;
                f4 = fFloatValueX;
            } else {
                f2 = 256.0f;
                f3 = 0.0f;
                SVG.Length length5 = svgLinearGradient.x1;
                float fFloatValue5 = length5 != null ? length5.floatValue(this, 1.0f) : 0.0f;
                SVG.Length length6 = svgLinearGradient.y1;
                fFloatValue3 = length6 != null ? length6.floatValue(this, 1.0f) : 0.0f;
                SVG.Length length7 = svgLinearGradient.x2;
                float fFloatValue6 = length7 != null ? length7.floatValue(this, 1.0f) : 1.0f;
                SVG.Length length8 = svgLinearGradient.y2;
                f4 = fFloatValue5;
                fFloatValue4 = length8 != null ? length8.floatValue(this, 1.0f) : 0.0f;
                f5 = fFloatValue6;
            }
            float f6 = fFloatValue3;
            statePush();
            this.state = findInheritFromAncestorState(svgLinearGradient);
            Matrix matrix = new Matrix();
            if (!z3) {
                matrix.preTranslate(box.minX, box.minY);
                matrix.preScale(box.width, box.height);
            }
            Matrix matrix2 = svgLinearGradient.gradientTransform;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            int size = svgLinearGradient.children.size();
            if (size == 0) {
                statePop();
                if (z) {
                    ((RendererState) this.state).hasFill = false;
                    return;
                } else {
                    ((RendererState) this.state).hasStroke = false;
                    return;
                }
            }
            int[] iArr = new int[size];
            float[] fArr = new float[size];
            Iterator it = svgLinearGradient.children.iterator();
            int i2 = 0;
            float f7 = -1.0f;
            while (it.hasNext()) {
                SVG.Stop stop = (SVG.Stop) ((SVG.SvgObject) it.next());
                Float f8 = stop.offset;
                float fFloatValue7 = f8 != null ? f8.floatValue() : f3;
                if (i2 == 0 || fFloatValue7 >= f7) {
                    fArr[i2] = fFloatValue7;
                    f7 = fFloatValue7;
                } else {
                    fArr[i2] = f7;
                }
                statePush();
                updateStyleForElement((RendererState) this.state, stop);
                SVG.Style style = ((RendererState) this.state).style;
                SVG.Colour colour2 = (SVG.Colour) style.stopColor;
                if (colour2 == null) {
                    colour2 = colour;
                }
                iArr[i2] = colourWithOpacity(colour2.colour, style.stopOpacity.floatValue());
                i2++;
                statePop();
            }
            if ((f4 == f5 && f6 == fFloatValue4) || size == 1) {
                statePop();
                paint.setColor(iArr[size - 1]);
                return;
            }
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            int i3 = svgLinearGradient.spreadMethod;
            if (i3 != 0) {
                if (i3 == 2) {
                    tileMode = Shader.TileMode.MIRROR;
                } else if (i3 == 3) {
                    tileMode = Shader.TileMode.REPEAT;
                }
            }
            Shader.TileMode tileMode2 = tileMode;
            statePop();
            LinearGradient linearGradient = new LinearGradient(f4, f6, f5, fFloatValue4, iArr, fArr, tileMode2);
            linearGradient.setLocalMatrix(matrix);
            paint.setShader(linearGradient);
            int iFloatValue = (int) (((RendererState) this.state).style.fillOpacity.floatValue() * f2);
            if (iFloatValue < 0) {
                i = 0;
            } else {
                i = iFloatValue > 255 ? 255 : iFloatValue;
            }
            paint.setAlpha(i);
            return;
        }
        if (!(svgElementBaseResolveIRI instanceof SVG.SvgRadialGradient)) {
            if (svgElementBaseResolveIRI instanceof SVG.SolidColor) {
                SVG.SolidColor solidColor = (SVG.SolidColor) svgElementBaseResolveIRI;
                if (z) {
                    if (isSpecified(solidColor.baseStyle, 2147483648L)) {
                        RendererState rendererState3 = (RendererState) this.state;
                        SVG.Style style2 = rendererState3.style;
                        SVG.SvgPaint svgPaint2 = solidColor.baseStyle.solidColor;
                        style2.fill = svgPaint2;
                        rendererState3.hasFill = svgPaint2 != null;
                    }
                    if (isSpecified(solidColor.baseStyle, 4294967296L)) {
                        ((RendererState) this.state).style.fillOpacity = solidColor.baseStyle.solidOpacity;
                    }
                    if (isSpecified(solidColor.baseStyle, 6442450944L)) {
                        RendererState rendererState4 = (RendererState) this.state;
                        setPaintColour(rendererState4, z, rendererState4.style.fill);
                        return;
                    }
                    return;
                }
                if (isSpecified(solidColor.baseStyle, 2147483648L)) {
                    RendererState rendererState5 = (RendererState) this.state;
                    SVG.Style style3 = rendererState5.style;
                    SVG.SvgPaint svgPaint3 = solidColor.baseStyle.solidColor;
                    style3.stroke = svgPaint3;
                    rendererState5.hasStroke = svgPaint3 != null;
                }
                if (isSpecified(solidColor.baseStyle, 4294967296L)) {
                    ((RendererState) this.state).style.strokeOpacity = solidColor.baseStyle.solidOpacity;
                }
                if (isSpecified(solidColor.baseStyle, 6442450944L)) {
                    RendererState rendererState6 = (RendererState) this.state;
                    setPaintColour(rendererState6, z, rendererState6.style.stroke);
                    return;
                }
                return;
            }
            return;
        }
        SVG.SvgRadialGradient svgRadialGradient = (SVG.SvgRadialGradient) svgElementBaseResolveIRI;
        String str2 = svgRadialGradient.href;
        if (str2 != null) {
            fillInChainedGradientFields(svgRadialGradient, str2);
        }
        Boolean bool2 = svgRadialGradient.gradientUnitsAreUser;
        boolean z4 = bool2 != null && bool2.booleanValue();
        RendererState rendererState7 = (RendererState) this.state;
        Paint paint2 = z ? rendererState7.fillPaint : rendererState7.strokePaint;
        if (z4) {
            SVG.Length length9 = new SVG.Length(9, 50.0f);
            SVG.Length length10 = svgRadialGradient.cx;
            float fFloatValueX3 = length10 != null ? length10.floatValueX(this) : length9.floatValueX(this);
            SVG.Length length11 = svgRadialGradient.cy;
            fFloatValue = length11 != null ? length11.floatValueY(this) : length9.floatValueY(this);
            SVG.Length length12 = svgRadialGradient.r;
            fFloatValue2 = length12 != null ? length12.floatValue(this) : length9.floatValue(this);
            f = fFloatValueX3;
        } else {
            SVG.Length length13 = svgRadialGradient.cx;
            float fFloatValue8 = length13 != null ? length13.floatValue(this, 1.0f) : 0.5f;
            SVG.Length length14 = svgRadialGradient.cy;
            fFloatValue = length14 != null ? length14.floatValue(this, 1.0f) : 0.5f;
            SVG.Length length15 = svgRadialGradient.r;
            f = fFloatValue8;
            fFloatValue2 = length15 != null ? length15.floatValue(this, 1.0f) : 0.5f;
        }
        float f9 = fFloatValue;
        statePush();
        this.state = findInheritFromAncestorState(svgRadialGradient);
        Matrix matrix3 = new Matrix();
        if (!z4) {
            matrix3.preTranslate(box.minX, box.minY);
            matrix3.preScale(box.width, box.height);
        }
        Matrix matrix4 = svgRadialGradient.gradientTransform;
        if (matrix4 != null) {
            matrix3.preConcat(matrix4);
        }
        int size2 = svgRadialGradient.children.size();
        if (size2 == 0) {
            statePop();
            if (z) {
                ((RendererState) this.state).hasFill = false;
                return;
            } else {
                ((RendererState) this.state).hasStroke = false;
                return;
            }
        }
        int[] iArr2 = new int[size2];
        float[] fArr2 = new float[size2];
        Iterator it2 = svgRadialGradient.children.iterator();
        int i4 = 0;
        float f10 = -1.0f;
        while (it2.hasNext()) {
            SVG.Stop stop2 = (SVG.Stop) ((SVG.SvgObject) it2.next());
            Float f11 = stop2.offset;
            float fFloatValue9 = f11 != null ? f11.floatValue() : 0.0f;
            if (i4 == 0 || fFloatValue9 >= f10) {
                fArr2[i4] = fFloatValue9;
                f10 = fFloatValue9;
            } else {
                fArr2[i4] = f10;
            }
            statePush();
            updateStyleForElement((RendererState) this.state, stop2);
            SVG.Style style4 = ((RendererState) this.state).style;
            SVG.Colour colour3 = (SVG.Colour) style4.stopColor;
            if (colour3 == null) {
                colour3 = colour;
            }
            iArr2[i4] = colourWithOpacity(colour3.colour, style4.stopOpacity.floatValue());
            i4++;
            statePop();
        }
        if (fFloatValue2 == 0.0f || size2 == 1) {
            statePop();
            paint2.setColor(iArr2[size2 - 1]);
            return;
        }
        Shader.TileMode tileMode3 = Shader.TileMode.CLAMP;
        int i5 = svgRadialGradient.spreadMethod;
        if (i5 != 0) {
            if (i5 == 2) {
                tileMode3 = Shader.TileMode.MIRROR;
            } else if (i5 == 3) {
                tileMode3 = Shader.TileMode.REPEAT;
            }
        }
        Shader.TileMode tileMode4 = tileMode3;
        statePop();
        RadialGradient radialGradient = new RadialGradient(f, f9, fFloatValue2, iArr2, fArr2, tileMode4);
        radialGradient.setLocalMatrix(matrix3);
        paint2.setShader(radialGradient);
        int iFloatValue2 = (int) (((RendererState) this.state).style.fillOpacity.floatValue() * 256.0f);
        if (iFloatValue2 < 0) {
            iFloatValue2 = 0;
        } else if (iFloatValue2 > 255) {
            iFloatValue2 = 255;
        }
        paint2.setAlpha(iFloatValue2);
    }

    public boolean display() {
        Boolean bool = ((RendererState) this.state).style.display;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:79:0x0177  */
    public void doFilledPath(SVG.SvgElement svgElement, Path path) {
        float fFloatValueX;
        float fFloatValueY;
        float fFloatValueY2;
        float fFloatValueX2;
        boolean z;
        boolean z2;
        Canvas canvas = (Canvas) this.canvas;
        SVG.SvgPaint svgPaint = ((RendererState) this.state).style.fill;
        if (svgPaint instanceof SVG.PaintReference) {
            SVG.SvgElementBase svgElementBaseResolveIRI = ((SVG) this.document).resolveIRI(((SVG.PaintReference) svgPaint).href);
            if (svgElementBaseResolveIRI instanceof SVG.Pattern) {
                SVG.Pattern pattern = (SVG.Pattern) svgElementBaseResolveIRI;
                Boolean bool = pattern.patternUnitsAreUser;
                boolean z3 = bool != null && bool.booleanValue();
                String str = pattern.href;
                if (str != null) {
                    fillInChainedPatternFields(pattern, str);
                }
                if (z3) {
                    SVG.Length length = pattern.x;
                    fFloatValueX = length != null ? length.floatValueX(this) : 0.0f;
                    SVG.Length length2 = pattern.y;
                    fFloatValueY2 = length2 != null ? length2.floatValueY(this) : 0.0f;
                    SVG.Length length3 = pattern.width;
                    fFloatValueX2 = length3 != null ? length3.floatValueX(this) : 0.0f;
                    SVG.Length length4 = pattern.height;
                    fFloatValueY = length4 != null ? length4.floatValueY(this) : 0.0f;
                } else {
                    SVG.Length length5 = pattern.x;
                    float fFloatValue = length5 != null ? length5.floatValue(this, 1.0f) : 0.0f;
                    SVG.Length length6 = pattern.y;
                    float fFloatValue2 = length6 != null ? length6.floatValue(this, 1.0f) : 0.0f;
                    SVG.Length length7 = pattern.width;
                    float fFloatValue3 = length7 != null ? length7.floatValue(this, 1.0f) : 0.0f;
                    SVG.Length length8 = pattern.height;
                    float fFloatValue4 = length8 != null ? length8.floatValue(this, 1.0f) : 0.0f;
                    SVG.Box box = svgElement.boundingBox;
                    float f = box.minX;
                    float f2 = box.width;
                    fFloatValueX = (fFloatValue * f2) + f;
                    float f3 = box.minY;
                    float f4 = box.height;
                    float f5 = fFloatValue3 * f2;
                    fFloatValueY = fFloatValue4 * f4;
                    fFloatValueY2 = (fFloatValue2 * f4) + f3;
                    fFloatValueX2 = f5;
                }
                if (fFloatValueX2 == 0.0f || fFloatValueY == 0.0f) {
                    return;
                }
                PreserveAspectRatio preserveAspectRatio = pattern.preserveAspectRatio;
                if (preserveAspectRatio == null) {
                    preserveAspectRatio = PreserveAspectRatio.LETTERBOX;
                }
                statePush();
                canvas.clipPath(path);
                RendererState rendererState = new RendererState();
                updateStyle(rendererState, SVG.Style.getDefaultStyle());
                rendererState.style.overflow = Boolean.FALSE;
                findInheritFromAncestorState(pattern, rendererState);
                this.state = rendererState;
                SVG.Box box2 = svgElement.boundingBox;
                Matrix matrix = pattern.patternTransform;
                if (matrix != null) {
                    canvas.concat(matrix);
                    Matrix matrix2 = new Matrix();
                    if (pattern.patternTransform.invert(matrix2)) {
                        SVG.Box box3 = svgElement.boundingBox;
                        float f6 = box3.minX;
                        float f7 = box3.minY;
                        float fMaxX = box3.maxX();
                        z = true;
                        SVG.Box box4 = svgElement.boundingBox;
                        z2 = false;
                        float f8 = box4.minY;
                        float fMaxX2 = box4.maxX();
                        float fMaxY = svgElement.boundingBox.maxY();
                        SVG.Box box5 = svgElement.boundingBox;
                        float[] fArr = {f6, f7, fMaxX, f8, fMaxX2, fMaxY, box5.minX, box5.maxY()};
                        matrix2.mapPoints(fArr);
                        float f9 = fArr[0];
                        float f10 = fArr[1];
                        RectF rectF = new RectF(f9, f10, f9, f10);
                        for (int i = 2; i <= 6; i += 2) {
                            float f11 = fArr[i];
                            if (f11 < rectF.left) {
                                rectF.left = f11;
                            }
                            if (f11 > rectF.right) {
                                rectF.right = f11;
                            }
                            float f12 = fArr[i + 1];
                            if (f12 < rectF.top) {
                                rectF.top = f12;
                            }
                            if (f12 > rectF.bottom) {
                                rectF.bottom = f12;
                            }
                        }
                        float f13 = rectF.left;
                        float f14 = rectF.top;
                        box2 = new SVG.Box(f13, f14, rectF.right - f13, rectF.bottom - f14);
                    } else {
                        z = true;
                        z2 = false;
                    }
                } else {
                    z = true;
                    z2 = false;
                }
                float fFloor = (((float) Math.floor((box2.minX - fFloatValueX) / fFloatValueX2)) * fFloatValueX2) + fFloatValueX;
                float fMaxX3 = box2.maxX();
                float fMaxY2 = box2.maxY();
                SVG.Box box6 = new SVG.Box(0.0f, 0.0f, fFloatValueX2, fFloatValueY);
                boolean zPushLayer = pushLayer();
                for (float fFloor2 = (((float) Math.floor((box2.minY - fFloatValueY2) / fFloatValueY)) * fFloatValueY) + fFloatValueY2; fFloor2 < fMaxY2; fFloor2 += fFloatValueY) {
                    float f15 = fFloor;
                    while (f15 < fMaxX3) {
                        box6.minX = f15;
                        box6.minY = fFloor2;
                        statePush();
                        if (!((RendererState) this.state).style.overflow.booleanValue()) {
                            setClipRect(box6.minX, box6.minY, box6.width, box6.height);
                        }
                        SVG.Box box7 = pattern.viewBox;
                        if (box7 != null) {
                            canvas.concat(calculateViewBoxTransform(box6, box7, preserveAspectRatio));
                        } else {
                            Boolean bool2 = pattern.patternContentUnitsAreUser;
                            boolean z4 = (bool2 == null || bool2.booleanValue()) ? z : z2;
                            canvas.translate(f15, fFloor2);
                            if (!z4) {
                                SVG.Box box8 = svgElement.boundingBox;
                                canvas.scale(box8.width, box8.height);
                            }
                        }
                        Iterator it = pattern.children.iterator();
                        while (it.hasNext()) {
                            render((SVG.SvgObject) it.next());
                        }
                        statePop();
                        f15 += fFloatValueX2;
                        fMaxY2 = fMaxY2;
                        fFloor = fFloor;
                    }
                }
                if (zPushLayer) {
                    popLayer(pattern.boundingBox);
                }
                statePop();
                return;
            }
        }
        canvas.drawPath(path, ((RendererState) this.state).fillPaint);
    }

    public void doStroke(Path path) {
        Canvas canvas = (Canvas) this.canvas;
        RendererState rendererState = (RendererState) this.state;
        if (rendererState.style.vectorEffect != 2) {
            canvas.drawPath(path, rendererState.strokePaint);
            return;
        }
        Matrix matrix = canvas.getMatrix();
        Path path2 = new Path();
        path.transform(matrix, path2);
        canvas.setMatrix(new Matrix());
        Shader shader = ((RendererState) this.state).strokePaint.getShader();
        Matrix matrix2 = new Matrix();
        if (shader != null) {
            shader.getLocalMatrix(matrix2);
            Matrix matrix3 = new Matrix(matrix2);
            matrix3.postConcat(matrix);
            shader.setLocalMatrix(matrix3);
        }
        canvas.drawPath(path2, ((RendererState) this.state).strokePaint);
        canvas.setMatrix(matrix);
        if (shader != null) {
            shader.setLocalMatrix(matrix2);
        }
    }

    public void enumerateTextSpans(SVG.TextContainer textContainer, zzik zzikVar) {
        float f;
        float fFloatValueY;
        float fFloatValueX;
        int anchorPosition;
        if (display()) {
            Iterator it = textContainer.children.iterator();
            boolean z = true;
            while (it.hasNext()) {
                SVG.SvgObject svgObject = (SVG.SvgObject) it.next();
                if (svgObject instanceof SVG.TextSequence) {
                    zzikVar.processText(textXMLSpaceTransform(((SVG.TextSequence) svgObject).text, z, !it.hasNext()));
                } else if (zzikVar.doTextContainer((SVG.TextContainer) svgObject)) {
                    float fFloatValueY2 = 0.0f;
                    if (svgObject instanceof SVG.TextPath) {
                        statePush();
                        SVG.TextPath textPath = (SVG.TextPath) svgObject;
                        updateStyleForElement((RendererState) this.state, textPath);
                        if (display() && visible()) {
                            SVG.SvgElementBase svgElementBaseResolveIRI = textPath.document.resolveIRI(textPath.href);
                            if (svgElementBaseResolveIRI == null) {
                                error("TextPath reference '%s' not found", textPath.href);
                            } else {
                                SVG.Path path = (SVG.Path) svgElementBaseResolveIRI;
                                PathConverter pathConverter = new PathConverter(path.d);
                                Matrix matrix = path.transform;
                                Path path2 = pathConverter.path;
                                if (matrix != null) {
                                    path2.transform(matrix);
                                }
                                PathMeasure pathMeasure = new PathMeasure(path2, false);
                                SVG.Length length = textPath.startOffset;
                                fFloatValueY2 = length != null ? length.floatValue(this, pathMeasure.getLength()) : 0.0f;
                                int anchorPosition2 = getAnchorPosition();
                                if (anchorPosition2 != 1) {
                                    float fCalculateTextWidth = calculateTextWidth(textPath);
                                    if (anchorPosition2 == 2) {
                                        fCalculateTextWidth /= 2.0f;
                                    }
                                    fFloatValueY2 -= fCalculateTextWidth;
                                }
                                checkForGradientsAndPatterns(textPath.textRoot);
                                boolean zPushLayer = pushLayer();
                                enumerateTextSpans(textPath, new PathTextDrawer(path2, fFloatValueY2));
                                if (zPushLayer) {
                                    popLayer(textPath.boundingBox);
                                }
                            }
                        }
                        statePop();
                    } else if (svgObject instanceof SVG.TSpan) {
                        statePush();
                        SVG.TSpan tSpan = (SVG.TSpan) svgObject;
                        updateStyleForElement((RendererState) this.state, tSpan);
                        if (display()) {
                            ArrayList arrayList = tSpan.x;
                            boolean z2 = arrayList != null && arrayList.size() > 0;
                            boolean z3 = zzikVar instanceof PlainTextDrawer;
                            if (z3) {
                                float fFloatValueX2 = !z2 ? ((PlainTextDrawer) zzikVar).x : ((SVG.Length) tSpan.x.get(0)).floatValueX(this);
                                ArrayList arrayList2 = tSpan.y;
                                fFloatValueY = (arrayList2 == null || arrayList2.size() == 0) ? ((PlainTextDrawer) zzikVar).y : ((SVG.Length) tSpan.y.get(0)).floatValueY(this);
                                ArrayList arrayList3 = tSpan.dx;
                                fFloatValueX = (arrayList3 == null || arrayList3.size() == 0) ? 0.0f : ((SVG.Length) tSpan.dx.get(0)).floatValueX(this);
                                ArrayList arrayList4 = tSpan.dy;
                                if (arrayList4 != null && arrayList4.size() != 0) {
                                    fFloatValueY2 = ((SVG.Length) tSpan.dy.get(0)).floatValueY(this);
                                }
                                float f2 = fFloatValueX2;
                                f = fFloatValueY2;
                                fFloatValueY2 = f2;
                            } else {
                                f = 0.0f;
                                fFloatValueY = 0.0f;
                                fFloatValueX = 0.0f;
                            }
                            if (z2 && (anchorPosition = getAnchorPosition()) != 1) {
                                float fCalculateTextWidth2 = calculateTextWidth(tSpan);
                                if (anchorPosition == 2) {
                                    fCalculateTextWidth2 /= 2.0f;
                                }
                                fFloatValueY2 -= fCalculateTextWidth2;
                            }
                            checkForGradientsAndPatterns(tSpan.textRoot);
                            if (z3) {
                                PlainTextDrawer plainTextDrawer = (PlainTextDrawer) zzikVar;
                                plainTextDrawer.x = fFloatValueY2 + fFloatValueX;
                                plainTextDrawer.y = fFloatValueY + f;
                            }
                            boolean zPushLayer2 = pushLayer();
                            enumerateTextSpans(tSpan, zzikVar);
                            if (zPushLayer2) {
                                popLayer(tSpan.boundingBox);
                            }
                        }
                        statePop();
                    } else if (svgObject instanceof SVG.TRef) {
                        statePush();
                        SVG.TRef tRef = (SVG.TRef) svgObject;
                        updateStyleForElement((RendererState) this.state, tRef);
                        if (display()) {
                            checkForGradientsAndPatterns(tRef.textRoot);
                            SVG.SvgElementBase svgElementBaseResolveIRI2 = svgObject.document.resolveIRI(tRef.href);
                            if (svgElementBaseResolveIRI2 == null || !(svgElementBaseResolveIRI2 instanceof SVG.TextContainer)) {
                                error("Tref reference '%s' not found", tRef.href);
                            } else {
                                StringBuilder sb = new StringBuilder();
                                extractRawText((SVG.TextContainer) svgElementBaseResolveIRI2, sb);
                                if (sb.length() > 0) {
                                    zzikVar.processText(sb.toString());
                                }
                            }
                        }
                        statePop();
                    }
                }
                z = false;
            }
        }
    }

    public void extractRawText(SVG.TextContainer textContainer, StringBuilder sb) {
        Iterator it = textContainer.children.iterator();
        boolean z = true;
        while (it.hasNext()) {
            SVG.SvgObject svgObject = (SVG.SvgObject) it.next();
            if (svgObject instanceof SVG.TextContainer) {
                extractRawText((SVG.TextContainer) svgObject, sb);
            } else if (svgObject instanceof SVG.TextSequence) {
                sb.append(textXMLSpaceTransform(((SVG.TextSequence) svgObject).text, z, !it.hasNext()));
            }
            z = false;
        }
    }

    public RendererState findInheritFromAncestorState(SVG.SvgElementBase svgElementBase) {
        RendererState rendererState = new RendererState();
        updateStyle(rendererState, SVG.Style.getDefaultStyle());
        findInheritFromAncestorState(svgElementBase, rendererState);
        return rendererState;
    }

    public void forceFinishCloseStaleSessions(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl) {
        ArrayList sessionsInOrder = getSessionsInOrder();
        int size = sessionsInOrder.size();
        int i = 0;
        while (i < size) {
            Object obj = sessionsInOrder.get(i);
            i++;
            SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl2 = (SynchronizedCaptureSessionImpl) obj;
            if (synchronizedCaptureSessionImpl2 == synchronizedCaptureSessionImpl) {
                return;
            }
            synchronizedCaptureSessionImpl2.releaseDeferrableSurfaces();
            synchronizedCaptureSessionImpl2.mRequestMonitor.stop();
        }
    }

    @Override // javax.inject.Provider
    public Object get() {
        return new TooltipPopup((Context) ((Provider) this.canvas).get(), (MetadataBackendRegistry) ((Provider) this.document).get(), (EventStore) ((Provider) this.state).get(), (SVG) ((RealNetworkObserver) this.stateStack).get(), (Executor) ((Provider) this.parentStack).get(), (SynchronizationGuard) ((Provider) this.matrixStack).get(), new okio.Path.Companion(16));
    }

    public int getAnchorPosition() {
        int i;
        SVG.Style style = ((RendererState) this.state).style;
        if (style.direction == 1 || (i = style.textAnchor) == 2) {
            return style.textAnchor;
        }
        return i == 1 ? 3 : 1;
    }

    public ArrayList getCaptureSessions() {
        ArrayList arrayList;
        synchronized (this.document) {
            arrayList = new ArrayList((LinkedHashSet) this.state);
        }
        return arrayList;
    }

    public Path.FillType getClipRuleFromState() {
        int i = ((RendererState) this.state).style.clipRule;
        return (i == 0 || i != 2) ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
    }

    public ArrayList getCreatingCaptureSessions() {
        ArrayList arrayList;
        synchronized (this.document) {
            arrayList = new ArrayList((LinkedHashSet) this.parentStack);
        }
        return arrayList;
    }

    public ArrayList getSessionsInOrder() {
        ArrayList arrayList;
        synchronized (this.document) {
            arrayList = new ArrayList();
            arrayList.addAll(getCaptureSessions());
            arrayList.addAll(getCreatingCaptureSessions());
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0048  */
    /* JADX WARN: Code duplicated, block: B:17:0x004e  */
    /* JADX WARN: Code duplicated, block: B:20:0x0053  */
    /* JADX WARN: Code duplicated, block: B:21:0x0059  */
    /* JADX WARN: Code duplicated, block: B:24:0x006a  */
    /* JADX WARN: Code duplicated, block: B:29:0x0081  */
    public Path makePathAndBoundingBox(SVG.Rect rect) {
        float fFloatValueX;
        float fFloatValueY;
        float fMin;
        SVG.Length length;
        float fFloatValueX2;
        SVG.Length length2;
        float fFloatValueY2;
        float fFloatValueX3;
        float fFloatValueY3;
        float f;
        float f2;
        Path path;
        SVG.Length length3 = rect.rx;
        if (length3 == null && rect.ry == null) {
            fFloatValueX = 0.0f;
        } else {
            if (length3 != null) {
                if (rect.ry == null) {
                    fFloatValueX = length3.floatValueX(this);
                } else {
                    fFloatValueX = length3.floatValueX(this);
                    fFloatValueY = rect.ry.floatValueY(this);
                }
                fMin = Math.min(fFloatValueX, rect.width.floatValueX(this) / 2.0f);
                float fMin2 = Math.min(fFloatValueY, rect.height.floatValueY(this) / 2.0f);
                length = rect.x;
                if (length != null) {
                    fFloatValueX2 = length.floatValueX(this);
                } else {
                    fFloatValueX2 = 0.0f;
                }
                length2 = rect.y;
                if (length2 != null) {
                    fFloatValueY2 = length2.floatValueY(this);
                } else {
                    fFloatValueY2 = 0.0f;
                }
                fFloatValueX3 = rect.width.floatValueX(this);
                fFloatValueY3 = rect.height.floatValueY(this);
                if (rect.boundingBox == null) {
                    rect.boundingBox = new SVG.Box(fFloatValueX2, fFloatValueY2, fFloatValueX3, fFloatValueY3);
                }
                f = fFloatValueX3 + fFloatValueX2;
                f2 = fFloatValueY2 + fFloatValueY3;
                path = new Path();
                if (fMin != 0.0f || fMin2 == 0.0f) {
                    path.moveTo(fFloatValueX2, fFloatValueY2);
                    path.lineTo(f, fFloatValueY2);
                    path.lineTo(f, f2);
                    path.lineTo(fFloatValueX2, f2);
                    path.lineTo(fFloatValueX2, fFloatValueY2);
                } else {
                    float f3 = fMin * 0.5522848f;
                    float f4 = 0.5522848f * fMin2;
                    float f5 = fFloatValueY2 + fMin2;
                    path.moveTo(fFloatValueX2, f5);
                    float f6 = f5 - f4;
                    float f7 = fFloatValueX2 + fMin;
                    float f8 = f7 - f3;
                    path.cubicTo(fFloatValueX2, f6, f8, fFloatValueY2, f7, fFloatValueY2);
                    float f9 = f - fMin;
                    path.lineTo(f9, fFloatValueY2);
                    float f10 = f9 + f3;
                    path.cubicTo(f10, fFloatValueY2, f, f6, f, f5);
                    float f11 = f2 - fMin2;
                    path.lineTo(f, f11);
                    float f12 = f11 + f4;
                    path.cubicTo(f, f12, f10, f2, f9, f2);
                    path.lineTo(f7, f2);
                    float f13 = fFloatValueX2;
                    path.cubicTo(f8, f2, f13, f12, fFloatValueX2, f11);
                    path.lineTo(f13, f5);
                }
                path.close();
                return path;
            }
            fFloatValueX = rect.ry.floatValueY(this);
        }
        fFloatValueY = fFloatValueX;
        fMin = Math.min(fFloatValueX, rect.width.floatValueX(this) / 2.0f);
        float fMin3 = Math.min(fFloatValueY, rect.height.floatValueY(this) / 2.0f);
        length = rect.x;
        if (length != null) {
            fFloatValueX2 = length.floatValueX(this);
        } else {
            fFloatValueX2 = 0.0f;
        }
        length2 = rect.y;
        if (length2 != null) {
            fFloatValueY2 = length2.floatValueY(this);
        } else {
            fFloatValueY2 = 0.0f;
        }
        fFloatValueX3 = rect.width.floatValueX(this);
        fFloatValueY3 = rect.height.floatValueY(this);
        if (rect.boundingBox == null) {
            rect.boundingBox = new SVG.Box(fFloatValueX2, fFloatValueY2, fFloatValueX3, fFloatValueY3);
        }
        f = fFloatValueX3 + fFloatValueX2;
        f2 = fFloatValueY2 + fFloatValueY3;
        path = new Path();
        if (fMin != 0.0f) {
            path.moveTo(fFloatValueX2, fFloatValueY2);
            path.lineTo(f, fFloatValueY2);
            path.lineTo(f, f2);
            path.lineTo(fFloatValueX2, f2);
            path.lineTo(fFloatValueX2, fFloatValueY2);
        } else {
            path.moveTo(fFloatValueX2, fFloatValueY2);
            path.lineTo(f, fFloatValueY2);
            path.lineTo(f, f2);
            path.lineTo(fFloatValueX2, f2);
            path.lineTo(fFloatValueX2, fFloatValueY2);
        }
        path.close();
        return path;
    }

    public SVG.Box makeViewPort(SVG.Length length, SVG.Length length2, SVG.Length length3, SVG.Length length4) {
        float fFloatValueX = length != null ? length.floatValueX(this) : 0.0f;
        float fFloatValueY = length2 != null ? length2.floatValueY(this) : 0.0f;
        RendererState rendererState = (RendererState) this.state;
        SVG.Box box = rendererState.viewBox;
        if (box == null) {
            box = rendererState.viewPort;
        }
        return new SVG.Box(fFloatValueX, fFloatValueY, length3 != null ? length3.floatValueX(this) : box.width, length4 != null ? length4.floatValueY(this) : box.height);
    }

    public Path objectToPath(SVG.SvgElement svgElement, boolean z) {
        Path pathMakePathAndBoundingBox;
        Path pathCalculateClipPath;
        ((Stack) this.stateStack).push((RendererState) this.state);
        RendererState rendererState = new RendererState((RendererState) this.state);
        this.state = rendererState;
        updateStyleForElement(rendererState, svgElement);
        if (!display() || !visible()) {
            this.state = (RendererState) ((Stack) this.stateStack).pop();
            return null;
        }
        if (svgElement instanceof SVG.Use) {
            if (!z) {
                error("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
            }
            SVG.Use use = (SVG.Use) svgElement;
            SVG.SvgElementBase svgElementBaseResolveIRI = svgElement.document.resolveIRI(use.href);
            if (svgElementBaseResolveIRI == null) {
                error("Use reference '%s' not found", use.href);
                this.state = (RendererState) ((Stack) this.stateStack).pop();
                return null;
            }
            if (!(svgElementBaseResolveIRI instanceof SVG.SvgElement)) {
                this.state = (RendererState) ((Stack) this.stateStack).pop();
                return null;
            }
            pathMakePathAndBoundingBox = objectToPath((SVG.SvgElement) svgElementBaseResolveIRI, false);
            if (pathMakePathAndBoundingBox != null) {
                if (use.boundingBox == null) {
                    use.boundingBox = calculatePathBounds(pathMakePathAndBoundingBox);
                }
                Matrix matrix = use.transform;
                if (matrix != null) {
                    pathMakePathAndBoundingBox.transform(matrix);
                }
                if (((RendererState) this.state).style.clipPath != null && (pathCalculateClipPath = calculateClipPath(svgElement, svgElement.boundingBox)) != null) {
                    pathMakePathAndBoundingBox.op(pathCalculateClipPath, Path.Op.INTERSECT);
                }
                this.state = (RendererState) ((Stack) this.stateStack).pop();
                return pathMakePathAndBoundingBox;
            }
            return null;
        }
        if (svgElement instanceof SVG.GraphicsElement) {
            SVG.GraphicsElement graphicsElement = (SVG.GraphicsElement) svgElement;
            if (svgElement instanceof SVG.Path) {
                PathConverter pathConverter = new PathConverter(((SVG.Path) svgElement).d);
                SVG.Box box = svgElement.boundingBox;
                Path path = pathConverter.path;
                if (box == null) {
                    svgElement.boundingBox = calculatePathBounds(path);
                }
                pathMakePathAndBoundingBox = path;
            } else if (svgElement instanceof SVG.Rect) {
                pathMakePathAndBoundingBox = makePathAndBoundingBox((SVG.Rect) svgElement);
            } else if (svgElement instanceof SVG.Circle) {
                pathMakePathAndBoundingBox = makePathAndBoundingBox((SVG.Circle) svgElement);
            } else if (svgElement instanceof SVG.Ellipse) {
                pathMakePathAndBoundingBox = makePathAndBoundingBox((SVG.Ellipse) svgElement);
            } else {
                pathMakePathAndBoundingBox = svgElement instanceof SVG.PolyLine ? makePathAndBoundingBox((SVG.PolyLine) svgElement) : null;
            }
            if (pathMakePathAndBoundingBox != null) {
                if (graphicsElement.boundingBox == null) {
                    graphicsElement.boundingBox = calculatePathBounds(pathMakePathAndBoundingBox);
                }
                Matrix matrix2 = graphicsElement.transform;
                if (matrix2 != null) {
                    pathMakePathAndBoundingBox.transform(matrix2);
                }
                pathMakePathAndBoundingBox.setFillType(getClipRuleFromState());
            }
            return null;
        }
        if (!(svgElement instanceof SVG.Text)) {
            error("Invalid %s element found in clipPath definition", svgElement.getNodeName());
            return null;
        }
        SVG.Text text = (SVG.Text) svgElement;
        ArrayList arrayList = text.x;
        float fFloatValueY = 0.0f;
        float fFloatValueX = (arrayList == null || arrayList.size() == 0) ? 0.0f : ((SVG.Length) text.x.get(0)).floatValueX(this);
        ArrayList arrayList2 = text.y;
        float fFloatValueY2 = (arrayList2 == null || arrayList2.size() == 0) ? 0.0f : ((SVG.Length) text.y.get(0)).floatValueY(this);
        ArrayList arrayList3 = text.dx;
        float fFloatValueX2 = (arrayList3 == null || arrayList3.size() == 0) ? 0.0f : ((SVG.Length) text.dx.get(0)).floatValueX(this);
        ArrayList arrayList4 = text.dy;
        if (arrayList4 != null && arrayList4.size() != 0) {
            fFloatValueY = ((SVG.Length) text.dy.get(0)).floatValueY(this);
        }
        if (((RendererState) this.state).style.textAnchor != 1) {
            float fCalculateTextWidth = calculateTextWidth(text);
            if (((RendererState) this.state).style.textAnchor == 2) {
                fCalculateTextWidth /= 2.0f;
            }
            fFloatValueX -= fCalculateTextWidth;
        }
        if (text.boundingBox == null) {
            PlainTextToPath plainTextToPath = new PlainTextToPath(this, fFloatValueX, fFloatValueY2);
            enumerateTextSpans(text, plainTextToPath);
            Object obj = plainTextToPath.textAsPath;
            RectF rectF = (RectF) obj;
            text.boundingBox = new SVG.Box(rectF.left, rectF.top, rectF.width(), ((RectF) obj).height());
        }
        Path path2 = new Path();
        enumerateTextSpans(text, new PlainTextToPath(this, fFloatValueX + fFloatValueX2, fFloatValueY2 + fFloatValueY, path2));
        Matrix matrix3 = text.transform;
        if (matrix3 != null) {
            path2.transform(matrix3);
        }
        path2.setFillType(getClipRuleFromState());
        pathMakePathAndBoundingBox = path2;
        if (((RendererState) this.state).style.clipPath != null) {
            pathMakePathAndBoundingBox.op(pathCalculateClipPath, Path.Op.INTERSECT);
        }
        this.state = (RendererState) ((Stack) this.stateStack).pop();
        return pathMakePathAndBoundingBox;
    }

    public void onCreateCaptureSession(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl) {
        synchronized (this.document) {
            ((LinkedHashSet) this.parentStack).add(synchronizedCaptureSessionImpl);
        }
    }

    public void popLayer(SVG.Box box) {
        Canvas canvas = (Canvas) this.canvas;
        if (((RendererState) this.state).style.mask != null) {
            Paint paint = new Paint();
            PorterDuff.Mode mode = PorterDuff.Mode.DST_IN;
            paint.setXfermode(new PorterDuffXfermode(mode));
            canvas.saveLayer(null, paint, 31);
            Paint paint2 = new Paint();
            paint2.setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.2127f, 0.7151f, 0.0722f, 0.0f, 0.0f})));
            canvas.saveLayer(null, paint2, 31);
            SVG.Mask mask = (SVG.Mask) ((SVG) this.document).resolveIRI(((RendererState) this.state).style.mask);
            renderMask(mask, box);
            canvas.restore();
            Paint paint3 = new Paint();
            paint3.setXfermode(new PorterDuffXfermode(mode));
            canvas.saveLayer(null, paint3, 31);
            renderMask(mask, box);
            canvas.restore();
            canvas.restore();
        }
        statePop();
    }

    public boolean pushLayer() {
        SVG.SvgElementBase svgElementBaseResolveIRI;
        if (((RendererState) this.state).style.opacity.floatValue() >= 1.0f && ((RendererState) this.state).style.mask == null) {
            return false;
        }
        Canvas canvas = (Canvas) this.canvas;
        int iFloatValue = (int) (((RendererState) this.state).style.opacity.floatValue() * 256.0f);
        if (iFloatValue < 0) {
            iFloatValue = 0;
        } else if (iFloatValue > 255) {
            iFloatValue = 255;
        }
        canvas.saveLayerAlpha(null, iFloatValue, 31);
        ((Stack) this.stateStack).push((RendererState) this.state);
        RendererState rendererState = new RendererState((RendererState) this.state);
        this.state = rendererState;
        String str = rendererState.style.mask;
        if (str != null && ((svgElementBaseResolveIRI = ((SVG) this.document).resolveIRI(str)) == null || !(svgElementBaseResolveIRI instanceof SVG.Mask))) {
            error("Mask reference '%s' not found", ((RendererState) this.state).style.mask);
            ((RendererState) this.state).style.mask = null;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void render(SVG.SvgObject svgObject) {
        SVG.Length length;
        String str;
        int iIndexOf;
        Set systemLanguage;
        SVG.Length length2;
        Boolean bool;
        if (svgObject instanceof SVG.NotDirectlyRendered) {
            return;
        }
        statePush();
        if ((svgObject instanceof SVG.SvgElementBase) && (bool = ((SVG.SvgElementBase) svgObject).spacePreserve) != null) {
            ((RendererState) this.state).spacePreserve = bool.booleanValue();
        }
        if (svgObject instanceof SVG.Svg) {
            SVG.Svg svg = (SVG.Svg) svgObject;
            render(svg, makeViewPort(svg.x, svg.y, svg.width, svg.height), svg.viewBox, svg.preserveAspectRatio);
        } else {
            Bitmap bitmapDecodeByteArray = null;
            float fFloatValueY = 0.0f;
            if (svgObject instanceof SVG.Use) {
                SVG.Use use = (SVG.Use) svgObject;
                Canvas canvas = (Canvas) this.canvas;
                SVG.Length length3 = use.width;
                if ((length3 == null || !length3.isZero()) && ((length2 = use.height) == null || !length2.isZero())) {
                    updateStyleForElement((RendererState) this.state, use);
                    if (display()) {
                        SVG.SvgObject svgObjectResolveIRI = use.document.resolveIRI(use.href);
                        if (svgObjectResolveIRI == null) {
                            error("Use reference '%s' not found", use.href);
                        } else {
                            Matrix matrix = use.transform;
                            if (matrix != null) {
                                canvas.concat(matrix);
                            }
                            SVG.Length length4 = use.x;
                            float fFloatValueX = length4 != null ? length4.floatValueX(this) : 0.0f;
                            SVG.Length length5 = use.y;
                            canvas.translate(fFloatValueX, length5 != null ? length5.floatValueY(this) : 0.0f);
                            checkForClipPath(use, use.boundingBox);
                            boolean zPushLayer = pushLayer();
                            ((Stack) this.parentStack).push(use);
                            ((Stack) this.matrixStack).push(((Canvas) this.canvas).getMatrix());
                            if (svgObjectResolveIRI instanceof SVG.Svg) {
                                SVG.Svg svg2 = (SVG.Svg) svgObjectResolveIRI;
                                SVG.Box boxMakeViewPort = makeViewPort(null, null, use.width, use.height);
                                statePush();
                                render(svg2, boxMakeViewPort, svg2.viewBox, svg2.preserveAspectRatio);
                                statePop();
                            } else if (svgObjectResolveIRI instanceof SVG.Symbol) {
                                SVG.Length length6 = use.width;
                                if (length6 == null) {
                                    length6 = new SVG.Length(9, 100.0f);
                                }
                                SVG.Length length7 = use.height;
                                if (length7 == null) {
                                    length7 = new SVG.Length(9, 100.0f);
                                }
                                SVG.Box boxMakeViewPort2 = makeViewPort(null, null, length6, length7);
                                statePush();
                                SVG.Symbol symbol = (SVG.Symbol) svgObjectResolveIRI;
                                if (boxMakeViewPort2.width != 0.0f && boxMakeViewPort2.height != 0.0f) {
                                    PreserveAspectRatio preserveAspectRatio = symbol.preserveAspectRatio;
                                    if (preserveAspectRatio == null) {
                                        preserveAspectRatio = PreserveAspectRatio.LETTERBOX;
                                    }
                                    updateStyleForElement((RendererState) this.state, symbol);
                                    RendererState rendererState = (RendererState) this.state;
                                    rendererState.viewPort = boxMakeViewPort2;
                                    if (!rendererState.style.overflow.booleanValue()) {
                                        SVG.Box box = ((RendererState) this.state).viewPort;
                                        setClipRect(box.minX, box.minY, box.width, box.height);
                                    }
                                    SVG.Box box2 = symbol.viewBox;
                                    if (box2 != null) {
                                        canvas.concat(calculateViewBoxTransform(((RendererState) this.state).viewPort, box2, preserveAspectRatio));
                                        ((RendererState) this.state).viewBox = symbol.viewBox;
                                    } else {
                                        SVG.Box box3 = ((RendererState) this.state).viewPort;
                                        canvas.translate(box3.minX, box3.minY);
                                    }
                                    boolean zPushLayer2 = pushLayer();
                                    renderChildren(symbol, true);
                                    if (zPushLayer2) {
                                        popLayer(symbol.boundingBox);
                                    }
                                    updateParentBoundingBox(symbol);
                                }
                                statePop();
                            } else {
                                render(svgObjectResolveIRI);
                            }
                            ((Stack) this.parentStack).pop();
                            ((Stack) this.matrixStack).pop();
                            if (zPushLayer) {
                                popLayer(use.boundingBox);
                            }
                            updateParentBoundingBox(use);
                        }
                    }
                }
            } else if (svgObject instanceof SVG.Switch) {
                SVG.Switch r14 = (SVG.Switch) svgObject;
                updateStyleForElement((RendererState) this.state, r14);
                if (display()) {
                    Matrix matrix2 = r14.transform;
                    if (matrix2 != null) {
                        ((Canvas) this.canvas).concat(matrix2);
                    }
                    checkForClipPath(r14, r14.boundingBox);
                    boolean zPushLayer3 = pushLayer();
                    String language = Locale.getDefault().getLanguage();
                    for (SVG.SvgObject svgObject2 : r14.children) {
                        if (svgObject2 instanceof SVG.SvgConditional) {
                            SVG.SvgConditional svgConditional = (SVG.SvgConditional) svgObject2;
                            if (svgConditional.getRequiredExtensions() == null && ((systemLanguage = svgConditional.getSystemLanguage()) == null || (!systemLanguage.isEmpty() && systemLanguage.contains(language)))) {
                                Set requiredFeatures = svgConditional.getRequiredFeatures();
                                if (requiredFeatures != null) {
                                    if (supportedFeatures == null) {
                                        synchronized (SVGAndroidRenderer.class) {
                                            HashSet hashSet = new HashSet();
                                            supportedFeatures = hashSet;
                                            hashSet.add("Structure");
                                            supportedFeatures.add("BasicStructure");
                                            supportedFeatures.add("ConditionalProcessing");
                                            supportedFeatures.add("Image");
                                            supportedFeatures.add("Style");
                                            supportedFeatures.add("ViewportAttribute");
                                            supportedFeatures.add("Shape");
                                            supportedFeatures.add("BasicText");
                                            supportedFeatures.add("PaintAttribute");
                                            supportedFeatures.add("BasicPaintAttribute");
                                            supportedFeatures.add("OpacityAttribute");
                                            supportedFeatures.add("BasicGraphicsAttribute");
                                            supportedFeatures.add("Marker");
                                            supportedFeatures.add("Gradient");
                                            supportedFeatures.add("Pattern");
                                            supportedFeatures.add("Clip");
                                            supportedFeatures.add("BasicClip");
                                            supportedFeatures.add("Mask");
                                            supportedFeatures.add("View");
                                        }
                                    }
                                    if (requiredFeatures.isEmpty() || !supportedFeatures.containsAll(requiredFeatures)) {
                                    }
                                }
                                Set requiredFormats = svgConditional.getRequiredFormats();
                                if (requiredFormats == null) {
                                    Set requiredFonts = svgConditional.getRequiredFonts();
                                    if (requiredFonts == null) {
                                        render(svgObject2);
                                        break;
                                    }
                                    requiredFonts.isEmpty();
                                } else {
                                    requiredFormats.isEmpty();
                                }
                            }
                        }
                    }
                    if (zPushLayer3) {
                        popLayer(r14.boundingBox);
                    }
                    updateParentBoundingBox(r14);
                }
            } else if (svgObject instanceof SVG.Group) {
                SVG.Group group = (SVG.Group) svgObject;
                updateStyleForElement((RendererState) this.state, group);
                if (display()) {
                    Matrix matrix3 = group.transform;
                    if (matrix3 != null) {
                        ((Canvas) this.canvas).concat(matrix3);
                    }
                    checkForClipPath(group, group.boundingBox);
                    boolean zPushLayer4 = pushLayer();
                    renderChildren(group, true);
                    if (zPushLayer4) {
                        popLayer(group.boundingBox);
                    }
                    updateParentBoundingBox(group);
                }
            } else if (svgObject instanceof SVG.Image) {
                SVG.Image image = (SVG.Image) svgObject;
                Canvas canvas2 = (Canvas) this.canvas;
                SVG.Length length8 = image.width;
                if (length8 != null && !length8.isZero() && (length = image.height) != null && !length.isZero() && (str = image.href) != null) {
                    PreserveAspectRatio preserveAspectRatio2 = image.preserveAspectRatio;
                    if (preserveAspectRatio2 == null) {
                        preserveAspectRatio2 = PreserveAspectRatio.LETTERBOX;
                    }
                    if (str.startsWith("data:") && str.length() >= 14 && (iIndexOf = str.indexOf(44)) >= 12 && ";base64".equals(str.substring(iIndexOf - 7, iIndexOf))) {
                        try {
                            byte[] bArrDecode = Base64.decode(str.substring(iIndexOf + 1), 0);
                            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                        } catch (Exception e) {
                            Log.e("SVGAndroidRenderer", "Could not decode bad Data URL", e);
                        }
                    }
                    if (bitmapDecodeByteArray != null) {
                        SVG.Box box4 = new SVG.Box(0.0f, 0.0f, bitmapDecodeByteArray.getWidth(), bitmapDecodeByteArray.getHeight());
                        updateStyleForElement((RendererState) this.state, image);
                        if (display() && visible()) {
                            Matrix matrix4 = image.transform;
                            if (matrix4 != null) {
                                canvas2.concat(matrix4);
                            }
                            SVG.Length length9 = image.x;
                            float fFloatValueX2 = length9 != null ? length9.floatValueX(this) : 0.0f;
                            SVG.Length length10 = image.y;
                            float fFloatValueY2 = length10 != null ? length10.floatValueY(this) : 0.0f;
                            float fFloatValueX3 = image.width.floatValueX(this);
                            float fFloatValueX4 = image.height.floatValueX(this);
                            RendererState rendererState2 = (RendererState) this.state;
                            rendererState2.viewPort = new SVG.Box(fFloatValueX2, fFloatValueY2, fFloatValueX3, fFloatValueX4);
                            if (!rendererState2.style.overflow.booleanValue()) {
                                SVG.Box box5 = ((RendererState) this.state).viewPort;
                                setClipRect(box5.minX, box5.minY, box5.width, box5.height);
                            }
                            image.boundingBox = ((RendererState) this.state).viewPort;
                            updateParentBoundingBox(image);
                            checkForClipPath(image, image.boundingBox);
                            boolean zPushLayer5 = pushLayer();
                            viewportFill();
                            canvas2.save();
                            canvas2.concat(calculateViewBoxTransform(((RendererState) this.state).viewPort, box4, preserveAspectRatio2));
                            canvas2.drawBitmap(bitmapDecodeByteArray, 0.0f, 0.0f, new Paint(((RendererState) this.state).style.imageRendering != 3 ? 2 : 0));
                            canvas2.restore();
                            if (zPushLayer5) {
                                popLayer(image.boundingBox);
                            }
                        }
                    }
                }
            } else if (svgObject instanceof SVG.Path) {
                SVG.Path path = (SVG.Path) svgObject;
                if (path.d != null) {
                    updateStyleForElement((RendererState) this.state, path);
                    if (display() && visible()) {
                        RendererState rendererState3 = (RendererState) this.state;
                        if (rendererState3.hasStroke || rendererState3.hasFill) {
                            Matrix matrix5 = path.transform;
                            if (matrix5 != null) {
                                ((Canvas) this.canvas).concat(matrix5);
                            }
                            Path path2 = new PathConverter(path.d).path;
                            if (path.boundingBox == null) {
                                path.boundingBox = calculatePathBounds(path2);
                            }
                            updateParentBoundingBox(path);
                            checkForGradientsAndPatterns(path);
                            checkForClipPath(path, path.boundingBox);
                            boolean zPushLayer6 = pushLayer();
                            RendererState rendererState4 = (RendererState) this.state;
                            if (rendererState4.hasFill) {
                                int i = rendererState4.style.fillRule;
                                path2.setFillType((i == 0 || i != 2) ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                                doFilledPath(path, path2);
                            }
                            if (((RendererState) this.state).hasStroke) {
                                doStroke(path2);
                            }
                            renderMarkers(path);
                            if (zPushLayer6) {
                                popLayer(path.boundingBox);
                            }
                        }
                    }
                }
            } else if (svgObject instanceof SVG.Rect) {
                SVG.Rect rect = (SVG.Rect) svgObject;
                SVG.Length length11 = rect.width;
                if (length11 != null && rect.height != null && !length11.isZero() && !rect.height.isZero()) {
                    updateStyleForElement((RendererState) this.state, rect);
                    if (display() && visible()) {
                        Matrix matrix6 = rect.transform;
                        if (matrix6 != null) {
                            ((Canvas) this.canvas).concat(matrix6);
                        }
                        Path pathMakePathAndBoundingBox = makePathAndBoundingBox(rect);
                        updateParentBoundingBox(rect);
                        checkForGradientsAndPatterns(rect);
                        checkForClipPath(rect, rect.boundingBox);
                        boolean zPushLayer7 = pushLayer();
                        if (((RendererState) this.state).hasFill) {
                            doFilledPath(rect, pathMakePathAndBoundingBox);
                        }
                        if (((RendererState) this.state).hasStroke) {
                            doStroke(pathMakePathAndBoundingBox);
                        }
                        if (zPushLayer7) {
                            popLayer(rect.boundingBox);
                        }
                    }
                }
            } else if (svgObject instanceof SVG.Circle) {
                SVG.Circle circle = (SVG.Circle) svgObject;
                SVG.Length length12 = circle.r;
                if (length12 != null && !length12.isZero()) {
                    updateStyleForElement((RendererState) this.state, circle);
                    if (display() && visible()) {
                        Matrix matrix7 = circle.transform;
                        if (matrix7 != null) {
                            ((Canvas) this.canvas).concat(matrix7);
                        }
                        Path pathMakePathAndBoundingBox2 = makePathAndBoundingBox(circle);
                        updateParentBoundingBox(circle);
                        checkForGradientsAndPatterns(circle);
                        checkForClipPath(circle, circle.boundingBox);
                        boolean zPushLayer8 = pushLayer();
                        if (((RendererState) this.state).hasFill) {
                            doFilledPath(circle, pathMakePathAndBoundingBox2);
                        }
                        if (((RendererState) this.state).hasStroke) {
                            doStroke(pathMakePathAndBoundingBox2);
                        }
                        if (zPushLayer8) {
                            popLayer(circle.boundingBox);
                        }
                    }
                }
            } else if (svgObject instanceof SVG.Ellipse) {
                SVG.Ellipse ellipse = (SVG.Ellipse) svgObject;
                SVG.Length length13 = ellipse.rx;
                if (length13 != null && ellipse.ry != null && !length13.isZero() && !ellipse.ry.isZero()) {
                    updateStyleForElement((RendererState) this.state, ellipse);
                    if (display() && visible()) {
                        Matrix matrix8 = ellipse.transform;
                        if (matrix8 != null) {
                            ((Canvas) this.canvas).concat(matrix8);
                        }
                        Path pathMakePathAndBoundingBox3 = makePathAndBoundingBox(ellipse);
                        updateParentBoundingBox(ellipse);
                        checkForGradientsAndPatterns(ellipse);
                        checkForClipPath(ellipse, ellipse.boundingBox);
                        boolean zPushLayer9 = pushLayer();
                        if (((RendererState) this.state).hasFill) {
                            doFilledPath(ellipse, pathMakePathAndBoundingBox3);
                        }
                        if (((RendererState) this.state).hasStroke) {
                            doStroke(pathMakePathAndBoundingBox3);
                        }
                        if (zPushLayer9) {
                            popLayer(ellipse.boundingBox);
                        }
                    }
                }
            } else if (svgObject instanceof SVG.Line) {
                SVG.Line line = (SVG.Line) svgObject;
                updateStyleForElement((RendererState) this.state, line);
                if (display() && visible() && ((RendererState) this.state).hasStroke) {
                    Matrix matrix9 = line.transform;
                    if (matrix9 != null) {
                        ((Canvas) this.canvas).concat(matrix9);
                    }
                    SVG.Length length14 = line.x1;
                    float fFloatValueX5 = length14 == null ? 0.0f : length14.floatValueX(this);
                    SVG.Length length15 = line.y1;
                    float fFloatValueY3 = length15 == null ? 0.0f : length15.floatValueY(this);
                    SVG.Length length16 = line.x2;
                    float fFloatValueX6 = length16 == null ? 0.0f : length16.floatValueX(this);
                    SVG.Length length17 = line.y2;
                    fFloatValueY = length17 != null ? length17.floatValueY(this) : 0.0f;
                    if (line.boundingBox == null) {
                        line.boundingBox = new SVG.Box(Math.min(fFloatValueX5, fFloatValueX6), Math.min(fFloatValueY3, fFloatValueY), Math.abs(fFloatValueX6 - fFloatValueX5), Math.abs(fFloatValueY - fFloatValueY3));
                    }
                    Path path3 = new Path();
                    path3.moveTo(fFloatValueX5, fFloatValueY3);
                    path3.lineTo(fFloatValueX6, fFloatValueY);
                    updateParentBoundingBox(line);
                    checkForGradientsAndPatterns(line);
                    checkForClipPath(line, line.boundingBox);
                    boolean zPushLayer10 = pushLayer();
                    doStroke(path3);
                    renderMarkers(line);
                    if (zPushLayer10) {
                        popLayer(line.boundingBox);
                    }
                }
            } else if (svgObject instanceof SVG.Polygon) {
                SVG.Polygon polygon = (SVG.Polygon) svgObject;
                updateStyleForElement((RendererState) this.state, polygon);
                if (display() && visible()) {
                    RendererState rendererState5 = (RendererState) this.state;
                    if (rendererState5.hasStroke || rendererState5.hasFill) {
                        Matrix matrix10 = polygon.transform;
                        if (matrix10 != null) {
                            ((Canvas) this.canvas).concat(matrix10);
                        }
                        if (polygon.points.length >= 2) {
                            Path pathMakePathAndBoundingBox4 = makePathAndBoundingBox(polygon);
                            updateParentBoundingBox(polygon);
                            checkForGradientsAndPatterns(polygon);
                            checkForClipPath(polygon, polygon.boundingBox);
                            boolean zPushLayer11 = pushLayer();
                            if (((RendererState) this.state).hasFill) {
                                doFilledPath(polygon, pathMakePathAndBoundingBox4);
                            }
                            if (((RendererState) this.state).hasStroke) {
                                doStroke(pathMakePathAndBoundingBox4);
                            }
                            renderMarkers(polygon);
                            if (zPushLayer11) {
                                popLayer(polygon.boundingBox);
                            }
                        }
                    }
                }
            } else if (svgObject instanceof SVG.PolyLine) {
                SVG.PolyLine polyLine = (SVG.PolyLine) svgObject;
                updateStyleForElement((RendererState) this.state, polyLine);
                if (display() && visible()) {
                    RendererState rendererState6 = (RendererState) this.state;
                    if (rendererState6.hasStroke || rendererState6.hasFill) {
                        Matrix matrix11 = polyLine.transform;
                        if (matrix11 != null) {
                            ((Canvas) this.canvas).concat(matrix11);
                        }
                        if (polyLine.points.length >= 2) {
                            Path pathMakePathAndBoundingBox5 = makePathAndBoundingBox(polyLine);
                            updateParentBoundingBox(polyLine);
                            int i2 = ((RendererState) this.state).style.fillRule;
                            pathMakePathAndBoundingBox5.setFillType((i2 == 0 || i2 != 2) ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                            checkForGradientsAndPatterns(polyLine);
                            checkForClipPath(polyLine, polyLine.boundingBox);
                            boolean zPushLayer12 = pushLayer();
                            if (((RendererState) this.state).hasFill) {
                                doFilledPath(polyLine, pathMakePathAndBoundingBox5);
                            }
                            if (((RendererState) this.state).hasStroke) {
                                doStroke(pathMakePathAndBoundingBox5);
                            }
                            renderMarkers(polyLine);
                            if (zPushLayer12) {
                                popLayer(polyLine.boundingBox);
                            }
                        }
                    }
                }
            } else if (svgObject instanceof SVG.Text) {
                SVG.Text text = (SVG.Text) svgObject;
                updateStyleForElement((RendererState) this.state, text);
                if (display()) {
                    Matrix matrix12 = text.transform;
                    if (matrix12 != null) {
                        ((Canvas) this.canvas).concat(matrix12);
                    }
                    ArrayList arrayList = text.x;
                    float fFloatValueX7 = (arrayList == null || arrayList.size() == 0) ? 0.0f : ((SVG.Length) text.x.get(0)).floatValueX(this);
                    ArrayList arrayList2 = text.y;
                    float fFloatValueY4 = (arrayList2 == null || arrayList2.size() == 0) ? 0.0f : ((SVG.Length) text.y.get(0)).floatValueY(this);
                    ArrayList arrayList3 = text.dx;
                    float fFloatValueX8 = (arrayList3 == null || arrayList3.size() == 0) ? 0.0f : ((SVG.Length) text.dx.get(0)).floatValueX(this);
                    ArrayList arrayList4 = text.dy;
                    if (arrayList4 != null && arrayList4.size() != 0) {
                        fFloatValueY = ((SVG.Length) text.dy.get(0)).floatValueY(this);
                    }
                    int anchorPosition = getAnchorPosition();
                    if (anchorPosition != 1) {
                        float fCalculateTextWidth = calculateTextWidth(text);
                        if (anchorPosition == 2) {
                            fCalculateTextWidth /= 2.0f;
                        }
                        fFloatValueX7 -= fCalculateTextWidth;
                    }
                    if (text.boundingBox == null) {
                        PlainTextToPath plainTextToPath = new PlainTextToPath(this, fFloatValueX7, fFloatValueY4);
                        enumerateTextSpans(text, plainTextToPath);
                        RectF rectF = (RectF) plainTextToPath.textAsPath;
                        text.boundingBox = new SVG.Box(rectF.left, rectF.top, rectF.width(), ((RectF) plainTextToPath.textAsPath).height());
                    }
                    updateParentBoundingBox(text);
                    checkForGradientsAndPatterns(text);
                    checkForClipPath(text, text.boundingBox);
                    boolean zPushLayer13 = pushLayer();
                    enumerateTextSpans(text, new PlainTextDrawer(fFloatValueX7 + fFloatValueX8, fFloatValueY4 + fFloatValueY));
                    if (zPushLayer13) {
                        popLayer(text.boundingBox);
                    }
                }
            }
        }
        statePop();
    }

    public void renderChildren(SVG.SvgConditionalContainer svgConditionalContainer, boolean z) {
        if (z) {
            ((Stack) this.parentStack).push(svgConditionalContainer);
            ((Stack) this.matrixStack).push(((Canvas) this.canvas).getMatrix());
        }
        Iterator it = svgConditionalContainer.children.iterator();
        while (it.hasNext()) {
            render((SVG.SvgObject) it.next());
        }
        if (z) {
            ((Stack) this.parentStack).pop();
            ((Stack) this.matrixStack).pop();
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0037  */
    /* JADX WARN: Code duplicated, block: B:70:0x010d  */
    public void renderMarker(SVG.Marker marker, MarkerVector markerVector) {
        float fFloatValue;
        float f;
        float f2;
        float f3;
        Canvas canvas = (Canvas) this.canvas;
        statePush();
        Float f4 = marker.orient;
        float f5 = 0.0f;
        if (f4 == null) {
            fFloatValue = 0.0f;
        } else if (Float.isNaN(f4.floatValue())) {
            float f6 = markerVector.dx;
            if (f6 == 0.0f && markerVector.dy == 0.0f) {
                fFloatValue = 0.0f;
            } else {
                fFloatValue = (float) Math.toDegrees(Math.atan2(markerVector.dy, f6));
            }
        } else {
            fFloatValue = marker.orient.floatValue();
        }
        float fFloatValue$1 = marker.markerUnitsAreUser ? 1.0f : ((RendererState) this.state).style.strokeWidth.floatValue$1();
        this.state = findInheritFromAncestorState(marker);
        Matrix matrix = new Matrix();
        matrix.preTranslate(markerVector.x, markerVector.y);
        matrix.preRotate(fFloatValue);
        matrix.preScale(fFloatValue$1, fFloatValue$1);
        SVG.Length length = marker.refX;
        float fFloatValueX = length != null ? length.floatValueX(this) : 0.0f;
        SVG.Length length2 = marker.refY;
        float fFloatValueY = length2 != null ? length2.floatValueY(this) : 0.0f;
        SVG.Length length3 = marker.markerWidth;
        float fFloatValueX2 = length3 != null ? length3.floatValueX(this) : 3.0f;
        SVG.Length length4 = marker.markerHeight;
        float fFloatValueY2 = length4 != null ? length4.floatValueY(this) : 3.0f;
        SVG.Box box = marker.viewBox;
        if (box != null) {
            float fMax = fFloatValueX2 / box.width;
            float f7 = fFloatValueY2 / box.height;
            PreserveAspectRatio preserveAspectRatio = marker.preserveAspectRatio;
            if (preserveAspectRatio == null) {
                preserveAspectRatio = PreserveAspectRatio.LETTERBOX;
            }
            boolean zEquals = preserveAspectRatio.equals(PreserveAspectRatio.STRETCH);
            PreserveAspectRatio.Alignment alignment = preserveAspectRatio.alignment;
            if (!zEquals) {
                fMax = preserveAspectRatio.scale == 2 ? Math.max(fMax, f7) : Math.min(fMax, f7);
                f7 = fMax;
            }
            matrix.preTranslate((-fFloatValueX) * fMax, (-fFloatValueY) * f7);
            canvas.concat(matrix);
            SVG.Box box2 = marker.viewBox;
            float f8 = box2.width * fMax;
            float f9 = box2.height * f7;
            int iOrdinal = alignment.ordinal();
            if (iOrdinal == 2) {
                f = (fFloatValueX2 - f8) / 2.0f;
                f2 = 0.0f - f;
            } else {
                if (iOrdinal != 3) {
                    if (iOrdinal != 5) {
                        if (iOrdinal != 6) {
                            if (iOrdinal != 8) {
                                if (iOrdinal != 9) {
                                    f2 = 0.0f;
                                }
                            }
                        }
                    }
                    f = (fFloatValueX2 - f8) / 2.0f;
                    f2 = 0.0f - f;
                }
                f = fFloatValueX2 - f8;
                f2 = 0.0f - f;
            }
            switch (alignment.ordinal()) {
                case 4:
                case 5:
                case 6:
                    f3 = (fFloatValueY2 - f9) / 2.0f;
                    f5 = 0.0f - f3;
                    if (!((RendererState) this.state).style.overflow.booleanValue()) {
                        setClipRect(f2, f5, fFloatValueX2, fFloatValueY2);
                    }
                    matrix.reset();
                    matrix.preScale(fMax, f7);
                    canvas.concat(matrix);
                    break;
                case 7:
                case 8:
                case 9:
                    f3 = fFloatValueY2 - f9;
                    f5 = 0.0f - f3;
                    if (!((RendererState) this.state).style.overflow.booleanValue()) {
                        setClipRect(f2, f5, fFloatValueX2, fFloatValueY2);
                    }
                    matrix.reset();
                    matrix.preScale(fMax, f7);
                    canvas.concat(matrix);
                    break;
                default:
                    if (!((RendererState) this.state).style.overflow.booleanValue()) {
                        setClipRect(f2, f5, fFloatValueX2, fFloatValueY2);
                    }
                    matrix.reset();
                    matrix.preScale(fMax, f7);
                    canvas.concat(matrix);
                    break;
            }
        } else {
            matrix.preTranslate(-fFloatValueX, -fFloatValueY);
            canvas.concat(matrix);
            if (!((RendererState) this.state).style.overflow.booleanValue()) {
                setClipRect(0.0f, 0.0f, fFloatValueX2, fFloatValueY2);
            }
        }
        boolean zPushLayer = pushLayer();
        renderChildren(marker, false);
        if (zPushLayer) {
            popLayer(marker.boundingBox);
        }
        statePop();
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:104:0x01e6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:109:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:76:0x017e  */
    /* JADX WARN: Code duplicated, block: B:83:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:85:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:87:0x01c7  */
    public void renderMarkers(SVG.GraphicsElement graphicsElement) {
        SVG.Marker marker;
        SVG.Marker marker2;
        SVG.Marker marker3;
        int i;
        float f;
        float f2;
        float f3;
        ArrayList arrayList;
        int size;
        MarkerVector markerVector;
        MarkerVector markerVector2;
        int i2;
        MarkerVector markerVector3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        SVG.Style style = ((RendererState) this.state).style;
        String str = style.markerStart;
        if (str == null && style.markerMid == null && style.markerEnd == null) {
            return;
        }
        if (str == null) {
            marker = null;
        } else {
            SVG.SvgElementBase svgElementBaseResolveIRI = graphicsElement.document.resolveIRI(str);
            if (svgElementBaseResolveIRI != null) {
                marker = (SVG.Marker) svgElementBaseResolveIRI;
            } else {
                error("Marker reference '%s' not found", ((RendererState) this.state).style.markerStart);
                marker = null;
            }
        }
        String str2 = ((RendererState) this.state).style.markerMid;
        if (str2 == null) {
            marker2 = null;
        } else {
            SVG.SvgElementBase svgElementBaseResolveIRI2 = graphicsElement.document.resolveIRI(str2);
            if (svgElementBaseResolveIRI2 != null) {
                marker2 = (SVG.Marker) svgElementBaseResolveIRI2;
            } else {
                error("Marker reference '%s' not found", ((RendererState) this.state).style.markerMid);
                marker2 = null;
            }
        }
        String str3 = ((RendererState) this.state).style.markerEnd;
        if (str3 == null) {
            marker3 = null;
        } else {
            SVG.SvgElementBase svgElementBaseResolveIRI3 = graphicsElement.document.resolveIRI(str3);
            if (svgElementBaseResolveIRI3 != null) {
                marker3 = (SVG.Marker) svgElementBaseResolveIRI3;
            } else {
                error("Marker reference '%s' not found", ((RendererState) this.state).style.markerEnd);
                marker3 = null;
            }
        }
        float f9 = 0.0f;
        if (!(graphicsElement instanceof SVG.Path)) {
            if (graphicsElement instanceof SVG.Line) {
                SVG.Line line = (SVG.Line) graphicsElement;
                SVG.Length length = line.x1;
                float fFloatValueX = length != null ? length.floatValueX(this) : 0.0f;
                SVG.Length length2 = line.y1;
                float fFloatValueY = length2 != null ? length2.floatValueY(this) : 0.0f;
                SVG.Length length3 = line.x2;
                float fFloatValueX2 = length3 != null ? length3.floatValueX(this) : 0.0f;
                SVG.Length length4 = line.y2;
                float fFloatValueY2 = length4 != null ? length4.floatValueY(this) : 0.0f;
                ArrayList arrayList2 = new ArrayList(2);
                float f10 = fFloatValueX2 - fFloatValueX;
                i = 1;
                float f11 = fFloatValueY2 - fFloatValueY;
                arrayList2.add(new MarkerVector(fFloatValueX, fFloatValueY, f10, f11));
                arrayList2.add(new MarkerVector(fFloatValueX2, fFloatValueY2, f10, f11));
                f2 = 0.0f;
                arrayList = arrayList2;
            } else {
                i = 1;
                SVG.PolyLine polyLine = (SVG.PolyLine) graphicsElement;
                int length5 = polyLine.points.length;
                if (length5 < 2) {
                    arrayList = null;
                } else {
                    ArrayList arrayList3 = new ArrayList();
                    float[] fArr = polyLine.points;
                    MarkerVector markerVector4 = new MarkerVector(fArr[0], fArr[1], 0.0f, 0.0f);
                    int i3 = 2;
                    float f12 = 0.0f;
                    float f13 = 0.0f;
                    while (true) {
                        f = markerVector4.y;
                        f2 = f9;
                        f3 = markerVector4.x;
                        if (i3 >= length5) {
                            break;
                        }
                        float[] fArr2 = polyLine.points;
                        float f14 = fArr2[i3];
                        float f15 = fArr2[i3 + 1];
                        markerVector4.add(f14, f15);
                        arrayList3.add(markerVector4);
                        markerVector4 = new MarkerVector(f14, f15, f14 - f3, f15 - f);
                        i3 += 2;
                        f13 = f15;
                        f12 = f14;
                        f9 = f2;
                    }
                    if (polyLine instanceof SVG.Polygon) {
                        float[] fArr3 = polyLine.points;
                        float f16 = fArr3[0];
                        if (f12 != f16) {
                            float f17 = fArr3[1];
                            if (f13 != f17) {
                                markerVector4.add(f16, f17);
                                arrayList3.add(markerVector4);
                                MarkerVector markerVector5 = new MarkerVector(f16, f17, f16 - f3, f17 - f);
                                markerVector5.add((MarkerVector) arrayList3.get(0));
                                arrayList3.add(markerVector5);
                                arrayList3.set(0, markerVector5);
                            }
                        }
                    } else {
                        arrayList3.add(markerVector4);
                    }
                    arrayList = arrayList3;
                }
            }
            if (arrayList == null && (size = arrayList.size()) != 0) {
                SVG.Style style2 = ((RendererState) this.state).style;
                style2.markerEnd = null;
                style2.markerMid = null;
                style2.markerStart = null;
                if (marker != null) {
                    renderMarker(marker, (MarkerVector) arrayList.get(0));
                }
                if (marker2 != null && arrayList.size() > 2) {
                    markerVector = (MarkerVector) arrayList.get(0);
                    markerVector2 = (MarkerVector) arrayList.get(i);
                    i2 = 1;
                    while (i2 < size - 1) {
                        i2++;
                        markerVector3 = (MarkerVector) arrayList.get(i2);
                        if (markerVector2.isAmbiguous) {
                            f4 = markerVector2.dx;
                            f5 = markerVector2.dy;
                            f6 = markerVector2.x;
                            float f18 = f6 - markerVector.x;
                            f7 = markerVector2.y;
                            f8 = ((f7 - markerVector.y) * f5) + (f18 * f4);
                            if (f8 == f2) {
                                f8 = ((markerVector3.x - f6) * f4) + ((markerVector3.y - f7) * f5);
                            }
                            if (f8 <= f2 && (f8 != f2 || (f4 <= f2 && f5 < f2))) {
                                markerVector2.dx = -f4;
                                markerVector2.dy = -f5;
                            }
                        }
                        renderMarker(marker2, markerVector2);
                        markerVector = markerVector2;
                        markerVector2 = markerVector3;
                    }
                }
                if (marker3 != null) {
                    renderMarker(marker3, (MarkerVector) arrayList.get(size - 1));
                }
            }
            return;
        }
        arrayList = new MarkerPositionCalculator(this, ((SVG.Path) graphicsElement).d).markers;
        i = 1;
        f2 = 0.0f;
        if (arrayList == null) {
            return;
        }
        SVG.Style style3 = ((RendererState) this.state).style;
        style3.markerEnd = null;
        style3.markerMid = null;
        style3.markerStart = null;
        if (marker != null) {
            renderMarker(marker, (MarkerVector) arrayList.get(0));
        }
        if (marker2 != null) {
            markerVector = (MarkerVector) arrayList.get(0);
            markerVector2 = (MarkerVector) arrayList.get(i);
            i2 = 1;
            while (i2 < size - 1) {
                i2++;
                markerVector3 = (MarkerVector) arrayList.get(i2);
                if (markerVector2.isAmbiguous) {
                    f4 = markerVector2.dx;
                    f5 = markerVector2.dy;
                    f6 = markerVector2.x;
                    float f19 = f6 - markerVector.x;
                    f7 = markerVector2.y;
                    f8 = ((f7 - markerVector.y) * f5) + (f19 * f4);
                    if (f8 == f2) {
                        f8 = ((markerVector3.x - f6) * f4) + ((markerVector3.y - f7) * f5);
                    }
                    if (f8 <= f2) {
                        markerVector2.dx = -f4;
                        markerVector2.dy = -f5;
                    }
                }
                renderMarker(marker2, markerVector2);
                markerVector = markerVector2;
                markerVector2 = markerVector3;
            }
        }
        if (marker3 != null) {
            renderMarker(marker3, (MarkerVector) arrayList.get(size - 1));
        }
    }

    public void renderMask(SVG.Mask mask, SVG.Box box) {
        float fFloatValueX;
        float fFloatValueY;
        Canvas canvas = (Canvas) this.canvas;
        Boolean bool = mask.maskUnitsAreUser;
        if (bool == null || !bool.booleanValue()) {
            SVG.Length length = mask.width;
            float fFloatValue = length != null ? length.floatValue(this, 1.0f) : 1.2f;
            SVG.Length length2 = mask.height;
            float fFloatValue2 = length2 != null ? length2.floatValue(this, 1.0f) : 1.2f;
            fFloatValueX = fFloatValue * box.width;
            fFloatValueY = fFloatValue2 * box.height;
        } else {
            SVG.Length length3 = mask.width;
            fFloatValueX = length3 != null ? length3.floatValueX(this) : box.width;
            SVG.Length length4 = mask.height;
            fFloatValueY = length4 != null ? length4.floatValueY(this) : box.height;
        }
        if (fFloatValueX == 0.0f || fFloatValueY == 0.0f) {
            return;
        }
        statePush();
        RendererState rendererStateFindInheritFromAncestorState = findInheritFromAncestorState(mask);
        this.state = rendererStateFindInheritFromAncestorState;
        rendererStateFindInheritFromAncestorState.style.opacity = Float.valueOf(1.0f);
        boolean zPushLayer = pushLayer();
        canvas.save();
        Boolean bool2 = mask.maskContentUnitsAreUser;
        if (bool2 != null && !bool2.booleanValue()) {
            canvas.translate(box.minX, box.minY);
            canvas.scale(box.width, box.height);
        }
        renderChildren(mask, false);
        canvas.restore();
        if (zPushLayer) {
            popLayer(box);
        }
        statePop();
    }

    public void setClipRect(float f, float f2, float f3, float f4) {
        float fFloatValueX = f3 + f;
        float fFloatValueY = f4 + f2;
        Dispatcher dispatcher = ((RendererState) this.state).style.clip;
        if (dispatcher != null) {
            f += ((SVG.Length) dispatcher.runningSyncCalls).floatValueX(this);
            f2 += ((SVG.Length) ((RendererState) this.state).style.clip.executorServiceOrNull).floatValueY(this);
            fFloatValueX -= ((SVG.Length) ((RendererState) this.state).style.clip.readyAsyncCalls).floatValueX(this);
            fFloatValueY -= ((SVG.Length) ((RendererState) this.state).style.clip.runningAsyncCalls).floatValueY(this);
        }
        ((Canvas) this.canvas).clipRect(f, f2, fFloatValueX, fFloatValueY);
    }

    public void statePop() {
        ((Canvas) this.canvas).restore();
        this.state = (RendererState) ((Stack) this.stateStack).pop();
    }

    public void statePush() {
        ((Canvas) this.canvas).save();
        ((Stack) this.stateStack).push((RendererState) this.state);
        this.state = new RendererState((RendererState) this.state);
    }

    public String textXMLSpaceTransform(String str, boolean z, boolean z2) {
        if (((RendererState) this.state).spacePreserve) {
            return str.replaceAll("[\\n\\t]", " ");
        }
        String strReplaceAll = str.replaceAll("\\n", "").replaceAll("\\t", " ");
        if (z) {
            strReplaceAll = strReplaceAll.replaceAll("^\\s+", "");
        }
        if (z2) {
            strReplaceAll = strReplaceAll.replaceAll("\\s+$", "");
        }
        return strReplaceAll.replaceAll("\\s{2,}", " ");
    }

    public void updateParentBoundingBox(SVG.SvgElement svgElement) {
        if (svgElement.parent == null || svgElement.boundingBox == null) {
            return;
        }
        Matrix matrix = new Matrix();
        if (((Matrix) ((Stack) this.matrixStack).peek()).invert(matrix)) {
            SVG.Box box = svgElement.boundingBox;
            float f = box.minX;
            float f2 = box.minY;
            float fMaxX = box.maxX();
            SVG.Box box2 = svgElement.boundingBox;
            float f3 = box2.minY;
            float fMaxX2 = box2.maxX();
            float fMaxY = svgElement.boundingBox.maxY();
            SVG.Box box3 = svgElement.boundingBox;
            float[] fArr = {f, f2, fMaxX, f3, fMaxX2, fMaxY, box3.minX, box3.maxY()};
            matrix.preConcat(((Canvas) this.canvas).getMatrix());
            matrix.mapPoints(fArr);
            float f4 = fArr[0];
            float f5 = fArr[1];
            RectF rectF = new RectF(f4, f5, f4, f5);
            for (int i = 2; i <= 6; i += 2) {
                float f6 = fArr[i];
                if (f6 < rectF.left) {
                    rectF.left = f6;
                }
                if (f6 > rectF.right) {
                    rectF.right = f6;
                }
                float f7 = fArr[i + 1];
                if (f7 < rectF.top) {
                    rectF.top = f7;
                }
                if (f7 > rectF.bottom) {
                    rectF.bottom = f7;
                }
            }
            SVG.SvgElement svgElement2 = (SVG.SvgElement) ((Stack) this.parentStack).peek();
            SVG.Box box4 = svgElement2.boundingBox;
            if (box4 == null) {
                float f8 = rectF.left;
                float f9 = rectF.top;
                svgElement2.boundingBox = new SVG.Box(f8, f9, rectF.right - f8, rectF.bottom - f9);
                return;
            }
            float f10 = rectF.left;
            float f11 = rectF.top;
            float f12 = rectF.right - f10;
            float f13 = rectF.bottom - f11;
            if (f10 < box4.minX) {
                box4.minX = f10;
            }
            if (f11 < box4.minY) {
                box4.minY = f11;
            }
            if (f10 + f12 > box4.maxX()) {
                box4.width = (f10 + f12) - box4.minX;
            }
            if (f11 + f13 > box4.maxY()) {
                box4.height = (f11 + f13) - box4.minY;
            }
        }
    }

    public void updateStyle(RendererState rendererState, SVG.Style style) {
        if (isSpecified(style, 4096L)) {
            rendererState.style.color = style.color;
        }
        if (isSpecified(style, 2048L)) {
            rendererState.style.opacity = style.opacity;
        }
        boolean zIsSpecified = isSpecified(style, 1L);
        SVG.Colour colour = SVG.Colour.TRANSPARENT;
        if (zIsSpecified) {
            rendererState.style.fill = style.fill;
            SVG.SvgPaint svgPaint = style.fill;
            rendererState.hasFill = (svgPaint == null || svgPaint == colour) ? false : true;
        }
        if (isSpecified(style, 4L)) {
            rendererState.style.fillOpacity = style.fillOpacity;
        }
        if (isSpecified(style, 6149L)) {
            setPaintColour(rendererState, true, rendererState.style.fill);
        }
        if (isSpecified(style, 2L)) {
            rendererState.style.fillRule = style.fillRule;
        }
        if (isSpecified(style, 8L)) {
            rendererState.style.stroke = style.stroke;
            SVG.SvgPaint svgPaint2 = style.stroke;
            rendererState.hasStroke = (svgPaint2 == null || svgPaint2 == colour) ? false : true;
        }
        if (isSpecified(style, 16L)) {
            rendererState.style.strokeOpacity = style.strokeOpacity;
        }
        if (isSpecified(style, 6168L)) {
            setPaintColour(rendererState, false, rendererState.style.stroke);
        }
        if (isSpecified(style, 34359738368L)) {
            rendererState.style.vectorEffect = style.vectorEffect;
        }
        if (isSpecified(style, 32L)) {
            SVG.Style style2 = rendererState.style;
            SVG.Length length = style.strokeWidth;
            style2.strokeWidth = length;
            rendererState.strokePaint.setStrokeWidth(length.floatValue(this));
        }
        if (isSpecified(style, 64L)) {
            SVG.Style style3 = rendererState.style;
            Paint paint = rendererState.strokePaint;
            style3.strokeLineCap = style.strokeLineCap;
            int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(style.strokeLineCap);
            if (iOrdinal == 0) {
                paint.setStrokeCap(Paint.Cap.BUTT);
            } else if (iOrdinal == 1) {
                paint.setStrokeCap(Paint.Cap.ROUND);
            } else if (iOrdinal == 2) {
                paint.setStrokeCap(Paint.Cap.SQUARE);
            }
        }
        if (isSpecified(style, 128L)) {
            SVG.Style style4 = rendererState.style;
            Paint paint2 = rendererState.strokePaint;
            style4.strokeLineJoin = style.strokeLineJoin;
            int iOrdinal2 = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(style.strokeLineJoin);
            if (iOrdinal2 == 0) {
                paint2.setStrokeJoin(Paint.Join.MITER);
            } else if (iOrdinal2 == 1) {
                paint2.setStrokeJoin(Paint.Join.ROUND);
            } else if (iOrdinal2 == 2) {
                paint2.setStrokeJoin(Paint.Join.BEVEL);
            }
        }
        if (isSpecified(style, 256L)) {
            rendererState.style.strokeMiterLimit = style.strokeMiterLimit;
            rendererState.strokePaint.setStrokeMiter(style.strokeMiterLimit.floatValue());
        }
        if (isSpecified(style, 512L)) {
            rendererState.style.strokeDashArray = style.strokeDashArray;
        }
        if (isSpecified(style, 1024L)) {
            rendererState.style.strokeDashOffset = style.strokeDashOffset;
        }
        Typeface typefaceCheckGenericFont = null;
        if (isSpecified(style, 1536L)) {
            SVG.Style style5 = rendererState.style;
            Paint paint3 = rendererState.strokePaint;
            SVG.Length[] lengthArr = style5.strokeDashArray;
            if (lengthArr == null) {
                paint3.setPathEffect(null);
            } else {
                int length2 = lengthArr.length;
                int i = length2 % 2 == 0 ? length2 : length2 * 2;
                float[] fArr = new float[i];
                float f = 0.0f;
                for (int i2 = 0; i2 < i; i2++) {
                    float fFloatValue = style5.strokeDashArray[i2 % length2].floatValue(this);
                    fArr[i2] = fFloatValue;
                    f += fFloatValue;
                }
                if (f == 0.0f) {
                    paint3.setPathEffect(null);
                } else {
                    float fFloatValue2 = style5.strokeDashOffset.floatValue(this);
                    if (fFloatValue2 < 0.0f) {
                        fFloatValue2 = (fFloatValue2 % f) + f;
                    }
                    paint3.setPathEffect(new DashPathEffect(fArr, fFloatValue2));
                }
            }
        }
        if (isSpecified(style, 16384L)) {
            float textSize = ((RendererState) this.state).fillPaint.getTextSize();
            rendererState.style.fontSize = style.fontSize;
            rendererState.fillPaint.setTextSize(style.fontSize.floatValue(this, textSize));
            rendererState.strokePaint.setTextSize(style.fontSize.floatValue(this, textSize));
        }
        if (isSpecified(style, 8192L)) {
            rendererState.style.fontFamily = style.fontFamily;
        }
        if (isSpecified(style, 32768L)) {
            if (style.fontWeight.intValue() == -1 && rendererState.style.fontWeight.intValue() > 100) {
                SVG.Style style6 = rendererState.style;
                style6.fontWeight = Integer.valueOf(style6.fontWeight.intValue() - 100);
            } else if (style.fontWeight.intValue() != 1 || rendererState.style.fontWeight.intValue() >= 900) {
                rendererState.style.fontWeight = style.fontWeight;
            } else {
                SVG.Style style7 = rendererState.style;
                style7.fontWeight = Integer.valueOf(style7.fontWeight.intValue() + 100);
            }
        }
        if (isSpecified(style, 65536L)) {
            rendererState.style.fontStyle = style.fontStyle;
        }
        if (isSpecified(style, 106496L)) {
            SVG.Style style8 = rendererState.style;
            ArrayList arrayList = style8.fontFamily;
            if (arrayList != null) {
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    typefaceCheckGenericFont = checkGenericFont((String) obj, style8.fontWeight, style8.fontStyle);
                    if (typefaceCheckGenericFont != null) {
                        break;
                    }
                }
            }
            if (typefaceCheckGenericFont == null) {
                typefaceCheckGenericFont = checkGenericFont("serif", style8.fontWeight, style8.fontStyle);
            }
            rendererState.fillPaint.setTypeface(typefaceCheckGenericFont);
            rendererState.strokePaint.setTypeface(typefaceCheckGenericFont);
        }
        if (isSpecified(style, 131072L)) {
            SVG.Style style9 = rendererState.style;
            Paint paint4 = rendererState.strokePaint;
            Paint paint5 = rendererState.fillPaint;
            style9.textDecoration = style.textDecoration;
            paint5.setStrikeThruText(style.textDecoration == 4);
            paint5.setUnderlineText(style.textDecoration == 2);
            paint4.setStrikeThruText(style.textDecoration == 4);
            paint4.setUnderlineText(style.textDecoration == 2);
        }
        if (isSpecified(style, 68719476736L)) {
            rendererState.style.direction = style.direction;
        }
        if (isSpecified(style, 262144L)) {
            rendererState.style.textAnchor = style.textAnchor;
        }
        if (isSpecified(style, 524288L)) {
            rendererState.style.overflow = style.overflow;
        }
        if (isSpecified(style, 2097152L)) {
            rendererState.style.markerStart = style.markerStart;
        }
        if (isSpecified(style, 4194304L)) {
            rendererState.style.markerMid = style.markerMid;
        }
        if (isSpecified(style, 8388608L)) {
            rendererState.style.markerEnd = style.markerEnd;
        }
        if (isSpecified(style, 16777216L)) {
            rendererState.style.display = style.display;
        }
        if (isSpecified(style, 33554432L)) {
            rendererState.style.visibility = style.visibility;
        }
        if (isSpecified(style, 1048576L)) {
            rendererState.style.clip = style.clip;
        }
        if (isSpecified(style, 268435456L)) {
            rendererState.style.clipPath = style.clipPath;
        }
        if (isSpecified(style, 536870912L)) {
            rendererState.style.clipRule = style.clipRule;
        }
        if (isSpecified(style, 1073741824L)) {
            rendererState.style.mask = style.mask;
        }
        if (isSpecified(style, 67108864L)) {
            rendererState.style.stopColor = style.stopColor;
        }
        if (isSpecified(style, 134217728L)) {
            rendererState.style.stopOpacity = style.stopOpacity;
        }
        if (isSpecified(style, 8589934592L)) {
            rendererState.style.viewportFill = style.viewportFill;
        }
        if (isSpecified(style, 17179869184L)) {
            rendererState.style.viewportFillOpacity = style.viewportFillOpacity;
        }
        if (isSpecified(style, 137438953472L)) {
            rendererState.style.imageRendering = style.imageRendering;
        }
    }

    public void updateStyleForElement(RendererState rendererState, SVG.SvgElementBase svgElementBase) {
        int i = 0;
        boolean z = svgElementBase.parent == null;
        SVG.Style style = rendererState.style;
        Float fValueOf = Float.valueOf(1.0f);
        Boolean bool = Boolean.TRUE;
        style.display = bool;
        if (!z) {
            bool = Boolean.FALSE;
        }
        style.overflow = bool;
        style.clip = null;
        style.clipPath = null;
        style.opacity = fValueOf;
        style.stopColor = SVG.Colour.BLACK;
        style.stopOpacity = fValueOf;
        style.mask = null;
        style.solidColor = null;
        style.solidOpacity = fValueOf;
        style.viewportFill = null;
        style.viewportFillOpacity = fValueOf;
        style.vectorEffect = 1;
        SVG.Style style2 = svgElementBase.baseStyle;
        if (style2 != null) {
            updateStyle(rendererState, style2);
        }
        ArrayList arrayList = (ArrayList) ((ConnectionPool) ((SVG) this.document).cssRules).delegate;
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = (ArrayList) ((ConnectionPool) ((SVG) this.document).cssRules).delegate;
            int size = arrayList2.size();
            while (i < size) {
                Object obj = arrayList2.get(i);
                i++;
                CSSParser.Rule rule = (CSSParser.Rule) obj;
                if (CSSParser.ruleMatch(rule.selector, svgElementBase)) {
                    updateStyle(rendererState, rule.style);
                }
            }
        }
        SVG.Style style3 = svgElementBase.style;
        if (style3 != null) {
            updateStyle(rendererState, style3);
        }
    }

    public void viewportFill() {
        int iColourWithOpacity;
        SVG.Style style = ((RendererState) this.state).style;
        SVG.SvgPaint svgPaint = style.viewportFill;
        if (svgPaint instanceof SVG.Colour) {
            iColourWithOpacity = ((SVG.Colour) svgPaint).colour;
        } else if (!(svgPaint instanceof SVG.CurrentColor)) {
            return;
        } else {
            iColourWithOpacity = style.color.colour;
        }
        Float f = style.viewportFillOpacity;
        if (f != null) {
            iColourWithOpacity = colourWithOpacity(iColourWithOpacity, f.floatValue());
        }
        ((Canvas) this.canvas).drawColor(iColourWithOpacity);
    }

    public boolean visible() {
        Boolean bool = ((RendererState) this.state).style.visibility;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public void findInheritFromAncestorState(SVG.SvgObject svgObject, RendererState rendererState) {
        int i;
        ArrayList arrayList = new ArrayList();
        while (true) {
            i = 0;
            if (svgObject instanceof SVG.SvgElementBase) {
                arrayList.add(0, (SVG.SvgElementBase) svgObject);
            }
            Object obj = svgObject.parent;
            if (obj == null) {
                break;
            } else {
                svgObject = (SVG.SvgObject) obj;
            }
        }
        int size = arrayList.size();
        while (i < size) {
            Object obj2 = arrayList.get(i);
            i++;
            updateStyleForElement(rendererState, (SVG.SvgElementBase) obj2);
        }
        RendererState rendererState2 = (RendererState) this.state;
        rendererState.viewBox = rendererState2.viewBox;
        rendererState.viewPort = rendererState2.viewPort;
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class PlainTextToPath extends zzik {
        public final /* synthetic */ int $r8$classId;
        public final Object textAsPath;
        public final /* synthetic */ SVGAndroidRenderer this$0;
        public float x;
        public final float y;

        public PlainTextToPath(SVGAndroidRenderer sVGAndroidRenderer, float f, float f2) {
            this.$r8$classId = 1;
            this.this$0 = sVGAndroidRenderer;
            this.textAsPath = new RectF();
            this.x = f;
            this.y = f2;
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzik
        public final boolean doTextContainer(SVG.TextContainer textContainer) {
            switch (this.$r8$classId) {
                case 0:
                    if (!(textContainer instanceof SVG.TextPath)) {
                        return true;
                    }
                    Log.w("SVGAndroidRenderer", "Using <textPath> elements in a clip path is not supported.");
                    return false;
                default:
                    if (!(textContainer instanceof SVG.TextPath)) {
                        return true;
                    }
                    SVG.TextPath textPath = (SVG.TextPath) textContainer;
                    SVG.SvgElementBase svgElementBaseResolveIRI = textContainer.document.resolveIRI(textPath.href);
                    if (svgElementBaseResolveIRI == null) {
                        SVGAndroidRenderer.error("TextPath path reference '%s' not found", textPath.href);
                        return false;
                    }
                    SVG.Path path = (SVG.Path) svgElementBaseResolveIRI;
                    PathConverter pathConverter = new PathConverter(path.d);
                    Matrix matrix = path.transform;
                    Path path2 = pathConverter.path;
                    if (matrix != null) {
                        path2.transform(matrix);
                    }
                    RectF rectF = new RectF();
                    path2.computeBounds(rectF, true);
                    ((RectF) this.textAsPath).union(rectF);
                    return false;
            }
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzik
        public final void processText(String str) {
            String str2;
            switch (this.$r8$classId) {
                case 0:
                    SVGAndroidRenderer sVGAndroidRenderer = this.this$0;
                    if (sVGAndroidRenderer.visible()) {
                        Path path = new Path();
                        str2 = str;
                        ((RendererState) sVGAndroidRenderer.state).fillPaint.getTextPath(str2, 0, str.length(), this.x, this.y, path);
                        ((Path) this.textAsPath).addPath(path);
                    } else {
                        str2 = str;
                    }
                    this.x = ((RendererState) sVGAndroidRenderer.state).fillPaint.measureText(str2) + this.x;
                    break;
                default:
                    SVGAndroidRenderer sVGAndroidRenderer2 = this.this$0;
                    if (sVGAndroidRenderer2.visible()) {
                        Rect rect = new Rect();
                        ((RendererState) sVGAndroidRenderer2.state).fillPaint.getTextBounds(str, 0, str.length(), rect);
                        RectF rectF = new RectF(rect);
                        rectF.offset(this.x, this.y);
                        ((RectF) this.textAsPath).union(rectF);
                    }
                    this.x = ((RendererState) sVGAndroidRenderer2.state).fillPaint.measureText(str) + this.x;
                    break;
            }
        }

        public PlainTextToPath(SVGAndroidRenderer sVGAndroidRenderer, float f, float f2, Path path) {
            this.$r8$classId = 0;
            this.this$0 = sVGAndroidRenderer;
            this.x = f;
            this.y = f2;
            this.textAsPath = path;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class MarkerVector {
        public float dx;
        public float dy;
        public boolean isAmbiguous = false;
        public final float x;
        public final float y;

        public MarkerVector(float f, float f2, float f3, float f4) {
            this.dx = 0.0f;
            this.dy = 0.0f;
            this.x = f;
            this.y = f2;
            double dSqrt = Math.sqrt((f4 * f4) + (f3 * f3));
            if (dSqrt != 0.0d) {
                this.dx = (float) (((double) f3) / dSqrt);
                this.dy = (float) (((double) f4) / dSqrt);
            }
        }

        public final void add(float f, float f2) {
            float f3 = f - this.x;
            float f4 = f2 - this.y;
            double dSqrt = Math.sqrt((f4 * f4) + (f3 * f3));
            if (dSqrt != 0.0d) {
                f3 = (float) (((double) f3) / dSqrt);
                f4 = (float) (((double) f4) / dSqrt);
            }
            float f5 = this.dx;
            if (f3 != (-f5) || f4 != (-this.dy)) {
                this.dx = f5 + f3;
                this.dy += f4;
            } else {
                this.isAmbiguous = true;
                this.dx = -f4;
                this.dy = f3;
            }
        }

        public final String toString() {
            return "(" + this.x + "," + this.y + " " + this.dx + "," + this.dy + ")";
        }

        public final void add(MarkerVector markerVector) {
            float f = markerVector.dx;
            float f2 = this.dx;
            if (f == (-f2)) {
                float f3 = markerVector.dy;
                if (f3 == (-this.dy)) {
                    this.isAmbiguous = true;
                    this.dx = -f3;
                    this.dy = markerVector.dx;
                    return;
                }
            }
            this.dx = f2 + f;
            this.dy += markerVector.dy;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class RendererState {
        public final Paint fillPaint;
        public boolean hasFill;
        public boolean hasStroke;
        public boolean spacePreserve;
        public final Paint strokePaint;
        public final SVG.Style style;
        public SVG.Box viewBox;
        public SVG.Box viewPort;

        public RendererState() {
            Paint paint = new Paint();
            this.fillPaint = paint;
            paint.setFlags(193);
            paint.setHinting(0);
            paint.setStyle(Paint.Style.FILL);
            Typeface typeface = Typeface.DEFAULT;
            paint.setTypeface(typeface);
            Paint paint2 = new Paint();
            this.strokePaint = paint2;
            paint2.setFlags(193);
            paint2.setHinting(0);
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setTypeface(typeface);
            this.style = SVG.Style.getDefaultStyle();
        }

        public RendererState(RendererState rendererState) {
            this.hasFill = rendererState.hasFill;
            this.hasStroke = rendererState.hasStroke;
            this.fillPaint = new Paint(rendererState.fillPaint);
            this.strokePaint = new Paint(rendererState.strokePaint);
            SVG.Box box = rendererState.viewPort;
            if (box != null) {
                this.viewPort = new SVG.Box(box);
            }
            SVG.Box box2 = rendererState.viewBox;
            if (box2 != null) {
                this.viewBox = new SVG.Box(box2);
            }
            this.spacePreserve = rendererState.spacePreserve;
            try {
                this.style = (SVG.Style) rendererState.style.clone();
            } catch (CloneNotSupportedException e) {
                Log.e("SVGAndroidRenderer", "Unexpected clone error", e);
                this.style = SVG.Style.getDefaultStyle();
            }
        }
    }

    public static void fillInChainedGradientFields(SVG.SvgRadialGradient svgRadialGradient, SVG.SvgRadialGradient svgRadialGradient2) {
        if (svgRadialGradient.cx == null) {
            svgRadialGradient.cx = svgRadialGradient2.cx;
        }
        if (svgRadialGradient.cy == null) {
            svgRadialGradient.cy = svgRadialGradient2.cy;
        }
        if (svgRadialGradient.r == null) {
            svgRadialGradient.r = svgRadialGradient2.r;
        }
        if (svgRadialGradient.fx == null) {
            svgRadialGradient.fx = svgRadialGradient2.fx;
        }
        if (svgRadialGradient.fy == null) {
            svgRadialGradient.fy = svgRadialGradient2.fy;
        }
    }

    public Path makePathAndBoundingBox(SVG.Circle circle) {
        SVG.Length length = circle.cx;
        float fFloatValueX = length != null ? length.floatValueX(this) : 0.0f;
        SVG.Length length2 = circle.cy;
        float fFloatValueY = length2 != null ? length2.floatValueY(this) : 0.0f;
        float fFloatValue = circle.r.floatValue(this);
        float f = fFloatValueX - fFloatValue;
        float f2 = fFloatValueY - fFloatValue;
        float f3 = fFloatValueX + fFloatValue;
        float f4 = fFloatValueY + fFloatValue;
        if (circle.boundingBox == null) {
            float f5 = 2.0f * fFloatValue;
            circle.boundingBox = new SVG.Box(f, f2, f5, f5);
        }
        float f6 = fFloatValue * 0.5522848f;
        Path path = new Path();
        path.moveTo(fFloatValueX, f2);
        float f7 = fFloatValueX + f6;
        float f8 = fFloatValueY - f6;
        path.cubicTo(f7, f2, f3, f8, f3, fFloatValueY);
        float f9 = fFloatValueY + f6;
        path.cubicTo(f3, f9, f7, f4, fFloatValueX, f4);
        float f10 = fFloatValueX - f6;
        path.cubicTo(f10, f4, f, f9, f, fFloatValueY);
        path.cubicTo(f, f8, f10, f2, fFloatValueX, f2);
        path.close();
        return path;
    }

    public Path makePathAndBoundingBox(SVG.Ellipse ellipse) {
        SVG.Length length = ellipse.cx;
        float fFloatValueX = length != null ? length.floatValueX(this) : 0.0f;
        SVG.Length length2 = ellipse.cy;
        float fFloatValueY = length2 != null ? length2.floatValueY(this) : 0.0f;
        float fFloatValueX2 = ellipse.rx.floatValueX(this);
        float fFloatValueY2 = ellipse.ry.floatValueY(this);
        float f = fFloatValueX - fFloatValueX2;
        float f2 = fFloatValueY - fFloatValueY2;
        float f3 = fFloatValueX + fFloatValueX2;
        float f4 = fFloatValueY + fFloatValueY2;
        if (ellipse.boundingBox == null) {
            ellipse.boundingBox = new SVG.Box(f, f2, fFloatValueX2 * 2.0f, 2.0f * fFloatValueY2);
        }
        float f5 = fFloatValueX2 * 0.5522848f;
        float f6 = fFloatValueY2 * 0.5522848f;
        Path path = new Path();
        path.moveTo(fFloatValueX, f2);
        float f7 = fFloatValueX + f5;
        float f8 = fFloatValueY - f6;
        path.cubicTo(f7, f2, f3, f8, f3, fFloatValueY);
        float f9 = fFloatValueY + f6;
        path.cubicTo(f3, f9, f7, f4, fFloatValueX, f4);
        float f10 = fFloatValueX - f5;
        path.cubicTo(f10, f4, f, f9, f, fFloatValueY);
        path.cubicTo(f, f8, f10, f2, fFloatValueX, f2);
        path.close();
        return path;
    }

    public static Path makePathAndBoundingBox(SVG.PolyLine polyLine) {
        Path path = new Path();
        float[] fArr = polyLine.points;
        path.moveTo(fArr[0], fArr[1]);
        int i = 2;
        while (true) {
            float[] fArr2 = polyLine.points;
            if (i >= fArr2.length) {
                break;
            }
            path.lineTo(fArr2[i], fArr2[i + 1]);
            i += 2;
        }
        if (polyLine instanceof SVG.Polygon) {
            path.close();
        }
        if (polyLine.boundingBox == null) {
            polyLine.boundingBox = calculatePathBounds(path);
        }
        return path;
    }

    public void render(SVG.Svg svg, SVG.Box box, SVG.Box box2, PreserveAspectRatio preserveAspectRatio) {
        Canvas canvas = (Canvas) this.canvas;
        if (box.width == 0.0f || box.height == 0.0f) {
            return;
        }
        if (preserveAspectRatio == null && (preserveAspectRatio = svg.preserveAspectRatio) == null) {
            preserveAspectRatio = PreserveAspectRatio.LETTERBOX;
        }
        updateStyleForElement((RendererState) this.state, svg);
        if (display()) {
            RendererState rendererState = (RendererState) this.state;
            rendererState.viewPort = box;
            if (!rendererState.style.overflow.booleanValue()) {
                SVG.Box box3 = ((RendererState) this.state).viewPort;
                setClipRect(box3.minX, box3.minY, box3.width, box3.height);
            }
            checkForClipPath(svg, ((RendererState) this.state).viewPort);
            if (box2 != null) {
                canvas.concat(calculateViewBoxTransform(((RendererState) this.state).viewPort, box2, preserveAspectRatio));
                ((RendererState) this.state).viewBox = svg.viewBox;
            } else {
                SVG.Box box4 = ((RendererState) this.state).viewPort;
                canvas.translate(box4.minX, box4.minY);
            }
            boolean zPushLayer = pushLayer();
            viewportFill();
            renderChildren(svg, true);
            if (zPushLayer) {
                popLayer(svg.boundingBox);
            }
            updateParentBoundingBox(svg);
        }
    }
}
