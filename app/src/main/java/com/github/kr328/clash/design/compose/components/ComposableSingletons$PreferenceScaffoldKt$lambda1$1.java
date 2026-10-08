package com.github.kr328.clash.design.compose.components;

import androidx.compose.runtime.GapComposer;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: renamed from: com.github.kr328.clash.design.compose.components.ComposableSingletons$PreferenceScaffoldKt$lambda-1$1, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ComposableSingletons$PreferenceScaffoldKt$lambda1$1 implements Function3 {
    public static final ComposableSingletons$PreferenceScaffoldKt$lambda1$1 INSTANCE = new ComposableSingletons$PreferenceScaffoldKt$lambda1$1();

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        GapComposer gapComposer = (GapComposer) obj2;
        if ((((Number) obj3).intValue() & 17) == 16 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
