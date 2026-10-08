package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzxr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzxr> CREATOR = new zzh(17);
    public final String zza;
    public final String zzb;
    public final String zzc;
    public final String zzd;
    public final String zze;
    public final zzxq zzf;
    public final zzxq zzg;

    public zzxr(String str, String str2, String str3, String str4, String str5, zzxq zzxqVar, zzxq zzxqVar2) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = str5;
        this.zzf = zzxqVar;
        this.zzg = zzxqVar2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = com.google.android.gms.internal.mlkit_vision_common.zzli.zza(parcel, 20293);
        com.google.android.gms.internal.mlkit_vision_common.zzli.writeString(parcel, 1, this.zza);
        com.google.android.gms.internal.mlkit_vision_common.zzli.writeString(parcel, 2, this.zzb);
        com.google.android.gms.internal.mlkit_vision_common.zzli.writeString(parcel, 3, this.zzc);
        com.google.android.gms.internal.mlkit_vision_common.zzli.writeString(parcel, 4, this.zzd);
        com.google.android.gms.internal.mlkit_vision_common.zzli.writeString(parcel, 5, this.zze);
        com.google.android.gms.internal.mlkit_vision_common.zzli.writeParcelable(parcel, 6, this.zzf, i);
        com.google.android.gms.internal.mlkit_vision_common.zzli.writeParcelable(parcel, 7, this.zzg, i);
        com.google.android.gms.internal.mlkit_vision_common.zzli.zzb(parcel, iZza);
    }
}
