package androidx.compose.runtime;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ComputedValueHolder implements ValueHolder {
    public final Function1 compute;

    public ComputedValueHolder(Function1 function1) {
        this.compute = function1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ComputedValueHolder) && Intrinsics.areEqual(this.compute, ((ComputedValueHolder) obj).compute);
    }

    public final int hashCode() {
        return this.compute.hashCode();
    }

    @Override // androidx.compose.runtime.ValueHolder
    public final Object readValue(PersistentCompositionLocalMap persistentCompositionLocalMap) {
        return this.compute.invoke(persistentCompositionLocalMap);
    }

    public final String toString() {
        return "ComputedValueHolder(compute=" + this.compute + ')';
    }
}
