package com.github.kr328.clash.compose.proxy;

import com.github.kr328.clash.core.model.ProxySort;
import com.github.kr328.clash.service.remote.IClashManager;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ProxyViewModel$loadGroups$2$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ String $name;
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ ProxySort $sort;
    public /* synthetic */ Object L$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProxyViewModel$loadGroups$2$1$1(String str, ProxySort proxySort, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.$name = str;
        this.$sort = proxySort;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                ProxyViewModel$loadGroups$2$1$1 proxyViewModel$loadGroups$2$1$1 = new ProxyViewModel$loadGroups$2$1$1(this.$name, this.$sort, continuation, 0);
                proxyViewModel$loadGroups$2$1$1.L$0 = obj;
                return proxyViewModel$loadGroups$2$1$1;
            default:
                ProxyViewModel$loadGroups$2$1$1 proxyViewModel$loadGroups$2$1$2 = new ProxyViewModel$loadGroups$2$1$1(this.$name, this.$sort, continuation, 1);
                proxyViewModel$loadGroups$2$1$2.L$0 = obj;
                return proxyViewModel$loadGroups$2$1$2;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        IClashManager iClashManager = (IClashManager) obj;
        Continuation continuation = (Continuation) obj2;
        switch (this.$r8$classId) {
            case 0:
                break;
        }
        return ((ProxyViewModel$loadGroups$2$1$1) create(iClashManager, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                ResultKt.throwOnFailure(obj);
                break;
            default:
                ResultKt.throwOnFailure(obj);
                break;
        }
        return ((IClashManager) this.L$0).queryProxyGroup(this.$name, this.$sort);
    }
}
