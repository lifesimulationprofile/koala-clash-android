package androidx.compose.runtime;

import kotlin.SynchronizedLazyImpl;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class LazyValueHolder implements ValueHolder {
    public final SynchronizedLazyImpl current$delegate;

    public LazyValueHolder(Function0 function0) {
        this.current$delegate = new SynchronizedLazyImpl(function0);
    }

    @Override // androidx.compose.runtime.ValueHolder
    public final Object readValue(PersistentCompositionLocalMap persistentCompositionLocalMap) {
        return this.current$delegate.getValue();
    }
}
