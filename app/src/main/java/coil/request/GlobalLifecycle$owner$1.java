package coil.request;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class GlobalLifecycle$owner$1 implements LifecycleOwner {
    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return GlobalLifecycle.INSTANCE;
    }
}
