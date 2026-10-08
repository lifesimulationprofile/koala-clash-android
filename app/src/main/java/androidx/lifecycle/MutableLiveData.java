package androidx.lifecycle;

import androidx.arch.core.executor.ArchTaskExecutor;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public class MutableLiveData extends LiveData {
    public final void postValue(Object obj) {
        boolean z;
        synchronized (this.mDataLock) {
            z = this.mPendingData == LiveData.NOT_SET;
            this.mPendingData = obj;
        }
        if (z) {
            ArchTaskExecutor.getInstance().postToMainThread(this.mPostValueRunnable);
        }
    }

    @Override // androidx.lifecycle.LiveData
    public final void setValue(Object obj) {
        LiveData.assertMainThread("setValue");
        this.mVersion++;
        this.mData = obj;
        dispatchingValue(null);
    }
}
