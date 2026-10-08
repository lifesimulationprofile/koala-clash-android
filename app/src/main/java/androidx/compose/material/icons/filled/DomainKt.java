package androidx.compose.material.icons.filled;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.emoji2.text.flatbuffer.Table;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.builders.MapBuilder;
import kotlin.collections.builders.MapBuilderValues;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorImpl;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.internal.PrimitiveSerialDescriptor;
import kotlinx.serialization.internal.PrimitivesKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class DomainKt {
    public static ImageVector _domain;

    public static final PrimitiveSerialDescriptor PrimitiveSerialDescriptor(String str, PrimitiveKind primitiveKind) {
        if (StringsKt.isBlank(str)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        Object it = ((MapBuilderValues) PrimitivesKt.BUILTIN_SERIALIZERS.values()).iterator();
        while (((Table) it).hasNext()) {
            KSerializer kSerializer = (KSerializer) ((MapBuilder.KeysItr) it).next();
            if (str.equals(kSerializer.getDescriptor().getSerialName())) {
                StringBuilder sbM13m = ImageAnalysis$$ExternalSyntheticLambda1.m13m("\n                The name of serial descriptor should uniquely identify associated serializer.\n                For serial name ", str, " there already exists ");
                sbM13m.append(Reflection.getOrCreateKotlinClass(kSerializer.getClass()).getSimpleName());
                sbM13m.append(".\n                Please refer to SerialDescriptor documentation for additional information.\n            ");
                throw new IllegalArgumentException(StringsKt__IndentKt.trimIndent(sbM13m.toString()));
            }
        }
        return new PrimitiveSerialDescriptor(str, primitiveKind);
    }

    public static SerialDescriptorImpl buildSerialDescriptor$default(String str, SerialKind serialKind, SerialDescriptor[] serialDescriptorArr) {
        if (StringsKt.isBlank(str)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        if (serialKind.equals(StructureKind.MAP.INSTANCE$1)) {
            throw new IllegalArgumentException("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead");
        }
        ClassSerialDescriptorBuilder classSerialDescriptorBuilder = new ClassSerialDescriptorBuilder(str);
        Unit unit = Unit.INSTANCE;
        return new SerialDescriptorImpl(str, serialKind, classSerialDescriptorBuilder.elementNames.size(), ArraysKt.toList(serialDescriptorArr), classSerialDescriptorBuilder);
    }
}
