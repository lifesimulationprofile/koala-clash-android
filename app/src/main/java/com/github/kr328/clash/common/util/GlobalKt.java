package com.github.kr328.clash.common.util;

import com.github.kr328.clash.common.Global;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class GlobalKt {
    public static final String packageName;

    static {
        Global.INSTANCE.getClass();
        packageName = Global.getApplication$1().getPackageName();
    }
}
