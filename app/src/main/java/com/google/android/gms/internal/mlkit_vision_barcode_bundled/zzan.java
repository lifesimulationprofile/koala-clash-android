package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.zzli;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzan extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzan> CREATOR = new zzal(5);
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final boolean zzg;
    public final String zzh;

    public zzan(int i, int i2, int i3, int i4, int i5, int i6, boolean z, String str) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = i5;
        this.zzf = i6;
        this.zzg = z;
        this.zzh = str;
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
        zzli.zzc(parcel, 5, 4);
        parcel.writeInt(this.zze);
        zzli.zzc(parcel, 6, 4);
        parcel.writeInt(this.zzf);
        zzli.zzc(parcel, 7, 4);
        parcel.writeInt(this.zzg ? 1 : 0);
        zzli.writeString(parcel, 8, this.zzh);
        zzli.zzb(parcel, iZza);
    }
}
