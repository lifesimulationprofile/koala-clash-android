package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import androidx.work.impl.StartStopTokens;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zac {
    public final int zac;

    public zac(int i) {
        this.zac = i;
    }

    public static Status zah(RemoteException remoteException) {
        return new Status(19, remoteException.getClass().getSimpleName() + ": " + remoteException.getLocalizedMessage(), null, null);
    }

    public abstract boolean zaa(zabq zabqVar);

    public abstract Feature[] zab(zabq zabqVar);

    public abstract void zad(Status status);

    public abstract void zae(Exception exc);

    public abstract void zaf(zabq zabqVar);

    public abstract void zag(StartStopTokens startStopTokens, boolean z);
}
