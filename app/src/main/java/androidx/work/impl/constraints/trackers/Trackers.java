package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.os.Build;
import androidx.navigation.NavDestinationBuilder;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class Trackers {
    public final BatteryNotLowTracker batteryChargingTracker;
    public final BatteryNotLowTracker batteryNotLowTracker;
    public final NavDestinationBuilder networkStateTracker;
    public final BatteryNotLowTracker storageNotLowTracker;

    public Trackers(Context context, WorkManagerTaskExecutor workManagerTaskExecutor) {
        BatteryNotLowTracker batteryNotLowTracker = new BatteryNotLowTracker(context.getApplicationContext(), workManagerTaskExecutor, 1);
        BatteryNotLowTracker batteryNotLowTracker2 = new BatteryNotLowTracker(context.getApplicationContext(), workManagerTaskExecutor, 0);
        Context applicationContext = context.getApplicationContext();
        String str = NetworkStateTrackerKt.TAG;
        NavDestinationBuilder networkStateTracker24 = Build.VERSION.SDK_INT >= 24 ? new NetworkStateTracker24(applicationContext, workManagerTaskExecutor) : new NetworkStateTrackerPre24(applicationContext, workManagerTaskExecutor);
        BatteryNotLowTracker batteryNotLowTracker3 = new BatteryNotLowTracker(context.getApplicationContext(), workManagerTaskExecutor, 2);
        this.batteryChargingTracker = batteryNotLowTracker;
        this.batteryNotLowTracker = batteryNotLowTracker2;
        this.networkStateTracker = networkStateTracker24;
        this.storageNotLowTracker = batteryNotLowTracker3;
    }
}
