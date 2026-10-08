package androidx.compose.runtime.composer.gapbuffer;

import com.google.android.gms.internal.mlkit_vision_barcode.zzsl;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AnchoredGroupPath extends zzsl {
    public final int group;

    public AnchoredGroupPath(int i) {
        this.group = i;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof AnchoredGroupPath) && ((AnchoredGroupPath) obj).group == this.group;
    }

    public final int hashCode() {
        return this.group * 31;
    }
}
