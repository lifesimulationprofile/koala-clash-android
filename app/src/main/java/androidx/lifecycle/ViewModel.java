package androidx.lifecycle;

import androidx.lifecycle.viewmodel.internal.ViewModelImpl;
import java.util.Iterator;
import kotlin.Unit;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ViewModel {
    public final ViewModelImpl impl = new ViewModelImpl();

    public final void addCloseable(String str, AutoCloseable autoCloseable) {
        AutoCloseable autoCloseable2;
        ViewModelImpl viewModelImpl = this.impl;
        if (viewModelImpl != null) {
            if (viewModelImpl.isCleared) {
                ViewModelImpl.closeWithRuntimeException(autoCloseable);
                return;
            }
            synchronized (viewModelImpl.lock) {
                autoCloseable2 = (AutoCloseable) viewModelImpl.keyToCloseables.put(str, autoCloseable);
            }
            ViewModelImpl.closeWithRuntimeException(autoCloseable2);
        }
    }

    public final void clear$lifecycle_viewmodel_release() {
        ViewModelImpl viewModelImpl = this.impl;
        if (viewModelImpl != null && !viewModelImpl.isCleared) {
            viewModelImpl.isCleared = true;
            synchronized (viewModelImpl.lock) {
                try {
                    Iterator it = viewModelImpl.keyToCloseables.values().iterator();
                    while (it.hasNext()) {
                        ViewModelImpl.closeWithRuntimeException((AutoCloseable) it.next());
                    }
                    Iterator it2 = viewModelImpl.closeables.iterator();
                    while (it2.hasNext()) {
                        ViewModelImpl.closeWithRuntimeException((AutoCloseable) it2.next());
                    }
                    viewModelImpl.closeables.clear();
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        onCleared();
    }

    public final AutoCloseable getCloseable(String str) {
        AutoCloseable autoCloseable;
        ViewModelImpl viewModelImpl = this.impl;
        if (viewModelImpl == null) {
            return null;
        }
        synchronized (viewModelImpl.lock) {
            autoCloseable = (AutoCloseable) viewModelImpl.keyToCloseables.get(str);
        }
        return autoCloseable;
    }

    public void onCleared() {
    }
}
