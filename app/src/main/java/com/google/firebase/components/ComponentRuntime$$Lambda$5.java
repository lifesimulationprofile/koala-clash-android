package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ComponentRuntime$$Lambda$5 implements Provider {
    public static final ComponentRuntime$$Lambda$5 instance = new ComponentRuntime$$Lambda$5(0);
    public static final ComponentRuntime$$Lambda$5 instance$1 = new ComponentRuntime$$Lambda$5(1);
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ ComponentRuntime$$Lambda$5(int i) {
        this.$r8$classId = i;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        switch (this.$r8$classId) {
            case 0:
                return Collections.EMPTY_SET;
            default:
                return null;
        }
    }
}
