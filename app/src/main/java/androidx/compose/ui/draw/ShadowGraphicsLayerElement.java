package androidx.compose.ui.draw;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.BlockGraphicsLayerModifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.unit.Dp;
import androidx.work.JobListenableFuture;
import kotlin.ULong;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ShadowGraphicsLayerElement extends ModifierNodeElement {
    public final long ambientColor;
    public final boolean clip;
    public final float elevation;
    public final RoundedCornerShape shape;
    public final long spotColor;

    public ShadowGraphicsLayerElement(float f, RoundedCornerShape roundedCornerShape, boolean z, long j, long j2) {
        this.elevation = f;
        this.shape = roundedCornerShape;
        this.clip = z;
        this.ambientColor = j;
        this.spotColor = j2;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        return new BlockGraphicsLayerModifier(new JobListenableFuture.AnonymousClass1(9, this));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShadowGraphicsLayerElement)) {
            return false;
        }
        ShadowGraphicsLayerElement shadowGraphicsLayerElement = (ShadowGraphicsLayerElement) obj;
        return Dp.m701equalsimpl0(this.elevation, shadowGraphicsLayerElement.elevation) && this.shape.equals(shadowGraphicsLayerElement.shape) && this.clip == shadowGraphicsLayerElement.clip && Color.m433equalsimpl0(this.ambientColor, shadowGraphicsLayerElement.ambientColor) && Color.m433equalsimpl0(this.spotColor, shadowGraphicsLayerElement.spotColor);
    }

    public final int hashCode() {
        int iHashCode = (((this.shape.hashCode() + (Float.floatToIntBits(this.elevation) * 31)) * 31) + (this.clip ? 1231 : 1237)) * 31;
        int i = Color.$r8$clinit;
        return ULong.m836hashCodeimpl(this.spotColor) + ImageAnalysis$$ExternalSyntheticLambda1.m(iHashCode, 31, this.ambientColor);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ShadowGraphicsLayerElement(elevation=");
        sb.append((Object) Dp.m702toStringimpl(this.elevation));
        sb.append(", shape=");
        sb.append(this.shape);
        sb.append(", clip=");
        sb.append(this.clip);
        sb.append(", ambientColor=");
        ImageAnalysis$$ExternalSyntheticLambda1.m(this.ambientColor, sb, ", spotColor=");
        sb.append((Object) Color.m439toStringimpl(this.spotColor));
        sb.append(')');
        return sb.toString();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        BlockGraphicsLayerModifier blockGraphicsLayerModifier = (BlockGraphicsLayerModifier) node;
        JobListenableFuture.AnonymousClass1 anonymousClass1 = new JobListenableFuture.AnonymousClass1(9, this);
        blockGraphicsLayerModifier.layerBlock = anonymousClass1;
        HitTestResultKt.updateLayerBlock(blockGraphicsLayerModifier, anonymousClass1);
    }
}
