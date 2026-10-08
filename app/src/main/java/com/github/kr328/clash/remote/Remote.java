package com.github.kr328.clash.remote;

import coil.ImageLoader$Builder$$ExternalSyntheticLambda2;
import coil.disk.DiskLruCache;
import com.github.kr328.clash.common.Global;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Remote {
    public static final DiskLruCache.Editor broadcasts;
    public static final Service service;

    static {
        Global.INSTANCE.getClass();
        broadcasts = new DiskLruCache.Editor(Global.getApplication$1());
        service = new Service(Global.getApplication$1(), new ImageLoader$Builder$$ExternalSyntheticLambda2(29));
        ChannelKt.Channel$default(-1, 0, 6);
    }
}
