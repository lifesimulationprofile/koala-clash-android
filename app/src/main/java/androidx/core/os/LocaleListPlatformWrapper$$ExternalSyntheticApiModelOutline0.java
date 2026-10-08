package androidx.core.os;

import android.hardware.camera2.params.OutputConfiguration;
import android.os.Build;
import android.os.LocaleList;
import android.text.style.LocaleSpan;
import androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class LocaleListPlatformWrapper$$ExternalSyntheticApiModelOutline0 {
    public static /* bridge */ /* synthetic */ OutputConfiguration m(Object obj) {
        return (OutputConfiguration) obj;
    }

    public static /* synthetic */ LocaleList m(Locale[] localeArr) {
        return new LocaleList(localeArr);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ LocaleSpan m742m(LocaleList localeList) {
        return new LocaleSpan(localeList);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m744m() {
    }

    public static /* synthetic */ void m(HandlerScheduledExecutorService handlerScheduledExecutorService) {
        if (Build.VERSION.SDK_INT <= 23 || handlerScheduledExecutorService != ForkJoinPool.commonPool()) {
            handlerScheduledExecutorService.shutdown();
            throw null;
        }
    }

    public static /* synthetic */ void m(ExecutorService executorService) {
        boolean zIsTerminated;
        if ((Build.VERSION.SDK_INT <= 23 || executorService != ForkJoinPool.commonPool()) && !(zIsTerminated = executorService.isTerminated())) {
            executorService.shutdown();
            boolean z = false;
            while (!zIsTerminated) {
                try {
                    zIsTerminated = executorService.awaitTermination(1L, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z) {
                        executorService.shutdownNow();
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
