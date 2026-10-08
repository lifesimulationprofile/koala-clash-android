package kotlinx.serialization.encoding;

import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.PrimitiveArrayDescriptor;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface CompositeDecoder {
    boolean decodeBooleanElement(SerialDescriptor serialDescriptor, int i);

    byte decodeByteElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i);

    char decodeCharElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i);

    int decodeCollectionSize();

    double decodeDoubleElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i);

    int decodeElementIndex(SerialDescriptor serialDescriptor);

    float decodeFloatElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i);

    Decoder decodeInlineElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i);

    int decodeIntElement(SerialDescriptor serialDescriptor, int i);

    long decodeLongElement(SerialDescriptor serialDescriptor, int i);

    Object decodeNullableSerializableElement(SerialDescriptor serialDescriptor, int i, String str);

    boolean decodeSequentially();

    Object decodeSerializableElement(SerialDescriptor serialDescriptor, int i, KSerializer kSerializer, Object obj);

    short decodeShortElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i);

    String decodeStringElement(SerialDescriptor serialDescriptor, int i);

    void endStructure(SerialDescriptor serialDescriptor);

    Request getSerializersModule();
}
