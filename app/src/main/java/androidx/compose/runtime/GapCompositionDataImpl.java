package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class GapCompositionDataImpl implements CompositionData {
    public final Composition composition;

    public GapCompositionDataImpl(Composition composition) {
        this.composition = composition;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof GapCompositionDataImpl) {
            return Intrinsics.areEqual(this.composition, ((GapCompositionDataImpl) obj).composition);
        }
        return false;
    }

    public final int hashCode() {
        return this.composition.hashCode() * 31;
    }
}
