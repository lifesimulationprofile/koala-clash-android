package kotlinx.serialization.json;

import androidx.compose.material.icons.filled.DomainKt;
import androidx.compose.material.icons.filled.HomeKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorImpl;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.internal.JsonDecodingException;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class JsonNullSerializer implements KSerializer {
    public static final JsonNullSerializer INSTANCE = new JsonNullSerializer();
    public static final SerialDescriptorImpl descriptor = DomainKt.buildSerialDescriptor$default("kotlinx.serialization.json.JsonNull", SerialKind.ENUM.INSTANCE, new SerialDescriptor[0]);

    @Override // kotlinx.serialization.KSerializer
    public final Object deserialize(Decoder decoder) {
        HomeKt.asJsonDecoder(decoder);
        if (decoder.decodeNotNullMark()) {
            throw new JsonDecodingException("Expected 'null' literal");
        }
        return JsonNull.INSTANCE;
    }

    @Override // kotlinx.serialization.KSerializer
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.KSerializer
    public final void serialize(Encoder encoder, Object obj) {
        HomeKt.access$verify(encoder);
        encoder.encodeNull();
    }
}
