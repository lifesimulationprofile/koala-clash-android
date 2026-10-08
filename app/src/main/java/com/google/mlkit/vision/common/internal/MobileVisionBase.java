package com.google.mlkit.vision.common.internal;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import coil.memory.EmptyStrongMemoryCache;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.zzw;
import com.google.mlkit.vision.barcode.internal.zzl;
import java.io.Closeable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.ConnectionPool;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class MobileVisionBase implements Closeable, LifecycleObserver {
    public static final GmsLogger zzb = new GmsLogger(0, "MobileVisionBase", "");
    public final AtomicBoolean zzc = new AtomicBoolean(false);
    public final zzl zzd;
    public final EmptyStrongMemoryCache zze;
    public final Executor zzf;

    public MobileVisionBase(zzl zzlVar, Executor executor) {
        this.zzd = zzlVar;
        EmptyStrongMemoryCache emptyStrongMemoryCache = new EmptyStrongMemoryCache(29);
        this.zze = emptyStrongMemoryCache;
        this.zzf = executor;
        zzlVar.zza$1.incrementAndGet();
        zzw zzwVarCallAfterLoad = zzlVar.callAfterLoad(executor, zzb.zza, (ConnectionPool) emptyStrongMemoryCache.weakMemoryCache);
        zzc zzcVar = zzc.zza;
        zzwVarCallAfterLoad.getClass();
        zzwVarCallAfterLoad.addOnFailureListener(TaskExecutors.MAIN_THREAD, zzcVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, com.google.mlkit.vision.barcode.BarcodeScanner
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public synchronized void close() {
        if (this.zzc.getAndSet(true)) {
            return;
        }
        this.zze.cancel();
        zzl zzlVar = this.zzd;
        Executor executor = this.zzf;
        if (zzlVar.zza$1.get() <= 0) {
            throw new IllegalStateException();
        }
        zzlVar.taskQueue.submit(new com.google.mlkit.common.sdkinternal.zzb(2, zzlVar, new TaskCompletionSource()), executor);
    }
}
