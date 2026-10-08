package com.github.kr328.clash.service.data;

import androidx.room.RoomDatabase;
import coil.network.RealNetworkObserver;
import com.github.kr328.clash.common.Global;
import com.github.kr328.clash.remote.Remote$launch$2;
import com.google.mlkit.common.internal.zzd;
import java.lang.ref.SoftReference;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Database extends RoomDatabase {
    public static final zzd Companion = new zzd();
    public static SoftReference softDatabase = new SoftReference(null);

    static {
        Global global = Global.INSTANCE;
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        JobKt.launch$default(global, DefaultIoScheduler.INSTANCE, new Remote$launch$2(2, null, 1), 2);
    }

    public abstract Dispatcher openImportedDao();

    public abstract RealNetworkObserver openSelectionProxyDao();
}
