package kotlinx.coroutines.flow.internal;

import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class CombineKt$combineInternal$2$1$1 implements FlowCollector {
    public final /* synthetic */ int $i;
    public final /* synthetic */ BufferedChannel $resultChannel;

    public CombineKt$combineInternal$2$1$1(BufferedChannel bufferedChannel, int i) {
        this.$resultChannel = bufferedChannel;
        this.$i = i;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0092, code lost:
    
        if (r6 == r4) goto L34;
     */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1 r0 = (kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1 r0 = new kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            int r1 = r0.label
            r2 = 2
            r3 = 1
            kotlin.coroutines.intrinsics.CoroutineSingletons r4 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r1 == 0) goto L37
            if (r1 == r3) goto L33
            if (r1 != r2) goto L2b
            kotlin.ResultKt.throwOnFailure(r7)
            goto L95
        L2b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L33:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L4c
        L37:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.collections.IndexedValue r7 = new kotlin.collections.IndexedValue
            int r1 = r5.$i
            r7.<init>(r1, r6)
            r0.label = r3
            kotlinx.coroutines.channels.BufferedChannel r6 = r5.$resultChannel
            java.lang.Object r6 = r6.send(r7, r0)
            if (r6 != r4) goto L4c
            goto L94
        L4c:
            r0.label = r2
            kotlin.coroutines.CoroutineContext r6 = r0.getContext()
            kotlinx.coroutines.JobKt.ensureActive(r6)
            kotlin.coroutines.Continuation r7 = com.google.android.gms.internal.mlkit_vision_barcode.zzgn.intercepted(r0)
            boolean r0 = r7 instanceof kotlinx.coroutines.internal.DispatchedContinuation
            if (r0 == 0) goto L60
            kotlinx.coroutines.internal.DispatchedContinuation r7 = (kotlinx.coroutines.internal.DispatchedContinuation) r7
            goto L61
        L60:
            r7 = 0
        L61:
            if (r7 != 0) goto L66
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            goto L8d
        L66:
            kotlinx.coroutines.CoroutineDispatcher r0 = r7.dispatcher
            boolean r1 = kotlinx.coroutines.internal.InlineList.safeIsDispatchNeeded(r0, r6)
            if (r1 == 0) goto L78
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            r7._state = r1
            r7.resumeMode = r3
            r0.dispatchYield(r6, r7)
            goto L8c
        L78:
            kotlinx.coroutines.YieldContext r1 = new kotlinx.coroutines.YieldContext
            kotlinx.coroutines.Job$Key r2 = kotlinx.coroutines.YieldContext.Key
            r1.<init>(r2)
            kotlin.coroutines.CoroutineContext r6 = r6.plus(r1)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            r7._state = r1
            r7.resumeMode = r3
            r0.dispatchYield(r6, r7)
        L8c:
            r6 = r4
        L8d:
            if (r6 != r4) goto L90
            goto L92
        L90:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
        L92:
            if (r6 != r4) goto L95
        L94:
            return r4
        L95:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
