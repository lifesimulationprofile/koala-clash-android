package androidx.lifecycle.viewmodel.internal;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import com.google.android.gms.internal.mlkit_vision_common.zzbc;
import kotlin.jvm.internal.ClassReference;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultViewModelProviderFactory implements ViewModelProvider$Factory {
    public static final DefaultViewModelProviderFactory INSTANCE = new DefaultViewModelProviderFactory();

    @Override // androidx.lifecycle.ViewModelProvider$Factory
    public final ViewModel create(ClassReference classReference, MutableCreationExtras mutableCreationExtras) {
        return zzbc.createViewModel(classReference.getJClass());
    }

    @Override // androidx.lifecycle.ViewModelProvider$Factory
    public final ViewModel create(Class cls) {
        throw new UnsupportedOperationException("`Factory.create(String, CreationExtras)` is not implemented. You may need to override the method and provide a custom implementation. Note that using `Factory.create(String)` is not supported and considered an error.");
    }

    @Override // androidx.lifecycle.ViewModelProvider$Factory
    public final ViewModel create(Class cls, MutableCreationExtras mutableCreationExtras) {
        create(cls);
        throw null;
    }
}
