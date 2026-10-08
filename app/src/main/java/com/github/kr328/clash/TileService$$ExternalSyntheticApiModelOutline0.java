package com.github.kr328.clash;

import android.app.job.JobInfo;
import android.net.Uri;
import android.os.Build;
import android.os.LocaleList;
import com.google.android.gms.internal.mlkit_common.zzav;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class TileService$$ExternalSyntheticApiModelOutline0 {
    public static /* synthetic */ JobInfo.TriggerContentUri m(Uri uri, int i) {
        return new JobInfo.TriggerContentUri(uri, i);
    }

    public static /* bridge */ /* synthetic */ LocaleList m(Object obj) {
        return (LocaleList) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m802m() {
    }

    public static /* synthetic */ void m(zzav zzavVar) {
        boolean zIsTerminated;
        if ((Build.VERSION.SDK_INT <= 23 || zzavVar != ForkJoinPool.commonPool()) && !(zIsTerminated = zzavVar.isTerminated())) {
            zzavVar.shutdown();
            boolean z = false;
            while (!zIsTerminated) {
                try {
                    zIsTerminated = zzavVar.awaitTermination(1L, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z) {
                        zzavVar.shutdownNow();
                        z = true;
                    }
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
