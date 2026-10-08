package com.github.kr328.clash.core.model;

import com.github.kr328.clash.core.util.DateSerializer;
import java.util.Date;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LogMessage$$serializer implements GeneratedSerializer {
    public static final LogMessage$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        LogMessage$$serializer logMessage$$serializer = new LogMessage$$serializer();
        INSTANCE = logMessage$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.github.kr328.clash.core.model.LogMessage", logMessage$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("level", false);
        pluginGeneratedSerialDescriptor.addElement("message", false);
        pluginGeneratedSerialDescriptor.addElement("time", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{LogMessage$Level$$serializer.INSTANCE, StringSerializer.INSTANCE, DateSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.KSerializer
    public final Object deserialize(Decoder decoder) {
        int i;
        LogMessage.Level level;
        String strDecodeStringElement;
        Date date;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        boolean zDecodeSequentially = compositeDecoderBeginStructure.decodeSequentially();
        DateSerializer dateSerializer = DateSerializer.INSTANCE;
        LogMessage.Level level2 = null;
        if (zDecodeSequentially) {
            level = (LogMessage.Level) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, LogMessage$Level$$serializer.INSTANCE, null);
            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
            date = (Date) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, dateSerializer, null);
            i = 7;
        } else {
            boolean z = true;
            int i2 = 0;
            String strDecodeStringElement2 = null;
            Date date2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    level2 = (LogMessage.Level) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, LogMessage$Level$$serializer.INSTANCE, level2);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
                    i2 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    date2 = (Date) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, dateSerializer, date2);
                    i2 |= 4;
                }
            }
            i = i2;
            level = level2;
            strDecodeStringElement = strDecodeStringElement2;
            date = date2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new LogMessage(i, level, strDecodeStringElement, date);
    }

    @Override // kotlinx.serialization.KSerializer
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.KSerializer
    public final void serialize(Encoder encoder, Object obj) {
        LogMessage logMessage = (LogMessage) obj;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, LogMessage$Level$$serializer.INSTANCE, logMessage.level);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 1, logMessage.message);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 2, DateSerializer.INSTANCE, logMessage.time);
        compositeEncoderBeginStructure.endStructure();
    }
}
