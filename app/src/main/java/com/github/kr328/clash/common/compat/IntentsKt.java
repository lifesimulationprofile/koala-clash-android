package com.github.kr328.clash.common.compat;

import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class IntentsKt {
    public static int pendingIntentFlags$default() {
        return Build.VERSION.SDK_INT >= 24 ? 201326592 : 134217728;
    }
}
