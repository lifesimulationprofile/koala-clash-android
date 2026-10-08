package com.github.kr328.clash.compose.home;

import android.app.Application;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelKt;
import coil.disk.DiskLruCache;
import com.github.kr328.clash.FilesActivity$showError$1;
import com.github.kr328.clash.design.compose.components.ControlButtonState;
import com.github.kr328.clash.remote.Remote;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class HomeViewModel extends AndroidViewModel {
    public final StateFlowImpl _activeProfile;
    public final StateFlowImpl _currentProxy;
    public final StateFlowImpl _loaded;
    public final StateFlowImpl _tunnelStartedAt;
    public final StateFlowImpl _tunnelState;
    public final ReadonlyStateFlow activeProfile;
    public final ReadonlyStateFlow currentProxy;
    public final ReadonlyStateFlow loaded;
    public final HomeViewModel$observer$1 observer;
    public StandaloneCoroutine proxyTickerJob;
    public StandaloneCoroutine transitionWatchdog;
    public final ReadonlyStateFlow tunnelStartedAt;
    public final ReadonlyStateFlow tunnelState;

    public HomeViewModel(Application application) {
        super(application);
        DiskLruCache.Editor editor = Remote.broadcasts;
        StateFlowImpl stateFlowImplMutableStateFlow = FlowKt.MutableStateFlow(editor.closed ? ControlButtonState.Connected : ControlButtonState.Disconnected);
        this._tunnelState = stateFlowImplMutableStateFlow;
        this.tunnelState = FlowKt.asStateFlow(stateFlowImplMutableStateFlow);
        StateFlowImpl stateFlowImplMutableStateFlow2 = FlowKt.MutableStateFlow(null);
        this._activeProfile = stateFlowImplMutableStateFlow2;
        this.activeProfile = FlowKt.asStateFlow(stateFlowImplMutableStateFlow2);
        StateFlowImpl stateFlowImplMutableStateFlow3 = FlowKt.MutableStateFlow(Boolean.FALSE);
        this._loaded = stateFlowImplMutableStateFlow3;
        this.loaded = FlowKt.asStateFlow(stateFlowImplMutableStateFlow3);
        StateFlowImpl stateFlowImplMutableStateFlow4 = FlowKt.MutableStateFlow(null);
        this._currentProxy = stateFlowImplMutableStateFlow4;
        this.currentProxy = FlowKt.asStateFlow(stateFlowImplMutableStateFlow4);
        StateFlowImpl stateFlowImplMutableStateFlow5 = FlowKt.MutableStateFlow(null);
        this._tunnelStartedAt = stateFlowImplMutableStateFlow5;
        this.tunnelStartedAt = FlowKt.asStateFlow(stateFlowImplMutableStateFlow5);
        HomeViewModel$observer$1 homeViewModel$observer$1 = new HomeViewModel$observer$1(0, this);
        this.observer = homeViewModel$observer$1;
        editor.addObserver(homeViewModel$observer$1);
        refreshActiveProfile();
        if (editor.closed) {
            stateFlowImplMutableStateFlow5.updateState(null, Long.valueOf(System.currentTimeMillis()));
            startProxyTicker();
        }
    }

    @Override // androidx.lifecycle.ViewModel
    public final void onCleared() {
        Remote.broadcasts.removeObserver(this.observer);
        StandaloneCoroutine standaloneCoroutine = this.proxyTickerJob;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel((CancellationException) null);
        }
        this.proxyTickerJob = null;
        StandaloneCoroutine standaloneCoroutine2 = this.transitionWatchdog;
        if (standaloneCoroutine2 != null) {
            standaloneCoroutine2.cancel((CancellationException) null);
        }
    }

    public final void refreshActiveProfile() {
        JobKt.launch$default(ViewModelKt.getViewModelScope(this), null, new FilesActivity$showError$1(this, null, 9), 3);
    }

    public final void startProxyTicker() {
        StandaloneCoroutine standaloneCoroutine = this.proxyTickerJob;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel((CancellationException) null);
        }
        this.proxyTickerJob = JobKt.launch$default(ViewModelKt.getViewModelScope(this), JobKt.SupervisorJob$default(), new LazyListState.AnonymousClass2(this, null), 2);
    }
}
