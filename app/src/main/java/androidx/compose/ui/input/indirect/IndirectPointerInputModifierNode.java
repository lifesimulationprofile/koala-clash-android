package androidx.compose.ui.input.indirect;

import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.node.DelegatableNode;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface IndirectPointerInputModifierNode extends DelegatableNode {
    void onCancelIndirectPointerInput();

    void onIndirectPointerEvent(StatusLine statusLine, PointerEventPass pointerEventPass);
}
