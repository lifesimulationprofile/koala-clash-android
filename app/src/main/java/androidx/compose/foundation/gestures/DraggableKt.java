package androidx.compose.foundation.gestures;

import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class DraggableKt {
    public static final /* synthetic */ int $r8$clinit = 0;

    static {
        new DraggableKt$NoOpOnDragStarted$1(3, null, 0);
        new DraggableKt$NoOpOnDragStarted$1(3, null, 1);
    }

    /* JADX INFO: renamed from: toValidVelocity-TH1AsA0, reason: not valid java name */
    public static final long m77toValidVelocityTH1AsA0(long j) {
        return VelocityKt.Velocity(Float.isNaN(Velocity.m731getXimpl(j)) ? 0.0f : Velocity.m731getXimpl(j), Float.isNaN(Velocity.m732getYimpl(j)) ? 0.0f : Velocity.m732getYimpl(j));
    }
}
