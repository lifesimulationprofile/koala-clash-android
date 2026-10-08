package androidx.core.view;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class VelocityTrackerFallback {
    public final float[] mMovements = new float[20];
    public final long[] mEventTimes = new long[20];
    public float mLastComputedVelocity = 0.0f;
    public int mDataPointsBufferSize = 0;
    public int mDataPointsBufferLastUsedIndex = 0;
}
