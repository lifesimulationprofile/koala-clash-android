package coil;

import android.content.ClipDescription;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextHelper;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.AutoValue_SurfaceOutput_CameraInputInfo;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.utils.futures.ChainingListenableFuture;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.processing.DefaultSurfaceProcessor;
import androidx.camera.core.processing.SurfaceEdge;
import androidx.camera.core.processing.SurfaceEdge$$ExternalSyntheticLambda4;
import androidx.camera.core.processing.util.AutoValue_OutConfig;
import androidx.camera.view.PreviewView;
import androidx.compose.foundation.border.BorderLogic$$ExternalSyntheticLambda1;
import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda0;
import androidx.compose.material3.internal.ripple.AndroidRippleNode;
import androidx.compose.runtime.internal.ThreadMap;
import androidx.compose.runtime.internal.Thread_androidKt;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Outline$Generic;
import androidx.compose.ui.graphics.Outline$Rectangle;
import androidx.compose.ui.graphics.Outline$Rounded;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerImpl;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.unit.Dp;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatImpl;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.LifecycleService;
import androidx.lifecycle.compose.LifecycleEffectKt$$ExternalSyntheticLambda1;
import androidx.room.RoomSQLiteQuery;
import androidx.work.Worker;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.model.WorkTag;
import androidx.work.impl.model.WorkTagDao_Impl$1;
import androidx.work.impl.model.WorkTagDao_Impl$2;
import coil.disk.RealDiskCache;
import coil.memory.RealStrongMemoryCache;
import coil.network.HttpException;
import coil.network.RealNetworkObserver;
import coil.util.Requests;
import coil.util.SingletonDiskCache;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGAndroidRenderer;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.TransportImpl;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.AutoValue_PersistedEvent;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.gms.internal.mlkit_vision_common.zzaj;
import com.google.android.material.textfield.IconHelper;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.config.EncoderConfig;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;
import com.google.zxing.qrcode.encoder.Encoder;
import com.google.zxing.qrcode.encoder.MinimalEncoder;
import com.google.zxing.qrcode.encoder.MinimalEncoder$ResultList$ResultNode;
import dev.chrisbanes.haze.BlurEffectKt$$ExternalSyntheticLambda1;
import fi.iki.elonen.NanoHTTPD;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import okhttp3.Handshake;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ImageLoader$Builder implements FutureCallback, InputContentInfoCompat$InputContentInfoCompatImpl, SynchronizationGuard.CriticalSection, SQLiteEventStore.Function, EncoderConfig {
    public final /* synthetic */ int $r8$classId;
    public Object applicationContext;
    public Object defaults;
    public Object options;

    public /* synthetic */ ImageLoader$Builder(Object obj, Object obj2, Object obj3, int i) {
        this.$r8$classId = i;
        this.applicationContext = obj;
        this.defaults = obj2;
        this.options = obj3;
    }

    public static ImageLoader$Builder obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr, int i) {
        return new ImageLoader$Builder(context, context.obtainStyledAttributes(attributeSet, iArr, i, 0));
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        SQLiteEventStore sQLiteEventStore;
        SQLiteEventStore sQLiteEventStore2 = (SQLiteEventStore) this.applicationContext;
        ArrayList arrayList = (ArrayList) this.defaults;
        AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) this.options;
        Cursor cursor = (Cursor) obj;
        Encoding encoding = SQLiteEventStore.PROTOBUF_ENCODING;
        while (cursor.moveToNext()) {
            long j = cursor.getLong(0);
            boolean z = cursor.getInt(7) != 0;
            AppCompatDrawableManager.AnonymousClass1 anonymousClass1 = new AppCompatDrawableManager.AnonymousClass1();
            anonymousClass1.TINT_CHECKABLE_BUTTON_LIST = new HashMap();
            String string = cursor.getString(1);
            if (string == null) {
                throw new NullPointerException("Null transportName");
            }
            anonymousClass1.COLORFILTER_TINT_COLOR_CONTROL_NORMAL = string;
            anonymousClass1.COLORFILTER_COLOR_BACKGROUND_MULTIPLY = Long.valueOf(cursor.getLong(2));
            anonymousClass1.TINT_COLOR_CONTROL_STATE_LIST = Long.valueOf(cursor.getLong(3));
            if (z) {
                String string2 = cursor.getString(4);
                anonymousClass1.COLORFILTER_COLOR_CONTROL_ACTIVATED = new EncodedPayload(string2 == null ? SQLiteEventStore.PROTOBUF_ENCODING : new Encoding(string2), cursor.getBlob(5));
                sQLiteEventStore = sQLiteEventStore2;
            } else {
                String string3 = cursor.getString(4);
                Encoding encoding2 = string3 == null ? SQLiteEventStore.PROTOBUF_ENCODING : new Encoding(string3);
                Cursor cursorQuery = sQLiteEventStore2.getDb().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j)}, null, null, "sequence_num");
                try {
                    Encoding encoding3 = SQLiteEventStore.PROTOBUF_ENCODING;
                    ArrayList arrayList2 = new ArrayList();
                    int length = 0;
                    while (cursorQuery.moveToNext()) {
                        byte[] blob = cursorQuery.getBlob(0);
                        arrayList2.add(blob);
                        length += blob.length;
                    }
                    byte[] bArr = new byte[length];
                    int i = 0;
                    int length2 = 0;
                    while (i < arrayList2.size()) {
                        byte[] bArr2 = (byte[]) arrayList2.get(i);
                        SQLiteEventStore sQLiteEventStore3 = sQLiteEventStore2;
                        System.arraycopy(bArr2, 0, bArr, length2, bArr2.length);
                        length2 += bArr2.length;
                        i++;
                        sQLiteEventStore2 = sQLiteEventStore3;
                    }
                    sQLiteEventStore = sQLiteEventStore2;
                    cursorQuery.close();
                    anonymousClass1.COLORFILTER_COLOR_CONTROL_ACTIVATED = new EncodedPayload(encoding2, bArr);
                } catch (Throwable th) {
                    cursorQuery.close();
                    throw th;
                }
            }
            if (!cursor.isNull(6)) {
                anonymousClass1.TINT_COLOR_CONTROL_NORMAL = Integer.valueOf(cursor.getInt(6));
            }
            arrayList.add(new AutoValue_PersistedEvent(j, autoValue_TransportContext, anonymousClass1.build()));
            sQLiteEventStore2 = sQLiteEventStore;
        }
        return null;
    }

    public void createAndSendSurfaceOutput(SurfaceEdge surfaceEdge, Map.Entry entry) {
        SurfaceEdge surfaceEdge2 = (SurfaceEdge) entry.getValue();
        AutoValue_SurfaceOutput_CameraInputInfo autoValue_SurfaceOutput_CameraInputInfo = null;
        AutoValue_SurfaceOutput_CameraInputInfo autoValue_SurfaceOutput_CameraInputInfo2 = new AutoValue_SurfaceOutput_CameraInputInfo(surfaceEdge.mStreamSpec.resolution, ((AutoValue_OutConfig) entry.getKey()).getCropRect, surfaceEdge.mHasCameraTransform ? (CameraInternal) this.defaults : null, ((AutoValue_OutConfig) entry.getKey()).getRotationDegrees, ((AutoValue_OutConfig) entry.getKey()).isMirroring);
        int i = ((AutoValue_OutConfig) entry.getKey()).getFormat;
        surfaceEdge2.getClass();
        MapsKt__MapsKt.checkMainThread();
        surfaceEdge2.checkNotClosed();
        Preconditions.checkState("Consumer can only be linked once.", !surfaceEdge2.mHasConsumer);
        surfaceEdge2.mHasConsumer = true;
        SurfaceEdge.SettableSurface settableSurface = surfaceEdge2.mSettableSurface;
        ChainingListenableFuture chainingListenableFutureTransformAsync = Futures.transformAsync(settableSurface.getSurface(), new SurfaceEdge$$ExternalSyntheticLambda4(surfaceEdge2, settableSurface, i, autoValue_SurfaceOutput_CameraInputInfo2, autoValue_SurfaceOutput_CameraInputInfo), SetsKt.mainThreadExecutor());
        chainingListenableFutureTransformAsync.addListener(new Worker.AnonymousClass2(1, chainingListenableFutureTransformAsync, new RealStrongMemoryCache(6, this, surfaceEdge2)), SetsKt.mainThreadExecutor());
    }

    public void drawBorder(LayoutNodeDrawScope layoutNodeDrawScope, Function0 function0, Function0 function1, final SolidColor solidColor, BrushKt brushKt) {
        Object blurEffectKt$$ExternalSyntheticLambda1;
        final SVGAndroidRenderer sVGAndroidRenderer = (SVGAndroidRenderer) this.applicationContext;
        final BasicTextKt$$ExternalSyntheticLambda0 basicTextKt$$ExternalSyntheticLambda0 = new BasicTextKt$$ExternalSyntheticLambda0(23, this);
        sVGAndroidRenderer.document = function0;
        sVGAndroidRenderer.state = function1;
        if (!solidColor.equals((SolidColor) sVGAndroidRenderer.stateStack) || !Intrinsics.areEqual(brushKt, (BrushKt) sVGAndroidRenderer.parentStack) || ((Function1) sVGAndroidRenderer.matrixStack) == null) {
            sVGAndroidRenderer.stateStack = solidColor;
            sVGAndroidRenderer.parentStack = brushKt;
            if (brushKt instanceof Outline$Generic) {
                final Outline$Generic outline$Generic = (Outline$Generic) brushKt;
                AndroidPath androidPath = outline$Generic.path;
                final Rect bounds = androidPath.getBounds();
                if (((PreviewView.AnonymousClass1) sVGAndroidRenderer.canvas) == null) {
                    sVGAndroidRenderer.canvas = new PreviewView.AnonymousClass1(28, false);
                }
                PreviewView.AnonymousClass1 anonymousClass1 = (PreviewView.AnonymousClass1) sVGAndroidRenderer.canvas;
                AndroidPath androidPathPath = (AndroidPath) anonymousClass1.this$0;
                if (androidPathPath == null) {
                    androidPathPath = AndroidPath_androidKt.Path();
                    anonymousClass1.this$0 = androidPathPath;
                }
                final AndroidPath androidPath2 = androidPathPath;
                androidPath2.reset();
                Modifier.CC.addRect$default(androidPath2, bounds);
                androidPath2.m407opN5in7k0(androidPath2, androidPath, 0);
                final long jCeil = (((long) ((int) Math.ceil(bounds.right - bounds.left))) << 32) | (((long) ((int) Math.ceil(bounds.bottom - bounds.top))) & 4294967295L);
                blurEffectKt$$ExternalSyntheticLambda1 = new Function1() { // from class: androidx.compose.material3.internal.ripple.BorderLogic$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        long j = jCeil;
                        BasicTextKt$$ExternalSyntheticLambda0 basicTextKt$$ExternalSyntheticLambda1 = basicTextKt$$ExternalSyntheticLambda0;
                        final AndroidPath androidPath3 = androidPath2;
                        DrawScope drawScope = (DrawScope) obj;
                        SVGAndroidRenderer sVGAndroidRenderer2 = sVGAndroidRenderer;
                        float f = ((Dp) ((Function0) sVGAndroidRenderer2.document).invoke()).value;
                        float f2 = 2;
                        float fMin = Math.min(Dp.m701equalsimpl0(f, 0.0f) ? 1.0f : (float) Math.ceil(drawScope.mo89toPx0680j_4(f)), (float) Math.ceil((Size.m384getMinDimensionimpl(drawScope.mo472getSizeNHjbRc()) - (((float) Math.ceil(drawScope.mo89toPx0680j_4(((Dp) ((Function0) sVGAndroidRenderer2.state).invoke()).value))) * f2)) / f2));
                        final float f3 = fMin < 0.0f ? 0.0f : fMin;
                        final float fCeil = (float) Math.ceil(drawScope.mo89toPx0680j_4(((Dp) ((Function0) sVGAndroidRenderer2.state).invoke()).value));
                        final Outline$Generic outline$Generic2 = outline$Generic;
                        final SolidColor solidColor2 = solidColor;
                        if (fCeil != 0.0f || f2 * f3 <= Size.m384getMinDimensionimpl(drawScope.mo472getSizeNHjbRc())) {
                            final Rect rect = bounds;
                            float f4 = rect.left;
                            float f5 = rect.top;
                            ((RealDiskCache.RealEditor) drawScope.getDrawContext().rootElement).translate(f4, f5);
                            try {
                                GraphicsLayer graphicsLayer = (GraphicsLayer) basicTextKt$$ExternalSyntheticLambda1.invoke();
                                GraphicsLayerImpl graphicsLayerImpl = graphicsLayer.impl;
                                if (graphicsLayerImpl.mo478getCompositingStrategyke2Ky5w() != 1) {
                                    graphicsLayerImpl.mo482setCompositingStrategyWpw9cng(1);
                                }
                                drawScope.mo473recordJVtK1S4(graphicsLayer, j, new Function1() { // from class: androidx.compose.material3.internal.ripple.BorderLogic$createDrawGenericBorder$lambda$1$0$0$$inlined$drawBorderCache-95KtPRI$1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        SolidColor solidColor3 = solidColor2;
                                        DrawScope drawScope2 = (DrawScope) obj2;
                                        float f6 = fCeil;
                                        Outline$Generic outline$Generic3 = outline$Generic2;
                                        Rect rect2 = rect;
                                        float f7 = -rect2.left;
                                        float f8 = -rect2.top;
                                        ((RealDiskCache.RealEditor) drawScope2.getDrawContext().rootElement).translate(f7, f8);
                                        try {
                                            float f9 = 2;
                                            Modifier.CC.m311drawPathGBMwjPU$default(drawScope2, outline$Generic3.path, solidColor3, 0.0f, new Stroke((f3 + f6) * f9, 0.0f, 0, 0, 30), null, 0, 52);
                                            Modifier.CC.m311drawPathGBMwjPU$default(drawScope2, outline$Generic3.path, solidColor3, 0.0f, new Stroke(f6 * f9, 0.0f, 0, 0, 30), null, 0, 20);
                                            float f10 = 1;
                                            float fIntBitsToFloat = (Float.intBitsToFloat((int) (drawScope2.mo472getSizeNHjbRc() >> 32)) + f10) / Float.intBitsToFloat((int) (drawScope2.mo472getSizeNHjbRc() >> 32));
                                            float fIntBitsToFloat2 = (Float.intBitsToFloat((int) (drawScope2.mo472getSizeNHjbRc() & 4294967295L)) + f10) / Float.intBitsToFloat((int) (drawScope2.mo472getSizeNHjbRc() & 4294967295L));
                                            long jMo471getCenterF1C5BW0 = drawScope2.mo471getCenterF1C5BW0();
                                            SVG drawContext = drawScope2.getDrawContext();
                                            long jM795getSizeNHjbRc = drawContext.m795getSizeNHjbRc();
                                            drawContext.getCanvas().save();
                                            try {
                                                ((RealDiskCache.RealEditor) drawContext.rootElement).m786scale0AR0LA0(fIntBitsToFloat, fIntBitsToFloat2, jMo471getCenterF1C5BW0);
                                                Modifier.CC.m311drawPathGBMwjPU$default(drawScope2, androidPath3, solidColor3, 0.0f, null, null, 0, 28);
                                                drawContext.getCanvas().restore();
                                                drawContext.m797setSizeuvyYCjk(jM795getSizeNHjbRc);
                                                ((RealDiskCache.RealEditor) drawScope2.getDrawContext().rootElement).translate(-f7, -f8);
                                                return Unit.INSTANCE;
                                            } catch (Throwable th) {
                                                drawContext.getCanvas().restore();
                                                drawContext.m797setSizeuvyYCjk(jM795getSizeNHjbRc);
                                                throw th;
                                            }
                                        } catch (Throwable th2) {
                                            ((RealDiskCache.RealEditor) drawScope2.getDrawContext().rootElement).translate(-f7, -f8);
                                            throw th2;
                                        }
                                    }
                                });
                                GraphicsLayerKt.drawLayer(drawScope, graphicsLayer);
                            } finally {
                                ((RealDiskCache.RealEditor) drawScope.getDrawContext().rootElement).translate(-f4, -f5);
                            }
                        } else {
                            Modifier.CC.m311drawPathGBMwjPU$default(drawScope, outline$Generic2.path, solidColor2, 0.0f, null, null, 0, 60);
                        }
                        return Unit.INSTANCE;
                    }
                };
            } else if (brushKt instanceof Outline$Rounded) {
                Outline$Rounded outline$Rounded = (Outline$Rounded) brushKt;
                if (RoundRectKt.isSimple(outline$Rounded.roundRect)) {
                    blurEffectKt$$ExternalSyntheticLambda1 = new LifecycleEffectKt$$ExternalSyntheticLambda1(sVGAndroidRenderer, outline$Rounded, solidColor, 16);
                } else {
                    if (((PreviewView.AnonymousClass1) sVGAndroidRenderer.canvas) == null) {
                        sVGAndroidRenderer.canvas = new PreviewView.AnonymousClass1(28, false);
                    }
                    PreviewView.AnonymousClass1 anonymousClass2 = (PreviewView.AnonymousClass1) sVGAndroidRenderer.canvas;
                    AndroidPath androidPathPath2 = (AndroidPath) anonymousClass2.this$0;
                    if (androidPathPath2 == null) {
                        androidPathPath2 = AndroidPath_androidKt.Path();
                        anonymousClass2.this$0 = androidPathPath2;
                    }
                    Ref$FloatRef ref$FloatRef = new Ref$FloatRef();
                    ref$FloatRef.element = Float.NaN;
                    blurEffectKt$$ExternalSyntheticLambda1 = new BorderLogic$$ExternalSyntheticLambda1(sVGAndroidRenderer, ref$FloatRef, new Ref$ObjectRef(), androidPathPath2, outline$Rounded, solidColor);
                }
            } else {
                if (!(brushKt instanceof Outline$Rectangle)) {
                    throw new HttpException();
                }
                blurEffectKt$$ExternalSyntheticLambda1 = new BlurEffectKt$$ExternalSyntheticLambda1(5, sVGAndroidRenderer, solidColor);
            }
            sVGAndroidRenderer.matrixStack = blurEffectKt$$ExternalSyntheticLambda1;
        }
        ((Function1) sVGAndroidRenderer.matrixStack).invoke(layoutNodeDrawScope);
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object execute() {
        DefaultScheduler defaultScheduler = (DefaultScheduler) this.applicationContext;
        AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) this.defaults;
        AutoValue_EventInternal autoValue_EventInternal = (AutoValue_EventInternal) this.options;
        SQLiteEventStore sQLiteEventStore = (SQLiteEventStore) defaultScheduler.eventStore;
        sQLiteEventStore.getClass();
        Priority priority = autoValue_TransportContext.priority;
        String str = autoValue_EventInternal.transportName;
        String str2 = autoValue_TransportContext.backendName;
        Log.d("TransportRuntime.".concat("SQLiteEventStore"), "Storing event with priority=" + priority + ", name=" + str + " for destination " + str2);
        ((Long) sQLiteEventStore.inTransaction(new RealNetworkObserver(sQLiteEventStore, autoValue_TransportContext, autoValue_EventInternal, 16, false))).getClass();
        defaultScheduler.workScheduler.schedule(autoValue_TransportContext, 1, false);
        return null;
    }

    public Object get() {
        long jCurrentThreadId = Thread_jvmKt.currentThreadId();
        if (jCurrentThreadId == Thread_androidKt.MainThreadId) {
            return this.options;
        }
        ThreadMap threadMap = (ThreadMap) ((AtomicReference) this.applicationContext).get();
        int iFind = threadMap.find(jCurrentThreadId);
        if (iFind >= 0) {
            return threadMap.values[iFind];
        }
        return null;
    }

    public ColorStateList getColorStateList(int i) {
        int resourceId;
        ColorStateList colorStateList;
        TypedArray typedArray = (TypedArray) this.defaults;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (colorStateList = IconHelper.getColorStateList((Context) this.applicationContext, resourceId)) == null) ? typedArray.getColorStateList(i) : colorStateList;
    }

    @Override // androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatImpl
    public Uri getContentUri() {
        return (Uri) this.applicationContext;
    }

    @Override // androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatImpl
    public ClipDescription getDescription() {
        return (ClipDescription) this.defaults;
    }

    public Drawable getDrawable(int i) {
        int resourceId;
        TypedArray typedArray = (TypedArray) this.defaults;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) ? typedArray.getDrawable(i) : IconHelper.getDrawable((Context) this.applicationContext, resourceId);
    }

    public Drawable getDrawableIfKnown(int i) {
        int resourceId;
        Drawable drawable;
        if (!((TypedArray) this.defaults).hasValue(i) || (resourceId = ((TypedArray) this.defaults).getResourceId(i, 0)) == 0) {
            return null;
        }
        AppCompatDrawableManager appCompatDrawableManager = AppCompatDrawableManager.get();
        Context context = (Context) this.applicationContext;
        synchronized (appCompatDrawableManager) {
            drawable = appCompatDrawableManager.mResourceManager.getDrawable(context, resourceId, true);
        }
        return drawable;
    }

    public Typeface getFont(int i, int i2, AppCompatTextHelper.AnonymousClass1 anonymousClass1) {
        int resourceId = ((TypedArray) this.defaults).getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (((TypedValue) this.options) == null) {
            this.options = new TypedValue();
        }
        Context context = (Context) this.applicationContext;
        TypedValue typedValue = (TypedValue) this.options;
        ThreadLocal threadLocal = ResourcesCompat.sTempTypedValue;
        if (context.isRestricted()) {
            return null;
        }
        return ResourcesCompat.loadFont(context, resourceId, typedValue, i2, anonymousClass1, true, false);
    }

    @Override // androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatImpl
    public Object getInputContentInfo() {
        return null;
    }

    @Override // androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatImpl
    public Uri getLinkUri() {
        return (Uri) this.options;
    }

    public int getSize(Version version) {
        ArrayList arrayList = (ArrayList) this.applicationContext;
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            MinimalEncoder$ResultList$ResultNode minimalEncoder$ResultList$ResultNode = (MinimalEncoder$ResultList$ResultNode) obj;
            int i3 = minimalEncoder$ResultList$ResultNode.characterLength;
            Mode mode = minimalEncoder$ResultList$ResultNode.mode;
            int characterCountBits = mode.getCharacterCountBits(version);
            int characterCountIndicator = characterCountBits + 4;
            int iOrdinal = mode.ordinal();
            int i4 = 4;
            if (iOrdinal != 1) {
                if (iOrdinal == 2) {
                    characterCountIndicator = ((i3 / 2) * 11) + characterCountIndicator + (i3 % 2 != 1 ? 0 : 6);
                } else if (iOrdinal == 4) {
                    characterCountIndicator += minimalEncoder$ResultList$ResultNode.getCharacterCountIndicator() * 8;
                } else if (iOrdinal == 5) {
                    characterCountIndicator = characterCountBits + 12;
                } else if (iOrdinal == 6) {
                    characterCountIndicator += i3 * 13;
                }
            } else {
                int i5 = ((i3 / 3) * 10) + characterCountIndicator;
                int i6 = i3 % 3;
                if (i6 != 1) {
                    i4 = i6 == 2 ? 7 : 0;
                }
                characterCountIndicator = i5 + i4;
            }
            i += characterCountIndicator;
        }
        return i;
    }

    public ArrayList getTagsForWorkSpecId(String str) {
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.applicationContext;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?", 1);
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

    public TransportImpl getTransport(Encoding encoding, Transformer transformer) {
        Set set = (Set) this.applicationContext;
        if (set.contains(encoding)) {
            return new TransportImpl((AutoValue_TransportContext) this.defaults, encoding, transformer, (TransportRuntime) this.options);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", encoding, set));
    }

    public void insertTags(String str, Set set) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            WorkTag workTag = new WorkTag((String) it.next(), str);
            WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.applicationContext;
            workDatabase_Impl.assertNotSuspendingTransaction();
            workDatabase_Impl.beginTransaction();
            try {
                ((WorkTagDao_Impl$1) this.defaults).insert(workTag);
                workDatabase_Impl.setTransactionSuccessful();
                workDatabase_Impl.internalEndTransaction();
            } catch (Throwable th) {
                workDatabase_Impl.internalEndTransaction();
                throw th;
            }
        }
    }

    @Override // androidx.camera.core.impl.utils.futures.FutureCallback
    public void onFailure(Throwable th) {
        CallbackToFutureAdapter.Completer completer = (CallbackToFutureAdapter.Completer) this.defaults;
        if (th instanceof CancellationException) {
            Preconditions.checkState(null, completer.setException(new SurfaceRequest.RequestCancelledException(ImageAnalysis$$ExternalSyntheticLambda1.m(new StringBuilder(), (String) this.options, " cancelled."), th)));
        } else {
            completer.set(null);
        }
    }

    @Override // androidx.camera.core.impl.utils.futures.FutureCallback
    public void onSuccess(Object obj) {
        Futures.propagateTransform(true, (ListenableFuture) this.applicationContext, (CallbackToFutureAdapter.Completer) this.defaults, SetsKt.directExecutor());
    }

    public void postDispatchRunnable(Lifecycle.Event event) {
        NanoHTTPD.ServerRunnable serverRunnable = (NanoHTTPD.ServerRunnable) this.options;
        if (serverRunnable != null) {
            serverRunnable.run();
        }
        NanoHTTPD.ServerRunnable serverRunnable2 = new NanoHTTPD.ServerRunnable((LifecycleRegistry) this.applicationContext, event);
        this.options = serverRunnable2;
        ((Handler) this.defaults).postAtFrontOfQueue(serverRunnable2);
    }

    public void recycle() {
        ((TypedArray) this.defaults).recycle();
    }

    @Override // com.google.firebase.encoders.config.EncoderConfig
    public /* bridge */ /* synthetic */ EncoderConfig registerEncoder(Class cls, ObjectEncoder objectEncoder) {
        ((HashMap) this.applicationContext).put(cls, objectEncoder);
        ((HashMap) this.defaults).remove(cls);
        return this;
    }

    public void set(Object obj) {
        long jCurrentThreadId = Thread_jvmKt.currentThreadId();
        if (jCurrentThreadId == Thread_androidKt.MainThreadId) {
            this.options = obj;
            return;
        }
        synchronized (this.defaults) {
            ThreadMap threadMap = (ThreadMap) ((AtomicReference) this.applicationContext).get();
            int iFind = threadMap.find(jCurrentThreadId);
            if (iFind >= 0) {
                threadMap.values[iFind] = obj;
            } else {
                ((AtomicReference) this.applicationContext).set(threadMap.newWith(jCurrentThreadId, obj));
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 18:
                StringBuilder sb = new StringBuilder();
                ArrayList arrayList = (ArrayList) this.applicationContext;
                int size = arrayList.size();
                MinimalEncoder$ResultList$ResultNode minimalEncoder$ResultList$ResultNode = null;
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    MinimalEncoder$ResultList$ResultNode minimalEncoder$ResultList$ResultNode2 = (MinimalEncoder$ResultList$ResultNode) obj;
                    if (minimalEncoder$ResultList$ResultNode != null) {
                        sb.append(",");
                    }
                    sb.append(minimalEncoder$ResultList$ResultNode2.toString());
                    minimalEncoder$ResultList$ResultNode = minimalEncoder$ResultList$ResultNode2;
                }
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public ImageLoader$Builder(LifecycleService lifecycleService) {
        this.$r8$classId = 12;
        this.applicationContext = new LifecycleRegistry(lifecycleService, true);
        this.defaults = new Handler();
    }

    public ImageLoader$Builder(WorkDatabase_Impl workDatabase_Impl) {
        this.$r8$classId = 1;
        this.applicationContext = workDatabase_Impl;
        int i = 0;
        this.defaults = new WorkTagDao_Impl$1(workDatabase_Impl, i);
        this.options = new WorkTagDao_Impl$2(workDatabase_Impl, i);
    }

    public ImageLoader$Builder(int i) {
        this.$r8$classId = i;
        switch (i) {
            case 8:
                break;
            case 10:
                this.applicationContext = new WeakHashMap();
                this.defaults = new WeakHashMap();
                this.options = new WeakHashMap();
                break;
            case 17:
                this.applicationContext = new HashMap();
                this.defaults = new HashMap();
                this.options = zzaj.zza$1;
                break;
            default:
                this.applicationContext = new AtomicReference(Thread_jvmKt.emptyThreadMap);
                this.defaults = new Object();
                break;
        }
    }

    public ImageLoader$Builder(View view) {
        this.$r8$classId = 9;
        this.applicationContext = view;
        this.defaults = LazyKt__LazyJVMKt.lazy(3, new Handshake.AnonymousClass2(14, this));
        this.options = new RealDiskCache.RealEditor(view);
    }

    public ImageLoader$Builder(Context context, TypedArray typedArray) {
        this.$r8$classId = 2;
        this.applicationContext = context;
        this.defaults = typedArray;
    }

    @Override // androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatImpl
    public void requestPermission() {
    }

    public ImageLoader$Builder(CameraInternal cameraInternal, DefaultSurfaceProcessor defaultSurfaceProcessor) {
        this.$r8$classId = 4;
        this.defaults = cameraInternal;
        this.applicationContext = defaultSurfaceProcessor;
    }

    public ImageLoader$Builder(Context context) {
        this.$r8$classId = 0;
        this.applicationContext = context.getApplicationContext();
        this.defaults = Requests.DEFAULT_REQUEST_OPTIONS;
        this.options = new SingletonDiskCache();
    }

    public ImageLoader$Builder(AndroidRippleNode androidRippleNode) {
        this.$r8$classId = 6;
        this.options = androidRippleNode;
        this.applicationContext = new SVGAndroidRenderer();
    }

    public ImageLoader$Builder(MinimalEncoder minimalEncoder, Version version, MinimalEncoder.Edge edge) {
        Mode mode;
        int i;
        int i2;
        this.$r8$classId = 18;
        this.options = minimalEncoder;
        this.applicationContext = new ArrayList();
        MinimalEncoder.Edge edge2 = edge;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            mode = Mode.ECI;
            i = 1;
            if (edge2 == null) {
                break;
            }
            int i5 = edge2.charsetEncoderIndex;
            int i6 = i3 + edge2.characterLength;
            MinimalEncoder.Edge edge3 = edge2.previous;
            int i7 = i4;
            Mode mode2 = edge2.mode;
            boolean z = (mode2 == Mode.BYTE && edge3 == null && i5 != 0) || !(edge3 == null || i5 == edge3.charsetEncoderIndex);
            i = z ? 1 : i7;
            if (edge3 == null || edge3.mode != mode2 || z) {
                ((ArrayList) this.applicationContext).add(0, new MinimalEncoder$ResultList$ResultNode(this, mode2, edge2.fromPosition, i5, i6));
                i2 = 0;
            } else {
                i2 = i6;
            }
            if (z) {
                ((ArrayList) this.applicationContext).add(0, new MinimalEncoder$ResultList$ResultNode(this, mode, edge2.fromPosition, edge2.charsetEncoderIndex, 0));
            }
            i4 = i;
            edge2 = edge3;
            i3 = i2;
        }
        int i8 = i4;
        boolean z2 = minimalEncoder.isGS1;
        int i9 = minimalEncoder.ecLevel;
        if (z2) {
            MinimalEncoder$ResultList$ResultNode minimalEncoder$ResultList$ResultNode = (MinimalEncoder$ResultList$ResultNode) ((ArrayList) this.applicationContext).get(0);
            if (minimalEncoder$ResultList$ResultNode != null && minimalEncoder$ResultList$ResultNode.mode != mode && i8 != 0) {
                ((ArrayList) this.applicationContext).add(0, new MinimalEncoder$ResultList$ResultNode(this, mode, 0, 0, 0));
            }
            ((ArrayList) this.applicationContext).add(((MinimalEncoder$ResultList$ResultNode) ((ArrayList) this.applicationContext).get(0)).mode == mode ? 1 : 0, new MinimalEncoder$ResultList$ResultNode(this, Mode.FNC1_FIRST_POSITION, 0, 0, 0));
        }
        int i10 = version.versionNumber;
        int i11 = 26;
        int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i10 <= 9 ? 1 : i10 <= 26 ? 2 : 3);
        if (iOrdinal == 0) {
            i11 = 9;
        } else if (iOrdinal != 1) {
            i = 27;
            i11 = 40;
        } else {
            i = 10;
        }
        int size = getSize(version);
        while (i10 < i11 && !Encoder.willFit(size, Version.getVersionForNumber(i10), i9)) {
            i10++;
        }
        while (i10 > i && Encoder.willFit(size, Version.getVersionForNumber(i10 - 1), i9)) {
            i10--;
        }
        this.defaults = Version.getVersionForNumber(i10);
    }
}
