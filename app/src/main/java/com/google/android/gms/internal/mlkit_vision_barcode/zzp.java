package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzp> CREATOR = new zzh(3);
    public String zza;
    public String zzb;
    public String zzc;
    public String zzd;
    public String zze;
    public String zzf;
    public String zzg;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = com.google.android.gms.internal.mlkit_vision_common.zzli.zza(parcel, 20293);
        com.google.android.gms.internal.mlkit_vision_common.zzli.writeString(parcel, 2, this.zza);
        com.google.android.gms.internal.mlkit_vision_common.zzli.writeString(parcel, 3, this.zzb);
        com.google.android.gms.internal.mlkit_vision_common.zzli.writeString(parcel, 4, this.zzc);
        com.google.android.gms.internal.mlkit_vision_common.zzli.writeString(parcel, 5, this.zzd);
        com.google.android.gms.internal.mlkit_vision_common.zzli.writeString(parcel, 6, this.zze);
        com.google.android.gms.internal.mlkit_vision_common.zzli.writeString(parcel, 7, this.zzf);
        com.google.android.gms.internal.mlkit_vision_common.zzli.writeString(parcel, 8, this.zzg);
        com.google.android.gms.internal.mlkit_vision_common.zzli.zzb(parcel, iZza);
    }
}
