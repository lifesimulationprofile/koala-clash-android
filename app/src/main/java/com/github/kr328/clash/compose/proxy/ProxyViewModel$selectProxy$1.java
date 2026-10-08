package com.github.kr328.clash.compose.proxy;

import com.github.kr328.clash.LogcatActivity$writeLogTo$2$1;
import com.github.kr328.clash.util.RemoteKt;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ProxyViewModel$selectProxy$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ String $groupName;
    public final /* synthetic */ String $proxyName;
    public final /* synthetic */ int $r8$classId;
    public int label;
    public final /* synthetic */ ProxyViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProxyViewModel$selectProxy$1(ProxyViewModel proxyViewModel, String str, String str2, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.this$0 = proxyViewModel;
        this.$groupName = str;
        this.$proxyName = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new ProxyViewModel$selectProxy$1(this.this$0, this.$groupName, this.$proxyName, continuation, 0);
            default:
                return new ProxyViewModel$selectProxy$1(this.this$0, this.$groupName, this.$proxyName, continuation, 1);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (this.$r8$classId) {
            case 0:
                break;
        }
        return ((ProxyViewModel$selectProxy$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object value;
        Object value2;
        Object value3;
        Object value4;
        switch (this.$r8$classId) {
            case 0:
                int i = this.label;
                String str = this.$groupName;
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (i != 0) {
                    if (i == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                LogcatActivity$writeLogTo$2$1 logcatActivity$writeLogTo$2$1 = new LogcatActivity$writeLogTo$2$1(str, this.$proxyName, null, 7);
                this.label = 1;
                if (RemoteKt.withClash$default(logcatActivity$writeLogTo$2$1, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                this.label = 2;
                if (ProxyViewModel.access$reloadGroup(this.this$0, str, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                return Unit.INSTANCE;
            default:
                int i2 = this.label;
                ProxyViewModel proxyViewModel = this.this$0;
                String str2 = this.$groupName;
                String str3 = this.$proxyName;
                try {
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj);
                        ProxyViewModel$testProxy$1$2 proxyViewModel$testProxy$1$2 = new ProxyViewModel$testProxy$1$2(str2, str3, null, 2);
                        this.label = 1;
                        Object objWithClash$default = RemoteKt.withClash$default(proxyViewModel$testProxy$1$2, this);
                        CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (objWithClash$default == coroutineSingletons2) {
                            return coroutineSingletons2;
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    StateFlowImpl stateFlowImpl = proxyViewModel._testedProxies;
                    do {
                        value3 = stateFlowImpl.getValue();
                        break;
                    } while (!stateFlowImpl.compareAndSet(value3, SetsKt.plus((Set) value3, str3)));
                    StateFlowImpl stateFlowImpl2 = proxyViewModel._testingNodes;
                    do {
                        value4 = stateFlowImpl2.getValue();
                    } while (!stateFlowImpl2.compareAndSet(value4, SetsKt.minus((Set) value4, ProxyViewModel.nodeKey(str2, str3))));
                } catch (Exception unused) {
                    StateFlowImpl stateFlowImpl3 = proxyViewModel._testingNodes;
                    do {
                        value2 = stateFlowImpl3.getValue();
                    } while (!stateFlowImpl3.compareAndSet(value2, SetsKt.minus((Set) value2, ProxyViewModel.nodeKey(str2, str3))));
                } catch (Throwable th) {
                    StateFlowImpl stateFlowImpl4 = proxyViewModel._testingNodes;
                    do {
                        value = stateFlowImpl4.getValue();
                    } while (!stateFlowImpl4.compareAndSet(value, SetsKt.minus((Set) value, ProxyViewModel.nodeKey(str2, str3))));
                    throw th;
                }
                return Unit.INSTANCE;
        }
    }
}
