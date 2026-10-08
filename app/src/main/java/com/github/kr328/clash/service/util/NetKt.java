package com.github.kr328.clash.service.util;

import java.util.List;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class NetKt {
    public static final IPNet parseCIDR(String str) {
        List listSplit$default = StringsKt.split$default(str, new String[]{"/"}, 2, 2);
        if (listSplit$default.size() == 2) {
            return new IPNet((String) listSplit$default.get(0), Integer.parseInt((String) listSplit$default.get(1)));
        }
        throw new IllegalArgumentException("Invalid address");
    }
}
