package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import coil.request.RequestService;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.zzli;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class Feature extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Feature> CREATOR = new zzb(1);
    public final String zza;
    public final int zzb;
    public final long zzc;

    public Feature(int i, long j, String str) {
        this.zza = str;
        this.zzb = i;
        this.zzc = j;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            String str = feature.zza;
            String str2 = this.zza;
            if (((str2 != null && str2.equals(str)) || (str2 == null && str == null)) && getVersion() == feature.getVersion()) {
                return true;
            }
        }
        return false;
    }

    public final long getVersion() {
        long j = this.zzc;
        return j == -1 ? this.zzb : j;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, Long.valueOf(getVersion())});
    }

    public final String toString() {
        RequestService requestService = new RequestService(this);
        requestService.add(this.zza, "name");
        requestService.add(Long.valueOf(getVersion()), "version");
        return requestService.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = zzli.zza(parcel, 20293);
        zzli.writeString(parcel, 1, this.zza);
        zzli.zzc(parcel, 2, 4);
        parcel.writeInt(this.zzb);
        long version = getVersion();
        zzli.zzc(parcel, 3, 8);
        parcel.writeLong(version);
        zzli.zzb(parcel, iZza);
    }

    public Feature(String str, long j) {
        this.zza = str;
        this.zzc = j;
        this.zzb = -1;
    }
}
