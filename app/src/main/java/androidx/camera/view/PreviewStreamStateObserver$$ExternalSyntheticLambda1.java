package androidx.camera.view;

import androidx.arch.core.util.Function;
import androidx.camera.camera2.internal.ZoomControl;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.work.WorkRequest;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PreviewStreamStateObserver$$ExternalSyntheticLambda1 implements AsyncFunction, Function {
    public final /* synthetic */ ZoomControl f$0;

    public /* synthetic */ PreviewStreamStateObserver$$ExternalSyntheticLambda1(ZoomControl zoomControl) {
        this.f$0 = zoomControl;
    }

    @Override // androidx.camera.core.impl.utils.futures.AsyncFunction, androidx.arch.core.util.Function
    public ListenableFuture apply(Object obj) {
        return ((WorkRequest.Builder) this.f$0.mZoomImpl).waitForNextFrame();
    }

    @Override // androidx.arch.core.util.Function
    public Object apply(Object obj) {
        this.f$0.updatePreviewStreamState(PreviewView.StreamState.STREAMING);
        return null;
    }
}
