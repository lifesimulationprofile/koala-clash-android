package androidx.core.os;

import android.content.res.Configuration;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ConfigurationCompat {
    public static LocaleListCompat getLocales(Configuration configuration) {
        return Build.VERSION.SDK_INT >= 24 ? new LocaleListCompat(new LocaleListPlatformWrapper(LocaleListCompat.Api24Impl.getLocales(configuration))) : LocaleListCompat.create(configuration.locale);
    }
}
