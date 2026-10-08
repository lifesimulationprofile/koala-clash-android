package com.google.android.gms.internal.mlkit_vision_barcode;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzbs implements Map.Entry {
    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            if (com.google.android.gms.internal.mlkit_vision_common.zzlo.zza(getKey(), entry.getKey()) && com.google.android.gms.internal.mlkit_vision_common.zzlo.zza(getValue(), entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object key = getKey();
        Object value = getValue();
        return (key == null ? 0 : key.hashCode()) ^ (value != null ? value.hashCode() : 0);
    }

    public final String toString() {
        return ImageAnalysis$$ExternalSyntheticLambda1.m(String.valueOf(getKey()), "=", String.valueOf(getValue()));
    }
}
