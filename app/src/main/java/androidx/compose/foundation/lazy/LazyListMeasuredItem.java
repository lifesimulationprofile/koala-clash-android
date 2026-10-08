package androidx.compose.foundation.lazy;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.PlaceableKt;
import androidx.compose.ui.layout.RootMeasurePolicy$measure$1;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import coil.network.HttpException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class LazyListMeasuredItem {
    public final LazyLayoutItemAnimator animator;
    public final Object contentType;
    public final int crossAxisSize;
    public final Alignment.Horizontal horizontalAlignment;
    public final int index;
    public final Object key;
    public final LayoutDirection layoutDirection;
    public int mainAxisLayoutSize = Integer.MIN_VALUE;
    public final int mainAxisSizeWithSpacings;
    public boolean nonScrollableItem;
    public int offset;
    public final int[] placeableOffsets;
    public final List placeables;
    public final boolean reverseLayout;
    public final int size;
    public final int spacing;
    public final long visualOffset;

    public LazyListMeasuredItem(int i, List list, Alignment.Horizontal horizontal, LayoutDirection layoutDirection, boolean z, int i2, int i3, int i4, long j, Object obj, Object obj2, LazyLayoutItemAnimator lazyLayoutItemAnimator, long j2) {
        this.index = i;
        this.placeables = list;
        this.horizontalAlignment = horizontal;
        this.layoutDirection = layoutDirection;
        this.reverseLayout = z;
        this.spacing = i4;
        this.visualOffset = j;
        this.key = obj;
        this.contentType = obj2;
        this.animator = lazyLayoutItemAnimator;
        int size = list.size();
        int i5 = 0;
        int iMax = 0;
        for (int i6 = 0; i6 < size; i6++) {
            Placeable placeable = (Placeable) list.get(i6);
            i5 += placeable.height;
            iMax = Math.max(iMax, placeable.width);
        }
        this.size = i5;
        int i7 = i5 + this.spacing;
        this.mainAxisSizeWithSpacings = i7 >= 0 ? i7 : 0;
        this.crossAxisSize = iMax;
        this.placeableOffsets = new int[this.placeables.size() * 2];
    }

    /* JADX INFO: renamed from: getOffset-Bjo55l4, reason: not valid java name */
    public final long m146getOffsetBjo55l4(int i) {
        int i2;
        long j;
        if (i == 0 && this.placeables.size() == 0) {
            i2 = this.offset;
            j = 0;
        } else {
            int i3 = i * 2;
            int[] iArr = this.placeableOffsets;
            int i4 = iArr[i3];
            i2 = iArr[i3 + 1];
            j = i4;
        }
        return (4294967295L & ((long) i2)) | (j << 32);
    }

    public final void place(Placeable.PlacementScope placementScope) {
        RootMeasurePolicy$measure$1 rootMeasurePolicy$measure$1 = RootMeasurePolicy$measure$1.INSTANCE$1;
        if (this.mainAxisLayoutSize == Integer.MIN_VALUE) {
            InlineClassHelperKt.throwIllegalArgumentException("position() should be called first");
        }
        List list = this.placeables;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Placeable placeable = (Placeable) list.get(i);
            int i2 = placeable.height;
            long jM146getOffsetBjo55l4 = m146getOffsetBjo55l4(i);
            Modifier.CC.m(this.animator.keyToItemInfoMap.get(this.key));
            if (this.reverseLayout) {
                int i3 = (int) (jM146getOffsetBjo55l4 >> 32);
                jM146getOffsetBjo55l4 = (((long) ((this.mainAxisLayoutSize - ((int) (jM146getOffsetBjo55l4 & 4294967295L))) - placeable.height)) & 4294967295L) | (((long) i3) << 32);
            }
            long jM711plusqkQi6aY = IntOffset.m711plusqkQi6aY(jM146getOffsetBjo55l4, this.visualOffset);
            int i4 = PlaceableKt.$r8$clinit;
            placementScope.getClass();
            Placeable.PlacementScope.access$handleMotionFrameOfReferencePlacement(placementScope, placeable);
            placeable.mo519placeAtf8xVGno(IntOffset.m711plusqkQi6aY(jM711plusqkQi6aY, placeable.apparentToRealOffset), 0.0f, rootMeasurePolicy$measure$1);
        }
    }

    public final void position(int i, int i2, int i3) {
        this.offset = i;
        this.mainAxisLayoutSize = i3;
        List list = this.placeables;
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            Placeable placeable = (Placeable) list.get(i4);
            int i5 = i4 * 2;
            Alignment.Horizontal horizontal = this.horizontalAlignment;
            if (horizontal == null) {
                InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null horizontalAlignment when isVertical == true");
                throw new HttpException();
            }
            int iAlign = horizontal.align(placeable.width, i2, this.layoutDirection);
            int[] iArr = this.placeableOffsets;
            iArr[i5] = iAlign;
            iArr[i5 + 1] = i;
            i += placeable.height;
        }
    }
}
