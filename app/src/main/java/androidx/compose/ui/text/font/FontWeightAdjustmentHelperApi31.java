package androidx.compose.ui.text.font;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class FontWeightAdjustmentHelperApi31 {
    public static final FontWeightAdjustmentHelperApi31 INSTANCE = new FontWeightAdjustmentHelperApi31();

    public final int fontWeightAdjustment(Context context) {
        return context.getResources().getConfiguration().fontWeightAdjustment;
    }
}
