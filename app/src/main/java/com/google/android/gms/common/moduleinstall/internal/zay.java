package com.google.android.gms.common.moduleinstall.internal;

import coil.memory.RealStrongMemoryCache;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.OptionalModuleApi;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;
import com.google.android.gms.signin.zaa;
import com.google.android.gms.tasks.zzw;
import com.google.mlkit.common.internal.zzd;
import com.google.zxing.qrcode.encoder.MinimalEncoder;
import java.util.Arrays;
import okhttp3.ConnectionPool;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zay extends GoogleApi {
    public static final RealStrongMemoryCache zae = new RealStrongMemoryCache("ModuleInstall.API", new zaa(2), new zzd());

    public final zzw areModulesAvailable(OptionalModuleApi... optionalModuleApiArr) {
        zzah.checkArgument("Please provide at least one OptionalModuleApi.", optionalModuleApiArr.length > 0);
        for (OptionalModuleApi optionalModuleApi : optionalModuleApiArr) {
            zzah.checkNotNull(optionalModuleApi, "Requested API must not be null.");
        }
        ApiFeatureRequest apiFeatureRequestZaa = ApiFeatureRequest.zaa(Arrays.asList(optionalModuleApiArr), false);
        if (apiFeatureRequestZaa.zab.isEmpty()) {
            ModuleAvailabilityResponse moduleAvailabilityResponse = new ModuleAvailabilityResponse(0, true);
            zzw zzwVar = new zzw();
            zzwVar.zzb(moduleAvailabilityResponse);
            return zzwVar;
        }
        MinimalEncoder minimalEncoder = new MinimalEncoder();
        minimalEncoder.encoders = new Feature[]{com.google.android.gms.internal.base.zaf.zaa$1};
        minimalEncoder.ecLevel = 27301;
        minimalEncoder.isGS1 = false;
        minimalEncoder.stringToEncode = new ConnectionPool(this, apiFeatureRequestZaa);
        return zae(0, minimalEncoder.build());
    }
}
