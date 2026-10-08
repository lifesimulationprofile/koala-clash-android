package androidx.lifecycle;

import androidx.camera.camera2.internal.Camera2CameraInfoImpl$RedirectableLiveData$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class MediatorLiveData$Source implements Observer {
    public final LiveData mLiveData;
    public final Camera2CameraInfoImpl$RedirectableLiveData$$ExternalSyntheticLambda0 mObserver;
    public int mVersion = -1;

    public MediatorLiveData$Source(LiveData liveData, Camera2CameraInfoImpl$RedirectableLiveData$$ExternalSyntheticLambda0 camera2CameraInfoImpl$RedirectableLiveData$$ExternalSyntheticLambda0) {
        this.mLiveData = liveData;
        this.mObserver = camera2CameraInfoImpl$RedirectableLiveData$$ExternalSyntheticLambda0;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        int i = this.mVersion;
        int i2 = this.mLiveData.mVersion;
        if (i != i2) {
            this.mVersion = i2;
            this.mObserver.onChanged(obj);
        }
    }
}
