package androidx.camera.camera2.internal;

import android.hardware.camera2.params.MeteringRectangle;
import androidx.camera.core.impl.utils.executor.SequentialExecutor;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class FocusMeteringControl {
    public static final MeteringRectangle[] EMPTY_RECTANGLES = new MeteringRectangle[0];
    public MeteringRectangle[] mAeRects;
    public MeteringRectangle[] mAfRects;
    public MeteringRectangle[] mAwbRects;
    public final Camera2CameraControlImpl mCameraControl;
    public final boolean mIsExternalFlashAeModeEnabled;
    public volatile boolean mIsActive = false;
    public int mTemplate = 1;

    public FocusMeteringControl(Camera2CameraControlImpl camera2CameraControlImpl, SequentialExecutor sequentialExecutor) {
        MeteringRectangle[] meteringRectangleArr = EMPTY_RECTANGLES;
        this.mAfRects = meteringRectangleArr;
        this.mAeRects = meteringRectangleArr;
        this.mAwbRects = meteringRectangleArr;
        this.mIsExternalFlashAeModeEnabled = false;
        this.mCameraControl = camera2CameraControlImpl;
    }
}
