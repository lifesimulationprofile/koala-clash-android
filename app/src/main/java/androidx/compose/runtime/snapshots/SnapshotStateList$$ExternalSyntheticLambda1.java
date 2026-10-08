package androidx.compose.runtime.snapshots;

import androidx.compose.ui.layout.Placeable;
import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SnapshotStateList$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ int f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ SnapshotStateList$$ExternalSyntheticLambda1(int i, int i2, Placeable placeable) {
        this.$r8$classId = i2;
        this.f$1 = placeable;
        this.f$0 = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                return Boolean.valueOf(((List) obj).addAll(this.f$0, (Collection) this.f$1));
            case 1:
                Placeable.PlacementScope.place$default((Placeable.PlacementScope) obj, (Placeable) this.f$1, -this.f$0, 0);
                return Unit.INSTANCE;
            default:
                Placeable.PlacementScope.place$default((Placeable.PlacementScope) obj, (Placeable) this.f$1, 0, -this.f$0);
                return Unit.INSTANCE;
        }
    }

    public /* synthetic */ SnapshotStateList$$ExternalSyntheticLambda1(int i, Collection collection) {
        this.$r8$classId = 0;
        this.f$0 = i;
        this.f$1 = collection;
    }
}
