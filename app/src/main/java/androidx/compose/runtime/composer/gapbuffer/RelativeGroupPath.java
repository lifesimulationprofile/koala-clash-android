package androidx.compose.runtime.composer.gapbuffer;

import com.google.android.gms.internal.mlkit_vision_barcode.zzsl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class RelativeGroupPath extends zzsl {
    public final int index;
    public final zzsl parent;

    public RelativeGroupPath(zzsl zzslVar, int i) {
        this.parent = zzslVar;
        this.index = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof RelativeGroupPath)) {
            return false;
        }
        RelativeGroupPath relativeGroupPath = (RelativeGroupPath) obj;
        return Intrinsics.areEqual(relativeGroupPath.parent, this.parent) && relativeGroupPath.index == this.index;
    }

    public final int hashCode() {
        return this.parent.hashCode() + (this.index * 31);
    }
}
