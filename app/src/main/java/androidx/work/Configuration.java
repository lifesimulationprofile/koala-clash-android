package androidx.work;

import android.os.Build;
import coil.disk.RealDiskCache;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class Configuration {
    public final int contentUriTriggerWorkersLimit;
    public final ExecutorService executor;
    public final int maxSchedulerLimit;
    public final ExecutorService taskExecutor;
    public final SystemClock clock = new SystemClock();
    public final WorkerFactory$1 workerFactory = new WorkerFactory$1();
    public final SystemClock inputMergerFactory = SystemClock.INSTANCE;
    public final RealDiskCache.RealEditor runnableScheduler = new RealDiskCache.RealEditor(27);
    public final int minimumLoggingLevel = 4;
    public final int maxJobSchedulerId = Integer.MAX_VALUE;

    public Configuration() {
        final boolean z = false;
        final boolean z2 = true;
        this.executor = Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), new ThreadFactory() { // from class: androidx.work.ConfigurationKt$createDefaultExecutor$factory$1
            public final AtomicInteger threadCount = new AtomicInteger(0);

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, (z ? "WM.task-" : "androidx.work-") + this.threadCount.incrementAndGet());
            }
        });
        this.taskExecutor = Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), new ThreadFactory() { // from class: androidx.work.ConfigurationKt$createDefaultExecutor$factory$1
            public final AtomicInteger threadCount = new AtomicInteger(0);

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, (z2 ? "WM.task-" : "androidx.work-") + this.threadCount.incrementAndGet());
            }
        });
        this.maxSchedulerLimit = Build.VERSION.SDK_INT == 23 ? 10 : 20;
        this.contentUriTriggerWorkersLimit = 8;
    }
}
