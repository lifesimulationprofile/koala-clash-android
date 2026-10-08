package androidx.compose.material3;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.shape.DpCornerSize;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.material3.tokens.ShapeTokens;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ShapeDefaults {
    public static final RoundedCornerShape ExtraSmall = ShapeTokens.CornerExtraSmall;
    public static final RoundedCornerShape Small = ShapeTokens.CornerSmall;
    public static final RoundedCornerShape Medium = ShapeTokens.CornerMedium;
    public static final RoundedCornerShape Large = ShapeTokens.CornerLarge;
    public static final RoundedCornerShape LargeIncreased = ShapeTokens.CornerLargeIncreased;
    public static final RoundedCornerShape ExtraLarge = ShapeTokens.CornerExtraLarge;
    public static final RoundedCornerShape ExtraLargeIncreased = ShapeTokens.CornerExtraLargeIncreased;
    public static final RoundedCornerShape ExtraExtraLarge = ShapeTokens.CornerExtraExtraLarge;
    public static final DpCornerSize CornerNone = ShapeTokens.CornerValueNone;

    static {
        float f = 100;
        if (f < 0.0f || f > 100.0f) {
            InlineClassHelperKt.throwIllegalArgumentException("The percent should be in the range of [0, 100]");
        }
    }
}
