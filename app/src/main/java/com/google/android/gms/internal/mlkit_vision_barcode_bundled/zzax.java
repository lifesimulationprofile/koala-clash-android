package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.zzli;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzax extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzax> CREATOR = new zzal(18);
    public final String zza;
    public final String zzb;
    public final int zzc;

    public zzax(int i, String str, String str2) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = zzli.zza(parcel, 20293);
        zzli.writeString(parcel, 1, this.zza);
        zzli.writeString(parcel, 2, this.zzb);
        zzli.zzc(parcel, 3, 4);
        parcel.writeInt(this.zzc);
        zzli.zzb(parcel, iZza);
    }
}
