package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.StateRecord;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class SnapshotMutableFloatStateImpl$FloatStateStateRecord extends StateRecord {
    public float value;

    public SnapshotMutableFloatStateImpl$FloatStateStateRecord(float f, long j) {
        super(j);
        this.value = f;
    }

    @Override // androidx.compose.runtime.snapshots.StateRecord
    public final void assign(StateRecord stateRecord) {
        this.value = ((SnapshotMutableFloatStateImpl$FloatStateStateRecord) stateRecord).value;
    }

    @Override // androidx.compose.runtime.snapshots.StateRecord
    public final StateRecord create(long j) {
        return new SnapshotMutableFloatStateImpl$FloatStateStateRecord(this.value, j);
    }
}
