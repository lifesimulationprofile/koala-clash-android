package androidx.work.impl.constraints;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class WorkConstraintsTracker$track$$inlined$combine$1$3 extends SuspendLambda implements Function3 {
    public /* synthetic */ FlowCollector L$0;
    public /* synthetic */ Object[] L$1;
    public int label;

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        WorkConstraintsTracker$track$$inlined$combine$1$3 workConstraintsTracker$track$$inlined$combine$1$3 = new WorkConstraintsTracker$track$$inlined$combine$1$3(3, (Continuation) obj3);
        workConstraintsTracker$track$$inlined$combine$1$3.L$0 = (FlowCollector) obj;
        workConstraintsTracker$track$$inlined$combine$1$3.L$1 = (Object[]) obj2;
        return workConstraintsTracker$track$$inlined$combine$1$3.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ConstraintsState constraintsState;
        ConstraintsState constraintsState2;
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = this.L$0;
            ConstraintsState[] constraintsStateArr = (ConstraintsState[]) this.L$1;
            int length = constraintsStateArr.length;
            int i2 = 0;
            while (true) {
                constraintsState = ConstraintsState.ConstraintsMet.INSTANCE;
                if (i2 >= length) {
                    constraintsState2 = null;
                    break;
                }
                constraintsState2 = constraintsStateArr[i2];
                if (!Intrinsics.areEqual(constraintsState2, constraintsState)) {
                    break;
                }
                i2++;
            }
            if (constraintsState2 != null) {
                constraintsState = constraintsState2;
            }
            this.label = 1;
            Object objEmit = flowCollector.emit(constraintsState, this);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objEmit == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
