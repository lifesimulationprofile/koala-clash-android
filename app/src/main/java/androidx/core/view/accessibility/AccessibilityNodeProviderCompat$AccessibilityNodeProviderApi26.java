package androidx.core.view.accessibility;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi26 extends AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi19 {
    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final void addExtraDataToAccessibilityNodeInfo(int i, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
        this.mCompat.addExtraDataToAccessibilityNodeInfo(i, new AccessibilityNodeInfoCompat(accessibilityNodeInfo), str, bundle);
    }
}
