package androidx.compose.ui.text.input;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class TextInputSession {
    public final PlatformTextInputService platformTextInputService;
    public final TextInputService textInputService;

    public TextInputSession(TextInputService textInputService, PlatformTextInputService platformTextInputService) {
        this.textInputService = textInputService;
        this.platformTextInputService = platformTextInputService;
    }

    public final void updateState(TextFieldValue textFieldValue, TextFieldValue textFieldValue2) {
        if (Intrinsics.areEqual((TextInputSession) this.textInputService._currentInputSession.get(), this)) {
            this.platformTextInputService.updateState(textFieldValue, textFieldValue2);
        }
    }
}
