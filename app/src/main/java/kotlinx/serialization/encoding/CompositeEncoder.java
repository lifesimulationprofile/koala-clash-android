package kotlinx.serialization.encoding;

import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.PrimitiveArrayDescriptor;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface CompositeEncoder {
    void encodeBooleanElement(SerialDescriptor serialDescriptor, int i, boolean z);

    void encodeByteElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i, byte b);

    void encodeCharElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i, char c);

    void encodeDoubleElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i, double d);

    void encodeFloatElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i, float f);

    Encoder encodeInlineElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i);

    void encodeIntElement(int i, int i2, SerialDescriptor serialDescriptor);

    void encodeLongElement(SerialDescriptor serialDescriptor, int i, long j);

    void encodeNullableSerializableElement(SerialDescriptor serialDescriptor, int i, Object obj);

    void encodeSerializableElement(SerialDescriptor serialDescriptor, int i, KSerializer kSerializer, Object obj);

    void encodeShortElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i, short s);

    void encodeStringElement(SerialDescriptor serialDescriptor, int i, String str);

    void endStructure();

    boolean shouldEncodeElementDefault();
}
