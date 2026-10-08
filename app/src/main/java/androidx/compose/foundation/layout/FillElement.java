package androidx.compose.foundation.layout;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class FillElement extends ModifierNodeElement {
    public final int direction;
    public final float fraction;

    public FillElement(int i, float f) {
        this.direction = i;
        this.fraction = f;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        FillNode fillNode = new FillNode();
        fillNode.direction = this.direction;
        fillNode.fraction = this.fraction;
        return fillNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FillElement)) {
            return false;
        }
        FillElement fillElement = (FillElement) obj;
        return this.direction == fillElement.direction && this.fraction == fillElement.fraction;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.fraction) + (CaptureSession$State$EnumUnboxingLocalUtility.ordinal(this.direction) * 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        FillNode fillNode = (FillNode) node;
        fillNode.direction = this.direction;
        fillNode.fraction = this.fraction;
    }
}
