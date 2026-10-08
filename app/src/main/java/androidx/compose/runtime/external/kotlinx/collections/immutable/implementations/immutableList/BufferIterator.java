package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class BufferIterator extends AbstractListIterator {
    public final /* synthetic */ int $r8$classId = 1;
    public final Object buffer;

    public BufferIterator(Object[] objArr, int i, int i2) {
        super(i, i2);
        this.buffer = objArr;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        switch (this.$r8$classId) {
            case 0:
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Object[] objArr = (Object[]) this.buffer;
                int i = this.index;
                this.index = i + 1;
                return objArr[i];
            default:
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                this.index++;
                return this.buffer;
        }
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        switch (this.$r8$classId) {
            case 0:
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                Object[] objArr = (Object[]) this.buffer;
                int i = this.index - 1;
                this.index = i;
                return objArr[i];
            default:
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                this.index--;
                return this.buffer;
        }
    }

    public BufferIterator(int i, Object obj) {
        super(i, 1);
        this.buffer = obj;
    }
}
