package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.text.method.KeyListener;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.View;
import com.caverock.androidsvg.SVG;
import okio.AsyncTimeout;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class EmojiKeyListener implements KeyListener {
    public final AsyncTimeout.Companion mEmojiCompatHandleKeyDownHelper;
    public final KeyListener mKeyListener;

    public EmojiKeyListener(KeyListener keyListener) {
        AsyncTimeout.Companion companion = new AsyncTimeout.Companion(10);
        this.mKeyListener = keyListener;
        this.mEmojiCompatHandleKeyDownHelper = companion;
    }

    @Override // android.text.method.KeyListener
    public final void clearMetaKeyState(View view, Editable editable, int i) {
        this.mKeyListener.clearMetaKeyState(view, editable, i);
    }

    @Override // android.text.method.KeyListener
    public final int getInputType() {
        return this.mKeyListener.getInputType();
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyDown(View view, Editable editable, int i, KeyEvent keyEvent) {
        boolean zDelete;
        boolean z;
        this.mEmojiCompatHandleKeyDownHelper.getClass();
        if (i != 67) {
            zDelete = i != 112 ? false : SVG.delete(editable, keyEvent, true);
        } else {
            zDelete = SVG.delete(editable, keyEvent, false);
        }
        if (zDelete) {
            MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
            z = true;
        } else {
            z = false;
        }
        return z || this.mKeyListener.onKeyDown(view, editable, i, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.mKeyListener.onKeyOther(view, editable, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyUp(View view, Editable editable, int i, KeyEvent keyEvent) {
        return this.mKeyListener.onKeyUp(view, editable, i, keyEvent);
    }
}
