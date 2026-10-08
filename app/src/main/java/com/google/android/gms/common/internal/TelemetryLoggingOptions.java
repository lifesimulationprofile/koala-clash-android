package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.Api$ApiOptions;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class TelemetryLoggingOptions implements Api$ApiOptions {
    public static final TelemetryLoggingOptions zaa = new TelemetryLoggingOptions(null);
    public final String zab;

    public /* synthetic */ TelemetryLoggingOptions(String str) {
        this.zab = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof TelemetryLoggingOptions) {
            return zzah.equal(this.zab, ((TelemetryLoggingOptions) obj).zab);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zab});
    }
}
