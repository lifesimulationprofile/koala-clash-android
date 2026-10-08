package androidx.compose.material3.internal.ripple;

import com.google.android.gms.internal.mlkit_vision_barcode.zzsc;
import com.google.android.gms.internal.mlkit_vision_barcode.zzsd;
import com.google.android.gms.internal.mlkit_vision_barcode.zzse;
import com.google.android.gms.internal.mlkit_vision_barcode.zzsf;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class RippleNodeConfig {
    public final zzsc drag;
    public final zzsd focus;
    public final zzse hover;
    public final zzsf press;

    public RippleNodeConfig(zzsf zzsfVar, zzsd zzsdVar, zzse zzseVar, zzsc zzscVar) {
        this.press = zzsfVar;
        this.focus = zzsdVar;
        this.hover = zzseVar;
        this.drag = zzscVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RippleNodeConfig)) {
            return false;
        }
        RippleNodeConfig rippleNodeConfig = (RippleNodeConfig) obj;
        return Intrinsics.areEqual(this.press, rippleNodeConfig.press) && Intrinsics.areEqual(this.focus, rippleNodeConfig.focus) && Intrinsics.areEqual(this.hover, rippleNodeConfig.hover) && Intrinsics.areEqual(this.drag, rippleNodeConfig.drag);
    }

    public final int hashCode() {
        return this.drag.hashCode() + ((this.hover.hashCode() + ((this.focus.hashCode() + (this.press.hashCode() * 31)) * 31)) * 31);
    }
}
