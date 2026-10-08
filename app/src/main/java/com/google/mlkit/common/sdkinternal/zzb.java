package com.google.mlkit.common.sdkinternal;

import androidx.appcompat.view.menu.CascadingMenuPopup$3$1;
import androidx.appcompat.widget.AppCompatDrawableManager;
import coil.disk.DiskLruCache;
import com.google.android.gms.internal.mlkit_common.zzrq;
import com.google.android.gms.internal.mlkit_common.zzsu;
import com.google.android.gms.internal.mlkit_vision_barcode.zzra;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrc;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrr;
import com.google.android.gms.internal.mlkit_vision_barcode.zzwp;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.zzw;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.vision.barcode.internal.zzl;
import java.lang.ref.ReferenceQueue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.ExecutorCoroutineDispatcherImpl;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.LimitedDispatcher;
import okhttp3.Request;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zzb implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public Object zza;
    public final Object zzb;

    public /* synthetic */ zzb(int i, Object obj, Object obj2) {
        this.$r8$classId = i;
        this.zza = obj;
        this.zzb = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                ReferenceQueue referenceQueue = (ReferenceQueue) this.zza;
                while (!((Set) this.zzb).isEmpty()) {
                    try {
                        zzd zzdVar = (zzd) referenceQueue.remove();
                        if (zzdVar.zza.remove(zzdVar)) {
                            zzdVar.clear();
                            zzdVar.zzb.getClass();
                        }
                    } catch (InterruptedException unused) {
                    }
                }
                return;
            case 1:
                Callable callable = (Callable) this.zza;
                zzw zzwVar = ((TaskCompletionSource) this.zzb).zza;
                try {
                    zzwVar.zzb(callable.call());
                    return;
                } catch (MlKitException e) {
                    zzwVar.zza(e);
                    return;
                } catch (Exception e2) {
                    zzwVar.zza(new MlKitException("Internal error has occurred when executing ML Kit tasks", e2));
                    return;
                }
            case 2:
                zzl zzlVar = (zzl) this.zza;
                TaskCompletionSource taskCompletionSource = (TaskCompletionSource) this.zzb;
                int iDecrementAndGet = zzlVar.zza$1.decrementAndGet();
                if (iDecrementAndGet < 0) {
                    throw new IllegalStateException();
                }
                if (iDecrementAndGet == 0) {
                    synchronized (zzlVar) {
                        try {
                            zzlVar.zzd.zzb();
                            zzl.zza = true;
                            AppCompatDrawableManager.AnonymousClass1 anonymousClass1 = new AppCompatDrawableManager.AnonymousClass1();
                            zzra zzraVar = zzlVar.zzh ? zzra.zzc : zzra.zzb;
                            zzwp zzwpVar = zzlVar.zze;
                            anonymousClass1.COLORFILTER_COLOR_CONTROL_ACTIVATED = zzraVar;
                            Request request = new Request(15, false);
                            request.method = com.google.mlkit.vision.barcode.internal.zzb.zzc(zzlVar.zzc);
                            anonymousClass1.COLORFILTER_COLOR_BACKGROUND_MULTIPLY = new zzrr(request);
                            zzh.zza.execute(new CascadingMenuPopup$3$1(zzwpVar, new StatusLine(anonymousClass1, 0), zzrc.zzl, zzwpVar.zzj(), 2));
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    zzlVar.zzb.set(false);
                }
                zzrq.zza.clear();
                zzsu.zza.clear();
                taskCompletionSource.zza.zzb(null);
                return;
            case 3:
                DiskLruCache.Editor editor = (DiskLruCache.Editor) this.zza;
                AtomicReference atomicReference = (AtomicReference) editor.this$0;
                if (((Thread) atomicReference.getAndSet(Thread.currentThread())) != null) {
                    throw new IllegalStateException();
                }
                try {
                    ((Runnable) this.zzb).run();
                    atomicReference.set(null);
                    editor.zzc();
                    return;
                } catch (Throwable th2) {
                    try {
                        atomicReference.set(null);
                        editor.zzc();
                        throw th2;
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                        throw th2;
                    }
                }
            case 4:
                ((CancellableContinuationImpl) this.zzb).resumeUndispatched((ExecutorCoroutineDispatcherImpl) this.zza, Unit.INSTANCE);
                return;
            default:
                LimitedDispatcher limitedDispatcher = (LimitedDispatcher) this.zzb;
                int i = 0;
                while (true) {
                    try {
                        ((Runnable) this.zza).run();
                    } catch (Throwable th4) {
                        JobKt.handleCoroutineException(th4, EmptyCoroutineContext.INSTANCE);
                    }
                    Runnable runnableObtainTaskOrDeallocateWorker = limitedDispatcher.obtainTaskOrDeallocateWorker();
                    if (runnableObtainTaskOrDeallocateWorker == null) {
                        return;
                    }
                    this.zza = runnableObtainTaskOrDeallocateWorker;
                    i++;
                    if (i >= 16 && InlineList.safeIsDispatchNeeded(limitedDispatcher.dispatcher, limitedDispatcher)) {
                        InlineList.safeDispatch(limitedDispatcher.dispatcher, limitedDispatcher, this);
                        return;
                    }
                    break;
                }
                break;
        }
    }

    public zzb(LimitedDispatcher limitedDispatcher, Runnable runnable) {
        this.$r8$classId = 5;
        this.zzb = limitedDispatcher;
        this.zza = runnable;
    }
}
