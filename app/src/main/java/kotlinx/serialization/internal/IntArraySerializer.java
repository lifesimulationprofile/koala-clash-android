package kotlinx.serialization.internal;

import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class IntArraySerializer extends PrimitiveArraySerializer {
    public static final IntArraySerializer INSTANCE = new IntArraySerializer(IntSerializer.INSTANCE);

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final int collectionSize(Object obj) {
        return ((int[]) obj).length;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final Object empty() {
        return new int[0];
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.internal.AbstractCollectionSerializer
    public final void readElement(CompositeDecoder compositeDecoder, int i, Object obj) {
        IntArrayBuilder intArrayBuilder = (IntArrayBuilder) obj;
        int iDecodeIntElement = compositeDecoder.decodeIntElement(this.descriptor, i);
        intArrayBuilder.ensureCapacity$kotlinx_serialization_core(intArrayBuilder.getPosition$kotlinx_serialization_core() + 1);
        int[] iArr = intArrayBuilder.buffer;
        int i2 = intArrayBuilder.position;
        intArrayBuilder.position = i2 + 1;
        iArr[i2] = iDecodeIntElement;
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Object toBuilder(Object obj) {
        int[] iArr = (int[]) obj;
        IntArrayBuilder intArrayBuilder = new IntArrayBuilder();
        intArrayBuilder.buffer = iArr;
        intArrayBuilder.position = iArr.length;
        intArrayBuilder.ensureCapacity$kotlinx_serialization_core(10);
        return intArrayBuilder;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final void writeContent(CompositeEncoder compositeEncoder, Object obj, int i) {
        int[] iArr = (int[]) obj;
        for (int i2 = 0; i2 < i; i2++) {
            compositeEncoder.encodeIntElement(i2, iArr[i2], this.descriptor);
        }
    }
}
