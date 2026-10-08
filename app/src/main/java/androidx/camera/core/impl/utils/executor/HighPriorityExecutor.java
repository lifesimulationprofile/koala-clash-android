package androidx.camera.core.impl.utils.executor;

import androidx.core.provider.RequestExecutor$DefaultThreadFactory;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class HighPriorityExecutor implements Executor {
    public static volatile HighPriorityExecutor sExecutor;
    public final /* synthetic */ int $r8$classId;
    public final Object mHighPriorityService;

    public HighPriorityExecutor() {
        this.$r8$classId = 0;
        this.mHighPriorityService = Executors.newSingleThreadExecutor(new RequestExecutor$DefaultThreadFactory(1));
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.$r8$classId) {
            case 0:
                ((ExecutorService) this.mHighPriorityService).execute(runnable);
                break;
            default:
                ((WorkManagerTaskExecutor) this.mHighPriorityService).mMainThreadHandler.post(runnable);
                break;
        }
    }

    public HighPriorityExecutor(WorkManagerTaskExecutor workManagerTaskExecutor) {
        this.$r8$classId = 1;
        this.mHighPriorityService = workManagerTaskExecutor;
    }
}
