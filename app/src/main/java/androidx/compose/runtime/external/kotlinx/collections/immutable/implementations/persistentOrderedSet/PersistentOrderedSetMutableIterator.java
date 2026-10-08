package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import java.util.ConcurrentModificationException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableCollection;
import kotlin.sequences.GeneratorSequence;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class PersistentOrderedSetMutableIterator extends GeneratorSequence.AnonymousClass1 {
    public final PersistentOrderedSetBuilder builder;
    public int expectedModCount;
    public Object lastIteratedElement;
    public boolean nextWasInvoked;

    /* JADX WARN: Illegal instructions before constructor call */
    public PersistentOrderedSetMutableIterator(PersistentOrderedSetBuilder persistentOrderedSetBuilder) {
        Object obj = persistentOrderedSetBuilder.firstElement;
        PersistentHashMapBuilder persistentHashMapBuilder = persistentOrderedSetBuilder.hashMapBuilder;
        super(obj, persistentHashMapBuilder);
        this.builder = persistentOrderedSetBuilder;
        this.expectedModCount = persistentHashMapBuilder.modCount;
    }

    @Override // kotlin.sequences.GeneratorSequence.AnonymousClass1, java.util.Iterator
    public final Object next() {
        if (this.builder.hashMapBuilder.modCount != this.expectedModCount) {
            throw new ConcurrentModificationException();
        }
        Object next = super.next();
        this.lastIteratedElement = next;
        this.nextWasInvoked = true;
        return next;
    }

    @Override // kotlin.sequences.GeneratorSequence.AnonymousClass1, java.util.Iterator
    public final void remove() {
        if (!this.nextWasInvoked) {
            throw new IllegalStateException();
        }
        Object obj = this.lastIteratedElement;
        PersistentOrderedSetBuilder persistentOrderedSetBuilder = this.builder;
        if ((persistentOrderedSetBuilder instanceof KMappedMarker) && !(persistentOrderedSetBuilder instanceof KMutableCollection)) {
            TypeIntrinsics.throwCce(persistentOrderedSetBuilder, "kotlin.collections.MutableCollection");
            throw null;
        }
        try {
            persistentOrderedSetBuilder.remove(obj);
            this.lastIteratedElement = null;
            this.nextWasInvoked = false;
            this.expectedModCount = persistentOrderedSetBuilder.hashMapBuilder.modCount;
            this.nextState--;
        } catch (ClassCastException e) {
            Intrinsics.sanitizeStackTrace(e, TypeIntrinsics.class.getName());
            throw e;
        }
    }
}
