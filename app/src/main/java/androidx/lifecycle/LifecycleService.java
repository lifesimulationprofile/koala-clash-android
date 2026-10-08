package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import coil.ImageLoader$Builder;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class LifecycleService extends Service implements LifecycleOwner {
    public final ImageLoader$Builder dispatcher = new ImageLoader$Builder(this);

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return (LifecycleRegistry) this.dispatcher.applicationContext;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        this.dispatcher.postDispatchRunnable(Lifecycle.Event.ON_START);
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        this.dispatcher.postDispatchRunnable(Lifecycle.Event.ON_CREATE);
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        Lifecycle.Event event = Lifecycle.Event.ON_STOP;
        ImageLoader$Builder imageLoader$Builder = this.dispatcher;
        imageLoader$Builder.postDispatchRunnable(event);
        imageLoader$Builder.postDispatchRunnable(Lifecycle.Event.ON_DESTROY);
        super.onDestroy();
    }

    @Override // android.app.Service
    public final void onStart(Intent intent, int i) {
        this.dispatcher.postDispatchRunnable(Lifecycle.Event.ON_START);
        super.onStart(intent, i);
    }
}
