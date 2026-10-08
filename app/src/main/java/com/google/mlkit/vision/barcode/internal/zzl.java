package com.google.mlkit.vision.barcode.internal;

import android.graphics.Bitmap;
import android.media.Image;
import android.os.SystemClock;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.work.Worker;
import androidx.work.impl.WorkLauncherImpl;
import coil.disk.DiskLruCache;
import coil.memory.EmptyStrongMemoryCache;
import coil.memory.RealStrongMemoryCache;
import com.caverock.androidsvg.CSSParser;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.service.zao;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.internal.mlkit_vision_barcode.zzft;
import com.google.android.gms.internal.mlkit_vision_barcode.zzqi;
import com.google.android.gms.internal.mlkit_vision_barcode.zzqk;
import com.google.android.gms.internal.mlkit_vision_barcode.zzqq;
import com.google.android.gms.internal.mlkit_vision_barcode.zzra;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrb;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrc;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrn;
import com.google.android.gms.internal.mlkit_vision_barcode.zzro;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrr;
import com.google.android.gms.internal.mlkit_vision_barcode.zzwo;
import com.google.android.gms.internal.mlkit_vision_barcode.zzwp;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.zzw;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.zzn;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.BitmapInStreamingChecker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import okhttp3.ConnectionPool;
import okhttp3.Request;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.http1.HeadersReader;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzl {
    public static boolean zza = true;
    public final BarcodeScannerOptions zzc;
    public final zzm zzd;
    public final zzwp zze;
    public final RealStrongMemoryCache zzf;
    public boolean zzh;
    public final AtomicInteger zza$1 = new AtomicInteger(0);
    public final AtomicBoolean zzb = new AtomicBoolean(false);
    public final DiskLruCache.Editor taskQueue = new DiskLruCache.Editor(5, false);
    public final BitmapInStreamingChecker zzg = new BitmapInStreamingChecker();

    public zzl(MlKitContext mlKitContext, BarcodeScannerOptions barcodeScannerOptions, zzm zzmVar, zzwp zzwpVar) {
        zzah.checkNotNull(mlKitContext, "MlKitContext can not be null");
        this.zzc = barcodeScannerOptions;
        this.zzd = zzmVar;
        this.zze = zzwpVar;
        this.zzf = new RealStrongMemoryCache(mlKitContext.getApplicationContext(), 21);
    }

    public final zzw callAfterLoad(Executor executor, Callable callable, ConnectionPool connectionPool) {
        if (this.zza$1.get() <= 0) {
            throw new IllegalStateException();
        }
        if (((zzw) connectionPool.delegate).isComplete()) {
            zzw zzwVar = new zzw();
            zzwVar.zzc();
            return zzwVar;
        }
        EmptyStrongMemoryCache emptyStrongMemoryCache = new EmptyStrongMemoryCache(29);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource((ConnectionPool) emptyStrongMemoryCache.weakMemoryCache);
        com.google.mlkit.common.sdkinternal.zzm zzmVar = new com.google.mlkit.common.sdkinternal.zzm(executor, connectionPool, emptyStrongMemoryCache, taskCompletionSource);
        this.taskQueue.submit(new zzn(this, connectionPool, emptyStrongMemoryCache, callable, taskCompletionSource), zzmVar);
        return taskCompletionSource.zza;
    }

    public final List run(InputImage inputImage) throws Throwable {
        zzl zzlVar;
        InputImage inputImage2;
        synchronized (this) {
            try {
                try {
                    BitmapInStreamingChecker bitmapInStreamingChecker = this.zzg;
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    bitmapInStreamingChecker.check(inputImage);
                    try {
                        ArrayList arrayListZza = this.zzd.zza(inputImage);
                        zzlVar = this;
                        inputImage2 = inputImage;
                        try {
                            zzlVar.zzf(zzrb.zza, jElapsedRealtime, inputImage2, arrayListZza);
                            zza = false;
                            return arrayListZza;
                        } catch (MlKitException e) {
                            e = e;
                            MlKitException mlKitException = e;
                            zzlVar.zzf(mlKitException.zza == 14 ? zzrb.zzk : zzrb.zzab, jElapsedRealtime, inputImage2, null);
                            throw mlKitException;
                        }
                    } catch (MlKitException e2) {
                        e = e2;
                        zzlVar = this;
                        inputImage2 = inputImage;
                    }
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public final void zzf(final zzrb zzrbVar, long j, final InputImage inputImage, List list) {
        final CSSParser cSSParser = new CSSParser();
        final CSSParser cSSParser2 = new CSSParser();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Barcode barcode = (Barcode) it.next();
                int format = barcode.zza.getFormat();
                if (format > 4096 || format == 0) {
                    format = -1;
                }
                zzrn zzrnVar = (zzrn) zzb.zzb.get(format);
                if (zzrnVar == null) {
                    zzrnVar = zzrn.zza;
                }
                cSSParser.zza$com$google$android$gms$internal$mlkit_vision_barcode$zzcl(zzrnVar);
                zzro zzroVar = (zzro) zzb.zzc.get(barcode.zza.getValueType());
                if (zzroVar == null) {
                    zzroVar = zzro.zza;
                }
                cSSParser2.zza$com$google$android$gms$internal$mlkit_vision_barcode$zzcl(zzroVar);
            }
        }
        final long jElapsedRealtime = SystemClock.elapsedRealtime() - j;
        this.zze.zzf(new zzwo() { // from class: com.google.mlkit.vision.barcode.internal.zzj
            @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzwo
            public final StatusLine zza() {
                int iLimit;
                zzqi zzqiVar;
                zzl zzlVar = this.zza;
                long j2 = jElapsedRealtime;
                zzrb zzrbVar2 = zzrbVar;
                CSSParser cSSParser3 = cSSParser;
                CSSParser cSSParser4 = cSSParser2;
                InputImage inputImage2 = inputImage;
                Request request = new Request(15, false);
                Request request2 = new Request(14, false);
                request2.url = Long.valueOf(j2 & Long.MAX_VALUE);
                request2.method = zzrbVar2;
                request2.headers = Boolean.valueOf(zzl.zza);
                Boolean bool = Boolean.TRUE;
                request2.tags = bool;
                request2.lazyCacheControl = bool;
                request.url = new zzqq(request2);
                request.method = zzb.zzc(zzlVar.zzc);
                request.headers = cSSParser3.zzf();
                request.tags = cSSParser4.zzf();
                int i = inputImage2.zzg;
                if (i == -1) {
                    Bitmap bitmap = inputImage2.zza;
                    zzah.checkNotNull(bitmap);
                    iLimit = bitmap.getAllocationByteCount();
                } else {
                    if (i == 17 || i == 842094169) {
                        zzah.checkNotNull(null);
                        throw null;
                    }
                    if (i != 35) {
                        iLimit = 0;
                    } else {
                        Image.Plane[] planes = inputImage2.getPlanes();
                        zzah.checkNotNull(planes);
                        iLimit = (planes[0].getBuffer().limit() * 3) / 2;
                    }
                }
                WorkLauncherImpl workLauncherImpl = new WorkLauncherImpl(20);
                if (i == -1) {
                    zzqiVar = zzqi.zzg;
                } else if (i == 35) {
                    zzqiVar = zzqi.zze;
                } else if (i == 842094169) {
                    zzqiVar = zzqi.zzd;
                } else if (i != 16) {
                    zzqiVar = i != 17 ? zzqi.zza : zzqi.zzc;
                } else {
                    zzqiVar = zzqi.zzb;
                }
                workLauncherImpl.processor = zzqiVar;
                workLauncherImpl.workTaskExecutor = Integer.valueOf(Integer.MAX_VALUE & iLimit);
                request.lazyCacheControl = new zzqk(workLauncherImpl);
                AppCompatDrawableManager.AnonymousClass1 anonymousClass1 = new AppCompatDrawableManager.AnonymousClass1();
                anonymousClass1.COLORFILTER_COLOR_CONTROL_ACTIVATED = zzlVar.zzh ? zzra.zzc : zzra.zzb;
                anonymousClass1.COLORFILTER_COLOR_BACKGROUND_MULTIPLY = new zzrr(request);
                return new StatusLine(anonymousClass1, 0);
            }
        }, zzrc.zzj);
        Request request = new Request(13, false);
        request.url = zzrbVar;
        request.method = Boolean.valueOf(zza);
        request.headers = zzb.zzc(this.zzc);
        request.tags = cSSParser.zzf();
        request.lazyCacheControl = cSSParser2.zzf();
        final zzft zzftVar = new zzft(request);
        final ConnectionPool connectionPool = new ConnectionPool(17, this);
        final zzwp zzwpVar = this.zze;
        com.google.mlkit.common.sdkinternal.zzh.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.mlkit_vision_barcode.zzwn
            {
                zzrc zzrcVar = zzrc.zza;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzrc zzrcVar = zzrc.zzbe;
                zzwp zzwpVar2 = zzwpVar;
                HashMap map = zzwpVar2.zzl;
                if (!map.containsKey(zzrcVar)) {
                    map.put(zzrcVar, new zzbw());
                }
                zzbw zzbwVar = (zzbw) map.get(zzrcVar);
                Long lValueOf = Long.valueOf(jElapsedRealtime);
                zzci zzciVar = zzbwVar.zza;
                zzft zzftVar2 = zzftVar;
                Collection collection = (Collection) zzciVar.get(zzftVar2);
                if (collection == null) {
                    ArrayList arrayList = new ArrayList(3);
                    if (!arrayList.add(lValueOf)) {
                        throw new AssertionError("New Collection violated the Collection spec");
                    }
                    zzciVar.put(zzftVar2, arrayList);
                } else {
                    collection.add(lValueOf);
                }
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                if (zzwpVar2.zzk(zzrcVar, jElapsedRealtime2)) {
                    zzwpVar2.zzk.put(zzrcVar, Long.valueOf(jElapsedRealtime2));
                    com.google.mlkit.common.sdkinternal.zzh.zza.execute(new Worker.AnonymousClass2(zzwpVar2, connectionPool));
                }
            }
        });
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z = this.zzh;
        long j2 = jCurrentTimeMillis - jElapsedRealtime;
        RealStrongMemoryCache realStrongMemoryCache = this.zzf;
        int i = true != z ? 24301 : 24302;
        int i2 = zzrbVar.zzad;
        synchronized (realStrongMemoryCache) {
            AtomicLong atomicLong = (AtomicLong) realStrongMemoryCache.cache;
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            if (atomicLong.get() != -1 && jElapsedRealtime2 - ((AtomicLong) realStrongMemoryCache.cache).get() <= TimeUnit.MINUTES.toMillis(30L)) {
                return;
            }
            zzw zzwVarLog = ((zao) realStrongMemoryCache.weakMemoryCache).log(new TelemetryData(0, Arrays.asList(new MethodInvocation(i, i2, 0, j2, jCurrentTimeMillis, null, null, 0, -1))));
            HeadersReader headersReader = new HeadersReader(realStrongMemoryCache, jElapsedRealtime2, 4);
            zzwVarLog.getClass();
            zzwVarLog.addOnFailureListener(TaskExecutors.MAIN_THREAD, headersReader);
        }
    }
}
