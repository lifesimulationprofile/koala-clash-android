package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentState;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.zzli;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class RootTelemetryConfiguration extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RootTelemetryConfiguration> CREATOR = new FragmentState.AnonymousClass1(23);
    public final int zza;
    public final boolean zzb;
    public final boolean zzc;
    public final int zzd;
    public final int zze;

    public RootTelemetryConfiguration(int i, int i2, int i3, boolean z, boolean z2) {
        this.zza = i;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = i2;
        this.zze = i3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = zzli.zza(parcel, 20293);
        zzli.zzc(parcel, 1, 4);
        parcel.writeInt(this.zza);
        zzli.zzc(parcel, 2, 4);
        parcel.writeInt(this.zzb ? 1 : 0);
        zzli.zzc(parcel, 3, 4);
        parcel.writeInt(this.zzc ? 1 : 0);
        zzli.zzc(parcel, 4, 4);
        parcel.writeInt(this.zzd);
        zzli.zzc(parcel, 5, 4);
        parcel.writeInt(this.zze);
        zzli.zzb(parcel, iZza);
    }
}
