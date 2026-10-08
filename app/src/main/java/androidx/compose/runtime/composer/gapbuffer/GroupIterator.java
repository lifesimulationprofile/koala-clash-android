package androidx.compose.runtime.composer.gapbuffer;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class GroupIterator implements Iterator, KMappedMarker {
    public final int end;
    public int index;
    public final SlotTable table;
    public final int version;

    public GroupIterator(SlotTable slotTable, int i, int i2) {
        this.table = slotTable;
        this.end = i2;
        this.index = i;
        this.version = slotTable.version;
        if (slotTable.writer) {
            SlotTableKt.throwConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.index < this.end;
    }

    @Override // java.util.Iterator
    public final Object next() {
        SlotTable slotTable = this.table;
        int i = slotTable.version;
        int i2 = this.version;
        if (i != i2) {
            SlotTableKt.throwConcurrentModificationException();
        }
        int i3 = this.index;
        this.index = slotTable.groups[(i3 * 5) + 3] + i3;
        return new SlotTableGroup(slotTable, i3, i2);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
