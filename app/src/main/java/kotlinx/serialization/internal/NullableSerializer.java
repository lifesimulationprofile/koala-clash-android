package kotlinx.serialization.internal;

import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class NullableSerializer implements KSerializer {
    public final SerialDescriptorForNullable descriptor;

    public NullableSerializer() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        this.descriptor = new SerialDescriptorForNullable(StringSerializer.descriptor);
    }

    @Override // kotlinx.serialization.KSerializer
    public final Object deserialize(Decoder decoder) {
        if (decoder.decodeNotNullMark()) {
            return decoder.decodeSerializableValue(StringSerializer.INSTANCE);
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || NullableSerializer.class != obj.getClass()) {
            return false;
        }
        Object obj2 = StringSerializer.INSTANCE;
        return obj2.equals(obj2);
    }

    @Override // kotlinx.serialization.KSerializer
    public final SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    public final int hashCode() {
        return StringSerializer.INSTANCE.hashCode();
    }

    @Override // kotlinx.serialization.KSerializer
    public final void serialize(Encoder encoder, Object obj) {
        if (obj == null) {
            encoder.encodeNull();
        } else {
            encoder.encodeNotNullMark();
            encoder.encodeSerializableValue(StringSerializer.INSTANCE, obj);
        }
    }
}
