package com.google.android.gms.dynamite;

import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.base.zaa;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzq extends zaa {
    public final IObjectWrapper zzh(ObjectWrapper objectWrapper, String str, int i) {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.common.zzc.zze(parcelZza, objectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeInt(i);
        Parcel parcelZzB = zzB(parcelZza, 2);
        IObjectWrapper iObjectWrapperAsInterface = ObjectWrapper.asInterface(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return iObjectWrapperAsInterface;
    }

    public final IObjectWrapper zzi(ObjectWrapper objectWrapper, String str, int i, ObjectWrapper objectWrapper2) {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.common.zzc.zze(parcelZza, objectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeInt(i);
        com.google.android.gms.internal.common.zzc.zze(parcelZza, objectWrapper2);
        Parcel parcelZzB = zzB(parcelZza, 8);
        IObjectWrapper iObjectWrapperAsInterface = ObjectWrapper.asInterface(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return iObjectWrapperAsInterface;
    }

    public final IObjectWrapper zzj(ObjectWrapper objectWrapper, String str, int i) {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.common.zzc.zze(parcelZza, objectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeInt(i);
        Parcel parcelZzB = zzB(parcelZza, 4);
        IObjectWrapper iObjectWrapperAsInterface = ObjectWrapper.asInterface(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return iObjectWrapperAsInterface;
    }

    public final IObjectWrapper zzk(ObjectWrapper objectWrapper, String str, boolean z, long j) {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.common.zzc.zze(parcelZza, objectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeInt(z ? 1 : 0);
        parcelZza.writeLong(j);
        Parcel parcelZzB = zzB(parcelZza, 7);
        IObjectWrapper iObjectWrapperAsInterface = ObjectWrapper.asInterface(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return iObjectWrapperAsInterface;
    }
}
