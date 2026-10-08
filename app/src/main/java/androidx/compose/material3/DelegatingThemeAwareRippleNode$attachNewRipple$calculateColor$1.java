package androidx.compose.material3;

import androidx.compose.runtime.DynamicProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.node.HitTestResultKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class DelegatingThemeAwareRippleNode$attachNewRipple$calculateColor$1 implements ColorProducer {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ DelegatingThemeAwareRippleNode this$0;

    public /* synthetic */ DelegatingThemeAwareRippleNode$attachNewRipple$calculateColor$1(DelegatingThemeAwareRippleNode delegatingThemeAwareRippleNode, int i) {
        this.$r8$classId = i;
        this.this$0 = delegatingThemeAwareRippleNode;
    }

    @Override // androidx.compose.ui.graphics.ColorProducer
    /* JADX INFO: renamed from: invoke-0d7_KjU, reason: not valid java name */
    public final long mo244invoke0d7_KjU() {
        switch (this.$r8$classId) {
            case 0:
                DelegatingThemeAwareRippleNode delegatingThemeAwareRippleNode = this.this$0;
                long jMo244invoke0d7_KjU = delegatingThemeAwareRippleNode.color.mo244invoke0d7_KjU();
                if (jMo244invoke0d7_KjU != 16) {
                    return jMo244invoke0d7_KjU;
                }
                RippleConfiguration rippleConfiguration = (RippleConfiguration) HitTestResultKt.currentValueOf(delegatingThemeAwareRippleNode, RippleKt.LocalRippleConfiguration);
                if (rippleConfiguration != null) {
                    long j = rippleConfiguration.color;
                    if (j != 16) {
                        return j;
                    }
                }
                return ((Color) HitTestResultKt.currentValueOf(delegatingThemeAwareRippleNode, ContentColorKt.LocalContentColor)).value;
            default:
                DynamicProvidableCompositionLocal dynamicProvidableCompositionLocal = RippleKt.LocalRippleConfiguration;
                DelegatingThemeAwareRippleNode delegatingThemeAwareRippleNode2 = this.this$0;
                return ((MaterialTheme$Values) HitTestResultKt.currentValueOf(delegatingThemeAwareRippleNode2, MaterialThemeKt._localMaterialTheme)).colorScheme.secondary;
        }
    }
}
