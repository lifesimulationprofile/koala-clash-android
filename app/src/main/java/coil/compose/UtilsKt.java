package coil.compose;

import android.content.Context;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.ConstraintsKt;
import coil.request.ImageRequest;
import coil.size.RealSizeResolver;
import coil.size.Size;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class UtilsKt {
    public static final RealSizeResolver OriginalSizeResolver;
    public static final long ZeroConstraints = ConstraintsKt.createConstraints(0, 0, 0, 0);

    static {
        Size size = Size.ORIGINAL;
        OriginalSizeResolver = new RealSizeResolver();
    }

    public static final ImageRequest requestOf(Object obj, GapComposer gapComposer) {
        gapComposer.startReplaceableGroup(1087186730);
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            gapComposer.end(false);
            return imageRequest;
        }
        Context context = (Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext);
        gapComposer.startReplaceableGroup(-1245195153);
        boolean zChanged = gapComposer.changed(context) | gapComposer.changed(obj);
        Object objRememberedValue = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue == Composer$Companion.Empty) {
            ImageRequest.Builder builder = new ImageRequest.Builder(context);
            builder.data = obj;
            objRememberedValue = builder.build();
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        ImageRequest imageRequest2 = (ImageRequest) objRememberedValue;
        gapComposer.end(false);
        gapComposer.end(false);
        return imageRequest2;
    }
}
