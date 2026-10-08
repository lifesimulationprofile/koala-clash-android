package com.google.android.gms.internal.mlkit_vision_barcode;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzwd {
    public final String zza;
    public final int zzc;

    public zzwd(String str, int i) {
        this.zza = str;
        this.zzc = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzwd)) {
            return false;
        }
        zzwd zzwdVar = (zzwd) obj;
        return this.zza.equals(zzwdVar.zza) && this.zzc == zzwdVar.zzc;
    }

    public final int hashCode() {
        return ((((this.zza.hashCode() ^ 1000003) * 1000003) ^ 1231) * 1000003) ^ this.zzc;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("MLKitLoggingOptions{libraryName=");
        sb.append(this.zza);
        sb.append(", enableFirelog=true, firelogEventType=");
        return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, this.zzc, "}");
    }
}
