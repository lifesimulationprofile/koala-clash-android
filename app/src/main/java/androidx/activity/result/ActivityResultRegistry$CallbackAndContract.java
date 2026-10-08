package androidx.activity.result;

import androidx.work.WorkManager;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityResultRegistry$CallbackAndContract {
    public final ActivityResultCallback callback;
    public final WorkManager contract;

    public ActivityResultRegistry$CallbackAndContract(ActivityResultCallback activityResultCallback, WorkManager workManager) {
        this.callback = activityResultCallback;
        this.contract = workManager;
    }
}
