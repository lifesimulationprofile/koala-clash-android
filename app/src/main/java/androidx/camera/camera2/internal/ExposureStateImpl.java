package androidx.camera.camera2.internal;

import android.view.accessibility.AccessibilityNodeInfo;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ExposureStateImpl {
    public final Object mLock;

    public /* synthetic */ ExposureStateImpl(Object obj) {
        this.mLock = obj;
    }

    public static ExposureStateImpl obtain(int i, int i2, int i3) {
        return new ExposureStateImpl(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, false, i3));
    }

    public ExposureStateImpl() {
        this.mLock = new Object();
    }
}
