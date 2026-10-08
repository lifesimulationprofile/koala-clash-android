package androidx.camera.core.impl;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class UseCaseAttachState$UseCaseAttachInfo {
    public final List mCaptureTypes;
    public final SessionConfig mSessionConfig;
    public final AutoValue_StreamSpec mStreamSpec;
    public final UseCaseConfig mUseCaseConfig;
    public boolean mAttached = false;
    public boolean mActive = false;

    public UseCaseAttachState$UseCaseAttachInfo(SessionConfig sessionConfig, UseCaseConfig useCaseConfig, AutoValue_StreamSpec autoValue_StreamSpec, List list) {
        this.mSessionConfig = sessionConfig;
        this.mUseCaseConfig = useCaseConfig;
        this.mStreamSpec = autoValue_StreamSpec;
        this.mCaptureTypes = list;
    }

    public final String toString() {
        return "UseCaseAttachInfo{mSessionConfig=" + this.mSessionConfig + ", mUseCaseConfig=" + this.mUseCaseConfig + ", mStreamSpec=" + this.mStreamSpec + ", mCaptureTypes=" + this.mCaptureTypes + ", mAttached=" + this.mAttached + ", mActive=" + this.mActive + '}';
    }
}
