package androidx.lifecycle;

import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewModelStore {
    public final LinkedHashMap map = new LinkedHashMap();

    public final void clear() {
        LinkedHashMap linkedHashMap = this.map;
        Iterator it = linkedHashMap.values().iterator();
        while (it.hasNext()) {
            ((ViewModel) it.next()).clear$lifecycle_viewmodel_release();
        }
        linkedHashMap.clear();
    }
}
