package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.zzli;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzar extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzar> CREATOR = new zzal(9);
    public final int zza;
    public final String zzb;
    public final String zzc;
    public final String zzd;

    public zzar(int i, String str, String str2, String str3) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = zzli.zza(parcel, 20293);
        zzli.zzc(parcel, 1, 4);
        parcel.writeInt(this.zza);
        zzli.writeString(parcel, 2, this.zzb);
        zzli.writeString(parcel, 3, this.zzc);
        zzli.writeString(parcel, 4, this.zzd);
        zzli.zzb(parcel, iZza);
    }
}
