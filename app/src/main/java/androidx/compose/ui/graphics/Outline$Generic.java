package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class Outline$Generic extends BrushKt {
    public final AndroidPath path;

    public Outline$Generic(AndroidPath androidPath) {
        this.path = androidPath;
    }

    @Override // androidx.compose.ui.graphics.BrushKt
    public final Rect getBounds() {
        return this.path.getBounds();
    }
}
