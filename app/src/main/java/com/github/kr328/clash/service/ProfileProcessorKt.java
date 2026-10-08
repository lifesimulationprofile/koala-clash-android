package com.github.kr328.clash.service;

import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ProfileProcessorKt {
    public static final HwidLimitMarker parseHwidLimitMarker(String str) {
        if (str == null || !StringsKt__StringsJVMKt.startsWith(str, "HWID_LIMIT", false)) {
            return null;
        }
        String strRemovePrefix = StringsKt.removePrefix(StringsKt.removePrefix(str, "HWID_LIMIT"), "|");
        return new HwidLimitMarker(strRemovePrefix.length() > 0 ? strRemovePrefix : null);
    }
}
