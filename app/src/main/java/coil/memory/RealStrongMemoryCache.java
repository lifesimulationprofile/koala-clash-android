package coil.memory;

import android.animation.Animator;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import androidx.camera.camera2.internal.Camera2CameraImpl;
import androidx.camera.camera2.internal.CaptureSession;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21;
import androidx.camera.core.AutoValue_CameraState;
import androidx.camera.core.AutoValue_CameraState_StateError;
import androidx.camera.core.AutoValue_SurfaceRequest_Result;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CameraStateRegistry;
import androidx.camera.core.impl.utils.executor.SequentialExecutor;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.processing.DefaultSurfaceProcessor;
import androidx.camera.core.processing.SurfaceEdge;
import androidx.camera.core.processing.SurfaceOutputImpl;
import androidx.camera.view.TextureViewImplementation;
import androidx.collection.LruCache;
import androidx.collection.MutableScatterMap;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputEventData;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.EditingBuffer;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.core.os.BundleKt;
import androidx.core.os.CancellationSignal;
import androidx.core.provider.CallbackWrapper$2;
import androidx.core.provider.FontRequestWorker;
import androidx.core.util.Preconditions;
import androidx.fragment.app.FragmentManagerImpl;
import androidx.fragment.app.SpecialEffectsController$FragmentStateManagerOperation;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateRegistry$SavedStateProvider;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.internal.SavedStateRegistryImpl;
import androidx.work.Worker;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkLauncherImpl;
import androidx.work.impl.model.Preference;
import androidx.work.impl.model.WorkTagDao_Impl$1;
import coil.ImageLoader$Builder;
import coil.disk.DiskLruCache$$ExternalSyntheticLambda0;
import coil.disk.RealDiskCache;
import coil.request.RequestService;
import coil.util.Bitmaps;
import com.google.android.datatransport.cct.CctBackendFactory;
import com.google.android.datatransport.runtime.backends.TransportBackendDiscovery;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.TelemetryLoggingOptions;
import com.google.android.gms.common.internal.service.zao;
import com.google.android.gms.signin.zaa;
import com.google.android.gms.tasks.zzu;
import com.google.mlkit.common.internal.zzd;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.builders.ListBuilderKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.internal.PrimitiveArrayDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public class RealStrongMemoryCache implements FutureCallback, CancellationSignal.OnCancelListener, StrongMemoryCache, Decoder, CompositeDecoder {
    public final /* synthetic */ int $r8$classId;
    public Object cache;
    public Object weakMemoryCache;

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class InternalValue {
        public final Bitmap bitmap;
        public final Map extras;
        public final int size;

        public InternalValue(Bitmap bitmap, Map map, int i) {
            this.bitmap = bitmap;
            this.extras = map;
            this.size = i;
        }
    }

    public /* synthetic */ RealStrongMemoryCache(int i, Object obj, Object obj2) {
        this.$r8$classId = i;
        this.cache = obj;
        this.weakMemoryCache = obj2;
    }

    /* JADX INFO: renamed from: activeHoverEvent-0FcD4WY, reason: not valid java name */
    public boolean m791activeHoverEvent0FcD4WY(long j) {
        Object obj;
        List list = (List) ((RequestService) this.cache).systemCallbacks;
        int size = list.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                obj = null;
                break;
            }
            obj = list.get(i);
            if (PointerId.m508equalsimpl0(((PointerInputEventData) obj).id, j)) {
                break;
            }
            i++;
        }
        PointerInputEventData pointerInputEventData = (PointerInputEventData) obj;
        if (pointerInputEventData != null) {
            return pointerInputEventData.activeHover;
        }
        return false;
    }

    public TextFieldValue apply(List list) {
        EditCommand editCommand;
        Exception e;
        try {
            int size = list.size();
            int i = 0;
            editCommand = null;
            while (i < size) {
                try {
                    EditCommand editCommand2 = (EditCommand) list.get(i);
                    try {
                        editCommand2.applyTo((EditingBuffer) this.cache);
                        i++;
                        editCommand = editCommand2;
                    } catch (Exception e2) {
                        e = e2;
                        editCommand = editCommand2;
                        StringBuilder sb = new StringBuilder();
                        StringBuilder sb2 = new StringBuilder("Error while applying EditCommand batch to buffer (length=");
                        sb2.append(((EditingBuffer) this.cache).gapBuffer.getLength());
                        sb2.append(", composition=");
                        sb2.append(((EditingBuffer) this.cache).m657getCompositionMzsxiRA$ui_text());
                        sb2.append(", selection=");
                        EditingBuffer editingBuffer = (EditingBuffer) this.cache;
                        sb2.append((Object) TextRange.m644toStringimpl(ParagraphKt.TextRange(editingBuffer.selectionStart, editingBuffer.selectionEnd)));
                        sb2.append("):");
                        sb.append(sb2.toString());
                        sb.append('\n');
                        CollectionsKt.joinTo$default(list, sb, "\n", new DiskLruCache$$ExternalSyntheticLambda0(4, editCommand, this), 60);
                        throw new RuntimeException(sb.toString(), e);
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            }
            EditingBuffer editingBuffer2 = (EditingBuffer) this.cache;
            editingBuffer2.getClass();
            AnnotatedString annotatedString = new AnnotatedString(editingBuffer2.gapBuffer.toString());
            EditingBuffer editingBuffer3 = (EditingBuffer) this.cache;
            long jTextRange = ParagraphKt.TextRange(editingBuffer3.selectionStart, editingBuffer3.selectionEnd);
            TextRange textRange = TextRange.m643getReversedimpl(((TextFieldValue) this.weakMemoryCache).selection) ? null : new TextRange(jTextRange);
            TextFieldValue textFieldValue = new TextFieldValue(annotatedString, textRange != null ? textRange.packedValue : ParagraphKt.TextRange(TextRange.m641getMaximpl(jTextRange), TextRange.m642getMinimpl(jTextRange)), ((EditingBuffer) this.cache).m657getCompositionMzsxiRA$ui_text());
            this.weakMemoryCache = textFieldValue;
            return textFieldValue;
        } catch (Exception e4) {
            editCommand = null;
            e = e4;
        }
    }

    public void clear() {
        int[] iArr = (int[]) this.weakMemoryCache;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        this.cache = null;
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public boolean decodeBoolean() {
        return ((Parcel) this.weakMemoryCache).readByte() != 0;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public boolean decodeBooleanElement(SerialDescriptor serialDescriptor, int i) {
        return decodeBoolean();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public byte decodeByte() {
        return ((Parcel) this.weakMemoryCache).readByte();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public byte decodeByteElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i) {
        return ((Parcel) this.weakMemoryCache).readByte();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public char decodeChar() {
        return (char) ((Parcel) this.weakMemoryCache).readInt();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public char decodeCharElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i) {
        return decodeChar();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public int decodeCollectionSize() {
        return ((Parcel) this.weakMemoryCache).readInt();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public double decodeDouble() {
        return ((Parcel) this.weakMemoryCache).readDouble();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public double decodeDoubleElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i) {
        return ((Parcel) this.weakMemoryCache).readDouble();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public int decodeElementIndex(SerialDescriptor serialDescriptor) {
        return ((Parcel) this.weakMemoryCache).readInt();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public int decodeEnum(SerialDescriptor serialDescriptor) {
        return ((Parcel) this.weakMemoryCache).readInt();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public float decodeFloat() {
        return ((Parcel) this.weakMemoryCache).readFloat();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public float decodeFloatElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i) {
        return ((Parcel) this.weakMemoryCache).readFloat();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public int decodeInt() {
        return ((Parcel) this.weakMemoryCache).readInt();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public int decodeIntElement(SerialDescriptor serialDescriptor, int i) {
        return ((Parcel) this.weakMemoryCache).readInt();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public long decodeLong() {
        return ((Parcel) this.weakMemoryCache).readLong();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public long decodeLongElement(SerialDescriptor serialDescriptor, int i) {
        return ((Parcel) this.weakMemoryCache).readLong();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public boolean decodeNotNullMark() {
        return decodeBoolean();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public Object decodeNullableSerializableElement(SerialDescriptor serialDescriptor, int i, String str) {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        StringSerializer stringSerializer2 = StringSerializer.INSTANCE;
        if (decodeBoolean()) {
            return decodeString();
        }
        return null;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public boolean decodeSequentially() {
        return true;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public Object decodeSerializableElement(SerialDescriptor serialDescriptor, int i, KSerializer kSerializer, Object obj) {
        return kSerializer.deserialize(this);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public Object decodeSerializableValue(KSerializer kSerializer) {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return decodeString();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public short decodeShort() {
        return (short) ((Parcel) this.weakMemoryCache).readInt();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public short decodeShortElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i) {
        return decodeShort();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public String decodeString() {
        return ((Parcel) this.weakMemoryCache).readString();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public String decodeStringElement(SerialDescriptor serialDescriptor, int i) {
        return ((Parcel) this.weakMemoryCache).readString();
    }

    public void ensureSize(int i) {
        int[] iArr = (int[]) this.weakMemoryCache;
        if (iArr == null) {
            int[] iArr2 = new int[Math.max(i, 10) + 1];
            this.weakMemoryCache = iArr2;
            Arrays.fill(iArr2, -1);
        } else if (i >= iArr.length) {
            int length = iArr.length;
            while (length <= i) {
                length *= 2;
            }
            int[] iArr3 = new int[length];
            this.weakMemoryCache = iArr3;
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            int[] iArr4 = (int[]) this.weakMemoryCache;
            Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
        }
    }

    @Override // coil.memory.StrongMemoryCache
    public MemoryCache$Value get(MemoryCache$Key memoryCache$Key) {
        InternalValue internalValue = (InternalValue) ((RealStrongMemoryCache$cache$1) this.cache).get(memoryCache$Key);
        if (internalValue != null) {
            return new MemoryCache$Value(internalValue.bitmap, internalValue.extras);
        }
        return null;
    }

    public CameraCharacteristics getCameraCharacteristics(String str) throws CameraAccessExceptionCompat {
        try {
            return ((CameraManager) this.weakMemoryCache).getCameraCharacteristics(str);
        } catch (CameraAccessException e) {
            throw new CameraAccessExceptionCompat(e);
        }
    }

    public Set getConcurrentCameraIds() {
        return Collections.EMPTY_SET;
    }

    public Long getLongValue(String str) {
        RoomDatabase roomDatabase = (RoomDatabase) this.weakMemoryCache;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT long_value FROM Preference where `key`=?", 1);
        roomSQLiteQueryAcquire.bindString(str, 1);
        roomDatabase.assertNotSuspendingTransaction();
        Cursor cursorQuery = roomDatabase.query(roomSQLiteQueryAcquire);
        try {
            Long lValueOf = null;
            if (cursorQuery.moveToFirst() && !cursorQuery.isNull(0)) {
                lValueOf = Long.valueOf(cursorQuery.getLong(0));
            }
            return lValueOf;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    public MeasurePolicy getMeasurePolicyState() {
        return (MeasurePolicy) ((ParcelableSnapshotMutableState) this.cache).getValue();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public Request getSerializersModule() {
        return (Request) this.cache;
    }

    public void insertPreference(Preference preference) {
        RoomDatabase roomDatabase = (RoomDatabase) this.weakMemoryCache;
        roomDatabase.assertNotSuspendingTransaction();
        roomDatabase.beginTransaction();
        try {
            ((WorkTagDao_Impl$1) this.cache).insert(preference);
            roomDatabase.setTransactionSuccessful();
        } finally {
            roomDatabase.internalEndTransaction();
        }
    }

    public void offsetForAddition(int i, int i2) {
        int[] iArr = (int[]) this.weakMemoryCache;
        if (iArr == null || i >= iArr.length) {
            return;
        }
        int i3 = i + i2;
        ensureSize(i3);
        int[] iArr2 = (int[]) this.weakMemoryCache;
        System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
        Arrays.fill((int[]) this.weakMemoryCache, i, i3, -1);
        ArrayList arrayList = (ArrayList) this.cache;
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem) ((ArrayList) this.cache).get(size);
            int i4 = staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mPosition;
            if (i4 >= i) {
                staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mPosition = i4 + i2;
            }
        }
    }

    public void offsetForRemoval(int i, int i2) {
        int[] iArr = (int[]) this.weakMemoryCache;
        if (iArr == null || i >= iArr.length) {
            return;
        }
        int i3 = i + i2;
        ensureSize(i3);
        int[] iArr2 = (int[]) this.weakMemoryCache;
        System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
        int[] iArr3 = (int[]) this.weakMemoryCache;
        Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
        ArrayList arrayList = (ArrayList) this.cache;
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem) ((ArrayList) this.cache).get(size);
            int i4 = staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mPosition;
            if (i4 >= i) {
                if (i4 < i3) {
                    ((ArrayList) this.cache).remove(size);
                } else {
                    staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mPosition = i4 - i2;
                }
            }
        }
    }

    @Override // androidx.core.os.CancellationSignal.OnCancelListener
    public void onCancel() {
        ((Animator) this.weakMemoryCache).end();
        if (FragmentManagerImpl.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Animator from operation " + ((SpecialEffectsController$FragmentStateManagerOperation) this.cache) + " has been canceled.");
        }
    }

    @Override // androidx.camera.core.impl.utils.futures.FutureCallback
    public void onFailure(Throwable th) {
        switch (this.$r8$classId) {
            case 2:
                return;
            case 6:
                int i = ((SurfaceEdge) this.weakMemoryCache).mTargets;
                if (i == 2 && (th instanceof CancellationException)) {
                    LazyKt__LazyJVMKt.d("SurfaceProcessorNode", "Downstream VideoCapture failed to provide Surface.");
                    return;
                }
                LazyKt__LazyJVMKt.w("SurfaceProcessorNode", "Downstream node failed to provide Surface. Target: " + ListBuilderKt.getHumanReadableName(i), th);
                return;
            default:
                throw new IllegalStateException("SurfaceReleaseFuture did not complete nicely.", th);
        }
    }

    @Override // androidx.camera.core.impl.utils.futures.FutureCallback
    public void onSuccess(Object obj) {
        switch (this.$r8$classId) {
            case 2:
                ((Camera2CameraImpl) this.cache).mReleasedCaptureSessions.remove((CaptureSession) this.weakMemoryCache);
                int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(((Camera2CameraImpl) this.cache).mState);
                if (iOrdinal != 1 && iOrdinal != 4) {
                    if (iOrdinal == 5 || (iOrdinal == 6 && ((Camera2CameraImpl) this.cache).mCameraDeviceError != 0)) {
                        ((Camera2CameraImpl) this.cache).debugLog("Camera reopen required. Checking if the current camera can be closed safely.", null);
                    }
                }
                if (((Camera2CameraImpl) this.cache).mReleasedCaptureSessions.isEmpty()) {
                    Camera2CameraImpl camera2CameraImpl = (Camera2CameraImpl) this.cache;
                    if (camera2CameraImpl.mCameraDevice != null) {
                        camera2CameraImpl.debugLog("closing camera", null);
                        ((Camera2CameraImpl) this.cache).mCameraDevice.close();
                        ((Camera2CameraImpl) this.cache).mCameraDevice = null;
                    }
                }
                break;
            case 6:
                SurfaceOutputImpl surfaceOutputImpl = (SurfaceOutputImpl) obj;
                surfaceOutputImpl.getClass();
                ((DefaultSurfaceProcessor) ((ImageLoader$Builder) this.cache).applicationContext).onOutputSurface(surfaceOutputImpl);
                break;
            default:
                Preconditions.checkState("Unexpected result from SurfaceRequest. Surface was provided twice.", ((AutoValue_SurfaceRequest_Result) obj).resultCode != 3);
                LazyKt__LazyJVMKt.d("TextureViewImpl", "SurfaceTexture about to manually be destroyed");
                ((SurfaceTexture) this.weakMemoryCache).release();
                TextureViewImplementation textureViewImplementation = ((TextureViewImplementation.AnonymousClass1) this.cache).this$0;
                if (textureViewImplementation.mDetachedSurfaceTexture != null) {
                    textureViewImplementation.mDetachedSurfaceTexture = null;
                }
                break;
        }
    }

    public void onTypefaceResult(FontRequestWorker.TypefaceResult typefaceResult) {
        zzu zzuVar = (zzu) this.cache;
        RealDiskCache.RealEditor realEditor = (RealDiskCache.RealEditor) this.weakMemoryCache;
        int i = typefaceResult.mResult;
        if (i != 0) {
            zzuVar.execute(new CallbackWrapper$2(i, 0, realEditor));
        } else {
            zzuVar.execute(new Worker.AnonymousClass2(6, realEditor, typefaceResult.mTypeface));
        }
    }

    public void openCamera(String str, Executor executor, CameraDevice.StateCallback stateCallback) {
        executor.getClass();
        stateCallback.getClass();
        try {
            ((CameraManager) this.weakMemoryCache).openCamera(str, new Camera2CameraImpl.AnonymousClass2(executor, stateCallback), ((CameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21) this.cache).mCompatHandler);
        } catch (CameraAccessException e) {
            throw new CameraAccessExceptionCompat(e);
        }
    }

    public void performAttach() {
        ((SavedStateRegistryImpl) this.weakMemoryCache).performAttach();
    }

    public void performRestore(Bundle bundle) {
        SavedStateRegistryImpl savedStateRegistryImpl = (SavedStateRegistryImpl) this.weakMemoryCache;
        SavedStateRegistryOwner savedStateRegistryOwner = savedStateRegistryImpl.owner;
        if (!savedStateRegistryImpl.attached) {
            savedStateRegistryImpl.performAttach();
        }
        if (savedStateRegistryOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            throw new IllegalStateException(("performRestore cannot be called when owner is " + savedStateRegistryOwner.getLifecycle().getCurrentState()).toString());
        }
        if (savedStateRegistryImpl.isRestored) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        Bundle bundleM769getSavedStateimpl = null;
        if (bundle != null && bundle.containsKey("androidx.lifecycle.BundlableSavedStateRegistry.key")) {
            bundleM769getSavedStateimpl = SavedStateReader.m769getSavedStateimpl("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle);
        }
        savedStateRegistryImpl.restoredState = bundleM769getSavedStateimpl;
        savedStateRegistryImpl.isRestored = true;
    }

    public void performSave(Bundle bundle) {
        SavedStateRegistryImpl savedStateRegistryImpl = (SavedStateRegistryImpl) this.weakMemoryCache;
        Bundle bundleBundleOf = BundleKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
        Bundle bundle2 = savedStateRegistryImpl.restoredState;
        if (bundle2 != null) {
            bundleBundleOf.putAll(bundle2);
        }
        synchronized (savedStateRegistryImpl.lock) {
            try {
                for (Map.Entry entry : savedStateRegistryImpl.keyToProviders.entrySet()) {
                    bundleBundleOf.putBundle((String) entry.getKey(), ((SavedStateRegistry$SavedStateProvider) entry.getValue()).saveState());
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (bundleBundleOf.isEmpty()) {
            return;
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundleBundleOf);
    }

    public void registerAvailabilityCallback(SequentialExecutor sequentialExecutor, Camera2CameraImpl.CameraAvailability cameraAvailability) {
        CameraManagerCompat.AvailabilityCallbackExecutorWrapper availabilityCallbackExecutorWrapper;
        CameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21 cameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21 = (CameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21) this.cache;
        synchronized (cameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21.mWrapperMap) {
            try {
                availabilityCallbackExecutorWrapper = (CameraManagerCompat.AvailabilityCallbackExecutorWrapper) cameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21.mWrapperMap.get(cameraAvailability);
                if (availabilityCallbackExecutorWrapper == null) {
                    availabilityCallbackExecutorWrapper = new CameraManagerCompat.AvailabilityCallbackExecutorWrapper(sequentialExecutor, cameraAvailability);
                    cameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21.mWrapperMap.put(cameraAvailability, availabilityCallbackExecutorWrapper);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        ((CameraManager) this.weakMemoryCache).registerAvailabilityCallback(availabilityCallbackExecutorWrapper, cameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21.mCompatHandler);
    }

    @Override // coil.memory.StrongMemoryCache
    public void set(MemoryCache$Key memoryCache$Key, Bitmap bitmap, Map map) {
        int i;
        int allocationByteCountCompat = Bitmaps.getAllocationByteCountCompat(bitmap);
        RealStrongMemoryCache$cache$1 realStrongMemoryCache$cache$1 = (RealStrongMemoryCache$cache$1) this.cache;
        synchronized (realStrongMemoryCache$cache$1.lock) {
            i = realStrongMemoryCache$cache$1.maxSize;
        }
        if (allocationByteCountCompat <= i) {
            ((RealStrongMemoryCache$cache$1) this.cache).put(memoryCache$Key, new InternalValue(bitmap, map, allocationByteCountCompat));
        } else {
            ((RealStrongMemoryCache$cache$1) this.cache).remove(memoryCache$Key);
            ((RealWeakMemoryCache) this.weakMemoryCache).set(memoryCache$Key, bitmap, map, allocationByteCountCompat);
        }
    }

    @Override // coil.memory.StrongMemoryCache
    public void trimMemory(int i) {
        int i2;
        if (i >= 40) {
            ((RealStrongMemoryCache$cache$1) this.cache).trimToSize(-1);
            return;
        }
        if (10 > i || i >= 20) {
            return;
        }
        RealStrongMemoryCache$cache$1 realStrongMemoryCache$cache$1 = (RealStrongMemoryCache$cache$1) this.cache;
        synchronized (realStrongMemoryCache$cache$1.lock) {
            i2 = realStrongMemoryCache$cache$1.size;
        }
        realStrongMemoryCache$cache$1.trimToSize(i2 / 2);
    }

    public void unregisterAvailabilityCallback(CameraManager.AvailabilityCallback availabilityCallback) {
        CameraManagerCompat.AvailabilityCallbackExecutorWrapper availabilityCallbackExecutorWrapper;
        if (availabilityCallback != null) {
            CameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21 cameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21 = (CameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21) this.cache;
            synchronized (cameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21.mWrapperMap) {
                availabilityCallbackExecutorWrapper = (CameraManagerCompat.AvailabilityCallbackExecutorWrapper) cameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21.mWrapperMap.remove(availabilityCallback);
            }
        } else {
            availabilityCallbackExecutorWrapper = null;
        }
        if (availabilityCallbackExecutorWrapper != null) {
            availabilityCallbackExecutorWrapper.setDisabled();
        }
        ((CameraManager) this.weakMemoryCache).unregisterAvailabilityCallback(availabilityCallbackExecutorWrapper);
    }

    public void updateState(CameraInternal.State state, AutoValue_CameraState_StateError autoValue_CameraState_StateError) {
        AutoValue_CameraState autoValue_CameraState;
        switch (state) {
            case RELEASED:
            case CLOSED:
                autoValue_CameraState = new AutoValue_CameraState(5, autoValue_CameraState_StateError);
                break;
            case RELEASING:
            case CLOSING:
                autoValue_CameraState = new AutoValue_CameraState(4, autoValue_CameraState_StateError);
                break;
            case PENDING_OPEN:
                CameraStateRegistry cameraStateRegistry = (CameraStateRegistry) this.weakMemoryCache;
                synchronized (cameraStateRegistry.mLock) {
                    Iterator it = cameraStateRegistry.mCameraStates.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            autoValue_CameraState = new AutoValue_CameraState(1, null);
                        } else if (((CameraStateRegistry.CameraRegistration) ((Map.Entry) it.next()).getValue()).mState == CameraInternal.State.CLOSING) {
                            autoValue_CameraState = new AutoValue_CameraState(2, null);
                        }
                    }
                }
                break;
            case OPENING:
                autoValue_CameraState = new AutoValue_CameraState(2, autoValue_CameraState_StateError);
                break;
            case OPEN:
            case CONFIGURED:
                autoValue_CameraState = new AutoValue_CameraState(3, autoValue_CameraState_StateError);
                break;
            default:
                throw new IllegalStateException("Unknown internal camera state: " + state);
        }
        LazyKt__LazyJVMKt.d("CameraStateMachine", "New public camera state " + autoValue_CameraState + " from " + state + " and " + autoValue_CameraState_StateError);
        if (Objects.equals((AutoValue_CameraState) ((MutableLiveData) this.cache).getValue(), autoValue_CameraState)) {
            return;
        }
        LazyKt__LazyJVMKt.d("CameraStateMachine", "Publishing new public camera state " + autoValue_CameraState);
        ((MutableLiveData) this.cache).postValue(autoValue_CameraState);
    }

    public /* synthetic */ RealStrongMemoryCache(int i, Object obj, Object obj2, boolean z) {
        this.$r8$classId = i;
        this.weakMemoryCache = obj;
        this.cache = obj2;
    }

    public /* synthetic */ RealStrongMemoryCache(int i, boolean z) {
        this.$r8$classId = i;
    }

    public RealStrongMemoryCache(String str, zaa zaaVar, zzd zzdVar) {
        this.$r8$classId = 20;
        this.cache = str;
        this.weakMemoryCache = zaaVar;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x003e  */
    /* JADX WARN: Code duplicated, block: B:17:0x0046  */
    /* JADX WARN: Code duplicated, block: B:20:0x0059  */
    public CctBackendFactory get(String str) {
        Bundle bundle;
        Map map;
        Object obj;
        if (((Map) this.cache) == null) {
            Context context = (Context) this.weakMemoryCache;
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("BackendRegistry", "Context has no PackageManager.");
                } else {
                    ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) TransportBackendDiscovery.class), 128);
                    if (serviceInfo == null) {
                        Log.w("BackendRegistry", "TransportBackendDiscovery has no service info.");
                    } else {
                        bundle = serviceInfo.metaData;
                    }
                    if (bundle == null) {
                        Log.w("BackendRegistry", "Could not retrieve metadata, returning empty list of transport backends.");
                        map = Collections.EMPTY_MAP;
                    } else {
                        HashMap map2 = new HashMap();
                        for (String str2 : bundle.keySet()) {
                            obj = bundle.get(str2);
                            if (!(obj instanceof String) && str2.startsWith("backend:")) {
                                for (String str3 : ((String) obj).split(",", -1)) {
                                    String strTrim = str3.trim();
                                    if (!strTrim.isEmpty()) {
                                        map2.put(strTrim, str2.substring(8));
                                    }
                                }
                            }
                        }
                        map = map2;
                    }
                    this.cache = map;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("BackendRegistry", "Application info not found.");
            }
            bundle = null;
            if (bundle == null) {
                Log.w("BackendRegistry", "Could not retrieve metadata, returning empty list of transport backends.");
                map = Collections.EMPTY_MAP;
            } else {
                HashMap map3 = new HashMap();
                while (r6.hasNext()) {
                    obj = bundle.get(str2);
                    if (!(obj instanceof String)) {
                    }
                }
                map = map3;
            }
            this.cache = map;
        }
        String str4 = (String) ((Map) this.cache).get(str);
        if (str4 == null) {
            return null;
        }
        try {
            return (CctBackendFactory) Class.forName(str4).asSubclass(CctBackendFactory.class).getDeclaredConstructor(null).newInstance(null);
        } catch (ClassNotFoundException e) {
            Log.w("BackendRegistry", "Class " + str4 + " is not found.", e);
            return null;
        } catch (IllegalAccessException e2) {
            Log.w("BackendRegistry", "Could not instantiate " + str4 + ".", e2);
            return null;
        } catch (InstantiationException e3) {
            Log.w("BackendRegistry", "Could not instantiate " + str4 + ".", e3);
            return null;
        } catch (NoSuchMethodException e4) {
            Log.w("BackendRegistry", "Could not instantiate ".concat(str4), e4);
            return null;
        } catch (InvocationTargetException e5) {
            Log.w("BackendRegistry", "Could not instantiate ".concat(str4), e5);
            return null;
        }
    }

    public RealStrongMemoryCache(Parcel parcel) {
        this.$r8$classId = 18;
        this.weakMemoryCache = parcel;
        this.cache = new Request(new HashMap(), new HashMap(), new HashMap(), new HashMap(), new HashMap(), 16);
    }

    public RealStrongMemoryCache(SavedStateRegistryImpl savedStateRegistryImpl) {
        this.$r8$classId = 17;
        this.weakMemoryCache = savedStateRegistryImpl;
        this.cache = new WorkLauncherImpl(savedStateRegistryImpl);
    }

    public RealStrongMemoryCache(WorkDatabase workDatabase) {
        this.$r8$classId = 1;
        this.weakMemoryCache = workDatabase;
        this.cache = new WorkTagDao_Impl$1(workDatabase, 2);
    }

    public RealStrongMemoryCache(LayoutNode layoutNode, MeasurePolicy measurePolicy) {
        this.$r8$classId = 11;
        this.weakMemoryCache = layoutNode;
        this.cache = Stack.mutableStateOf$default(measurePolicy);
    }

    public RealStrongMemoryCache(CameraStateRegistry cameraStateRegistry) {
        this.$r8$classId = 3;
        this.weakMemoryCache = cameraStateRegistry;
        MutableLiveData mutableLiveData = new MutableLiveData();
        this.cache = mutableLiveData;
        mutableLiveData.postValue(new AutoValue_CameraState(5, null));
    }

    public RealStrongMemoryCache(Context context, CameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21 cameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21) {
        this.$r8$classId = 4;
        this.weakMemoryCache = (CameraManager) context.getSystemService("camera");
        this.cache = cameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21;
    }

    public RealStrongMemoryCache(final int i, RealWeakMemoryCache realWeakMemoryCache) {
        this.$r8$classId = 0;
        this.weakMemoryCache = realWeakMemoryCache;
        this.cache = new LruCache(i) { // from class: coil.memory.RealStrongMemoryCache$cache$1
            @Override // androidx.collection.LruCache
            public final void entryRemoved(Object obj, Object obj2, Object obj3) {
                RealStrongMemoryCache.InternalValue internalValue = (RealStrongMemoryCache.InternalValue) obj2;
                ((RealWeakMemoryCache) this.weakMemoryCache).set((MemoryCache$Key) obj, internalValue.bitmap, internalValue.extras, internalValue.size);
            }

            @Override // androidx.collection.LruCache
            public final int sizeOf(Object obj, Object obj2) {
                return ((RealStrongMemoryCache.InternalValue) obj2).size;
            }
        };
    }

    public RealStrongMemoryCache(Context context, int i) {
        this.$r8$classId = i;
        switch (i) {
            case 21:
                this.cache = new AtomicLong(-1L);
                this.weakMemoryCache = new zao(context, zao.zae, new TelemetryLoggingOptions("mlkit:vision"), GoogleApi.Settings.DEFAULT_SETTINGS);
                break;
            default:
                this.cache = null;
                this.weakMemoryCache = context;
                break;
        }
    }

    private final void onFailure$androidx$camera$camera2$internal$Camera2CameraImpl$3(Throwable th) {
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public CompositeDecoder beginStructure(SerialDescriptor serialDescriptor) {
        return this;
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public Decoder decodeInline(SerialDescriptor serialDescriptor) {
        return this;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public void endStructure(SerialDescriptor serialDescriptor) {
    }

    public RealStrongMemoryCache(int i) {
        this.$r8$classId = i;
        switch (i) {
            case 12:
                this.weakMemoryCache = new MutableVector(new Reference[16]);
                this.cache = new ReferenceQueue();
                break;
            default:
                this.weakMemoryCache = new MutableScatterMap();
                this.cache = new MutableScatterMap();
                break;
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public Decoder decodeInlineElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i) {
        return this;
    }
}
