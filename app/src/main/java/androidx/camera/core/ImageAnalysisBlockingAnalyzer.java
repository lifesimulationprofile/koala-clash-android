package androidx.camera.core;

import androidx.appcompat.widget.Toolbar;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.work.Worker;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.collections.SetsKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ImageAnalysisBlockingAnalyzer extends ImageAnalysisAbstractAnalyzer {
    @Override // androidx.camera.core.ImageAnalysisAbstractAnalyzer
    public final ImageProxy acquireImage(ImageReaderProxy imageReaderProxy) {
        return imageReaderProxy.acquireNextImage();
    }

    @Override // androidx.camera.core.ImageAnalysisAbstractAnalyzer
    public final void onValidImageAvailable(ImageProxy imageProxy) throws Throwable {
        ListenableFuture listenableFutureAnalyzeImage = analyzeImage(imageProxy);
        Toolbar.AnonymousClass1 anonymousClass1 = new Toolbar.AnonymousClass1(16, imageProxy);
        listenableFutureAnalyzeImage.addListener(new Worker.AnonymousClass2(1, listenableFutureAnalyzeImage, anonymousClass1), SetsKt.directExecutor());
    }

    @Override // androidx.camera.core.ImageAnalysisAbstractAnalyzer
    public final void clearCache() {
    }
}
