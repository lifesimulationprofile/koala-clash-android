package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.zzb;
import com.google.android.gms.internal.mlkit_vision_common.zzli;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zag extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zag> CREATOR = new zzb(3);
    public final List zaa;
    public final String zab;

    public zag(ArrayList arrayList, String str) {
        this.zaa = arrayList;
        this.zab = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = zzli.zza(parcel, 20293);
        List<String> list = this.zaa;
        if (list != null) {
            int iZza2 = zzli.zza(parcel, 1);
            parcel.writeStringList(list);
            zzli.zzb(parcel, iZza2);
        }
        zzli.writeString(parcel, 2, this.zab);
        zzli.zzb(parcel, iZza);
    }
}
