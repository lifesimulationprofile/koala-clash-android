package androidx.compose.material3;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.graphics.Color;
import kotlin.ULong;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class TopAppBarColors {
    public final long actionIconContentColor;
    public final long containerColor;
    public final long navigationIconContentColor;
    public final long scrolledContainerColor;
    public final long subtitleContentColor;
    public final long titleContentColor;

    public TopAppBarColors(long j, long j2, long j3, long j4, long j5, long j6) {
        this.containerColor = j;
        this.scrolledContainerColor = j2;
        this.navigationIconContentColor = j3;
        this.titleContentColor = j4;
        this.actionIconContentColor = j5;
        this.subtitleContentColor = j6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof TopAppBarColors)) {
            return false;
        }
        TopAppBarColors topAppBarColors = (TopAppBarColors) obj;
        return Color.m433equalsimpl0(this.containerColor, topAppBarColors.containerColor) && Color.m433equalsimpl0(this.scrolledContainerColor, topAppBarColors.scrolledContainerColor) && Color.m433equalsimpl0(this.navigationIconContentColor, topAppBarColors.navigationIconContentColor) && Color.m433equalsimpl0(this.titleContentColor, topAppBarColors.titleContentColor) && Color.m433equalsimpl0(this.actionIconContentColor, topAppBarColors.actionIconContentColor) && Color.m433equalsimpl0(this.subtitleContentColor, topAppBarColors.subtitleContentColor);
    }

    public final int hashCode() {
        int i = Color.$r8$clinit;
        return ULong.m836hashCodeimpl(this.subtitleContentColor) + ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ULong.m836hashCodeimpl(this.containerColor) * 31, 31, this.scrolledContainerColor), 31, this.navigationIconContentColor), 31, this.titleContentColor), 31, this.actionIconContentColor);
    }
}
