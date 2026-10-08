package com.google.mlkit.common.sdkinternal;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import coil.memory.EmptyStrongMemoryCache;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api$ApiOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;
import com.google.android.gms.common.moduleinstall.internal.ApiFeatureRequest;
import com.google.android.gms.common.moduleinstall.internal.zay;
import com.google.android.gms.internal.base.zaf;
import com.google.android.gms.internal.mlkit_common.zzag;
import com.google.android.gms.internal.mlkit_common.zzaq;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.zzw;
import com.google.zxing.qrcode.encoder.MinimalEncoder;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class OptionalModuleUtils {
    public static final Feature[] EMPTY_FEATURES = new Feature[0];
    public static final Feature FEATURE_BARCODE;
    public static final zzaq zza;
    public static final zzaq zzb;

    static {
        Feature feature = new Feature("vision.barcode", 1L);
        FEATURE_BARCODE = feature;
        Feature feature2 = new Feature("vision.custom.ica", 1L);
        Feature feature3 = new Feature("vision.face", 1L);
        Feature feature4 = new Feature("vision.ica", 1L);
        Feature feature5 = new Feature("vision.ocr", 1L);
        Feature feature6 = new Feature("mlkit.langid", 1L);
        Feature feature7 = new Feature("mlkit.nlclassifier", 1L);
        Feature feature8 = new Feature("tflite_dynamite", 1L);
        Feature feature9 = new Feature("mlkit.barcode.ui", 1L);
        Feature feature10 = new Feature("mlkit.smartreply", 1L);
        StatusLine statusLine = new StatusLine(10);
        statusLine.zza("barcode", feature);
        statusLine.zza("custom_ica", feature2);
        statusLine.zza("face", feature3);
        statusLine.zza("ica", feature4);
        statusLine.zza("ocr", feature5);
        statusLine.zza("langid", feature6);
        statusLine.zza("nlclassifier", feature7);
        statusLine.zza("tflite_dynamite", feature8);
        statusLine.zza("barcode_ui", feature9);
        statusLine.zza("smart_reply", feature10);
        zzag zzagVar = (zzag) statusLine.message;
        if (zzagVar != null) {
            throw zzagVar.zza();
        }
        zzaq zzaqVarZzg = zzaq.zzg(statusLine.code, (Object[]) statusLine.protocol, statusLine);
        zzag zzagVar2 = (zzag) statusLine.message;
        if (zzagVar2 != null) {
            throw zzagVar2.zza();
        }
        zza = zzaqVarZzg;
        StatusLine statusLine2 = new StatusLine(10);
        statusLine2.zza("com.google.android.gms.vision.barcode", feature);
        statusLine2.zza("com.google.android.gms.vision.custom.ica", feature2);
        statusLine2.zza("com.google.android.gms.vision.face", feature3);
        statusLine2.zza("com.google.android.gms.vision.ica", feature4);
        statusLine2.zza("com.google.android.gms.vision.ocr", feature5);
        statusLine2.zza("com.google.android.gms.mlkit.langid", feature6);
        statusLine2.zza("com.google.android.gms.mlkit.nlclassifier", feature7);
        statusLine2.zza("com.google.android.gms.tflite_dynamite", feature8);
        statusLine2.zza("com.google.android.gms.mlkit_smartreply", feature10);
        zzag zzagVar3 = (zzag) statusLine2.message;
        if (zzagVar3 != null) {
            throw zzagVar3.zza();
        }
        zzaq zzaqVarZzg2 = zzaq.zzg(statusLine2.code, (Object[]) statusLine2.protocol, statusLine2);
        zzag zzagVar4 = (zzag) statusLine2.message;
        if (zzagVar4 != null) {
            throw zzagVar4.zza();
        }
        zzb = zzaqVarZzg2;
    }

    public static void requestDownload(Context context, List list) {
        zzw zzwVarZae;
        GoogleApiAvailabilityLight.zza.getClass();
        if (GoogleApiAvailabilityLight.getApkVersion(context) < 221500000) {
            Intent intent = new Intent();
            intent.setClassName("com.google.android.gms", "com.google.android.gms.vision.DependencyBroadcastReceiverProxy");
            intent.setAction("com.google.android.gms.vision.DEPENDENCY");
            intent.putExtra("com.google.android.gms.vision.DEPENDENCIES", TextUtils.join(",", list));
            intent.putExtra("requester_app_package", context.getApplicationInfo().packageName);
            context.sendBroadcast(intent);
            return;
        }
        Feature[] featureArrZza = zza(zza, list);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new zzo(featureArrZza, 0));
        zzah.checkArgument("APIs must not be empty.", !arrayList.isEmpty());
        zay zayVar = new zay(context, zay.zae, Api$ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
        ApiFeatureRequest apiFeatureRequestZaa = ApiFeatureRequest.zaa(arrayList, true);
        if (apiFeatureRequestZaa.zab.isEmpty()) {
            ModuleInstallResponse moduleInstallResponse = new ModuleInstallResponse(0, false);
            zzwVarZae = new zzw();
            zzwVarZae.zzb(moduleInstallResponse);
        } else {
            MinimalEncoder minimalEncoder = new MinimalEncoder();
            minimalEncoder.encoders = new Feature[]{zaf.zaa$1};
            minimalEncoder.isGS1 = true;
            minimalEncoder.ecLevel = 27304;
            minimalEncoder.stringToEncode = new EmptyStrongMemoryCache(zayVar, apiFeatureRequestZaa);
            zzwVarZae = zayVar.zae(0, minimalEncoder.build());
        }
        com.google.mlkit.common.internal.zzd zzdVar = new com.google.mlkit.common.internal.zzd();
        zzwVarZae.getClass();
        zzwVarZae.addOnFailureListener(TaskExecutors.MAIN_THREAD, zzdVar);
    }

    public static Feature[] zza(zzaq zzaqVar, List list) {
        Feature[] featureArr = new Feature[list.size()];
        for (int i = 0; i < list.size(); i++) {
            Feature feature = (Feature) zzaqVar.get(list.get(i));
            zzah.checkNotNull(feature);
            featureArr[i] = feature;
        }
        return featureArr;
    }
}
