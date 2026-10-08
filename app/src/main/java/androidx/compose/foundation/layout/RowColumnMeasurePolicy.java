package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface RowColumnMeasurePolicy {
    /* JADX INFO: renamed from: createConstraints-xF2OJ5Q */
    long mo110createConstraintsxF2OJ5Q(int i, int i2, int i3, boolean z);

    int crossAxisSize(Placeable placeable);

    int mainAxisSize(Placeable placeable);

    MeasureResult placeHelper(Placeable[] placeableArr, MeasureScope measureScope, int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5);

    void populateMainAxisPositions(int i, MeasureScope measureScope, int[] iArr, int[] iArr2);
}
