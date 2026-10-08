package com.google.android.gms.internal.mlkit_vision_common;

import coil.network.RealNetworkObserver;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zziy {
    public final zzla zza;
    public final zziv zzb;
    public final zziq zzc;

    public /* synthetic */ zziy(RealNetworkObserver realNetworkObserver) {
        this.zza = (zzla) realNetworkObserver.connectivityManager;
        this.zzb = (zziv) realNetworkObserver.listener;
        this.zzc = (zziq) realNetworkObserver.networkCallback;
    }
}
