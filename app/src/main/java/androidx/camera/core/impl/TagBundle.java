package androidx.camera.core.impl;

import android.util.ArrayMap;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public class TagBundle {
    public static final TagBundle EMPTY_TAGBUNDLE = new TagBundle(new ArrayMap());
    public final ArrayMap mTagMap;

    public TagBundle(ArrayMap arrayMap) {
        this.mTagMap = arrayMap;
    }

    public final String toString() {
        return "android.hardware.camera2.CaptureRequest.setTag.CX";
    }
}
