package kotlinx.serialization.json;

import androidx.room.RoomOpenHelper;
import coil.memory.RealWeakMemoryCache;
import java.util.List;
import kotlin.collections.ArrayDeque;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.json.internal.CharArrayPool;
import kotlinx.serialization.json.internal.Composer;
import kotlinx.serialization.json.internal.StreamingJsonDecoder;
import kotlinx.serialization.json.internal.StreamingJsonEncoder;
import kotlinx.serialization.json.internal.WriteMode;
import kotlinx.serialization.modules.SerializersModuleKt;
import okhttp3.ConnectionPool;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Json {
    public static final Default Default = new Default(new JsonConfiguration(false, true, "    ", "type", true, 3), SerializersModuleKt.EmptySerializersModule);
    public final ConnectionPool _schemaCache = new ConnectionPool(20);
    public final JsonConfiguration configuration;
    public final Request serializersModule;

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Default extends Json {
    }

    public Json(JsonConfiguration jsonConfiguration, Request request) {
        this.configuration = jsonConfiguration;
        this.serializersModule = request;
    }

    public final Object decodeFromString(String str, KSerializer kSerializer) {
        RoomOpenHelper roomOpenHelper = new RoomOpenHelper(str);
        Object objDecodeSerializableValue = new StreamingJsonDecoder(this, WriteMode.OBJ, roomOpenHelper, kSerializer.getDescriptor(), null).decodeSerializableValue(kSerializer);
        if (roomOpenHelper.consumeNextToken() == 10) {
            return objDecodeSerializableValue;
        }
        RoomOpenHelper.fail$default(roomOpenHelper, "Expected EOF after parsing, but had " + str.charAt(roomOpenHelper.version - 1) + " instead", 0, null, 6);
        throw null;
    }

    public final String encodeToString(ArrayListSerializer arrayListSerializer, List list) {
        char[] cArr;
        RealWeakMemoryCache realWeakMemoryCache = new RealWeakMemoryCache(12, false);
        CharArrayPool charArrayPool = CharArrayPool.INSTANCE;
        synchronized (charArrayPool) {
            ArrayDeque arrayDeque = (ArrayDeque) charArrayPool.arrays;
            cArr = null;
            char[] cArr2 = (char[]) (arrayDeque.isEmpty() ? null : arrayDeque.removeLast());
            if (cArr2 != null) {
                charArrayPool.charsTotal -= cArr2.length;
                cArr = cArr2;
            }
        }
        if (cArr == null) {
            cArr = new char[128];
        }
        realWeakMemoryCache.cache = cArr;
        try {
            new StreamingJsonEncoder(new Composer(realWeakMemoryCache), this, WriteMode.OBJ, new StreamingJsonEncoder[WriteMode.$ENTRIES.getSize()]).encodeSerializableValue(arrayListSerializer, list);
            return realWeakMemoryCache.toString();
        } finally {
            realWeakMemoryCache.release();
        }
    }
}
