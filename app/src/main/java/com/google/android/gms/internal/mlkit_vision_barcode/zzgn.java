package com.google.android.gms.internal.mlkit_vision_barcode;

import androidx.compose.foundation.interaction.FocusInteractionKt$collectIsFocusedAsState$1$1;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor$Key;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$1;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$2;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.internal.DispatchedContinuation;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzgn {
    public static final MutableState collectIsFocusedAsState(MutableInteractionSourceImpl mutableInteractionSourceImpl, GapComposer gapComposer, int i) {
        Object objRememberedValue = gapComposer.rememberedValue();
        NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
        if (objRememberedValue == neverEqualPolicy) {
            objRememberedValue = Stack.mutableStateOf$default(Boolean.FALSE);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        MutableState mutableState = (MutableState) objRememberedValue;
        boolean z = (((i & 14) ^ 6) > 4 && gapComposer.changed(mutableInteractionSourceImpl)) || (i & 6) == 4;
        Object objRememberedValue2 = gapComposer.rememberedValue();
        if (z || objRememberedValue2 == neverEqualPolicy) {
            objRememberedValue2 = new FocusInteractionKt$collectIsFocusedAsState$1$1(mutableInteractionSourceImpl, mutableState, null, 0);
            gapComposer.updateRememberedValue(objRememberedValue2);
        }
        Stack.LaunchedEffect(gapComposer, mutableInteractionSourceImpl, (Function2) objRememberedValue2);
        return mutableState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Continuation createCoroutineUnintercepted(final Continuation continuation, final Continuation continuation2, final Function2 function2) {
        if (function2 instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) function2).create(continuation, continuation2);
        }
        final CoroutineContext context = continuation2.getContext();
        return context == EmptyCoroutineContext.INSTANCE ? new RestrictedContinuationImpl(continuation2) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3
            public int label;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                int i = this.label;
                if (i != 0) {
                    if (i != 1) {
                        throw new IllegalStateException("This coroutine had already completed");
                    }
                    this.label = 2;
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                this.label = 1;
                ResultKt.throwOnFailure(obj);
                Function2 function3 = function2;
                TypeIntrinsics.beforeCheckcastToFunctionOfArity(2, function3);
                return function3.invoke(continuation, this);
            }
        } : new ContinuationImpl(continuation2, context) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4
            public int label;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                int i = this.label;
                if (i != 0) {
                    if (i != 1) {
                        throw new IllegalStateException("This coroutine had already completed");
                    }
                    this.label = 2;
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                this.label = 1;
                ResultKt.throwOnFailure(obj);
                Function2 function3 = function2;
                TypeIntrinsics.beforeCheckcastToFunctionOfArity(2, function3);
                return function3.invoke(continuation, this);
            }
        };
    }

    public static Continuation intercepted(Continuation continuation) {
        ContinuationImpl continuationImpl = continuation instanceof ContinuationImpl ? (ContinuationImpl) continuation : null;
        if (continuationImpl == null || (continuation = continuationImpl.intercepted) != null) {
            return continuation;
        }
        CoroutineDispatcher coroutineDispatcher = (CoroutineDispatcher) continuationImpl.getContext().get(ContinuationInterceptor$Key.$$INSTANCE);
        Continuation dispatchedContinuation = coroutineDispatcher != null ? new DispatchedContinuation(coroutineDispatcher, continuationImpl) : continuationImpl;
        continuationImpl.intercepted = dispatchedContinuation;
        return dispatchedContinuation;
    }

    public static Object wrapWithContinuationImpl(Function2 function2, Object obj, Continuation continuation) {
        CoroutineContext context = continuation.getContext();
        Object intrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$1 = context == EmptyCoroutineContext.INSTANCE ? new IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$1(continuation) : new IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$2(continuation, context);
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(2, function2);
        return function2.invoke(obj, intrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$1);
    }
}
