package coil.memory;

import android.graphics.Bitmap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface StrongMemoryCache {
    MemoryCache$Value get(MemoryCache$Key memoryCache$Key);

    void set(MemoryCache$Key memoryCache$Key, Bitmap bitmap, Map map);

    void trimMemory(int i);
}
