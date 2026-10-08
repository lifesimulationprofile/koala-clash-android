package kotlin.text;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.graphics.vector.ImageVector;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes.dex */
public abstract class CharsKt {
    public static ImageVector _article;

    public static void checkRadix(int i) {
        if (2 > i || i >= 37) {
            StringBuilder sbM = ImageAnalysis$$ExternalSyntheticLambda1.m(i, "radix ", " was not in valid range ");
            sbM.append(new IntRange(2, 36, 1));
            throw new IllegalArgumentException(sbM.toString());
        }
    }

    public static final boolean equals(char c, char c2, boolean z) {
        if (c == c2) {
            return true;
        }
        if (!z) {
            return false;
        }
        char upperCase = Character.toUpperCase(c);
        char upperCase2 = Character.toUpperCase(c2);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }

    public static boolean isWhitespace(char c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c);
    }
}
