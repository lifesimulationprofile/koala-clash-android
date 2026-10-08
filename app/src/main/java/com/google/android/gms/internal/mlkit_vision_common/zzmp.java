package com.google.android.gms.internal.mlkit_vision_common;

import android.content.Context;
import coil.ImageLoader$Builder;
import coil.network.RealNetworkObserver;
import coil.request.RequestService;
import com.google.android.datatransport.AutoValue_Event;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.TransportImpl;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.firebase.components.Lazy;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzmp implements zzmc {
    public final Lazy zzb;
    public final zzma zzc;

    public zzmp(Context context, zzma zzmaVar) {
        this.zzc = zzmaVar;
        CCTDestination cCTDestination = CCTDestination.INSTANCE;
        TransportRuntime.initialize(context);
        ImageLoader$Builder imageLoader$BuilderNewFactory = TransportRuntime.getInstance().newFactory(cCTDestination);
        if (CCTDestination.SUPPORTED_ENCODINGS.contains(new Encoding("json"))) {
            new Lazy(new zzmm(0, imageLoader$BuilderNewFactory));
        }
        this.zzb = new Lazy(new zzmm(3, imageLoader$BuilderNewFactory));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzmc
    public final void zza(RequestService requestService) {
        TransportImpl transportImpl = (TransportImpl) this.zzb.get();
        zzmw zzmwVar = zzmw.zza$1;
        RealNetworkObserver realNetworkObserver = (RealNetworkObserver) requestService.systemCallbacks;
        ((zzky) requestService.hardwareBitmapService).zzi = false;
        zzky zzkyVar = (zzky) requestService.hardwareBitmapService;
        zzkyVar.zzg = Boolean.FALSE;
        realNetworkObserver.connectivityManager = new zzla(zzkyVar);
        try {
            zzmw.zza();
            zziy zziyVar = new zziy(realNetworkObserver);
            ImageLoader$Builder imageLoader$Builder = new ImageLoader$Builder(17);
            zzmwVar.configure(imageLoader$Builder);
            HashMap map = new HashMap((HashMap) imageLoader$Builder.applicationContext);
            HashMap map2 = new HashMap((HashMap) imageLoader$Builder.defaults);
            zzaj zzajVar = (zzaj) imageLoader$Builder.options;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                zzak zzakVar = new zzak(byteArrayOutputStream, map, map2, zzajVar);
                ObjectEncoder objectEncoder = (ObjectEncoder) map.get(zziy.class);
                if (objectEncoder == null) {
                    throw new EncodingException("No encoder for ".concat(String.valueOf(zziy.class)));
                }
                objectEncoder.encode(zziyVar, zzakVar);
                transportImpl.send(new AutoValue_Event(byteArrayOutputStream.toByteArray(), Priority.VERY_LOW));
            } catch (IOException unused) {
            }
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e);
        }
    }
}
