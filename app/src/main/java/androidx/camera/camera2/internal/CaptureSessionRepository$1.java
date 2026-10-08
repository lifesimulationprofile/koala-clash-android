package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import androidx.camera.core.Preview$$ExternalSyntheticLambda0;
import androidx.camera.core.impl.utils.executor.SequentialExecutor;
import androidx.core.content.res.ResourcesCompat$FontCallback$$ExternalSyntheticLambda1;
import com.caverock.androidsvg.SVGAndroidRenderer;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class CaptureSessionRepository$1 extends CameraDevice.StateCallback {
    public final /* synthetic */ int $r8$classId;
    public final Object this$0;

    public CaptureSessionRepository$1(SVGAndroidRenderer sVGAndroidRenderer) {
        this.$r8$classId = 0;
        this.this$0 = sVGAndroidRenderer;
    }

    public void cameraClosed() {
        ArrayList sessionsInOrder;
        synchronized (((SVGAndroidRenderer) this.this$0).document) {
            sessionsInOrder = ((SVGAndroidRenderer) this.this$0).getSessionsInOrder();
            ((LinkedHashSet) ((SVGAndroidRenderer) this.this$0).parentStack).clear();
            ((LinkedHashSet) ((SVGAndroidRenderer) this.this$0).state).clear();
            ((LinkedHashSet) ((SVGAndroidRenderer) this.this$0).stateStack).clear();
        }
        int size = sessionsInOrder.size();
        int i = 0;
        while (i < size) {
            Object obj = sessionsInOrder.get(i);
            i++;
            SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl = (SynchronizedCaptureSessionImpl) obj;
            synchronizedCaptureSessionImpl.releaseDeferrableSurfaces();
            synchronizedCaptureSessionImpl.mRequestMonitor.stop();
        }
    }

    public void forceOnClosedCaptureSessions() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        synchronized (((SVGAndroidRenderer) this.this$0).document) {
            linkedHashSet.addAll((LinkedHashSet) ((SVGAndroidRenderer) this.this$0).parentStack);
            linkedHashSet.addAll((LinkedHashSet) ((SVGAndroidRenderer) this.this$0).state);
        }
        ((SequentialExecutor) ((SVGAndroidRenderer) this.this$0).canvas).execute(new Preview$$ExternalSyntheticLambda0(7, linkedHashSet));
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onClosed(CameraDevice cameraDevice) {
        switch (this.$r8$classId) {
            case 0:
                forceOnClosedCaptureSessions();
                cameraClosed();
                break;
            default:
                ArrayList arrayList = (ArrayList) this.this$0;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    ((CameraDevice.StateCallback) obj).onClosed(cameraDevice);
                }
                break;
        }
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onDisconnected(CameraDevice cameraDevice) {
        switch (this.$r8$classId) {
            case 0:
                forceOnClosedCaptureSessions();
                cameraClosed();
                break;
            default:
                ArrayList arrayList = (ArrayList) this.this$0;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    ((CameraDevice.StateCallback) obj).onDisconnected(cameraDevice);
                }
                break;
        }
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onError(CameraDevice cameraDevice, int i) {
        switch (this.$r8$classId) {
            case 0:
                forceOnClosedCaptureSessions();
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                synchronized (((SVGAndroidRenderer) this.this$0).document) {
                    linkedHashSet.addAll((LinkedHashSet) ((SVGAndroidRenderer) this.this$0).parentStack);
                    linkedHashSet.addAll((LinkedHashSet) ((SVGAndroidRenderer) this.this$0).state);
                    break;
                }
                ((SequentialExecutor) ((SVGAndroidRenderer) this.this$0).canvas).execute(new ResourcesCompat$FontCallback$$ExternalSyntheticLambda1(i, 2, linkedHashSet));
                cameraClosed();
                return;
            default:
                ArrayList arrayList = (ArrayList) this.this$0;
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    ((CameraDevice.StateCallback) obj).onError(cameraDevice, i);
                }
                return;
        }
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onOpened(CameraDevice cameraDevice) {
        switch (this.$r8$classId) {
            case 0:
                break;
            default:
                ArrayList arrayList = (ArrayList) this.this$0;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    ((CameraDevice.StateCallback) obj).onOpened(cameraDevice);
                }
                break;
        }
    }

    public CaptureSessionRepository$1(ArrayList arrayList) {
        this.$r8$classId = 1;
        this.this$0 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            CameraDevice.StateCallback stateCallback = (CameraDevice.StateCallback) obj;
            if (!(stateCallback instanceof CameraDeviceStateCallbacks$NoOpDeviceStateCallback)) {
                ((ArrayList) this.this$0).add(stateCallback);
            }
        }
    }

    private final void onOpened$androidx$camera$camera2$internal$CaptureSessionRepository$1(CameraDevice cameraDevice) {
    }
}
