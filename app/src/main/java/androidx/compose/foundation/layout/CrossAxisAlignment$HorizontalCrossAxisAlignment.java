package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class CrossAxisAlignment$HorizontalCrossAxisAlignment extends OffsetKt {
    public final Alignment.Horizontal horizontal;

    public CrossAxisAlignment$HorizontalCrossAxisAlignment(BiasAlignment.Horizontal horizontal) {
        this.horizontal = horizontal;
    }

    @Override // androidx.compose.foundation.layout.OffsetKt
    public final int align$foundation_layout(int i, int i2, LayoutDirection layoutDirection) {
        return this.horizontal.align(i2, i, layoutDirection);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CrossAxisAlignment$HorizontalCrossAxisAlignment) && Intrinsics.areEqual(this.horizontal, ((CrossAxisAlignment$HorizontalCrossAxisAlignment) obj).horizontal);
    }

    public final int hashCode() {
        return this.horizontal.hashCode();
    }

    public final String toString() {
        return "HorizontalCrossAxisAlignment(horizontal=" + this.horizontal + ')';
    }
}
