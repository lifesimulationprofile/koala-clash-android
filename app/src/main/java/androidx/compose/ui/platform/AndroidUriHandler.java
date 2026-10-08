package androidx.compose.ui.platform;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.zzj;
import com.google.android.gms.common.zzk;
import com.google.android.gms.common.zzm;
import com.google.android.gms.common.zzn;
import com.google.android.gms.internal.mlkit_vision_common.zzmm;
import com.google.firebase.components.OptionalProvider$$Lambda$4;
import com.google.mlkit.common.internal.MlKitComponentDiscoveryService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidUriHandler {
    public static AndroidUriHandler zza;
    public final Context context;

    public AndroidUriHandler(Context context, int i) {
        switch (i) {
            case 1:
                this.context = context.getApplicationContext();
                break;
            case 2:
                this.context = context.getApplicationContext();
                break;
            default:
                this.context = context;
                break;
        }
    }

    public static void getInstance(Context context) {
        zzah.checkNotNull(context);
        synchronized (AndroidUriHandler.class) {
            try {
                if (zza == null) {
                    zzn.zze(context);
                    zza = new AndroidUriHandler(context, 1);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static final zzj zza(PackageInfo packageInfo, zzj... zzjVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null) {
            if (signatureArr.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            zzk zzkVar = new zzk(packageInfo.signatures[0].toByteArray());
            for (int i = 0; i < zzjVarArr.length; i++) {
                if (zzjVarArr[i].equals(zzkVar)) {
                    return zzjVarArr[i];
                }
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0036  */
    /* JADX WARN: Code duplicated, block: B:24:0x003d  */
    /* JADX WARN: Code duplicated, block: B:26:0x004b A[RETURN] */
    public static final boolean zzb(PackageInfo packageInfo) {
        PackageInfo packageInfo2;
        boolean z;
        zzj zzjVarZza;
        if (packageInfo != null) {
            if ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName)) {
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                z = (applicationInfo == null || (applicationInfo.flags & 129) == 0) ? false : true;
                packageInfo2 = packageInfo;
            } else {
                packageInfo2 = packageInfo;
            }
            if (packageInfo != null && packageInfo2.signatures != null) {
                if (z) {
                    zzjVarZza = zza(packageInfo2, zzm.zza);
                } else {
                    zzjVarZza = zza(packageInfo2, zzm.zza[0]);
                }
                if (zzjVarZza != null) {
                    return true;
                }
            }
            return false;
        }
        packageInfo2 = null;
        z = true;
        if (packageInfo != null) {
            if (z) {
                zzjVarZza = zza(packageInfo2, zzm.zza);
            } else {
                zzjVarZza = zza(packageInfo2, zzm.zza[0]);
            }
            if (zzjVarZza != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.util.List] */
    public ArrayList discoverLazy() {
        ?? arrayList;
        ArrayList arrayList2 = new ArrayList();
        Context context = this.context;
        Bundle bundle = null;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                Log.w("ComponentDiscovery", "Context has no PackageManager.");
            } else {
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) MlKitComponentDiscoveryService.class), 128);
                if (serviceInfo == null) {
                    Log.w("ComponentDiscovery", MlKitComponentDiscoveryService.class + " has no service info.");
                } else {
                    bundle = serviceInfo.metaData;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
            Log.w("ComponentDiscovery", "Application info not found.");
        }
        if (bundle == null) {
            Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
            arrayList = Collections.EMPTY_LIST;
        } else {
            arrayList = new ArrayList();
            for (String str : bundle.keySet()) {
                if ("com.google.firebase.components.ComponentRegistrar".equals(bundle.get(str)) && str.startsWith("com.google.firebase.components:")) {
                    arrayList.add(str.substring(31));
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new zzmm(4, (String) it.next()));
        }
        return arrayList2;
    }

    public AndroidUriHandler(Context context, OptionalProvider$$Lambda$4 optionalProvider$$Lambda$4) {
        this.context = context;
    }
}
