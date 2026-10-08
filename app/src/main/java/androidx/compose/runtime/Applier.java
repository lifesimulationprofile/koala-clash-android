package androidx.compose.runtime;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface Applier {
    void apply(Object obj, Function2 function2);

    void down(Object obj);

    void insertBottomUp(int i, Object obj);

    void insertTopDown(int i, Object obj);

    void move(int i, int i2, int i3);

    void onEndChanges();

    void remove(int i, int i2);

    void reuse();

    void up();
}
