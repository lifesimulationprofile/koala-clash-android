package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Density;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface TextForegroundStyle {

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Unspecified implements TextForegroundStyle {
        public static final Unspecified INSTANCE = new Unspecified();

        @Override // androidx.compose.ui.text.style.TextForegroundStyle
        public final float getAlpha() {
            return Float.NaN;
        }

        @Override // androidx.compose.ui.text.style.TextForegroundStyle
        public final Brush getBrush() {
            return null;
        }

        @Override // androidx.compose.ui.text.style.TextForegroundStyle
        /* JADX INFO: renamed from: getColor-0d7_KjU */
        public final long mo666getColor0d7_KjU() {
            int i = Color.$r8$clinit;
            return Color.Unspecified;
        }

        @Override // androidx.compose.ui.text.style.TextForegroundStyle
        public final /* synthetic */ TextForegroundStyle merge(TextForegroundStyle textForegroundStyle) {
            return Density.CC.$default$merge(this, textForegroundStyle);
        }

        @Override // androidx.compose.ui.text.style.TextForegroundStyle
        public final TextForegroundStyle takeOrElse(Function0 function0) {
            return !equals(INSTANCE) ? this : (TextForegroundStyle) function0.invoke();
        }
    }

    float getAlpha();

    Brush getBrush();

    /* JADX INFO: renamed from: getColor-0d7_KjU */
    long mo666getColor0d7_KjU();

    TextForegroundStyle merge(TextForegroundStyle textForegroundStyle);

    TextForegroundStyle takeOrElse(Function0 function0);
}
