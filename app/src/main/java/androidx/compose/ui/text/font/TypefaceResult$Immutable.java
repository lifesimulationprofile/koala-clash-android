package androidx.compose.ui.text.font;

import android.graphics.Typeface;
import androidx.compose.runtime.State;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class TypefaceResult$Immutable implements State {
    public final boolean cacheable = true;
    public final Object value;

    public TypefaceResult$Immutable(Typeface typeface) {
        this.value = typeface;
    }

    @Override // androidx.compose.runtime.State
    public final Object getValue() {
        return this.value;
    }
}
