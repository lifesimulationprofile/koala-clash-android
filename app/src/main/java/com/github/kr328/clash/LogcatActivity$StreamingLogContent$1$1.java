package com.github.kr328.clash;

import androidx.compose.runtime.MutableState;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class LogcatActivity$StreamingLogContent$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ MutableState $messages$delegate;
    public int I$0;
    public /* synthetic */ Object L$0;
    public LogcatService L$1;
    public int label;
    public final /* synthetic */ LogcatActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LogcatActivity$StreamingLogContent$1$1(LogcatActivity logcatActivity, MutableState mutableState, Continuation continuation) {
        super(2, continuation);
        this.this$0 = logcatActivity;
        this.$messages$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        LogcatActivity$StreamingLogContent$1$1 logcatActivity$StreamingLogContent$1$1 = new LogcatActivity$StreamingLogContent$1$1(this.this$0, this.$messages$delegate, continuation);
        logcatActivity$StreamingLogContent$1$1.L$0 = obj;
        return logcatActivity$StreamingLogContent$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((LogcatActivity$StreamingLogContent$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x008e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:24:0x0090  */
    /* JADX WARN: Code duplicated, block: B:25:0x0092  */
    /* JADX WARN: Code duplicated, block: B:29:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:32:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:36:0x00cc  */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0082, code lost:
    
        if (r12 == r5) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c9, code lost:
    
        if (kotlinx.coroutines.JobKt.delay(500, r11) == r5) goto L35;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00c9 -> B:8:0x001b). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 207
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.kr328.clash.LogcatActivity$StreamingLogContent$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
