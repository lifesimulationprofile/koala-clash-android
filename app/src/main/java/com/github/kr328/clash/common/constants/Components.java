package com.github.kr328.clash.common.constants;

import android.content.ComponentName;
import com.github.kr328.clash.common.util.GlobalKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Components {
    public static final ComponentName MAIN_ACTIVITY;

    static {
        String str = GlobalKt.packageName;
        MAIN_ACTIVITY = new ComponentName(str, "com.github.kr328.clash.MainActivity");
        new ComponentName(str, "com.github.kr328.clash.PropertiesActivity");
    }
}
