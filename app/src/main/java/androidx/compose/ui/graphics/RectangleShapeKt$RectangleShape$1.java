package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class RectangleShapeKt$RectangleShape$1 implements Shape {
    @Override // androidx.compose.ui.graphics.Shape
    /* JADX INFO: renamed from: createOutline-Pq9zytI */
    public final BrushKt mo57createOutlinePq9zytI(long j, LayoutDirection layoutDirection, Density density) {
        return new Outline$Rectangle(RectKt.m380Recttz77jQw(0L, j));
    }

    public final String toString() {
        return "RectangleShape";
    }
}
