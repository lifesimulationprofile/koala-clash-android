package kotlinx.coroutines.channels;

import androidx.compose.ui.graphics.vector.ImageVector;
import com.google.android.gms.internal.mlkit_vision_barcode.zzgn;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ProduceKt {
    public static ImageVector _brightness4;

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ProduceKt$awaitClose$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public Function0 L$1;
        public int label;
        public /* synthetic */ Object result;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ProduceKt.awaitClose(null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object awaitClose(ProducerScope producerScope, Function0 function0, ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object obj = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                if (anonymousClass1._context.get(Job.Key.$$INSTANCE) != producerScope) {
                    throw new IllegalStateException("awaitClose() can only be invoked from the producer context");
                }
                anonymousClass1.L$1 = function0;
                anonymousClass1.label = 1;
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, zzgn.intercepted(anonymousClass1));
                cancellableContinuationImpl.initCancellability();
                ((ProducerCoroutine) producerScope).invokeOnClose(new ProduceKt$awaitClose$4$1(0, cancellableContinuationImpl));
                Object result = cancellableContinuationImpl.getResult();
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (result == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                function0 = anonymousClass1.L$1;
                ResultKt.throwOnFailure(obj);
            }
            function0.invoke();
            return Unit.INSTANCE;
        } catch (Throwable th) {
            function0.invoke();
            throw th;
        }
    }
}
