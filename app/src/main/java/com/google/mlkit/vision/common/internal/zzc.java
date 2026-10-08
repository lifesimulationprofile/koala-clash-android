package com.google.mlkit.vision.common.internal;

import android.util.Log;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgq;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.RestrictedComponentContainer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zzc implements OnFailureListener, ComponentFactory {
    public static final /* synthetic */ zzc zza = new zzc();
    public static final /* synthetic */ zzc zza$1 = new zzc();

    @Override // com.google.firebase.components.ComponentFactory
    public Object create(RestrictedComponentContainer restrictedComponentContainer) {
        Set of = restrictedComponentContainer.setOf(zzgq.class);
        zzc zzcVar = new zzc();
        new HashMap();
        new HashMap();
        Iterator it = of.iterator();
        if (!it.hasNext()) {
            return zzcVar;
        }
        it.next().getClass();
        throw new ClassCastException();
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        GmsLogger gmsLogger = MobileVisionBase.zzb;
        if (Log.isLoggable(gmsLogger.zza, 6)) {
            Log.e("MobileVisionBase", gmsLogger.zza("Error preloading model resource"), exc);
        }
    }
}
