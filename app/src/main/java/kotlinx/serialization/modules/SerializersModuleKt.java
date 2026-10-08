package kotlinx.serialization.modules;

import kotlin.collections.EmptyMap;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SerializersModuleKt {
    public static final Request EmptySerializersModule;

    static {
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        EmptySerializersModule = new Request(emptyMap, emptyMap, emptyMap, emptyMap, emptyMap, 16);
    }
}
