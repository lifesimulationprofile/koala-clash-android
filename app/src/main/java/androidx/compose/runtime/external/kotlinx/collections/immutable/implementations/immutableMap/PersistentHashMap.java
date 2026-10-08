package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.Links;
import coil.memory.RealWeakMemoryCache;
import kotlin.collections.AbstractMap;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public class PersistentHashMap extends AbstractMap implements PersistentMap {
    public static final PersistentHashMap EMPTY = new PersistentHashMap(TrieNode.EMPTY, 0);
    public final TrieNode node;
    public final int size;

    public PersistentHashMap(TrieNode trieNode, int i) {
        this.node = trieNode;
        this.size = i;
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.node.containsKey(obj != null ? obj.hashCode() : 0, 0, obj);
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        return this.node.get(obj != null ? obj.hashCode() : 0, 0, obj);
    }

    public final PersistentHashMap put(Object obj, Links links) {
        RealWeakMemoryCache realWeakMemoryCachePut = this.node.put(obj, obj != null ? obj.hashCode() : 0, links, 0);
        return realWeakMemoryCachePut == null ? this : new PersistentHashMap((TrieNode) realWeakMemoryCachePut.cache, this.size + realWeakMemoryCachePut.operationsSinceCleanUp);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap
    public PersistentHashMapBuilder builder() {
        return new PersistentHashMapBuilder(this);
    }
}
