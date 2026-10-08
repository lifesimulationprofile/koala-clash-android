package com.github.kr328.clash.service.remote;

import android.os.Binder;
import android.os.Parcel;
import coil.memory.RealStrongMemoryCache;
import com.github.kr328.clash.core.model.FetchStatus;
import kotlin.Unit;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class IFetchObserverDelegate extends Binder implements IFetchObserver {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final /* synthetic */ IFetchObserver $$delegate_0;

    public IFetchObserverDelegate(IFetchObserver iFetchObserver) {
        this.$$delegate_0 = iFetchObserver;
    }

    @Override // android.os.Binder, android.os.IBinder
    public final String getInterfaceDescriptor() {
        return "com.github.kr328.clash.service.remote.IFetchObserver";
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return super.onTransact(i, parcel, parcel2, i2);
        }
        if (parcel2 == null) {
            return false;
        }
        parcel.enforceInterface("com.github.kr328.clash.service.remote.IFetchObserver");
        updateStatus((FetchStatus) FetchStatus.CREATOR.serializer().deserialize(new RealStrongMemoryCache(parcel)));
        Unit unit = Unit.INSTANCE;
        parcel2.writeNoException();
        return true;
    }

    @Override // com.github.kr328.clash.service.remote.IFetchObserver
    public final void updateStatus(FetchStatus fetchStatus) {
        this.$$delegate_0.updateStatus(fetchStatus);
    }
}
