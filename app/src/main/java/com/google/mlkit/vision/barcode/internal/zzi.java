package com.google.mlkit.vision.barcode.internal;

import android.content.Context;
import androidx.customview.poolingcontainer.PoolingContainer;
import androidx.lifecycle.Lifecycle;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.barcode.ModuleDescriptor;
import com.google.android.gms.internal.mlkit_vision_barcode.zzah;
import com.google.android.gms.internal.mlkit_vision_barcode.zzdk;
import com.google.android.gms.internal.mlkit_vision_barcode.zzwd;
import com.google.android.gms.internal.mlkit_vision_barcode.zzwp;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import okhttp3.internal.connection.Exchange;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzi extends Lifecycle {
    public final MlKitContext zza;

    public zzi(MlKitContext mlKitContext) {
        super(5);
        this.zza = mlKitContext;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0041  */
    @Override // androidx.lifecycle.Lifecycle
    public final Object create(Object obj) {
        zzwp zzwpVarZza;
        zzm zzoVar;
        MlKitContext mlKitContext = this.zza;
        BarcodeScannerOptions barcodeScannerOptions = (BarcodeScannerOptions) obj;
        Context applicationContext = mlKitContext.getApplicationContext();
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
        zzdk zzdkVar = zzo.zza;
        if (DynamiteModule.getLocalVersion(applicationContext, ModuleDescriptor.MODULE_ID) > 0) {
            zzoVar = new zzo(applicationContext, barcodeScannerOptions, zzwpVarZza);
        } else {
            GoogleApiAvailabilityLight.zza.getClass();
            if (GoogleApiAvailabilityLight.getApkVersion(applicationContext) >= 204500000) {
                zzoVar = new zzo(applicationContext, barcodeScannerOptions, zzwpVarZza);
            } else {
                Exchange exchange = new Exchange();
                zzah zzahVar = new zzah();
                exchange.finder = zzahVar;
                exchange.call = applicationContext;
                zzahVar.zza = barcodeScannerOptions.zza;
                exchange.codec = zzwpVarZza;
                zzoVar = exchange;
            }
        }
        return new zzl(mlKitContext, barcodeScannerOptions, zzoVar, zzwpVarZza);
    }
}
