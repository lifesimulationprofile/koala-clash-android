package androidx.work.impl.utils;

import android.content.Context;
import android.os.PowerManager;
import androidx.work.Logger$LogcatLogger;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class WakeLocks {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("WakeLocks");

    public static final PowerManager.WakeLock newWakeLock(Context context, String str) {
        PowerManager powerManager = (PowerManager) context.getApplicationContext().getSystemService("power");
        String strConcat = "WorkManager: ".concat(str);
        PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(1, strConcat);
        synchronized (WakeLocksHolder.INSTANCE) {
        }
        return wakeLockNewWakeLock;
    }
}
