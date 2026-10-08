package kotlin.collections;

import coil.decode.SvgDecoder$$ExternalSyntheticLambda0;
import java.util.Iterator;
import kotlin.UIntArray;
import kotlin.io.FileTreeWalk;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.text.DelimitedRangesSequence$iterator$1;
import kotlinx.serialization.internal.EnumDescriptor;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class IndexingIterable implements Iterable, KMappedMarker {
    public final /* synthetic */ int $r8$classId;
    public final Object iteratorFactory;

    public /* synthetic */ IndexingIterable(int i, Object obj) {
        this.$r8$classId = i;
        this.iteratorFactory = obj;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        switch (this.$r8$classId) {
            case 0:
                return new IndexingIterator((Iterator) ((SvgDecoder$$ExternalSyntheticLambda0) this.iteratorFactory).invoke());
            case 1:
                return new DelimitedRangesSequence$iterator$1((FileTreeWalk) this.iteratorFactory);
            default:
                return new UIntArray.Iterator((EnumDescriptor) this.iteratorFactory);
        }
    }
}
