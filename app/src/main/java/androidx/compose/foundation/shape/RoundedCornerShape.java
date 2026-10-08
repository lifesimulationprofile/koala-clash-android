package androidx.compose.foundation.shape;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Interpolatable;
import androidx.compose.ui.graphics.Outline$Rectangle;
import androidx.compose.ui.graphics.Outline$Rounded;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class RoundedCornerShape implements Shape, Interpolatable {
    public final CornerSize bottomEnd;
    public final CornerSize bottomStart;
    public final CornerSize topEnd;
    public final CornerSize topStart;

    public RoundedCornerShape(CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4) {
        this.topStart = cornerSize;
        this.topEnd = cornerSize2;
        this.bottomEnd = cornerSize3;
        this.bottomStart = cornerSize4;
    }

    public static RoundedCornerShape copy$default(RoundedCornerShape roundedCornerShape, CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4, int i) {
        if ((i & 1) != 0) {
            cornerSize = roundedCornerShape.topStart;
        }
        if ((i & 2) != 0) {
            cornerSize2 = roundedCornerShape.topEnd;
        }
        if ((i & 4) != 0) {
            cornerSize3 = roundedCornerShape.bottomEnd;
        }
        if ((i & 8) != 0) {
            cornerSize4 = roundedCornerShape.bottomStart;
        }
        roundedCornerShape.getClass();
        return new RoundedCornerShape(cornerSize, cornerSize2, cornerSize3, cornerSize4);
    }

    @Override // androidx.compose.ui.graphics.Shape
    /* JADX INFO: renamed from: createOutline-Pq9zytI */
    public final BrushKt mo57createOutlinePq9zytI(long j, LayoutDirection layoutDirection, Density density) {
        float fMo155toPxTmRCtEA = this.topStart.mo155toPxTmRCtEA(j, density);
        float fMo155toPxTmRCtEA2 = this.topEnd.mo155toPxTmRCtEA(j, density);
        float fMo155toPxTmRCtEA3 = this.bottomEnd.mo155toPxTmRCtEA(j, density);
        float fMo155toPxTmRCtEA4 = this.bottomStart.mo155toPxTmRCtEA(j, density);
        float fM384getMinDimensionimpl = Size.m384getMinDimensionimpl(j);
        float f = fMo155toPxTmRCtEA + fMo155toPxTmRCtEA4;
        if (f > fM384getMinDimensionimpl) {
            float f2 = fM384getMinDimensionimpl / f;
            fMo155toPxTmRCtEA *= f2;
            fMo155toPxTmRCtEA4 *= f2;
        }
        float f3 = fMo155toPxTmRCtEA2 + fMo155toPxTmRCtEA3;
        if (f3 > fM384getMinDimensionimpl) {
            float f4 = fM384getMinDimensionimpl / f3;
            fMo155toPxTmRCtEA2 *= f4;
            fMo155toPxTmRCtEA3 *= f4;
        }
        if (fMo155toPxTmRCtEA < 0.0f || fMo155toPxTmRCtEA2 < 0.0f || fMo155toPxTmRCtEA3 < 0.0f || fMo155toPxTmRCtEA4 < 0.0f) {
            InlineClassHelperKt.throwIllegalArgumentException("Corner size in Px can't be negative(topStart = " + fMo155toPxTmRCtEA + ", topEnd = " + fMo155toPxTmRCtEA2 + ", bottomEnd = " + fMo155toPxTmRCtEA3 + ", bottomStart = " + fMo155toPxTmRCtEA4 + ")!");
        }
        if (fMo155toPxTmRCtEA + fMo155toPxTmRCtEA2 + fMo155toPxTmRCtEA3 + fMo155toPxTmRCtEA4 == 0.0f) {
            return new Outline$Rectangle(RectKt.m380Recttz77jQw(0L, j));
        }
        Rect rectM380Recttz77jQw = RectKt.m380Recttz77jQw(0L, j);
        LayoutDirection layoutDirection2 = LayoutDirection.Ltr;
        float f5 = layoutDirection == layoutDirection2 ? fMo155toPxTmRCtEA : fMo155toPxTmRCtEA2;
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(f5)) << 32) | (((long) Float.floatToRawIntBits(f5)) & 4294967295L);
        if (layoutDirection == layoutDirection2) {
            fMo155toPxTmRCtEA = fMo155toPxTmRCtEA2;
        }
        long jFloatToRawIntBits2 = (((long) Float.floatToRawIntBits(fMo155toPxTmRCtEA)) << 32) | (((long) Float.floatToRawIntBits(fMo155toPxTmRCtEA)) & 4294967295L);
        float f6 = layoutDirection == layoutDirection2 ? fMo155toPxTmRCtEA3 : fMo155toPxTmRCtEA4;
        long jFloatToRawIntBits3 = (((long) Float.floatToRawIntBits(f6)) << 32) | (((long) Float.floatToRawIntBits(f6)) & 4294967295L);
        if (layoutDirection != layoutDirection2) {
            fMo155toPxTmRCtEA4 = fMo155toPxTmRCtEA3;
        }
        return new Outline$Rounded(new RoundRect(rectM380Recttz77jQw.left, rectM380Recttz77jQw.top, rectM380Recttz77jQw.right, rectM380Recttz77jQw.bottom, jFloatToRawIntBits, jFloatToRawIntBits2, jFloatToRawIntBits3, (((long) Float.floatToRawIntBits(fMo155toPxTmRCtEA4)) << 32) | (((long) Float.floatToRawIntBits(fMo155toPxTmRCtEA4)) & 4294967295L)));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RoundedCornerShape)) {
            return false;
        }
        RoundedCornerShape roundedCornerShape = (RoundedCornerShape) obj;
        return Intrinsics.areEqual(this.topStart, roundedCornerShape.topStart) && Intrinsics.areEqual(this.topEnd, roundedCornerShape.topEnd) && Intrinsics.areEqual(this.bottomEnd, roundedCornerShape.bottomEnd) && Intrinsics.areEqual(this.bottomStart, roundedCornerShape.bottomStart);
    }

    public final int hashCode() {
        return this.bottomStart.hashCode() + ((this.bottomEnd.hashCode() + ((this.topEnd.hashCode() + (this.topStart.hashCode() * 31)) * 31)) * 31);
    }

    @Override // androidx.compose.ui.graphics.Interpolatable
    public final Object lerp(Object obj, final float f) {
        if (Intrinsics.areEqual(obj, BrushKt.RectangleShape) || obj == null) {
            RoundedCornerShape roundedCornerShape = RoundedCornerShapeKt.CircleShape;
            PxCornerSize pxCornerSize = new PxCornerSize();
            obj = new RoundedCornerShape(pxCornerSize, pxCornerSize, pxCornerSize, pxCornerSize);
        }
        if (!(obj instanceof RoundedCornerShape)) {
            return null;
        }
        RoundedCornerShape roundedCornerShape2 = (RoundedCornerShape) obj;
        RoundedCornerShape roundedCornerShape3 = RoundedCornerShapeKt.CircleShape;
        final CornerSize cornerSize = roundedCornerShape2.topStart;
        final CornerSize cornerSize2 = this.topStart;
        CornerSize cornerSize3 = new CornerSize() { // from class: androidx.compose.foundation.shape.RoundedCornerShapeKt$lerp$1
            @Override // androidx.compose.foundation.shape.CornerSize
            /* JADX INFO: renamed from: toPx-TmRCtEA */
            public final float mo155toPxTmRCtEA(long j, Density density) {
                return MathHelpersKt.lerp(cornerSize2.mo155toPxTmRCtEA(j, density), cornerSize.mo155toPxTmRCtEA(j, density), f);
            }
        };
        final CornerSize cornerSize4 = roundedCornerShape2.topEnd;
        final CornerSize cornerSize5 = this.topEnd;
        CornerSize cornerSize6 = new CornerSize() { // from class: androidx.compose.foundation.shape.RoundedCornerShapeKt$lerp$1
            @Override // androidx.compose.foundation.shape.CornerSize
            /* JADX INFO: renamed from: toPx-TmRCtEA */
            public final float mo155toPxTmRCtEA(long j, Density density) {
                return MathHelpersKt.lerp(cornerSize5.mo155toPxTmRCtEA(j, density), cornerSize4.mo155toPxTmRCtEA(j, density), f);
            }
        };
        final CornerSize cornerSize7 = roundedCornerShape2.bottomEnd;
        final CornerSize cornerSize8 = this.bottomEnd;
        CornerSize cornerSize9 = new CornerSize() { // from class: androidx.compose.foundation.shape.RoundedCornerShapeKt$lerp$1
            @Override // androidx.compose.foundation.shape.CornerSize
            /* JADX INFO: renamed from: toPx-TmRCtEA */
            public final float mo155toPxTmRCtEA(long j, Density density) {
                return MathHelpersKt.lerp(cornerSize8.mo155toPxTmRCtEA(j, density), cornerSize7.mo155toPxTmRCtEA(j, density), f);
            }
        };
        final CornerSize cornerSize10 = roundedCornerShape2.bottomStart;
        final CornerSize cornerSize11 = this.bottomStart;
        return new RoundedCornerShape(cornerSize3, cornerSize6, cornerSize9, new CornerSize() { // from class: androidx.compose.foundation.shape.RoundedCornerShapeKt$lerp$1
            @Override // androidx.compose.foundation.shape.CornerSize
            /* JADX INFO: renamed from: toPx-TmRCtEA */
            public final float mo155toPxTmRCtEA(long j, Density density) {
                return MathHelpersKt.lerp(cornerSize11.mo155toPxTmRCtEA(j, density), cornerSize10.mo155toPxTmRCtEA(j, density), f);
            }
        });
    }

    public final String toString() {
        return "RoundedCornerShape(topStart = " + this.topStart + ", topEnd = " + this.topEnd + ", bottomEnd = " + this.bottomEnd + ", bottomStart = " + this.bottomStart + ')';
    }
}
