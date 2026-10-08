package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.WorkManagerImpl;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public class RescheduleReceiver extends BroadcastReceiver {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("RescheduleReceiver");

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Logger$LogcatLogger.get().debug(TAG, "Received intent " + intent);
        try {
            WorkManagerImpl instance$1 = WorkManagerImpl.getInstance$1(context);
            BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
            synchronized (WorkManagerImpl.sLock) {
                try {
                    BroadcastReceiver.PendingResult pendingResult = instance$1.mRescheduleReceiverResult;
                    if (pendingResult != null) {
                        pendingResult.finish();
                    }
                    instance$1.mRescheduleReceiverResult = pendingResultGoAsync;
                    if (instance$1.mForceStopRunnableCompleted) {
                        pendingResultGoAsync.finish();
                        instance$1.mRescheduleReceiverResult = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (IllegalStateException e) {
            Logger$LogcatLogger.get().error(TAG, "Cannot reschedule jobs. WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e);
        }
    }
}
