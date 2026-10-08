package androidx.compose.ui.graphics;

import kotlin.ULong;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class SolidColor extends Brush implements Interpolatable {
    public final long value;

    public SolidColor(long j) {
        this.value = j;
    }

    @Override // androidx.compose.ui.graphics.Brush
    /* JADX INFO: renamed from: applyTo-Pq9zytI */
    public final void mo409applyToPq9zytI(float f, long j, AndroidPaint androidPaint) {
        androidPaint.setAlpha(1.0f);
        long jColor = this.value;
        if (f != 1.0f) {
            jColor = BrushKt.Color(Color.m438getRedimpl(jColor), Color.m437getGreenimpl(jColor), Color.m435getBlueimpl(jColor), Color.m434getAlphaimpl(jColor) * f, Color.m436getColorSpaceimpl(jColor));
        }
        androidPaint.m402setColor8_81llA(jColor);
        if (androidPaint.internalShader != null) {
            androidPaint.setShader(null);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SolidColor) {
            return Color.m433equalsimpl0(this.value, ((SolidColor) obj).value);
        }
        return false;
    }

    public final int hashCode() {
        int i = Color.$r8$clinit;
        return ULong.m836hashCodeimpl(this.value);
    }

    @Override // androidx.compose.ui.graphics.Interpolatable
    public final Object lerp(Object obj, float f) {
        if (obj == null) {
            obj = new SolidColor(Color.Transparent);
        }
        if (!(obj instanceof SolidColor)) {
            return null;
        }
        return new SolidColor(BrushKt.m417lerpjxsXWHM(this.value, ((SolidColor) obj).value, f));
    }

    public final String toString() {
        return "SolidColor(value=" + ((Object) Color.m439toStringimpl(this.value)) + ')';
    }
}
