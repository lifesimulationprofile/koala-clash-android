package com.github.kr328.clash.remote;

import android.content.Context;
import com.github.kr328.clash.FilesActivity;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class FilesClient {
    public static final String[] FilesProjection = {"document_id", "_display_name", "_size", "last_modified", "mime_type"};
    public final Context context;

    public FilesClient(FilesActivity filesActivity) {
        this.context = filesActivity;
    }
}
