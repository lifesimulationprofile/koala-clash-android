package kotlinx.coroutines;

import androidx.compose.ui.Modifier;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class Empty implements Incomplete {
    public final boolean isActive;

    public Empty(boolean z) {
        this.isActive = z;
    }

    @Override // kotlinx.coroutines.Incomplete
    public final NodeList getList() {
        return null;
    }

    @Override // kotlinx.coroutines.Incomplete
    public final boolean isActive() {
        return this.isActive;
    }

    public final String toString() {
        return Modifier.CC.m(new StringBuilder("Empty{"), this.isActive ? "Active" : "New", '}');
    }
}
