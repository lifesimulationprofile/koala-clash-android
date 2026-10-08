package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new zzh(11);
    public int zza;
    public int zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public int zzf;
    public boolean zzg;
    public String zzh;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = com.google.android.gms.internal.mlkit_vision_common.zzli.zza(parcel, 20293);
        int i2 = this.zza;
        com.google.android.gms.internal.mlkit_vision_common.zzli.zzc(parcel, 2, 4);
        parcel.writeInt(i2);
        int i3 = this.zzb;
        com.google.android.gms.internal.mlkit_vision_common.zzli.zzc(parcel, 3, 4);
        parcel.writeInt(i3);
        int i4 = this.zzc;
        com.google.android.gms.internal.mlkit_vision_common.zzli.zzc(parcel, 4, 4);
        parcel.writeInt(i4);
        int i5 = this.zzd;
        com.google.android.gms.internal.mlkit_vision_common.zzli.zzc(parcel, 5, 4);
        parcel.writeInt(i5);
        int i6 = this.zze;
        com.google.android.gms.internal.mlkit_vision_common.zzli.zzc(parcel, 6, 4);
        parcel.writeInt(i6);
        int i7 = this.zzf;
        com.google.android.gms.internal.mlkit_vision_common.zzli.zzc(parcel, 7, 4);
        parcel.writeInt(i7);
        boolean z = this.zzg;
        com.google.android.gms.internal.mlkit_vision_common.zzli.zzc(parcel, 8, 4);
        parcel.writeInt(z ? 1 : 0);
        com.google.android.gms.internal.mlkit_vision_common.zzli.writeString(parcel, 9, this.zzh);
        com.google.android.gms.internal.mlkit_vision_common.zzli.zzb(parcel, iZza);
    }
}
