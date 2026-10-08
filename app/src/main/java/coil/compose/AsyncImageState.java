package coil.compose;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import coil.RealImageLoader;
import coil.memory.MemoryCache$Key;
import coil.request.ImageRequest;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AsyncImageState {
    public final RealImageLoader imageLoader;
    public final Object model;
    public final EqualityDelegateKt$DefaultModelEqualityDelegate$1 modelEqualityDelegate;

    public AsyncImageState(Object obj, EqualityDelegateKt$DefaultModelEqualityDelegate$1 equalityDelegateKt$DefaultModelEqualityDelegate$1, RealImageLoader realImageLoader) {
        this.model = obj;
        this.modelEqualityDelegate = equalityDelegateKt$DefaultModelEqualityDelegate$1;
        this.imageLoader = realImageLoader;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0017  */
    public final boolean equals(Object obj) {
        boolean zAreEqual;
        if (this != obj) {
            if (obj instanceof AsyncImageState) {
                AsyncImageState asyncImageState = (AsyncImageState) obj;
                Object obj2 = asyncImageState.model;
                this.modelEqualityDelegate.getClass();
                Object obj3 = this.model;
                if (obj3 == obj2) {
                    zAreEqual = true;
                } else if ((obj3 instanceof ImageRequest) && (obj2 instanceof ImageRequest)) {
                    ImageRequest imageRequest = (ImageRequest) obj3;
                    ImageRequest imageRequest2 = (ImageRequest) obj2;
                    if (Intrinsics.areEqual(imageRequest.context, imageRequest2.context) && imageRequest.data.equals(imageRequest2.data) && Intrinsics.areEqual(imageRequest.memoryCacheKey, imageRequest2.memoryCacheKey) && imageRequest.bitmapConfig == imageRequest2.bitmapConfig && Intrinsics.areEqual(imageRequest.transformations, imageRequest2.transformations) && Intrinsics.areEqual(imageRequest.headers, imageRequest2.headers) && imageRequest.allowConversionToBitmap == imageRequest2.allowConversionToBitmap && imageRequest.allowHardware == imageRequest2.allowHardware && imageRequest.allowRgb565 == imageRequest2.allowRgb565 && imageRequest.premultipliedAlpha == imageRequest2.premultipliedAlpha && imageRequest.memoryCachePolicy == imageRequest2.memoryCachePolicy && imageRequest.diskCachePolicy == imageRequest2.diskCachePolicy && imageRequest.networkCachePolicy == imageRequest2.networkCachePolicy && imageRequest.sizeResolver.equals(imageRequest2.sizeResolver) && imageRequest.scale == imageRequest2.scale && imageRequest.precision == imageRequest2.precision && imageRequest.parameters.equals(imageRequest2.parameters)) {
                        zAreEqual = true;
                    } else {
                        zAreEqual = false;
                    }
                } else {
                    zAreEqual = Intrinsics.areEqual(obj3, obj2);
                }
                if (!zAreEqual || !this.imageLoader.equals(asyncImageState.imageLoader)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        this.modelEqualityDelegate.getClass();
        Object obj = this.model;
        int iHashCode = 0;
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            int iHashCode2 = (imageRequest.data.hashCode() + (imageRequest.context.hashCode() * 31)) * 961;
            MemoryCache$Key memoryCache$Key = imageRequest.memoryCacheKey;
            iHashCode = imageRequest.parameters.entries.hashCode() + ImageAnalysis$$ExternalSyntheticLambda1.m(imageRequest.precision, ImageAnalysis$$ExternalSyntheticLambda1.m(imageRequest.scale, (imageRequest.sizeResolver.hashCode() + ImageAnalysis$$ExternalSyntheticLambda1.m(imageRequest.networkCachePolicy, ImageAnalysis$$ExternalSyntheticLambda1.m(imageRequest.diskCachePolicy, ImageAnalysis$$ExternalSyntheticLambda1.m(imageRequest.memoryCachePolicy, (((((((((((imageRequest.transformations.hashCode() + ((imageRequest.bitmapConfig.hashCode() + ((iHashCode2 + (memoryCache$Key != null ? memoryCache$Key.hashCode() : 0)) * 961)) * 961)) * 31) + Arrays.hashCode(imageRequest.headers.namesAndValues)) * 31) + (imageRequest.allowConversionToBitmap ? 1231 : 1237)) * 31) + (imageRequest.allowHardware ? 1231 : 1237)) * 31) + (imageRequest.allowRgb565 ? 1231 : 1237)) * 31) + (imageRequest.premultipliedAlpha ? 1231 : 1237)) * 31, 31), 31), 31)) * 31, 31), 31);
        } else if (obj != null) {
            iHashCode = obj.hashCode();
        }
        return this.imageLoader.hashCode() + (iHashCode * 31);
    }
}
