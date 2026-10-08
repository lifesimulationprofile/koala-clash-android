package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import androidx.camera.view.PreviewView;
import coil.request.RequestService;
import com.caverock.androidsvg.SVG;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class CameraCharacteristicsCompat {
    public final PreviewView.AnonymousClass1 mCameraCharacteristicsImpl;
    public final String mCameraId;
    public final HashMap mValuesCache = new HashMap();
    public SVG mStreamConfigurationMapCompat = null;

    public CameraCharacteristicsCompat(CameraCharacteristics cameraCharacteristics, String str) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.mCameraCharacteristicsImpl = new CameraCharacteristicsApi28Impl(9, cameraCharacteristics);
        } else {
            this.mCameraCharacteristicsImpl = new PreviewView.AnonymousClass1(9, cameraCharacteristics);
        }
        this.mCameraId = str;
    }

    public final Object get(CameraCharacteristics.Key key) {
        if (key.equals(CameraCharacteristics.SENSOR_ORIENTATION)) {
            return ((CameraCharacteristics) this.mCameraCharacteristicsImpl.this$0).get(key);
        }
        synchronized (this) {
            try {
                Object obj = this.mValuesCache.get(key);
                if (obj != null) {
                    return obj;
                }
                Object obj2 = ((CameraCharacteristics) this.mCameraCharacteristicsImpl.this$0).get(key);
                if (obj2 != null) {
                    this.mValuesCache.put(key, obj2);
                }
                return obj2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final SVG getStreamConfigurationMapCompat() {
        if (this.mStreamConfigurationMapCompat == null) {
            try {
                StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                if (streamConfigurationMap == null) {
                    throw new IllegalArgumentException("StreamConfigurationMap is null!");
                }
                this.mStreamConfigurationMapCompat = new SVG(streamConfigurationMap, new RequestService(this.mCameraId));
            } catch (AssertionError | NullPointerException e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }
        return this.mStreamConfigurationMapCompat;
    }
}
