package com.github.kr328.clash.core.util;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URL;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class NetKt {
    public static final InetSocketAddress parseInetSocketAddress(String str) {
        URL url = new URL("https://".concat(str));
        return new InetSocketAddress(InetAddress.getByName(url.getHost()), url.getPort());
    }
}
