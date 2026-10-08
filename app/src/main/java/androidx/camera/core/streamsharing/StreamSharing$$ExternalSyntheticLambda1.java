package androidx.camera.core.streamsharing;

import androidx.camera.core.UseCase;
import androidx.camera.core.impl.AutoValue_StreamSpec;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import java.util.Iterator;
import kotlin.collections.MapsKt__MapsKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class StreamSharing$$ExternalSyntheticLambda1 implements SessionConfig.ErrorListener {
    public final /* synthetic */ StreamSharing f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ UseCaseConfig f$3;
    public final /* synthetic */ AutoValue_StreamSpec f$4;
    public final /* synthetic */ AutoValue_StreamSpec f$5;

    public /* synthetic */ StreamSharing$$ExternalSyntheticLambda1(StreamSharing streamSharing, String str, String str2, UseCaseConfig useCaseConfig, AutoValue_StreamSpec autoValue_StreamSpec, AutoValue_StreamSpec autoValue_StreamSpec2) {
        this.f$0 = streamSharing;
        this.f$1 = str;
        this.f$2 = str2;
        this.f$3 = useCaseConfig;
        this.f$4 = autoValue_StreamSpec;
        this.f$5 = autoValue_StreamSpec2;
    }

    @Override // androidx.camera.core.impl.SessionConfig.ErrorListener
    public final void onError(SessionConfig sessionConfig) {
        StreamSharing streamSharing = this.f$0;
        if (streamSharing.getCamera() == null) {
            return;
        }
        streamSharing.clearPipeline$3();
        streamSharing.updateSessionConfig(streamSharing.createPipelineAndUpdateChildrenSpecs(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5));
        streamSharing.notifyReset();
        VirtualCameraAdapter virtualCameraAdapter = streamSharing.mVirtualCameraAdapter;
        virtualCameraAdapter.getClass();
        MapsKt__MapsKt.checkMainThread();
        Iterator it = virtualCameraAdapter.mChildren.iterator();
        while (it.hasNext()) {
            virtualCameraAdapter.onUseCaseReset((UseCase) it.next());
        }
    }
}
