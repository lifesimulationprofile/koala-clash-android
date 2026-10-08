package androidx.compose.material3;

import androidx.compose.runtime.DynamicProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda10;
import androidx.compose.ui.unit.Dp;
import coil.ImageLoader$Builder$$ExternalSyntheticLambda2;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class RippleKt {
    public static final RippleNodeFactory DefaultBoundedRipple;
    public static final RippleNodeFactory DefaultUnboundedRipple;
    public static final DynamicProvidableCompositionLocal LocalRippleThemeConfiguration = new DynamicProvidableCompositionLocal(new ImageLoader$Builder$$ExternalSyntheticLambda2(1));
    public static final DynamicProvidableCompositionLocal LocalRippleConfiguration = new DynamicProvidableCompositionLocal(new SaversKt$$ExternalSyntheticLambda10(13));

    static {
        long j = Color.Unspecified;
        DefaultBoundedRipple = new RippleNodeFactory(true, Float.NaN, j, null, true, true, true, true);
        DefaultUnboundedRipple = new RippleNodeFactory(false, Float.NaN, j, null, true, true, true, true);
    }

    /* JADX INFO: renamed from: ripple-Ou1YvPQ$default, reason: not valid java name */
    public static RippleNodeFactory m259rippleOu1YvPQ$default(float f, long j, Shape shape, boolean z, int i) {
        boolean z2 = (i & 1) != 0;
        float f2 = (i & 2) != 0 ? Float.NaN : f;
        long j2 = (i & 4) != 0 ? Color.Unspecified : j;
        Shape shape2 = (i & 8) != 0 ? null : shape;
        boolean z3 = (i & 16) != 0;
        boolean z4 = (i & 32) != 0 ? true : z;
        boolean z5 = (i & 64) != 0;
        boolean z6 = (i & 128) != 0;
        if (Dp.m701equalsimpl0(f2, Float.NaN) && Color.m433equalsimpl0(j2, Color.Unspecified) && shape2 == null && z3 && z4 && z5 && z6) {
            return z2 ? DefaultBoundedRipple : DefaultUnboundedRipple;
        }
        return new RippleNodeFactory(z2, f2, j2, shape2, z3, z4, z5, z6);
    }
}
