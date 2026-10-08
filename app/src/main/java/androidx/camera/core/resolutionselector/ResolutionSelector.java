package androidx.camera.core.resolutionselector;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ResolutionSelector {
    public final AspectRatioStrategy mAspectRatioStrategy;
    public final ResolutionStrategy mResolutionStrategy;

    public ResolutionSelector(AspectRatioStrategy aspectRatioStrategy, ResolutionStrategy resolutionStrategy, ImageAnalysis$$ExternalSyntheticLambda1 imageAnalysis$$ExternalSyntheticLambda1) {
        this.mAspectRatioStrategy = aspectRatioStrategy;
        this.mResolutionStrategy = resolutionStrategy;
    }
}
