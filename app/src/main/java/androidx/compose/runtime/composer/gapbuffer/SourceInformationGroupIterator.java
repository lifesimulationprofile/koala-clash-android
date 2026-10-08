package androidx.compose.runtime.composer.gapbuffer;

import com.google.android.gms.internal.mlkit_vision_barcode.zzsl;
import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class SourceInformationGroupIterator implements Iterator, KMappedMarker {
    public int index;
    public final int parent;
    public final zzsl path;
    public final SlotTable table;
    public final int version;

    public SourceInformationGroupIterator(SlotTable slotTable, int i, GapGroupSourceInformation gapGroupSourceInformation, zzsl zzslVar) {
        this.table = slotTable;
        this.parent = i;
        this.path = zzslVar;
        this.version = slotTable.version;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        throw null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        throw null;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
