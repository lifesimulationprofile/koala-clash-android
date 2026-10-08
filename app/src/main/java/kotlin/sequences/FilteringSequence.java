package kotlin.sequences;

import java.util.Iterator;
import kotlin.io.FileTreeWalk;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class FilteringSequence implements Sequence {
    public final Function1 predicate;
    public final boolean sendWhen;
    public final Sequence sequence;

    public FilteringSequence(Sequence sequence, boolean z, Function1 function1) {
        this.sequence = sequence;
        this.sendWhen = z;
        this.predicate = function1;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        return new FileTreeWalk.FileTreeWalkIterator(this);
    }
}
