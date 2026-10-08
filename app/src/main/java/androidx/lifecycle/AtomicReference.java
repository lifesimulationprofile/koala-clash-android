package androidx.lifecycle;

import androidx.lifecycle.viewmodel.CreationExtras;
import okhttp3.Request;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AtomicReference {
    public static final Path.Companion VIEW_MODEL_KEY = new Path.Companion(12);
    public final Object base;

    public AtomicReference() {
        this.base = new java.util.concurrent.atomic.AtomicReference(null);
    }

    public AtomicReference(ViewModelStore viewModelStore, ViewModelProvider$Factory viewModelProvider$Factory, CreationExtras creationExtras) {
        this.base = new Request.Builder(viewModelStore, viewModelProvider$Factory, creationExtras);
    }

    public AtomicReference(ProcessLifecycleOwner processLifecycleOwner) {
        this.base = processLifecycleOwner;
    }
}
