package com.github.kr328.clash.compose.settings;

import androidx.compose.runtime.GapComposer;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class SettingsScreenKt$SettingsScreen$3$2 implements Function2 {
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        GapComposer gapComposer = (GapComposer) obj;
        if ((((Number) obj2).intValue() & 3) == 2 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
