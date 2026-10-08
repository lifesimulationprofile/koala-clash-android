package com.github.kr328.clash.remote;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.compose.foundation.style.InteractionSet;
import androidx.compose.ui.text.font.Font$ResourceLoader;
import androidx.emoji2.text.ConcurrencyHelpers$$ExternalSyntheticLambda0;
import androidx.emoji2.text.EmojiCompat;
import androidx.work.impl.Processor$$ExternalSyntheticLambda1;
import coil.memory.EmptyStrongMemoryCache;
import coil.network.RealNetworkObserver;
import coil.request.RequestService;
import com.caverock.androidsvg.SVGAndroidRenderer;
import com.github.kr328.clash.common.constants.Authorities;
import com.google.android.datatransport.runtime.DaggerTransportRuntimeComponent;
import com.google.android.datatransport.runtime.ExecutionModule_ExecutorFactory$InstanceHolder;
import com.google.android.datatransport.runtime.dagger.internal.DoubleCheck;
import com.google.android.gms.internal.mlkit_vision_common.zzat;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.inject.Provider;
import okhttp3.ConnectionPool;
import okhttp3.Request;
import okio.AsyncTimeout;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class StatusClient implements Font$ResourceLoader, EmojiCompat.MetadataRepoLoader {
    public Context context;

    public /* synthetic */ StatusClient(Context context, boolean z) {
        this.context = context;
    }

    public DaggerTransportRuntimeComponent build() {
        Context context = this.context;
        if (context == null) {
            throw new IllegalStateException(Context.class.getCanonicalName() + " must be set");
        }
        DaggerTransportRuntimeComponent daggerTransportRuntimeComponent = new DaggerTransportRuntimeComponent();
        daggerTransportRuntimeComponent.executorProvider = DoubleCheck.provider(ExecutionModule_ExecutorFactory$InstanceHolder.INSTANCE);
        InteractionSet interactionSet = new InteractionSet(context);
        daggerTransportRuntimeComponent.setApplicationContextProvider = interactionSet;
        daggerTransportRuntimeComponent.metadataBackendRegistryProvider = DoubleCheck.provider(new RequestService(19, interactionSet, new EmptyStrongMemoryCache(24, interactionSet), false));
        Provider provider = DoubleCheck.provider(new ConnectionPool(6, new EmptyStrongMemoryCache(26, daggerTransportRuntimeComponent.setApplicationContextProvider)));
        daggerTransportRuntimeComponent.sQLiteEventStoreProvider = provider;
        AsyncTimeout.Companion companion = new AsyncTimeout.Companion(15);
        InteractionSet interactionSet2 = daggerTransportRuntimeComponent.setApplicationContextProvider;
        RealNetworkObserver realNetworkObserver = new RealNetworkObserver(interactionSet2, provider, companion, 15, false);
        Provider provider2 = daggerTransportRuntimeComponent.executorProvider;
        Provider provider3 = daggerTransportRuntimeComponent.metadataBackendRegistryProvider;
        Request request = new Request(provider2, provider3, realNetworkObserver, provider, provider, 12);
        SVGAndroidRenderer sVGAndroidRenderer = new SVGAndroidRenderer();
        sVGAndroidRenderer.canvas = interactionSet2;
        sVGAndroidRenderer.document = provider3;
        sVGAndroidRenderer.state = provider;
        sVGAndroidRenderer.stateStack = realNetworkObserver;
        sVGAndroidRenderer.parentStack = provider2;
        sVGAndroidRenderer.matrixStack = provider;
        daggerTransportRuntimeComponent.transportRuntimeProvider = DoubleCheck.provider(new RealNetworkObserver(request, sVGAndroidRenderer, new Request.Builder(provider2, provider, realNetworkObserver, provider), 14, false));
        return daggerTransportRuntimeComponent;
    }

    public String currentProfile() {
        try {
            Bundle bundleCall = this.context.getContentResolver().call(new Uri.Builder().scheme("content").authority(Authorities.STATUS_PROVIDER).build(), "currentProfile", (String) null, (Bundle) null);
            if (bundleCall != null) {
                return bundleCall.getString("name");
            }
            return null;
        } catch (Exception e) {
            Log.w("KoalaClash", "Query current profile: " + e, e);
            return null;
        }
    }

    @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoader
    public void load(zzat zzatVar) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ConcurrencyHelpers$$ExternalSyntheticLambda0("EmojiCompatInitializer"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.execute(new Processor$$ExternalSyntheticLambda1(this, zzatVar, threadPoolExecutor, 12));
    }
}
