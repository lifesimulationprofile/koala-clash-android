package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Offset;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class PointerId {
    public static final StackTraceElement[] EmptyStackTraceElements;
    public static final AndroidPointerIconType pointerIconDefault = new AndroidPointerIconType(1000);
    public static final AndroidPointerIconType pointerIconText;

    static {
        new AndroidPointerIconType(1007);
        pointerIconText = new AndroidPointerIconType(1008);
        new AndroidPointerIconType(1002);
        EmptyStackTraceElements = new StackTraceElement[0];
    }

    public static final boolean changedToDown(PointerInputChange pointerInputChange) {
        return (pointerInputChange.isConsumed() || pointerInputChange.previousPressed || !pointerInputChange.pressed) ? false : true;
    }

    public static final boolean changedToDownIgnoreConsumed(PointerInputChange pointerInputChange) {
        return !pointerInputChange.previousPressed && pointerInputChange.pressed;
    }

    public static final boolean changedToUp(PointerInputChange pointerInputChange) {
        return (pointerInputChange.isConsumed() || !pointerInputChange.previousPressed || pointerInputChange.pressed) ? false : true;
    }

    public static final boolean changedToUpIgnoreConsumed(PointerInputChange pointerInputChange) {
        return pointerInputChange.previousPressed && !pointerInputChange.pressed;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m508equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: isOutOfBounds-jwHxaWs, reason: not valid java name */
    public static final boolean m509isOutOfBoundsjwHxaWs(PointerInputChange pointerInputChange, long j, long j2) {
        int i = pointerInputChange.type == 1 ? 1 : 0;
        long j3 = pointerInputChange.position;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j3 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j3 & 4294967295L));
        float f = i;
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (j2 >> 32)) * f;
        float f2 = ((int) (j >> 32)) + fIntBitsToFloat3;
        float fIntBitsToFloat4 = Float.intBitsToFloat((int) (j2 & 4294967295L)) * f;
        return (fIntBitsToFloat > f2) | (fIntBitsToFloat < (-fIntBitsToFloat3)) | (fIntBitsToFloat2 < (-fIntBitsToFloat4)) | (fIntBitsToFloat2 > ((int) (j & 4294967295L)) + fIntBitsToFloat4);
    }

    public static final long positionChangeInternal(PointerInputChange pointerInputChange, boolean z) {
        long jM370minusMKHz9U = Offset.m370minusMKHz9U(pointerInputChange.position, pointerInputChange.previousPosition);
        if (z || !pointerInputChange.isConsumed()) {
            return jM370minusMKHz9U;
        }
        return 0L;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m510toStringimpl(long j) {
        return "PointerId(value=" + j + ')';
    }
}
