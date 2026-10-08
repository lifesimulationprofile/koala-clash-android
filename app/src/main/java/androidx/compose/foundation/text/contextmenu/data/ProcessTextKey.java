package androidx.compose.foundation.text.contextmenu.data;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ProcessTextKey {
    public final int id;

    public ProcessTextKey(int i) {
        this.id = i;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ProcessTextKey) {
            return this.id == ((ProcessTextKey) obj).id;
        }
        return false;
    }

    public final int hashCode() {
        return this.id;
    }
}
