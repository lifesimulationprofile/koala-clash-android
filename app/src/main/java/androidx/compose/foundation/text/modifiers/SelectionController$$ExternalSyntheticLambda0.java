package androidx.compose.foundation.text.modifiers;

import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SelectionController$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ SelectionController f$0;

    public /* synthetic */ SelectionController$$ExternalSyntheticLambda0(SelectionController selectionController, int i) {
        this.$r8$classId = i;
        this.f$0 = selectionController;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                return this.f$0.params.layoutCoordinates;
            case 1:
                return this.f$0.params.textLayoutResult;
            default:
                return this.f$0.params.layoutCoordinates;
        }
    }
}
