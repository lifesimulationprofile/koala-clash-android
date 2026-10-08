package com.google.android.gms.internal.mlkit_vision_barcode;

import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzqq {
    public final Long zza;
    public final zzrb zzb;
    public final Boolean zzc;
    public final Boolean zzd;
    public final Boolean zze;

    public /* synthetic */ zzqq(Request request) {
        this.zza = (Long) request.url;
        this.zzb = (zzrb) request.method;
        this.zzc = (Boolean) request.headers;
        this.zzd = (Boolean) request.tags;
        this.zze = (Boolean) request.lazyCacheControl;
    }
}
