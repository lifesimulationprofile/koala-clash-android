package androidx.work.impl.background.systemalarm;

import android.content.Context;
import androidx.work.Logger$LogcatLogger;
import androidx.work.SystemClock;
import coil.memory.EmptyStrongMemoryCache;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ConstraintsCommandHandler {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("ConstraintsCmdHandler");
    public final SystemClock mClock;
    public final Context mContext;
    public final int mStartId;
    public final EmptyStrongMemoryCache mWorkConstraintsTracker;

    public ConstraintsCommandHandler(Context context, SystemClock systemClock, int i, SystemAlarmDispatcher systemAlarmDispatcher) {
        this.mContext = context;
        this.mClock = systemClock;
        this.mStartId = i;
        this.mWorkConstraintsTracker = new EmptyStrongMemoryCache(systemAlarmDispatcher.mWorkManager.mTrackers);
    }
}
