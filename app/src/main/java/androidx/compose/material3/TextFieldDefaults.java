package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.material3.internal.TextFieldImplKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class TextFieldDefaults {
    public static final TextFieldDefaults INSTANCE = new TextFieldDefaults();
    public static final TextFieldDefaults INSTANCE$1 = new TextFieldDefaults();

    /* JADX INFO: renamed from: supportingTextPadding-a9UjIt4$material3$default, reason: not valid java name */
    public static PaddingValuesImpl m272supportingTextPaddinga9UjIt4$material3$default() {
        float f = TextFieldImplKt.TextFieldPadding;
        return new PaddingValuesImpl(f, TextFieldImplKt.SupportingTopPadding, f, 0);
    }
}
