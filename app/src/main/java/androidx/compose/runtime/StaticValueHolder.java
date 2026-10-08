package androidx.compose.runtime;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class StaticValueHolder implements ValueHolder {
    public final Object value;

    public StaticValueHolder(Object obj) {
        this.value = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StaticValueHolder) && Intrinsics.areEqual(this.value, ((StaticValueHolder) obj).value);
    }

    public final int hashCode() {
        Object obj = this.value;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    @Override // androidx.compose.runtime.ValueHolder
    public final Object readValue(PersistentCompositionLocalMap persistentCompositionLocalMap) {
        return this.value;
    }

    public final String toString() {
        return "StaticValueHolder(value=" + this.value + ')';
    }
}
