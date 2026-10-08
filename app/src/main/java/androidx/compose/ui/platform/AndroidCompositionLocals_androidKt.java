package androidx.compose.ui.platform;

import androidx.compose.runtime.DynamicProvidableCompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.savedstate.compose.LocalSavedStateRegistryOwnerKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidCompositionLocals_androidKt {
    public static final DynamicProvidableCompositionLocal LocalConfiguration = new DynamicProvidableCompositionLocal(CompositionLocalsKt$LocalDensity$1.INSTANCE$1);
    public static final StaticProvidableCompositionLocal LocalContext = new StaticProvidableCompositionLocal(CompositionLocalsKt$LocalDensity$1.INSTANCE$2);
    public static final DynamicProvidableCompositionLocal LocalResources = new DynamicProvidableCompositionLocal(AndroidComposeView.AnonymousClass1.INSTANCE$2);
    public static final StaticProvidableCompositionLocal LocalImageVectorCache = new StaticProvidableCompositionLocal(CompositionLocalsKt$LocalDensity$1.INSTANCE$3);
    public static final StaticProvidableCompositionLocal LocalResourceIdCache = new StaticProvidableCompositionLocal(CompositionLocalsKt$LocalDensity$1.INSTANCE$4);
    public static final StaticProvidableCompositionLocal LocalView = new StaticProvidableCompositionLocal(CompositionLocalsKt$LocalDensity$1.INSTANCE$5);

    public static final void access$noLocalProvidedFor(String str) {
        throw new IllegalStateException(("CompositionLocal " + str + " not present").toString());
    }

    public static final ProvidableCompositionLocal getLocalSavedStateRegistryOwner() {
        return LocalSavedStateRegistryOwnerKt.LocalSavedStateRegistryOwner;
    }
}
