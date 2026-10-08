package androidx.work.impl;

import android.content.Context;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class Api21Impl {
    public static final Api21Impl INSTANCE = new Api21Impl();

    public final File getNoBackupFilesDir(Context context) {
        return context.getNoBackupFilesDir();
    }
}
