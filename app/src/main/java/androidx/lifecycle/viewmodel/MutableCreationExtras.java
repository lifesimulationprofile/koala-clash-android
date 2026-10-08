package androidx.lifecycle.viewmodel;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class MutableCreationExtras extends CreationExtras {
    public MutableCreationExtras(CreationExtras creationExtras) {
        this.extras.putAll(creationExtras.extras);
    }

    public final void set(CreationExtras.Key key, Object obj) {
        this.extras.put(key, obj);
    }

    public /* synthetic */ MutableCreationExtras(int i) {
        this(CreationExtras.Empty.INSTANCE);
    }
}
