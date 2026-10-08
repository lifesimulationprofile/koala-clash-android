package androidx.compose.foundation.text;

import androidx.compose.ui.text.AndroidParagraph;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TextFieldDelegateKt {
    public static final String EmptyTextReplacement = StringsKt__StringsJVMKt.repeat("H", 10);

    public static final long computeSizeForDefaultText(TextStyle textStyle, Density density, FontFamily$Resolver fontFamily$Resolver, String str, int i) {
        AndroidParagraph androidParagraphM630ParagraphUl8oQg4$default = ParagraphKt.m630ParagraphUl8oQg4$default(str, textStyle, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15), density, fontFamily$Resolver, i, 64);
        return (((long) BasicTextKt.ceilToIntPx(androidParagraphM630ParagraphUl8oQg4$default.paragraphIntrinsics.getMinIntrinsicWidth())) << 32) | (((long) BasicTextKt.ceilToIntPx(androidParagraphM630ParagraphUl8oQg4$default.getHeight())) & 4294967295L);
    }
}
