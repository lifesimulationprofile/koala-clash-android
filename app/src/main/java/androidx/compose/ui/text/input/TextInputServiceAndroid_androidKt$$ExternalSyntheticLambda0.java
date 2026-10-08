package androidx.compose.ui.text.input;

import android.view.Choreographer;
import androidx.profileinstaller.ProfileInstallerInitializer$$ExternalSyntheticLambda0;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TextInputServiceAndroid_androidKt$$ExternalSyntheticLambda0 implements Executor {
    public final /* synthetic */ Choreographer f$0;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f$0.postFrameCallback(new ProfileInstallerInitializer$$ExternalSyntheticLambda0(runnable));
    }
}
