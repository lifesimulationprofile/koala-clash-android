package com.github.kr328.clash.design.store;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import coil.ImageLoader$Builder;
import coil.memory.EmptyStrongMemoryCache;
import com.github.kr328.clash.core.model.ProxySort;
import com.github.kr328.clash.design.model.AppInfoSort;
import com.github.kr328.clash.design.model.DarkMode;
import com.google.android.gms.tasks.zzr;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import okhttp3.ConnectionPool;
import okhttp3.Request;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class UiStore {
    public static final /* synthetic */ KProperty[] $$delegatedProperties;
    public static final ByteString.Companion Companion;
    public final zzr accessControlReverse$delegate;
    public final Request.Builder accessControlSort$delegate;
    public final zzr accessControlSystemApp$delegate;
    public final Request.Builder darkMode$delegate;
    public final zzr enableVpn$delegate;
    public final zzr hideAppIcon$delegate;
    public final zzr hideFromRecents$delegate;
    public final zzr proxyExcludeNotSelectable$delegate;
    public final ImageLoader$Builder proxyLastGroup$delegate;
    public final Request.Builder proxySort$delegate;

    static {
        MutablePropertyReference1Impl mutablePropertyReference1Impl = new MutablePropertyReference1Impl(UiStore.class, "enableVpn", "getEnableVpn()Z", 0);
        Reflection.factory.getClass();
        $$delegatedProperties = new KProperty[]{mutablePropertyReference1Impl, new MutablePropertyReference1Impl(UiStore.class, "darkMode", "getDarkMode()Lcom/github/kr328/clash/design/model/DarkMode;", 0), new MutablePropertyReference1Impl(UiStore.class, "hideAppIcon", "getHideAppIcon()Z", 0), new MutablePropertyReference1Impl(UiStore.class, "hideFromRecents", "getHideFromRecents()Z", 0), new MutablePropertyReference1Impl(UiStore.class, "proxyExcludeNotSelectable", "getProxyExcludeNotSelectable()Z", 0), new MutablePropertyReference1Impl(UiStore.class, "proxyLine", "getProxyLine()I", 0), new MutablePropertyReference1Impl(UiStore.class, "proxySort", "getProxySort()Lcom/github/kr328/clash/core/model/ProxySort;", 0), new MutablePropertyReference1Impl(UiStore.class, "proxyLastGroup", "getProxyLastGroup()Ljava/lang/String;", 0), new MutablePropertyReference1Impl(UiStore.class, "accessControlSort", "getAccessControlSort()Lcom/github/kr328/clash/design/model/AppInfoSort;", 0), new MutablePropertyReference1Impl(UiStore.class, "accessControlReverse", "getAccessControlReverse()Z", 0), new MutablePropertyReference1Impl(UiStore.class, "accessControlSystemApp", "getAccessControlSystemApp()Z", 0)};
        Companion = new ByteString.Companion(14);
    }

    public UiStore(Context context) {
        ConnectionPool connectionPool = new ConnectionPool(4, new EmptyStrongMemoryCache(20, context.getSharedPreferences("ui", 0)));
        this.enableVpn$delegate = new zzr(connectionPool, "enable_vpn", true);
        this.darkMode$delegate = new Request.Builder(connectionPool, "dark_mode", DarkMode.Auto, DarkMode.values());
        PackageManager packageManager = context.getPackageManager();
        Companion.getClass();
        int componentEnabledSetting = packageManager.getComponentEnabledSetting(new ComponentName(context, "com.github.kr328.clash.MainActivityAlias"));
        this.hideAppIcon$delegate = new zzr(connectionPool, "hide_app_icon", (componentEnabledSetting == 1 || componentEnabledSetting == 0) ? false : true);
        this.hideFromRecents$delegate = new zzr(connectionPool, "hide_from_recents", false);
        this.proxyExcludeNotSelectable$delegate = new zzr(connectionPool, "proxy_exclude_not_selectable", false);
        this.proxySort$delegate = new Request.Builder(connectionPool, "proxy_sort", ProxySort.Default, ProxySort.values());
        this.proxyLastGroup$delegate = new ImageLoader$Builder(connectionPool, "proxy_last_group", "", 13);
        this.accessControlSort$delegate = new Request.Builder(connectionPool, "access_control_sort", AppInfoSort.Label, AppInfoSort.values());
        this.accessControlReverse$delegate = new zzr(connectionPool, "access_control_reverse", false);
        this.accessControlSystemApp$delegate = new zzr(connectionPool, "access_control_system_app", false);
    }
}
