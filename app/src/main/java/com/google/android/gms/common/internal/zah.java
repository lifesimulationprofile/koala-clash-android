package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.signin.internal.SignInClientImpl;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zah implements BaseGmsClient$ConnectionProgressReportCallbacks {
    public static zah zza;
    public static final RootTelemetryConfiguration zzb = new RootTelemetryConfiguration(0, 0, 0, false, false);
    public Object zaa;

    public /* synthetic */ zah(Object obj) {
        this.zaa = obj;
    }

    public static synchronized zah getInstance() {
        try {
            if (zza == null) {
                zza = new zah();
            }
        } catch (Throwable th) {
            throw th;
        }
        return zza;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient$ConnectionProgressReportCallbacks
    public void onReportServiceBinding(ConnectionResult connectionResult) {
        SignInClientImpl signInClientImpl = (SignInClientImpl) this.zaa;
        if (connectionResult.zzb == 0) {
            signInClientImpl.getRemoteService(null, ((GmsClient) signInClientImpl).zac);
            return;
        }
        zah zahVar = signInClientImpl.zzx;
        if (zahVar != null) {
            ((GoogleApiClient.OnConnectionFailedListener) zahVar.zaa).onConnectionFailed(connectionResult);
        }
    }
}
