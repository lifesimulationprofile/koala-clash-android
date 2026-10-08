package androidx.compose.ui.platform;

import androidx.savedstate.internal.SavedStateRegistryImpl;
import androidx.work.impl.WorkLauncherImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class DisposableSaveableStateRegistry_androidKt$DisposableSaveableStateRegistry$1 extends Lambda implements Function0 {
    public final /* synthetic */ WorkLauncherImpl $androidxRegistry;
    public final /* synthetic */ String $key;
    public final /* synthetic */ boolean $registered;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DisposableSaveableStateRegistry_androidKt$DisposableSaveableStateRegistry$1(boolean z, WorkLauncherImpl workLauncherImpl, String str) {
        super(0);
        this.$registered = z;
        this.$androidxRegistry = workLauncherImpl;
        this.$key = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        if (this.$registered) {
            WorkLauncherImpl workLauncherImpl = this.$androidxRegistry;
            String str = this.$key;
            SavedStateRegistryImpl savedStateRegistryImpl = (SavedStateRegistryImpl) workLauncherImpl.processor;
            synchronized (savedStateRegistryImpl.lock) {
            }
        }
        return Unit.INSTANCE;
    }
}
