package androidx.camera.camera2.internal;

import androidx.lifecycle.Observer;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Camera2CameraInfoImpl$RedirectableLiveData$$ExternalSyntheticLambda0 implements Observer {
    public final /* synthetic */ Camera2CameraInfoImpl.RedirectableLiveData f$0;

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        this.f$0.setValue(obj);
    }
}
