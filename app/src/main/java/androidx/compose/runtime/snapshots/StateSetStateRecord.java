package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import kotlin.Unit;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class StateSetStateRecord extends StateRecord {
    public int modification;
    public PersistentSet set;

    public StateSetStateRecord(long j, PersistentSet persistentSet) {
        super(j);
        this.set = persistentSet;
    }

    @Override // androidx.compose.runtime.snapshots.StateRecord
    public final void assign(StateRecord stateRecord) {
        synchronized (SnapshotId_jvmKt.sync$2) {
            this.set = ((StateSetStateRecord) stateRecord).set;
            this.modification = ((StateSetStateRecord) stateRecord).modification;
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.snapshots.StateRecord
    public final StateRecord create(long j) {
        return new StateSetStateRecord(j, this.set);
    }
}
