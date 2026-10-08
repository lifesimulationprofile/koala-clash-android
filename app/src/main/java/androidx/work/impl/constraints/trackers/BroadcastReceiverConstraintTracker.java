package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.navigation.NavDestinationBuilder;
import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import com.github.kr328.clash.TileService$receiver$1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class BroadcastReceiverConstraintTracker extends NavDestinationBuilder {
    public final TileService$receiver$1 broadcastReceiver;

    public BroadcastReceiverConstraintTracker(Context context, WorkManagerTaskExecutor workManagerTaskExecutor) {
        super(context, workManagerTaskExecutor);
        this.broadcastReceiver = new TileService$receiver$1(2, this);
    }

    public abstract IntentFilter getIntentFilter();

    public abstract void onBroadcastReceive(Intent intent);

    @Override // androidx.navigation.NavDestinationBuilder
    public final void startTracking() {
        Logger$LogcatLogger.get().debug(BroadcastReceiverConstraintTrackerKt.TAG, getClass().getSimpleName().concat(": registering receiver"));
        ((Context) this.route).registerReceiver(this.broadcastReceiver, getIntentFilter());
    }

    @Override // androidx.navigation.NavDestinationBuilder
    public final void stopTracking() {
        Logger$LogcatLogger.get().debug(BroadcastReceiverConstraintTrackerKt.TAG, getClass().getSimpleName().concat(": unregistering receiver"));
        ((Context) this.route).unregisterReceiver(this.broadcastReceiver);
    }
}
