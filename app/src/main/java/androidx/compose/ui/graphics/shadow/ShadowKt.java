package androidx.compose.ui.graphics.shadow;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Interpolatable;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ShadowKt {
    /* JADX WARN: Code duplicated, block: B:19:0x0081  */
    public static final Shadow lerpNonNull(Shadow shadow, Shadow shadow2, float f) {
        float fLerp = MathHelpersKt.lerp(shadow.radius, shadow2.radius, f);
        float fLerp2 = MathHelpersKt.lerp(shadow.spread, shadow2.spread, f);
        long j = shadow.offset;
        long j2 = shadow2.offset;
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(MathHelpersKt.lerp(DpOffset.m704getXD9Ej5fM(j), DpOffset.m704getXD9Ej5fM(j2), f))) << 32) | (((long) Float.floatToRawIntBits(MathHelpersKt.lerp(DpOffset.m705getYD9Ej5fM(j), DpOffset.m705getYD9Ej5fM(j2), f))) & 4294967295L);
        long jM417lerpjxsXWHM = BrushKt.m417lerpjxsXWHM(shadow.color, shadow2.color, f);
        Object obj = shadow.brush;
        Object obj2 = shadow2.brush;
        if (!Intrinsics.areEqual(obj, obj2)) {
            Object objLerp = obj instanceof Interpolatable ? ((Interpolatable) obj).lerp(obj2, f) : null;
            if (objLerp == null && (obj2 instanceof Interpolatable)) {
                objLerp = ((Interpolatable) obj2).lerp(obj, 1 - f);
            }
            if (objLerp != null) {
                obj = objLerp;
            } else if (f >= 0.5f) {
                obj = obj2;
            }
        } else if (f >= 0.5f) {
            obj = obj2;
        }
        return new Shadow(fLerp, fLerp2, jFloatToRawIntBits, jM417lerpjxsXWHM, obj instanceof Brush ? (Brush) obj : null, MathHelpersKt.lerp(shadow.alpha, shadow2.alpha, f), f < 0.5f ? shadow.blendMode : shadow2.blendMode);
    }
}
