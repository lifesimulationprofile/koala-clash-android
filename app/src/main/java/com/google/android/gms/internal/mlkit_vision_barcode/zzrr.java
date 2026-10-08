package com.google.android.gms.internal.mlkit_vision_barcode;

import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzrr {
    public final zzqq zza;
    public final zzvz zzb;
    public final zzdk zzc;
    public final zzdk zzd;
    public final zzqk zze;

    public /* synthetic */ zzrr(Request request) {
        this.zza = (zzqq) request.url;
        this.zzb = (zzvz) request.method;
        this.zzc = (zzdk) request.headers;
        this.zzd = (zzdk) request.tags;
        this.zze = (zzqk) request.lazyCacheControl;
    }
}
