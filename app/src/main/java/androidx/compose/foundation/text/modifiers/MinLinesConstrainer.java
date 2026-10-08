package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.DensityImpl;
import androidx.compose.ui.unit.LayoutDirection;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class MinLinesConstrainer {
    public static MinLinesConstrainer last;
    public final DensityImpl density;
    public final FontFamily$Resolver fontFamilyResolver;
    public final TextStyle inputTextStyle;
    public final LayoutDirection layoutDirection;
    public float lineHeightCache = Float.NaN;
    public float oneLineHeightCache = Float.NaN;
    public final TextStyle resolvedStyle;

    public MinLinesConstrainer(LayoutDirection layoutDirection, TextStyle textStyle, DensityImpl densityImpl, FontFamily$Resolver fontFamily$Resolver) {
        this.layoutDirection = layoutDirection;
        this.inputTextStyle = textStyle;
        this.density = densityImpl;
        this.fontFamilyResolver = fontFamily$Resolver;
        this.resolvedStyle = ParagraphKt.resolveDefaults(textStyle, layoutDirection);
    }

    /* JADX INFO: renamed from: coerceMinLines-Oh53vG4$foundation, reason: not valid java name */
    public final long m199coerceMinLinesOh53vG4$foundation(int i, long j) {
        int iM682getMinHeightimpl;
        float f = this.oneLineHeightCache;
        float f2 = this.lineHeightCache;
        if (Float.isNaN(f) || Float.isNaN(f2)) {
            String str = MinLinesConstrainerKt.EmptyTextReplacement;
            long jConstraints$default = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15);
            TextStyle textStyle = this.resolvedStyle;
            DensityImpl densityImpl = this.density;
            float height = ParagraphKt.m630ParagraphUl8oQg4$default(str, textStyle, jConstraints$default, densityImpl, this.fontFamilyResolver, 1, 96).getHeight();
            float height2 = ParagraphKt.m630ParagraphUl8oQg4$default(MinLinesConstrainerKt.TwoLineTextReplacement, this.resolvedStyle, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15), densityImpl, this.fontFamilyResolver, 2, 96).getHeight() - height;
            this.oneLineHeightCache = height;
            this.lineHeightCache = height2;
            f2 = height2;
            f = height;
        }
        if (i != 1) {
            int iRound = Math.round((f2 * (i - 1)) + f);
            iM682getMinHeightimpl = iRound >= 0 ? iRound : 0;
            int iM680getMaxHeightimpl = Constraints.m680getMaxHeightimpl(j);
            if (iM682getMinHeightimpl > iM680getMaxHeightimpl) {
                iM682getMinHeightimpl = iM680getMaxHeightimpl;
            }
        } else {
            iM682getMinHeightimpl = Constraints.m682getMinHeightimpl(j);
        }
        return ConstraintsKt.Constraints(Constraints.m683getMinWidthimpl(j), Constraints.m681getMaxWidthimpl(j), iM682getMinHeightimpl, Constraints.m680getMaxHeightimpl(j));
    }
}
