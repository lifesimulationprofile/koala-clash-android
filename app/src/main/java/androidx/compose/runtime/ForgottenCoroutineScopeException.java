package androidx.compose.runtime;

import androidx.compose.ui.internal.PlatformOptimizedCancellationException;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ForgottenCoroutineScopeException extends PlatformOptimizedCancellationException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForgottenCoroutineScopeException(int i) {
        super("rememberCoroutineScope left the composition", 2);
        switch (i) {
            case 1:
                super("The coroutine scope left the composition", 2);
                break;
            default:
                break;
        }
    }
}
