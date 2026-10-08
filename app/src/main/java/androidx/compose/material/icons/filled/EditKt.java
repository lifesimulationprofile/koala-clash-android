package androidx.compose.material.icons.filled;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorKt;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.internal.PrimitiveArrayDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import okhttp3.Headers;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class EditKt implements Decoder, CompositeDecoder {
    public static ImageVector _edit;

    public static final ImageVector getEdit() {
        ImageVector imageVector = _edit;
        if (imageVector != null) {
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Filled.Edit", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
        int i = VectorKt.$r8$clinit;
        SolidColor solidColor = new SolidColor(Color.Black);
        Headers.Builder builder2 = new Headers.Builder(2);
        builder2.moveTo(3.0f, 17.25f);
        builder2.verticalLineTo(21.0f);
        builder2.horizontalLineToRelative(3.75f);
        builder2.lineTo(17.81f, 9.94f);
        builder2.lineToRelative(-3.75f, -3.75f);
        builder2.lineTo(3.0f, 17.25f);
        builder2.close();
        builder2.moveTo(20.71f, 7.04f);
        builder2.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0.0f, -1.41f);
        builder2.lineToRelative(-2.34f, -2.34f);
        builder2.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0.0f);
        builder2.lineToRelative(-1.83f, 1.83f);
        builder2.lineToRelative(3.75f, 3.75f);
        builder2.lineToRelative(1.83f, -1.83f);
        builder2.close();
        ImageVector.Builder.m500addPathoIyEayM$default(builder, builder2.namesAndValues, solidColor);
        ImageVector imageVectorBuild = builder.build();
        _edit = imageVectorBuild;
        return imageVectorBuild;
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public boolean decodeBoolean() {
        decodeValue();
        throw null;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public boolean decodeBooleanElement(SerialDescriptor serialDescriptor, int i) {
        return decodeBoolean();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public abstract byte decodeByte();

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public byte decodeByteElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i) {
        return decodeByte();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public char decodeChar() {
        decodeValue();
        throw null;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public char decodeCharElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i) {
        return decodeChar();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public int decodeCollectionSize() {
        return -1;
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public double decodeDouble() {
        decodeValue();
        throw null;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public double decodeDoubleElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i) {
        return decodeDouble();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public int decodeEnum(SerialDescriptor serialDescriptor) {
        decodeValue();
        throw null;
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public float decodeFloat() {
        decodeValue();
        throw null;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public float decodeFloatElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i) {
        return decodeFloat();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public Decoder decodeInlineElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i) {
        return decodeInline(primitiveArrayDescriptor.getElementDescriptor(i));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public abstract int decodeInt();

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public int decodeIntElement(SerialDescriptor serialDescriptor, int i) {
        return decodeInt();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public abstract long decodeLong();

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public long decodeLongElement(SerialDescriptor serialDescriptor, int i) {
        return decodeLong();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public boolean decodeNotNullMark() {
        return true;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public Object decodeNullableSerializableElement(SerialDescriptor serialDescriptor, int i, String str) {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        StringSerializer stringSerializer2 = StringSerializer.INSTANCE;
        if (decodeNotNullMark()) {
            return decodeSerializableValue(stringSerializer);
        }
        return null;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public boolean decodeSequentially() {
        return false;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public Object decodeSerializableElement(SerialDescriptor serialDescriptor, int i, KSerializer kSerializer, Object obj) {
        return decodeSerializableValue(kSerializer);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public Object decodeSerializableValue(KSerializer kSerializer) {
        return kSerializer.deserialize(this);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public abstract short decodeShort();

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public short decodeShortElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i) {
        return decodeShort();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public String decodeString() {
        decodeValue();
        throw null;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public String decodeStringElement(SerialDescriptor serialDescriptor, int i) {
        return decodeString();
    }

    public void decodeValue() {
        throw new SerializationException(Reflection.getOrCreateKotlinClass(getClass()) + " can't retrieve untyped values");
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public CompositeDecoder beginStructure(SerialDescriptor serialDescriptor) {
        return this;
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public Decoder decodeInline(SerialDescriptor serialDescriptor) {
        return this;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public void endStructure(SerialDescriptor serialDescriptor) {
    }
}
