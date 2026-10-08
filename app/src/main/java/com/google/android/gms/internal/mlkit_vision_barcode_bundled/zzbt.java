package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.zzli;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbt> CREATOR = new zzal(12);
    public final float[] zza;
    public final int zzb;
    public final boolean zzc;

    public zzbt(float[] fArr, int i, boolean z) {
        this.zza = fArr;
        this.zzb = i;
        this.zzc = z;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = zzli.zza(parcel, 20293);
        float[] fArr = this.zza;
        if (fArr != null) {
            int iZza2 = zzli.zza(parcel, 1);
            parcel.writeFloatArray(fArr);
            zzli.zzb(parcel, iZza2);
        }
        zzli.zzc(parcel, 2, 4);
        parcel.writeInt(this.zzb);
        zzli.zzc(parcel, 3, 4);
        parcel.writeInt(this.zzc ? 1 : 0);
        zzli.zzb(parcel, iZza);
    }
}
