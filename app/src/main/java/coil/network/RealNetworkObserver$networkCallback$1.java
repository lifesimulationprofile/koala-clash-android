package coil.network;

import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.util.Log;
import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.constraints.trackers.NetworkStateTracker24;
import androidx.work.impl.constraints.trackers.NetworkStateTrackerKt;
import com.github.kr328.clash.service.clash.module.NetworkObserveModule;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.EmptyList;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class RealNetworkObserver$networkCallback$1 extends ConnectivityManager.NetworkCallback {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object this$0;

    public /* synthetic */ RealNetworkObserver$networkCallback$1(int i, Object obj) {
        this.$r8$classId = i;
        this.this$0 = obj;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network network) {
        switch (this.$r8$classId) {
            case 0:
                RealNetworkObserver.access$onConnectivityChange((RealNetworkObserver) this.this$0, network, true);
                break;
            case 1:
            default:
                super.onAvailable(network);
                break;
            case 2:
                Log.i("KoalaClash", "NetworkObserve onAvailable network=" + network, null);
                ConcurrentHashMap concurrentHashMap = ((NetworkObserveModule) this.this$0).networkInfos;
                EmptyList emptyList = EmptyList.INSTANCE;
                NetworkObserveModule.NetworkInfo networkInfo = new NetworkObserveModule.NetworkInfo();
                networkInfo.losingMs = 0L;
                networkInfo.dnsList = emptyList;
                concurrentHashMap.put(network, networkInfo);
                break;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        switch (this.$r8$classId) {
            case 1:
                Logger$LogcatLogger.get().debug(NetworkStateTrackerKt.TAG, "Network capabilities changed: " + networkCapabilities);
                NetworkStateTracker24 networkStateTracker24 = (NetworkStateTracker24) this.this$0;
                networkStateTracker24.setState(NetworkStateTrackerKt.getActiveNetworkState(networkStateTracker24.connectivityManager));
                break;
            default:
                super.onCapabilitiesChanged(network, networkCapabilities);
                break;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
        switch (this.$r8$classId) {
            case 2:
                Log.i("KoalaClash", "NetworkObserve onLinkPropertiesChanged network=" + network + " " + linkProperties, null);
                NetworkObserveModule.NetworkInfo networkInfo = (NetworkObserveModule.NetworkInfo) ((NetworkObserveModule) this.this$0).networkInfos.get(network);
                if (networkInfo != null) {
                    networkInfo.dnsList = linkProperties.getDnsServers();
                }
                NetworkObserveModule.access$notifyDnsChange((NetworkObserveModule) this.this$0);
                ((NetworkObserveModule) this.this$0).networks.mo851trySendJP2dKIU(network);
                break;
            default:
                super.onLinkPropertiesChanged(network, linkProperties);
                break;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLosing(Network network, int i) {
        switch (this.$r8$classId) {
            case 2:
                Log.i("KoalaClash", "NetworkObserve onLosing network=" + network, null);
                NetworkObserveModule.NetworkInfo networkInfo = (NetworkObserveModule.NetworkInfo) ((NetworkObserveModule) this.this$0).networkInfos.get(network);
                if (networkInfo != null) {
                    networkInfo.losingMs = System.currentTimeMillis() + ((long) i);
                }
                NetworkObserveModule.access$notifyDnsChange((NetworkObserveModule) this.this$0);
                ((NetworkObserveModule) this.this$0).networks.mo851trySendJP2dKIU(network);
                break;
            default:
                super.onLosing(network, i);
                break;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        switch (this.$r8$classId) {
            case 0:
                RealNetworkObserver.access$onConnectivityChange((RealNetworkObserver) this.this$0, network, false);
                break;
            case 1:
                Logger$LogcatLogger.get().debug(NetworkStateTrackerKt.TAG, "Network connection lost");
                NetworkStateTracker24 networkStateTracker24 = (NetworkStateTracker24) this.this$0;
                networkStateTracker24.setState(NetworkStateTrackerKt.getActiveNetworkState(networkStateTracker24.connectivityManager));
                break;
            default:
                Log.i("KoalaClash", "NetworkObserve onLost network=" + network, null);
                NetworkObserveModule networkObserveModule = (NetworkObserveModule) this.this$0;
                networkObserveModule.networkInfos.remove(network);
                NetworkObserveModule.access$notifyDnsChange(networkObserveModule);
                networkObserveModule.networks.mo851trySendJP2dKIU(network);
                break;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onUnavailable() {
        switch (this.$r8$classId) {
            case 2:
                Log.i("KoalaClash", "NetworkObserve onUnavailable", null);
                break;
            default:
                super.onUnavailable();
                break;
        }
    }
}
