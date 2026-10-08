package androidx.core.os;

import android.os.Handler;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ExecutorCompat$HandlerExecutor implements Executor {
    public final /* synthetic */ int $r8$classId;
    public final Handler mHandler;

    public /* synthetic */ ExecutorCompat$HandlerExecutor(Handler handler, int i) {
        this.$r8$classId = i;
        this.mHandler = handler;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.$r8$classId) {
            case 0:
                runnable.getClass();
                Handler handler = this.mHandler;
                if (handler.post(runnable)) {
                    return;
                }
                throw new RejectedExecutionException(handler + " is shutting down");
            default:
                this.mHandler.post(runnable);
                return;
        }
    }
}
