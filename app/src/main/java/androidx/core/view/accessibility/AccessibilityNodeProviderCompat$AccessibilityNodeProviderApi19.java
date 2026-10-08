package androidx.core.view.accessibility;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import coil.disk.RealDiskCache;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public class AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi19 extends AccessibilityNodeProvider {
    public final RealDiskCache.RealEditor mCompat;

    public AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi19(RealDiskCache.RealEditor realEditor) {
        this.mCompat = realEditor;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompatCreateAccessibilityNodeInfo = this.mCompat.createAccessibilityNodeInfo(i);
        if (accessibilityNodeInfoCompatCreateAccessibilityNodeInfo == null) {
            return null;
        }
        return accessibilityNodeInfoCompatCreateAccessibilityNodeInfo.mInfo;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final List findAccessibilityNodeInfosByText(String str, int i) {
        this.mCompat.getClass();
        return null;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo findFocus(int i) {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompatFindFocus = this.mCompat.findFocus(i);
        if (accessibilityNodeInfoCompatFindFocus == null) {
            return null;
        }
        return accessibilityNodeInfoCompatFindFocus.mInfo;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final boolean performAction(int i, int i2, Bundle bundle) {
        return this.mCompat.performAction(i, i2, bundle);
    }
}
