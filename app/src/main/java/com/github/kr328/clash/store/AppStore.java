package com.github.kr328.clash.store;

import android.content.Context;
import coil.memory.EmptyStrongMemoryCache;
import com.google.android.gms.tasks.zzr;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import okhttp3.ConnectionPool;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AppStore {
    public static final /* synthetic */ KProperty[] $$delegatedProperties;
    public final zzr autoCheckUpdate$delegate;
    public final ConnectionPool updatedAt$delegate;

    static {
        MutablePropertyReference1Impl mutablePropertyReference1Impl = new MutablePropertyReference1Impl(AppStore.class, "updatedAt", "getUpdatedAt()J", 0);
        Reflection.factory.getClass();
        $$delegatedProperties = new KProperty[]{mutablePropertyReference1Impl, new MutablePropertyReference1Impl(AppStore.class, "autoCheckUpdate", "getAutoCheckUpdate()Z", 0)};
    }

    public AppStore(Context context) {
        ConnectionPool connectionPool = new ConnectionPool(4, new EmptyStrongMemoryCache(20, context.getSharedPreferences("app", 0)));
        this.updatedAt$delegate = new ConnectionPool(3, connectionPool);
        this.autoCheckUpdate$delegate = new zzr(connectionPool, "auto_check_update", true);
    }
}
