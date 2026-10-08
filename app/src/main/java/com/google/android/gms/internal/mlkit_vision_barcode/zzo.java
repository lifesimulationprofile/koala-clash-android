package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzo> CREATOR = new zzh(2);
    public double zza;
    public double zzb;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = com.google.android.gms.internal.mlkit_vision_common.zzli.zza(parcel, 20293);
        double d = this.zza;
        com.google.android.gms.internal.mlkit_vision_common.zzli.zzc(parcel, 2, 8);
        parcel.writeDouble(d);
        double d2 = this.zzb;
        com.google.android.gms.internal.mlkit_vision_common.zzli.zzc(parcel, 3, 8);
        parcel.writeDouble(d2);
        com.google.android.gms.internal.mlkit_vision_common.zzli.zzb(parcel, iZza);
    }
}
