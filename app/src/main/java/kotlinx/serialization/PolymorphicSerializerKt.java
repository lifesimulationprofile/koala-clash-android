package kotlinx.serialization;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorKt;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.internal.Platform_commonKt;
import okhttp3.Headers;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class PolymorphicSerializerKt {
    public static ImageVector _delete;

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.Object, java.util.Map] */
    public static final KSerializer findPolymorphicSerializer(PolymorphicSerializer polymorphicSerializer, CompositeDecoder compositeDecoder, String str) {
        Request serializersModule = compositeDecoder.getSerializersModule();
        polymorphicSerializer.getClass();
        Map map = (Map) serializersModule.tags.get(null);
        KSerializer kSerializer = map != null ? (KSerializer) map.get(str) : null;
        if (kSerializer == null) {
            kSerializer = null;
        }
        if (kSerializer == null) {
            Object obj = serializersModule.lazyCacheControl.get(null);
            Function1 function1 = TypeIntrinsics.isFunctionOfArity(1, obj) ? (Function1) obj : null;
            kSerializer = function1 != null ? (KSerializer) function1.invoke(str) : null;
        }
        if (kSerializer != null) {
            return kSerializer;
        }
        Platform_commonKt.throwSubtypeNotRegistered(str, null);
        throw null;
    }

    public static final ImageVector getDelete() {
        ImageVector imageVector = _delete;
        if (imageVector != null) {
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Filled.Delete", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
        int i = VectorKt.$r8$clinit;
        SolidColor solidColor = new SolidColor(Color.Black);
        Headers.Builder builder2 = new Headers.Builder(2);
        builder2.moveTo(6.0f, 19.0f);
        builder2.curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
        builder2.horizontalLineToRelative(8.0f);
        builder2.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
        builder2.verticalLineTo(7.0f);
        builder2.horizontalLineTo(6.0f);
        builder2.verticalLineToRelative(12.0f);
        builder2.close();
        builder2.moveTo(19.0f, 4.0f);
        builder2.horizontalLineToRelative(-3.5f);
        builder2.lineToRelative(-1.0f, -1.0f);
        builder2.horizontalLineToRelative(-5.0f);
        builder2.lineToRelative(-1.0f, 1.0f);
        builder2.horizontalLineTo(5.0f);
        builder2.verticalLineToRelative(2.0f);
        builder2.horizontalLineToRelative(14.0f);
        builder2.verticalLineTo(4.0f);
        builder2.close();
        ImageVector.Builder.m500addPathoIyEayM$default(builder, builder2.namesAndValues, solidColor);
        ImageVector imageVectorBuild = builder.build();
        _delete = imageVectorBuild;
        return imageVectorBuild;
    }
}
