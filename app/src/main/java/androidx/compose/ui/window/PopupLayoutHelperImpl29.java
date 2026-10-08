package androidx.compose.ui.window;

import android.graphics.Rect;
import androidx.camera.core.impl.utils.MatrixExt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public class PopupLayoutHelperImpl29 extends PopupLayoutHelperImpl {
    @Override // androidx.compose.ui.window.PopupLayoutHelperImpl
    public final void setGestureExclusionRects(PopupLayout popupLayout, int i, int i2) {
        popupLayout.setSystemGestureExclusionRects(MatrixExt.mutableListOf(new Rect(0, 0, i, i2)));
    }
}
