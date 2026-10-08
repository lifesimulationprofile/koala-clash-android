package androidx.activity;

import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigationevent.OnBackInvokedDefaultInput;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ComponentActivity$$ExternalSyntheticLambda13 implements LifecycleEventObserver {
    public final /* synthetic */ OnBackPressedDispatcher f$0;
    public final /* synthetic */ ComponentActivity f$1;

    public /* synthetic */ ComponentActivity$$ExternalSyntheticLambda13(OnBackPressedDispatcher onBackPressedDispatcher, ComponentActivity componentActivity) {
        this.f$0 = onBackPressedDispatcher;
        this.f$1 = componentActivity;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_CREATE) {
            OnBackInvokedDispatcher onBackInvokedDispatcher = this.f$1.getOnBackInvokedDispatcher();
            Dispatcher dispatcher = this.f$0.eventDispatcher;
            dispatcher.addInput(new OnBackInvokedDefaultInput(onBackInvokedDispatcher, 0), 1);
            dispatcher.addInput(new OnBackInvokedDefaultInput(onBackInvokedDispatcher, 1000000), 0);
        }
    }
}
