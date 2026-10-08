package kotlinx.serialization.json;

import androidx.room.RoomOpenHelper;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.internal.InlineClassDescriptor;
import kotlinx.serialization.internal.Platform_commonKt;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.internal.JsonDecodingException;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class JsonElementKt {
    public static final InlineClassDescriptor jsonUnquotedLiteralDescriptor = Platform_commonKt.InlinePrimitiveDescriptor("kotlinx.serialization.json.JsonUnquotedLiteral", StringSerializer.INSTANCE);

    public static final int getInt(JsonPrimitive jsonPrimitive) {
        try {
            long jConsumeNumericLiteral = new RoomOpenHelper(jsonPrimitive.getContent()).consumeNumericLiteral();
            if (-2147483648L <= jConsumeNumericLiteral && jConsumeNumericLiteral <= 2147483647L) {
                return (int) jConsumeNumericLiteral;
            }
            throw new NumberFormatException(jsonPrimitive.getContent() + " is not an Int");
        } catch (JsonDecodingException e) {
            throw new NumberFormatException(e.getMessage());
        }
    }

    public static final JsonPrimitive getJsonPrimitive(JsonElement jsonElement) {
        JsonPrimitive jsonPrimitive = jsonElement instanceof JsonPrimitive ? (JsonPrimitive) jsonElement : null;
        if (jsonPrimitive != null) {
            return jsonPrimitive;
        }
        throw new IllegalArgumentException("Element " + Reflection.getOrCreateKotlinClass(jsonElement.getClass()) + " is not a JsonPrimitive");
    }
}
