package com.google.android.gms.signin;

import com.google.android.gms.common.api.Api$ApiOptions;
import com.google.android.gms.common.internal.zzah;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class SignInOptions implements Api$ApiOptions {
    public static final SignInOptions zaa = new SignInOptions();

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof SignInOptions) && zzah.equal(null, null) && zzah.equal(null, null) && zzah.equal(null, null) && zzah.equal(null, null) && zzah.equal(null, null);
    }

    public final int hashCode() {
        Boolean bool = Boolean.FALSE;
        return Arrays.hashCode(new Object[]{bool, bool, null, bool, bool, null, null, null, null});
    }
}
