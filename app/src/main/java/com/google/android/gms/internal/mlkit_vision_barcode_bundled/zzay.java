package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.zzli;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzay extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzay> CREATOR = new zzal(1);
    public final int zza;
    public final String zzb;
    public final String zzc;
    public final byte[] zzd;
    public final Point[] zze;
    public final int zzf;
    public final zzar zzg;
    public final zzau zzh;
    public final zzav zzi;
    public final zzax zzj;
    public final zzaw zzk;
    public final zzas zzl;
    public final zzao zzm;
    public final zzap zzn;
    public final zzaq zzo;

    public zzay(int i, String str, String str2, byte[] bArr, Point[] pointArr, int i2, zzar zzarVar, zzau zzauVar, zzav zzavVar, zzax zzaxVar, zzaw zzawVar, zzas zzasVar, zzao zzaoVar, zzap zzapVar, zzaq zzaqVar) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = bArr;
        this.zze = pointArr;
        this.zzf = i2;
        this.zzg = zzarVar;
        this.zzh = zzauVar;
        this.zzi = zzavVar;
        this.zzj = zzaxVar;
        this.zzk = zzawVar;
        this.zzl = zzasVar;
        this.zzm = zzaoVar;
        this.zzn = zzapVar;
        this.zzo = zzaqVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = zzli.zza(parcel, 20293);
        zzli.zzc(parcel, 1, 4);
        parcel.writeInt(this.zza);
        zzli.writeString(parcel, 2, this.zzb);
        zzli.writeString(parcel, 3, this.zzc);
        zzli.writeByteArray(parcel, 4, this.zzd);
        zzli.writeTypedArray(parcel, 5, this.zze, i);
        zzli.zzc(parcel, 6, 4);
        parcel.writeInt(this.zzf);
        zzli.writeParcelable(parcel, 7, this.zzg, i);
        zzli.writeParcelable(parcel, 8, this.zzh, i);
        zzli.writeParcelable(parcel, 9, this.zzi, i);
        zzli.writeParcelable(parcel, 10, this.zzj, i);
        zzli.writeParcelable(parcel, 11, this.zzk, i);
        zzli.writeParcelable(parcel, 12, this.zzl, i);
        zzli.writeParcelable(parcel, 13, this.zzm, i);
        zzli.writeParcelable(parcel, 14, this.zzn, i);
        zzli.writeParcelable(parcel, 15, this.zzo, i);
        zzli.zzb(parcel, iZza);
    }
}
