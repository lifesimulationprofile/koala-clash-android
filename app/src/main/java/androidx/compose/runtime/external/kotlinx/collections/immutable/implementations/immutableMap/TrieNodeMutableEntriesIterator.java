package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.ui.graphics.vector.VectorGroup;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class TrieNodeMutableEntriesIterator extends TrieNodeBaseIterator {
    public final VectorGroup.AnonymousClass1 parentIterator;

    public TrieNodeMutableEntriesIterator(VectorGroup.AnonymousClass1 anonymousClass1) {
        this.parentIterator = anonymousClass1;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.index;
        this.index = i + 2;
        Object[] objArr = this.buffer;
        return new MutableMapEntry(this.parentIterator, objArr[i], objArr[i + 1]);
    }
}
