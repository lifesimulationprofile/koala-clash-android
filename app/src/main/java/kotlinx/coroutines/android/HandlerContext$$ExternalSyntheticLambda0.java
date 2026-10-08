package kotlinx.coroutines.android;

import android.util.Size;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda0;
import androidx.camera.core.Preview;
import androidx.camera.core.impl.ImageAnalysisConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.PreviewConfig;
import androidx.camera.core.impl.utils.futures.ChainingListenableFuture;
import androidx.camera.core.resolutionselector.AspectRatioStrategy;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.camera.core.resolutionselector.ResolutionStrategy;
import androidx.camera.lifecycle.LifecycleCamera;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.navigation.NavDestinationBuilder;
import androidx.tracing.Trace;
import androidx.work.ListenableWorker;
import androidx.work.impl.WorkLauncherImpl;
import androidx.work.impl.constraints.controllers.ConstraintController$track$1$listener$1;
import androidx.work.impl.utils.WorkForegroundRunnable;
import androidx.work.impl.utils.futures.AbstractFuture;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import androidx.work.impl.workers.ConstraintTrackingWorkerKt;
import coil.decode.SvgDecoder$$ExternalSyntheticLambda0;
import coil.disk.DiskLruCache$$ExternalSyntheticLambda0;
import com.github.kr328.clash.remote.Remote$$ExternalSyntheticLambda1;
import com.google.common.util.concurrent.ListenableFuture;
import dev.chrisbanes.haze.BlurEffectKt$$ExternalSyntheticLambda1;
import io.github.g00fy2.quickie.QRCodeAnalyzer;
import io.github.g00fy2.quickie.QROverlayView;
import io.github.g00fy2.quickie.QRScannerActivity;
import io.github.g00fy2.quickie.QRScannerActivity$$ExternalSyntheticLambda0;
import io.github.g00fy2.quickie.QRScannerActivity$sam$androidx_lifecycle_Observer$0;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HandlerContext$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ HandlerContext$$ExternalSyntheticLambda0(int i, Object obj, Object obj2) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    private final void run$androidx$work$impl$workers$ConstraintTrackingWorker$$ExternalSyntheticLambda2() {
        ConstraintTrackingWorker constraintTrackingWorker = (ConstraintTrackingWorker) this.f$0;
        ListenableFuture listenableFuture = (ListenableFuture) this.f$1;
        synchronized (constraintTrackingWorker.lock) {
            try {
                if (constraintTrackingWorker.areConstraintsUnmet) {
                    SettableFuture settableFuture = constraintTrackingWorker.future;
                    String str = ConstraintTrackingWorkerKt.TAG;
                    settableFuture.set(new ListenableWorker.Result.Retry());
                } else {
                    constraintTrackingWorker.future.setFuture(listenableFuture);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = 1;
        switch (this.$r8$classId) {
            case 0:
                ((CancellableContinuationImpl) this.f$0).resumeUndispatched((HandlerContext) this.f$1, Unit.INSTANCE);
                return;
            case 1:
                List list = (List) this.f$0;
                NavDestinationBuilder navDestinationBuilder = (NavDestinationBuilder) this.f$1;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((ConstraintController$track$1$listener$1) it.next()).onConstraintChanged(navDestinationBuilder.deepLinks);
                }
                return;
            case 2:
                WorkForegroundRunnable workForegroundRunnable = (WorkForegroundRunnable) this.f$0;
                SettableFuture settableFuture = (SettableFuture) this.f$1;
                if (workForegroundRunnable.mFuture.value instanceof AbstractFuture.Cancellation) {
                    settableFuture.cancel(true);
                    return;
                } else {
                    settableFuture.setFuture(workForegroundRunnable.mWorker.getForegroundInfoAsync());
                    return;
                }
            case 3:
                run$androidx$work$impl$workers$ConstraintTrackingWorker$$ExternalSyntheticLambda2();
                return;
            default:
                ChainingListenableFuture chainingListenableFuture = (ChainingListenableFuture) this.f$0;
                QRScannerActivity qRScannerActivity = (QRScannerActivity) this.f$1;
                int i2 = QRScannerActivity.$r8$clinit;
                try {
                    ProcessCameraProvider processCameraProvider = (ProcessCameraProvider) chainingListenableFuture.get();
                    PreviewConfig previewConfig = new PreviewConfig(OptionsBundle.from(new Preview.Builder(0).mMutableConfig));
                    ImageOutputConfig.CC.validateConfig(previewConfig);
                    Preview preview = new Preview(previewConfig);
                    preview.mSurfaceProviderExecutor = Preview.DEFAULT_SURFACE_PROVIDER_EXECUTOR;
                    WorkLauncherImpl workLauncherImpl = qRScannerActivity.binding;
                    if (workLauncherImpl == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        throw null;
                    }
                    preview.setSurfaceProvider(((PreviewView) workLauncherImpl.workTaskExecutor).getSurfaceProvider());
                    int i3 = 2;
                    Preview.Builder builder = new Preview.Builder(2);
                    builder.mMutableConfig.insertOption(ImageOutputConfig.OPTION_RESOLUTION_SELECTOR, new ResolutionSelector(AspectRatioStrategy.RATIO_4_3_FALLBACK_AUTO_STRATEGY, new ResolutionStrategy(new Size(1280, 720)), null));
                    ImageAnalysisConfig imageAnalysisConfig = new ImageAnalysisConfig(OptionsBundle.from(builder.mMutableConfig));
                    ImageOutputConfig.CC.validateConfig(imageAnalysisConfig);
                    ImageAnalysis imageAnalysis = new ImageAnalysis(imageAnalysisConfig);
                    ExecutorService executorService = qRScannerActivity.analysisExecutor;
                    if (executorService == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("analysisExecutor");
                        throw null;
                    }
                    QRCodeAnalyzer qRCodeAnalyzer = new QRCodeAnalyzer(qRScannerActivity.barcodeFormats, new BlurEffectKt$$ExternalSyntheticLambda1(14, imageAnalysis, qRScannerActivity), new QRScannerActivity$$ExternalSyntheticLambda0(qRScannerActivity, i), new QRScannerActivity$$ExternalSyntheticLambda0(qRScannerActivity, i3));
                    synchronized (imageAnalysis.mAnalysisLock) {
                        try {
                            imageAnalysis.mImageAnalysisAbstractAnalyzer.setAnalyzer(executorService, new ImageAnalysis$$ExternalSyntheticLambda0(qRCodeAnalyzer));
                            if (imageAnalysis.mSubscribedAnalyzer == null) {
                                imageAnalysis.notifyActive();
                            }
                            imageAnalysis.mSubscribedAnalyzer = qRCodeAnalyzer;
                        } catch (Throwable th) {
                            throw th;
                        }
                        break;
                    }
                    processCameraProvider.getClass();
                    Trace.beginSection("CX:unbindAll");
                    try {
                        MapsKt__MapsKt.checkMainThread();
                        ProcessCameraProvider.access$setCameraOperatingMode(processCameraProvider, 0);
                        processCameraProvider.mLifecycleCameraRepository.unbindAll();
                        Unit unit = Unit.INSTANCE;
                        android.os.Trace.endSection();
                        try {
                            LifecycleCamera lifecycleCameraBindToLifecycle = processCameraProvider.bindToLifecycle(qRScannerActivity, qRScannerActivity.useFrontCamera ? CameraSelector.DEFAULT_FRONT_CAMERA : CameraSelector.DEFAULT_BACK_CAMERA, preview, imageAnalysis);
                            WorkLauncherImpl workLauncherImpl2 = qRScannerActivity.binding;
                            if (workLauncherImpl2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("binding");
                                throw null;
                            }
                            ((QROverlayView) workLauncherImpl2.processor).setVisibility(0);
                            WorkLauncherImpl workLauncherImpl3 = qRScannerActivity.binding;
                            if (workLauncherImpl3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("binding");
                                throw null;
                            }
                            int i4 = 18;
                            ((QROverlayView) workLauncherImpl3.processor).setCloseVisibilityAndOnClick(qRScannerActivity.showCloseButton, new SvgDecoder$$ExternalSyntheticLambda0(i4, qRScannerActivity));
                            if (!qRScannerActivity.showTorchToggle || !lifecycleCameraBindToLifecycle.mCameraUseCaseAdapter.mAdapterCameraInfo.mCameraInfo.hasFlashUnit()) {
                                WorkLauncherImpl workLauncherImpl4 = qRScannerActivity.binding;
                                if (workLauncherImpl4 != null) {
                                    ((QROverlayView) workLauncherImpl4.processor).setTorchVisibilityAndOnClick(new Remote$$ExternalSyntheticLambda1(i4), false);
                                    return;
                                } else {
                                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                                    throw null;
                                }
                            }
                            WorkLauncherImpl workLauncherImpl5 = qRScannerActivity.binding;
                            if (workLauncherImpl5 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("binding");
                                throw null;
                            }
                            ((QROverlayView) workLauncherImpl5.processor).setTorchVisibilityAndOnClick(new DiskLruCache$$ExternalSyntheticLambda0(15, lifecycleCameraBindToLifecycle), true);
                            lifecycleCameraBindToLifecycle.mCameraUseCaseAdapter.mAdapterCameraInfo.mCameraInfo.getTorchState().observe(qRScannerActivity, new QRScannerActivity$sam$androidx_lifecycle_Observer$0(new QRScannerActivity$$ExternalSyntheticLambda0(qRScannerActivity, 3)));
                            return;
                        } catch (Exception e) {
                            WorkLauncherImpl workLauncherImpl6 = qRScannerActivity.binding;
                            if (workLauncherImpl6 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("binding");
                                throw null;
                            }
                            ((QROverlayView) workLauncherImpl6.processor).setVisibility(4);
                            qRScannerActivity.onFailure(e);
                            return;
                        }
                    } catch (Throwable th2) {
                        android.os.Trace.endSection();
                        throw th2;
                    }
                } catch (Exception e2) {
                    qRScannerActivity.onFailure(e2);
                    return;
                }
        }
    }
}
