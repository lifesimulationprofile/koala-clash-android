package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public class Connector {
    public final ColorSpace destination;
    public final float[] transform;
    public final ColorSpace transformDestination;
    public final ColorSpace transformSource;

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class RgbConnector extends Connector {
        public final Rgb mDestination;
        public final Rgb mSource;
        public final float[] mTransform;

        public RgbConnector(Rgb rgb, Rgb rgb2) {
            float[] fArrMul3x3;
            super(rgb2, rgb, rgb2, null);
            this.mSource = rgb;
            this.mDestination = rgb2;
            float[] fArr = Adaptation$Companion$Bradford$1.Bradford.transform;
            WhitePoint whitePoint = rgb.whitePoint;
            float[] fArr2 = rgb.transform;
            WhitePoint whitePoint2 = rgb2.whitePoint;
            float[] fArr3 = rgb2.inverseTransform;
            if (Illuminant.compare(whitePoint, whitePoint2)) {
                fArrMul3x3 = Illuminant.mul3x3(fArr3, fArr2);
            } else {
                float[] xyz$ui_graphics = whitePoint.toXyz$ui_graphics();
                float[] xyz$ui_graphics2 = whitePoint2.toXyz$ui_graphics();
                WhitePoint whitePoint3 = Illuminant.D50;
                fArrMul3x3 = Illuminant.mul3x3(Illuminant.compare(whitePoint2, whitePoint3) ? fArr3 : Illuminant.inverse3x3(Illuminant.mul3x3(Illuminant.chromaticAdaptation(fArr, xyz$ui_graphics2, new float[]{0.964212f, 1.0f, 0.825188f}), rgb2.transform)), Illuminant.compare(whitePoint, whitePoint3) ? fArr2 : Illuminant.mul3x3(Illuminant.chromaticAdaptation(fArr, xyz$ui_graphics, new float[]{0.964212f, 1.0f, 0.825188f}), fArr2));
            }
            this.mTransform = fArrMul3x3;
        }

        @Override // androidx.compose.ui.graphics.colorspace.Connector
        /* JADX INFO: renamed from: transformToColor-l2rxGTc$ui_graphics */
        public final long mo456transformToColorl2rxGTc$ui_graphics(long j) {
            float fM438getRedimpl = Color.m438getRedimpl(j);
            float fM437getGreenimpl = Color.m437getGreenimpl(j);
            float fM435getBlueimpl = Color.m435getBlueimpl(j);
            float fM434getAlphaimpl = Color.m434getAlphaimpl(j);
            Rgb$$ExternalSyntheticLambda0 rgb$$ExternalSyntheticLambda0 = this.mSource.eotfFunc;
            float fInvoke = (float) rgb$$ExternalSyntheticLambda0.invoke(fM438getRedimpl);
            float fInvoke2 = (float) rgb$$ExternalSyntheticLambda0.invoke(fM437getGreenimpl);
            float fInvoke3 = (float) rgb$$ExternalSyntheticLambda0.invoke(fM435getBlueimpl);
            float[] fArr = this.mTransform;
            float f = (fArr[6] * fInvoke3) + (fArr[3] * fInvoke2) + (fArr[0] * fInvoke);
            float f2 = (fArr[7] * fInvoke3) + (fArr[4] * fInvoke2) + (fArr[1] * fInvoke);
            float f3 = (fArr[8] * fInvoke3) + (fArr[5] * fInvoke2) + (fArr[2] * fInvoke);
            Rgb rgb = this.mDestination;
            float fInvoke4 = (float) rgb.oetfFunc.invoke(f);
            Rgb$$ExternalSyntheticLambda0 rgb$$ExternalSyntheticLambda1 = rgb.oetfFunc;
            return BrushKt.Color(fInvoke4, (float) rgb$$ExternalSyntheticLambda1.invoke(f2), (float) rgb$$ExternalSyntheticLambda1.invoke(f3), fM434getAlphaimpl, rgb);
        }
    }

    public Connector(ColorSpace colorSpace, ColorSpace colorSpace2, ColorSpace colorSpace3, float[] fArr) {
        this.destination = colorSpace;
        this.transformSource = colorSpace2;
        this.transformDestination = colorSpace3;
        this.transform = fArr;
    }

    /* JADX INFO: renamed from: transformToColor-l2rxGTc$ui_graphics, reason: not valid java name */
    public long mo456transformToColorl2rxGTc$ui_graphics(long j) {
        float fM438getRedimpl = Color.m438getRedimpl(j);
        float fM437getGreenimpl = Color.m437getGreenimpl(j);
        float fM435getBlueimpl = Color.m435getBlueimpl(j);
        float fM434getAlphaimpl = Color.m434getAlphaimpl(j);
        ColorSpace colorSpace = this.transformSource;
        long xy$ui_graphics = colorSpace.toXy$ui_graphics(fM438getRedimpl, fM437getGreenimpl, fM435getBlueimpl);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (xy$ui_graphics >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (xy$ui_graphics & 4294967295L));
        float z$ui_graphics = colorSpace.toZ$ui_graphics(fM438getRedimpl, fM437getGreenimpl, fM435getBlueimpl);
        float[] fArr = this.transform;
        if (fArr != null) {
            fIntBitsToFloat *= fArr[0];
            fIntBitsToFloat2 *= fArr[1];
            z$ui_graphics *= fArr[2];
        }
        float f = fIntBitsToFloat;
        float f2 = fIntBitsToFloat2;
        return this.transformDestination.mo455xyzaToColorJlNiLsg$ui_graphics(f, f2, z$ui_graphics, fM434getAlphaimpl, this.destination);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0069  */
    /* JADX WARN: Illegal instructions before constructor call */
    public Connector(ColorSpace colorSpace, ColorSpace colorSpace2, int i) {
        float[] fArr;
        long j = colorSpace.model;
        long j2 = ColorModel.Rgb;
        ColorSpace colorSpaceAdapt$default = ColorModel.m453equalsimpl0(j, j2) ? Illuminant.adapt$default(colorSpace) : colorSpace;
        ColorSpace colorSpaceAdapt$default2 = ColorModel.m453equalsimpl0(colorSpace2.model, j2) ? Illuminant.adapt$default(colorSpace2) : colorSpace2;
        if (i == 3) {
            boolean zM453equalsimpl0 = ColorModel.m453equalsimpl0(colorSpace.model, j2);
            boolean zM453equalsimpl1 = ColorModel.m453equalsimpl0(colorSpace2.model, j2);
            if (!(zM453equalsimpl0 && zM453equalsimpl1) && (zM453equalsimpl0 || zM453equalsimpl1)) {
                WhitePoint whitePoint = ((Rgb) (zM453equalsimpl0 ? colorSpace : colorSpace2)).whitePoint;
                float[] xyz$ui_graphics = Illuminant.D50Xyz;
                float[] xyz$ui_graphics2 = zM453equalsimpl0 ? whitePoint.toXyz$ui_graphics() : xyz$ui_graphics;
                xyz$ui_graphics = zM453equalsimpl1 ? whitePoint.toXyz$ui_graphics() : xyz$ui_graphics;
                fArr = new float[]{xyz$ui_graphics2[0] / xyz$ui_graphics[0], xyz$ui_graphics2[1] / xyz$ui_graphics[1], xyz$ui_graphics2[2] / xyz$ui_graphics[2]};
            } else {
                fArr = null;
            }
        } else {
            fArr = null;
        }
        this(colorSpace2, colorSpaceAdapt$default, colorSpaceAdapt$default2, fArr);
    }
}
