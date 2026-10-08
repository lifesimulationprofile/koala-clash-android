package androidx.work.impl.workers;

import android.content.Context;
import android.os.Build;
import androidx.work.CoroutineWorker$$ExternalSyntheticLambda0;
import androidx.work.ListenableWorker;
import androidx.work.Logger$LogcatLogger;
import androidx.work.WorkerParameters;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.OnConstraintsStateChangedListener;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import kotlin.Unit;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ConstraintTrackingWorker extends ListenableWorker implements OnConstraintsStateChangedListener {
    public volatile boolean areConstraintsUnmet;
    public ListenableWorker delegate;
    public final SettableFuture future;
    public final Object lock;
    public final WorkerParameters workerParameters;

    public ConstraintTrackingWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.workerParameters = workerParameters;
        this.lock = new Object();
        this.future = new SettableFuture();
    }

    @Override // androidx.work.impl.constraints.OnConstraintsStateChangedListener
    public final void onConstraintsStateChanged(WorkSpec workSpec, ConstraintsState constraintsState) {
        Logger$LogcatLogger.get().debug(ConstraintTrackingWorkerKt.TAG, "Constraints changed for " + workSpec);
        if (constraintsState instanceof ConstraintsState.ConstraintsNotMet) {
            synchronized (this.lock) {
                this.areConstraintsUnmet = true;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Override // androidx.work.ListenableWorker
    public final void onStopped() {
        ListenableWorker listenableWorker = this.delegate;
        if (listenableWorker == null || listenableWorker.mStopReason != -256) {
            return;
        }
        listenableWorker.stop(Build.VERSION.SDK_INT >= 31 ? this.mStopReason : 0);
    }

    @Override // androidx.work.ListenableWorker
    public final SettableFuture startWork() {
        this.mWorkerParams.mBackgroundExecutor.execute(new CoroutineWorker$$ExternalSyntheticLambda0(5, this));
        return this.future;
    }
}
