package kotlinx.serialization.json;

import androidx.compose.material.icons.filled.DomainKt;
import androidx.compose.material.icons.filled.HomeKt;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorImpl;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.internal.WriteModeKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class JsonPrimitiveSerializer implements KSerializer {
    public static final JsonPrimitiveSerializer INSTANCE = new JsonPrimitiveSerializer();
    public static final SerialDescriptorImpl descriptor = DomainKt.buildSerialDescriptor$default("kotlinx.serialization.json.JsonPrimitive", PrimitiveKind.INT.INSTANCE$8, new SerialDescriptor[0]);

    @Override // kotlinx.serialization.KSerializer
    public final Object deserialize(Decoder decoder) {
        JsonElement jsonElementDecodeJsonElement = HomeKt.asJsonDecoder(decoder).decodeJsonElement();
        if (jsonElementDecodeJsonElement instanceof JsonPrimitive) {
            return (JsonPrimitive) jsonElementDecodeJsonElement;
        }
        throw WriteModeKt.JsonDecodingException(-1, jsonElementDecodeJsonElement.toString(), "Unexpected JSON element, expected JsonPrimitive, had " + Reflection.getOrCreateKotlinClass(jsonElementDecodeJsonElement.getClass()));
    }

    @Override // kotlinx.serialization.KSerializer
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.KSerializer
    public final void serialize(Encoder encoder, Object obj) {
        JsonPrimitive jsonPrimitive = (JsonPrimitive) obj;
        HomeKt.access$verify(encoder);
        if (jsonPrimitive instanceof JsonNull) {
            encoder.encodeSerializableValue(JsonNullSerializer.INSTANCE, JsonNull.INSTANCE);
        } else {
            encoder.encodeSerializableValue(JsonLiteralSerializer.INSTANCE, (JsonLiteral) jsonPrimitive);
        }
    }
}
