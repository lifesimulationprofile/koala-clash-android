package androidx.appcompat.view;

import android.view.SearchEvent;
import android.view.Window;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class WindowCallbackWrapper$Api23Impl {
    public static boolean onSearchRequested(Window.Callback callback, SearchEvent searchEvent) {
        return callback.onSearchRequested(searchEvent);
    }

    public static android.view.ActionMode onWindowStartingActionMode(Window.Callback callback, android.view.ActionMode.Callback callback2, int i) {
        return callback.onWindowStartingActionMode(callback2, i);
    }
}
