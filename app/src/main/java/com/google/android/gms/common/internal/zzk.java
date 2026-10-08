package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentState;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.zzli;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzk> CREATOR = new FragmentState.AnonymousClass1(24);
    public Bundle zza;
    public Feature[] zzb;
    public int zzc;
    public ConnectionTelemetryConfiguration zzd;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = zzli.zza(parcel, 20293);
        Bundle bundle = this.zza;
        if (bundle != null) {
            int iZza2 = zzli.zza(parcel, 1);
            parcel.writeBundle(bundle);
            zzli.zzb(parcel, iZza2);
        }
        zzli.writeTypedArray(parcel, 2, this.zzb, i);
        int i2 = this.zzc;
        zzli.zzc(parcel, 3, 4);
        parcel.writeInt(i2);
        zzli.writeParcelable(parcel, 4, this.zzd, i);
        zzli.zzb(parcel, iZza);
    }
}
