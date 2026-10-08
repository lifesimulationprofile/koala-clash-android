package androidx.compose.runtime.snapshots;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SnapshotKt$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Function1 f$0;
    public final /* synthetic */ Function1 f$1;

    public /* synthetic */ SnapshotKt$$ExternalSyntheticLambda0(Function1 function1, Function1 function2, int i) {
        this.$r8$classId = i;
        this.f$0 = function1;
        this.f$1 = function2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                this.f$0.invoke(obj);
                this.f$1.invoke(obj);
                break;
            default:
                this.f$0.invoke(obj);
                this.f$1.invoke(obj);
                break;
        }
        return Unit.INSTANCE;
    }
}
