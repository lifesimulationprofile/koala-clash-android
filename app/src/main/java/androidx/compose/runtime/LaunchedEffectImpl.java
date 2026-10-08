package androidx.compose.runtime;

import androidx.compose.runtime.tooling.ComposeStackTraceKt;
import androidx.compose.runtime.tooling.CompositionErrorContextImpl;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.internal.ContextScope;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class LaunchedEffectImpl implements RememberObserver, CoroutineExceptionHandler {
    public StandaloneCoroutine job;
    public final CoroutineContext parentCoroutineContext;
    public final ContextScope scope;
    public final Function2 task;

    public LaunchedEffectImpl(CoroutineContext coroutineContext, Function2 function2) {
        this.parentCoroutineContext = coroutineContext;
        this.task = function2;
        this.scope = JobKt.CoroutineScope(coroutineContext.plus(this));
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final Object fold(Object obj, Function2 function2) {
        return function2.invoke(obj, this);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext.Element get(CoroutineContext.Key key) {
        return CoroutineContext.Element.DefaultImpls.get(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key getKey() {
        return Job.Key.$$INSTANCE$1;
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public final void handleException(Throwable th, CoroutineContext coroutineContext) throws Throwable {
        CompositionErrorContextImpl compositionErrorContextImpl = (CompositionErrorContextImpl) coroutineContext.get(CompositionErrorContextImpl.Key);
        if (compositionErrorContextImpl != null) {
            ComposeStackTraceKt.tryAttachComposeStackTrace(th, new Recomposer$$ExternalSyntheticLambda6(19, compositionErrorContextImpl, this));
        }
        CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) this.parentCoroutineContext.get(Job.Key.$$INSTANCE$1);
        if (coroutineExceptionHandler == null) {
            throw th;
        }
        coroutineExceptionHandler.handleException(th, coroutineContext);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key key) {
        return CoroutineContext.Element.DefaultImpls.minusKey(this, key);
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onAbandoned() {
        StandaloneCoroutine standaloneCoroutine = this.job;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancelInternal(new ForgottenCoroutineScopeException(1));
        }
        this.job = null;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onForgotten() {
        StandaloneCoroutine standaloneCoroutine = this.job;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancelInternal(new ForgottenCoroutineScopeException(1));
        }
        this.job = null;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onRemembered() {
        StandaloneCoroutine standaloneCoroutine = this.job;
        if (standaloneCoroutine != null) {
            CancellationException cancellationException = new CancellationException("Old job was still running!");
            cancellationException.initCause(null);
            standaloneCoroutine.cancel(cancellationException);
        }
        this.job = JobKt.launch$default(this.scope, null, this.task, 3);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineContext.DefaultImpls.plus(this, coroutineContext);
    }
}
