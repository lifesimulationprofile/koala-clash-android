package androidx.camera.core.impl;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class LiveDataObservable$Result {
    public final CameraInternal.State mValue;

    public LiveDataObservable$Result(CameraInternal.State state) {
        this.mValue = state;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[Result: <");
        sb.append("Value: " + this.mValue);
        sb.append(">]");
        return sb.toString();
    }
}
