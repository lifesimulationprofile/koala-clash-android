package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.os.SystemClock;
import androidx.collection.ArraySet;
import androidx.core.os.ExecutorCompat$HandlerExecutor;
import androidx.room.TransactionElement;
import coil.memory.RealStrongMemoryCache;
import com.caverock.androidsvg.SVG;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.gms.common.api.internal.zacd;
import com.google.android.gms.common.api.internal.zach;
import com.google.android.gms.common.api.internal.zag;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.zah;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.internal.base.zau;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.zzh;
import com.google.android.gms.tasks.zzw;
import com.google.zxing.qrcode.encoder.MinimalEncoder;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class GoogleApi {
    public final GoogleApiManager zaa;
    public final Context zab;
    public final String zac;
    public final RealStrongMemoryCache zad;
    public final Api$ApiOptions zae;
    public final ApiKey zaf;
    public final int zah;
    public final TransactionElement.Key zaj;

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Settings {
        public static final Settings DEFAULT_SETTINGS = new Settings(new TransactionElement.Key(15), Looper.getMainLooper());
        public final TransactionElement.Key zaa;

        public Settings(TransactionElement.Key key, Looper looper) {
            this.zaa = key;
        }
    }

    public GoogleApi(Context context, RealStrongMemoryCache realStrongMemoryCache, Api$ApiOptions api$ApiOptions, Settings settings) {
        zzah.checkNotNull(context, "Null context is not permitted.");
        zzah.checkNotNull(realStrongMemoryCache, "Api must not be null.");
        zzah.checkNotNull(settings, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context applicationContext = context.getApplicationContext();
        zzah.checkNotNull(applicationContext, "The provided context did not have an application context.");
        this.zab = applicationContext;
        String attributionTag = Build.VERSION.SDK_INT >= 30 ? context.getAttributionTag() : null;
        this.zac = attributionTag;
        this.zad = realStrongMemoryCache;
        this.zae = api$ApiOptions;
        this.zaf = new ApiKey(realStrongMemoryCache, api$ApiOptions, attributionTag);
        GoogleApiManager googleApiManagerZak = GoogleApiManager.zak(applicationContext);
        this.zaa = googleApiManagerZak;
        this.zah = googleApiManagerZak.zal.getAndIncrement();
        this.zaj = settings.zaa;
        zau zauVar = googleApiManagerZak.zar;
        zauVar.sendMessage(zauVar.obtainMessage(7, this));
    }

    public final SVG createClientSettingsBuilder() {
        SVG svg = new SVG(17);
        Set set = Collections.EMPTY_SET;
        if (((ArraySet) svg.rootElement) == null) {
            svg.rootElement = new ArraySet(0);
        }
        ((ArraySet) svg.rootElement).addAll(set);
        Context context = this.zab;
        svg.idToElementMap = context.getClass().getName();
        svg.cssRules = context.getPackageName();
        return svg;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0054  */
    public final zzw zae(int i, MinimalEncoder minimalEncoder) {
        zacd zacdVar;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        TransactionElement.Key key = this.zaj;
        GoogleApiManager googleApiManager = this.zaa;
        googleApiManager.getClass();
        int i2 = minimalEncoder.ecLevel;
        if (i2 != 0) {
            ApiKey apiKey = this.zaf;
            if (googleApiManager.zaD()) {
                RootTelemetryConfiguration rootTelemetryConfiguration = (RootTelemetryConfiguration) zah.getInstance().zaa;
                boolean z = true;
                if (rootTelemetryConfiguration != null) {
                    if (rootTelemetryConfiguration.zzb) {
                        boolean z2 = rootTelemetryConfiguration.zzc;
                        zabq zabqVar = (zabq) googleApiManager.zan.get(apiKey);
                        if (zabqVar != null) {
                            Api$Client api$Client = zabqVar.zac;
                            if (api$Client instanceof GmsClient) {
                                GmsClient gmsClient = (GmsClient) api$Client;
                                if (gmsClient.zzD == null || gmsClient.isConnecting()) {
                                    z = z2;
                                } else {
                                    ConnectionTelemetryConfiguration connectionTelemetryConfigurationZab = zacd.zab(zabqVar, gmsClient, i2);
                                    if (connectionTelemetryConfigurationZab != null) {
                                        zabqVar.zam++;
                                        z = connectionTelemetryConfigurationZab.zzc;
                                    }
                                }
                            }
                        } else {
                            z = z2;
                        }
                    }
                    zacdVar = null;
                }
                zacdVar = new zacd(googleApiManager, i2, apiKey, z ? System.currentTimeMillis() : 0L, z ? SystemClock.elapsedRealtime() : 0L);
            } else {
                zacdVar = null;
            }
            if (zacdVar != null) {
                zzw zzwVar = taskCompletionSource.zza;
                zau zauVar = googleApiManager.zar;
                zauVar.getClass();
                ExecutorCompat$HandlerExecutor executorCompat$HandlerExecutor = new ExecutorCompat$HandlerExecutor(zauVar, 1);
                zzwVar.getClass();
                zzwVar.zzb.zza(new zzh(executorCompat$HandlerExecutor, zacdVar));
                zzwVar.zzi();
            }
        }
        zach zachVar = new zach(new zag(i, minimalEncoder, taskCompletionSource, key), googleApiManager.zam.get(), this);
        zau zauVar2 = googleApiManager.zar;
        zauVar2.sendMessage(zauVar2.obtainMessage(4, zachVar));
        return taskCompletionSource.zza;
    }
}
