package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
final class LegacyAdaptingPlatformTextInputModifier extends ModifierNodeElement {
    public final LegacyTextFieldState legacyTextFieldState;
    public final AndroidLegacyPlatformTextInputServiceAdapter serviceAdapter;
    public final TextFieldSelectionManager textFieldSelectionManager;

    public LegacyAdaptingPlatformTextInputModifier(AndroidLegacyPlatformTextInputServiceAdapter androidLegacyPlatformTextInputServiceAdapter, LegacyTextFieldState legacyTextFieldState, TextFieldSelectionManager textFieldSelectionManager) {
        this.serviceAdapter = androidLegacyPlatformTextInputServiceAdapter;
        this.legacyTextFieldState = legacyTextFieldState;
        this.textFieldSelectionManager = textFieldSelectionManager;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        return new LegacyAdaptingPlatformTextInputModifierNode(this.serviceAdapter, this.legacyTextFieldState, this.textFieldSelectionManager);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LegacyAdaptingPlatformTextInputModifier)) {
            return false;
        }
        LegacyAdaptingPlatformTextInputModifier legacyAdaptingPlatformTextInputModifier = (LegacyAdaptingPlatformTextInputModifier) obj;
        return Intrinsics.areEqual(this.serviceAdapter, legacyAdaptingPlatformTextInputModifier.serviceAdapter) && Intrinsics.areEqual(this.legacyTextFieldState, legacyAdaptingPlatformTextInputModifier.legacyTextFieldState) && Intrinsics.areEqual(this.textFieldSelectionManager, legacyAdaptingPlatformTextInputModifier.textFieldSelectionManager);
    }

    public final int hashCode() {
        return this.textFieldSelectionManager.hashCode() + ((this.legacyTextFieldState.hashCode() + (this.serviceAdapter.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "LegacyAdaptingPlatformTextInputModifier(serviceAdapter=" + this.serviceAdapter + ", legacyTextFieldState=" + this.legacyTextFieldState + ", textFieldSelectionManager=" + this.textFieldSelectionManager + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        LegacyAdaptingPlatformTextInputModifierNode legacyAdaptingPlatformTextInputModifierNode = (LegacyAdaptingPlatformTextInputModifierNode) node;
        if (legacyAdaptingPlatformTextInputModifierNode.isAttached) {
            legacyAdaptingPlatformTextInputModifierNode.serviceAdapter.stopInput();
            legacyAdaptingPlatformTextInputModifierNode.serviceAdapter.unregisterModifier(legacyAdaptingPlatformTextInputModifierNode);
        }
        AndroidLegacyPlatformTextInputServiceAdapter androidLegacyPlatformTextInputServiceAdapter = this.serviceAdapter;
        legacyAdaptingPlatformTextInputModifierNode.serviceAdapter = androidLegacyPlatformTextInputServiceAdapter;
        if (legacyAdaptingPlatformTextInputModifierNode.isAttached) {
            if (androidLegacyPlatformTextInputServiceAdapter.textInputModifierNode != null) {
                InlineClassHelperKt.throwIllegalStateException("Expected textInputModifierNode to be null");
            }
            androidLegacyPlatformTextInputServiceAdapter.textInputModifierNode = legacyAdaptingPlatformTextInputModifierNode;
        }
        legacyAdaptingPlatformTextInputModifierNode.legacyTextFieldState = this.legacyTextFieldState;
        legacyAdaptingPlatformTextInputModifierNode.textFieldSelectionManager = this.textFieldSelectionManager;
    }
}
