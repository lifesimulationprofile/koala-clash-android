package androidx.compose.runtime.composer.gapbuffer;

import androidx.collection.MutableIntList;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class PrioritySet {
    /* JADX INFO: renamed from: add-impl, reason: not valid java name */
    public static final void m300addimpl(MutableIntList mutableIntList, int i) {
        if (mutableIntList._size == 0 || !(mutableIntList.get(0) == i || mutableIntList.get(mutableIntList._size - 1) == i)) {
            int i2 = mutableIntList._size;
            mutableIntList.add(i);
            while (i2 > 0) {
                int i3 = ((i2 + 1) >>> 1) - 1;
                int i4 = mutableIntList.get(i3);
                if (i <= i4) {
                    break;
                }
                mutableIntList.set(i2, i4);
                i2 = i3;
            }
            mutableIntList.set(i2, i);
        }
    }

    /* JADX INFO: renamed from: takeMax-impl, reason: not valid java name */
    public static final int m301takeMaximpl(MutableIntList mutableIntList) {
        int i;
        int i2 = mutableIntList._size;
        int i3 = mutableIntList.get(0);
        while (mutableIntList._size != 0 && mutableIntList.get(0) == i3) {
            mutableIntList.set(0, mutableIntList.last());
            mutableIntList.removeAt(mutableIntList._size - 1);
            int i4 = mutableIntList._size;
            int i5 = i4 >>> 1;
            int i6 = 0;
            while (i6 < i5) {
                int i7 = mutableIntList.get(i6);
                int i8 = (i6 + 1) * 2;
                int i9 = i8 - 1;
                int i10 = mutableIntList.get(i9);
                if (i8 < i4 && (i = mutableIntList.get(i8)) > i10) {
                    if (i <= i7) {
                        break;
                    }
                    mutableIntList.set(i6, i);
                    mutableIntList.set(i8, i7);
                    i6 = i8;
                } else {
                    if (i10 <= i7) {
                        break;
                    }
                    mutableIntList.set(i6, i10);
                    mutableIntList.set(i9, i7);
                    i6 = i9;
                }
            }
        }
        return i3;
    }
}
