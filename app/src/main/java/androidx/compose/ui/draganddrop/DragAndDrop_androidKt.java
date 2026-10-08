package androidx.compose.ui.draganddrop;

import android.view.DragEvent;
import coil.memory.EmptyStrongMemoryCache;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class DragAndDrop_androidKt {
    public static final long getPositionInRoot(EmptyStrongMemoryCache emptyStrongMemoryCache) {
        DragEvent dragEvent = (DragEvent) emptyStrongMemoryCache.weakMemoryCache;
        float x = dragEvent.getX();
        float y = dragEvent.getY();
        return (((long) Float.floatToRawIntBits(x)) << 32) | (((long) Float.floatToRawIntBits(y)) & 4294967295L);
    }
}
