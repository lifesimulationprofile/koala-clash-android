package androidx.compose.ui.text.input;

import androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda4;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.lifecycle.compose.LifecycleEffectKt$$ExternalSyntheticLambda1;
import kotlinx.coroutines.channels.ProduceKt$awaitClose$4$1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface PlatformTextInputService {
    void hideSoftwareKeyboard();

    void notifyFocusedRect(Rect rect);

    void showSoftwareKeyboard();

    void startInput();

    void startInput(TextFieldValue textFieldValue, ImeOptions imeOptions, LifecycleEffectKt$$ExternalSyntheticLambda1 lifecycleEffectKt$$ExternalSyntheticLambda1, CoreTextFieldKt$$ExternalSyntheticLambda4 coreTextFieldKt$$ExternalSyntheticLambda4);

    void stopInput();

    void updateState(TextFieldValue textFieldValue, TextFieldValue textFieldValue2);

    void updateTextLayoutResult(TextFieldValue textFieldValue, OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, ProduceKt$awaitClose$4$1 produceKt$awaitClose$4$1, Rect rect, Rect rect2);
}
