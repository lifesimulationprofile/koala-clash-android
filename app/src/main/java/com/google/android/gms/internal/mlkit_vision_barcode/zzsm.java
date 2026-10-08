package com.google.android.gms.internal.mlkit_vision_barcode;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.composer.gapbuffer.SlotWriter;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzsm {
    public static final void positionToParentOf(SlotWriter slotWriter, Applier applier, int i) {
        while (true) {
            int i2 = slotWriter.parent;
            if (i > i2 && i < slotWriter.currentGroupEnd) {
                return;
            }
            if (i2 == 0 && i == 0) {
                return;
            }
            slotWriter.skipToGroupEnd();
            if (slotWriter.isNode(slotWriter.parent)) {
                applier.up();
            }
            slotWriter.endGroup();
        }
    }
}
