package dev.chrisbanes.haze;

import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.snapshots.SnapshotStateList;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class HazeState {
    public final SnapshotStateList _areas = new SnapshotStateList();
    public final ParcelableSnapshotMutableState blurEnabled$delegate;

    public HazeState(boolean z) {
        this.blurEnabled$delegate = Stack.mutableStateOf$default(Boolean.valueOf(z));
    }
}
