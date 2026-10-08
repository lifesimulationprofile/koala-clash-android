package androidx.compose.foundation.text.modifiers;

import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class MinLinesConstrainerKt {
    public static final String EmptyTextReplacement;
    public static final String TwoLineTextReplacement;

    static {
        String strRepeat = StringsKt__StringsJVMKt.repeat("H", 10);
        EmptyTextReplacement = strRepeat;
        TwoLineTextReplacement = strRepeat + '\n' + strRepeat;
    }
}
