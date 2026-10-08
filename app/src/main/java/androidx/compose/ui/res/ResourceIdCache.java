package androidx.compose.ui.res;

import androidx.collection.MutableIntObjectMap;
import kotlin.Unit;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ResourceIdCache {
    public final MutableIntObjectMap resIdPathMap = new MutableIntObjectMap();

    public final void clear() {
        synchronized (this) {
            this.resIdPathMap.clear();
            Unit unit = Unit.INSTANCE;
        }
    }
}
