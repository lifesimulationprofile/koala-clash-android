package com.github.kr328.clash.service.document;

import java.io.File;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class FileDocument implements Document {
    public final File file;
    public final Set flags;
    public final String idOverride;
    public final String nameOverride;

    public FileDocument(File file, Set set, String str, String str2) {
        this.file = file;
        this.flags = set;
        this.idOverride = str;
        this.nameOverride = str2;
    }

    @Override // com.github.kr328.clash.service.document.Document
    public final Set getFlags() {
        return this.flags;
    }

    @Override // com.github.kr328.clash.service.document.Document
    public final String getId() {
        String str = this.idOverride;
        return str == null ? this.file.getName() : str;
    }

    @Override // com.github.kr328.clash.service.document.Document
    public final String getMimeType() {
        return this.file.isDirectory() ? "vnd.android.document/directory" : "text/plain";
    }

    @Override // com.github.kr328.clash.service.document.Document
    public final String getName() {
        String str = this.nameOverride;
        return str == null ? this.file.getName() : str;
    }

    @Override // com.github.kr328.clash.service.document.Document
    public final long getSize() {
        return this.file.length();
    }

    @Override // com.github.kr328.clash.service.document.Document
    public final long getUpdatedAt() {
        return this.file.lastModified();
    }
}
