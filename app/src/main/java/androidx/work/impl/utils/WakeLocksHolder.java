package androidx.work.impl.utils;

import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class WakeLocksHolder {
    public static final WakeLocksHolder INSTANCE = new WakeLocksHolder();
    public static final WeakHashMap wakeLocks = new WeakHashMap();
}
