package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.ULong;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class RippleConfiguration {
    public final long color = Color.Unspecified;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RippleConfiguration) {
            return Color.m433equalsimpl0(this.color, ((RippleConfiguration) obj).color);
        }
        return false;
    }

    public final int hashCode() {
        int i = Color.$r8$clinit;
        return ULong.m836hashCodeimpl(this.color) * 961;
    }

    public final String toString() {
        return "RippleConfiguration(color=" + ((Object) Color.m439toStringimpl(this.color)) + ", focus=null, rippleAlpha=null)";
    }
}
