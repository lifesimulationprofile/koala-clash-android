package androidx.core.view;

import android.content.Context;
import android.view.VelocityTracker;
import coil.disk.RealDiskCache;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class DifferentialMotionFlingController {
    public final Context mContext;
    public float mLastFlingVelocity;
    public final RealDiskCache.RealEditor mTarget;
    public VelocityTracker mVelocityTracker;
    public int mLastProcessedAxis = -1;
    public int mLastProcessedSource = -1;
    public int mLastProcessedDeviceId = -1;
    public final int[] mFlingVelocityThresholds = {Integer.MAX_VALUE, 0};

    public DifferentialMotionFlingController(Context context, RealDiskCache.RealEditor realEditor) {
        this.mContext = context;
        this.mTarget = realEditor;
    }
}
