package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.zzli;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbc> CREATOR = new zzal(3);
    public final zzbt zza;
    public final zzbv zzb;
    public final boolean zzd;

    public zzbc(zzbt zzbtVar, zzbv zzbvVar, boolean z) {
        this.zza = zzbtVar;
        this.zzb = zzbvVar;
        this.zzd = z;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = zzli.zza(parcel, 20293);
        zzli.writeParcelable(parcel, 1, this.zza, i);
        zzli.writeParcelable(parcel, 2, this.zzb, i);
        zzli.zzc(parcel, 3, 4);
        parcel.writeInt(1);
        zzli.zzc(parcel, 4, 4);
        parcel.writeInt(this.zzd ? 1 : 0);
        zzli.zzb(parcel, iZza);
    }
}
