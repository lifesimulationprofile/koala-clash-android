package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class PersistentHashMapBaseIterator implements Iterator, KMappedMarker {
    public boolean hasNext = true;
    public final TrieNodeBaseIterator[] path;
    public int pathLastIndex;

    public PersistentHashMapBaseIterator(TrieNode trieNode, TrieNodeBaseIterator[] trieNodeBaseIteratorArr) {
        this.path = trieNodeBaseIteratorArr;
        trieNodeBaseIteratorArr[0].reset(trieNode.buffer, Integer.bitCount(trieNode.dataMap) * 2, 0);
        this.pathLastIndex = 0;
        ensureNextEntryIsReady();
    }

    public final void ensureNextEntryIsReady() {
        int i = this.pathLastIndex;
        TrieNodeBaseIterator[] trieNodeBaseIteratorArr = this.path;
        TrieNodeBaseIterator trieNodeBaseIterator = trieNodeBaseIteratorArr[i];
        if (trieNodeBaseIterator.index < trieNodeBaseIterator.dataSize) {
            return;
        }
        while (-1 < i) {
            int iMoveToNextNodeWithData = moveToNextNodeWithData(i);
            if (iMoveToNextNodeWithData == -1) {
                TrieNodeBaseIterator trieNodeBaseIterator2 = trieNodeBaseIteratorArr[i];
                int i2 = trieNodeBaseIterator2.index;
                Object[] objArr = trieNodeBaseIterator2.buffer;
                if (i2 < objArr.length) {
                    int length = objArr.length;
                    trieNodeBaseIterator2.index = i2 + 1;
                    iMoveToNextNodeWithData = moveToNextNodeWithData(i);
                }
            }
            if (iMoveToNextNodeWithData != -1) {
                this.pathLastIndex = iMoveToNextNodeWithData;
                return;
            }
            if (i > 0) {
                TrieNodeBaseIterator trieNodeBaseIterator3 = trieNodeBaseIteratorArr[i - 1];
                int i3 = trieNodeBaseIterator3.index;
                int length2 = trieNodeBaseIterator3.buffer.length;
                trieNodeBaseIterator3.index = i3 + 1;
            }
            trieNodeBaseIteratorArr[i].reset(TrieNode.EMPTY.buffer, 0, 0);
            i--;
        }
        this.hasNext = false;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.hasNext;
    }

    public final int moveToNextNodeWithData(int i) {
        TrieNodeBaseIterator[] trieNodeBaseIteratorArr = this.path;
        TrieNodeBaseIterator trieNodeBaseIterator = trieNodeBaseIteratorArr[i];
        int i2 = trieNodeBaseIterator.index;
        if (i2 < trieNodeBaseIterator.dataSize) {
            return i;
        }
        Object[] objArr = trieNodeBaseIterator.buffer;
        if (i2 >= objArr.length) {
            return -1;
        }
        int length = objArr.length;
        TrieNode trieNode = (TrieNode) objArr[i2];
        if (i == 6) {
            TrieNodeBaseIterator trieNodeBaseIterator2 = trieNodeBaseIteratorArr[i + 1];
            Object[] objArr2 = trieNode.buffer;
            trieNodeBaseIterator2.reset(objArr2, objArr2.length, 0);
        } else {
            trieNodeBaseIteratorArr[i + 1].reset(trieNode.buffer, Integer.bitCount(trieNode.dataMap) * 2, 0);
        }
        return moveToNextNodeWithData(i + 1);
    }

    @Override // java.util.Iterator
    public Object next() {
        if (!this.hasNext) {
            throw new NoSuchElementException();
        }
        Object next = this.path[this.pathLastIndex].next();
        ensureNextEntryIsReady();
        return next;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
