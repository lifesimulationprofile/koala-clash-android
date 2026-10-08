package com.google.android.gms.signin.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import androidx.appcompat.widget.AppCompatDrawableManager;
import com.google.android.gms.common.api.Api$Client;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.GmsClient;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class SignInClientImpl extends GmsClient implements Api$Client {
    public final boolean zab;
    public final AppCompatDrawableManager.AnonymousClass1 zac;
    public final Bundle zad;
    public final Integer zae;

    public SignInClientImpl(Context context, Looper looper, AppCompatDrawableManager.AnonymousClass1 anonymousClass1, Bundle bundle, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 44, anonymousClass1, connectionCallbacks, onConnectionFailedListener);
        this.zab = true;
        this.zac = anonymousClass1;
        this.zad = bundle;
        this.zae = (Integer) anonymousClass1.TINT_CHECKABLE_BUTTON_LIST;
    }

    @Override // com.google.android.gms.common.internal.GmsClient
    public final IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return iInterfaceQueryLocalInterface instanceof zaf ? (zaf) iInterfaceQueryLocalInterface : new zaf(iBinder, "com.google.android.gms.signin.internal.ISignInService", 0);
    }

    @Override // com.google.android.gms.common.internal.GmsClient
    public final Bundle getGetServiceRequestExtraArgs() {
        AppCompatDrawableManager.AnonymousClass1 anonymousClass1 = this.zac;
        boolean zEquals = this.zzl.getPackageName().equals((String) anonymousClass1.COLORFILTER_COLOR_CONTROL_ACTIVATED);
        Bundle bundle = this.zad;
        if (!zEquals) {
            bundle.putString("com.google.android.gms.signin.internal.realClientPackageName", (String) anonymousClass1.COLORFILTER_COLOR_CONTROL_ACTIVATED);
        }
        return bundle;
    }

    @Override // com.google.android.gms.common.api.Api$Client
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.GmsClient
    public final String getServiceDescriptor() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.GmsClient
    public final String getStartServiceAction() {
        return "com.google.android.gms.signin.service.START";
    }

    @Override // com.google.android.gms.common.internal.GmsClient, com.google.android.gms.common.api.Api$Client
    public final boolean requiresSignIn() {
        return this.zab;
    }
}
