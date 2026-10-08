package androidx.compose.material3;

import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import kotlin.jvm.functions.Function0;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultBasicAlertDialogOverride {
    public static final DefaultBasicAlertDialogOverride INSTANCE = new DefaultBasicAlertDialogOverride();

    public final void BasicAlertDialog(Request.Builder builder, GapComposer gapComposer, int i) {
        gapComposer.startRestartGroup(1565826668);
        int i2 = (gapComposer.changed(builder) ? 4 : 2) | i;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 3) != 2)) {
            AndroidDialog_androidKt.Dialog((Function0) builder.url, (DialogProperties) builder.headers, Thread_jvmKt.rememberComposableLambda(1163527043, new Updater$$ExternalSyntheticLambda0(17, builder), gapComposer), gapComposer, 384);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TextKt$$ExternalSyntheticLambda2(this, builder, i, 13);
        }
    }
}
