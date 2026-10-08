package com.github.kr328.clash.service;

import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class HwidLimitException extends IllegalStateException {
    public final String supportURL;

    public HwidLimitException(String str) {
        super((str == null || StringsKt.isBlank(str)) ? "HWID_LIMIT" : "HWID_LIMIT|".concat(str));
        this.supportURL = str;
    }
}
