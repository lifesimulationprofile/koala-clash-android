package androidx.compose.ui.text.input;

import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public class NullableInputConnectionWrapperApi24 extends NullableInputConnectionWrapperApi21 {
    @Override // androidx.compose.ui.text.input.NullableInputConnectionWrapperApi21
    public final void closeDelegate(androidx.compose.foundation.text.input.internal.RecordingInputConnection recordingInputConnection) {
        recordingInputConnection.closeConnection();
    }

    @Override // androidx.compose.ui.text.input.NullableInputConnectionWrapperApi21, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingTextInCodePoints(int i, int i2) {
        androidx.compose.foundation.text.input.internal.RecordingInputConnection recordingInputConnection = this.delegate;
        if (recordingInputConnection != null) {
            return recordingInputConnection.deleteSurroundingTextInCodePoints(i, i2);
        }
        return false;
    }

    @Override // androidx.compose.ui.text.input.NullableInputConnectionWrapperApi21, android.view.inputmethod.InputConnection
    public final Handler getHandler() {
        return null;
    }
}
