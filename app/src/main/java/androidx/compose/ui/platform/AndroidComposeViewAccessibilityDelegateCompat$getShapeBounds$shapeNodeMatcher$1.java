package androidx.compose.ui.platform;

import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidComposeViewAccessibilityDelegateCompat$getShapeBounds$shapeNodeMatcher$1 implements SemanticsPropertyReceiver {
    public final /* synthetic */ Shape $shape;
    public boolean hasMatchedShape;

    public AndroidComposeViewAccessibilityDelegateCompat$getShapeBounds$shapeNodeMatcher$1(Shape shape) {
        this.$shape = shape;
    }

    @Override // androidx.compose.ui.semantics.SemanticsPropertyReceiver
    public final void set(SemanticsPropertyKey semanticsPropertyKey, Object obj) {
        if (obj == this.$shape) {
            this.hasMatchedShape = true;
        }
    }
}
