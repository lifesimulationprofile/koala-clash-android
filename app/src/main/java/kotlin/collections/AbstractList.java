package kotlin.collections;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.Modifier;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.UIntArray;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractList extends AbstractCollection implements List {

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public abstract class Companion {
        public static void checkBoundsIndexes$kotlin_stdlib(int i, int i2, int i3) {
            if (i >= 0 && i2 <= i3) {
                if (i > i2) {
                    throw new IllegalArgumentException(Modifier.CC.m(i, i2, "startIndex: ", " > endIndex: "));
                }
                return;
            }
            throw new IndexOutOfBoundsException("startIndex: " + i + ", endIndex: " + i2 + ", size: " + i3);
        }

        public static void checkRangeIndexes$kotlin_stdlib(int i, int i2, int i3) {
            if (i >= 0 && i2 <= i3) {
                if (i > i2) {
                    throw new IllegalArgumentException(Modifier.CC.m(i, i2, "fromIndex: ", " > toIndex: "));
                }
                return;
            }
            throw new IndexOutOfBoundsException("fromIndex: " + i + ", toIndex: " + i2 + ", size: " + i3);
        }

        public static int getRelativeImageRotation(int i, int i2, boolean z) {
            int i3 = z ? ((i2 - i) + 360) % 360 : (i2 + i) % 360;
            if (LazyKt__LazyJVMKt.isLogLevelEnabled(LazyKt__LazyJVMKt.truncateTag("CameraOrientationUtil"), 2)) {
                LazyKt__LazyJVMKt.d("CameraOrientationUtil", "getRelativeImageRotation: destRotationDegrees=" + i + ", sourceRotationDegrees=" + i2 + ", isOppositeFacing=" + z + ", result=" + i3);
            }
            return i3;
        }

        public static int surfaceRotationToDegrees(int i) {
            if (i == 0) {
                return 0;
            }
            if (i == 1) {
                return 90;
            }
            if (i == 2) {
                return 180;
            }
            if (i == 3) {
                return 270;
            }
            throw new IllegalArgumentException(ImageAnalysis$$ExternalSyntheticLambda1.m("Unsupported surface rotation: ", i));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class ListIteratorImpl extends UIntArray.Iterator implements ListIterator {
        public ListIteratorImpl(int i) {
            super(5, AbstractList.this);
            int size = AbstractList.this.getSize();
            if (i < 0 || i > size) {
                throw new IndexOutOfBoundsException(Modifier.CC.m(i, size, "index: ", ", size: "));
            }
            this.index = i;
        }

        @Override // java.util.ListIterator
        public final void add(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public final boolean hasPrevious() {
            return this.index > 0;
        }

        @Override // java.util.ListIterator
        public final int nextIndex() {
            return this.index;
        }

        @Override // java.util.ListIterator
        public final Object previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            int i = this.index - 1;
            this.index = i;
            return AbstractList.this.get(i);
        }

        @Override // java.util.ListIterator
        public final int previousIndex() {
            return this.index - 1;
        }

        @Override // java.util.ListIterator
        public final void set(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class SubList extends AbstractList implements RandomAccess {
        public final int _size;
        public final int fromIndex;
        public final AbstractList list;

        public SubList(AbstractList abstractList, int i, int i2) {
            this.list = abstractList;
            this.fromIndex = i;
            Companion.checkRangeIndexes$kotlin_stdlib(i, i2, abstractList.getSize());
            this._size = i2 - i;
        }

        @Override // java.util.List
        public final Object get(int i) {
            int i2 = this._size;
            if (i < 0 || i >= i2) {
                throw new IndexOutOfBoundsException(Modifier.CC.m(i, i2, "index: ", ", size: "));
            }
            return this.list.get(this.fromIndex + i);
        }

        @Override // kotlin.collections.AbstractCollection
        public final int getSize() {
            return this._size;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final List subList(int i, int i2) {
            Companion.checkRangeIndexes$kotlin_stdlib(i, i2, this._size);
            int i3 = this.fromIndex;
            return new SubList(this.list, i + i3, i3 + i2);
        }
    }

    @Override // java.util.List
    public final void add(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        Collection collection = (Collection) obj;
        if (size() == collection.size()) {
            Iterator it = collection.iterator();
            Iterator<E> it2 = iterator();
            while (it2.hasNext()) {
                if (!Intrinsics.areEqual(it2.next(), it.next())) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        Iterator<E> it = iterator();
        int iHashCode = 1;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode = (iHashCode * 31) + (next != null ? next.hashCode() : 0);
        }
        return iHashCode;
    }

    public int indexOf(Object obj) {
        Iterator it = iterator();
        int i = 0;
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next(), obj)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return new UIntArray.Iterator(5, this);
    }

    public int lastIndexOf(Object obj) {
        ListIterator listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (Intrinsics.areEqual(listIterator.previous(), obj)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    public ListIterator listIterator() {
        return new ListIteratorImpl(0);
    }

    @Override // java.util.List
    public final Object remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final Object set(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public List subList(int i, int i2) {
        return new SubList(this, i, i2);
    }

    public ListIterator listIterator(int i) {
        return new ListIteratorImpl(i);
    }
}
