package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.zzli;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzcc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcc> CREATOR = new zzal(19);
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final long zze;

    public zzcc(int i, int i2, int i3, int i4, long j) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = j;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = zzli.zza(parcel, 20293);
        zzli.zzc(parcel, 1, 4);
        parcel.writeInt(this.zza);
        zzli.zzc(parcel, 2, 4);
        parcel.writeInt(this.zzb);
        zzli.zzc(parcel, 3, 4);
        parcel.writeInt(this.zzc);
        zzli.zzc(parcel, 4, 4);
        parcel.writeInt(this.zzd);
        zzli.zzc(parcel, 5, 8);
        parcel.writeLong(this.zze);
        zzli.zzb(parcel, iZza);
    }
}
