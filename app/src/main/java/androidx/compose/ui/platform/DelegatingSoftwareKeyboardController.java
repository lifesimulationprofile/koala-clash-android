package androidx.compose.ui.platform;

import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputSession;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class DelegatingSoftwareKeyboardController implements SoftwareKeyboardController {
    public final TextInputService textInputService;

    public DelegatingSoftwareKeyboardController(TextInputService textInputService) {
        this.textInputService = textInputService;
    }

    public final void hide() {
        this.textInputService.platformTextInputService.hideSoftwareKeyboard();
    }

    public final void show() {
        TextInputService textInputService = this.textInputService;
        if (((TextInputSession) textInputService._currentInputSession.get()) != null) {
            textInputService.platformTextInputService.showSoftwareKeyboard();
        }
    }
}
