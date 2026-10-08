package com.github.kr328.clash.compose.proxy;

import com.github.kr328.clash.PropertiesActivity$commit$4$1$$ExternalSyntheticLambda0;
import com.github.kr328.clash.service.model.Profile;
import com.github.kr328.clash.service.remote.IClashManager;
import com.github.kr328.clash.service.remote.IProfileManager;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ProxyViewModel$testProxy$1$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ String $groupName;
    public final /* synthetic */ String $proxyName;
    public final /* synthetic */ int $r8$classId;
    public /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProxyViewModel$testProxy$1$2(String str, String str2, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.$groupName = str;
        this.$proxyName = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                ProxyViewModel$testProxy$1$2 proxyViewModel$testProxy$1$2 = new ProxyViewModel$testProxy$1$2(this.$groupName, this.$proxyName, continuation, 0);
                proxyViewModel$testProxy$1$2.L$0 = obj;
                return proxyViewModel$testProxy$1$2;
            case 1:
                ProxyViewModel$testProxy$1$2 proxyViewModel$testProxy$1$3 = new ProxyViewModel$testProxy$1$2(this.$groupName, this.$proxyName, continuation, 1);
                proxyViewModel$testProxy$1$3.L$0 = obj;
                return proxyViewModel$testProxy$1$3;
            default:
                ProxyViewModel$testProxy$1$2 proxyViewModel$testProxy$1$4 = new ProxyViewModel$testProxy$1$2(this.$groupName, this.$proxyName, continuation, 2);
                proxyViewModel$testProxy$1$4.L$0 = obj;
                return proxyViewModel$testProxy$1$4;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                return ((ProxyViewModel$testProxy$1$2) create((IClashManager) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 1:
                return ((ProxyViewModel$testProxy$1$2) create((IProfileManager) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            default:
                return ((ProxyViewModel$testProxy$1$2) create((IClashManager) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    IClashManager iClashManager = (IClashManager) this.L$0;
                    this.label = 1;
                    Object objHealthCheckProxy = iClashManager.healthCheckProxy(this.$groupName, this.$proxyName, this);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objHealthCheckProxy == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            case 1:
                int i2 = this.label;
                if (i2 != 0) {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                ResultKt.throwOnFailure(obj);
                IProfileManager iProfileManager = (IProfileManager) this.L$0;
                PropertiesActivity$commit$4$1$$ExternalSyntheticLambda0 propertiesActivity$commit$4$1$$ExternalSyntheticLambda0 = new PropertiesActivity$commit$4$1$$ExternalSyntheticLambda0();
                this.label = 1;
                Object objMo816import = iProfileManager.mo816import(Profile.Type.Url, this.$groupName, this.$proxyName, 0L, propertiesActivity$commit$4$1$$ExternalSyntheticLambda0, this);
                CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                return objMo816import == coroutineSingletons2 ? coroutineSingletons2 : objMo816import;
            default:
                int i3 = this.label;
                if (i3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    IClashManager iClashManager2 = (IClashManager) this.L$0;
                    this.label = 1;
                    Object objHealthCheckProxy2 = iClashManager2.healthCheckProxy(this.$groupName, this.$proxyName, this);
                    CoroutineSingletons coroutineSingletons3 = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objHealthCheckProxy2 == coroutineSingletons3) {
                        return coroutineSingletons3;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
        }
    }
}
