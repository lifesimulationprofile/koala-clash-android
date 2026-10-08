package androidx.work.impl.background.greedy;

import androidx.work.Logger$LogcatLogger;
import androidx.work.SystemClock;
import coil.disk.RealDiskCache;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class DelayedWorkTracker {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("DelayedWorkTracker");
    public final SystemClock mClock;
    public final GreedyScheduler mImmediateScheduler;
    public final RealDiskCache.RealEditor mRunnableScheduler;
    public final HashMap mRunnables = new HashMap();

    public DelayedWorkTracker(GreedyScheduler greedyScheduler, RealDiskCache.RealEditor realEditor, SystemClock systemClock) {
        this.mImmediateScheduler = greedyScheduler;
        this.mRunnableScheduler = realEditor;
        this.mClock = systemClock;
    }
}
