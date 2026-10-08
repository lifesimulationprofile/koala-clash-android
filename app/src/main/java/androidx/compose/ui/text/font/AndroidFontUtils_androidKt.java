package androidx.compose.ui.text.font;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AndroidFontUtils_androidKt {
    /* JADX INFO: renamed from: getAndroidTypefaceStyle-FO1MlWM, reason: not valid java name */
    public static final int m653getAndroidTypefaceStyleFO1MlWM(FontWeight fontWeight, int i) {
        boolean z = Intrinsics.compare(fontWeight.weight, FontWeight.W600.weight) >= 0;
        boolean z2 = i == 1;
        if (z2 && z) {
            return 3;
        }
        if (z) {
            return 1;
        }
        return z2 ? 2 : 0;
    }
}
