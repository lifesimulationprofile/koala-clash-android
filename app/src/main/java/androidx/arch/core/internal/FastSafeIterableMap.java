package androidx.arch.core.internal;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class FastSafeIterableMap extends SafeIterableMap {
    public final HashMap mHashMap = new HashMap();

    @Override // androidx.arch.core.internal.SafeIterableMap
    public final SafeIterableMap.Entry get(Object obj) {
        return (SafeIterableMap.Entry) this.mHashMap.get(obj);
    }

    @Override // androidx.arch.core.internal.SafeIterableMap
    public final Object remove(Object obj) {
        Object objRemove = super.remove(obj);
        this.mHashMap.remove(obj);
        return objRemove;
    }
}
