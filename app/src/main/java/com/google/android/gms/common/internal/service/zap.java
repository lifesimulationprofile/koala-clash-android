package com.google.android.gms.common.internal.service;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import androidx.appcompat.widget.AppCompatDrawableManager;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.TelemetryLoggingOptions;
import com.google.android.gms.internal.base.zaf;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zap extends GmsClient {
    public final TelemetryLoggingOptions zaa;

    public zap(Context context, Looper looper, AppCompatDrawableManager.AnonymousClass1 anonymousClass1, TelemetryLoggingOptions telemetryLoggingOptions, zabq zabqVar, zabq zabqVar2) {
        super(context, looper, 270, anonymousClass1, zabqVar, zabqVar2);
        this.zaa = telemetryLoggingOptions;
    }

    @Override // com.google.android.gms.common.internal.GmsClient
    public final IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.IClientTelemetryService");
        return iInterfaceQueryLocalInterface instanceof zai ? (zai) iInterfaceQueryLocalInterface : new zai(iBinder, "com.google.android.gms.common.internal.service.IClientTelemetryService", 0);
    }

    @Override // com.google.android.gms.common.internal.GmsClient
    public final Feature[] getApiFeatures() {
        return zaf.zab;
    }

    @Override // com.google.android.gms.common.internal.GmsClient
    public final Bundle getGetServiceRequestExtraArgs() {
        TelemetryLoggingOptions telemetryLoggingOptions = this.zaa;
        telemetryLoggingOptions.getClass();
        Bundle bundle = new Bundle();
        String str = telemetryLoggingOptions.zab;
        if (str != null) {
            bundle.putString("api", str);
        }
        return bundle;
    }

    @Override // com.google.android.gms.common.api.Api$Client
    public final int getMinApkVersion() {
        return 203400000;
    }

    @Override // com.google.android.gms.common.internal.GmsClient
    public final String getServiceDescriptor() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }

    @Override // com.google.android.gms.common.internal.GmsClient
    public final String getStartServiceAction() {
        return "com.google.android.gms.common.telemetry.service.START";
    }

    @Override // com.google.android.gms.common.internal.GmsClient
    public final boolean getUseDynamicLookup() {
        return true;
    }
}
