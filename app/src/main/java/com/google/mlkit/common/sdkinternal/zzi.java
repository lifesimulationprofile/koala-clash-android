package com.google.mlkit.common.sdkinternal;

import com.google.android.gms.common.internal.zzah;
import java.util.ArrayDeque;
import java.util.Deque;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zzi implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Runnable zza;

    public /* synthetic */ zzi(Runnable runnable, int i) {
        this.$r8$classId = i;
        this.zza = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                Deque deque = (Deque) MlKitThreadPool.zza.get();
                zzah.checkNotNull(deque);
                Runnable runnable = this.zza;
                deque.add(runnable);
                if (deque.size() <= 1) {
                    do {
                        runnable.run();
                        deque.removeFirst();
                        runnable = (Runnable) deque.peekFirst();
                    } while (runnable != null);
                }
                break;
            default:
                MlKitThreadPool.zza.set(new ArrayDeque());
                this.zza.run();
                break;
        }
    }
}
