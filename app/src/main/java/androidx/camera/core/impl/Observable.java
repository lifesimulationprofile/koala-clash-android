package androidx.camera.core.impl;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface Observable {

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public interface Observer {
        void onError(Throwable th);

        void onNewData(Object obj);
    }

    void addObserver(Executor executor, Observer observer);

    void removeObserver(Observer observer);
}
