package androidx.compose.runtime.composer.gapbuffer;

import androidx.compose.runtime.ComposerKt;
import coil.network.HttpException;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class GapAnchorKt {
    public static final GapAnchor asGapAnchor(GapAnchor gapAnchor) {
        if (!(gapAnchor instanceof GapAnchor)) {
            gapAnchor = null;
        }
        if (gapAnchor != null) {
            return gapAnchor;
        }
        ComposerKt.composeRuntimeError("Inconsistent composition");
        throw new HttpException();
    }
}
