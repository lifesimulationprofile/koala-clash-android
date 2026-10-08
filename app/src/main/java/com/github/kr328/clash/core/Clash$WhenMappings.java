package com.github.kr328.clash.core;

import com.github.kr328.clash.core.model.TunnelState;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class Clash$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        int[] iArr = new int[TunnelState.Mode.values().length];
        try {
            TunnelState.Mode.Companion companion = TunnelState.Mode.Companion;
            iArr[0] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            TunnelState.Mode.Companion companion2 = TunnelState.Mode.Companion;
            iArr[1] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            TunnelState.Mode.Companion companion3 = TunnelState.Mode.Companion;
            iArr[2] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        $EnumSwitchMapping$0 = iArr;
    }
}
