package com.google.android.gms.common.moduleinstall;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentState;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.zzli;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ModuleInstallIntentResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ModuleInstallIntentResponse> CREATOR = new FragmentState.AnonymousClass1(28);
    public final PendingIntent zaa;

    public ModuleInstallIntentResponse(PendingIntent pendingIntent) {
        this.zaa = pendingIntent;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = zzli.zza(parcel, 20293);
        zzli.writeParcelable(parcel, 1, this.zaa, i);
        zzli.zzb(parcel, iZza);
    }
}
