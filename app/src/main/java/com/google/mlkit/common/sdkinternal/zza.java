package com.google.mlkit.common.sdkinternal;

import android.os.Trace;
import androidx.core.os.TraceCompat;
import androidx.emoji2.text.EmojiCompat;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zza implements Runnable {
    public final /* synthetic */ int $r8$classId;

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                return;
            default:
                try {
                    int i = TraceCompat.$r8$clinit;
                    Trace.beginSection("EmojiCompat.EmojiCompatInitializer.run");
                    if (EmojiCompat.isConfigured()) {
                        EmojiCompat.get().load();
                        break;
                    }
                    return;
                } finally {
                    int i2 = TraceCompat.$r8$clinit;
                    Trace.endSection();
                }
        }
    }

    private final void run$com$google$mlkit$common$sdkinternal$zza() {
    }
}
