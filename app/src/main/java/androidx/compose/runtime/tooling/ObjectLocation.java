package androidx.compose.runtime.tooling;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ObjectLocation {
    public final Integer dataOffset;
    public final int group;

    public ObjectLocation(int i, Integer num) {
        this.group = i;
        this.dataOffset = num;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ObjectLocation)) {
            return false;
        }
        ObjectLocation objectLocation = (ObjectLocation) obj;
        return this.group == objectLocation.group && Intrinsics.areEqual(this.dataOffset, objectLocation.dataOffset);
    }

    public final int hashCode() {
        int i = this.group * 31;
        Integer num = this.dataOffset;
        return i + (num == null ? 0 : num.hashCode());
    }

    public final String toString() {
        return "ObjectLocation(group=" + this.group + ", dataOffset=" + this.dataOffset + ')';
    }
}
