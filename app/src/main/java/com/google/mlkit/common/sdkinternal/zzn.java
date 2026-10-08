package com.google.mlkit.common.sdkinternal;

import android.content.Context;
import androidx.compose.ui.unit.Density;
import androidx.work.ForegroundInfo;
import androidx.work.impl.Processor;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.WorkForegroundUpdater;
import androidx.work.impl.utils.futures.AbstractFuture;
import androidx.work.impl.utils.futures.SettableFuture;
import coil.memory.EmptyStrongMemoryCache;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.zzw;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.vision.barcode.internal.zzl;
import java.util.UUID;
import java.util.concurrent.Callable;
import okhttp3.ConnectionPool;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zzn implements Runnable {
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ Object zza;
    public final /* synthetic */ Object zzb;
    public final /* synthetic */ Object zzc;
    public final /* synthetic */ Object zzd;
    public final /* synthetic */ Object zze;

    public /* synthetic */ zzn(zzl zzlVar, ConnectionPool connectionPool, EmptyStrongMemoryCache emptyStrongMemoryCache, Callable callable, TaskCompletionSource taskCompletionSource) {
        this.zza = zzlVar;
        this.zzb = connectionPool;
        this.zzc = emptyStrongMemoryCache;
        this.zzd = callable;
        this.zze = taskCompletionSource;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                zzl zzlVar = (zzl) this.zza;
                ConnectionPool connectionPool = (ConnectionPool) this.zzb;
                EmptyStrongMemoryCache emptyStrongMemoryCache = (EmptyStrongMemoryCache) this.zzc;
                Callable callable = (Callable) this.zzd;
                TaskCompletionSource taskCompletionSource = (TaskCompletionSource) this.zze;
                try {
                    if (((zzw) connectionPool.delegate).isComplete()) {
                        emptyStrongMemoryCache.cancel();
                        return;
                    }
                    try {
                        if (!zzlVar.zzb.get()) {
                            synchronized (zzlVar) {
                                zzlVar.zzh = zzlVar.zzd.zzc();
                            }
                            zzlVar.zzb.set(true);
                        }
                        if (((zzw) connectionPool.delegate).isComplete()) {
                            emptyStrongMemoryCache.cancel();
                            return;
                        }
                        Object objCall = callable.call();
                        if (((zzw) connectionPool.delegate).isComplete()) {
                            emptyStrongMemoryCache.cancel();
                            return;
                        } else {
                            taskCompletionSource.zza.zzb(objCall);
                            return;
                        }
                    } catch (RuntimeException e) {
                        throw new MlKitException("Internal error has occurred when executing ML Kit tasks", e);
                    }
                } catch (Exception e2) {
                    if (((zzw) connectionPool.delegate).isComplete()) {
                        emptyStrongMemoryCache.cancel();
                        return;
                    } else {
                        taskCompletionSource.zza.zza(e2);
                        return;
                    }
                }
            default:
                try {
                    if (!(((SettableFuture) this.zza).value instanceof AbstractFuture.Cancellation)) {
                        String string = ((UUID) this.zzb).toString();
                        WorkSpec workSpec = ((WorkForegroundUpdater) this.zze).mWorkSpecDao.getWorkSpec(string);
                        if (workSpec == null || Density.CC._isFinished(workSpec.state)) {
                            throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                        }
                        ((Processor) ((WorkForegroundUpdater) this.zze).mForegroundProcessor).startForeground(string, (ForegroundInfo) this.zzc);
                        ((Context) this.zzd).startService(SystemForegroundDispatcher.createNotifyIntent((Context) this.zzd, WorkSpecKt.generationalId(workSpec), (ForegroundInfo) this.zzc));
                    }
                    ((SettableFuture) this.zza).set(null);
                    return;
                } catch (Throwable th) {
                    ((SettableFuture) this.zza).setException(th);
                    return;
                }
        }
    }

    public zzn(WorkForegroundUpdater workForegroundUpdater, SettableFuture settableFuture, UUID uuid, ForegroundInfo foregroundInfo, Context context) {
        this.zze = workForegroundUpdater;
        this.zza = settableFuture;
        this.zzb = uuid;
        this.zzc = foregroundInfo;
        this.zzd = context;
    }
}
