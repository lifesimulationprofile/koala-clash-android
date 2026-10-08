package androidx.compose.ui.graphics;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.RoundRectKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class Outline$Rounded extends BrushKt {
    public final RoundRect roundRect;
    public final AndroidPath roundRectPath;

    public Outline$Rounded(RoundRect roundRect) {
        AndroidPath androidPathPath;
        this.roundRect = roundRect;
        if (RoundRectKt.isSimple(roundRect)) {
            androidPathPath = null;
        } else {
            androidPathPath = AndroidPath_androidKt.Path();
            Modifier.CC.addRoundRect$default(androidPathPath, roundRect);
        }
        this.roundRectPath = androidPathPath;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Outline$Rounded) {
            return Intrinsics.areEqual(this.roundRect, ((Outline$Rounded) obj).roundRect);
        }
        return false;
    }

    @Override // androidx.compose.ui.graphics.BrushKt
    public final Rect getBounds() {
        RoundRect roundRect = this.roundRect;
        return new Rect(roundRect.left, roundRect.top, roundRect.right, roundRect.bottom);
    }

    public final int hashCode() {
        return this.roundRect.hashCode();
    }
}
