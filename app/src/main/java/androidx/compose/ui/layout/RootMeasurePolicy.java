package androidx.compose.ui.layout;

import androidx.compose.ui.draw.PainterNode$measure$1;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.EmptyMap;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class RootMeasurePolicy extends LayoutNode.NoIntrinsicsMeasurePolicy {
    public static final RootMeasurePolicy INSTANCE = new RootMeasurePolicy("Undefined intrinsics block and it is required");

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo21measure3p2s80s(MeasureScope measureScope, List list, long j) {
        int size = list.size();
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        if (size == 0) {
            return measureScope.layout(Constraints.m683getMinWidthimpl(j), Constraints.m682getMinHeightimpl(j), emptyMap, RootMeasurePolicy$measure$1.INSTANCE);
        }
        if (size == 1) {
            Placeable placeableMo515measureBRTryo0 = ((Measurable) list.get(0)).mo515measureBRTryo0(j);
            return measureScope.layout(ConstraintsKt.m690constrainWidthK40F9xA(placeableMo515measureBRTryo0.width, j), ConstraintsKt.m689constrainHeightK40F9xA(placeableMo515measureBRTryo0.height, j), emptyMap, new PainterNode$measure$1(placeableMo515measureBRTryo0, 4));
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size2 = list.size();
        int iMax = 0;
        int iMax2 = 0;
        for (int i = 0; i < size2; i++) {
            Placeable placeableMo515measureBRTryo1 = ((Measurable) list.get(i)).mo515measureBRTryo0(j);
            iMax = Math.max(placeableMo515measureBRTryo1.width, iMax);
            iMax2 = Math.max(placeableMo515measureBRTryo1.height, iMax2);
            arrayList.add(placeableMo515measureBRTryo1);
        }
        return measureScope.layout(ConstraintsKt.m690constrainWidthK40F9xA(iMax, j), ConstraintsKt.m689constrainHeightK40F9xA(iMax2, j), emptyMap, new RootMeasurePolicy$measure$3(0, arrayList));
    }
}
