package com.google.android.gms.dynamite;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService;
import androidx.compose.ui.platform.AndroidUiDispatcher;
import androidx.core.os.HandlerCompat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Random;
import kotlin.collections.SetsKt;
import kotlin.coroutines.CoroutineContext;
import okhttp3.internal.Util;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzd extends ThreadLocal {
    public final /* synthetic */ int $r8$classId;

    @Override // java.lang.ThreadLocal
    public final Object initialValue() {
        switch (this.$r8$classId) {
            case 0:
                return 0L;
            case 1:
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    return SetsKt.mainThreadExecutor();
                }
                if (Looper.myLooper() != null) {
                    return new HandlerScheduledExecutorService(new Handler(Looper.myLooper()));
                }
                return null;
            case 2:
                Choreographer choreographer = Choreographer.getInstance();
                Looper looperMyLooper = Looper.myLooper();
                if (looperMyLooper == null) {
                    throw new IllegalStateException("no Looper on this thread");
                }
                AndroidUiDispatcher androidUiDispatcher = new AndroidUiDispatcher(choreographer, HandlerCompat.createAsync(looperMyLooper));
                return CoroutineContext.DefaultImpls.plus(androidUiDispatcher, androidUiDispatcher.frameClock);
            case 3:
                return new Random();
            default:
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
                simpleDateFormat.setLenient(false);
                simpleDateFormat.setTimeZone(Util.UTC);
                return simpleDateFormat;
        }
    }
}
