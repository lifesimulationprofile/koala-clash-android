package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import androidx.emoji2.text.EmojiCompat;
import androidx.room.TransactionElement;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class EmojiInputConnection extends InputConnectionWrapper {
    public final TransactionElement.Key mEmojiCompatDeleteHelper;
    public final EditText mTextView;

    public EmojiInputConnection(EditText editText, InputConnection inputConnection, EditorInfo editorInfo) {
        TransactionElement.Key key = new TransactionElement.Key(10);
        super(inputConnection, false);
        this.mTextView = editText;
        this.mEmojiCompatDeleteHelper = key;
        if (EmojiCompat.isConfigured()) {
            EmojiCompat.get().updateEditorInfo(editorInfo);
        }
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int i, int i2) {
        Editable editableText = this.mTextView.getEditableText();
        this.mEmojiCompatDeleteHelper.getClass();
        return TransactionElement.Key.handleDeleteSurroundingText(this, editableText, i, i2, false) || super.deleteSurroundingText(i, i2);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingTextInCodePoints(int i, int i2) {
        Editable editableText = this.mTextView.getEditableText();
        this.mEmojiCompatDeleteHelper.getClass();
        return TransactionElement.Key.handleDeleteSurroundingText(this, editableText, i, i2, true) || super.deleteSurroundingTextInCodePoints(i, i2);
    }
}
