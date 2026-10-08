package com.github.kr328.clash.service.remote;

import android.os.IBinder;
import android.os.Parcel;
import com.github.kr328.clash.core.model.FetchStatus;
import kotlin.Unit;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class IFetchObserverProxy implements IFetchObserver {
    public final IBinder remote;

    public IFetchObserverProxy(IBinder iBinder) {
        this.remote = iBinder;
    }

    @Override // com.github.kr328.clash.service.remote.IFetchObserver
    public final void updateStatus(FetchStatus fetchStatus) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            int i = IFetchObserverDelegate.$r8$clinit;
            parcelObtain.writeInterfaceToken("com.github.kr328.clash.service.remote.IFetchObserver");
            fetchStatus.writeToParcel(parcelObtain, 0);
            this.remote.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            Unit unit = Unit.INSTANCE;
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }
}
