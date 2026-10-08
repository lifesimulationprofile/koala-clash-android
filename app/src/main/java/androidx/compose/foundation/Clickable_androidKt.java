package androidx.compose.foundation;

import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.ui.node.HitTestResultKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Clickable_androidKt {
    public static final long TapIndicationDelay = ViewConfiguration.getTapTimeout();

    public static final boolean isComposeRootInScrollableContainer(AbstractClickableNode abstractClickableNode) {
        ViewParent parent = HitTestResultKt.requireView(abstractClickableNode).getParent();
        while (parent != null && (parent instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
            parent = viewGroup.getParent();
        }
        return false;
    }
}
