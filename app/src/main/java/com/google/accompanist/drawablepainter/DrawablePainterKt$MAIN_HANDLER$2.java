package com.google.accompanist.drawablepainter;

import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class DrawablePainterKt$MAIN_HANDLER$2 extends Lambda implements Function0 {
    public static final DrawablePainterKt$MAIN_HANDLER$2 INSTANCE = new DrawablePainterKt$MAIN_HANDLER$2(0);

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return new Handler(Looper.getMainLooper());
    }
}
