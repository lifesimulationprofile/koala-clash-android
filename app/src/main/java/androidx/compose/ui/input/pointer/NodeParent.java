package androidx.compose.ui.input.pointer;

import androidx.collection.LongSparseArray;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.layout.LayoutCoordinates;
import coil.memory.RealStrongMemoryCache;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public class NodeParent {
    public final MutableVector children = new MutableVector(new Node[16]);
    public final MutableObjectList removeMatchingPointerInputModifierNodeList = new MutableObjectList(10);

    public boolean buildCache(LongSparseArray longSparseArray, LayoutCoordinates layoutCoordinates, RealStrongMemoryCache realStrongMemoryCache, boolean z) {
        MutableVector mutableVector = this.children;
        Object[] objArr = mutableVector.content;
        int i = mutableVector.size;
        boolean z2 = false;
        for (int i2 = 0; i2 < i; i2++) {
            z2 = ((Node) objArr[i2]).buildCache(longSparseArray, layoutCoordinates, realStrongMemoryCache, z) || z2;
        }
        return z2;
    }

    public void cleanUpHits(RealStrongMemoryCache realStrongMemoryCache) {
        MutableVector mutableVector = this.children;
        int i = mutableVector.size;
        while (true) {
            i--;
            if (-1 >= i) {
                return;
            }
            if (((Node) mutableVector.content[i]).pointerIds.operationsSinceCleanUp == 0) {
                mutableVector.removeAt(i);
            }
        }
    }
}
