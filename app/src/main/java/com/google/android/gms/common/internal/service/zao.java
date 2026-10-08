package com.google.android.gms.common.internal.service;

import coil.memory.EmptyStrongMemoryCache;
import coil.memory.RealStrongMemoryCache;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.internal.base.zaf;
import com.google.android.gms.signin.zaa;
import com.google.android.gms.tasks.zzw;
import com.google.mlkit.common.internal.zzd;
import com.google.zxing.qrcode.encoder.MinimalEncoder;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zao extends GoogleApi {
    public static final RealStrongMemoryCache zae = new RealStrongMemoryCache("ClientTelemetry.API", new zaa(1), new zzd());

    public final zzw log(TelemetryData telemetryData) {
        MinimalEncoder minimalEncoder = new MinimalEncoder();
        minimalEncoder.ecLevel = 0;
        minimalEncoder.encoders = new Feature[]{zaf.zaa};
        minimalEncoder.isGS1 = false;
        minimalEncoder.stringToEncode = new EmptyStrongMemoryCache(27, telemetryData);
        return zae(2, minimalEncoder.build());
    }
}
