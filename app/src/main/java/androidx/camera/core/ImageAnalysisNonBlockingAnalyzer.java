package androidx.camera.core;

import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.view.PreviewView;
import androidx.work.Worker;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import kotlin.collections.SetsKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ImageAnalysisNonBlockingAnalyzer extends ImageAnalysisAbstractAnalyzer {
    public final Executor mBackgroundExecutor;
    public ImageProxy mCachedImage;
    public final Object mLock = new Object();
    public SingleCloseImageProxy mPostedImage;

    public ImageAnalysisNonBlockingAnalyzer(Executor executor) {
        this.mBackgroundExecutor = executor;
    }

    @Override // androidx.camera.core.ImageAnalysisAbstractAnalyzer
    public final ImageProxy acquireImage(ImageReaderProxy imageReaderProxy) {
        return imageReaderProxy.acquireLatestImage();
    }

    @Override // androidx.camera.core.ImageAnalysisAbstractAnalyzer
    public final void clearCache() {
        synchronized (this.mLock) {
            try {
                ImageProxy imageProxy = this.mCachedImage;
                if (imageProxy != null) {
                    imageProxy.close();
                    this.mCachedImage = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.core.ImageAnalysisAbstractAnalyzer
    public final void onValidImageAvailable(ImageProxy imageProxy) {
        synchronized (this.mLock) {
            try {
                if (!this.mIsAttached) {
                    imageProxy.close();
                    return;
                }
                if (this.mPostedImage != null) {
                    if (imageProxy.getImageInfo().getTimestamp() <= this.mPostedImage.mImage.getImageInfo().getTimestamp()) {
                        imageProxy.close();
                    } else {
                        ImageProxy imageProxy2 = this.mCachedImage;
                        if (imageProxy2 != null) {
                            imageProxy2.close();
                        }
                        this.mCachedImage = imageProxy;
                    }
                    return;
                }
                SingleCloseImageProxy singleCloseImageProxy = new SingleCloseImageProxy(imageProxy, this);
                this.mPostedImage = singleCloseImageProxy;
                ListenableFuture listenableFutureAnalyzeImage = analyzeImage(singleCloseImageProxy);
                PreviewView.AnonymousClass1 anonymousClass1 = new PreviewView.AnonymousClass1(15, singleCloseImageProxy);
                listenableFutureAnalyzeImage.addListener(new Worker.AnonymousClass2(1, listenableFutureAnalyzeImage, anonymousClass1), SetsKt.directExecutor());
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
