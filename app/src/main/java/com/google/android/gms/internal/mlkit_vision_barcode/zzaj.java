package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.base.zaa;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaj extends zaa {
    public final zzu[] zze(ObjectWrapper objectWrapper, zzan zzanVar) {
        Parcel parcelZza = zza();
        int i = zzc.$r8$clinit;
        parcelZza.writeStrongBinder(objectWrapper);
        parcelZza.writeInt(1);
        zzanVar.writeToParcel(parcelZza, 0);
        Parcel parcelZzb = zzb(parcelZza, 1);
        zzu[] zzuVarArr = (zzu[]) parcelZzb.createTypedArray(zzu.CREATOR);
        parcelZzb.recycle();
        return zzuVarArr;
    }
}
