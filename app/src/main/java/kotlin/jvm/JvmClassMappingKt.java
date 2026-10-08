package kotlin.jvm;

import androidx.compose.foundation.text.modifiers.MinLinesConstrainer;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityImpl;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class JvmClassMappingKt {
    public static MinLinesConstrainer from(MinLinesConstrainer minLinesConstrainer, LayoutDirection layoutDirection, TextStyle textStyle, Density density, FontFamily$Resolver fontFamily$Resolver) {
        if (minLinesConstrainer != null && layoutDirection == minLinesConstrainer.layoutDirection && ParagraphKt.resolveDefaults(textStyle, layoutDirection).equals(minLinesConstrainer.inputTextStyle) && density.getDensity() == minLinesConstrainer.density.density && fontFamily$Resolver == minLinesConstrainer.fontFamilyResolver) {
            return minLinesConstrainer;
        }
        MinLinesConstrainer minLinesConstrainer2 = MinLinesConstrainer.last;
        if (minLinesConstrainer2 != null && layoutDirection == minLinesConstrainer2.layoutDirection && ParagraphKt.resolveDefaults(textStyle, layoutDirection).equals(minLinesConstrainer2.inputTextStyle) && density.getDensity() == minLinesConstrainer2.density.density && fontFamily$Resolver == minLinesConstrainer2.fontFamilyResolver) {
            return minLinesConstrainer2;
        }
        MinLinesConstrainer minLinesConstrainer3 = new MinLinesConstrainer(layoutDirection, ParagraphKt.resolveDefaults(textStyle, layoutDirection), new DensityImpl(density.getDensity(), density.getFontScale()), fontFamily$Resolver);
        MinLinesConstrainer.last = minLinesConstrainer3;
        return minLinesConstrainer3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final Class getJavaObjectType(KClass kClass) {
        Class jClass = ((ClassBasedDeclarationContainer) kClass).getJClass();
        if (jClass.isPrimitive()) {
            String name = jClass.getName();
            switch (name.hashCode()) {
                case -1325958191:
                    if (name.equals("double")) {
                        return Double.class;
                    }
                    break;
                case 104431:
                    if (name.equals("int")) {
                        return Integer.class;
                    }
                    break;
                case 3039496:
                    if (name.equals("byte")) {
                        return Byte.class;
                    }
                    break;
                case 3052374:
                    if (name.equals("char")) {
                        return Character.class;
                    }
                    break;
                case 3327612:
                    if (name.equals("long")) {
                        return Long.class;
                    }
                    break;
                case 3625364:
                    if (name.equals("void")) {
                        return Void.class;
                    }
                    break;
                case 64711720:
                    if (name.equals("boolean")) {
                        return Boolean.class;
                    }
                    break;
                case 97526364:
                    if (name.equals("float")) {
                        return Float.class;
                    }
                    break;
                case 109413500:
                    if (name.equals("short")) {
                        return Short.class;
                    }
                    break;
            }
        }
        return jClass;
    }
}
