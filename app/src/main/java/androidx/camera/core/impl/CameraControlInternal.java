package androidx.camera.core.impl;

import android.graphics.Rect;
import androidx.camera.core.ImageCapture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.mlkit.common.internal.zzd;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface CameraControlInternal {
    public static final zzd DEFAULT_EMPTY_INSTANCE = new zzd();

    void addInteropConfig(Config config);

    void addZslConfig(SessionConfig.Builder builder);

    void clearInteropConfig();

    ListenableFuture enableTorch(boolean z);

    Config getInteropConfig();

    Rect getSensorRect();

    void setFlashMode(int i);

    void setScreenFlash(ImageCapture.ScreenFlash screenFlash);
}
