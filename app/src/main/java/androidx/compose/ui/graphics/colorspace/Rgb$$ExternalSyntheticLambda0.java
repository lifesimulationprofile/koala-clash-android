package androidx.compose.ui.graphics.colorspace;

import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Rgb$$ExternalSyntheticLambda0 implements DoubleFunction {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Rgb f$0;

    public /* synthetic */ Rgb$$ExternalSyntheticLambda0(Rgb rgb, int i) {
        this.$r8$classId = i;
        this.f$0 = rgb;
    }

    @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
    public final double invoke(double d) {
        switch (this.$r8$classId) {
            case 0:
                Rgb rgb = this.f$0;
                return RangesKt.coerceIn(rgb.oetfOrig.invoke(d), rgb.min, rgb.max);
            default:
                Rgb rgb2 = this.f$0;
                return rgb2.eotfOrig.invoke(RangesKt.coerceIn(d, rgb2.min, rgb2.max));
        }
    }
}
