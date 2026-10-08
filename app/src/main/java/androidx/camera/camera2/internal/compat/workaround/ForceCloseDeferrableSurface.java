package androidx.camera.camera2.internal.compat.workaround;

import androidx.camera.camera2.internal.compat.quirk.ConfigureSurfaceToSecondarySessionFailQuirk;
import androidx.camera.camera2.internal.compat.quirk.PreviewOrientationIncorrectQuirk;
import androidx.camera.camera2.internal.compat.quirk.TextureViewIsClosedQuirk;
import androidx.camera.core.impl.DeferrableSurface;
import java.util.ArrayList;
import kotlin.LazyKt__LazyJVMKt;
import okhttp3.Headers;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ForceCloseDeferrableSurface {
    public final boolean mHasConfigureSurfaceToSecondarySessionFailQuirk;
    public final boolean mHasPreviewOrientationIncorrectQuirk;
    public final boolean mHasTextureViewIsClosedQuirk;

    public ForceCloseDeferrableSurface(Headers.Builder builder, Headers.Builder builder2) {
        this.mHasTextureViewIsClosedQuirk = builder2.contains(TextureViewIsClosedQuirk.class);
        this.mHasPreviewOrientationIncorrectQuirk = builder.contains(PreviewOrientationIncorrectQuirk.class);
        this.mHasConfigureSurfaceToSecondarySessionFailQuirk = builder.contains(ConfigureSurfaceToSecondarySessionFailQuirk.class);
    }

    public final void onSessionEnd(ArrayList arrayList) {
        if ((this.mHasTextureViewIsClosedQuirk || this.mHasPreviewOrientationIncorrectQuirk || this.mHasConfigureSurfaceToSecondarySessionFailQuirk) && arrayList != null) {
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((DeferrableSurface) obj).close();
            }
            LazyKt__LazyJVMKt.d("ForceCloseDeferrableSurface", "deferrableSurface closed");
        }
    }
}
