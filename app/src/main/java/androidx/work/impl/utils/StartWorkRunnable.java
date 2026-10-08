package androidx.work.impl.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import androidx.camera.core.processing.Edge;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import androidx.core.provider.FontRequestWorker;
import androidx.work.Logger$LogcatLogger;
import androidx.work.SystemClock;
import androidx.work.Worker;
import androidx.work.impl.Processor;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.background.systemalarm.ConstraintProxy;
import androidx.work.impl.background.systemalarm.ConstraintProxyUpdateReceiver;
import coil.ImageLoader$Builder;
import coil.network.RealNetworkObserver;
import coil.request.RequestService;
import com.google.android.datatransport.cct.CctTransportBackend;
import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.mlkit_vision_common.zze;
import com.google.android.gms.internal.mlkit_vision_common.zziv;
import com.google.android.gms.internal.mlkit_vision_common.zzky;
import com.google.android.gms.internal.mlkit_vision_common.zzla;
import com.google.android.gms.internal.mlkit_vision_common.zzmj;
import com.google.android.gms.internal.mlkit_vision_common.zzn;
import com.google.android.gms.internal.mlkit_vision_common.zzp;
import com.google.android.gms.internal.mlkit_vision_common.zzu;
import com.google.mlkit.common.sdkinternal.CommonUtils;
import java.util.Arrays;
import java.util.Locale;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class StartWorkRunnable implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public Object processor;
    public Object runtimeExtras;
    public Object startStopToken;

    public /* synthetic */ StartWorkRunnable() {
        this.$r8$classId = 1;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002c  */
    @Override // java.lang.Runnable
    public final void run() {
        Object objCall;
        String str;
        zzu zzuVar;
        int i = 0;
        switch (this.$r8$classId) {
            case 0:
                ((Processor) this.processor).startWork((StartStopToken) this.startStopToken, (SystemClock) this.runtimeExtras);
                return;
            case 1:
                try {
                    objCall = ((FontRequestWorker.AnonymousClass1) this.processor).call();
                    break;
                } catch (Exception unused) {
                    objCall = null;
                }
                ((Handler) this.runtimeExtras).post(new Worker.AnonymousClass2(7, (Edge) this.startStopToken, objCall));
                return;
            case 2:
                BroadcastReceiver.PendingResult pendingResult = (BroadcastReceiver.PendingResult) this.runtimeExtras;
                Context context = (Context) this.startStopToken;
                Intent intent = (Intent) this.processor;
                try {
                    boolean booleanExtra = intent.getBooleanExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", false);
                    boolean booleanExtra2 = intent.getBooleanExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", false);
                    boolean booleanExtra3 = intent.getBooleanExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", false);
                    boolean booleanExtra4 = intent.getBooleanExtra("KEY_NETWORK_STATE_PROXY_ENABLED", false);
                    Logger$LogcatLogger.get().debug(ConstraintProxyUpdateReceiver.TAG, "Updating proxies: (BatteryNotLowProxy (" + booleanExtra + "), BatteryChargingProxy (" + booleanExtra2 + "), StorageNotLowProxy (" + booleanExtra3 + "), NetworkStateProxy (" + booleanExtra4 + "), ");
                    PackageManagerHelper.setComponentEnabled(context, ConstraintProxy.BatteryNotLowProxy.class, booleanExtra);
                    PackageManagerHelper.setComponentEnabled(context, ConstraintProxy.BatteryChargingProxy.class, booleanExtra2);
                    PackageManagerHelper.setComponentEnabled(context, ConstraintProxy.StorageNotLowProxy.class, booleanExtra3);
                    PackageManagerHelper.setComponentEnabled(context, ConstraintProxy.NetworkStateProxy.class, booleanExtra4);
                    return;
                } finally {
                    pendingResult.finish();
                }
            case 3:
                DefaultScheduler defaultScheduler = (DefaultScheduler) this.processor;
                AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) this.startStopToken;
                String str2 = autoValue_TransportContext.backendName;
                AutoValue_EventInternal autoValue_EventInternal = (AutoValue_EventInternal) this.runtimeExtras;
                Logger logger = DefaultScheduler.LOGGER;
                try {
                    TransportBackend transportBackend = defaultScheduler.backendRegistry.get(str2);
                    if (transportBackend == null) {
                        String str3 = "Transport backend '" + str2 + "' is not registered";
                        logger.warning(str3);
                        new IllegalArgumentException(str3);
                    } else {
                        ((SQLiteEventStore) defaultScheduler.guard).runCriticalSection(new ImageLoader$Builder(defaultScheduler, autoValue_TransportContext, ((CctTransportBackend) transportBackend).decorate(autoValue_EventInternal), 15));
                    }
                    return;
                } catch (Exception e) {
                    logger.warning("Error scheduling event " + e.getMessage());
                    return;
                }
            default:
                zzmj zzmjVar = (zzmj) this.processor;
                RequestService requestService = (RequestService) this.startStopToken;
                zziv zzivVar = zziv.zzbA;
                String str4 = (String) this.runtimeExtras;
                RealNetworkObserver realNetworkObserver = (RealNetworkObserver) requestService.systemCallbacks;
                realNetworkObserver.listener = zzivVar;
                zzla zzlaVar = (zzla) realNetworkObserver.connectivityManager;
                if (zzlaVar != null) {
                    str = zzlaVar.zzd;
                    int i2 = zze.$r8$clinit;
                    if (str == null || str.isEmpty()) {
                        str = "NA";
                    }
                } else {
                    str = "NA";
                }
                zzky zzkyVar = new zzky();
                zzkyVar.zza = zzmjVar.zzc;
                zzkyVar.zzb = zzmjVar.zzd;
                synchronized (zzmj.class) {
                    zzuVar = zzmj.zza;
                    if (zzuVar == null) {
                        LocaleListCompat locales = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
                        Object[] objArrCopyOf = new Object[4];
                        int i3 = 0;
                        while (i < locales.mImpl.size()) {
                            Locale locale = locales.mImpl.get(i);
                            GmsLogger gmsLogger = CommonUtils.zza;
                            String languageTag = locale.toLanguageTag();
                            languageTag.getClass();
                            int i4 = i3 + 1;
                            int length = objArrCopyOf.length;
                            if (length < i4) {
                                int i5 = length + (length >> 1) + 1;
                                if (i5 < i4) {
                                    int iHighestOneBit = Integer.highestOneBit(i3);
                                    i5 = iHighestOneBit + iHighestOneBit;
                                }
                                if (i5 < 0) {
                                    i5 = Integer.MAX_VALUE;
                                }
                                objArrCopyOf = Arrays.copyOf(objArrCopyOf, i5);
                            }
                            objArrCopyOf[i3] = languageTag;
                            i++;
                            i3 = i4;
                        }
                        zzn zznVar = zzp.zza;
                        zzuVar = i3 == 0 ? zzu.zza : new zzu(i3, objArrCopyOf);
                        zzmj.zza = zzuVar;
                    }
                }
                zzkyVar.zze = zzuVar;
                zzkyVar.zzh = Boolean.TRUE;
                zzkyVar.zzd = str;
                zzkyVar.zzc = str4;
                zzkyVar.zzf = zzmjVar.zzh.isSuccessful() ? (String) zzmjVar.zzh.getResult() : zzmjVar.zzf.getMlSdkInstanceId();
                zzkyVar.zzj = 10;
                zzkyVar.zzk = Integer.valueOf(zzmjVar.zzj);
                requestService.hardwareBitmapService = zzkyVar;
                zzmjVar.zze.zza(requestService);
                return;
        }
    }

    public /* synthetic */ StartWorkRunnable(zzmj zzmjVar, RequestService requestService, String str) {
        this.$r8$classId = 4;
        this.processor = zzmjVar;
        this.startStopToken = requestService;
        this.runtimeExtras = str;
    }

    public /* synthetic */ StartWorkRunnable(Object obj, Object obj2, Object obj3, int i) {
        this.$r8$classId = i;
        this.processor = obj;
        this.startStopToken = obj2;
        this.runtimeExtras = obj3;
    }
}
