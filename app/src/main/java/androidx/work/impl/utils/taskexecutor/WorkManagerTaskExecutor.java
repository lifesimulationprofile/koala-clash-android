package androidx.work.impl.utils.taskexecutor;

import android.os.Handler;
import android.os.Looper;
import androidx.camera.core.impl.utils.executor.HighPriorityExecutor;
import androidx.room.TransactionExecutor;
import java.util.concurrent.ExecutorService;
import kotlinx.coroutines.ExecutorCoroutineDispatcherImpl;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class WorkManagerTaskExecutor {
    public final TransactionExecutor mBackgroundExecutor;
    public final ExecutorCoroutineDispatcherImpl mTaskDispatcher;
    public final Handler mMainThreadHandler = new Handler(Looper.getMainLooper());
    public final HighPriorityExecutor mMainThreadExecutor = new HighPriorityExecutor(this);

    public WorkManagerTaskExecutor(ExecutorService executorService) {
        TransactionExecutor transactionExecutor = new TransactionExecutor(executorService, 1);
        this.mBackgroundExecutor = transactionExecutor;
        this.mTaskDispatcher = new ExecutorCoroutineDispatcherImpl(transactionExecutor);
    }

    public final void executeOnTaskThread(Runnable runnable) {
        this.mBackgroundExecutor.execute(runnable);
    }
}
