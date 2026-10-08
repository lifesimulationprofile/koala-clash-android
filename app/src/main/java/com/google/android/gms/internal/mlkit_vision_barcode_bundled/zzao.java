package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.zzli;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzao extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzao> CREATOR = new zzal(6);
    public final String zza;
    public final String zzb;
    public final String zzc;
    public final String zzd;
    public final String zze;
    public final zzan zzf;
    public final zzan zzg;

    public zzao(String str, String str2, String str3, String str4, String str5, zzan zzanVar, zzan zzanVar2) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = str5;
        this.zzf = zzanVar;
        this.zzg = zzanVar2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = zzli.zza(parcel, 20293);
        zzli.writeString(parcel, 1, this.zza);
        zzli.writeString(parcel, 2, this.zzb);
        zzli.writeString(parcel, 3, this.zzc);
        zzli.writeString(parcel, 4, this.zzd);
        zzli.writeString(parcel, 5, this.zze);
        zzli.writeParcelable(parcel, 6, this.zzf, i);
        zzli.writeParcelable(parcel, 7, this.zzg, i);
        zzli.zzb(parcel, iZza);
    }
}
