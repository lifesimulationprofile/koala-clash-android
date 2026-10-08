package com.github.kr328.clash.design.compose.theme;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Density;
import kotlin.ULong;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AppColors {
    public final long accentBorder;
    public final long accentFill;
    public final long appBackground;
    public final long buttonActiveEnd;
    public final long buttonActiveStart;
    public final long buttonColor;
    public final long buttonInactiveBorder;
    public final long buttonInactiveEnd;
    public final long buttonInactiveStart;
    public final long cardBackground;
    public final long cardBorder;
    public final long destructive;
    public final long networkTcp;
    public final long networkUdp;
    public final long statusActive;
    public final long statusClosed;
    public final long textPrimary;
    public final long textSecondary;

    public AppColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18) {
        this.appBackground = j;
        this.cardBackground = j2;
        this.cardBorder = j3;
        this.accentBorder = j4;
        this.accentFill = j5;
        this.buttonActiveStart = j6;
        this.buttonActiveEnd = j7;
        this.buttonInactiveStart = j8;
        this.buttonInactiveEnd = j9;
        this.buttonInactiveBorder = j10;
        this.buttonColor = j11;
        this.textPrimary = j12;
        this.textSecondary = j13;
        this.statusActive = j14;
        this.statusClosed = j15;
        this.networkTcp = j16;
        this.networkUdp = j17;
        this.destructive = j18;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppColors)) {
            return false;
        }
        AppColors appColors = (AppColors) obj;
        return Color.m433equalsimpl0(this.appBackground, appColors.appBackground) && Color.m433equalsimpl0(this.cardBackground, appColors.cardBackground) && Color.m433equalsimpl0(this.cardBorder, appColors.cardBorder) && Color.m433equalsimpl0(this.accentBorder, appColors.accentBorder) && Color.m433equalsimpl0(this.accentFill, appColors.accentFill) && Color.m433equalsimpl0(this.buttonActiveStart, appColors.buttonActiveStart) && Color.m433equalsimpl0(this.buttonActiveEnd, appColors.buttonActiveEnd) && Color.m433equalsimpl0(this.buttonInactiveStart, appColors.buttonInactiveStart) && Color.m433equalsimpl0(this.buttonInactiveEnd, appColors.buttonInactiveEnd) && Color.m433equalsimpl0(this.buttonInactiveBorder, appColors.buttonInactiveBorder) && Color.m433equalsimpl0(this.buttonColor, appColors.buttonColor) && Color.m433equalsimpl0(this.textPrimary, appColors.textPrimary) && Color.m433equalsimpl0(this.textSecondary, appColors.textSecondary) && Color.m433equalsimpl0(this.statusActive, appColors.statusActive) && Color.m433equalsimpl0(this.statusClosed, appColors.statusClosed) && Color.m433equalsimpl0(this.networkTcp, appColors.networkTcp) && Color.m433equalsimpl0(this.networkUdp, appColors.networkUdp) && Color.m433equalsimpl0(this.destructive, appColors.destructive);
    }

    public final int hashCode() {
        int i = Color.$r8$clinit;
        return ULong.m836hashCodeimpl(this.destructive) + ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ImageAnalysis$$ExternalSyntheticLambda1.m(ULong.m836hashCodeimpl(this.appBackground) * 31, 31, this.cardBackground), 31, this.cardBorder), 31, this.accentBorder), 31, this.accentFill), 31, this.buttonActiveStart), 31, this.buttonActiveEnd), 31, this.buttonInactiveStart), 31, this.buttonInactiveEnd), 31, this.buttonInactiveBorder), 31, this.buttonColor), 31, this.textPrimary), 31, this.textSecondary), 31, this.statusActive), 31, this.statusClosed), 31, this.networkTcp), 31, this.networkUdp);
    }

    public final String toString() {
        String strM439toStringimpl = Color.m439toStringimpl(this.appBackground);
        String strM439toStringimpl2 = Color.m439toStringimpl(this.cardBackground);
        String strM439toStringimpl3 = Color.m439toStringimpl(this.cardBorder);
        String strM439toStringimpl4 = Color.m439toStringimpl(this.accentBorder);
        String strM439toStringimpl5 = Color.m439toStringimpl(this.accentFill);
        String strM439toStringimpl6 = Color.m439toStringimpl(this.buttonActiveStart);
        String strM439toStringimpl7 = Color.m439toStringimpl(this.buttonActiveEnd);
        String strM439toStringimpl8 = Color.m439toStringimpl(this.buttonInactiveStart);
        String strM439toStringimpl9 = Color.m439toStringimpl(this.buttonInactiveEnd);
        String strM439toStringimpl10 = Color.m439toStringimpl(this.buttonInactiveBorder);
        String strM439toStringimpl11 = Color.m439toStringimpl(this.buttonColor);
        String strM439toStringimpl12 = Color.m439toStringimpl(this.textPrimary);
        String strM439toStringimpl13 = Color.m439toStringimpl(this.textSecondary);
        String strM439toStringimpl14 = Color.m439toStringimpl(this.statusActive);
        String strM439toStringimpl15 = Color.m439toStringimpl(this.statusClosed);
        String strM439toStringimpl16 = Color.m439toStringimpl(this.networkTcp);
        String strM439toStringimpl17 = Color.m439toStringimpl(this.networkUdp);
        String strM439toStringimpl18 = Color.m439toStringimpl(this.destructive);
        StringBuilder sbM = CaptureSession$State$EnumUnboxingLocalUtility.m("AppColors(appBackground=", strM439toStringimpl, ", cardBackground=", strM439toStringimpl2, ", cardBorder=");
        Density.CC.m(sbM, strM439toStringimpl3, ", accentBorder=", strM439toStringimpl4, ", accentFill=");
        Density.CC.m(sbM, strM439toStringimpl5, ", buttonActiveStart=", strM439toStringimpl6, ", buttonActiveEnd=");
        Density.CC.m(sbM, strM439toStringimpl7, ", buttonInactiveStart=", strM439toStringimpl8, ", buttonInactiveEnd=");
        Density.CC.m(sbM, strM439toStringimpl9, ", buttonInactiveBorder=", strM439toStringimpl10, ", buttonColor=");
        Density.CC.m(sbM, strM439toStringimpl11, ", textPrimary=", strM439toStringimpl12, ", textSecondary=");
        Density.CC.m(sbM, strM439toStringimpl13, ", statusActive=", strM439toStringimpl14, ", statusClosed=");
        Density.CC.m(sbM, strM439toStringimpl15, ", networkTcp=", strM439toStringimpl16, ", networkUdp=");
        sbM.append(strM439toStringimpl17);
        sbM.append(", destructive=");
        sbM.append(strM439toStringimpl18);
        sbM.append(")");
        return sbM.toString();
    }
}
