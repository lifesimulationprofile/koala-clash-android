package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.SelectionAdjustment$Companion;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LongPressTextDragObserverKt$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ TextDragObserver f$0;

    public /* synthetic */ LongPressTextDragObserverKt$$ExternalSyntheticLambda0(TextDragObserver textDragObserver, int i) {
        this.$r8$classId = i;
        this.f$0 = textDragObserver;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                this.f$0.mo174onStart3MmeM6k(((Offset) obj).packedValue, SelectionAdjustment$Companion.None);
                break;
            case 1:
                PointerInputChange pointerInputChange = (PointerInputChange) obj;
                this.f$0.mo173onDragk4lQ0M(PointerId.positionChangeInternal(pointerInputChange, false));
                pointerInputChange.consume();
                break;
            default:
                PointerInputChange pointerInputChange2 = (PointerInputChange) obj;
                this.f$0.mo173onDragk4lQ0M(PointerId.positionChangeInternal(pointerInputChange2, false));
                pointerInputChange2.consume();
                break;
        }
        return Unit.INSTANCE;
    }
}
