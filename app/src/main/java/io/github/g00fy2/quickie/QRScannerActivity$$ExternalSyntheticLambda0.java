package io.github.g00fy2.quickie;

import androidx.camera.core.impl.utils.futures.ChainingListenableFuture;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.core.content.ContextCompat;
import androidx.work.impl.WorkLauncherImpl;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.android.HandlerContext$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class QRScannerActivity$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ QRScannerActivity f$0;

    public /* synthetic */ QRScannerActivity$$ExternalSyntheticLambda0(QRScannerActivity qRScannerActivity, int i) {
        this.$r8$classId = i;
        this.f$0 = qRScannerActivity;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x001f  */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        boolean z;
        int i = this.$r8$classId;
        QRScannerActivity qRScannerActivity = this.f$0;
        switch (i) {
            case 0:
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                int i2 = QRScannerActivity.$r8$clinit;
                if (zBooleanValue) {
                    try {
                        ProcessCameraProvider processCameraProvider = ProcessCameraProvider.sAppInstance;
                        ChainingListenableFuture comparisonsKt__ComparisonsKt = ComparisonsKt__ComparisonsKt.getInstance(qRScannerActivity);
                        comparisonsKt__ComparisonsKt.addListener(new HandlerContext$$ExternalSyntheticLambda0(4, comparisonsKt__ComparisonsKt, qRScannerActivity), ContextCompat.getMainExecutor(qRScannerActivity));
                    } catch (Exception e) {
                        qRScannerActivity.onFailure(e);
                    }
                } else {
                    qRScannerActivity.setResult(2, null);
                    qRScannerActivity.finish();
                }
                return Unit.INSTANCE;
            case 1:
                int i3 = QRScannerActivity.$r8$clinit;
                qRScannerActivity.onFailure((Exception) obj);
                return Unit.INSTANCE;
            case 2:
                boolean zBooleanValue2 = ((Boolean) obj).booleanValue();
                int i4 = QRScannerActivity.$r8$clinit;
                if (!qRScannerActivity.isFinishing()) {
                    WorkLauncherImpl workLauncherImpl = qRScannerActivity.binding;
                    if (workLauncherImpl == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        throw null;
                    }
                    ((QROverlayView) workLauncherImpl.processor).setLoading(zBooleanValue2);
                }
                return Unit.INSTANCE;
            default:
                Integer num = (Integer) obj;
                WorkLauncherImpl workLauncherImpl2 = qRScannerActivity.binding;
                if (workLauncherImpl2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    throw null;
                }
                QROverlayView qROverlayView = (QROverlayView) workLauncherImpl2.processor;
                if (num != null) {
                    z = num.intValue() == 1;
                }
                qROverlayView.setTorchState(z);
                return Unit.INSTANCE;
        }
    }
}
