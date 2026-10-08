package androidx.compose.ui.res;

import android.content.res.Resources;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class StringResources_androidKt {
    public static final String stringResource(int i, GapComposer gapComposer) {
        return ((Resources) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalResources)).getString(i);
    }
}
