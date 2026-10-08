package androidx.work.impl.constraints.trackers;

import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.utils.NetworkApi21;
import androidx.work.impl.utils.NetworkApi23;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class NetworkStateTrackerKt {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("NetworkStateTracker");

    public static final NetworkState getActiveNetworkState(ConnectivityManager connectivityManager) {
        boolean zHasCapabilityCompat;
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        boolean z = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        try {
            NetworkCapabilities networkCapabilitiesCompat = NetworkApi21.getNetworkCapabilitiesCompat(connectivityManager, NetworkApi23.getActiveNetworkCompat(connectivityManager));
            zHasCapabilityCompat = networkCapabilitiesCompat != null ? NetworkApi21.hasCapabilityCompat(networkCapabilitiesCompat, 16) : false;
        } catch (SecurityException e) {
            Logger$LogcatLogger.get().error(TAG, "Unable to validate active network", e);
        }
        return new NetworkState(z, zHasCapabilityCompat, connectivityManager.isActiveNetworkMetered(), (activeNetworkInfo == null || activeNetworkInfo.isRoaming()) ? false : true);
    }
}
