package coil.network;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.net.Uri;
import android.os.SystemClock;
import android.util.Base64;
import android.view.Choreographer;
import androidx.appcompat.widget.TooltipPopup;
import androidx.camera.camera2.internal.Camera2CameraImpl;
import androidx.camera.camera2.internal.Camera2CameraImpl$ErrorTimeoutReopenScheduler$ScheduleNode$$ExternalSyntheticLambda0;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.camera2.internal.ZoomControl;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.collection.SimpleArrayMap;
import androidx.compose.animation.FlingCalculator;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda1;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.runtime.internal.AtomicInt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.SortedSet;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.intl.PlatformLocaleDelegate;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure$Measure;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.work.Worker;
import androidx.work.impl.StartStopTokens;
import androidx.work.impl.model.WorkTagDao_Impl$1;
import androidx.work.impl.model.WorkTagDao_Impl$2;
import coil.RealImageLoader;
import coil.memory.EmptyStrongMemoryCache;
import coil.network.RealNetworkObserver;
import coil.util.SystemCallbacks;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGAndroidRenderer;
import com.github.kr328.clash.service.data.Database_Impl;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AutoValue_SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.persistence.AutoValue_EventStoreConfig;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import com.google.android.gms.tasks.zzt;
import com.google.mlkit.common.internal.zzd;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Provider;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Dispatcher;
import okhttp3.Request;
import okio.AsyncTimeout;
import okio.ByteString;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class RealNetworkObserver implements CallbackToFutureAdapter.Resolver, FutureCallback, PlatformLocaleDelegate, NetworkObserver, Factory, SQLiteEventStore.Function {
    public final /* synthetic */ int $r8$classId;
    public Object connectivityManager;
    public Object listener;
    public Object networkCallback;

    public /* synthetic */ RealNetworkObserver(Object obj, Object obj2, Object obj3, int i) {
        this.$r8$classId = i;
        this.networkCallback = obj;
        this.connectivityManager = obj2;
        this.listener = obj3;
    }

    public static final void access$onConnectivityChange(RealNetworkObserver realNetworkObserver, Network network, boolean z) {
        boolean z2;
        boolean z3 = false;
        for (Network network2 : ((ConnectivityManager) realNetworkObserver.connectivityManager).getAllNetworks()) {
            if (Intrinsics.areEqual(network2, network)) {
                z2 = z;
            } else {
                NetworkCapabilities networkCapabilities = ((ConnectivityManager) realNetworkObserver.connectivityManager).getNetworkCapabilities(network2);
                z2 = networkCapabilities != null && networkCapabilities.hasCapability(12);
            }
            if (z2) {
                z3 = true;
                break;
            }
        }
        SystemCallbacks systemCallbacks = (SystemCallbacks) realNetworkObserver.listener;
        synchronized (systemCallbacks) {
            try {
                if (((RealImageLoader) systemCallbacks.imageLoader.get()) != null) {
                    systemCallbacks._isOnline = z3;
                } else {
                    systemCallbacks.shutdown();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void add(int i, LayoutNode layoutNode) {
        EmptyStrongMemoryCache emptyStrongMemoryCache = (EmptyStrongMemoryCache) this.connectivityManager;
        EmptyStrongMemoryCache emptyStrongMemoryCache2 = (EmptyStrongMemoryCache) this.listener;
        EmptyStrongMemoryCache emptyStrongMemoryCache3 = (EmptyStrongMemoryCache) this.networkCallback;
        int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i);
        if (iOrdinal == 0) {
            emptyStrongMemoryCache.add(layoutNode);
            emptyStrongMemoryCache3.add(layoutNode);
            return;
        }
        if (iOrdinal == 1) {
            emptyStrongMemoryCache2.add(layoutNode);
            emptyStrongMemoryCache3.add(layoutNode);
            return;
        }
        if (iOrdinal == 2) {
            if (layoutNode.lookaheadRoot != null) {
                emptyStrongMemoryCache3.add(layoutNode);
                return;
            } else {
                emptyStrongMemoryCache.add(layoutNode);
                return;
            }
        }
        if (iOrdinal != 3) {
            throw new HttpException();
        }
        if (layoutNode.lookaheadRoot != null) {
            emptyStrongMemoryCache3.add(layoutNode);
        } else {
            emptyStrongMemoryCache2.add(layoutNode);
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        long jInsert;
        SQLiteEventStore sQLiteEventStore = (SQLiteEventStore) this.connectivityManager;
        AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) this.listener;
        AutoValue_EventInternal autoValue_EventInternal = (AutoValue_EventInternal) this.networkCallback;
        EncodedPayload encodedPayload = autoValue_EventInternal.encodedPayload;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        Encoding encoding = SQLiteEventStore.PROTOBUF_ENCODING;
        long jSimpleQueryForLong = sQLiteEventStore.getDb().compileStatement("PRAGMA page_size").simpleQueryForLong() * sQLiteEventStore.getDb().compileStatement("PRAGMA page_count").simpleQueryForLong();
        AutoValue_EventStoreConfig autoValue_EventStoreConfig = sQLiteEventStore.config;
        if (jSimpleQueryForLong >= autoValue_EventStoreConfig.maxStorageSizeInBytes) {
            return -1L;
        }
        Long transportContextId = SQLiteEventStore.getTransportContextId(sQLiteDatabase, autoValue_TransportContext);
        if (transportContextId != null) {
            jInsert = transportContextId.longValue();
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put("backend_name", autoValue_TransportContext.backendName);
            contentValues.put("priority", Integer.valueOf(PriorityMapping.toInt(autoValue_TransportContext.priority)));
            contentValues.put("next_request_ms", (Integer) 0);
            byte[] bArr = autoValue_TransportContext.extras;
            if (bArr != null) {
                contentValues.put("extras", Base64.encodeToString(bArr, 0));
            }
            jInsert = sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        int i = autoValue_EventStoreConfig.maxBlobByteSizePerRow;
        byte[] bArr2 = encodedPayload.bytes;
        boolean z = bArr2.length <= i;
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("context_id", Long.valueOf(jInsert));
        contentValues2.put("transport_name", autoValue_EventInternal.transportName);
        contentValues2.put("timestamp_ms", Long.valueOf(autoValue_EventInternal.eventMillis));
        contentValues2.put("uptime_ms", Long.valueOf(autoValue_EventInternal.uptimeMillis));
        contentValues2.put("payload_encoding", encodedPayload.encoding.name);
        contentValues2.put("code", autoValue_EventInternal.code);
        contentValues2.put("num_attempts", (Integer) 0);
        contentValues2.put("inline", Boolean.valueOf(z));
        contentValues2.put("payload", z ? bArr2 : new byte[0]);
        long jInsert2 = sQLiteDatabase.insert("events", null, contentValues2);
        if (!z) {
            int iCeil = (int) Math.ceil(((double) bArr2.length) / ((double) i));
            for (int i2 = 1; i2 <= iCeil; i2++) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr2, (i2 - 1) * i, Math.min(i2 * i, bArr2.length));
                ContentValues contentValues3 = new ContentValues();
                contentValues3.put("event_id", Long.valueOf(jInsert2));
                contentValues3.put("sequence_num", Integer.valueOf(i2));
                contentValues3.put("bytes", bArrCopyOfRange);
                sQLiteDatabase.insert("event_payloads", null, contentValues3);
            }
        }
        for (Map.Entry entry : Collections.unmodifiableMap(autoValue_EventInternal.autoMetadata).entrySet()) {
            ContentValues contentValues4 = new ContentValues();
            contentValues4.put("event_id", Long.valueOf(jInsert2));
            contentValues4.put("name", (String) entry.getKey());
            contentValues4.put("value", (String) entry.getValue());
            sQLiteDatabase.insert("event_metadata", null, contentValues4);
        }
        return Long.valueOf(jInsert2);
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        Worker.AnonymousClass1 anonymousClass1 = new Worker.AnonymousClass1(5, this);
        zzt zztVarDirectExecutor = SetsKt.directExecutor();
        ResolvableFuture resolvableFuture = completer.cancellationFuture;
        if (resolvableFuture != null) {
            resolvableFuture.addListener(anonymousClass1, zztVarDirectExecutor);
        }
        ((HandlerScheduledExecutorService.HandlerScheduledFuture) this.networkCallback).mCompleter.set(completer);
        return "HandlerScheduledFuture-" + ((Callable) this.listener).toString();
    }

    public boolean contains(LayoutNode layoutNode) {
        return !(layoutNode.lookaheadRoot == null) && (((SortedSet) ((EmptyStrongMemoryCache) this.connectivityManager).weakMemoryCache).contains(layoutNode) || ((SortedSet) ((EmptyStrongMemoryCache) this.listener).weakMemoryCache).contains(layoutNode));
    }

    @Override // javax.inject.Provider
    public Object get() {
        switch (this.$r8$classId) {
            case 14:
                return new TransportRuntime(new Path.Companion(16), new ByteString.Companion(15), (Scheduler) ((Request) this.connectivityManager).get(), (TooltipPopup) ((SVGAndroidRenderer) this.listener).get(), (Dispatcher) ((Request.Builder) this.networkCallback).get());
            default:
                return new SVG((Context) ((Provider) this.connectivityManager).get(), (EventStore) ((Provider) this.listener).get(), (AutoValue_SchedulerConfig) ((AsyncTimeout.Companion) this.networkCallback).get(), 16);
        }
    }

    @Override // androidx.compose.ui.text.intl.PlatformLocaleDelegate
    public LocaleList getCurrent() {
        android.os.LocaleList localeList = android.os.LocaleList.getDefault();
        synchronized (((zzd) this.networkCallback)) {
            try {
                LocaleList localeList2 = (LocaleList) this.listener;
                if (localeList2 != null && localeList == ((android.os.LocaleList) this.connectivityManager)) {
                    return localeList2;
                }
                int size = localeList.size();
                ArrayList arrayList = new ArrayList(size);
                for (int i = 0; i < size; i++) {
                    arrayList.add(new Locale(localeList.get(i)));
                }
                LocaleList localeList3 = new LocaleList(arrayList);
                this.connectivityManager = localeList;
                this.listener = localeList3;
                return localeList3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean isNotEmpty() {
        return !(((SortedSet) ((EmptyStrongMemoryCache) this.connectivityManager).weakMemoryCache).isEmpty() && ((SortedSet) ((EmptyStrongMemoryCache) this.networkCallback).weakMemoryCache).isEmpty() && ((SortedSet) ((EmptyStrongMemoryCache) this.listener).weakMemoryCache).isEmpty());
    }

    @Override // coil.network.NetworkObserver
    public boolean isOnline() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.connectivityManager;
        for (Network network : connectivityManager.getAllNetworks()) {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
            if (networkCapabilities != null && networkCapabilities.hasCapability(12)) {
                return true;
            }
        }
        return false;
    }

    public boolean measure(ConstraintLayout.Measurer measurer, ConstraintWidget constraintWidget, boolean z) {
        BasicMeasure$Measure basicMeasure$Measure = (BasicMeasure$Measure) this.listener;
        int[] iArr = constraintWidget.mListDimensionBehaviors;
        int[] iArr2 = constraintWidget.mResolvedMatchConstraintDefault;
        basicMeasure$Measure.horizontalBehavior = iArr[0];
        basicMeasure$Measure.verticalBehavior = iArr[1];
        basicMeasure$Measure.horizontalDimension = constraintWidget.getWidth();
        basicMeasure$Measure.verticalDimension = constraintWidget.getHeight();
        basicMeasure$Measure.measuredNeedsSolverPass = false;
        basicMeasure$Measure.useCurrentDimensions = z;
        boolean z2 = basicMeasure$Measure.horizontalBehavior == 3;
        boolean z3 = basicMeasure$Measure.verticalBehavior == 3;
        boolean z4 = z2 && constraintWidget.mDimensionRatio > 0.0f;
        boolean z5 = z3 && constraintWidget.mDimensionRatio > 0.0f;
        if (z4 && iArr2[0] == 4) {
            basicMeasure$Measure.horizontalBehavior = 1;
        }
        if (z5 && iArr2[1] == 4) {
            basicMeasure$Measure.verticalBehavior = 1;
        }
        measurer.measure(constraintWidget, basicMeasure$Measure);
        constraintWidget.setWidth(basicMeasure$Measure.measuredWidth);
        constraintWidget.setHeight(basicMeasure$Measure.measuredHeight);
        constraintWidget.hasBaseline = basicMeasure$Measure.measuredHasBaseline;
        int i = basicMeasure$Measure.measuredBaseline;
        constraintWidget.mBaselineDistance = i;
        constraintWidget.hasBaseline = i > 0;
        basicMeasure$Measure.useCurrentDimensions = false;
        return basicMeasure$Measure.measuredNeedsSolverPass;
    }

    @Override // androidx.camera.core.impl.utils.futures.FutureCallback
    public void onFailure(Throwable th) {
        ((ZoomControl) this.networkCallback).mCaptureResultListener = null;
        ArrayList arrayList = (ArrayList) this.connectivityManager;
        if (arrayList.isEmpty()) {
            return;
        }
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((CameraInfoInternal) this.listener).removeSessionCaptureCallback((CameraCaptureCallback) obj);
        }
        arrayList.clear();
    }

    @Override // androidx.camera.core.impl.utils.futures.FutureCallback
    public void onSuccess(Object obj) {
        ((ZoomControl) this.networkCallback).mCaptureResultListener = null;
    }

    @Override // coil.network.NetworkObserver
    public void shutdown() {
        ((ConnectivityManager) this.connectivityManager).unregisterNetworkCallback((RealNetworkObserver$networkCallback$1) this.networkCallback);
    }

    public void solveLinearSystem(ConstraintWidgetContainer constraintWidgetContainer, int i, int i2) {
        int i3 = constraintWidgetContainer.mMinWidth;
        int i4 = constraintWidgetContainer.mMinHeight;
        constraintWidgetContainer.mMinWidth = 0;
        constraintWidgetContainer.mMinHeight = 0;
        constraintWidgetContainer.setWidth(i);
        constraintWidgetContainer.setHeight(i2);
        if (i3 < 0) {
            constraintWidgetContainer.mMinWidth = 0;
        } else {
            constraintWidgetContainer.mMinWidth = i3;
        }
        if (i4 < 0) {
            constraintWidgetContainer.mMinHeight = 0;
        } else {
            constraintWidgetContainer.mMinHeight = i4;
        }
        ((ConstraintWidgetContainer) this.networkCallback).layout();
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 12:
                String str = (String) this.networkCallback;
                String str2 = (String) this.listener;
                StringBuilder sb = new StringBuilder("NavDeepLinkRequest{");
                Uri uri = (Uri) this.connectivityManager;
                if (uri != null) {
                    sb.append(" uri=");
                    sb.append(String.valueOf(uri));
                }
                if (str2 != null) {
                    sb.append(" action=");
                    sb.append(str2);
                }
                if (str != null) {
                    sb.append(" mimetype=");
                    sb.append(str);
                }
                sb.append(" }");
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public void unregister() {
        MutableScatterMap mutableScatterMap = (MutableScatterMap) this.connectivityManager;
        String str = (String) this.listener;
        List list = (List) mutableScatterMap.remove(str);
        if (list != null) {
            list.remove((Function0) this.networkCallback);
        }
        if (list == null || list.isEmpty()) {
            return;
        }
        mutableScatterMap.set(str, list);
    }

    public /* synthetic */ RealNetworkObserver(Object obj, Object obj2, Object obj3, int i, boolean z) {
        this.$r8$classId = i;
        this.connectivityManager = obj;
        this.listener = obj2;
        this.networkCallback = obj3;
    }

    public RealNetworkObserver(Recomposer$$ExternalSyntheticLambda1 recomposer$$ExternalSyntheticLambda1) {
        this.$r8$classId = 6;
        this.connectivityManager = new AtomicInt(0);
        this.listener = new Request(6);
        this.networkCallback = new Recomposer$$ExternalSyntheticLambda6(18, this, recomposer$$ExternalSyntheticLambda1);
    }

    public RealNetworkObserver(Database_Impl database_Impl) {
        this.$r8$classId = 1;
        this.connectivityManager = database_Impl;
        this.listener = new WorkTagDao_Impl$1(this, database_Impl, 8);
        this.networkCallback = new WorkTagDao_Impl$2(database_Impl, 21);
    }

    public RealNetworkObserver(Intent intent) {
        this.$r8$classId = 12;
        Uri data = intent.getData();
        String action = intent.getAction();
        String type = intent.getType();
        this.connectivityManager = data;
        this.listener = action;
        this.networkCallback = type;
    }

    public RealNetworkObserver(ConnectivityManager connectivityManager, SystemCallbacks systemCallbacks) {
        this.$r8$classId = 0;
        this.connectivityManager = connectivityManager;
        this.listener = systemCallbacks;
        RealNetworkObserver$networkCallback$1 realNetworkObserver$networkCallback$1 = new RealNetworkObserver$networkCallback$1(0, this);
        this.networkCallback = realNetworkObserver$networkCallback$1;
        connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).build(), realNetworkObserver$networkCallback$1);
    }

    public RealNetworkObserver(ConstraintWidgetContainer constraintWidgetContainer) {
        this.$r8$classId = 10;
        this.connectivityManager = new ArrayList();
        this.listener = new BasicMeasure$Measure();
        this.networkCallback = constraintWidgetContainer;
    }

    public RealNetworkObserver(EmptyStrongMemoryCache emptyStrongMemoryCache) {
        this.$r8$classId = 11;
        this.$r8$classId = 11;
        this.connectivityManager = emptyStrongMemoryCache;
        this.listener = Choreographer.getInstance();
        this.networkCallback = new Choreographer.FrameCallback() { // from class: androidx.dynamicanimation.animation.AnimationHandler$FrameCallbackProvider16$1
            /* JADX WARN: Code duplicated, block: B:16:0x0048  */
            /* JADX WARN: Code duplicated, block: B:17:0x0050  */
            /* JADX WARN: Code duplicated, block: B:19:0x005f  */
            /* JADX WARN: Code duplicated, block: B:21:0x0065  */
            /* JADX WARN: Code duplicated, block: B:24:0x007d  */
            /* JADX WARN: Code duplicated, block: B:26:0x0083  */
            /* JADX WARN: Code duplicated, block: B:27:0x00c1  */
            /* JADX WARN: Code duplicated, block: B:36:0x012f  */
            /* JADX WARN: Code duplicated, block: B:38:0x013c  */
            /* JADX WARN: Code duplicated, block: B:41:0x0157  */
            /* JADX WARN: Code duplicated, block: B:45:0x016c  */
            /* JADX WARN: Code duplicated, block: B:47:0x0172 A[LOOP:1: B:43:0x0166->B:47:0x0172, LOOP_END] */
            /* JADX WARN: Code duplicated, block: B:52:0x018c  */
            /* JADX WARN: Code duplicated, block: B:54:0x0192  */
            /* JADX WARN: Code duplicated, block: B:74:0x0175 A[SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:76:0x0198 A[SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:7:0x0026  */
            /* JADX WARN: Code duplicated, block: B:80:0x0195 A[SYNTHETIC] */
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j) {
                long j2;
                long j3;
                float f;
                int i;
                float f2;
                SpringForce springForce;
                boolean z;
                ArrayList arrayList;
                ThreadLocal threadLocal;
                AnimationHandler animationHandler;
                ArrayList arrayList2;
                int iIndexOf;
                int i2;
                int size;
                float f3;
                AnimationHandler animationHandler2 = (AnimationHandler) ((EmptyStrongMemoryCache) this.this$0.connectivityManager).weakMemoryCache;
                long jUptimeMillis = SystemClock.uptimeMillis();
                ArrayList arrayList3 = animationHandler2.mAnimationCallbacks;
                long jUptimeMillis2 = SystemClock.uptimeMillis();
                boolean z2 = false;
                int i3 = 0;
                while (i3 < arrayList3.size()) {
                    SpringAnimation springAnimation = (SpringAnimation) arrayList3.get(i3);
                    if (springAnimation == null) {
                        i = i3;
                    } else {
                        SimpleArrayMap simpleArrayMap = animationHandler2.mDelayedCallbackStartTime;
                        Long l = (Long) simpleArrayMap.get(springAnimation);
                        if (l == null) {
                            j2 = springAnimation.mLastFrameTime;
                            if (j2 == 0) {
                                springAnimation.mLastFrameTime = jUptimeMillis;
                                springAnimation.setPropertyValue(springAnimation.mValue);
                                i = i3;
                            } else {
                                j3 = jUptimeMillis - j2;
                                springAnimation.mLastFrameTime = jUptimeMillis;
                                f = Float.MAX_VALUE;
                                if (springAnimation.mEndRequested) {
                                    f3 = springAnimation.mPendingPosition;
                                    if (f3 != Float.MAX_VALUE) {
                                        springAnimation.mSpring.mFinalPosition = f3;
                                        springAnimation.mPendingPosition = Float.MAX_VALUE;
                                    }
                                    springAnimation.mValue = (float) springAnimation.mSpring.mFinalPosition;
                                    springAnimation.mVelocity = 0.0f;
                                    springAnimation.mEndRequested = z2;
                                    i = i3;
                                    f = Float.MAX_VALUE;
                                } else {
                                    if (springAnimation.mPendingPosition != Float.MAX_VALUE) {
                                        SpringForce springForce2 = springAnimation.mSpring;
                                        double d = springForce2.mFinalPosition;
                                        i = i3;
                                        long j4 = j3 / 2;
                                        FlingCalculator flingCalculatorUpdateValues = springForce2.updateValues(springAnimation.mValue, springAnimation.mVelocity, j4);
                                        SpringForce springForce3 = springAnimation.mSpring;
                                        springForce3.mFinalPosition = springAnimation.mPendingPosition;
                                        springAnimation.mPendingPosition = Float.MAX_VALUE;
                                        FlingCalculator flingCalculatorUpdateValues2 = springForce3.updateValues(flingCalculatorUpdateValues.friction, flingCalculatorUpdateValues.magicPhysicalCoefficient, j4);
                                        springAnimation.mValue = flingCalculatorUpdateValues2.friction;
                                        springAnimation.mVelocity = flingCalculatorUpdateValues2.magicPhysicalCoefficient;
                                    } else {
                                        i = i3;
                                        FlingCalculator flingCalculatorUpdateValues3 = springAnimation.mSpring.updateValues(springAnimation.mValue, springAnimation.mVelocity, j3);
                                        springAnimation.mValue = flingCalculatorUpdateValues3.friction;
                                        springAnimation.mVelocity = flingCalculatorUpdateValues3.magicPhysicalCoefficient;
                                    }
                                    float fMax = Math.max(springAnimation.mValue, -3.4028235E38f);
                                    springAnimation.mValue = fMax;
                                    float fMin = Math.min(fMax, f);
                                    springAnimation.mValue = fMin;
                                    f2 = springAnimation.mVelocity;
                                    springForce = springAnimation.mSpring;
                                    springForce.getClass();
                                    if (Math.abs(f2) < springForce.mVelocityThreshold) {
                                    }
                                    z = false;
                                    float fMin2 = Math.min(springAnimation.mValue, f);
                                    springAnimation.mValue = fMin2;
                                    float fMax2 = Math.max(fMin2, -3.4028235E38f);
                                    springAnimation.mValue = fMax2;
                                    springAnimation.setPropertyValue(fMax2);
                                    if (z) {
                                        arrayList = springAnimation.mEndListeners;
                                        springAnimation.mRunning = false;
                                        threadLocal = AnimationHandler.sAnimatorHandler;
                                        if (threadLocal.get() == null) {
                                            threadLocal.set(new AnimationHandler());
                                        }
                                        animationHandler = (AnimationHandler) threadLocal.get();
                                        animationHandler.mDelayedCallbackStartTime.remove(springAnimation);
                                        arrayList2 = animationHandler.mAnimationCallbacks;
                                        iIndexOf = arrayList2.indexOf(springAnimation);
                                        if (iIndexOf >= 0) {
                                            arrayList2.set(iIndexOf, null);
                                            animationHandler.mListDirty = true;
                                        }
                                        springAnimation.mLastFrameTime = 0L;
                                        springAnimation.mStartValueIsSet = false;
                                        for (i2 = 0; i2 < arrayList.size(); i2++) {
                                            if (arrayList.get(i2) == null) {
                                                arrayList.get(i2).getClass();
                                                throw new ClassCastException();
                                            }
                                        }
                                        for (size = arrayList.size() - 1; size >= 0; size--) {
                                            if (arrayList.get(size) == null) {
                                                arrayList.remove(size);
                                            }
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                                z = true;
                                float fMin3 = Math.min(springAnimation.mValue, f);
                                springAnimation.mValue = fMin3;
                                float fMax3 = Math.max(fMin3, -3.4028235E38f);
                                springAnimation.mValue = fMax3;
                                springAnimation.setPropertyValue(fMax3);
                                if (z) {
                                    arrayList = springAnimation.mEndListeners;
                                    springAnimation.mRunning = false;
                                    threadLocal = AnimationHandler.sAnimatorHandler;
                                    if (threadLocal.get() == null) {
                                        threadLocal.set(new AnimationHandler());
                                    }
                                    animationHandler = (AnimationHandler) threadLocal.get();
                                    animationHandler.mDelayedCallbackStartTime.remove(springAnimation);
                                    arrayList2 = animationHandler.mAnimationCallbacks;
                                    iIndexOf = arrayList2.indexOf(springAnimation);
                                    if (iIndexOf >= 0) {
                                        arrayList2.set(iIndexOf, null);
                                        animationHandler.mListDirty = true;
                                    }
                                    springAnimation.mLastFrameTime = 0L;
                                    springAnimation.mStartValueIsSet = false;
                                    while (i2 < arrayList.size()) {
                                        if (arrayList.get(i2) == null) {
                                            arrayList.get(i2).getClass();
                                            throw new ClassCastException();
                                        }
                                    }
                                    while (size >= 0) {
                                        if (arrayList.get(size) == null) {
                                            arrayList.remove(size);
                                        }
                                    }
                                } else {
                                    continue;
                                }
                            }
                        } else if (l.longValue() < jUptimeMillis2) {
                            simpleArrayMap.remove(springAnimation);
                            j2 = springAnimation.mLastFrameTime;
                            if (j2 == 0) {
                                springAnimation.mLastFrameTime = jUptimeMillis;
                                springAnimation.setPropertyValue(springAnimation.mValue);
                                i = i3;
                            } else {
                                j3 = jUptimeMillis - j2;
                                springAnimation.mLastFrameTime = jUptimeMillis;
                                f = Float.MAX_VALUE;
                                if (springAnimation.mEndRequested) {
                                    f3 = springAnimation.mPendingPosition;
                                    if (f3 != Float.MAX_VALUE) {
                                        springAnimation.mSpring.mFinalPosition = f3;
                                        springAnimation.mPendingPosition = Float.MAX_VALUE;
                                    }
                                    springAnimation.mValue = (float) springAnimation.mSpring.mFinalPosition;
                                    springAnimation.mVelocity = 0.0f;
                                    springAnimation.mEndRequested = z2;
                                    i = i3;
                                    f = Float.MAX_VALUE;
                                } else {
                                    if (springAnimation.mPendingPosition != Float.MAX_VALUE) {
                                        SpringForce springForce4 = springAnimation.mSpring;
                                        double d2 = springForce4.mFinalPosition;
                                        i = i3;
                                        long j5 = j3 / 2;
                                        FlingCalculator flingCalculatorUpdateValues4 = springForce4.updateValues(springAnimation.mValue, springAnimation.mVelocity, j5);
                                        SpringForce springForce5 = springAnimation.mSpring;
                                        springForce5.mFinalPosition = springAnimation.mPendingPosition;
                                        springAnimation.mPendingPosition = Float.MAX_VALUE;
                                        FlingCalculator flingCalculatorUpdateValues5 = springForce5.updateValues(flingCalculatorUpdateValues4.friction, flingCalculatorUpdateValues4.magicPhysicalCoefficient, j5);
                                        springAnimation.mValue = flingCalculatorUpdateValues5.friction;
                                        springAnimation.mVelocity = flingCalculatorUpdateValues5.magicPhysicalCoefficient;
                                    } else {
                                        i = i3;
                                        FlingCalculator flingCalculatorUpdateValues6 = springAnimation.mSpring.updateValues(springAnimation.mValue, springAnimation.mVelocity, j3);
                                        springAnimation.mValue = flingCalculatorUpdateValues6.friction;
                                        springAnimation.mVelocity = flingCalculatorUpdateValues6.magicPhysicalCoefficient;
                                    }
                                    float fMax4 = Math.max(springAnimation.mValue, -3.4028235E38f);
                                    springAnimation.mValue = fMax4;
                                    float fMin4 = Math.min(fMax4, f);
                                    springAnimation.mValue = fMin4;
                                    f2 = springAnimation.mVelocity;
                                    springForce = springAnimation.mSpring;
                                    springForce.getClass();
                                    if (Math.abs(f2) < springForce.mVelocityThreshold || Math.abs(fMin4 - ((float) springForce.mFinalPosition)) >= springForce.mValueThreshold) {
                                        z = false;
                                    } else {
                                        springAnimation.mValue = (float) springAnimation.mSpring.mFinalPosition;
                                        springAnimation.mVelocity = 0.0f;
                                    }
                                    float fMin5 = Math.min(springAnimation.mValue, f);
                                    springAnimation.mValue = fMin5;
                                    float fMax5 = Math.max(fMin5, -3.4028235E38f);
                                    springAnimation.mValue = fMax5;
                                    springAnimation.setPropertyValue(fMax5);
                                    if (z) {
                                        arrayList = springAnimation.mEndListeners;
                                        springAnimation.mRunning = false;
                                        threadLocal = AnimationHandler.sAnimatorHandler;
                                        if (threadLocal.get() == null) {
                                            threadLocal.set(new AnimationHandler());
                                        }
                                        animationHandler = (AnimationHandler) threadLocal.get();
                                        animationHandler.mDelayedCallbackStartTime.remove(springAnimation);
                                        arrayList2 = animationHandler.mAnimationCallbacks;
                                        iIndexOf = arrayList2.indexOf(springAnimation);
                                        if (iIndexOf >= 0) {
                                            arrayList2.set(iIndexOf, null);
                                            animationHandler.mListDirty = true;
                                        }
                                        springAnimation.mLastFrameTime = 0L;
                                        springAnimation.mStartValueIsSet = false;
                                        while (i2 < arrayList.size()) {
                                            if (arrayList.get(i2) == null) {
                                                arrayList.get(i2).getClass();
                                                throw new ClassCastException();
                                            }
                                        }
                                        while (size >= 0) {
                                            if (arrayList.get(size) == null) {
                                                arrayList.remove(size);
                                            }
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                                z = true;
                                float fMin6 = Math.min(springAnimation.mValue, f);
                                springAnimation.mValue = fMin6;
                                float fMax6 = Math.max(fMin6, -3.4028235E38f);
                                springAnimation.mValue = fMax6;
                                springAnimation.setPropertyValue(fMax6);
                                if (z) {
                                    arrayList = springAnimation.mEndListeners;
                                    springAnimation.mRunning = false;
                                    threadLocal = AnimationHandler.sAnimatorHandler;
                                    if (threadLocal.get() == null) {
                                        threadLocal.set(new AnimationHandler());
                                    }
                                    animationHandler = (AnimationHandler) threadLocal.get();
                                    animationHandler.mDelayedCallbackStartTime.remove(springAnimation);
                                    arrayList2 = animationHandler.mAnimationCallbacks;
                                    iIndexOf = arrayList2.indexOf(springAnimation);
                                    if (iIndexOf >= 0) {
                                        arrayList2.set(iIndexOf, null);
                                        animationHandler.mListDirty = true;
                                    }
                                    springAnimation.mLastFrameTime = 0L;
                                    springAnimation.mStartValueIsSet = false;
                                    while (i2 < arrayList.size()) {
                                        if (arrayList.get(i2) == null) {
                                            arrayList.get(i2).getClass();
                                            throw new ClassCastException();
                                        }
                                    }
                                    while (size >= 0) {
                                        if (arrayList.get(size) == null) {
                                            arrayList.remove(size);
                                        }
                                    }
                                } else {
                                    continue;
                                }
                            }
                        } else {
                            i = i3;
                        }
                    }
                    i3 = i + 1;
                    z2 = false;
                }
                if (animationHandler2.mListDirty) {
                    for (int size2 = arrayList3.size() - 1; size2 >= 0; size2--) {
                        if (arrayList3.get(size2) == null) {
                            arrayList3.remove(size2);
                        }
                    }
                    animationHandler2.mListDirty = false;
                }
                if (arrayList3.size() > 0) {
                    if (animationHandler2.mProvider == null) {
                        animationHandler2.mProvider = new RealNetworkObserver(animationHandler2.mCallbackDispatcher);
                    }
                    RealNetworkObserver realNetworkObserver = animationHandler2.mProvider;
                    ((Choreographer) realNetworkObserver.listener).postFrameCallback((AnimationHandler$FrameCallbackProvider16$1) realNetworkObserver.networkCallback);
                }
            }
        };
    }

    public RealNetworkObserver(int i) {
        this.$r8$classId = i;
        switch (i) {
            case 8:
                this.connectivityManager = new EmptyStrongMemoryCache(5);
                this.listener = new EmptyStrongMemoryCache(5);
                this.networkCallback = new EmptyStrongMemoryCache(5);
                break;
            case 9:
                this.networkCallback = new zzd();
                break;
            case 17:
                break;
            default:
                long[] jArr = ScatterMapKt.EmptyGroup;
                this.connectivityManager = new MutableScatterMap();
                break;
        }
    }

    public RealNetworkObserver(StartStopTokens startStopTokens) {
        this.$r8$classId = 2;
        this.networkCallback = startStopTokens;
        this.listener = new AtomicBoolean(false);
        this.connectivityManager = ((Camera2CameraImpl) startStopTokens.runs).mScheduledExecutorService.schedule(new Camera2CameraImpl$ErrorTimeoutReopenScheduler$ScheduleNode$$ExternalSyntheticLambda0(this, 0), 2000L, TimeUnit.MILLISECONDS);
    }
}
