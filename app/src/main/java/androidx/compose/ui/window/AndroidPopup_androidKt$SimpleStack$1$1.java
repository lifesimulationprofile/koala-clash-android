package androidx.compose.ui.window;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.PainterNode$measure$1;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.RootMeasurePolicy$measure$3;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.EmptyMap;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidPopup_androidKt$SimpleStack$1$1 implements MeasurePolicy {
    public final /* synthetic */ int $r8$classId;
    public static final AndroidPopup_androidKt$SimpleStack$1$1 INSTANCE$1 = new AndroidPopup_androidKt$SimpleStack$1$1(1);
    public static final AndroidPopup_androidKt$SimpleStack$1$1 INSTANCE = new AndroidPopup_androidKt$SimpleStack$1$1(0);

    public /* synthetic */ AndroidPopup_androidKt$SimpleStack$1$1(int i) {
        this.$r8$classId = i;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        int i2 = this.$r8$classId;
        return Modifier.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, list, i);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        int i2 = this.$r8$classId;
        return Modifier.CC.$default$maxIntrinsicWidth(this, intrinsicMeasureScope, list, i);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo21measure3p2s80s(MeasureScope measureScope, List list, long j) {
        switch (this.$r8$classId) {
            case 0:
                int size = list.size();
                EmptyMap emptyMap = EmptyMap.INSTANCE;
                if (size == 0) {
                    return measureScope.layout(0, 0, emptyMap, AndroidPopup_androidKt$Popup$5$1$1.INSTANCE$4);
                }
                if (size == 1) {
                    Placeable placeableMo515measureBRTryo0 = ((Measurable) list.get(0)).mo515measureBRTryo0(j);
                    return measureScope.layout(placeableMo515measureBRTryo0.width, placeableMo515measureBRTryo0.height, emptyMap, new PainterNode$measure$1(placeableMo515measureBRTryo0, 6));
                }
                ArrayList arrayList = new ArrayList(list.size());
                int size2 = list.size();
                int iMax = 0;
                int iMax2 = 0;
                for (int i = 0; i < size2; i++) {
                    Placeable placeableMo515measureBRTryo1 = ((Measurable) list.get(i)).mo515measureBRTryo0(j);
                    iMax = Math.max(iMax, placeableMo515measureBRTryo1.width);
                    iMax2 = Math.max(iMax2, placeableMo515measureBRTryo1.height);
                    arrayList.add(placeableMo515measureBRTryo1);
                }
                return measureScope.layout(iMax, iMax2, emptyMap, new RootMeasurePolicy$measure$3(3, arrayList));
            default:
                ArrayList arrayList2 = new ArrayList(list.size());
                int size3 = list.size();
                int iM683getMinWidthimpl = 0;
                int iM682getMinHeightimpl = 0;
                for (int i2 = 0; i2 < size3; i2++) {
                    Placeable placeableMo515measureBRTryo2 = ((Measurable) list.get(i2)).mo515measureBRTryo0(j);
                    iM683getMinWidthimpl = Math.max(iM683getMinWidthimpl, placeableMo515measureBRTryo2.width);
                    iM682getMinHeightimpl = Math.max(iM682getMinHeightimpl, placeableMo515measureBRTryo2.height);
                    arrayList2.add(placeableMo515measureBRTryo2);
                }
                if (list.isEmpty()) {
                    iM683getMinWidthimpl = Constraints.m683getMinWidthimpl(j);
                    iM682getMinHeightimpl = Constraints.m682getMinHeightimpl(j);
                }
                return measureScope.layout(iM683getMinWidthimpl, iM682getMinHeightimpl, EmptyMap.INSTANCE, new RootMeasurePolicy$measure$3(2, arrayList2));
        }
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        int i2 = this.$r8$classId;
        return Modifier.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, list, i);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        int i2 = this.$r8$classId;
        return Modifier.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, list, i);
    }
}
