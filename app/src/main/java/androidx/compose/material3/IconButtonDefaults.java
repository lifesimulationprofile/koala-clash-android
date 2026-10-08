package androidx.compose.material3;

import androidx.compose.material3.tokens.SmallIconButtonTokens;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class IconButtonDefaults {
    public static final /* synthetic */ int $r8$clinit = 0;

    static {
        float f = SmallIconButtonTokens.ContainerHeight;
    }

    /* JADX INFO: renamed from: defaultIconButtonColors-4WTKRHQ$material3, reason: not valid java name */
    public static IconButtonColors m246defaultIconButtonColors4WTKRHQ$material3(ColorScheme colorScheme, long j) {
        IconButtonColors iconButtonColors = colorScheme.defaultIconButtonColorsCached;
        if (iconButtonColors != null) {
            return iconButtonColors;
        }
        long j2 = Color.Transparent;
        IconButtonColors iconButtonColors2 = new IconButtonColors(j2, j, j2, BrushKt.Color(Color.m438getRedimpl(j), Color.m437getGreenimpl(j), Color.m435getBlueimpl(j), 0.38f, Color.m436getColorSpaceimpl(j)));
        colorScheme.defaultIconButtonColorsCached = iconButtonColors2;
        return iconButtonColors2;
    }
}
