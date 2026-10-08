package coil.request;

import android.animation.Animator;
import android.content.Context;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Parcel;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import android.view.Surface;
import android.view.View;
import android.view.WindowInsetsAnimation;
import android.view.animation.Animation;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import androidx.camera.camera2.internal.Camera2CameraFactory;
import androidx.camera.camera2.internal.Camera2CameraImpl;
import androidx.camera.camera2.internal.CaptureSession;
import androidx.camera.camera2.internal.ExposureStateImpl;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ExtraSupportedOutputSizeQuirk;
import androidx.camera.core.AutoValue_CameraState_StateError;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.camera.core.InitializationException;
import androidx.camera.core.Preview$$ExternalSyntheticLambda1;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.processing.SurfaceEdge;
import androidx.camera.core.processing.SurfaceOutputImpl;
import androidx.camera.core.processing.SurfaceProcessorInternal;
import androidx.compose.foundation.style.InteractionSet;
import androidx.compose.runtime.CancellationHandle;
import androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.AtomicInt;
import androidx.compose.ui.graphics.Api26Bitmap$$ExternalSyntheticApiModelOutline0;
import androidx.compose.ui.input.pointer.util.VelocityTracker1D;
import androidx.compose.ui.platform.coreshims.ViewCompatShims;
import androidx.compose.ui.text.android.CanvasCompatQ$$ExternalSyntheticApiModelOutline0;
import androidx.compose.ui.unit.Density;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.graphics.Insets;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.ViewBoundsCheck$BoundFlags;
import androidx.recyclerview.widget.ViewBoundsCheck$Callback;
import androidx.tracing.TraceApi29Impl;
import androidx.work.Operation;
import androidx.work.impl.StartStopTokens;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.model.WorkTagDao_Impl$1;
import androidx.work.impl.utils.futures.SettableFuture;
import coil.RealImageLoader;
import coil.memory.EmptyStrongMemoryCache;
import coil.network.RealNetworkObserver;
import coil.size.Dimension;
import coil.size.Size;
import coil.util.Bitmaps;
import coil.util.HardwareBitmapService;
import coil.util.HardwareBitmaps;
import coil.util.ImmutableHardwareBitmapService;
import coil.util.Requests;
import coil.util.SingletonDiskCache;
import coil.util.SystemCallbacks;
import coil.util.Utils;
import com.caverock.androidsvg.SVG;
import com.google.android.datatransport.runtime.backends.MetadataBackendRegistry;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.gms.internal.mlkit_vision_common.zzky;
import com.google.android.gms.internal.mlkit_vision_common.zzmw;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.zzw;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.collections.builders.ListBuilderKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PrimitiveArrayDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import okhttp3.Request;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class RequestService implements FutureCallback, CancellationHandle, Operation, Encoder, CompositeEncoder, Factory, OnCompleteListener {
    public final /* synthetic */ int $r8$classId;
    public Object hardwareBitmapService;
    public Object systemCallbacks;

    public /* synthetic */ RequestService(int i, Object obj, Object obj2) {
        this.$r8$classId = i;
        this.hardwareBitmapService = obj;
        this.systemCallbacks = obj2;
    }

    public static ErrorResult errorResult(ImageRequest imageRequest, Throwable th) {
        if (th instanceof NullRequestDataException) {
            imageRequest.getClass();
            DefaultRequestOptions defaultRequestOptions = imageRequest.defaults;
            defaultRequestOptions.getClass();
            DefaultRequestOptions defaultRequestOptions2 = Requests.DEFAULT_REQUEST_OPTIONS;
            defaultRequestOptions.getClass();
        } else {
            imageRequest.defaults.getClass();
            DefaultRequestOptions defaultRequestOptions3 = Requests.DEFAULT_REQUEST_OPTIONS;
        }
        return new ErrorResult(null, imageRequest, th);
    }

    public void add(Object obj, String str) {
        ((ArrayList) this.systemCallbacks).add(ImageAnalysis$$ExternalSyntheticLambda1.m(str, "=", String.valueOf(obj)));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public CompositeEncoder beginCollection(SerialDescriptor serialDescriptor, int i) {
        encodeInt(i);
        return this;
    }

    @Override // androidx.compose.runtime.CancellationHandle
    public void cancel() {
        if (((AtomicInt) this.hardwareBitmapService).compareAndSet(1, 1)) {
            return;
        }
        ((GapComposer$$ExternalSyntheticLambda0) this.systemCallbacks).invoke();
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeBoolean(boolean z) {
        encodeByte(z ? (byte) 1 : (byte) 0);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public void encodeBooleanElement(SerialDescriptor serialDescriptor, int i, boolean z) {
        encodeByte(z ? (byte) 1 : (byte) 0);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeByte(byte b) {
        ((Parcel) this.systemCallbacks).writeByte(b);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public void encodeByteElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i, byte b) {
        encodeByte(b);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeChar(char c) {
        encodeInt(c);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public void encodeCharElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i, char c) {
        encodeInt(c);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeDouble(double d) {
        ((Parcel) this.systemCallbacks).writeDouble(d);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public void encodeDoubleElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i, double d) {
        encodeDouble(d);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeEnum(SerialDescriptor serialDescriptor, int i) {
        encodeInt(i);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeFloat(float f) {
        ((Parcel) this.systemCallbacks).writeFloat(f);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public void encodeFloatElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i, float f) {
        encodeFloat(f);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeInt(int i) {
        ((Parcel) this.systemCallbacks).writeInt(i);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public void encodeIntElement(int i, int i2, SerialDescriptor serialDescriptor) {
        encodeInt(i2);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeLong(long j) {
        ((Parcel) this.systemCallbacks).writeLong(j);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public void encodeLongElement(SerialDescriptor serialDescriptor, int i, long j) {
        encodeLong(j);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeNotNullMark() {
        encodeByte((byte) 1);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeNull() {
        encodeByte((byte) 0);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public void encodeNullableSerializableElement(SerialDescriptor serialDescriptor, int i, Object obj) {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        if (obj == null) {
            encodeNull();
        } else {
            encodeNotNullMark();
            encodeSerializableValue(stringSerializer, obj);
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public void encodeSerializableElement(SerialDescriptor serialDescriptor, int i, KSerializer kSerializer, Object obj) {
        kSerializer.serialize(this, obj);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeSerializableValue(KSerializer kSerializer, Object obj) {
        kSerializer.serialize(this, obj);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeShort(short s) {
        encodeInt(s);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public void encodeShortElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i, short s) {
        encodeInt(s);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeString(String str) {
        ((Parcel) this.systemCallbacks).writeString(str);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public void encodeStringElement(SerialDescriptor serialDescriptor, int i, String str) {
        encodeString(str);
    }

    public View findOneViewWithinBoundFlags(int i, int i2, int i3, int i4) {
        ViewBoundsCheck$BoundFlags viewBoundsCheck$BoundFlags = (ViewBoundsCheck$BoundFlags) this.hardwareBitmapService;
        ViewBoundsCheck$Callback viewBoundsCheck$Callback = (ViewBoundsCheck$Callback) this.systemCallbacks;
        int parentStart = viewBoundsCheck$Callback.getParentStart();
        int parentEnd = viewBoundsCheck$Callback.getParentEnd();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View childAt = viewBoundsCheck$Callback.getChildAt(i);
            int childStart = viewBoundsCheck$Callback.getChildStart(childAt);
            int childEnd = viewBoundsCheck$Callback.getChildEnd(childAt);
            viewBoundsCheck$BoundFlags.mRvStart = parentStart;
            viewBoundsCheck$BoundFlags.mRvEnd = parentEnd;
            viewBoundsCheck$BoundFlags.mChildStart = childStart;
            viewBoundsCheck$BoundFlags.mChildEnd = childEnd;
            if (i3 != 0) {
                viewBoundsCheck$BoundFlags.mBoundFlags = i3;
                if (viewBoundsCheck$BoundFlags.boundsMatch()) {
                    return childAt;
                }
            }
            if (i4 != 0) {
                viewBoundsCheck$BoundFlags.mBoundFlags = i4;
                if (viewBoundsCheck$BoundFlags.boundsMatch()) {
                    view = childAt;
                }
            }
            i += i5;
        }
        return view;
    }

    @Override // javax.inject.Provider
    public Object get() {
        return new MetadataBackendRegistry((Context) ((InteractionSet) this.systemCallbacks).setOrValue, (SVG) ((EmptyStrongMemoryCache) this.hardwareBitmapService).get());
    }

    public LinkedHashSet getCameras() {
        LinkedHashSet linkedHashSet;
        synchronized (this.systemCallbacks) {
            linkedHashSet = new LinkedHashSet(((LinkedHashMap) this.hardwareBitmapService).values());
        }
        return linkedHashSet;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public Request getSerializersModule() {
        return (Request) this.hardwareBitmapService;
    }

    public void init(Camera2CameraFactory camera2CameraFactory) {
        synchronized (this.systemCallbacks) {
            try {
                camera2CameraFactory.getClass();
                for (String str : new LinkedHashSet(camera2CameraFactory.mAvailableCameraIds)) {
                    LazyKt__LazyJVMKt.d("CameraRepository", "Added camera: " + str);
                    ((LinkedHashMap) this.hardwareBitmapService).put(str, camera2CameraFactory.getCamera(str));
                }
            } catch (CameraUnavailableException e) {
                throw new InitializationException(e);
            }
        }
    }

    public boolean isViewWithinBoundFlags(View view) {
        ViewBoundsCheck$BoundFlags viewBoundsCheck$BoundFlags = (ViewBoundsCheck$BoundFlags) this.hardwareBitmapService;
        ViewBoundsCheck$Callback viewBoundsCheck$Callback = (ViewBoundsCheck$Callback) this.systemCallbacks;
        int parentStart = viewBoundsCheck$Callback.getParentStart();
        int parentEnd = viewBoundsCheck$Callback.getParentEnd();
        int childStart = viewBoundsCheck$Callback.getChildStart(view);
        int childEnd = viewBoundsCheck$Callback.getChildEnd(view);
        viewBoundsCheck$BoundFlags.mRvStart = parentStart;
        viewBoundsCheck$BoundFlags.mRvEnd = parentEnd;
        viewBoundsCheck$BoundFlags.mChildStart = childStart;
        viewBoundsCheck$BoundFlags.mChildEnd = childEnd;
        viewBoundsCheck$BoundFlags.mBoundFlags = 24579;
        return viewBoundsCheck$BoundFlags.boundsMatch();
    }

    public void markState(Operation.State state) {
        SettableFuture settableFuture = (SettableFuture) this.hardwareBitmapService;
        ((MutableLiveData) this.systemCallbacks).postValue(state);
        if (state instanceof Operation.State.SUCCESS) {
            settableFuture.set((Operation.State.SUCCESS) state);
        } else if (state instanceof Operation.State.FAILURE) {
            settableFuture.setException(((Operation.State.FAILURE) state).mThrowable);
        }
    }

    public AutofillId newAutofillId(long j) {
        if (Build.VERSION.SDK_INT < 29) {
            return null;
        }
        ContentCaptureSession contentCaptureSessionM = CanvasCompatQ$$ExternalSyntheticApiModelOutline0.m(this.systemCallbacks);
        ExposureStateImpl autofillId = ViewCompatShims.getAutofillId((View) this.hardwareBitmapService);
        Objects.requireNonNull(autofillId);
        return TraceApi29Impl.newAutofillId(contentCaptureSessionM, Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(autofillId.mLock), j);
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(zzw zzwVar) {
        ((Map) ((StartStopTokens) this.hardwareBitmapService).runs).remove((TaskCompletionSource) this.systemCallbacks);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0068  */
    /* JADX WARN: Code duplicated, block: B:24:0x0074  */
    /* JADX WARN: Code duplicated, block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:? A[RETURN, SYNTHETIC] */
    @Override // androidx.camera.core.impl.utils.futures.FutureCallback
    public void onFailure(Throwable th) throws Throwable {
        Camera2CameraImpl camera2CameraImpl;
        HandlerScheduledExecutorService handlerScheduledExecutorServiceMainThreadExecutor;
        SessionConfig.ErrorListener errorListener;
        switch (this.$r8$classId) {
            case 2:
                SessionConfig sessionConfig = null;
                if (!(th instanceof DeferrableSurface.SurfaceClosedException)) {
                    if (th instanceof CancellationException) {
                        ((Camera2CameraImpl) this.hardwareBitmapService).debugLog("Unable to configure camera cancelled", null);
                        return;
                    }
                    if (((Camera2CameraImpl) this.hardwareBitmapService).mState == 9) {
                        ((Camera2CameraImpl) this.hardwareBitmapService).setState(9, new AutoValue_CameraState_StateError(4, th), true);
                    }
                    LazyKt__LazyJVMKt.e("Camera2CameraImpl", "Unable to configure camera " + ((Camera2CameraImpl) this.hardwareBitmapService), th);
                    Camera2CameraImpl camera2CameraImpl2 = (Camera2CameraImpl) this.hardwareBitmapService;
                    if (camera2CameraImpl2.mCaptureSession == ((CaptureSession) this.systemCallbacks)) {
                        camera2CameraImpl2.resetCaptureSession();
                        return;
                    }
                    return;
                }
                Camera2CameraImpl camera2CameraImpl3 = (Camera2CameraImpl) this.hardwareBitmapService;
                DeferrableSurface deferrableSurface = ((DeferrableSurface.SurfaceClosedException) th).mDeferrableSurface;
                for (SessionConfig sessionConfig2 : camera2CameraImpl3.mUseCaseAttachState.getAttachedSessionConfigs()) {
                    if (sessionConfig2.getSurfaces().contains(deferrableSurface)) {
                        sessionConfig = sessionConfig2;
                        if (sessionConfig != null) {
                            camera2CameraImpl = (Camera2CameraImpl) this.hardwareBitmapService;
                            handlerScheduledExecutorServiceMainThreadExecutor = SetsKt.mainThreadExecutor();
                            errorListener = sessionConfig.mErrorListener;
                            if (errorListener != null) {
                                camera2CameraImpl.debugLog("Posting surface closed", new Throwable());
                                handlerScheduledExecutorServiceMainThreadExecutor.execute(new Preview$$ExternalSyntheticLambda1(9, errorListener, sessionConfig));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                if (sessionConfig != null) {
                    camera2CameraImpl = (Camera2CameraImpl) this.hardwareBitmapService;
                    handlerScheduledExecutorServiceMainThreadExecutor = SetsKt.mainThreadExecutor();
                    errorListener = sessionConfig.mErrorListener;
                    if (errorListener != null) {
                        camera2CameraImpl.debugLog("Posting surface closed", new Throwable());
                        handlerScheduledExecutorServiceMainThreadExecutor.execute(new Preview$$ExternalSyntheticLambda1(9, errorListener, sessionConfig));
                        return;
                    }
                    return;
                }
                return;
            case 3:
                throw new IllegalStateException("Future should never fail. Did it get completed by GC?", th);
            default:
                int i = ((SurfaceEdge) this.systemCallbacks).mTargets;
                if (i == 2 && (th instanceof CancellationException)) {
                    LazyKt__LazyJVMKt.d("DualSurfaceProcessorNode", "Downstream VideoCapture failed to provide Surface.");
                    return;
                }
                LazyKt__LazyJVMKt.w("DualSurfaceProcessorNode", "Downstream node failed to provide Surface. Target: " + ListBuilderKt.getHumanReadableName(i), th);
                return;
        }
    }

    @Override // androidx.camera.core.impl.utils.futures.FutureCallback
    public void onSuccess(Object obj) throws Throwable {
        switch (this.$r8$classId) {
            case 2:
                Camera2CameraImpl camera2CameraImpl = (Camera2CameraImpl) this.hardwareBitmapService;
                if (camera2CameraImpl.mCameraCoordinator.version == 2 && camera2CameraImpl.mState == 9) {
                    ((Camera2CameraImpl) this.hardwareBitmapService).setState(10);
                    break;
                }
                break;
            case 3:
                ((Surface) this.systemCallbacks).release();
                ((SurfaceTexture) this.hardwareBitmapService).release();
                break;
            default:
                SurfaceOutputImpl surfaceOutputImpl = (SurfaceOutputImpl) obj;
                surfaceOutputImpl.getClass();
                ((SurfaceProcessorInternal) ((Request) this.hardwareBitmapService).url).onOutputSurface(surfaceOutputImpl);
                break;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public Options options(ImageRequest imageRequest, Size size) {
        List list = imageRequest.transformations;
        Bitmap.Config config = imageRequest.bitmapConfig;
        if (!list.isEmpty() && !ArraysKt.contains(Utils.VALID_TRANSFORMATION_CONFIGS, config)) {
            config = Bitmap.Config.ARGB_8888;
        } else if (Bitmaps.isHardware(config)) {
            if (!Bitmaps.isHardware(config) || imageRequest.allowHardware) {
                if (!((HardwareBitmapService) this.hardwareBitmapService).allowHardwareMainThread(size)) {
                }
            }
            config = Bitmap.Config.ARGB_8888;
        }
        Dimension dimension = size.width;
        Dimension.Undefined undefined = Dimension.Undefined.INSTANCE;
        return new Options(imageRequest.context, config, null, size, (dimension.equals(undefined) || size.height.equals(undefined)) ? 2 : imageRequest.scale, Requests.getAllowInexactSize(imageRequest), imageRequest.allowRgb565 && imageRequest.transformations.isEmpty() && config != Bitmap.Config.ALPHA_8, imageRequest.premultipliedAlpha, null, imageRequest.headers, imageRequest.tags, imageRequest.parameters, imageRequest.memoryCachePolicy, imageRequest.diskCachePolicy, imageRequest.networkCachePolicy);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void parseConstraintSet(Context context, XmlResourceParser xmlResourceParser) {
        ConstraintSet constraintSet = new ConstraintSet();
        int attributeCount = xmlResourceParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            if ("id".equals(xmlResourceParser.getAttributeName(i))) {
                String attributeValue = xmlResourceParser.getAttributeValue(i);
                int identifier = attributeValue.contains("/") ? context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName()) : -1;
                if (identifier == -1) {
                    if (attributeValue.length() > 1) {
                        identifier = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                try {
                    int eventType = xmlResourceParser.getEventType();
                    ConstraintSet.Constraint constraintFillFromAttributeList = null;
                    while (eventType != 1) {
                        if (eventType == 0) {
                            xmlResourceParser.getName();
                        } else if (eventType == 2) {
                            String name = xmlResourceParser.getName();
                            switch (name.hashCode()) {
                                case -2025855158:
                                    if (name.equals("Layout")) {
                                        if (constraintFillFromAttributeList == null) {
                                            throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                        }
                                        constraintFillFromAttributeList.layout.fillFromAttributeList(context, Xml.asAttributeSet(xmlResourceParser));
                                    } else {
                                        continue;
                                    }
                                    break;
                                case -1984451626:
                                    if (name.equals("Motion")) {
                                        if (constraintFillFromAttributeList == null) {
                                            throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                        }
                                        constraintFillFromAttributeList.motion.fillFromAttributeList(context, Xml.asAttributeSet(xmlResourceParser));
                                    } else {
                                        continue;
                                    }
                                    break;
                                case -1269513683:
                                    if (name.equals("PropertySet")) {
                                        if (constraintFillFromAttributeList == null) {
                                            throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                        }
                                        constraintFillFromAttributeList.propertySet.fillFromAttributeList(context, Xml.asAttributeSet(xmlResourceParser));
                                    } else {
                                        continue;
                                    }
                                    break;
                                case -1238332596:
                                    if (name.equals("Transform")) {
                                        if (constraintFillFromAttributeList == null) {
                                            throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                        }
                                        constraintFillFromAttributeList.transform.fillFromAttributeList(context, Xml.asAttributeSet(xmlResourceParser));
                                    } else {
                                        continue;
                                    }
                                    break;
                                case -71750448:
                                    if (name.equals("Guideline")) {
                                        constraintFillFromAttributeList = ConstraintSet.fillFromAttributeList(context, Xml.asAttributeSet(xmlResourceParser));
                                        constraintFillFromAttributeList.layout.mIsGuideline = true;
                                    }
                                    break;
                                case 1331510167:
                                    if (name.equals("Barrier")) {
                                        constraintFillFromAttributeList = ConstraintSet.fillFromAttributeList(context, Xml.asAttributeSet(xmlResourceParser));
                                        constraintFillFromAttributeList.layout.mHelperType = 1;
                                    }
                                    break;
                                case 1791837707:
                                    if (name.equals("CustomAttribute")) {
                                        if (constraintFillFromAttributeList == null) {
                                            throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                        }
                                        ConstraintAttribute.parse(context, xmlResourceParser, constraintFillFromAttributeList.mCustomConstraints);
                                    } else {
                                        continue;
                                    }
                                    break;
                                case 1803088381:
                                    if (name.equals("Constraint")) {
                                        constraintFillFromAttributeList = ConstraintSet.fillFromAttributeList(context, Xml.asAttributeSet(xmlResourceParser));
                                    }
                                    break;
                            }
                        } else if (eventType != 3) {
                            continue;
                        } else {
                            String name2 = xmlResourceParser.getName();
                            if ("ConstraintSet".equals(name2)) {
                                ((SparseArray) this.hardwareBitmapService).put(identifier, constraintSet);
                                return;
                            } else if (name2.equalsIgnoreCase("Constraint")) {
                                constraintSet.mConstraints.put(Integer.valueOf(constraintFillFromAttributeList.mViewId), constraintFillFromAttributeList);
                                constraintFillFromAttributeList = null;
                            }
                        }
                        eventType = xmlResourceParser.next();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (XmlPullParserException e2) {
                    e2.printStackTrace();
                }
                ((SparseArray) this.hardwareBitmapService).put(identifier, constraintSet);
                return;
            }
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public boolean shouldEncodeElementDefault() {
        return true;
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 14:
                return "Bounds{lower=" + ((Insets) this.systemCallbacks) + " upper=" + ((Insets) this.hardwareBitmapService) + "}";
            case 21:
                StringBuilder sb = new StringBuilder(100);
                sb.append(this.hardwareBitmapService.getClass().getSimpleName());
                sb.append('{');
                ArrayList arrayList = (ArrayList) this.systemCallbacks;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    sb.append((String) arrayList.get(i));
                    if (i < size - 1) {
                        sb.append(", ");
                    }
                }
                sb.append('}');
                return sb.toString();
            default:
                return super.toString();
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x003d  */
    public Options updateOptionsOnWorkerThread(Options options) {
        boolean z;
        boolean z2;
        Bitmap.Config config = options.config;
        int i = options.networkCachePolicy;
        boolean z3 = true;
        if (!Bitmaps.isHardware(config) || ((HardwareBitmapService) this.hardwareBitmapService).allowHardwareWorkerThread()) {
            z = false;
        } else {
            config = Bitmap.Config.ARGB_8888;
            z = true;
        }
        Bitmap.Config config2 = config;
        if (Density.CC.getReadEnabled(options.networkCachePolicy)) {
            SystemCallbacks systemCallbacks = (SystemCallbacks) this.systemCallbacks;
            synchronized (systemCallbacks) {
                systemCallbacks.registerNetworkObserver();
                z2 = systemCallbacks._isOnline;
            }
            if (z2) {
                z3 = z;
            } else {
                i = 4;
            }
        } else {
            z3 = z;
        }
        return z3 ? new Options(options.context, config2, options.colorSpace, options.size, options.scale, options.allowInexactSize, options.allowRgb565, options.premultipliedAlpha, options.diskCacheKey, options.headers, options.tags, options.parameters, options.memoryCachePolicy, options.diskCachePolicy, i) : options;
    }

    public /* synthetic */ RequestService(int i, Object obj, Object obj2, boolean z) {
        this.$r8$classId = i;
        this.systemCallbacks = obj;
        this.hardwareBitmapService = obj2;
    }

    public RequestService(RealNetworkObserver realNetworkObserver) {
        this.$r8$classId = 22;
        this.hardwareBitmapService = new zzky();
        this.systemCallbacks = realNetworkObserver;
        zzmw.zza();
    }

    public /* synthetic */ RequestService(Object obj) {
        this.$r8$classId = 21;
        this.hardwareBitmapService = obj;
        this.systemCallbacks = new ArrayList();
    }

    public RequestService(RealImageLoader realImageLoader, SystemCallbacks systemCallbacks) {
        Object immutableHardwareBitmapService;
        this.$r8$classId = 0;
        this.systemCallbacks = systemCallbacks;
        int i = Build.VERSION.SDK_INT;
        if (i < 26) {
            boolean z = HardwareBitmaps.IS_DEVICE_BLOCKED;
        } else {
            if (!HardwareBitmaps.IS_DEVICE_BLOCKED) {
                if (i != 26 && i != 27) {
                    immutableHardwareBitmapService = new ImmutableHardwareBitmapService(true);
                } else {
                    immutableHardwareBitmapService = new SingletonDiskCache();
                }
            }
            this.hardwareBitmapService = immutableHardwareBitmapService;
        }
        immutableHardwareBitmapService = new ImmutableHardwareBitmapService(false);
        this.hardwareBitmapService = immutableHardwareBitmapService;
    }

    public RequestService(WorkDatabase_Impl workDatabase_Impl) {
        this.$r8$classId = 1;
        this.systemCallbacks = workDatabase_Impl;
        this.hardwareBitmapService = new WorkTagDao_Impl$1(workDatabase_Impl, 4);
    }

    public RequestService(GapComposer$$ExternalSyntheticLambda0 gapComposer$$ExternalSyntheticLambda0) {
        this.$r8$classId = 9;
        this.systemCallbacks = gapComposer$$ExternalSyntheticLambda0;
        this.hardwareBitmapService = new AtomicInt(0);
    }

    public RequestService(int i) {
        this.$r8$classId = i;
        switch (i) {
            case 7:
                this.systemCallbacks = new VelocityTracker1D(0);
                this.hardwareBitmapService = new VelocityTracker1D(0);
                break;
            case 13:
                break;
            case 17:
                this.systemCallbacks = new MutableLiveData();
                this.hardwareBitmapService = new SettableFuture();
                markState(Operation.IN_PROGRESS);
                break;
            default:
                this.systemCallbacks = new Object();
                this.hardwareBitmapService = new LinkedHashMap();
                new HashSet();
                break;
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public void endStructure() {
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public CompositeEncoder beginStructure(SerialDescriptor serialDescriptor) {
        return this;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public Encoder encodeInline(SerialDescriptor serialDescriptor) {
        return this;
    }

    public RequestService(String str) {
        this.$r8$classId = 4;
        this.systemCallbacks = (ExtraSupportedOutputSizeQuirk) DeviceQuirks.sQuirks.get(ExtraSupportedOutputSizeQuirk.class);
        this.hardwareBitmapService = new Symbol(str, 1);
    }

    public RequestService(Parcel parcel) {
        this.$r8$classId = 18;
        this.systemCallbacks = parcel;
        this.hardwareBitmapService = new Request(new HashMap(), new HashMap(), new HashMap(), new HashMap(), new HashMap(), 16);
    }

    public RequestService(ViewBoundsCheck$Callback viewBoundsCheck$Callback) {
        this.$r8$classId = 16;
        this.systemCallbacks = viewBoundsCheck$Callback;
        ViewBoundsCheck$BoundFlags viewBoundsCheck$BoundFlags = new ViewBoundsCheck$BoundFlags();
        viewBoundsCheck$BoundFlags.mBoundFlags = 0;
        this.hardwareBitmapService = viewBoundsCheck$BoundFlags;
    }

    public RequestService(Animation animation) {
        this.$r8$classId = 15;
        this.systemCallbacks = animation;
        this.hardwareBitmapService = null;
    }

    public RequestService(Animator animator) {
        this.$r8$classId = 15;
        this.systemCallbacks = null;
        this.hardwareBitmapService = animator;
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public Encoder encodeInlineElement(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i) {
        return this;
    }

    public RequestService(WindowInsetsAnimation.Bounds bounds) {
        this.$r8$classId = 14;
        this.systemCallbacks = Insets.toCompatInsets(bounds.getLowerBound());
        this.hardwareBitmapService = Insets.toCompatInsets(bounds.getUpperBound());
    }
}
