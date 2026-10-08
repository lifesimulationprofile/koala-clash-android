package androidx.compose.ui.text.android;

import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TextLayout_androidKt {
    public static final ThreadLocal SharedTextAndroidCanvas = new ThreadLocal();
    public static final long ZeroVerticalPadding = VerticalPaddings(0, 0);

    public static final long VerticalPaddings(int i, int i2) {
        return (((long) i2) & 4294967295L) | (((long) i) << 32);
    }

    public static final TextDirectionHeuristic getTextDirectionHeuristic(int i) {
        if (i == 0) {
            return TextDirectionHeuristics.LTR;
        }
        if (i == 1) {
            return TextDirectionHeuristics.RTL;
        }
        if (i == 2) {
            return TextDirectionHeuristics.FIRSTSTRONG_LTR;
        }
        if (i == 3) {
            return TextDirectionHeuristics.FIRSTSTRONG_RTL;
        }
        if (i != 4) {
            return i != 5 ? TextDirectionHeuristics.FIRSTSTRONG_LTR : TextDirectionHeuristics.LOCALE;
        }
        return TextDirectionHeuristics.ANYRTL_LTR;
    }
}
