package kotlinx.coroutines.flow;

import androidx.compose.material3.BottomSheetKt$BottomSheet$4$1$1;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class FlowKt__ReduceKt$first$1 extends ContinuationImpl {
    public Ref$ObjectRef L$0;
    public BottomSheetKt$BottomSheet$4$1$1 L$1;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FlowKt.first(null, this);
    }
}
