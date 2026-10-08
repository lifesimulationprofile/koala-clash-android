package rikka.preference;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class IMultiProcessPreferenceChangeListener$Stub$Proxy implements IMultiProcessPreferenceChangeListener {
    public IBinder mRemote;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.mRemote;
    }

    @Override // rikka.preference.IMultiProcessPreferenceChangeListener
    public final void onPreferenceChanged(String str) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("rikka.preference.IMultiProcessPreferenceChangeListener");
            parcelObtain.writeString(str);
            if (!this.mRemote.transact(1, parcelObtain, parcelObtain2, 0)) {
                int i = MultiProcessPreference.AnonymousClass1.$r8$clinit;
            }
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
