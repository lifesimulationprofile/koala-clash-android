package androidx.camera.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class LifecycleCameraRepository$LifecycleCameraRepositoryObserver implements LifecycleObserver {
    public final Request mLifecycleCameraRepository;
    public final LifecycleOwner mLifecycleOwner;

    public LifecycleCameraRepository$LifecycleCameraRepositoryObserver(LifecycleOwner lifecycleOwner, Request request) {
        this.mLifecycleOwner = lifecycleOwner;
        this.mLifecycleCameraRepository = request;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy(LifecycleOwner lifecycleOwner) {
        Request request = this.mLifecycleCameraRepository;
        synchronized (request.url) {
            try {
                LifecycleCameraRepository$LifecycleCameraRepositoryObserver lifecycleCameraRepositoryObserver = request.getLifecycleCameraRepositoryObserver(lifecycleOwner);
                if (lifecycleCameraRepositoryObserver == null) {
                    return;
                }
                request.setInactive(lifecycleOwner);
                Iterator it = ((Set) ((HashMap) request.headers).get(lifecycleCameraRepositoryObserver)).iterator();
                while (it.hasNext()) {
                    ((HashMap) request.method).remove((AutoValue_LifecycleCameraRepository_Key) it.next());
                }
                ((HashMap) request.headers).remove(lifecycleCameraRepositoryObserver);
                lifecycleCameraRepositoryObserver.mLifecycleOwner.getLifecycle().removeObserver(lifecycleCameraRepositoryObserver);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart(LifecycleOwner lifecycleOwner) {
        this.mLifecycleCameraRepository.setActive(lifecycleOwner);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop(LifecycleOwner lifecycleOwner) {
        this.mLifecycleCameraRepository.setInactive(lifecycleOwner);
    }
}
