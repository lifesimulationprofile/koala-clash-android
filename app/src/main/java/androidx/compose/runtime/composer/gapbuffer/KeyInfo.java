package androidx.compose.runtime.composer.gapbuffer;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class KeyInfo {
    public final int key;
    public final int location;
    public final int nodes;
    public final Object objectKey;

    public KeyInfo(Object obj, int i, int i2, int i3) {
        this.key = i;
        this.objectKey = obj;
        this.location = i2;
        this.nodes = i3;
    }
}
