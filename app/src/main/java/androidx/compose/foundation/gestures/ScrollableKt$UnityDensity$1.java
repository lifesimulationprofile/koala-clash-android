package androidx.compose.foundation.gestures;

import androidx.compose.ui.unit.Density;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ScrollableKt$UnityDensity$1 implements Density {
    @Override // androidx.compose.ui.unit.Density
    public final float getDensity() {
        return 1.0f;
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getFontScale() {
        return 1.0f;
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    public final /* synthetic */ int mo83roundToPx0680j_4(float f) {
        return Density.CC.m693$default$roundToPx0680j_4(this, f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-GaN1DYA */
    public final /* synthetic */ float mo84toDpGaN1DYA(long j) {
        return Density.CC.m694$default$toDpGaN1DYA(j, this);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public final float mo85toDpu2uoSUM(float f) {
        return f / 1.0f;
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    public final /* synthetic */ long mo87toDpSizekrfVVM(long j) {
        return Density.CC.m695$default$toDpSizekrfVVM(j, this);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx--R2X_6o */
    public final /* synthetic */ float mo88toPxR2X_6o(long j) {
        return Density.CC.m696$default$toPxR2X_6o(j, this);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx-0680j_4 */
    public final float mo89toPx0680j_4(float f) {
        return 1.0f * f;
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    public final /* synthetic */ long mo90toSizeXkaWNTQ(long j) {
        return Density.CC.m697$default$toSizeXkaWNTQ(j, this);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public final long mo91toSpkPz2Gy4(float f) {
        return Density.CC.m698$default$toSp0xMU5do(this, mo85toDpu2uoSUM(f));
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public final float mo86toDpu2uoSUM(int i) {
        return i / 1.0f;
    }
}
