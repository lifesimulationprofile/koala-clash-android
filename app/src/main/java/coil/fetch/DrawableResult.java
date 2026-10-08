package coil.fetch;

import android.graphics.drawable.Drawable;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class DrawableResult extends FetchResult {
    public final int dataSource;
    public final Drawable drawable;
    public final boolean isSampled;

    public DrawableResult(Drawable drawable, boolean z, int i) {
        this.drawable = drawable;
        this.isSampled = z;
        this.dataSource = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DrawableResult)) {
            return false;
        }
        DrawableResult drawableResult = (DrawableResult) obj;
        return Intrinsics.areEqual(this.drawable, drawableResult.drawable) && this.isSampled == drawableResult.isSampled && this.dataSource == drawableResult.dataSource;
    }

    public final int hashCode() {
        return CaptureSession$State$EnumUnboxingLocalUtility.ordinal(this.dataSource) + (((this.drawable.hashCode() * 31) + (this.isSampled ? 1231 : 1237)) * 31);
    }
}
