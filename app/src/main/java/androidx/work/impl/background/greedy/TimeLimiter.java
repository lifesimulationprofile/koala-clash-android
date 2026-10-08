package androidx.work.impl.background.greedy;

import android.os.Handler;
import androidx.camera.core.Preview$$ExternalSyntheticLambda1;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.WorkLauncherImpl;
import coil.disk.RealDiskCache;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class TimeLimiter {
    public final WorkLauncherImpl launcher;
    public final Object lock;
    public final RealDiskCache.RealEditor runnableScheduler;
    public final long timeoutMs;
    public final LinkedHashMap tracked;

    public TimeLimiter(RealDiskCache.RealEditor realEditor, WorkLauncherImpl workLauncherImpl) {
        long millis = TimeUnit.MINUTES.toMillis(90L);
        this.runnableScheduler = realEditor;
        this.launcher = workLauncherImpl;
        this.timeoutMs = millis;
        this.lock = new Object();
        this.tracked = new LinkedHashMap();
    }

    public final void cancel(StartStopToken startStopToken) {
        Runnable runnable;
        synchronized (this.lock) {
            runnable = (Runnable) this.tracked.remove(startStopToken);
        }
        if (runnable != null) {
            ((Handler) this.runnableScheduler.editor).removeCallbacks(runnable);
        }
    }

    public final void track(StartStopToken startStopToken) {
        Preview$$ExternalSyntheticLambda1 preview$$ExternalSyntheticLambda1 = new Preview$$ExternalSyntheticLambda1(29, this, startStopToken);
        synchronized (this.lock) {
        }
        RealDiskCache.RealEditor realEditor = this.runnableScheduler;
        ((Handler) realEditor.editor).postDelayed(preview$$ExternalSyntheticLambda1, this.timeoutMs);
    }
}
