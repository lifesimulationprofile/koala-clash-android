package androidx.lifecycle;

import android.app.Activity;
import android.os.Handler;
import androidx.work.CoroutineWorker$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ProcessLifecycleOwner implements LifecycleOwner {
    public static final ProcessLifecycleOwner newInstance = new ProcessLifecycleOwner();
    public Handler handler;
    public int resumedCounter;
    public int startedCounter;
    public boolean pauseSent = true;
    public boolean stopSent = true;
    public final LifecycleRegistry registry = new LifecycleRegistry(this, true);
    public final CoroutineWorker$$ExternalSyntheticLambda0 delayedPauseRunnable = new CoroutineWorker$$ExternalSyntheticLambda0(4, this);
    public final AtomicReference initializationListener = new AtomicReference(this);

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public abstract class Api29Impl {
        public static final void registerActivityLifecycleCallbacks(Activity activity, ProcessLifecycleOwner$attach$1$onActivityPreCreated$1 processLifecycleOwner$attach$1$onActivityPreCreated$1) {
            activity.registerActivityLifecycleCallbacks(processLifecycleOwner$attach$1$onActivityPreCreated$1);
        }
    }

    public final void activityResumed$lifecycle_process_release() {
        int i = this.resumedCounter + 1;
        this.resumedCounter = i;
        if (i == 1) {
            if (!this.pauseSent) {
                this.handler.removeCallbacks(this.delayedPauseRunnable);
            } else {
                this.registry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
                this.pauseSent = false;
            }
        }
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return this.registry;
    }
}
