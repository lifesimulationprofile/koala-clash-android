package kotlinx.serialization.json;

import kotlinx.serialization.KSerializer;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class JsonNull extends JsonPrimitive {
    public static final JsonNull INSTANCE = new JsonNull();

    @Override // kotlinx.serialization.json.JsonPrimitive
    public final String getContent() {
        return "null";
    }

    @Override // kotlinx.serialization.json.JsonPrimitive
    public final boolean isString() {
        return false;
    }

    public final KSerializer serializer() {
        return JsonNullSerializer.INSTANCE;
    }
}
