package androidx.compose.ui.input.key;

import androidx.compose.ui.node.DelegatableNode;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface KeyInputModifierNode extends DelegatableNode {
    /* JADX INFO: renamed from: onKeyEvent-ZmokQxo */
    boolean mo32onKeyEventZmokQxo(android.view.KeyEvent keyEvent);

    /* JADX INFO: renamed from: onPreKeyEvent-ZmokQxo */
    boolean mo34onPreKeyEventZmokQxo(android.view.KeyEvent keyEvent);
}
