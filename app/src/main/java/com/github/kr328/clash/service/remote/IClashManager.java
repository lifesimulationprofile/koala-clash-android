package com.github.kr328.clash.service.remote;

import com.github.kr328.clash.core.model.Provider;
import com.github.kr328.clash.core.model.ProviderList;
import com.github.kr328.clash.core.model.ProxyGroup;
import com.github.kr328.clash.core.model.ProxySort;
import com.github.kr328.clash.core.model.TunnelState;
import com.github.kr328.clash.core.model.UiConfiguration;
import java.util.List;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface IClashManager {
    void addClosedConnections(String str);

    void clearClosedConnections();

    void closeAllConnections();

    void closeConnection(String str);

    Object healthCheck(String str, Continuation continuation);

    Object healthCheckProxy(String str, String str2, Continuation continuation);

    void patchOverrideMode(TunnelState.Mode mode);

    boolean patchSelector(String str, String str2);

    String queryClosedConnections();

    TunnelState.Mode queryConfigMode();

    UiConfiguration queryConfiguration();

    String queryConnections();

    TunnelState.Mode queryOverrideMode();

    ProviderList queryProviders();

    ProxyGroup queryProxyGroup(String str, ProxySort proxySort);

    List queryProxyGroupNames(boolean z);

    long queryTrafficTotal();

    TunnelState queryTunnelState();

    void setLogObserver(ILogObserver iLogObserver);

    Object updateProvider(Provider.Type type, String str, Continuation continuation);
}
