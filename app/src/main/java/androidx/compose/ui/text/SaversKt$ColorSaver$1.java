package androidx.compose.ui.text;

import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class SaversKt$ColorSaver$1 implements Function2 {
    public static final SaversKt$ColorSaver$1 INSTANCE = new SaversKt$ColorSaver$1();

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        long j = ((Color) obj2).value;
        return j == 16 ? Boolean.FALSE : Integer.valueOf(BrushKt.m424toArgb8_81llA(j));
    }
}
