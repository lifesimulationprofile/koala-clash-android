package com.google.mlkit.common.sdkinternal;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzd extends PhantomReference {
    public final Set zza;
    public final zza zzb;

    public /* synthetic */ zzd(Cleaner cleaner, ReferenceQueue referenceQueue, Set set, zza zzaVar) {
        super(cleaner, referenceQueue);
        this.zza = set;
        this.zzb = zzaVar;
    }
}
