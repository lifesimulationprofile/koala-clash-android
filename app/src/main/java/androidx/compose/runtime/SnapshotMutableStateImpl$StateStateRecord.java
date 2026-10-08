package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.StateRecord;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class SnapshotMutableStateImpl$StateStateRecord extends StateRecord {
    public Object value;

    public SnapshotMutableStateImpl$StateStateRecord(long j, Object obj) {
        super(j);
        this.value = obj;
    }

    @Override // androidx.compose.runtime.snapshots.StateRecord
    public final void assign(StateRecord stateRecord) {
        this.value = ((SnapshotMutableStateImpl$StateStateRecord) stateRecord).value;
    }

    @Override // androidx.compose.runtime.snapshots.StateRecord
    public final StateRecord create(long j) {
        return new SnapshotMutableStateImpl$StateStateRecord(SnapshotKt.currentSnapshot().getSnapshotId(), this.value);
    }
}
