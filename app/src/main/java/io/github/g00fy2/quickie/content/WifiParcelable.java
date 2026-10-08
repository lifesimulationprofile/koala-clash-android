package io.github.g00fy2.quickie.content;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.zzb;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class WifiParcelable implements Parcelable {
    public static final Parcelable.Creator<WifiParcelable> CREATOR = new zzb(20);
    public final int encryptionType;
    public final String password;
    public final String ssid;

    public WifiParcelable(int i, String str, String str2) {
        this.encryptionType = i;
        this.password = str;
        this.ssid = str2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.encryptionType);
        parcel.writeString(this.password);
        parcel.writeString(this.ssid);
    }
}
