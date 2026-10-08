package androidx.compose.material3;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BottomSheetKt$$ExternalSyntheticLambda3 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ SheetState f$0;
    public final /* synthetic */ Function0 f$1;

    public /* synthetic */ BottomSheetKt$$ExternalSyntheticLambda3(SheetState sheetState, Function0 function0, int i) {
        this.$r8$classId = i;
        this.f$0 = sheetState;
        this.f$1 = function0;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                if (!this.f$0.isVisible()) {
                    this.f$1.invoke();
                }
                break;
            case 1:
                if (!this.f$0.isVisible()) {
                    this.f$1.invoke();
                }
                break;
            case 2:
                if (!this.f$0.isVisible()) {
                    this.f$1.invoke();
                }
                break;
            case 3:
                if (!this.f$0.isVisible()) {
                    this.f$1.invoke();
                }
                break;
            default:
                if (!this.f$0.isVisible()) {
                    this.f$1.invoke();
                }
                break;
        }
        return Unit.INSTANCE;
    }
}
