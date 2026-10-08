package com.google.android.gms.signin;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import com.google.android.gms.common.api.Api$Client;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.gms.common.internal.TelemetryLoggingOptions;
import com.google.android.gms.common.internal.service.zap;
import com.google.android.gms.common.moduleinstall.internal.zaz;
import com.google.android.gms.signin.internal.SignInClientImpl;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zaa {
    public final /* synthetic */ int $r8$classId;

    public Api$Client buildClient(Context context, Looper looper, AppCompatDrawableManager.AnonymousClass1 anonymousClass1, Object obj, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        switch (this.$r8$classId) {
            case 0:
                anonymousClass1.getClass();
                Integer num = (Integer) anonymousClass1.TINT_CHECKABLE_BUTTON_LIST;
                Bundle bundle = new Bundle();
                bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", null);
                if (num != null) {
                    bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", num.intValue());
                }
                bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
                bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
                bundle.putString("com.google.android.gms.signin.internal.serverClientId", null);
                bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
                bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
                bundle.putString("com.google.android.gms.signin.internal.hostedDomain", null);
                bundle.putString("com.google.android.gms.signin.internal.logSessionId", null);
                bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
                return new SignInClientImpl(context, looper, anonymousClass1, bundle, connectionCallbacks, onConnectionFailedListener);
            case 3:
                throw ImageAnalysis$$ExternalSyntheticLambda1.m(obj);
            default:
                zabq zabqVar = (zabq) connectionCallbacks;
                zabq zabqVar2 = (zabq) onConnectionFailedListener;
                switch (this.$r8$classId) {
                    case 1:
                        return new zap(context, looper, anonymousClass1, (TelemetryLoggingOptions) obj, zabqVar, zabqVar2);
                    case 2:
                        return new zaz(context, looper, 308, anonymousClass1, zabqVar, zabqVar2);
                    default:
                        throw new UnsupportedOperationException("buildClient must be implemented");
                }
        }
    }
}
