package androidx.compose.foundation.gestures;

import androidx.navigation.compose.NavHostKt$NavHost$25$1$1;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AnchoredDraggableKt$restartable$2$1$emit$1 extends ContinuationImpl {
    public Object L$0;
    public Job L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ NavHostKt$NavHost$25$1$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchoredDraggableKt$restartable$2$1$emit$1(NavHostKt$NavHost$25$1$1 navHostKt$NavHost$25$1$1, Continuation continuation) {
        super(continuation);
        this.this$0 = navHostKt$NavHost$25$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, this);
    }
}
