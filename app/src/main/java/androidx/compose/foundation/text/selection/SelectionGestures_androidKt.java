package androidx.compose.foundation.text.selection;

import android.view.MotionEvent;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SelectionGestures_androidKt {
    public static final SelectionAdjustment$Companion$$ExternalSyntheticLambda0 FirstLongPressSelectionAdjustment = SelectionAdjustment$Companion.Word;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.util.Collection, java.util.List] */
    public static final boolean isMouseOrTouchPad(PointerEvent pointerEvent) {
        MotionEvent motionEvent;
        ?? r0 = pointerEvent.changes;
        int size = r0.size();
        for (int i = 0; i < size; i++) {
            if (((PointerInputChange) r0.get(i)).type != 2) {
                MotionEvent motionEvent2 = pointerEvent.getMotionEvent();
                if ((motionEvent2 == null || !motionEvent2.isFromSource(8194)) && ((motionEvent = pointerEvent.getMotionEvent()) == null || !motionEvent.isFromSource(1048584))) {
                    return false;
                }
            }
        }
        return true;
    }
}
