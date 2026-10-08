package com.google.android.gms.internal.mlkit_vision_barcode;

import androidx.compose.runtime.composer.gapbuffer.changelist.Operations;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzsn {
    /* JADX INFO: renamed from: setObject-sGr0YRc, reason: not valid java name */
    public static final void m817setObjectsGr0YRc(Operations operations, int i, Object obj) {
        operations.objectArgs[(operations.objectArgsSize - operations.opCodes[operations.opCodesSize - 1].objects) + i] = obj;
    }

    /* JADX INFO: renamed from: setObjects-EsEZvaA, reason: not valid java name */
    public static final void m818setObjectsEsEZvaA(Operations operations, int i, Object obj, int i2, Object obj2) {
        int i3 = operations.objectArgsSize - operations.opCodes[operations.opCodesSize - 1].objects;
        Object[] objArr = operations.objectArgs;
        objArr[i + i3] = obj;
        objArr[i3 + i2] = obj2;
    }
}
