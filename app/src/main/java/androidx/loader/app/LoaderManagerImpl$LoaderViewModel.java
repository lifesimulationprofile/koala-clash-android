package androidx.loader.app;

import androidx.collection.SparseArrayCompat;
import androidx.fragment.app.FragmentManagerViewModel;
import androidx.lifecycle.ViewModel;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public class LoaderManagerImpl$LoaderViewModel extends ViewModel {
    public static final FragmentManagerViewModel.AnonymousClass1 FACTORY = new FragmentManagerViewModel.AnonymousClass1(3);
    public final SparseArrayCompat mLoaders = new SparseArrayCompat(0);

    @Override // androidx.lifecycle.ViewModel
    public final void onCleared() {
        SparseArrayCompat sparseArrayCompat = this.mLoaders;
        if (sparseArrayCompat.size() > 0) {
            sparseArrayCompat.valueAt(0).getClass();
            throw new ClassCastException();
        }
        int i = sparseArrayCompat.size;
        Object[] objArr = sparseArrayCompat.values;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        sparseArrayCompat.size = 0;
        sparseArrayCompat.garbage = false;
    }
}
