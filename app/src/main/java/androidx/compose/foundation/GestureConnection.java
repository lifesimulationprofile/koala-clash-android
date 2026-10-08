package androidx.compose.foundation;

import androidx.compose.ui.input.indirect.IndirectPointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputChange;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface GestureConnection {
    boolean isInterested(IndirectPointerInputChange indirectPointerInputChange);

    boolean isInterested(PointerInputChange pointerInputChange);
}
