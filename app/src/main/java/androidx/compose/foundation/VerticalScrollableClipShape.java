package androidx.compose.foundation;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Outline$Rectangle;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class VerticalScrollableClipShape implements Shape {
    public final /* synthetic */ int $r8$classId;
    public static final VerticalScrollableClipShape INSTANCE$1 = new VerticalScrollableClipShape(1);
    public static final VerticalScrollableClipShape INSTANCE = new VerticalScrollableClipShape(0);

    public /* synthetic */ VerticalScrollableClipShape(int i) {
        this.$r8$classId = i;
    }

    @Override // androidx.compose.ui.graphics.Shape
    /* JADX INFO: renamed from: createOutline-Pq9zytI, reason: not valid java name */
    public final BrushKt mo57createOutlinePq9zytI(long j, LayoutDirection layoutDirection, Density density) {
        switch (this.$r8$classId) {
            case 0:
                float fMo83roundToPx0680j_4 = density.mo83roundToPx0680j_4(ClipScrollableContainerKt.MaxSupportedElevation);
                return new Outline$Rectangle(new Rect(-fMo83roundToPx0680j_4, 0.0f, Float.intBitsToFloat((int) (j >> 32)) + fMo83roundToPx0680j_4, Float.intBitsToFloat((int) (j & 4294967295L))));
            default:
                float fMo83roundToPx0680j_5 = density.mo83roundToPx0680j_4(ClipScrollableContainerKt.MaxSupportedElevation);
                return new Outline$Rectangle(new Rect(0.0f, -fMo83roundToPx0680j_5, Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)) + fMo83roundToPx0680j_5));
        }
    }
}
