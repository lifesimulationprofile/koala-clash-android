package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.zzli;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbr> CREATOR = new zzal(11);
    public final boolean zza;
    public final byte[] zzb;
    public final boolean zzc;
    public final float zzd;
    public final boolean zze;

    public zzbr(boolean z, byte[] bArr, boolean z2, float f, boolean z3) {
        this.zza = z;
        this.zzb = bArr;
        this.zzc = z2;
        this.zzd = f;
        this.zze = z3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = zzli.zza(parcel, 20293);
        zzli.zzc(parcel, 1, 4);
        parcel.writeInt(this.zza ? 1 : 0);
        zzli.writeByteArray(parcel, 2, this.zzb);
        zzli.zzc(parcel, 3, 4);
        parcel.writeInt(this.zzc ? 1 : 0);
        zzli.zzc(parcel, 4, 4);
        parcel.writeFloat(this.zzd);
        zzli.zzc(parcel, 5, 4);
        parcel.writeInt(this.zze ? 1 : 0);
        zzli.zzb(parcel, iZza);
    }
}
