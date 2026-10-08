package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.base.zaa;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzak extends zaa implements zzam {
    public final zzaj zzd(ObjectWrapper objectWrapper, zzah zzahVar) {
        zzaj zzajVar;
        Parcel parcelZza = zza();
        int i = zzc.$r8$clinit;
        parcelZza.writeStrongBinder(objectWrapper);
        parcelZza.writeInt(1);
        zzahVar.writeToParcel(parcelZza, 0);
        Parcel parcelZzb = zzb(parcelZza, 1);
        IBinder strongBinder = parcelZzb.readStrongBinder();
        if (strongBinder == null) {
            zzajVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
            zzajVar = iInterfaceQueryLocalInterface instanceof zzaj ? (zzaj) iInterfaceQueryLocalInterface : new zzaj(strongBinder, "com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector", 2);
        }
        parcelZzb.recycle();
        return zzajVar;
    }
}
