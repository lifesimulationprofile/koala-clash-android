package kotlinx.coroutines;

import java.util.concurrent.ScheduledFuture;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class DisposableFutureHandle implements DisposableHandle {
    public final ScheduledFuture future;

    public DisposableFutureHandle(ScheduledFuture scheduledFuture) {
        this.future = scheduledFuture;
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public final void dispose() {
        this.future.cancel(false);
    }

    public final String toString() {
        return "DisposableFutureHandle[" + this.future + ']';
    }
}
