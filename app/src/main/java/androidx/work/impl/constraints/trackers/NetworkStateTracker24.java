package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.net.ConnectivityManager;
import androidx.navigation.NavDestinationBuilder;
import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.utils.NetworkApi21;
import androidx.work.impl.utils.NetworkApi24;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import coil.network.RealNetworkObserver$networkCallback$1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class NetworkStateTracker24 extends NavDestinationBuilder {
    public final ConnectivityManager connectivityManager;
    public final RealNetworkObserver$networkCallback$1 networkCallback;

    public NetworkStateTracker24(Context context, WorkManagerTaskExecutor workManagerTaskExecutor) {
        super(context, workManagerTaskExecutor);
        this.connectivityManager = (ConnectivityManager) ((Context) this.route).getSystemService("connectivity");
        this.networkCallback = new RealNetworkObserver$networkCallback$1(1, this);
    }

    @Override // androidx.navigation.NavDestinationBuilder
    public final Object readSystemState() {
        return NetworkStateTrackerKt.getActiveNetworkState(this.connectivityManager);
    }

    @Override // androidx.navigation.NavDestinationBuilder
    public final void startTracking() {
        try {
            Logger$LogcatLogger.get().debug(NetworkStateTrackerKt.TAG, "Registering network callback");
            NetworkApi24.registerDefaultNetworkCallbackCompat(this.connectivityManager, this.networkCallback);
        } catch (IllegalArgumentException e) {
            Logger$LogcatLogger.get().error(NetworkStateTrackerKt.TAG, "Received exception while registering network callback", e);
        } catch (SecurityException e2) {
            Logger$LogcatLogger.get().error(NetworkStateTrackerKt.TAG, "Received exception while registering network callback", e2);
        }
    }

    @Override // androidx.navigation.NavDestinationBuilder
    public final void stopTracking() {
        try {
            Logger$LogcatLogger.get().debug(NetworkStateTrackerKt.TAG, "Unregistering network callback");
            NetworkApi21.unregisterNetworkCallbackCompat(this.connectivityManager, this.networkCallback);
        } catch (IllegalArgumentException e) {
            Logger$LogcatLogger.get().error(NetworkStateTrackerKt.TAG, "Received exception while unregistering network callback", e);
        } catch (SecurityException e2) {
            Logger$LogcatLogger.get().error(NetworkStateTrackerKt.TAG, "Received exception while unregistering network callback", e2);
        }
    }
}
