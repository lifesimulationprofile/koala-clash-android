package coil.request;

import java.util.Map;
import kotlin.collections.EmptyMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class Tags {
    public static final Tags EMPTY = new Tags(EmptyMap.INSTANCE);
    public final Map tags;

    public Tags(Map map) {
        this.tags = map;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Tags) {
            return Intrinsics.areEqual(this.tags, ((Tags) obj).tags);
        }
        return false;
    }

    public final int hashCode() {
        return this.tags.hashCode();
    }

    public final String toString() {
        return "Tags(tags=" + this.tags + ')';
    }
}
