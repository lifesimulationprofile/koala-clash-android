package io.github.g00fy2.quickie.content;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.zzb;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class GeoPointParcelable implements Parcelable {
    public static final Parcelable.Creator<GeoPointParcelable> CREATOR = new zzb(15);
    public final double lat;
    public final double lng;

    public GeoPointParcelable(double d, double d2) {
        this.lat = d;
        this.lng = d2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.lat);
        parcel.writeDouble(this.lng);
    }
}
