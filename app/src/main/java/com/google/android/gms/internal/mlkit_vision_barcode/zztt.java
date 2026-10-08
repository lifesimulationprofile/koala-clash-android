package com.google.android.gms.internal.mlkit_vision_barcode;

import androidx.compose.ui.text.android.selection.SegmentFinder;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zztt implements SegmentFinder {
    public abstract int next(int i);

    @Override // androidx.compose.ui.text.android.selection.SegmentFinder
    public int nextEndBoundary(int i) {
        return next(i);
    }

    @Override // androidx.compose.ui.text.android.selection.SegmentFinder
    public int nextStartBoundary(int i) {
        int next = next(i);
        if (next == -1 || next(next) == -1) {
            return -1;
        }
        return next;
    }

    public abstract int previous(int i);

    @Override // androidx.compose.ui.text.android.selection.SegmentFinder
    public int previousEndBoundary(int i) {
        int iPrevious = previous(i);
        if (iPrevious == -1 || previous(iPrevious) == -1) {
            return -1;
        }
        return iPrevious;
    }

    @Override // androidx.compose.ui.text.android.selection.SegmentFinder
    public int previousStartBoundary(int i) {
        return previous(i);
    }
}
