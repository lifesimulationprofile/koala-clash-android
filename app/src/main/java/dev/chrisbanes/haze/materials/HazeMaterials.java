package dev.chrisbanes.haze.materials;

import androidx.camera.camera2.internal.CaptureCallbackContainer;
import androidx.camera.camera2.internal.CaptureSession;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureCallbacks$ComboCameraCaptureCallback;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import dev.chrisbanes.haze.HazeStyle;
import dev.chrisbanes.haze.HazeTint;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class HazeMaterials {
    /* JADX INFO: renamed from: hazeMaterial-ek8zF_U, reason: not valid java name */
    public static HazeStyle m833hazeMaterialek8zF_U(float f, float f2, long j) {
        float f3 = 24;
        if (BrushKt.m419luminance8_81llA(j) < 0.5d) {
            f = f2;
        }
        return new HazeStyle(j, new HazeTint(BrushKt.Color(Color.m438getRedimpl(j), Color.m437getGreenimpl(j), Color.m435getBlueimpl(j), f, Color.m436getColorSpaceimpl(j))), f3, 24);
    }

    /* JADX INFO: renamed from: thin-Iv8Zu3U, reason: not valid java name */
    public static HazeStyle m834thinIv8Zu3U(GapComposer gapComposer) {
        return m833hazeMaterialek8zF_U(0.6f, 0.65f, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surface);
    }

    public static void toCaptureCallback(CameraCaptureCallback cameraCaptureCallback, ArrayList arrayList) {
        if (cameraCaptureCallback instanceof CameraCaptureCallbacks$ComboCameraCaptureCallback) {
            throw null;
        }
        if (cameraCaptureCallback instanceof CaptureCallbackContainer) {
            arrayList.add(((CaptureCallbackContainer) cameraCaptureCallback).mCaptureCallback);
        } else {
            arrayList.add(new CaptureSession.AnonymousClass2(cameraCaptureCallback));
        }
    }
}
