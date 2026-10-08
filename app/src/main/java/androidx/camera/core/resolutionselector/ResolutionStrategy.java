package androidx.camera.core.resolutionselector;

import android.util.Size;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ResolutionStrategy {
    public static final ResolutionStrategy HIGHEST_AVAILABLE_STRATEGY;
    public Size mBoundSize;
    public int mFallbackRule = 1;

    static {
        ResolutionStrategy resolutionStrategy = new ResolutionStrategy();
        resolutionStrategy.mBoundSize = null;
        resolutionStrategy.mFallbackRule = 0;
        HIGHEST_AVAILABLE_STRATEGY = resolutionStrategy;
    }

    public ResolutionStrategy(Size size) {
        this.mBoundSize = size;
    }
}
