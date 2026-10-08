package androidx.compose.ui.layout;

import androidx.camera.core.impl.utils.MatrixExt;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class RootMeasurePolicy$measure$3 extends Lambda implements Function1 {
    public final /* synthetic */ ArrayList $placeables;
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RootMeasurePolicy$measure$3(int i, ArrayList arrayList) {
        super(1);
        this.$r8$classId = i;
        this.$placeables = arrayList;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                ArrayList arrayList = this.$placeables;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    Placeable.PlacementScope.placeRelativeWithLayer$default(placementScope, (Placeable) arrayList.get(i), 0, 0, null, 12);
                }
                break;
            case 1:
                Placeable.PlacementScope placementScope2 = (Placeable.PlacementScope) obj;
                ArrayList arrayList2 = this.$placeables;
                int size2 = arrayList2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    Placeable.PlacementScope.place$default(placementScope2, (Placeable) arrayList2.get(i2), 0, 0);
                }
                break;
            case 2:
                Placeable.PlacementScope placementScope3 = (Placeable.PlacementScope) obj;
                ArrayList arrayList3 = this.$placeables;
                int size3 = arrayList3.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    Placeable.PlacementScope.placeRelative$default(placementScope3, (Placeable) arrayList3.get(i3), 0, 0);
                }
                break;
            default:
                Placeable.PlacementScope placementScope4 = (Placeable.PlacementScope) obj;
                ArrayList arrayList4 = this.$placeables;
                int lastIndex = MatrixExt.getLastIndex(arrayList4);
                if (lastIndex >= 0) {
                    int i4 = 0;
                    while (true) {
                        Placeable.PlacementScope.placeRelative$default(placementScope4, (Placeable) arrayList4.get(i4), 0, 0);
                        if (i4 != lastIndex) {
                            i4++;
                        }
                    }
                }
                break;
        }
        return Unit.INSTANCE;
    }
}
