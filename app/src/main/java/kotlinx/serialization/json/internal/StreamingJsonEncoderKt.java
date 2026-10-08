package kotlinx.serialization.json.internal;

import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.UByteSerializer;
import kotlinx.serialization.internal.UIntSerializer;
import kotlinx.serialization.internal.ULongSerializer;
import kotlinx.serialization.internal.UShortSerializer;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class StreamingJsonEncoderKt {
    public static final Set unsignedNumberDescriptors = ArraysKt.toSet(new SerialDescriptor[]{UIntSerializer.descriptor, ULongSerializer.descriptor, UByteSerializer.descriptor, UShortSerializer.descriptor});

    public static final boolean isUnsignedNumber(SerialDescriptor serialDescriptor) {
        return serialDescriptor.isInline() && unsignedNumberDescriptors.contains(serialDescriptor);
    }
}
