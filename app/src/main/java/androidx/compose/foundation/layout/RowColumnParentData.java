package androidx.compose.foundation.layout;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class RowColumnParentData {
    public float weight = 0.0f;
    public boolean fill = true;
    public CrossAxisAlignment$HorizontalCrossAxisAlignment crossAxisAlignment = null;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RowColumnParentData)) {
            return false;
        }
        RowColumnParentData rowColumnParentData = (RowColumnParentData) obj;
        return Float.compare(this.weight, rowColumnParentData.weight) == 0 && this.fill == rowColumnParentData.fill && Intrinsics.areEqual(this.crossAxisAlignment, rowColumnParentData.crossAxisAlignment);
    }

    public final int hashCode() {
        int iFloatToIntBits = ((Float.floatToIntBits(this.weight) * 31) + (this.fill ? 1231 : 1237)) * 31;
        CrossAxisAlignment$HorizontalCrossAxisAlignment crossAxisAlignment$HorizontalCrossAxisAlignment = this.crossAxisAlignment;
        return (iFloatToIntBits + (crossAxisAlignment$HorizontalCrossAxisAlignment == null ? 0 : crossAxisAlignment$HorizontalCrossAxisAlignment.horizontal.hashCode())) * 31;
    }

    public final String toString() {
        return "RowColumnParentData(weight=" + this.weight + ", fill=" + this.fill + ", crossAxisAlignment=" + this.crossAxisAlignment + ", flowLayoutData=null)";
    }
}
