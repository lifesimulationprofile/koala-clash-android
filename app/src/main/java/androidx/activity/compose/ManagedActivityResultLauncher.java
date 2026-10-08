package androidx.activity.compose;

import androidx.activity.result.ActivityResultRegistry$register$2;
import androidx.core.content.pm.ShortcutManagerCompat;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ManagedActivityResultLauncher extends ShortcutManagerCompat {
    public final ActivityResultLauncherHolder launcher;

    public ManagedActivityResultLauncher(ActivityResultLauncherHolder activityResultLauncherHolder) {
        this.launcher = activityResultLauncherHolder;
    }

    public final void launch(Object obj) throws Exception {
        ActivityResultRegistry$register$2 activityResultRegistry$register$2 = this.launcher.launcher;
        if (activityResultRegistry$register$2 == null) {
            throw new IllegalStateException("Launcher has not been initialized");
        }
        activityResultRegistry$register$2.launch(obj);
    }
}
