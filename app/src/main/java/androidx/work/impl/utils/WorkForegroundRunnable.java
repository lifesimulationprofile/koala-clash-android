package androidx.work.impl.utils;

import android.content.Context;
import android.os.Build;
import androidx.work.ListenableWorker;
import androidx.work.Logger$LogcatLogger;
import androidx.work.Worker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import kotlinx.coroutines.android.HandlerContext$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class WorkForegroundRunnable implements Runnable {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("WorkForegroundRunnable");
    public final Context mContext;
    public final WorkForegroundUpdater mForegroundUpdater;
    public final SettableFuture mFuture = new SettableFuture();
    public final WorkManagerTaskExecutor mTaskExecutor;
    public final WorkSpec mWorkSpec;
    public final ListenableWorker mWorker;

    public WorkForegroundRunnable(Context context, WorkSpec workSpec, ListenableWorker listenableWorker, WorkForegroundUpdater workForegroundUpdater, WorkManagerTaskExecutor workManagerTaskExecutor) {
        this.mContext = context;
        this.mWorkSpec = workSpec;
        this.mWorker = listenableWorker;
        this.mForegroundUpdater = workForegroundUpdater;
        this.mTaskExecutor = workManagerTaskExecutor;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.mWorkSpec.expedited || Build.VERSION.SDK_INT >= 31) {
            this.mFuture.set(null);
            return;
        }
        SettableFuture settableFuture = new SettableFuture();
        WorkManagerTaskExecutor workManagerTaskExecutor = this.mTaskExecutor;
        workManagerTaskExecutor.mMainThreadExecutor.execute(new HandlerContext$$ExternalSyntheticLambda0(2, this, settableFuture));
        settableFuture.addListener(new Worker.AnonymousClass2(14, this, settableFuture, false), workManagerTaskExecutor.mMainThreadExecutor);
    }
}
