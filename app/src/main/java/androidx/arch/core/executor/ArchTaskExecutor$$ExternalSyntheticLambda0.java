package androidx.arch.core.executor;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ArchTaskExecutor$$ExternalSyntheticLambda0 implements Executor {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ ArchTaskExecutor$$ExternalSyntheticLambda0(int i) {
        this.$r8$classId = i;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.$r8$classId) {
            case 0:
                ArchTaskExecutor.getInstance().mDelegate.mDiskIO.execute(runnable);
                break;
            default:
                runnable.run();
                break;
        }
    }
}
