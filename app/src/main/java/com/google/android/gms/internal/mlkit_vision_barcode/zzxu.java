package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzxu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzxu> CREATOR = new zzh(20);
    public final int zza;
    public final String zzb;
    public final String zzc;
    public final String zzd;

    public zzxu(int i, String str, String str2, String str3) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = com.google.android.gms.internal.mlkit_vision_common.zzli.zza(parcel, 20293);
        com.google.android.gms.internal.mlkit_vision_common.zzli.zzc(parcel, 1, 4);
        parcel.writeInt(this.zza);
        com.google.android.gms.internal.mlkit_vision_common.zzli.writeString(parcel, 2, this.zzb);
        com.google.android.gms.internal.mlkit_vision_common.zzli.writeString(parcel, 3, this.zzc);
        com.google.android.gms.internal.mlkit_vision_common.zzli.writeString(parcel, 4, this.zzd);
        com.google.android.gms.internal.mlkit_vision_common.zzli.zzb(parcel, iZza);
    }
}
