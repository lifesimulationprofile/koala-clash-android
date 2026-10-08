package kotlin.collections;

import androidx.camera.core.impl.utils.MatrixExt;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class CollectionsKt__IterablesKt extends MatrixExt {
    public static int collectionSizeOrDefault(Iterable iterable, int i) {
        return iterable instanceof Collection ? ((Collection) iterable).size() : i;
    }
}
