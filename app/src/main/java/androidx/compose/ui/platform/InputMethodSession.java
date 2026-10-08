package androidx.compose.ui.platform;

import androidx.compose.foundation.text.input.internal.LegacyTextInputMethodRequest;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.node.WeakReference;
import okhttp3.Handshake;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class InputMethodSession {
    public boolean disposed;
    public final Handshake.AnonymousClass2 onAllConnectionsClosed;
    public final LegacyTextInputMethodRequest request;
    public final Object lock = new Object();
    public final MutableVector connections = new MutableVector(new WeakReference[16]);

    public InputMethodSession(LegacyTextInputMethodRequest legacyTextInputMethodRequest, Handshake.AnonymousClass2 anonymousClass2) {
        this.request = legacyTextInputMethodRequest;
        this.onAllConnectionsClosed = anonymousClass2;
    }
}
