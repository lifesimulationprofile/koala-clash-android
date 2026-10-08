package androidx.compose.foundation;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.RadialGradient;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class BackgroundElement extends ModifierNodeElement {
    public final float alpha;
    public final Brush brush;
    public final long color;
    public final Shape shape;

    public BackgroundElement(long j, RadialGradient radialGradient, Shape shape, int i) {
        j = (i & 1) != 0 ? Color.Unspecified : j;
        radialGradient = (i & 2) != 0 ? null : radialGradient;
        this.color = j;
        this.brush = radialGradient;
        this.alpha = 1.0f;
        this.shape = shape;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        BackgroundNode backgroundNode = new BackgroundNode();
        backgroundNode.color = this.color;
        backgroundNode.brush = this.brush;
        backgroundNode.alpha = this.alpha;
        backgroundNode.shape = this.shape;
        backgroundNode.lastSize = 9205357640488583168L;
        return backgroundNode;
    }

    public final boolean equals(Object obj) {
        BackgroundElement backgroundElement = obj instanceof BackgroundElement ? (BackgroundElement) obj : null;
        return backgroundElement != null && Color.m433equalsimpl0(this.color, backgroundElement.color) && Intrinsics.areEqual(this.brush, backgroundElement.brush) && this.alpha == backgroundElement.alpha && Intrinsics.areEqual(this.shape, backgroundElement.shape);
    }

    public final int hashCode() {
        int i = Color.$r8$clinit;
        int iM836hashCodeimpl = ULong.m836hashCodeimpl(this.color) * 31;
        Brush brush = this.brush;
        return this.shape.hashCode() + ImageAnalysis$$ExternalSyntheticLambda1.m(this.alpha, (iM836hashCodeimpl + (brush != null ? brush.hashCode() : 0)) * 31, 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        BackgroundNode backgroundNode = (BackgroundNode) node;
        backgroundNode.color = this.color;
        backgroundNode.brush = this.brush;
        backgroundNode.alpha = this.alpha;
        Shape shape = backgroundNode.shape;
        Shape shape2 = this.shape;
        if (!Intrinsics.areEqual(shape, shape2)) {
            backgroundNode.shape = shape2;
            HitTestResultKt.invalidateSemantics(backgroundNode);
        }
        HitTestResultKt.invalidateDraw(backgroundNode);
    }
}
