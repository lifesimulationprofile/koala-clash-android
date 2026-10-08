package com.github.kr328.clash.common.compat;

import android.app.UiModeManager;
import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TvKt {
    public static final boolean isTvDevice(Context context) {
        Object systemService = context.getSystemService("uimode");
        UiModeManager uiModeManager = systemService instanceof UiModeManager ? (UiModeManager) systemService : null;
        return (uiModeManager != null ? uiModeManager.getCurrentModeType() : 1) == 4 || context.getPackageManager().hasSystemFeature("android.software.leanback");
    }
}
