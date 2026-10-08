package com.github.kr328.clash.compose.proxy;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.work.impl.WorkLauncherImpl;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ProxyScreenKt$ProxyGroupAccordionList$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ boolean $focusGlobal;
    public final /* synthetic */ int $globalIndex;
    public final /* synthetic */ LazyListState $listState;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProxyScreenKt$ProxyGroupAccordionList$1$1(boolean z, LazyListState lazyListState, int i, Continuation continuation) {
        super(2, continuation);
        this.$focusGlobal = z;
        this.$listState = lazyListState;
        this.$globalIndex = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ProxyScreenKt$ProxyGroupAccordionList$1$1(this.$focusGlobal, this.$listState, this.$globalIndex, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((ProxyScreenKt$ProxyGroupAccordionList$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$focusGlobal) {
                this.label = 1;
                WorkLauncherImpl workLauncherImpl = LazyListState.Saver;
                Object objAnimateScrollToItem = this.$listState.animateScrollToItem(this.$globalIndex, this);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objAnimateScrollToItem == coroutineSingletons) {
                    return coroutineSingletons;
                }
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
