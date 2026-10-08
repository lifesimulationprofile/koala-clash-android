package dev.chrisbanes.haze;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidRenderEffect;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.platform.CompositionLocalsKt;
import kotlin.text.StringsKt__StringsKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class RenderEffectBlurEffect implements BlurEffect {
    public final HazeEffectNode node;
    public AndroidRenderEffect renderEffect;

    public RenderEffectBlurEffect(HazeEffectNode hazeEffectNode) {
        this.node = hazeEffectNode;
    }

    @Override // dev.chrisbanes.haze.BlurEffect
    public final void drawEffect(LayoutNodeDrawScope layoutNodeDrawScope) {
        StringsKt__StringsKt$$ExternalSyntheticLambda0 stringsKt__StringsKt$$ExternalSyntheticLambda0 = new StringsKt__StringsKt$$ExternalSyntheticLambda0(2, this);
        HazeEffectNode hazeEffectNode = this.node;
        float fM827calculateInputScaleFactor3ABfNKs$default = HazeEffectNodeKt.m827calculateInputScaleFactor3ABfNKs$default(hazeEffectNode);
        boolean z = hazeEffectNode.blurredEdgeTreatment != null;
        GraphicsContext graphicsContext = (GraphicsContext) HitTestResultKt.currentValueOf(hazeEffectNode, CompositionLocalsKt.LocalGraphicsContext);
        GraphicsLayer graphicsLayerM828createScaledContentLayerwZMzALA = HazeKt.m828createScaledContentLayerwZMzALA(layoutNodeDrawScope, hazeEffectNode, fM827calculateInputScaleFactor3ABfNKs$default, hazeEffectNode.layerSize, hazeEffectNode.layerOffset);
        if (graphicsLayerM828createScaledContentLayerwZMzALA != null) {
            graphicsLayerM828createScaledContentLayerwZMzALA.setClip(z);
            HazeKt.m829drawScaledContentLF441nw(layoutNodeDrawScope, hazeEffectNode.layerOffset ^ (-9223372034707292160L), Size.m387times7Ah8Wj8(fM827calculateInputScaleFactor3ABfNKs$default, layoutNodeDrawScope.mo472getSizeNHjbRc()), z, new BlurEffectKt$$ExternalSyntheticLambda1(0, stringsKt__StringsKt$$ExternalSyntheticLambda0, graphicsLayerM828createScaledContentLayerwZMzALA));
            graphicsContext.releaseGraphicsLayer(graphicsLayerM828createScaledContentLayerwZMzALA);
        }
    }

    @Override // dev.chrisbanes.haze.BlurEffect
    public final /* bridge */ void cleanup() {
    }
}
