package androidx.compose.runtime;

import androidx.compose.runtime.tooling.ComposeStackTraceKt;
import androidx.compose.runtime.tooling.CompositionErrorContextImpl;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class RememberedCoroutineScope$special$$inlined$CoroutineExceptionHandler$1 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    public final /* synthetic */ CompositionErrorContextImpl $traceContext$inlined;
    public final /* synthetic */ RememberedCoroutineScope this$0;

    /* JADX WARN: Illegal instructions before constructor call */
    public RememberedCoroutineScope$special$$inlined$CoroutineExceptionHandler$1(CompositionErrorContextImpl compositionErrorContextImpl, RememberedCoroutineScope rememberedCoroutineScope) {
        Job.Key key = Job.Key.$$INSTANCE$1;
        this.$traceContext$inlined = compositionErrorContextImpl;
        this.this$0 = rememberedCoroutineScope;
        super(key);
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public final void handleException(Throwable th, CoroutineContext coroutineContext) throws Throwable {
        CompositionErrorContextImpl compositionErrorContextImpl = this.$traceContext$inlined;
        RememberedCoroutineScope rememberedCoroutineScope = this.this$0;
        ComposeStackTraceKt.tryAttachComposeStackTrace(th, new Recomposer$$ExternalSyntheticLambda6(19, compositionErrorContextImpl, rememberedCoroutineScope));
        CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) rememberedCoroutineScope.parentContext.get(Job.Key.$$INSTANCE$1);
        if (coroutineExceptionHandler == null) {
            throw th;
        }
        coroutineExceptionHandler.handleException(th, coroutineContext);
    }
}
