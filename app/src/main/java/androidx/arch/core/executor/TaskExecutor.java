package androidx.arch.core.executor;

import androidx.customview.poolingcontainer.PoolingContainer;
import com.google.android.gms.internal.mlkit_vision_barcode.zzwd;
import com.google.android.gms.internal.mlkit_vision_barcode.zzwp;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.barcode.internal.zzb;
import com.google.mlkit.vision.barcode.internal.zzg;
import com.google.mlkit.vision.barcode.internal.zzh;
import com.google.mlkit.vision.barcode.internal.zzl;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TaskExecutor {
    public static zzh getClient(BarcodeScannerOptions barcodeScannerOptions) {
        zzwp zzwpVarZza;
        zzg zzgVar = (zzg) MlKitContext.getInstance().get(zzg.class);
        zzl zzlVar = (zzl) zzgVar.zza.get(barcodeScannerOptions);
        Executor executor = (Executor) zzgVar.zzb.zza.get();
        String str = true != zzb.zzf() ? "play-services-mlkit-barcode-scanning" : "barcode-scanning";
        synchronized (PoolingContainer.class) {
            byte b = (byte) (((byte) 1) | 2);
            try {
                if (b != 3) {
                    StringBuilder sb = new StringBuilder();
                    if ((b & 1) == 0) {
                        sb.append(" enableFirelog");
                    }
                    if ((b & 2) == 0) {
                        sb.append(" firelogEventType");
                    }
                    throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
                }
                zzwpVarZza = PoolingContainer.zza(new zzwd(str, 1));
            } catch (Throwable th) {
                throw th;
            }
        }
        return new zzh(barcodeScannerOptions, zzlVar, executor, zzwpVarZza);
    }
}
