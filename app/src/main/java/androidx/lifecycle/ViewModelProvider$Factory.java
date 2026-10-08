package androidx.lifecycle;

import androidx.lifecycle.viewmodel.MutableCreationExtras;
import kotlin.jvm.internal.ClassReference;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface ViewModelProvider$Factory {
    ViewModel create(Class cls);

    ViewModel create(Class cls, MutableCreationExtras mutableCreationExtras);

    ViewModel create(ClassReference classReference, MutableCreationExtras mutableCreationExtras);
}
