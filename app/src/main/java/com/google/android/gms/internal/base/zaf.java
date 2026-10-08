package com.google.android.gms.internal.base;

import com.google.android.gms.common.Feature;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zaf {
    public static final Feature zaa;
    public static final Feature zaa$1;
    public static final Feature[] zab;
    public static final Feature[] zab$1;

    static {
        Feature feature = new Feature("CLIENT_TELEMETRY", 1L);
        zaa = feature;
        zab = new Feature[]{feature};
        Feature feature2 = new Feature("moduleinstall", 7L);
        zaa$1 = feature2;
        zab$1 = new Feature[]{feature2};
    }
}
