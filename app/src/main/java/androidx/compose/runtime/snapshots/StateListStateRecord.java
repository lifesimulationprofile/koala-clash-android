package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList;
import kotlin.Unit;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class StateListStateRecord extends StateRecord {
    public AbstractPersistentList list;
    public int modification;
    public int structuralChange;

    public StateListStateRecord(long j, AbstractPersistentList abstractPersistentList) {
        super(j);
        this.list = abstractPersistentList;
    }

    @Override // androidx.compose.runtime.snapshots.StateRecord
    public final void assign(StateRecord stateRecord) {
        synchronized (SnapshotId_jvmKt.sync) {
            this.list = ((StateListStateRecord) stateRecord).list;
            this.modification = ((StateListStateRecord) stateRecord).modification;
            this.structuralChange = ((StateListStateRecord) stateRecord).structuralChange;
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.snapshots.StateRecord
    public final StateRecord create(long j) {
        return new StateListStateRecord(j, this.list);
    }
}
