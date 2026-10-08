package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.zzli;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaq> CREATOR = new zzal(8);
    public final String zza;
    public final String zzb;
    public final String zzc;
    public final String zzd;
    public final String zze;
    public final String zzf;
    public final String zzg;
    public final String zzh;
    public final String zzi;
    public final String zzj;
    public final String zzk;
    public final String zzl;
    public final String zzm;
    public final String zzn;

    public zzaq(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = str5;
        this.zzf = str6;
        this.zzg = str7;
        this.zzh = str8;
        this.zzi = str9;
        this.zzj = str10;
        this.zzk = str11;
        this.zzl = str12;
        this.zzm = str13;
        this.zzn = str14;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = zzli.zza(parcel, 20293);
        zzli.writeString(parcel, 1, this.zza);
        zzli.writeString(parcel, 2, this.zzb);
        zzli.writeString(parcel, 3, this.zzc);
        zzli.writeString(parcel, 4, this.zzd);
        zzli.writeString(parcel, 5, this.zze);
        zzli.writeString(parcel, 6, this.zzf);
        zzli.writeString(parcel, 7, this.zzg);
        zzli.writeString(parcel, 8, this.zzh);
        zzli.writeString(parcel, 9, this.zzi);
        zzli.writeString(parcel, 10, this.zzj);
        zzli.writeString(parcel, 11, this.zzk);
        zzli.writeString(parcel, 12, this.zzl);
        zzli.writeString(parcel, 13, this.zzm);
        zzli.writeString(parcel, 14, this.zzn);
        zzli.zzb(parcel, iZza);
    }
}
