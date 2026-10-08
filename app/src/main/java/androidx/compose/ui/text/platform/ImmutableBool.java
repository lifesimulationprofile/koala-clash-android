package androidx.compose.ui.text.platform;

import androidx.compose.runtime.State;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ImmutableBool implements State {
    public final boolean value;

    public ImmutableBool(boolean z) {
        this.value = z;
    }

    @Override // androidx.compose.runtime.State
    public final Object getValue() {
        return Boolean.valueOf(this.value);
    }
}
