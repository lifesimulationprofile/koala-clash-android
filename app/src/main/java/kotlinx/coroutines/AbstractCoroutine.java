package kotlinx.coroutines;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import coil.network.HttpException;
import com.google.android.gms.internal.mlkit_vision_barcode.zzgn;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.internal.InlineList;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractCoroutine extends JobSupport implements Continuation, CoroutineScope {
    public final CoroutineContext context;

    public AbstractCoroutine(CoroutineContext coroutineContext, boolean z) {
        super(z);
        initParentJob((Job) coroutineContext.get(Job.Key.$$INSTANCE));
        this.context = coroutineContext.plus(this);
    }

    @Override // kotlinx.coroutines.JobSupport
    public final String cancellationExceptionMessage() {
        return getClass().getSimpleName().concat(" was cancelled");
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.context;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.context;
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void handleOnCompletionException$kotlinx_coroutines_core(HttpException httpException) {
        JobKt.handleCoroutineException(httpException, this.context);
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void onCompletionInternal(Object obj) {
        if (!(obj instanceof CompletedExceptionally)) {
            onCompleted(obj);
        } else {
            CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
            onCancelled(completedExceptionally.cause, CompletedExceptionally._handled$volatile$FU.get(completedExceptionally) == 1);
        }
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        Throwable thM835exceptionOrNullimpl = Result.m835exceptionOrNullimpl(obj);
        if (thM835exceptionOrNullimpl != null) {
            obj = new CompletedExceptionally(thM835exceptionOrNullimpl, false);
        }
        Object objMakeCompletingOnce$kotlinx_coroutines_core = makeCompletingOnce$kotlinx_coroutines_core(obj);
        if (objMakeCompletingOnce$kotlinx_coroutines_core == JobKt.COMPLETING_WAITING_CHILDREN) {
            return;
        }
        afterResume(objMakeCompletingOnce$kotlinx_coroutines_core);
    }

    public final void start(int i, AbstractCoroutine abstractCoroutine, Function2 function2) {
        Object objInvoke;
        int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i);
        if (iOrdinal == 0) {
            try {
                InlineList.resumeCancellableWith(Unit.INSTANCE, zzgn.intercepted(zzgn.createCoroutineUnintercepted(abstractCoroutine, this, function2)));
                return;
            } catch (Throwable th) {
                th = th;
                if (th instanceof DispatchException) {
                    th = ((DispatchException) th).cause;
                }
                resumeWith(new Result.Failure(th));
                throw th;
            }
        }
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                zzgn.intercepted(zzgn.createCoroutineUnintercepted(abstractCoroutine, this, function2)).resumeWith(Unit.INSTANCE);
                return;
            }
            if (iOrdinal != 3) {
                throw new HttpException();
            }
            try {
                CoroutineContext coroutineContext = this.context;
                Object objUpdateThreadContext = InlineList.updateThreadContext(coroutineContext, null);
                try {
                    if (function2 instanceof BaseContinuationImpl) {
                        TypeIntrinsics.beforeCheckcastToFunctionOfArity(2, function2);
                        objInvoke = function2.invoke(abstractCoroutine, this);
                    } else {
                        objInvoke = zzgn.wrapWithContinuationImpl(function2, abstractCoroutine, this);
                    }
                    InlineList.restoreThreadContext(coroutineContext, objUpdateThreadContext);
                    if (objInvoke != CoroutineSingletons.COROUTINE_SUSPENDED) {
                        resumeWith(objInvoke);
                    }
                } catch (Throwable th2) {
                    InlineList.restoreThreadContext(coroutineContext, objUpdateThreadContext);
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
                if (th instanceof DispatchException) {
                    th = ((DispatchException) th).cause;
                }
                resumeWith(new Result.Failure(th));
            }
        }
    }

    public void onCompleted(Object obj) {
    }

    public void onCancelled(Throwable th, boolean z) {
    }
}
