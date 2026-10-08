package androidx.fragment.app;

import android.os.Handler;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity$activityResultRegistry$1;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.work.impl.WorkLauncherImpl;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class FragmentActivity$HostCallbacks extends FragmentContainer implements ViewModelStoreOwner, OnBackPressedDispatcherOwner, ActivityResultRegistryOwner, SavedStateRegistryOwner, FragmentOnAttachListener {
    public final AppCompatActivity mActivity;
    public final AppCompatActivity mContext;
    public final FragmentManagerImpl mFragmentManager;
    public final Handler mHandler;
    public final /* synthetic */ AppCompatActivity this$0;

    public FragmentActivity$HostCallbacks(AppCompatActivity appCompatActivity) {
        this.this$0 = appCompatActivity;
        Handler handler = new Handler();
        this.mFragmentManager = new FragmentManagerImpl();
        this.mActivity = appCompatActivity;
        this.mContext = appCompatActivity;
        this.mHandler = handler;
    }

    @Override // androidx.activity.result.ActivityResultRegistryOwner
    public final ComponentActivity$activityResultRegistry$1 getActivityResultRegistry() {
        return this.this$0.activityResultRegistry;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return this.this$0.mFragmentLifecycleRegistry;
    }

    @Override // androidx.activity.OnBackPressedDispatcherOwner
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.this$0.getOnBackPressedDispatcher();
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public final WorkLauncherImpl getSavedStateRegistry() {
        return (WorkLauncherImpl) this.this$0.savedStateRegistryController.cache;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public final ViewModelStore getViewModelStore() {
        return this.this$0.getViewModelStore();
    }

    @Override // androidx.fragment.app.FragmentContainer
    public final View onFindViewById(int i) {
        return this.this$0.findViewById(i);
    }

    @Override // androidx.fragment.app.FragmentContainer
    public final boolean onHasView() {
        Window window = this.this$0.getWindow();
        return (window == null || window.peekDecorView() == null) ? false : true;
    }

    @Override // androidx.fragment.app.FragmentOnAttachListener
    public final void onAttachFragment$1() {
    }
}
