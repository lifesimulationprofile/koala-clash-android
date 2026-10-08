package androidx.compose.ui.node;

import androidx.compose.ui.platform.ViewConfiguration;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class LayoutNode$Companion$DummyViewConfiguration$1 implements ViewConfiguration {
    @Override // androidx.compose.ui.platform.ViewConfiguration
    public final long getDoubleTapTimeoutMillis() {
        return 300L;
    }

    @Override // androidx.compose.ui.platform.ViewConfiguration
    public final /* synthetic */ float getHandwritingGestureLineMargin() {
        return 16.0f;
    }

    @Override // androidx.compose.ui.platform.ViewConfiguration
    public final /* synthetic */ float getHandwritingSlop() {
        return 2.0f;
    }

    @Override // androidx.compose.ui.platform.ViewConfiguration
    public final long getLongPressTimeoutMillis() {
        return 400L;
    }

    @Override // androidx.compose.ui.platform.ViewConfiguration
    public final /* synthetic */ float getMaximumFlingVelocity() {
        return Float.MAX_VALUE;
    }

    @Override // androidx.compose.ui.platform.ViewConfiguration
    /* JADX INFO: renamed from: getMinimumTouchTargetSize-MYxV2XQ, reason: not valid java name */
    public final long mo548getMinimumTouchTargetSizeMYxV2XQ() {
        return 0L;
    }

    @Override // androidx.compose.ui.platform.ViewConfiguration
    public final float getTouchSlop() {
        return 16.0f;
    }
}
