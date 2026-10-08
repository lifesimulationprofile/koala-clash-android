package kotlinx.serialization.internal;

import kotlin.UByte;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class UByteSerializer implements KSerializer {
    public static final UByteSerializer INSTANCE = new UByteSerializer();
    public static final InlineClassDescriptor descriptor = Platform_commonKt.InlinePrimitiveDescriptor("kotlin.UByte", ByteSerializer.INSTANCE);

    @Override // kotlinx.serialization.KSerializer
    public final Object deserialize(Decoder decoder) {
        return new UByte(decoder.decodeInline(descriptor).decodeByte());
    }

    @Override // kotlinx.serialization.KSerializer
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.KSerializer
    public final void serialize(Encoder encoder, Object obj) {
        encoder.encodeInline(descriptor).encodeByte(((UByte) obj).data);
    }
}
