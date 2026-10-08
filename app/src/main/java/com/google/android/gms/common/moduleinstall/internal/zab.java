package com.google.android.gms.common.moduleinstall.internal;

import com.google.android.gms.common.Feature;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zab implements Comparator {
    public static final /* synthetic */ zab zaa = new zab();

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        Feature feature = (Feature) obj;
        Feature feature2 = (Feature) obj2;
        return !feature.zza.equals(feature2.zza) ? feature.zza.compareTo(feature2.zza) : (feature.getVersion() > feature2.getVersion() ? 1 : (feature.getVersion() == feature2.getVersion() ? 0 : -1));
    }
}
