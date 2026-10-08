package com.google.mlkit.vision.common.internal;

import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.zzah;
import com.google.mlkit.vision.common.InputImage;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class BitmapInStreamingChecker {
    public static final GmsLogger zza = new GmsLogger(0, "StreamingFormatChecker", "");
    public final LinkedList zzb = new LinkedList();
    public long zzc = -1;

    public final void check(InputImage inputImage) {
        if (inputImage.zzg != -1) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Long lValueOf = Long.valueOf(jElapsedRealtime);
        LinkedList linkedList = this.zzb;
        linkedList.add(lValueOf);
        if (linkedList.size() > 5) {
            linkedList.removeFirst();
        }
        if (linkedList.size() == 5) {
            Long l = (Long) linkedList.peekFirst();
            zzah.checkNotNull(l);
            if (jElapsedRealtime - l.longValue() < 5000) {
                long j = this.zzc;
                if (j == -1 || jElapsedRealtime - j >= TimeUnit.SECONDS.toMillis(5L)) {
                    this.zzc = jElapsedRealtime;
                    GmsLogger gmsLogger = zza;
                    if (Log.isLoggable(gmsLogger.zza, 5)) {
                        Log.w("StreamingFormatChecker", gmsLogger.zza("ML Kit has detected that you seem to pass camera frames to the detector as a Bitmap object. This is inefficient. Please use YUV_420_888 format for camera2 API or NV21 format for (legacy) camera API and directly pass down the byte array to ML Kit."));
                    }
                }
            }
        }
    }
}
