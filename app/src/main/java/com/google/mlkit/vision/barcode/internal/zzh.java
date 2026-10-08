package com.google.mlkit.vision.barcode.internal;

import androidx.appcompat.view.menu.CascadingMenuPopup$3$1;
import androidx.appcompat.widget.AppCompatDrawableManager;
import com.google.android.gms.common.Feature;
import com.google.android.gms.internal.mlkit_vision_barcode.zzra;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrc;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrr;
import com.google.android.gms.internal.mlkit_vision_barcode.zzwp;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.zzp;
import com.google.android.gms.tasks.zzu;
import com.google.android.gms.tasks.zzw;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.internal.zzd;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.google.mlkit.vision.barcode.BarcodeScanner;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.MobileVisionBase;
import java.util.concurrent.Executor;
import okhttp3.ConnectionPool;
import okhttp3.Request;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzh extends MobileVisionBase implements BarcodeScanner {
    public final boolean zze;

    public zzh(BarcodeScannerOptions barcodeScannerOptions, zzl zzlVar, Executor executor, zzwp zzwpVar) {
        super(zzlVar, executor);
        boolean zZzf = zzb.zzf();
        this.zze = zZzf;
        Request request = new Request(15, false);
        request.method = zzb.zzc(barcodeScannerOptions);
        zzrr zzrrVar = new zzrr(request);
        AppCompatDrawableManager.AnonymousClass1 anonymousClass1 = new AppCompatDrawableManager.AnonymousClass1();
        anonymousClass1.COLORFILTER_COLOR_CONTROL_ACTIVATED = zZzf ? zzra.zzc : zzra.zzb;
        anonymousClass1.COLORFILTER_COLOR_BACKGROUND_MULTIPLY = zzrrVar;
        com.google.mlkit.common.sdkinternal.zzh.zza.execute(new CascadingMenuPopup$3$1(zzwpVar, new StatusLine(anonymousClass1, 1), zzrc.zzk, zzwpVar.zzj(), 2));
    }

    @Override // com.google.mlkit.vision.common.internal.MobileVisionBase, java.io.Closeable, java.lang.AutoCloseable, com.google.mlkit.vision.barcode.BarcodeScanner
    public final synchronized void close() {
        super.close();
    }

    @Override // com.google.android.gms.common.api.OptionalModuleApi
    public final Feature[] getOptionalFeatures() {
        return this.zze ? OptionalModuleUtils.EMPTY_FEATURES : new Feature[]{OptionalModuleUtils.FEATURE_BARCODE};
    }

    public final zzw process(InputImage inputImage) {
        zzw zzwVar;
        synchronized (this) {
            if (this.zzc.get()) {
                MlKitException mlKitException = new MlKitException("This detector is already closed!", 14);
                zzwVar = new zzw();
                zzwVar.zza(mlKitException);
            } else if (inputImage.zzd < 32 || inputImage.zze < 32) {
                MlKitException mlKitException2 = new MlKitException("InputImage width and height should be at least 32!", 3);
                zzwVar = new zzw();
                zzwVar.zza(mlKitException2);
            } else {
                zzwVar = this.zzd.callAfterLoad(this.zzf, new com.google.mlkit.vision.common.internal.zza(this, inputImage), (ConnectionPool) super.zze.weakMemoryCache);
            }
        }
        int i = inputImage.zzd;
        int i2 = inputImage.zze;
        zzd zzdVar = new zzd();
        zzwVar.getClass();
        zzu zzuVar = TaskExecutors.MAIN_THREAD;
        zzw zzwVar2 = new zzw();
        zzwVar.zzb.zza(new zzp(zzuVar, zzdVar, zzwVar2));
        zzwVar.zzi();
        return zzwVar2;
    }
}
