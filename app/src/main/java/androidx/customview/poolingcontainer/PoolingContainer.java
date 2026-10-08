package androidx.customview.poolingcontainer;

import android.view.View;
import com.google.android.gms.internal.mlkit_common.zzsr;
import com.google.android.gms.internal.mlkit_vision_barcode.zzwd;
import com.google.android.gms.internal.mlkit_vision_barcode.zzwp;
import com.koala.clash.R;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class PoolingContainer {
    public static zzsr zza;

    public static final PoolingContainerListenerHolder getPoolingContainerListenerHolder(View view) {
        PoolingContainerListenerHolder poolingContainerListenerHolder = (PoolingContainerListenerHolder) view.getTag(R.id.pooling_container_listener_holder_tag);
        if (poolingContainerListenerHolder != null) {
            return poolingContainerListenerHolder;
        }
        PoolingContainerListenerHolder poolingContainerListenerHolder2 = new PoolingContainerListenerHolder();
        view.setTag(R.id.pooling_container_listener_holder_tag, poolingContainerListenerHolder2);
        return poolingContainerListenerHolder2;
    }

    public static synchronized zzwp zza(zzwd zzwdVar) {
        try {
            if (zza == null) {
                zza = new zzsr(1);
            }
        } catch (Throwable th) {
            throw th;
        }
        return (zzwp) zza.get(zzwdVar);
    }
}
