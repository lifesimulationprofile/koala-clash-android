package androidx.compose.runtime.external.kotlinx.collections.immutable.internal;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class DeltaCounter {
    public int count;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DeltaCounter) && this.count == ((DeltaCounter) obj).count;
    }

    public final int hashCode() {
        return this.count;
    }

    public final String toString() {
        return ImageAnalysis$$ExternalSyntheticLambda1.m(new StringBuilder("DeltaCounter(count="), this.count, ')');
    }
}
