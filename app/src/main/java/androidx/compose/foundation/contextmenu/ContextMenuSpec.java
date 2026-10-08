package androidx.compose.foundation.contextmenu;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.TextUnitKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ContextMenuSpec {
    public static final float DividerVerticalPadding;
    public static final float VerticalPadding;
    public static final float ContainerWidthMin = 112;
    public static final float ContainerWidthMax = 280;
    public static final float ListItemHeight = 48;
    public static final float MenuContainerElevation = 3;
    public static final float CornerRadius = 4;
    public static final BiasAlignment.Vertical LabelVerticalTextAlignment = Alignment.Companion.CenterVertically;
    public static final int LabelHorizontalTextAlignment = 5;
    public static final float HorizontalPadding = 12;
    public static final float IconSize = 24;
    public static final float DividerHeight = 1;
    public static final long FontSize = TextUnitKt.getSp(14);
    public static final FontWeight FontWeight = FontWeight.Medium;
    public static final long LineHeight = TextUnitKt.getSp(20);
    public static final long LetterSpacing = TextUnitKt.pack(0.1f, 4294967296L);

    static {
        float f = 8;
        VerticalPadding = f;
        DividerVerticalPadding = f;
    }
}
