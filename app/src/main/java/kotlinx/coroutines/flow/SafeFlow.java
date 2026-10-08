package kotlinx.coroutines.flow;

import androidx.work.impl.constraints.WorkConstraintsTracker$track$$inlined$combine$1$3;
import java.io.Serializable;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.SupervisorCoroutine;
import kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2;
import kotlinx.coroutines.flow.internal.SafeCollector;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import okhttp3.Handshake;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class SafeFlow implements Flow {
    public final /* synthetic */ int $r8$classId = 0;
    public final Serializable block;

    /* JADX WARN: Multi-variable type inference failed */
    public SafeFlow(Flow[] flowArr) {
        this.block = flowArr;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x004e  */
    /* JADX WARN: Type inference failed for: r0v5, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector flowCollector, Continuation continuation) throws Throwable {
        AbstractFlow$collect$1 abstractFlow$collect$1;
        Throwable th;
        SafeCollector safeCollector;
        switch (this.$r8$classId) {
            case 0:
                if (continuation instanceof AbstractFlow$collect$1) {
                    abstractFlow$collect$1 = (AbstractFlow$collect$1) continuation;
                    int i = abstractFlow$collect$1.label;
                    if ((i & Integer.MIN_VALUE) != 0) {
                        abstractFlow$collect$1.label = i - Integer.MIN_VALUE;
                    } else {
                        abstractFlow$collect$1 = new AbstractFlow$collect$1(this, continuation);
                    }
                } else {
                    abstractFlow$collect$1 = new AbstractFlow$collect$1(this, continuation);
                }
                Object obj = abstractFlow$collect$1.result;
                int i2 = abstractFlow$collect$1.label;
                if (i2 != 0) {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    safeCollector = abstractFlow$collect$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        safeCollector.releaseIntercepted();
                        return Unit.INSTANCE;
                    } catch (Throwable th2) {
                        th = th2;
                        safeCollector.releaseIntercepted();
                        throw th;
                    }
                }
                ResultKt.throwOnFailure(obj);
                SafeCollector safeCollector2 = new SafeCollector(flowCollector, abstractFlow$collect$1._context);
                try {
                    abstractFlow$collect$1.L$0 = safeCollector2;
                    abstractFlow$collect$1.label = 1;
                    Object objInvoke = ((SuspendLambda) this.block).invoke(safeCollector2, abstractFlow$collect$1);
                    Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objInvoke != obj2) {
                        objInvoke = Unit.INSTANCE;
                        break;
                    }
                    if (objInvoke == obj2) {
                        return obj2;
                    }
                    safeCollector = safeCollector2;
                    safeCollector.releaseIntercepted();
                    return Unit.INSTANCE;
                } catch (Throwable th3) {
                    th = th3;
                    safeCollector = safeCollector2;
                    safeCollector.releaseIntercepted();
                    throw th;
                }
            default:
                Flow[] flowArr = (Flow[]) this.block;
                CombineKt$combineInternal$2 combineKt$combineInternal$2 = new CombineKt$combineInternal$2(flowArr, new Handshake.AnonymousClass2(23, flowArr), new WorkConstraintsTracker$track$$inlined$combine$1$3(3, null), flowCollector, null);
                SupervisorCoroutine supervisorCoroutine = new SupervisorCoroutine(continuation.getContext(), continuation, 1);
                Object objStartUndispatchedOrReturn = UndispatchedKt.startUndispatchedOrReturn(supervisorCoroutine, supervisorCoroutine, combineKt$combineInternal$2);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objStartUndispatchedOrReturn != coroutineSingletons) {
                    objStartUndispatchedOrReturn = Unit.INSTANCE;
                }
                return objStartUndispatchedOrReturn == coroutineSingletons ? objStartUndispatchedOrReturn : Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SafeFlow(Function2 function2) {
        this.block = (SuspendLambda) function2;
    }
}
