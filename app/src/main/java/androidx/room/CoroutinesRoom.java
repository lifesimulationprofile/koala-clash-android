package androidx.room;

import android.os.CancellationSignal;
import androidx.navigation.NavController$handleDeepLink$2;
import coil.disk.DiskLruCache;
import com.github.kr328.clash.service.data.Database_Impl;
import com.google.android.gms.internal.mlkit_vision_barcode.zzgn;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorCoroutineDispatcherImpl;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.InterruptibleKt$runInterruptible$2;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class CoroutinesRoom {
    public static final Object execute(Database_Impl database_Impl, Callable callable, ContinuationImpl continuationImpl) {
        if (database_Impl.isOpenInternal() && database_Impl.getOpenHelper().getWritableDatabase().inTransaction()) {
            return callable.call();
        }
        if (continuationImpl.getContext().get(TransactionElement.Key) != null) {
            throw new ClassCastException();
        }
        Map map = database_Impl.backingFieldMap;
        Object executorCoroutineDispatcherImpl = map.get("TransactionDispatcher");
        if (executorCoroutineDispatcherImpl == null) {
            TransactionExecutor transactionExecutor = database_Impl.internalTransactionExecutor;
            if (transactionExecutor == null) {
                Intrinsics.throwUninitializedPropertyAccessException("internalTransactionExecutor");
                throw null;
            }
            executorCoroutineDispatcherImpl = new ExecutorCoroutineDispatcherImpl(transactionExecutor);
            map.put("TransactionDispatcher", executorCoroutineDispatcherImpl);
        }
        return JobKt.withContext((CoroutineDispatcher) executorCoroutineDispatcherImpl, new DiskLruCache.AnonymousClass1(callable, null, 4), continuationImpl);
    }

    public static final Object execute(Database_Impl database_Impl, CancellationSignal cancellationSignal, Callable callable, ContinuationImpl continuationImpl) {
        if (database_Impl.isOpenInternal() && database_Impl.getOpenHelper().getWritableDatabase().inTransaction()) {
            return callable.call();
        }
        if (continuationImpl.getContext().get(TransactionElement.Key) == null) {
            Map map = database_Impl.backingFieldMap;
            Object executorCoroutineDispatcherImpl = map.get("QueryDispatcher");
            Continuation continuation = null;
            if (executorCoroutineDispatcherImpl == null) {
                Executor executor = database_Impl.internalQueryExecutor;
                if (executor != null) {
                    executorCoroutineDispatcherImpl = new ExecutorCoroutineDispatcherImpl(executor);
                    map.put("QueryDispatcher", executorCoroutineDispatcherImpl);
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("internalQueryExecutor");
                    throw null;
                }
            }
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, zzgn.intercepted(continuationImpl));
            cancellableContinuationImpl.initCancellability();
            InterruptibleKt$runInterruptible$2 interruptibleKt$runInterruptible$2 = new InterruptibleKt$runInterruptible$2(callable, cancellableContinuationImpl, continuation, 3);
            cancellableContinuationImpl.invokeOnCancellation(new NavController$handleDeepLink$2(13, cancellationSignal, JobKt.launch$default(GlobalScope.INSTANCE, (CoroutineDispatcher) executorCoroutineDispatcherImpl, interruptibleKt$runInterruptible$2, 2)));
            return cancellableContinuationImpl.getResult();
        }
        throw new ClassCastException();
    }
}
