package androidx.compose.ui.platform;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface ViewConfiguration {
    long getDoubleTapTimeoutMillis();

    float getHandwritingGestureLineMargin();

    float getHandwritingSlop();

    long getLongPressTimeoutMillis();

    float getMaximumFlingVelocity();

    /* JADX INFO: renamed from: getMinimumTouchTargetSize-MYxV2XQ */
    long mo548getMinimumTouchTargetSizeMYxV2XQ();

    float getTouchSlop();
}
