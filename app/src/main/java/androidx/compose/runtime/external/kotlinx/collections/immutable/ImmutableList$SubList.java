package androidx.compose.runtime.external.kotlinx.collections.immutable;

import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList;
import com.google.android.gms.internal.mlkit_vision_barcode.zzsr;
import java.util.List;
import kotlin.collections.AbstractList;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ImmutableList$SubList extends AbstractList {
    public final int _size;
    public final int fromIndex;
    public final AbstractPersistentList source;

    public ImmutableList$SubList(AbstractPersistentList abstractPersistentList, int i, int i2) {
        this.source = abstractPersistentList;
        this.fromIndex = i;
        zzsr.checkRangeIndexes$runtime(i, i2, abstractPersistentList.getSize());
        this._size = i2 - i;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzsr.checkElementIndex$runtime(i, this._size);
        return this.source.get(this.fromIndex + i);
    }

    @Override // kotlin.collections.AbstractCollection
    public final int getSize() {
        return this._size;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final List subList(int i, int i2) {
        zzsr.checkRangeIndexes$runtime(i, i2, this._size);
        int i3 = this.fromIndex;
        return new ImmutableList$SubList(this.source, i + i3, i3 + i2);
    }
}
