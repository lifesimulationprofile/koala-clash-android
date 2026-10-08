package androidx.compose.runtime.internal;

import kotlin.text.CharsKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class IntRef {
    public int element = 0;

    public final String toString() {
        StringBuilder sb = new StringBuilder("IntRef(element = ");
        sb.append(this.element);
        sb.append(")@");
        int iHashCode = hashCode();
        CharsKt.checkRadix(16);
        sb.append(Integer.toString(iHashCode, 16));
        return sb.toString();
    }
}
