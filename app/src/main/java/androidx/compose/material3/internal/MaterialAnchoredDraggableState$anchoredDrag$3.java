package androidx.compose.material3.internal;

import androidx.work.impl.StartStopTokens;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref$FloatRef;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class MaterialAnchoredDraggableState$anchoredDrag$3 extends ContinuationImpl {
    public Ref$FloatRef L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ StartStopTokens this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaterialAnchoredDraggableState$anchoredDrag$3(StartStopTokens startStopTokens, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.this$0 = startStopTokens;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.anchoredDrag$material3(null, 0.0f, this);
    }
}
