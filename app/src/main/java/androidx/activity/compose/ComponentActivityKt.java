package androidx.activity.compose;

import android.R;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.platform.ComposeView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ComponentActivityKt {
    public static final ViewGroup.LayoutParams DefaultActivityContentLayoutParams = new ViewGroup.LayoutParams(-2, -2);

    public static void setContent$default(ComponentActivity componentActivity, ComposableLambdaImpl composableLambdaImpl) {
        View childAt = ((ViewGroup) componentActivity.getWindow().getDecorView().findViewById(R.id.content)).getChildAt(0);
        ComposeView composeView = childAt instanceof ComposeView ? (ComposeView) childAt : null;
        if (composeView != null) {
            composeView.setParentCompositionContext(null);
            composeView.setContent(composableLambdaImpl);
            return;
        }
        ComposeView composeView2 = new ComposeView(componentActivity);
        composeView2.setParentCompositionContext(null);
        composeView2.setContent(composableLambdaImpl);
        View decorView = componentActivity.getWindow().getDecorView();
        if (ViewModelKt.get(decorView) == null) {
            ViewModelKt.set(decorView, (LifecycleOwner) componentActivity);
        }
        if (ViewModelKt.m768get(decorView) == null) {
            ViewModelKt.set(decorView, (ViewModelStoreOwner) componentActivity);
        }
        if (ViewTreeSavedStateRegistryOwner.get(decorView) == null) {
            ViewTreeSavedStateRegistryOwner.set(decorView, componentActivity);
        }
        componentActivity.setContentView(composeView2, DefaultActivityContentLayoutParams);
    }
}
