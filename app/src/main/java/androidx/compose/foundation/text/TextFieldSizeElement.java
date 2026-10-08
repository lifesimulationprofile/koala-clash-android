package androidx.compose.foundation.text;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import coil.network.HttpException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
final class TextFieldSizeElement extends ModifierNodeElement {
    public final TextStyle style;

    public TextFieldSizeElement(TextStyle textStyle) {
        this.style = textStyle;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        return new TextFieldSizeNode(this.style);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextFieldSizeElement)) {
            return false;
        }
        return Intrinsics.areEqual(this.style, ((TextFieldSizeElement) obj).style);
    }

    public final int hashCode() {
        return this.style.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        TextFieldSizeNode textFieldSizeNode = (TextFieldSizeNode) node;
        textFieldSizeNode.getClass();
        TextStyle textStyleResolveDefaults = ParagraphKt.resolveDefaults(this.style, HitTestResultKt.requireLayoutNode(textFieldSizeNode).layoutDirection);
        textFieldSizeNode.updateFontResolutionState(textStyleResolveDefaults, (FontFamily$Resolver) HitTestResultKt.currentValueOf(textFieldSizeNode, CompositionLocalsKt.LocalFontFamilyResolver));
        TextFieldSize textFieldSize = textFieldSizeNode.minSizeState;
        if (textFieldSize == null) {
            InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("Min size state is not set.");
            throw new HttpException();
        }
        TextFieldSize.update$default(textFieldSize, null, null, textStyleResolveDefaults, 23);
        HitTestResultKt.invalidateMeasurement(textFieldSizeNode);
    }
}
