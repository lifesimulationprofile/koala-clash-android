package androidx.compose.ui.node;

import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface PointerInputModifierNode extends DelegatableNode {
    /* JADX INFO: renamed from: getTouchBoundsExpansion-RZrCHBk */
    long mo28getTouchBoundsExpansionRZrCHBk();

    boolean interceptOutOfBoundsChildEvents();

    void onCancelPointerInput();

    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    void mo33onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j);

    void onViewConfigurationChange();

    boolean sharePointerInputWithSiblings();
}
