package androidx.core.content.pm;

import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import com.github.kr328.clash.MainApplication;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class ShortcutInfoCompat$$ExternalSyntheticApiModelOutline0 {
    public static /* synthetic */ ShortcutInfo.Builder m(MainApplication mainApplication, String str) {
        return new ShortcutInfo.Builder(mainApplication, str);
    }

    public static /* bridge */ /* synthetic */ ShortcutManager m(Object obj) {
        return (ShortcutManager) obj;
    }

    public static /* bridge */ /* synthetic */ Class m() {
        return ShortcutManager.class;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m739m() {
    }
}
