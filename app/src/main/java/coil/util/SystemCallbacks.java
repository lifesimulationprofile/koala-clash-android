package coil.util;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import androidx.core.content.ContextCompat;
import coil.RealImageLoader;
import coil.memory.RealMemoryCache;
import coil.network.NetworkObserver;
import coil.network.RealNetworkObserver;
import java.lang.ref.WeakReference;
import okio.AsyncTimeout;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class SystemCallbacks implements ComponentCallbacks2 {
    public boolean _isOnline = true;
    public Context application;
    public final WeakReference imageLoader;
    public NetworkObserver networkObserver;
    public boolean shutdown;

    public SystemCallbacks(RealImageLoader realImageLoader) {
        this.imageLoader = new WeakReference(realImageLoader);
    }

    @Override // android.content.ComponentCallbacks
    public final synchronized void onConfigurationChanged(Configuration configuration) {
        if (((RealImageLoader) this.imageLoader.get()) == null) {
            shutdown();
        }
    }

    @Override // android.content.ComponentCallbacks
    public final synchronized void onLowMemory() {
        onTrimMemory(80);
    }

    @Override // android.content.ComponentCallbacks2
    public final synchronized void onTrimMemory(int i) {
        RealImageLoader realImageLoader = (RealImageLoader) this.imageLoader.get();
        if (realImageLoader != null) {
            RealMemoryCache realMemoryCache = (RealMemoryCache) realImageLoader.memoryCacheLazy.getValue();
            if (realMemoryCache != null) {
                realMemoryCache.strongMemoryCache.trimMemory(i);
                realMemoryCache.weakMemoryCache.trimMemory(i);
            }
        } else {
            shutdown();
        }
    }

    public final synchronized void registerNetworkObserver() {
        NetworkObserver companion;
        try {
            RealImageLoader realImageLoader = (RealImageLoader) this.imageLoader.get();
            if (realImageLoader == null) {
                shutdown();
            } else if (this.networkObserver == null) {
                realImageLoader.options.getClass();
                Context context = realImageLoader.context;
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(ConnectivityManager.class);
                if (connectivityManager == null || ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") != 0) {
                    companion = new AsyncTimeout.Companion(14);
                } else {
                    try {
                        companion = new RealNetworkObserver(connectivityManager, this);
                    } catch (Exception unused) {
                        companion = new AsyncTimeout.Companion(14);
                    }
                }
                this.networkObserver = companion;
                this._isOnline = companion.isOnline();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void shutdown() {
        try {
            if (this.shutdown) {
                return;
            }
            this.shutdown = true;
            Context context = this.application;
            if (context != null) {
                context.unregisterComponentCallbacks(this);
            }
            NetworkObserver networkObserver = this.networkObserver;
            if (networkObserver != null) {
                networkObserver.shutdown();
            }
            this.imageLoader.clear();
        } catch (Throwable th) {
            throw th;
        }
    }
}
