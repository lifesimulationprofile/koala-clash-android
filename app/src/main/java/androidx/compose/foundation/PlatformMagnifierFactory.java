package androidx.compose.foundation;

import android.view.View;
import androidx.compose.ui.unit.Density;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface PlatformMagnifierFactory {
    /* JADX INFO: renamed from: create-nHHXs2Y, reason: not valid java name */
    PlatformMagnifier mo55createnHHXs2Y(View view, Density density);

    boolean getCanUpdateZoom();
}
