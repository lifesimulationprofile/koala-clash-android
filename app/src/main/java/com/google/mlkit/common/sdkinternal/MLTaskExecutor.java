package com.google.mlkit.common.sdkinternal;

import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.internal.base.zau;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.zzw;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class MLTaskExecutor {
    public static final Object zza = new Object();
    public static MLTaskExecutor zzb;
    public final zau zzc;

    public MLTaskExecutor(Looper looper) {
        zau zauVar = new zau(looper);
        Looper.getMainLooper();
        this.zzc = zauVar;
    }

    public static MLTaskExecutor getInstance() {
        MLTaskExecutor mLTaskExecutor;
        synchronized (zza) {
            try {
                if (zzb == null) {
                    HandlerThread handlerThread = new HandlerThread("MLHandler", 9);
                    handlerThread.start();
                    zzb = new MLTaskExecutor(handlerThread.getLooper());
                }
                mLTaskExecutor = zzb;
            } catch (Throwable th) {
                throw th;
            }
        }
        return mLTaskExecutor;
    }

    public static zzw scheduleCallable(Callable callable) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zzh.zza.execute(new zzb(1, callable, taskCompletionSource));
        return taskCompletionSource.zza;
    }
}
