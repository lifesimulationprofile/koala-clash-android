package kotlinx.coroutines.flow.internal;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import com.google.android.gms.internal.mlkit_vision_barcode.zzgn;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ChannelFlowKt {
    public static final Continuation[] EMPTY_RESUMES = new Continuation[0];
    public static final Symbol NULL = new Symbol("NULL", 0);
    public static final Symbol UNINITIALIZED = new Symbol("UNINITIALIZED", 0);

    public static final Object withContextUndispatched(CoroutineContext coroutineContext, Object obj, Object obj2, Function2 function2, Continuation continuation) {
        Object objInvoke;
        Object objUpdateThreadContext = InlineList.updateThreadContext(coroutineContext, obj2);
        try {
            StackFrameContinuation stackFrameContinuation = new StackFrameContinuation(continuation, coroutineContext);
            if (ImageAnalysis$$ExternalSyntheticLambda1.m14m((Object) function2)) {
                TypeIntrinsics.beforeCheckcastToFunctionOfArity(2, function2);
                objInvoke = function2.invoke(obj, stackFrameContinuation);
            } else {
                objInvoke = zzgn.wrapWithContinuationImpl(function2, obj, stackFrameContinuation);
            }
            return objInvoke;
        } finally {
            InlineList.restoreThreadContext(coroutineContext, objUpdateThreadContext);
        }
    }
}
