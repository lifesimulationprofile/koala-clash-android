package com.github.kr328.clash.core.model;

import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TunPackages$$serializer implements GeneratedSerializer {
    public static final TunPackages$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        TunPackages$$serializer tunPackages$$serializer = new TunPackages$$serializer();
        INSTANCE = tunPackages$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.github.kr328.clash.core.model.TunPackages", tunPackages$$serializer, 2);
        pluginGeneratedSerialDescriptor.addElement("includePackage", true);
        pluginGeneratedSerialDescriptor.addElement("excludePackage", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        KSerializer[] kSerializerArr = TunPackages.$childSerializers;
        return new KSerializer[]{kSerializerArr[0], kSerializerArr[1]};
    }

    @Override // kotlinx.serialization.KSerializer
    public final Object deserialize(Decoder decoder) {
        int i;
        List list;
        List list2;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        KSerializer[] kSerializerArr = TunPackages.$childSerializers;
        List list3 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            list = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, kSerializerArr[0], null);
            list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, kSerializerArr[1], null);
            i = 3;
        } else {
            boolean z = true;
            int i2 = 0;
            List list4 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    list3 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, kSerializerArr[0], list3);
                    i2 |= 1;
                } else {
                    if (iDecodeElementIndex != 1) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    list4 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, kSerializerArr[1], list4);
                    i2 |= 2;
                }
            }
            i = i2;
            list = list3;
            list2 = list4;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new TunPackages(i, list, list2);
    }

    @Override // kotlinx.serialization.KSerializer
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.KSerializer
    public final void serialize(Encoder encoder, Object obj) {
        TunPackages tunPackages = (TunPackages) obj;
        List list = tunPackages.excludePackage;
        List list2 = tunPackages.includePackage;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        KSerializer[] kSerializerArr = TunPackages.$childSerializers;
        boolean zShouldEncodeElementDefault = compositeEncoderBeginStructure.shouldEncodeElementDefault();
        EmptyList emptyList = EmptyList.INSTANCE;
        if (zShouldEncodeElementDefault || !Intrinsics.areEqual(list2, emptyList)) {
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, kSerializerArr[0], list2);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault() || !Intrinsics.areEqual(list, emptyList)) {
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 1, kSerializerArr[1], list);
        }
        compositeEncoderBeginStructure.endStructure();
    }
}
