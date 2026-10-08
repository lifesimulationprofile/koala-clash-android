package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Arrays;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzft {
    public final zzrb zza;
    public final Boolean zzc;
    public final zzvz zze;
    public final zzdk zzf;
    public final zzdk zzg;

    public /* synthetic */ zzft(Request request) {
        this.zza = (zzrb) request.url;
        this.zzc = (Boolean) request.method;
        this.zze = (zzvz) request.headers;
        this.zzf = (zzdk) request.tags;
        this.zzg = (zzdk) request.lazyCacheControl;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzft)) {
            return false;
        }
        zzft zzftVar = (zzft) obj;
        return com.google.android.gms.common.internal.zzah.equal(this.zza, zzftVar.zza) && com.google.android.gms.common.internal.zzah.equal(null, null) && com.google.android.gms.common.internal.zzah.equal(this.zzc, zzftVar.zzc) && com.google.android.gms.common.internal.zzah.equal(null, null) && com.google.android.gms.common.internal.zzah.equal(this.zze, zzftVar.zze) && com.google.android.gms.common.internal.zzah.equal(this.zzf, zzftVar.zzf) && com.google.android.gms.common.internal.zzah.equal(this.zzg, zzftVar.zzg);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, null, this.zzc, null, this.zze, this.zzf, this.zzg});
    }
}
