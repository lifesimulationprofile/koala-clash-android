package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidImageBitmap;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class DrawCache {
    public AndroidCanvas cachedCanvas;
    public AndroidImageBitmap mCachedImage;
    public long size = 0;
    public int config = 0;
    public final CanvasDrawScope cacheScope = new CanvasDrawScope();
}
