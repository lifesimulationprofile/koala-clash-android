package io.github.g00fy2.quickie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.activity.OnBackPressedDispatcher$$ExternalSyntheticLambda0;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;
import androidx.core.content.IntentCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.viewbinding.ViewBindings;
import androidx.work.impl.WorkLauncherImpl;
import com.koala.clash.R;
import io.github.g00fy2.quickie.config.ParcelableScannerConfig;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class QRScannerActivity extends AppCompatActivity {
    public static final /* synthetic */ int $r8$clinit = 0;
    public ExecutorService analysisExecutor;
    public WorkLauncherImpl binding;
    public boolean showCloseButton;
    public boolean showTorchToggle;
    public boolean useFrontCamera;
    public int[] barcodeFormats = {256};
    public boolean hapticFeedback = true;

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) throws Exception {
        ParcelableScannerConfig parcelableScannerConfig;
        super.onCreate(bundle);
        int i = getApplicationInfo().theme;
        View viewInflate = (i != 0 ? getLayoutInflater().cloneInContext(new ContextThemeWrapper(this, i)) : getLayoutInflater()).inflate(R.layout.quickie_scanner_activity, (ViewGroup) null, false);
        int i2 = R.id.overlay_view;
        QROverlayView qROverlayView = (QROverlayView) ViewBindings.findChildViewById(viewInflate, R.id.overlay_view);
        if (qROverlayView != null) {
            i2 = R.id.preview_view;
            PreviewView previewView = (PreviewView) ViewBindings.findChildViewById(viewInflate, R.id.preview_view);
            if (previewView != null) {
                FrameLayout frameLayout = (FrameLayout) viewInflate;
                this.binding = new WorkLauncherImpl(frameLayout, qROverlayView, previewView);
                setContentView(frameLayout);
                WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
                WorkLauncherImpl workLauncherImpl = this.binding;
                if (workLauncherImpl == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    throw null;
                }
                QROverlayView qROverlayView2 = (QROverlayView) workLauncherImpl.processor;
                Util$$ExternalSyntheticLambda0 util$$ExternalSyntheticLambda0 = new Util$$ExternalSyntheticLambda0();
                WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(qROverlayView2, util$$ExternalSyntheticLambda0);
                Intent intent = getIntent();
                if (intent != null && (parcelableScannerConfig = (ParcelableScannerConfig) IntentCompat.getParcelableExtra(intent, "quickie-config", ParcelableScannerConfig.class)) != null) {
                    this.barcodeFormats = parcelableScannerConfig.formats;
                    WorkLauncherImpl workLauncherImpl2 = this.binding;
                    if (workLauncherImpl2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        throw null;
                    }
                    ((QROverlayView) workLauncherImpl2.processor).setCustomText(parcelableScannerConfig.stringRes);
                    WorkLauncherImpl workLauncherImpl3 = this.binding;
                    if (workLauncherImpl3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        throw null;
                    }
                    ((QROverlayView) workLauncherImpl3.processor).setCustomIcon(parcelableScannerConfig.drawableRes);
                    WorkLauncherImpl workLauncherImpl4 = this.binding;
                    if (workLauncherImpl4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        throw null;
                    }
                    ((QROverlayView) workLauncherImpl4.processor).setHorizontalFrameRatio(parcelableScannerConfig.horizontalFrameRatio);
                    this.hapticFeedback = parcelableScannerConfig.hapticFeedback;
                    this.showTorchToggle = parcelableScannerConfig.showTorchToggle;
                    this.useFrontCamera = parcelableScannerConfig.useFrontCamera;
                    this.showCloseButton = parcelableScannerConfig.showCloseButton;
                    if (parcelableScannerConfig.keepScreenOn) {
                        getWindow().addFlags(128);
                    }
                }
                this.analysisExecutor = Executors.newSingleThreadExecutor();
                QRScannerActivity$$ExternalSyntheticLambda0 qRScannerActivity$$ExternalSyntheticLambda0 = new QRScannerActivity$$ExternalSyntheticLambda0(this, 0);
                if (ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") == 0) {
                    qRScannerActivity$$ExternalSyntheticLambda0.invoke(Boolean.TRUE);
                    return;
                } else {
                    registerForActivityResult(new ScanQRCode(4), new OnBackPressedDispatcher$$ExternalSyntheticLambda0(17, qRScannerActivity$$ExternalSyntheticLambda0)).launch("android.permission.CAMERA");
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        ExecutorService executorService = this.analysisExecutor;
        if (executorService != null) {
            executorService.shutdown();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("analysisExecutor");
            throw null;
        }
    }

    public final void onFailure(Exception exc) {
        setResult(3, new Intent().putExtra("quickie-exception", exc));
        finish();
    }
}
