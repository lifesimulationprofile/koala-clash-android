package kotlinx.serialization.json.internal;

import kotlin.collections.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class CharArrayPool extends CharArrayPoolBase {
    public static final CharArrayPool INSTANCE;

    static {
        CharArrayPool charArrayPool = new CharArrayPool();
        charArrayPool.arrays = new ArrayDeque();
        INSTANCE = charArrayPool;
    }
}
