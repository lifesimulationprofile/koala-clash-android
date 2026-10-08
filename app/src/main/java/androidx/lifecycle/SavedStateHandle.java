package androidx.lifecycle;

import java.util.LinkedHashMap;
import kotlin.collections.EmptyMap;
import kotlin.collections.builders.MapBuilder;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class SavedStateHandle {
    public final Request impl;
    public final LinkedHashMap liveDatas;

    public SavedStateHandle(MapBuilder mapBuilder) {
        this.liveDatas = new LinkedHashMap();
        this.impl = new Request(mapBuilder);
    }

    public SavedStateHandle() {
        this.liveDatas = new LinkedHashMap();
        this.impl = new Request(EmptyMap.INSTANCE);
    }
}
