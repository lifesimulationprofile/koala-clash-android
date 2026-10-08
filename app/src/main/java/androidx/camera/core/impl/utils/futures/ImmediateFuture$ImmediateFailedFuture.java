package androidx.camera.core.impl.utils.futures;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.LazyKt__LazyJVMKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public class ImmediateFuture$ImmediateFailedFuture implements ListenableFuture {
    public static final ImmediateFuture$ImmediateFailedFuture NULL_FUTURE = new ImmediateFuture$ImmediateFailedFuture(1, null);
    public final /* synthetic */ int $r8$classId;
    public final Object mCause;

    public /* synthetic */ ImmediateFuture$ImmediateFailedFuture(int i, Object obj) {
        this.$r8$classId = i;
        this.mCause = obj;
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public final void addListener(Runnable runnable, Executor executor) {
        executor.getClass();
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            LazyKt__LazyJVMKt.e("ImmediateFuture", "Experienced RuntimeException while attempting to notify " + runnable + " on Executor " + executor, e);
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws ExecutionException {
        switch (this.$r8$classId) {
            case 0:
                throw new ExecutionException((Throwable) this.mCause);
            default:
                return this.mCause;
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return true;
    }

    public final String toString() {
        switch (this.$r8$classId) {
            case 0:
                return super.toString() + "[status=FAILURE, cause=[" + ((Throwable) this.mCause) + "]]";
            default:
                return super.toString() + "[status=SUCCESS, result=[" + this.mCause + "]]";
        }
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) {
        timeUnit.getClass();
        return get();
    }
}
