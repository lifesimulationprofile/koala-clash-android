package com.github.kr328.clash.service.clash.module;

import android.app.Service;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class SuspendModule extends Module {
    public final /* synthetic */ int $r8$classId;

    /* JADX INFO: renamed from: com.github.kr328.clash.service.clash.module.SuspendModule$run$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public Object L$0;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            SuspendModule.this.run(this);
            return CoroutineSingletons.COROUTINE_SUSPENDED;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SuspendModule(Service service, int i) {
        super(service);
        this.$r8$classId = i;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0277  */
    /* JADX WARN: Code duplicated, block: B:103:0x0280 A[Catch: all -> 0x022e, TryCatch #0 {all -> 0x022e, blocks: (B:89:0x022a, B:101:0x0278, B:103:0x0280, B:108:0x028f, B:110:0x0295, B:98:0x026d, B:111:0x02a6, B:114:0x02ad, B:115:0x02be), top: B:121:0x022a }] */
    /* JADX WARN: Code duplicated, block: B:105:0x0289  */
    /* JADX WARN: Code duplicated, block: B:107:0x028e A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:108:0x028f A[Catch: all -> 0x022e, TryCatch #0 {all -> 0x022e, blocks: (B:89:0x022a, B:101:0x0278, B:103:0x0280, B:108:0x028f, B:110:0x0295, B:98:0x026d, B:111:0x02a6, B:114:0x02ad, B:115:0x02be), top: B:121:0x022a }] */
    /* JADX WARN: Code duplicated, block: B:111:0x02a6 A[Catch: all -> 0x022e, TryCatch #0 {all -> 0x022e, blocks: (B:89:0x022a, B:101:0x0278, B:103:0x0280, B:108:0x028f, B:110:0x0295, B:98:0x026d, B:111:0x02a6, B:114:0x02ad, B:115:0x02be), top: B:121:0x022a }] */
    /* JADX WARN: Code duplicated, block: B:113:0x02ac  */
    /* JADX WARN: Code duplicated, block: B:114:0x02ad A[Catch: all -> 0x022e, TryCatch #0 {all -> 0x022e, blocks: (B:89:0x022a, B:101:0x0278, B:103:0x0280, B:108:0x028f, B:110:0x0295, B:98:0x026d, B:111:0x02a6, B:114:0x02ad, B:115:0x02be), top: B:121:0x022a }] */
    /* JADX WARN: Code duplicated, block: B:115:0x02be A[Catch: all -> 0x022e, TRY_LEAVE, TryCatch #0 {all -> 0x022e, blocks: (B:89:0x022a, B:101:0x0278, B:103:0x0280, B:108:0x028f, B:110:0x0295, B:98:0x026d, B:111:0x02a6, B:114:0x02ad, B:115:0x02be), top: B:121:0x022a }] */
    /* JADX WARN: Code duplicated, block: B:80:0x0202  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x01ee -> B:31:0x009d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:99:0x0275 -> B:101:0x0278). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:103:0x0280
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // com.github.kr328.clash.service.clash.module.Module
    public final java.lang.Object run(kotlin.coroutines.Continuation r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 740
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.kr328.clash.service.clash.module.SuspendModule.run(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
