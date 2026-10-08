package androidx.work.impl.background.systemjob;

import android.content.ComponentName;
import android.content.Context;
import androidx.work.Logger$LogcatLogger;
import androidx.work.SystemClock;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class SystemJobInfoConverter {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("SystemJobInfoConverter");
    public final SystemClock mClock;
    public final ComponentName mWorkServiceComponent;

    public SystemJobInfoConverter(Context context, SystemClock systemClock) {
        this.mClock = systemClock;
        this.mWorkServiceComponent = new ComponentName(context.getApplicationContext(), (Class<?>) SystemJobService.class);
    }
}
