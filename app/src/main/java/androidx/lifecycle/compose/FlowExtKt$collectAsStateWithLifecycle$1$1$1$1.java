package androidx.lifecycle.compose;

import androidx.compose.runtime.ProduceStateScopeImpl;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class FlowExtKt$collectAsStateWithLifecycle$1$1$1$1 implements FlowCollector {
    public final /* synthetic */ ProduceStateScopeImpl $$this$produceState;
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ FlowExtKt$collectAsStateWithLifecycle$1$1$1$1(ProduceStateScopeImpl produceStateScopeImpl, int i) {
        this.$r8$classId = i;
        this.$$this$produceState = produceStateScopeImpl;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                this.$$this$produceState.setValue(obj);
                break;
            case 1:
                this.$$this$produceState.setValue(obj);
                break;
            case 2:
                this.$$this$produceState.setValue(obj);
                break;
            default:
                this.$$this$produceState.setValue(obj);
                break;
        }
        return Unit.INSTANCE;
    }
}
