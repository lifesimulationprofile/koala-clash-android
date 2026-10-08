package androidx.compose.ui.platform;

import android.os.Trace;
import android.view.MotionEvent;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AndroidComposeView$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ AndroidComposeView f$0;

    public /* synthetic */ AndroidComposeView$$ExternalSyntheticLambda0(AndroidComposeView androidComposeView, int i) {
        this.$r8$classId = i;
        this.f$0 = androidComposeView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        AndroidComposeView androidComposeView = this.f$0;
        switch (i) {
            case 0:
                Trace.beginSection("AndroidOwner:outOfFrameExecutor");
                while (!androidComposeView.outOfFrameQueue.isEmpty()) {
                    try {
                        ((Function0) androidComposeView.outOfFrameQueue.removeLast()).invoke();
                    } catch (Throwable th) {
                        Trace.endSection();
                        throw th;
                    }
                }
                Unit unit = Unit.INSTANCE;
                Trace.endSection();
                return;
            case 1:
                androidComposeView.hoverExitReceived = false;
                MotionEvent motionEvent = androidComposeView.previousMotionEvent;
                if (motionEvent.getActionMasked() != 10) {
                    throw new IllegalStateException("The ACTION_HOVER_EXIT event was not cleared.");
                }
                androidComposeView.m592sendMotionEvent8iAsVTc(motionEvent);
                return;
            case 2:
                AndroidComposeView.invalidateLayers(androidComposeView.getRoot());
                return;
            default:
                AndroidComposeView.invalidateLayers(androidComposeView.getRoot());
                return;
        }
    }
}
