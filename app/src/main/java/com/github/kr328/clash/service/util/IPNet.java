package com.github.kr328.clash.service.util;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class IPNet {
    public final String ip;
    public final int prefix;

    public IPNet(String str, int i) {
        this.ip = str;
        this.prefix = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IPNet)) {
            return false;
        }
        IPNet iPNet = (IPNet) obj;
        return Intrinsics.areEqual(this.ip, iPNet.ip) && this.prefix == iPNet.prefix;
    }

    public final int hashCode() {
        return (this.ip.hashCode() * 31) + this.prefix;
    }

    public final String toString() {
        return "IPNet(ip=" + this.ip + ", prefix=" + this.prefix + ")";
    }
}
