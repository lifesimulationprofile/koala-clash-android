package androidx.work.impl;

import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.params.InputConfiguration;
import android.os.Bundle;
import android.os.Handler;
import android.util.SparseIntArray;
import android.view.Surface;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.activity.compose.BackHandlerKt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.camera.camera2.internal.SupportedSurfaceCombination;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat$StateCallbackExecutorWrapper;
import androidx.camera.camera2.internal.compat.CameraDeviceCompatBaseImpl$CameraDeviceCompatParamsApi21;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.camera2.internal.compat.params.InputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.camera2.interop.CaptureRequestOptions$Builder$$ExternalSyntheticLambda0;
import androidx.camera.core.AutoValue_SurfaceRequest_Result;
import androidx.camera.core.CameraX;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.AutoValue_StreamSpec;
import androidx.camera.core.impl.CameraCaptureMetaData$AeState;
import androidx.camera.core.impl.CameraCaptureMetaData$AfState;
import androidx.camera.core.impl.CameraCaptureMetaData$AwbState;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.UseCaseAttachState$UseCaseAttachInfo;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.view.PreviewView;
import androidx.collection.LruCache;
import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableOrderedScatterSet;
import androidx.collection.ObjectIntMapKt;
import androidx.collection.Values;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory;
import androidx.compose.runtime.PausedCompositionImpl;
import androidx.compose.runtime.saveable.SaveableHolder;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotId_jvmKt;
import androidx.compose.ui.layout.LayoutNodeSubcompositionsState;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.layout.SubcomposeSlotReusePolicy;
import androidx.compose.ui.node.LayoutNode;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import androidx.emoji2.viewsintegration.EmojiEditableFactory;
import androidx.emoji2.viewsintegration.EmojiTextWatcher;
import androidx.lifecycle.LegacySavedStateHandleController$OnRecreation;
import androidx.room.RoomSQLiteQuery;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateRegistry$SavedStateProvider;
import androidx.savedstate.internal.SavedStateRegistryImpl;
import androidx.work.Data;
import androidx.work.SystemClock;
import androidx.work.Worker;
import androidx.work.impl.model.WorkTagDao_Impl$1;
import androidx.work.impl.utils.StartWorkRunnable;
import androidx.work.impl.utils.StopWorkRunnable;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import coil.ImageLoader$Builder;
import com.github.kr328.clash.core.bridge.ClashException;
import com.github.kr328.clash.core.bridge.FetchCallback;
import com.github.kr328.clash.core.model.FetchStatus;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.AutoValue_PersistedEvent;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.mlkit.common.internal.zzd;
import io.github.g00fy2.quickie.QROverlayView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferredImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.serialization.json.Json;
import okio.AsyncTimeout;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public class WorkLauncherImpl implements CameraCaptureResult, FutureCallback, SubcomposeSlotReusePolicy, Saver, SubcomposeLayoutState.PausedPrecomposition, FetchCallback, SQLiteEventStore.Function {
    public final /* synthetic */ int $r8$classId;
    public Object processor;
    public Object workTaskExecutor;

    public /* synthetic */ WorkLauncherImpl(int i, Object obj, Object obj2) {
        this.$r8$classId = i;
        this.processor = obj;
        this.workTaskExecutor = obj2;
    }

    public static void checkPreconditions(CameraDevice cameraDevice, SessionConfigurationCompat sessionConfigurationCompat) {
        cameraDevice.getClass();
        SessionConfigurationCompat.SessionConfigurationCompatImpl sessionConfigurationCompatImpl = sessionConfigurationCompat.mImpl;
        sessionConfigurationCompatImpl.getStateCallback().getClass();
        List outputConfigurations = sessionConfigurationCompatImpl.getOutputConfigurations();
        if (outputConfigurations == null) {
            throw new IllegalArgumentException("Invalid output configurations");
        }
        if (sessionConfigurationCompatImpl.getExecutor() == null) {
            throw new IllegalArgumentException("Invalid executor");
        }
        String id = cameraDevice.getId();
        Iterator it = outputConfigurations.iterator();
        while (it.hasNext()) {
            String physicalCameraId = ((OutputConfigurationCompat) it.next()).mImpl.getPhysicalCameraId();
            if (physicalCameraId != null && !physicalCameraId.isEmpty()) {
                LazyKt__LazyJVMKt.w("CameraDeviceCompat", "Camera " + id + ": Camera doesn't support physicalCameraId " + physicalCameraId + ". Ignoring.");
            }
        }
    }

    public static int getSpanGroupIndex(int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            i3++;
            if (i3 == i2) {
                i4++;
                i3 = 0;
            } else if (i3 > i2) {
                i4++;
                i3 = 1;
            }
        }
        return i3 + 1 > i2 ? i4 + 1 : i4;
    }

    public static ArrayList unpackSurfaces(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((OutputConfigurationCompat) it.next()).mImpl.getSurface());
        }
        return arrayList;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        SQLiteEventStore sQLiteEventStore = (SQLiteEventStore) this.processor;
        AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) this.workTaskExecutor;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        Encoding encoding = SQLiteEventStore.PROTOBUF_ENCODING;
        sQLiteEventStore.getClass();
        ArrayList arrayList = new ArrayList();
        Long transportContextId = SQLiteEventStore.getTransportContextId(sQLiteDatabase, autoValue_TransportContext);
        if (transportContextId != null) {
            SQLiteEventStore.tryWithCursor(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline"}, "context_id = ?", new String[]{transportContextId.toString()}, null, null, null, String.valueOf(sQLiteEventStore.config.loadBatchSize)), new ImageLoader$Builder(sQLiteEventStore, arrayList, autoValue_TransportContext, 16));
        }
        HashMap map = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i = 0; i < arrayList.size(); i++) {
            sb.append(((AutoValue_PersistedEvent) arrayList.get(i)).id);
            if (i < arrayList.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(')');
        SQLiteEventStore.tryWithCursor(sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", "value"}, sb.toString(), null, null, null, null), new Data.Builder(map));
        ListIterator listIterator = arrayList.listIterator();
        while (listIterator.hasNext()) {
            AutoValue_PersistedEvent autoValue_PersistedEvent = (AutoValue_PersistedEvent) listIterator.next();
            long j = autoValue_PersistedEvent.id;
            if (map.containsKey(Long.valueOf(j))) {
                AppCompatDrawableManager.AnonymousClass1 builder = autoValue_PersistedEvent.event.toBuilder();
                for (SQLiteEventStore.Metadata metadata : (Set) map.get(Long.valueOf(j))) {
                    builder.addMetadata(metadata.key, metadata.value);
                }
                listIterator.set(new AutoValue_PersistedEvent(j, autoValue_PersistedEvent.transportContext, builder.build()));
            }
        }
        return arrayList;
    }

    @Override // androidx.compose.ui.layout.SubcomposeSlotReusePolicy
    public boolean areCompatible(Object obj, Object obj2) {
        LazyLayoutItemContentFactory lazyLayoutItemContentFactory = (LazyLayoutItemContentFactory) this.processor;
        return Intrinsics.areEqual(lazyLayoutItemContentFactory.getContentType(obj), lazyLayoutItemContentFactory.getContentType(obj2));
    }

    @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PausedPrecomposition
    public void cancel() {
        LayoutNodeSubcompositionsState.NodeState nodeState = getNodeState();
        if ((nodeState != null ? nodeState.pausedComposition : null) != null) {
            LayoutNodeSubcompositionsState.access$disposePrecomposedSlot((LayoutNodeSubcompositionsState) this.processor, this.workTaskExecutor);
        }
    }

    @Override // com.github.kr328.clash.core.bridge.FetchCallback
    public void complete(String str) {
        CompletableDeferredImpl completableDeferredImpl = (CompletableDeferredImpl) this.workTaskExecutor;
        if (str != null) {
            completableDeferredImpl.completeExceptionally(new ClashException(str));
        } else {
            completableDeferredImpl.makeCompleting$kotlinx_coroutines_core(Unit.INSTANCE);
        }
    }

    public Bundle consumeRestoredStateForKey(String str) {
        SavedStateRegistryImpl savedStateRegistryImpl = (SavedStateRegistryImpl) this.processor;
        if (!savedStateRegistryImpl.isRestored) {
            throw new IllegalStateException("You can 'consumeRestoredStateForKey' only after the corresponding component has moved to the 'CREATED' state");
        }
        Bundle bundle = savedStateRegistryImpl.restoredState;
        if (bundle == null) {
            return null;
        }
        Bundle bundleM769getSavedStateimpl = bundle.containsKey(str) ? SavedStateReader.m769getSavedStateimpl(str, bundle) : null;
        bundle.remove(str);
        if (bundle.isEmpty()) {
            savedStateRegistryImpl.restoredState = null;
        }
        return bundleM769getSavedStateimpl;
    }

    public void createCaptureSession(SessionConfigurationCompat sessionConfigurationCompat) throws CameraAccessExceptionCompat {
        CameraDevice cameraDevice = (CameraDevice) this.processor;
        checkPreconditions(cameraDevice, sessionConfigurationCompat);
        SessionConfigurationCompat.SessionConfigurationCompatImpl sessionConfigurationCompatImpl = sessionConfigurationCompat.mImpl;
        CameraCaptureSessionCompat$StateCallbackExecutorWrapper cameraCaptureSessionCompat$StateCallbackExecutorWrapper = new CameraCaptureSessionCompat$StateCallbackExecutorWrapper(sessionConfigurationCompatImpl.getExecutor(), sessionConfigurationCompatImpl.getStateCallback());
        ArrayList arrayListUnpackSurfaces = unpackSurfaces(sessionConfigurationCompatImpl.getOutputConfigurations());
        CameraDeviceCompatBaseImpl$CameraDeviceCompatParamsApi21 cameraDeviceCompatBaseImpl$CameraDeviceCompatParamsApi21 = (CameraDeviceCompatBaseImpl$CameraDeviceCompatParamsApi21) this.workTaskExecutor;
        cameraDeviceCompatBaseImpl$CameraDeviceCompatParamsApi21.getClass();
        Handler handler = cameraDeviceCompatBaseImpl$CameraDeviceCompatParamsApi21.mCompatHandler;
        InputConfigurationCompat inputConfiguration = sessionConfigurationCompatImpl.getInputConfiguration();
        try {
            if (inputConfiguration != null) {
                InputConfiguration inputConfiguration2 = inputConfiguration.mImpl.mObject;
                inputConfiguration2.getClass();
                cameraDevice.createReprocessableCaptureSession(inputConfiguration2, arrayListUnpackSurfaces, cameraCaptureSessionCompat$StateCallbackExecutorWrapper, handler);
            } else {
                if (sessionConfigurationCompatImpl.getSessionType() == 1) {
                    cameraDevice.createConstrainedHighSpeedCaptureSession(arrayListUnpackSurfaces, cameraCaptureSessionCompat$StateCallbackExecutorWrapper, handler);
                    return;
                }
                try {
                    cameraDevice.createCaptureSession(arrayListUnpackSurfaces, cameraCaptureSessionCompat$StateCallbackExecutorWrapper, handler);
                } catch (CameraAccessException e) {
                    throw new CameraAccessExceptionCompat(e);
                }
            }
        } catch (CameraAccessException e2) {
            throw new CameraAccessExceptionCompat(e2);
        }
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public CameraCaptureMetaData$AeState getAeState() {
        Integer num = (Integer) ((CaptureResult) this.workTaskExecutor).get(CaptureResult.CONTROL_AE_STATE);
        CameraCaptureMetaData$AeState cameraCaptureMetaData$AeState = CameraCaptureMetaData$AeState.UNKNOWN;
        if (num == null) {
            return cameraCaptureMetaData$AeState;
        }
        int iIntValue = num.intValue();
        if (iIntValue == 0) {
            return CameraCaptureMetaData$AeState.INACTIVE;
        }
        if (iIntValue != 1) {
            if (iIntValue == 2) {
                return CameraCaptureMetaData$AeState.CONVERGED;
            }
            if (iIntValue == 3) {
                return CameraCaptureMetaData$AeState.LOCKED;
            }
            if (iIntValue == 4) {
                return CameraCaptureMetaData$AeState.FLASH_REQUIRED;
            }
            if (iIntValue != 5) {
                LazyKt__LazyJVMKt.e("C2CameraCaptureResult", "Undefined ae state: " + num);
                return cameraCaptureMetaData$AeState;
            }
        }
        return CameraCaptureMetaData$AeState.SEARCHING;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public CameraCaptureMetaData$AfState getAfState() {
        Integer num = (Integer) ((CaptureResult) this.workTaskExecutor).get(CaptureResult.CONTROL_AF_STATE);
        CameraCaptureMetaData$AfState cameraCaptureMetaData$AfState = CameraCaptureMetaData$AfState.UNKNOWN;
        if (num == null) {
            return cameraCaptureMetaData$AfState;
        }
        switch (num.intValue()) {
            case 0:
                return CameraCaptureMetaData$AfState.INACTIVE;
            case 1:
            case 3:
                return CameraCaptureMetaData$AfState.SCANNING;
            case 2:
                return CameraCaptureMetaData$AfState.PASSIVE_FOCUSED;
            case 4:
                return CameraCaptureMetaData$AfState.LOCKED_FOCUSED;
            case 5:
                return CameraCaptureMetaData$AfState.LOCKED_NOT_FOCUSED;
            case 6:
                return CameraCaptureMetaData$AfState.PASSIVE_NOT_FOCUSED;
            default:
                LazyKt__LazyJVMKt.e("C2CameraCaptureResult", "Undefined af state: " + num);
                return cameraCaptureMetaData$AfState;
        }
    }

    public SessionConfig.ValidatingBuilder getAttachedBuilder() {
        SessionConfig.ValidatingBuilder validatingBuilder = new SessionConfig.ValidatingBuilder();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : ((LinkedHashMap) this.workTaskExecutor).entrySet()) {
            UseCaseAttachState$UseCaseAttachInfo useCaseAttachState$UseCaseAttachInfo = (UseCaseAttachState$UseCaseAttachInfo) entry.getValue();
            if (useCaseAttachState$UseCaseAttachInfo.mAttached) {
                validatingBuilder.add(useCaseAttachState$UseCaseAttachInfo.mSessionConfig);
                arrayList.add((String) entry.getKey());
            }
        }
        LazyKt__LazyJVMKt.d("UseCaseAttachState", "All use case: " + arrayList + " for camera: " + ((String) this.processor));
        return validatingBuilder;
    }

    public Collection getAttachedSessionConfigs() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : ((LinkedHashMap) this.workTaskExecutor).entrySet()) {
            if (((UseCaseAttachState$UseCaseAttachInfo) entry.getValue()).mAttached) {
                arrayList.add(((UseCaseAttachState$UseCaseAttachInfo) entry.getValue()).mSessionConfig);
            }
        }
        return Collections.unmodifiableCollection(arrayList);
    }

    public Collection getAttachedUseCaseConfigs() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : ((LinkedHashMap) this.workTaskExecutor).entrySet()) {
            if (((UseCaseAttachState$UseCaseAttachInfo) entry.getValue()).mAttached) {
                arrayList.add(((UseCaseAttachState$UseCaseAttachInfo) entry.getValue()).mUseCaseConfig);
            }
        }
        return Collections.unmodifiableCollection(arrayList);
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public CameraCaptureMetaData$AwbState getAwbState() {
        Integer num = (Integer) ((CaptureResult) this.workTaskExecutor).get(CaptureResult.CONTROL_AWB_STATE);
        CameraCaptureMetaData$AwbState cameraCaptureMetaData$AwbState = CameraCaptureMetaData$AwbState.UNKNOWN;
        if (num == null) {
            return cameraCaptureMetaData$AwbState;
        }
        int iIntValue = num.intValue();
        if (iIntValue == 0) {
            return CameraCaptureMetaData$AwbState.INACTIVE;
        }
        if (iIntValue == 1) {
            return CameraCaptureMetaData$AwbState.METERING;
        }
        if (iIntValue == 2) {
            return CameraCaptureMetaData$AwbState.CONVERGED;
        }
        if (iIntValue == 3) {
            return CameraCaptureMetaData$AwbState.LOCKED;
        }
        LazyKt__LazyJVMKt.e("C2CameraCaptureResult", "Undefined awb state: " + num);
        return cameraCaptureMetaData$AwbState;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public CaptureResult getCaptureResult() {
        return (CaptureResult) this.workTaskExecutor;
    }

    public ArrayList getDependentWorkIds(String str) {
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.processor;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT work_spec_id FROM dependency WHERE prerequisite_id=?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(str, 1);
        }
        workDatabase_Impl.assertNotSuspendingTransaction();
        Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    public LayoutNodeSubcompositionsState.NodeState getNodeState() {
        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = (LayoutNodeSubcompositionsState) this.processor;
        LayoutNode layoutNode = (LayoutNode) layoutNodeSubcompositionsState.precomposeMap.get(this.workTaskExecutor);
        if (layoutNode != null) {
            return (LayoutNodeSubcompositionsState.NodeState) layoutNodeSubcompositionsState.nodeToNodeState.get(layoutNode);
        }
        return null;
    }

    public SavedStateRegistry$SavedStateProvider getSavedStateProvider(String str) {
        SavedStateRegistry$SavedStateProvider savedStateRegistry$SavedStateProvider;
        SavedStateRegistryImpl savedStateRegistryImpl = (SavedStateRegistryImpl) this.processor;
        synchronized (savedStateRegistryImpl.lock) {
            Iterator it = savedStateRegistryImpl.keyToProviders.entrySet().iterator();
            do {
                savedStateRegistry$SavedStateProvider = null;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                String str2 = (String) entry.getKey();
                SavedStateRegistry$SavedStateProvider savedStateRegistry$SavedStateProvider2 = (SavedStateRegistry$SavedStateProvider) entry.getValue();
                if (Intrinsics.areEqual(str2, str)) {
                    savedStateRegistry$SavedStateProvider = savedStateRegistry$SavedStateProvider2;
                }
            } while (savedStateRegistry$SavedStateProvider == null);
        }
        return savedStateRegistry$SavedStateProvider;
    }

    @Override // androidx.compose.ui.layout.SubcomposeSlotReusePolicy
    public void getSlotsToRetain(Values values) {
        MutableObjectIntMap mutableObjectIntMap = (MutableObjectIntMap) this.workTaskExecutor;
        mutableObjectIntMap.clear();
        MutableOrderedScatterSet mutableOrderedScatterSet = (MutableOrderedScatterSet) values.parent;
        Object[] objArr = mutableOrderedScatterSet.elements;
        long[] jArr = mutableOrderedScatterSet.nodes;
        int i = mutableOrderedScatterSet.tail;
        while (i != Integer.MAX_VALUE) {
            int i2 = (int) ((jArr[i] >> 31) & 2147483647L);
            Object obj = objArr[i];
            Object contentType = ((LazyLayoutItemContentFactory) this.processor).getContentType(obj);
            int iFindKeyIndex = mutableObjectIntMap.findKeyIndex(contentType);
            int i3 = iFindKeyIndex >= 0 ? mutableObjectIntMap.values[iFindKeyIndex] : 0;
            if (i3 == 7) {
                values.remove(obj);
            } else {
                mutableObjectIntMap.set(i3 + 1, contentType);
            }
            i = i2;
        }
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public TagBundle getTagBundle() {
        return (TagBundle) this.processor;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public long getTimestamp() {
        Long l = (Long) ((CaptureResult) this.workTaskExecutor).get(CaptureResult.SENSOR_TIMESTAMP);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void invalidateSpanIndexCache() {
        ((SparseIntArray) this.processor).clear();
    }

    @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PausedPrecomposition
    public boolean isComplete() {
        PausedCompositionImpl pausedCompositionImpl;
        LayoutNodeSubcompositionsState.NodeState nodeState = getNodeState();
        if (nodeState == null || (pausedCompositionImpl = nodeState.pausedComposition) == null) {
            return true;
        }
        return pausedCompositionImpl.isComplete();
    }

    public boolean isUseCaseAttached(String str) {
        LinkedHashMap linkedHashMap = (LinkedHashMap) this.workTaskExecutor;
        if (linkedHashMap.containsKey(str)) {
            return ((UseCaseAttachState$UseCaseAttachInfo) linkedHashMap.get(str)).mAttached;
        }
        return false;
    }

    @Override // androidx.camera.core.impl.utils.futures.FutureCallback
    public void onFailure(Throwable th) {
        switch (this.$r8$classId) {
            case 5:
                Preconditions.checkState("Camera surface session should only fail with request cancellation. Instead failed due to:\n" + th, th instanceof SurfaceRequest.RequestCancelledException);
                ((Consumer) this.processor).accept(new AutoValue_SurfaceRequest_Result(1, (Surface) this.workTaskExecutor));
                break;
            default:
                ((CallbackToFutureAdapter.Completer) this.processor).setException(th);
                break;
        }
    }

    @Override // androidx.camera.core.impl.utils.futures.FutureCallback
    public void onSuccess(Object obj) {
        switch (this.$r8$classId) {
            case 5:
                ((Consumer) this.processor).accept(new AutoValue_SurfaceRequest_Result(0, (Surface) this.workTaskExecutor));
                break;
            default:
                ((CallbackToFutureAdapter.Completer) this.processor).set((CameraX) this.workTaskExecutor);
                break;
        }
    }

    public void registerSavedStateProvider(String str, SavedStateRegistry$SavedStateProvider savedStateRegistry$SavedStateProvider) {
        SavedStateRegistryImpl savedStateRegistryImpl = (SavedStateRegistryImpl) this.processor;
        synchronized (savedStateRegistryImpl.lock) {
            if (savedStateRegistryImpl.keyToProviders.containsKey(str)) {
                throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
            }
            savedStateRegistryImpl.keyToProviders.put(str, savedStateRegistry$SavedStateProvider);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.github.kr328.clash.core.bridge.FetchCallback
    public void report(String str) {
        ((Function1) this.processor).invoke(Json.Default.decodeFromString(str, FetchStatus.CREATOR.serializer()));
    }

    @Override // androidx.compose.runtime.saveable.Saver
    public Object restore(Object obj) {
        return ((Function1) this.workTaskExecutor).invoke(obj);
    }

    @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PausedPrecomposition
    public boolean resume(CaptureRequestOptions$Builder$$ExternalSyntheticLambda0 captureRequestOptions$Builder$$ExternalSyntheticLambda0) {
        LayoutNodeSubcompositionsState.NodeState nodeState = getNodeState();
        PausedCompositionImpl pausedCompositionImpl = nodeState != null ? nodeState.pausedComposition : null;
        if (pausedCompositionImpl == null || pausedCompositionImpl.isComplete()) {
            return true;
        }
        Snapshot currentThreadSnapshot = SnapshotId_jvmKt.getCurrentThreadSnapshot();
        Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot snapshotMakeCurrentNonObservable = SnapshotId_jvmKt.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            boolean zResume = pausedCompositionImpl.resume(captureRequestOptions$Builder$$ExternalSyntheticLambda0);
            SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            return zResume;
        } catch (Throwable th) {
            try {
                nodeState.getClass();
                throw th;
            } catch (Throwable th2) {
                SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                throw th2;
            }
        }
    }

    public void runOnNextRecreation() {
        if (!((SavedStateRegistryImpl) this.processor).isAllowingSavingState) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        AppCompatActivity.AnonymousClass1 anonymousClass1 = (AppCompatActivity.AnonymousClass1) this.workTaskExecutor;
        if (anonymousClass1 == null) {
            anonymousClass1 = new AppCompatActivity.AnonymousClass1(this);
        }
        this.workTaskExecutor = anonymousClass1;
        try {
            LegacySavedStateHandleController$OnRecreation.class.getDeclaredConstructor(null);
            AppCompatActivity.AnonymousClass1 anonymousClass2 = (AppCompatActivity.AnonymousClass1) this.workTaskExecutor;
            if (anonymousClass2 != null) {
                ((LinkedHashSet) anonymousClass2.this$0).add(LegacySavedStateHandleController$OnRecreation.class.getName());
            }
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Class " + LegacySavedStateHandleController$OnRecreation.class.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
        }
    }

    @Override // androidx.compose.runtime.saveable.Saver
    public Object save(SaveableHolder saveableHolder, Object obj) {
        return ((Function2) this.processor).invoke(saveableHolder, obj);
    }

    public void startWork(StartStopToken startStopToken, SystemClock systemClock) {
        ((WorkManagerTaskExecutor) this.workTaskExecutor).executeOnTaskThread(new StartWorkRunnable((Processor) this.processor, startStopToken, systemClock, 0));
    }

    public void stopWork(StartStopToken startStopToken, int i) {
        ((WorkManagerTaskExecutor) this.workTaskExecutor).executeOnTaskThread(new StopWorkRunnable((Processor) this.processor, startStopToken, false, i));
    }

    public void updateUseCase(String str, SessionConfig sessionConfig, UseCaseConfig useCaseConfig, AutoValue_StreamSpec autoValue_StreamSpec, List list) {
        LinkedHashMap linkedHashMap = (LinkedHashMap) this.workTaskExecutor;
        if (linkedHashMap.containsKey(str)) {
            UseCaseAttachState$UseCaseAttachInfo useCaseAttachState$UseCaseAttachInfo = new UseCaseAttachState$UseCaseAttachInfo(sessionConfig, useCaseConfig, autoValue_StreamSpec, list);
            UseCaseAttachState$UseCaseAttachInfo useCaseAttachState$UseCaseAttachInfo2 = (UseCaseAttachState$UseCaseAttachInfo) linkedHashMap.get(str);
            useCaseAttachState$UseCaseAttachInfo.mAttached = useCaseAttachState$UseCaseAttachInfo2.mAttached;
            useCaseAttachState$UseCaseAttachInfo.mActive = useCaseAttachState$UseCaseAttachInfo2.mActive;
            linkedHashMap.put(str, useCaseAttachState$UseCaseAttachInfo);
        }
    }

    public WorkLauncherImpl(Worker.AnonymousClass1 anonymousClass1, AlertDialog alertDialog) {
        this.$r8$classId = 19;
        this.workTaskExecutor = anonymousClass1;
        this.processor = alertDialog;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WorkLauncherImpl(CoroutineScope coroutineScope, Function2 function2) {
        this.$r8$classId = 17;
        this.processor = (Service) coroutineScope;
        this.workTaskExecutor = (SuspendLambda) function2;
    }

    public WorkLauncherImpl(SavedStateRegistryImpl savedStateRegistryImpl) {
        this.$r8$classId = 15;
        this.processor = savedStateRegistryImpl;
    }

    public WorkLauncherImpl(WorkDatabase_Impl workDatabase_Impl) {
        this.$r8$classId = 1;
        this.processor = workDatabase_Impl;
        this.workTaskExecutor = new WorkTagDao_Impl$1(workDatabase_Impl, 1);
    }

    public WorkLauncherImpl(FrameLayout frameLayout, QROverlayView qROverlayView, PreviewView previewView) {
        this.$r8$classId = 22;
        this.processor = qROverlayView;
        this.workTaskExecutor = previewView;
    }

    public WorkLauncherImpl(CameraDevice cameraDevice, CameraDeviceCompatBaseImpl$CameraDeviceCompatParamsApi21 cameraDeviceCompatBaseImpl$CameraDeviceCompatParamsApi21) {
        this.$r8$classId = 4;
        cameraDevice.getClass();
        this.processor = cameraDevice;
        this.workTaskExecutor = cameraDeviceCompatBaseImpl$CameraDeviceCompatParamsApi21;
    }

    public WorkLauncherImpl(String str, int i) {
        this.$r8$classId = i;
        switch (i) {
            case 21:
                this.workTaskExecutor = null;
                this.processor = str;
                break;
            default:
                this.workTaskExecutor = new LinkedHashMap();
                this.processor = str;
                break;
        }
    }

    public WorkLauncherImpl(Context context, Object obj, LinkedHashSet linkedHashSet) {
        CameraManagerCompat cameraManagerCompatFrom;
        this.$r8$classId = 3;
        AsyncTimeout.Companion companion = new AsyncTimeout.Companion(2);
        this.processor = new HashMap();
        this.workTaskExecutor = companion;
        if (obj instanceof CameraManagerCompat) {
            cameraManagerCompatFrom = (CameraManagerCompat) obj;
        } else {
            cameraManagerCompatFrom = CameraManagerCompat.from(context, BackHandlerKt.getInstance());
        }
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            ((HashMap) this.processor).put(str, new SupportedSurfaceCombination(context, str, cameraManagerCompatFrom, (AsyncTimeout.Companion) this.workTaskExecutor));
        }
    }

    public WorkLauncherImpl(LazyLayoutItemContentFactory lazyLayoutItemContentFactory) {
        this.$r8$classId = 8;
        this.processor = lazyLayoutItemContentFactory;
        MutableObjectIntMap mutableObjectIntMap = ObjectIntMapKt.EmptyObjectIntMap;
        this.workTaskExecutor = new MutableObjectIntMap();
    }

    @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PausedPrecomposition
    public SubcomposeLayoutState.PrecomposedSlotHandle apply() {
        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = (LayoutNodeSubcompositionsState) this.processor;
        LayoutNodeSubcompositionsState.NodeState nodeState = getNodeState();
        if (nodeState != null) {
            layoutNodeSubcompositionsState.applyPausedPrecomposition(nodeState, false);
        }
        return layoutNodeSubcompositionsState.createPrecomposedSlotHandle(this.workTaskExecutor);
    }

    public WorkLauncherImpl(int i) {
        this.$r8$classId = i;
        switch (i) {
            case 12:
                this.processor = new zzd();
                this.workTaskExecutor = new LruCache(16);
                break;
            case 14:
                this.processor = new SparseIntArray();
                this.workTaskExecutor = new SparseIntArray();
                break;
            case 20:
                break;
            default:
                this.processor = new LinkedHashMap();
                this.workTaskExecutor = new LinkedHashMap();
                break;
        }
    }

    public WorkLauncherImpl(EditText editText) {
        this.$r8$classId = 13;
        this.processor = editText;
        EmojiTextWatcher emojiTextWatcher = new EmojiTextWatcher(editText);
        this.workTaskExecutor = emojiTextWatcher;
        editText.addTextChangedListener(emojiTextWatcher);
        if (EmojiEditableFactory.sInstance == null) {
            synchronized (EmojiEditableFactory.INSTANCE_LOCK) {
                try {
                    if (EmojiEditableFactory.sInstance == null) {
                        EmojiEditableFactory emojiEditableFactory = new EmojiEditableFactory();
                        try {
                            EmojiEditableFactory.sWatcherClass = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, EmojiEditableFactory.class.getClassLoader());
                        } catch (Throwable unused) {
                        }
                        EmojiEditableFactory.sInstance = emojiEditableFactory;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        editText.setEditableFactory(EmojiEditableFactory.sInstance);
    }
}
