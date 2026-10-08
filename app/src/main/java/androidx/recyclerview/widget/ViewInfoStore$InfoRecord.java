package androidx.recyclerview.widget;

import androidx.core.util.Pools$SimplePool;
import androidx.navigation.NavOptions;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewInfoStore$InfoRecord {
    public static final Pools$SimplePool sPool = new Pools$SimplePool(20);
    public int flags;
    public NavOptions.Builder postInfo;
    public NavOptions.Builder preInfo;

    public static ViewInfoStore$InfoRecord obtain() {
        ViewInfoStore$InfoRecord viewInfoStore$InfoRecord = (ViewInfoStore$InfoRecord) sPool.acquire();
        return viewInfoStore$InfoRecord == null ? new ViewInfoStore$InfoRecord() : viewInfoStore$InfoRecord;
    }
}
