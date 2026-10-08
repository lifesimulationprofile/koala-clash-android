package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class Outline$Rectangle extends BrushKt {
    public final Rect rect;

    public Outline$Rectangle(Rect rect) {
        this.rect = rect;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Outline$Rectangle) {
            return Intrinsics.areEqual(this.rect, ((Outline$Rectangle) obj).rect);
        }
        return false;
    }

    @Override // androidx.compose.ui.graphics.BrushKt
    public final Rect getBounds() {
        return this.rect;
    }

    public final int hashCode() {
        return this.rect.hashCode();
    }
}
