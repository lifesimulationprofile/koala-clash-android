package androidx.camera.core;

import com.google.android.gms.tasks.OnFailureListener;
import io.github.g00fy2.quickie.QRCodeAnalyzer;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ImageAnalysis$$ExternalSyntheticLambda0 implements ImageAnalysis.Analyzer, OnFailureListener {
    public final /* synthetic */ QRCodeAnalyzer f$0;

    public /* synthetic */ ImageAnalysis$$ExternalSyntheticLambda0(QRCodeAnalyzer qRCodeAnalyzer) {
        this.f$0 = qRCodeAnalyzer;
    }

    @Override // androidx.camera.core.ImageAnalysis.Analyzer
    public void analyze(SettableImageProxy settableImageProxy) {
        this.f$0.analyze(settableImageProxy);
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        QRCodeAnalyzer qRCodeAnalyzer = this.f$0;
        qRCodeAnalyzer.failureOccurred = true;
        qRCodeAnalyzer.failureTimestamp = System.currentTimeMillis();
        qRCodeAnalyzer.onFailure.invoke(exc);
    }
}
