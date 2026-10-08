package androidx.compose.foundation.shape;

import androidx.compose.ui.unit.Density;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class PxCornerSize implements CornerSize {
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PxCornerSize) && Float.compare(0.0f, 0.0f) == 0;
    }

    public final int hashCode() {
        return Float.floatToIntBits(0.0f);
    }

    @Override // androidx.compose.foundation.shape.CornerSize
    /* JADX INFO: renamed from: toPx-TmRCtEA */
    public final float mo155toPxTmRCtEA(long j, Density density) {
        return 0.0f;
    }

    public final String toString() {
        return "CornerSize(size = 0.0.px)";
    }
}
