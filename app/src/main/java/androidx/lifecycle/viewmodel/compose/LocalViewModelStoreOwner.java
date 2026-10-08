package androidx.lifecycle.viewmodel.compose;

import android.view.View;
import androidx.compose.runtime.DynamicProvidableCompositionLocal;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.ViewModelStoreOwner;
import coil.ImageLoader$Builder$$ExternalSyntheticLambda2;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class LocalViewModelStoreOwner {
    public static final DynamicProvidableCompositionLocal LocalViewModelStoreOwner = new DynamicProvidableCompositionLocal(new ImageLoader$Builder$$ExternalSyntheticLambda2(15));

    public static ViewModelStoreOwner getCurrent(GapComposer gapComposer) {
        ViewModelStoreOwner viewModelStoreOwnerM768get = (ViewModelStoreOwner) gapComposer.consume(LocalViewModelStoreOwner);
        if (viewModelStoreOwnerM768get == null) {
            gapComposer.startReplaceGroup(1260197609);
            viewModelStoreOwnerM768get = androidx.lifecycle.ViewModelKt.m768get((View) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalView));
        } else {
            gapComposer.startReplaceGroup(1260196493);
        }
        gapComposer.end(false);
        return viewModelStoreOwnerM768get;
    }
}
