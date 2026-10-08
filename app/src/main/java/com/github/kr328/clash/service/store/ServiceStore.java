package com.github.kr328.clash.service.store;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import coil.ImageLoader$Builder;
import coil.memory.EmptyStrongMemoryCache;
import coil.network.RealNetworkObserver;
import com.github.kr328.clash.common.constants.Authorities;
import com.github.kr328.clash.remote.Remote$$ExternalSyntheticLambda1;
import com.github.kr328.clash.service.BaseService;
import com.github.kr328.clash.service.PreferenceProvider;
import com.github.kr328.clash.service.TunService;
import com.github.kr328.clash.service.model.AccessControlMode;
import com.google.android.gms.tasks.zzr;
import java.util.Set;
import java.util.UUID;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import okhttp3.ConnectionPool;
import okhttp3.Request;
import rikka.preference.MultiProcessPreference;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ServiceStore {
    public static final /* synthetic */ KProperty[] $$delegatedProperties;
    public final Request.Builder accessControlMode$delegate;
    public final EmptyStrongMemoryCache accessControlPackages$delegate;
    public final RealNetworkObserver activeProfile$delegate;
    public final zzr allowBypass$delegate;
    public final zzr allowIpv6$delegate;
    public final zzr bypassPrivateNetwork$delegate;
    public final zzr dnsHijacking$delegate;
    public final zzr dynamicNotification$delegate;
    public final zzr systemProxy$delegate;
    public final ImageLoader$Builder tunStackMode$delegate;

    static {
        MutablePropertyReference1Impl mutablePropertyReference1Impl = new MutablePropertyReference1Impl(ServiceStore.class, "activeProfile", "getActiveProfile()Ljava/util/UUID;", 0);
        Reflection.factory.getClass();
        $$delegatedProperties = new KProperty[]{mutablePropertyReference1Impl, new MutablePropertyReference1Impl(ServiceStore.class, "bypassPrivateNetwork", "getBypassPrivateNetwork()Z", 0), new MutablePropertyReference1Impl(ServiceStore.class, "accessControlMode", "getAccessControlMode()Lcom/github/kr328/clash/service/model/AccessControlMode;", 0), new MutablePropertyReference1Impl(ServiceStore.class, "accessControlPackages", "getAccessControlPackages()Ljava/util/Set;", 0), new MutablePropertyReference1Impl(ServiceStore.class, "dnsHijacking", "getDnsHijacking()Z", 0), new MutablePropertyReference1Impl(ServiceStore.class, "systemProxy", "getSystemProxy()Z", 0), new MutablePropertyReference1Impl(ServiceStore.class, "allowBypass", "getAllowBypass()Z", 0), new MutablePropertyReference1Impl(ServiceStore.class, "allowIpv6", "getAllowIpv6()Z", 0), new MutablePropertyReference1Impl(ServiceStore.class, "tunStackMode", "getTunStackMode()Ljava/lang/String;", 0), new MutablePropertyReference1Impl(ServiceStore.class, "dynamicNotification", "getDynamicNotification()Z", 0)};
    }

    public ServiceStore(Context context) {
        int i = PreferenceProvider.$r8$clinit;
        ConnectionPool connectionPool = new ConnectionPool(4, new EmptyStrongMemoryCache(20, ((context instanceof BaseService) || (context instanceof TunService)) ? ((ContextWrapper) context).getSharedPreferences("service", 0) : new MultiProcessPreference(context, Authorities.SETTINGS_PROVIDER)));
        this.activeProfile$delegate = new RealNetworkObserver(connectionPool, new Remote$$ExternalSyntheticLambda1(11), new Remote$$ExternalSyntheticLambda1(10), 13, false);
        this.bypassPrivateNetwork$delegate = new zzr(connectionPool, "bypass_private_network", true);
        this.accessControlMode$delegate = new Request.Builder(connectionPool, "access_control_mode", AccessControlMode.AcceptAll, AccessControlMode.values());
        this.accessControlPackages$delegate = new EmptyStrongMemoryCache(21, connectionPool);
        this.dnsHijacking$delegate = new zzr(connectionPool, "dns_hijacking", true);
        this.systemProxy$delegate = new zzr(connectionPool, "system_proxy", true);
        this.allowBypass$delegate = new zzr(connectionPool, "allow_bypass", false);
        this.allowIpv6$delegate = new zzr(connectionPool, "allow_ipv6", false);
        this.tunStackMode$delegate = new ImageLoader$Builder(connectionPool, "tun_stack_mode", "system", 13);
        this.dynamicNotification$delegate = new zzr(connectionPool, "dynamic_notification", true);
    }

    public final Set getAccessControlPackages() {
        KProperty kProperty = $$delegatedProperties[3];
        return ((SharedPreferences) ((EmptyStrongMemoryCache) ((ConnectionPool) this.accessControlPackages$delegate.weakMemoryCache).delegate).weakMemoryCache).getStringSet("access_control_packages", EmptySet.INSTANCE);
    }

    public final UUID getActiveProfile() {
        KProperty kProperty = $$delegatedProperties[0];
        RealNetworkObserver realNetworkObserver = this.activeProfile$delegate;
        EmptyStrongMemoryCache emptyStrongMemoryCache = (EmptyStrongMemoryCache) ((ConnectionPool) realNetworkObserver.connectivityManager).delegate;
        return (UUID) ((Remote$$ExternalSyntheticLambda1) realNetworkObserver.networkCallback).invoke(((SharedPreferences) emptyStrongMemoryCache.weakMemoryCache).getString("active_profile", (String) ((Remote$$ExternalSyntheticLambda1) realNetworkObserver.listener).invoke(null)));
    }

    public final boolean getAllowIpv6() {
        KProperty kProperty = $$delegatedProperties[7];
        return ((Boolean) this.allowIpv6$delegate.getValue()).booleanValue();
    }

    public final boolean getBypassPrivateNetwork() {
        KProperty kProperty = $$delegatedProperties[1];
        return ((Boolean) this.bypassPrivateNetwork$delegate.getValue()).booleanValue();
    }

    public final boolean getDynamicNotification() {
        KProperty kProperty = $$delegatedProperties[9];
        return ((Boolean) this.dynamicNotification$delegate.getValue()).booleanValue();
    }
}
