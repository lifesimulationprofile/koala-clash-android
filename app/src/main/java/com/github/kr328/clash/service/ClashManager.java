package com.github.kr328.clash.service;

import android.content.Intent;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import androidx.work.impl.model.WorkTagDao_Impl$1;
import androidx.work.impl.model.WorkTagDao_Impl$2;
import coil.memory.EmptyStrongMemoryCache;
import coil.network.HttpException;
import coil.network.RealNetworkObserver;
import com.github.kr328.clash.common.constants.Intents;
import com.github.kr328.clash.core.Clash$WhenMappings;
import com.github.kr328.clash.core.bridge.Bridge;
import com.github.kr328.clash.core.model.ConnectionInfo;
import com.github.kr328.clash.core.model.Provider;
import com.github.kr328.clash.core.model.ProviderList;
import com.github.kr328.clash.core.model.ProxyGroup;
import com.github.kr328.clash.core.model.ProxySort;
import com.github.kr328.clash.core.model.TunnelState;
import com.github.kr328.clash.core.model.UiConfiguration;
import com.github.kr328.clash.remote.Remote$$ExternalSyntheticLambda1;
import com.github.kr328.clash.service.data.Database;
import com.github.kr328.clash.service.data.Database_Impl;
import com.github.kr328.clash.service.data.Selection;
import com.github.kr328.clash.service.remote.IClashManager;
import com.github.kr328.clash.service.remote.ILogObserver;
import com.github.kr328.clash.service.store.ServiceStore;
import com.github.kr328.clash.service.util.BroadcastKt;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.CompletableDeferredImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonImpl;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import kotlinx.serialization.json.internal.JsonPrimitiveDecoder;
import kotlinx.serialization.json.internal.JsonTreeDecoder;
import kotlinx.serialization.json.internal.JsonTreeListDecoder;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ClashManager implements IClashManager, CoroutineScope {
    public final /* synthetic */ ContextScope $$delegate_0;
    public final JsonImpl cacheJson;
    public final ArrayList closedConnectionsCache;
    public final ArrayListSerializer closedSerializer;
    public final RemoteService context;
    public BufferedChannel logReceiver;
    public final ServiceStore store;

    public ClashManager(RemoteService remoteService) {
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        this.$$delegate_0 = JobKt.CoroutineScope(DefaultIoScheduler.INSTANCE);
        this.context = remoteService;
        this.store = new ServiceStore(remoteService);
        this.closedConnectionsCache = new ArrayList();
        this.cacheJson = JsonKt.Json$default(new Remote$$ExternalSyntheticLambda1(4));
        this.closedSerializer = new ArrayListSerializer(ConnectionInfo.Companion.serializer());
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final void addClosedConnections(String str) {
        List list = (List) this.cacheJson.decodeFromString(str, this.closedSerializer);
        synchronized (this.closedConnectionsCache) {
            try {
                this.closedConnectionsCache.addAll(0, list);
                if (this.closedConnectionsCache.size() > 100) {
                    ArrayList arrayList = this.closedConnectionsCache;
                    arrayList.subList(100, arrayList.size()).clear();
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final void clearClosedConnections() {
        synchronized (this.closedConnectionsCache) {
            this.closedConnectionsCache.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final void closeAllConnections() {
        Bridge.INSTANCE.nativeCloseAllConnections();
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final void closeConnection(String str) {
        Bridge.INSTANCE.nativeCloseConnection(str);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.coroutineContext;
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final Object healthCheck(String str, Continuation continuation) throws Throwable {
        CompletableDeferredImpl completableDeferredImplCompletableDeferred$default = JobKt.CompletableDeferred$default();
        Bridge.INSTANCE.nativeHealthCheck(completableDeferredImplCompletableDeferred$default, str);
        Object objAwaitInternal = completableDeferredImplCompletableDeferred$default.awaitInternal(continuation);
        return objAwaitInternal == CoroutineSingletons.COROUTINE_SUSPENDED ? objAwaitInternal : Unit.INSTANCE;
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final Object healthCheckProxy(String str, String str2, Continuation continuation) throws Throwable {
        CompletableDeferredImpl completableDeferredImplCompletableDeferred$default = JobKt.CompletableDeferred$default();
        Bridge.INSTANCE.nativeHealthCheckProxy(completableDeferredImplCompletableDeferred$default, str, str2);
        Object objAwaitInternal = completableDeferredImplCompletableDeferred$default.awaitInternal(continuation);
        return objAwaitInternal == CoroutineSingletons.COROUTINE_SUSPENDED ? objAwaitInternal : Unit.INSTANCE;
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final void patchOverrideMode(TunnelState.Mode mode) {
        String str;
        int i = mode == null ? -1 : Clash$WhenMappings.$EnumSwitchMapping$0[mode.ordinal()];
        if (i == 1) {
            str = "direct";
        } else if (i != 2) {
            str = i != 3 ? "" : "rule";
        } else {
            str = "global";
        }
        Bridge.INSTANCE.nativeWriteOverrideMode(str);
        BroadcastKt.sendBroadcastSelf(this.context, new Intent(Intents.ACTION_MODE_CHANGED));
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final boolean patchSelector(String str, String str2) {
        boolean zNativePatchSelector = Bridge.INSTANCE.nativePatchSelector(str, str2);
        UUID activeProfile = this.store.getActiveProfile();
        if (activeProfile == null) {
            return zNativePatchSelector;
        }
        if (zNativePatchSelector) {
            RealNetworkObserver realNetworkObserverOpenSelectionProxyDao = Database.Companion.getDatabase().openSelectionProxyDao();
            Selection selection = new Selection(activeProfile, str, str2);
            Database_Impl database_Impl = (Database_Impl) realNetworkObserverOpenSelectionProxyDao.connectivityManager;
            database_Impl.assertNotSuspendingTransaction();
            database_Impl.beginTransaction();
            try {
                ((WorkTagDao_Impl$1) realNetworkObserverOpenSelectionProxyDao.listener).insert(selection);
                database_Impl.setTransactionSuccessful();
                return zNativePatchSelector;
            } finally {
                database_Impl.internalEndTransaction();
            }
        }
        RealNetworkObserver realNetworkObserverOpenSelectionProxyDao2 = Database.Companion.getDatabase().openSelectionProxyDao();
        Database_Impl database_Impl2 = (Database_Impl) realNetworkObserverOpenSelectionProxyDao2.connectivityManager;
        database_Impl2.assertNotSuspendingTransaction();
        WorkTagDao_Impl$2 workTagDao_Impl$2 = (WorkTagDao_Impl$2) realNetworkObserverOpenSelectionProxyDao2.networkCallback;
        FrameworkSQLiteStatement frameworkSQLiteStatementAcquire = workTagDao_Impl$2.acquire();
        frameworkSQLiteStatementAcquire.bindString(activeProfile.toString(), 1);
        frameworkSQLiteStatementAcquire.bindString(str, 2);
        try {
            database_Impl2.beginTransaction();
            try {
                frameworkSQLiteStatementAcquire.executeUpdateDelete();
                database_Impl2.setTransactionSuccessful();
                database_Impl2.internalEndTransaction();
                workTagDao_Impl$2.release(frameworkSQLiteStatementAcquire);
                return zNativePatchSelector;
            } catch (Throwable th) {
                database_Impl2.internalEndTransaction();
                throw th;
            }
        } catch (Throwable th2) {
            workTagDao_Impl$2.release(frameworkSQLiteStatementAcquire);
            throw th2;
        }
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final String queryClosedConnections() {
        String strEncodeToString;
        synchronized (this.closedConnectionsCache) {
            strEncodeToString = this.cacheJson.encodeToString(this.closedSerializer, CollectionsKt.toList(this.closedConnectionsCache));
        }
        return strEncodeToString;
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final TunnelState.Mode queryConfigMode() {
        String strNativeReadConfigMode = Bridge.INSTANCE.nativeReadConfigMode();
        int iHashCode = strNativeReadConfigMode.hashCode();
        if (iHashCode == -1331586071) {
            if (strNativeReadConfigMode.equals("direct")) {
                return TunnelState.Mode.Direct;
            }
            return null;
        }
        if (iHashCode == -1243020381) {
            if (strNativeReadConfigMode.equals("global")) {
                return TunnelState.Mode.Global;
            }
            return null;
        }
        if (iHashCode == 3512060 && strNativeReadConfigMode.equals("rule")) {
            return TunnelState.Mode.Rule;
        }
        return null;
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final UiConfiguration queryConfiguration() {
        return (UiConfiguration) Json.Default.decodeFromString(Bridge.INSTANCE.nativeQueryConfiguration(), UiConfiguration.CREATOR.serializer());
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final String queryConnections() {
        return Bridge.INSTANCE.nativeQueryConnections();
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final TunnelState.Mode queryOverrideMode() {
        String strNativeReadOverrideMode = Bridge.INSTANCE.nativeReadOverrideMode();
        int iHashCode = strNativeReadOverrideMode.hashCode();
        if (iHashCode == -1331586071) {
            if (strNativeReadOverrideMode.equals("direct")) {
                return TunnelState.Mode.Direct;
            }
            return null;
        }
        if (iHashCode == -1243020381) {
            if (strNativeReadOverrideMode.equals("global")) {
                return TunnelState.Mode.Global;
            }
            return null;
        }
        if (iHashCode == 3512060 && strNativeReadOverrideMode.equals("rule")) {
            return TunnelState.Mode.Rule;
        }
        return null;
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final ProviderList queryProviders() {
        Decoder jsonPrimitiveDecoder;
        JsonArray jsonArray = (JsonArray) Json.Default.decodeFromString(Bridge.INSTANCE.nativeQueryProviders(), JsonArray.Companion.serializer());
        int size = jsonArray.content.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            Json.Default r5 = Json.Default;
            KSerializer kSerializerSerializer = Provider.CREATOR.serializer();
            JsonElement jsonElement = (JsonElement) jsonArray.content.get(i);
            r5.getClass();
            String str = null;
            if (jsonElement instanceof JsonObject) {
                jsonPrimitiveDecoder = new JsonTreeDecoder(r5, (JsonObject) jsonElement, str, 12);
            } else if (jsonElement instanceof JsonArray) {
                jsonPrimitiveDecoder = new JsonTreeListDecoder(r5, (JsonArray) jsonElement);
            } else {
                if (!(jsonElement instanceof JsonLiteral) && !jsonElement.equals(JsonNull.INSTANCE)) {
                    throw new HttpException();
                }
                jsonPrimitiveDecoder = new JsonPrimitiveDecoder(r5, (JsonPrimitive) jsonElement, null);
            }
            arrayList.add((Provider) jsonPrimitiveDecoder.decodeSerializableValue(kSerializerSerializer));
        }
        return new ProviderList(arrayList);
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final ProxyGroup queryProxyGroup(String str, ProxySort proxySort) {
        ProxyGroup proxyGroup;
        String strNativeQueryGroup = Bridge.INSTANCE.nativeQueryGroup(str, proxySort.name());
        return (strNativeQueryGroup == null || (proxyGroup = (ProxyGroup) Json.Default.decodeFromString(strNativeQueryGroup, ProxyGroup.CREATOR.serializer())) == null) ? new ProxyGroup() : proxyGroup;
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final List queryProxyGroupNames(boolean z) {
        JsonArray jsonArray = (JsonArray) Json.Default.decodeFromString(Bridge.INSTANCE.nativeQueryGroupNames(z), JsonArray.Companion.serializer());
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(jsonArray, 10));
        for (JsonElement jsonElement : jsonArray.content) {
            if (!JsonElementKt.getJsonPrimitive(jsonElement).isString()) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            arrayList.add(JsonElementKt.getJsonPrimitive(jsonElement).getContent());
        }
        return arrayList;
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final long queryTrafficTotal() {
        return Bridge.INSTANCE.nativeQueryTrafficTotal();
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final TunnelState queryTunnelState() {
        return (TunnelState) Json.Default.decodeFromString(Bridge.INSTANCE.nativeQueryTunnelState(), TunnelState.CREATOR.serializer());
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final void setLogObserver(ILogObserver iLogObserver) {
        synchronized (this) {
            try {
                BufferedChannel bufferedChannel = this.logReceiver;
                Continuation continuation = null;
                if (bufferedChannel != null) {
                    bufferedChannel.cancel(null);
                    Bridge.INSTANCE.nativeForceGc();
                }
                if (iLogObserver != null) {
                    BufferedChannel bufferedChannelChannel$default = ChannelKt.Channel$default(32, 0, 6);
                    int i = 22;
                    Bridge.INSTANCE.nativeSubscribeLogcat(new EmptyStrongMemoryCache(i, bufferedChannelChannel$default));
                    JobKt.launch$default(this, null, new NavHostKt$NavHost$29$1(iLogObserver, bufferedChannelChannel$default, continuation, i), 3);
                    this.logReceiver = bufferedChannelChannel$default;
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final Object updateProvider(Provider.Type type, String str, Continuation continuation) throws Throwable {
        CompletableDeferredImpl completableDeferredImplCompletableDeferred$default = JobKt.CompletableDeferred$default();
        Bridge.INSTANCE.nativeUpdateProvider(completableDeferredImplCompletableDeferred$default, type.toString(), str);
        Object objAwaitInternal = completableDeferredImplCompletableDeferred$default.awaitInternal(continuation);
        return objAwaitInternal == CoroutineSingletons.COROUTINE_SUSPENDED ? objAwaitInternal : Unit.INSTANCE;
    }
}
