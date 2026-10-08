package com.github.kr328.clash.service.document;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class VirtualDocument implements Document {
    public final Set flags;
    public final String id;
    public final String name;

    public VirtualDocument(String str, String str2, Set set) {
        this.id = str;
        this.name = str2;
        this.flags = set;
    }

    @Override // com.github.kr328.clash.service.document.Document
    public final Set getFlags() {
        return this.flags;
    }

    @Override // com.github.kr328.clash.service.document.Document
    public final String getId() {
        return this.id;
    }

    @Override // com.github.kr328.clash.service.document.Document
    public final String getMimeType() {
        return "vnd.android.document/directory";
    }

    @Override // com.github.kr328.clash.service.document.Document
    public final String getName() {
        return this.name;
    }

    @Override // com.github.kr328.clash.service.document.Document
    public final long getSize() {
        return 0L;
    }

    @Override // com.github.kr328.clash.service.document.Document
    public final long getUpdatedAt() {
        return 0L;
    }
}
