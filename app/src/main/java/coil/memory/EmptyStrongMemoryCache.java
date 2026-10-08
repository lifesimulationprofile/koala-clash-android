package coil.memory;

import android.R;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ContentProviderClient;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.view.ContentInfo;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.camera.core.impl.CameraProviderExecutionState;
import androidx.camera.core.impl.utils.MatrixExt;
import androidx.collection.LongSparseArray;
import androidx.collection.MutableLongList;
import androidx.collection.internal.RuntimeHelpersKt;
import androidx.compose.foundation.style.InteractionSet;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputChangeEventProducer$PointerInputData;
import androidx.compose.ui.input.pointer.PointerInputEventData;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.SortedSet;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.text.android.CanvasCompatS$$ExternalSyntheticApiModelOutline0;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.provider.FontProvider;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatApi25Impl;
import androidx.emoji2.text.EmojiCompat;
import androidx.navigation.NavDestinationBuilder;
import androidx.profileinstaller.ProfileInstallReceiver;
import androidx.profileinstaller.ProfileInstaller$DiagnosticsCallback;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.ViewBoundsCheck$Callback;
import androidx.work.CoroutineWorker$$ExternalSyntheticLambda0;
import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.constraints.WorkConstraintsTracker$areAllConstraintsMet$1;
import androidx.work.impl.constraints.WorkConstraintsTrackerKt;
import androidx.work.impl.constraints.controllers.BatteryNotLowController;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.constraints.controllers.NetworkMeteredController;
import androidx.work.impl.constraints.controllers.NetworkNotRoamingController;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import coil.ImageLoader$Builder;
import coil.RealImageLoader$executeMain$1;
import coil.compose.AsyncImagePainter;
import coil.compose.ConstraintsSizeResolver$size$$inlined$mapNotNull$1;
import coil.disk.RealDiskCache;
import coil.request.RequestService;
import coil.size.SizeResolver;
import coil.util.Bitmaps;
import com.caverock.androidsvg.SVG;
import com.github.kr328.clash.core.bridge.LogcatInterface;
import com.github.kr328.clash.core.model.LogMessage;
import com.google.android.datatransport.cct.CctTransportBackend;
import com.google.android.datatransport.cct.internal.AutoValue_BatchedLogRequest;
import com.google.android.datatransport.cct.internal.AutoValue_LogResponse;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.service.zai;
import com.google.android.gms.common.internal.service.zap;
import com.google.android.gms.common.moduleinstall.internal.ApiFeatureRequest;
import com.google.android.gms.common.moduleinstall.internal.zaf;
import com.google.android.gms.common.moduleinstall.internal.zar;
import com.google.android.gms.common.moduleinstall.internal.zay;
import com.google.android.gms.common.moduleinstall.internal.zaz;
import com.google.android.gms.internal.base.zac;
import com.google.android.gms.internal.mlkit_vision_common.zzaw;
import com.google.android.gms.internal.mlkit_vision_common.zzle;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.zzw;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import com.google.firebase.encoders.json.JsonValueObjectEncoderContext;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.inject.Provider;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.serialization.json.Json;
import okhttp3.ConnectionPool;
import okio.ByteString;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public class EmptyStrongMemoryCache implements OnApplyWindowInsetsListener, FontProvider.ContentQueryWrapper, ContentInfoCompat.BuilderCompat, ProfileInstaller$DiagnosticsCallback, ViewBoundsCheck$Callback, SizeResolver, StrongMemoryCache, LogcatInterface, Factory, SynchronizationGuard.CriticalSection, RemoteCall {
    public final /* synthetic */ int $r8$classId;
    public Object weakMemoryCache;

    public EmptyStrongMemoryCache(int i) {
        this.$r8$classId = i;
        switch (i) {
            case 4:
                this.weakMemoryCache = new LongSparseArray((Object) null);
                break;
            case 5:
                this.weakMemoryCache = new SortedSet(HitTestResultKt.DepthComparator);
                break;
            case 6:
                this.weakMemoryCache = Stack.mutableStateOf$default(Boolean.FALSE);
                break;
            case 29:
                this.weakMemoryCache = new ConnectionPool(11);
                break;
        }
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public void accept(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 27:
                TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
                zai zaiVar = (zai) ((zap) obj).getService();
                TelemetryData telemetryData = (TelemetryData) this.weakMemoryCache;
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.writeInterfaceToken(zaiVar.zab);
                zac.zac(parcelObtain, telemetryData);
                try {
                    zaiVar.zaa.transact(1, parcelObtain, null, 1);
                    parcelObtain.recycle();
                    taskCompletionSource.zza.zzb(null);
                    return;
                } catch (Throwable th) {
                    parcelObtain.recycle();
                    throw th;
                }
            default:
                zar zarVar = new zar((TaskCompletionSource) obj2, 1);
                zaf zafVar = (zaf) ((zaz) obj).getService();
                ApiFeatureRequest apiFeatureRequest = (ApiFeatureRequest) this.weakMemoryCache;
                Parcel parcelObtain2 = Parcel.obtain();
                parcelObtain2.writeInterfaceToken(zafVar.zab);
                int i = zac.$r8$clinit;
                parcelObtain2.writeStrongBinder(zarVar);
                zac.zac(parcelObtain2, apiFeatureRequest);
                parcelObtain2.writeStrongBinder(null);
                zafVar.zac(parcelObtain2, 2);
                return;
        }
    }

    public void add(LayoutNode layoutNode) {
        if (!layoutNode.isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("DepthSortedSet.add called on an unattached node");
        }
        ((SortedSet) this.weakMemoryCache).add(layoutNode);
    }

    public CameraProviderExecutionState apply(SVG svg) throws IOException {
        CctTransportBackend cctTransportBackend = (CctTransportBackend) this.weakMemoryCache;
        URL url = (URL) svg.rootElement;
        zzle.d("CctTransportBackend", "Making request to: %s", url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(cctTransportBackend.readTimeout);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("User-Agent", "datatransport/2.3.3 android/");
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = (String) svg.idToElementMap;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    ConnectionPool connectionPool = cctTransportBackend.dataEncoder;
                    AutoValue_BatchedLogRequest autoValue_BatchedLogRequest = (AutoValue_BatchedLogRequest) svg.cssRules;
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(gZIPOutputStream));
                    JsonDataEncoderBuilder jsonDataEncoderBuilder = (JsonDataEncoderBuilder) connectionPool.delegate;
                    JsonValueObjectEncoderContext jsonValueObjectEncoderContext = new JsonValueObjectEncoderContext(bufferedWriter, jsonDataEncoderBuilder.objectEncoders, jsonDataEncoderBuilder.valueEncoders, jsonDataEncoderBuilder.fallbackEncoder, jsonDataEncoderBuilder.ignoreNullValues);
                    jsonValueObjectEncoderContext.add(autoValue_BatchedLogRequest);
                    jsonValueObjectEncoderContext.maybeUnNest();
                    jsonValueObjectEncoderContext.jsonWriter.flush();
                    gZIPOutputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    Log.i("TransportRuntime.".concat("CctTransportBackend"), ImageAnalysis$$ExternalSyntheticLambda1.m("Status Code: ", responseCode));
                    Log.i("TransportRuntime.".concat("CctTransportBackend"), "Content-Type: " + httpURLConnection.getHeaderField("Content-Type"));
                    Log.i("TransportRuntime.".concat("CctTransportBackend"), "Content-Encoding: " + httpURLConnection.getHeaderField("Content-Encoding"));
                    if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                        return new CameraProviderExecutionState(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0L);
                    }
                    if (responseCode != 200) {
                        return new CameraProviderExecutionState(responseCode, null, 0L);
                    }
                    InputStream inputStream = httpURLConnection.getInputStream();
                    try {
                        InputStream gZIPInputStream = "gzip".equals(httpURLConnection.getHeaderField("Content-Encoding")) ? new GZIPInputStream(inputStream) : inputStream;
                        try {
                            CameraProviderExecutionState cameraProviderExecutionState = new CameraProviderExecutionState(responseCode, null, AutoValue_LogResponse.fromJson(new BufferedReader(new InputStreamReader(gZIPInputStream))).nextRequestWaitMillis);
                            if (gZIPInputStream != null) {
                                gZIPInputStream.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return cameraProviderExecutionState;
                        } catch (Throwable th) {
                            if (gZIPInputStream != null) {
                                try {
                                    gZIPInputStream.close();
                                } catch (Throwable unused) {
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable unused2) {
                            }
                        }
                        throw th2;
                    }
                } catch (Throwable th3) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Throwable unused3) {
                    }
                    throw th3;
                }
            } catch (Throwable th4) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable unused4) {
                    }
                }
                throw th4;
            }
        } catch (EncodingException e) {
            e = e;
            Log.e("TransportRuntime.".concat("CctTransportBackend"), "Couldn't encode request, returning with 400", e);
            return new CameraProviderExecutionState(400, null, 0L);
        } catch (ConnectException e2) {
            e = e2;
            Log.e("TransportRuntime.".concat("CctTransportBackend"), "Couldn't open connection, returning with 500", e);
            return new CameraProviderExecutionState(500, null, 0L);
        } catch (UnknownHostException e3) {
            e = e3;
            Log.e("TransportRuntime.".concat("CctTransportBackend"), "Couldn't open connection, returning with 500", e);
            return new CameraProviderExecutionState(500, null, 0L);
        } catch (IOException e4) {
            e = e4;
            Log.e("TransportRuntime.".concat("CctTransportBackend"), "Couldn't encode request, returning with 400", e);
            return new CameraProviderExecutionState(400, null, 0L);
        }
    }

    public boolean areAllConstraintsMet(WorkSpec workSpec) {
        List list = (List) this.weakMemoryCache;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            ConstraintController constraintController = (ConstraintController) obj;
            if (constraintController.hasConstraint(workSpec) && constraintController.isConstrained(constraintController.tracker.readSystemState())) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            Logger$LogcatLogger.get().debug(WorkConstraintsTrackerKt.TAG, "Work " + workSpec.id + " constrained by " + CollectionsKt.joinToString$default(arrayList, null, null, null, WorkConstraintsTracker$areAllConstraintsMet$1.INSTANCE, 31));
        }
        return arrayList.isEmpty();
    }

    @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
    public ContentInfoCompat build() {
        return new ContentInfoCompat(new RealDiskCache.RealEditor(((ContentInfo.Builder) this.weakMemoryCache).build()));
    }

    public void cancel() {
        ((zzw) ((ConnectionPool) this.weakMemoryCache).delegate).zze(null);
    }

    @Override // androidx.core.provider.FontProvider.ContentQueryWrapper
    public void close() {
        ContentProviderClient contentProviderClient = (ContentProviderClient) this.weakMemoryCache;
        if (contentProviderClient != null) {
            contentProviderClient.release();
        }
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object execute() {
        SQLiteEventStore sQLiteEventStore = (SQLiteEventStore) ((EventStore) this.weakMemoryCache);
        long time = sQLiteEventStore.wallClock.getTime() - sQLiteEventStore.config.eventCleanUpAge;
        SQLiteDatabase db = sQLiteEventStore.getDb();
        db.beginTransaction();
        try {
            int iDelete = db.delete("events", "timestamp_ms < ?", new String[]{String.valueOf(time)});
            db.setTransactionSuccessful();
            return Integer.valueOf(iDelete);
        } finally {
            db.endTransaction();
        }
    }

    @Override // coil.memory.StrongMemoryCache
    public MemoryCache$Value get(MemoryCache$Key memoryCache$Key) {
        return null;
    }

    @Override // androidx.recyclerview.widget.ViewBoundsCheck$Callback
    public View getChildAt(int i) {
        return ((RecyclerView.LayoutManager) this.weakMemoryCache).getChildAt(i);
    }

    @Override // androidx.recyclerview.widget.ViewBoundsCheck$Callback
    public int getChildEnd(View view) {
        return view.getRight() + ((RecyclerView.LayoutParams) view.getLayoutParams()).mDecorInsets.right + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).rightMargin;
    }

    @Override // androidx.recyclerview.widget.ViewBoundsCheck$Callback
    public int getChildStart(View view) {
        return (view.getLeft() - ((RecyclerView.LayoutParams) view.getLayoutParams()).mDecorInsets.left) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).leftMargin;
    }

    @Override // androidx.recyclerview.widget.ViewBoundsCheck$Callback
    public int getParentEnd() {
        RecyclerView.LayoutManager layoutManager = (RecyclerView.LayoutManager) this.weakMemoryCache;
        return layoutManager.mWidth - layoutManager.getPaddingRight();
    }

    @Override // androidx.recyclerview.widget.ViewBoundsCheck$Callback
    public int getParentStart() {
        return ((RecyclerView.LayoutManager) this.weakMemoryCache).getPaddingLeft();
    }

    public void hide() {
        View view = (View) this.weakMemoryCache;
        if (view != null) {
            ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat.Impl impl = windowInsetsCompat.mImpl;
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.weakMemoryCache;
        if (!Objects.equals(coordinatorLayout.mLastInsets, windowInsetsCompat)) {
            coordinatorLayout.mLastInsets = windowInsetsCompat;
            boolean z = windowInsetsCompat.getSystemWindowInsetTop() > 0;
            coordinatorLayout.mDrawStatusBarBackground = z;
            coordinatorLayout.setWillNotDraw(!z && coordinatorLayout.getBackground() == null);
            if (!impl.isConsumed()) {
                int childCount = coordinatorLayout.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = coordinatorLayout.getChildAt(i);
                    WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                    if (childAt.getFitsSystemWindows() && ((CoordinatorLayout.LayoutParams) childAt.getLayoutParams()).mBehavior != null && impl.isConsumed()) {
                        break;
                    }
                }
            }
            coordinatorLayout.requestLayout();
        }
        return windowInsetsCompat;
    }

    @Override // androidx.profileinstaller.ProfileInstaller$DiagnosticsCallback
    public void onDiagnosticReceived() {
        Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
    }

    @Override // androidx.profileinstaller.ProfileInstaller$DiagnosticsCallback
    public void onResultReceived(int i, Object obj) {
        String str;
        switch (i) {
            case 1:
                str = "RESULT_INSTALL_SUCCESS";
                break;
            case 2:
                str = "RESULT_ALREADY_INSTALLED";
                break;
            case 3:
                str = "RESULT_UNSUPPORTED_ART_VERSION";
                break;
            case 4:
                str = "RESULT_NOT_WRITABLE";
                break;
            case 5:
                str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                break;
            case 6:
                str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                break;
            case 7:
                str = "RESULT_IO_EXCEPTION";
                break;
            case 8:
                str = "RESULT_PARSE_EXCEPTION";
                break;
            case 9:
            default:
                str = "";
                break;
            case 10:
                str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                break;
            case 11:
                str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                break;
        }
        if (i == 6 || i == 7 || i == 8) {
            Log.e("ProfileInstaller", str, (Throwable) obj);
        } else {
            Log.d("ProfileInstaller", str);
        }
        ((ProfileInstallReceiver) this.weakMemoryCache).setResultCode(i);
    }

    public RealStrongMemoryCache produce(RequestService requestService, AndroidComposeView androidComposeView) {
        long jM591screenToLocalMKHz9U;
        long j;
        boolean z;
        LongSparseArray longSparseArray = (LongSparseArray) this.weakMemoryCache;
        List list = (List) requestService.systemCallbacks;
        LongSparseArray longSparseArray2 = new LongSparseArray(list.size());
        int size = list.size();
        int i = 0;
        while (i < size) {
            PointerInputEventData pointerInputEventData = (PointerInputEventData) list.get(i);
            long j2 = pointerInputEventData.id;
            PointerInputChangeEventProducer$PointerInputData pointerInputChangeEventProducer$PointerInputData = (PointerInputChangeEventProducer$PointerInputData) longSparseArray.get(j2);
            if (pointerInputChangeEventProducer$PointerInputData == null) {
                j = pointerInputEventData.uptime;
                jM591screenToLocalMKHz9U = pointerInputEventData.position;
                z = false;
            } else {
                long j3 = pointerInputChangeEventProducer$PointerInputData.uptime;
                boolean z2 = pointerInputChangeEventProducer$PointerInputData.down;
                jM591screenToLocalMKHz9U = androidComposeView.m591screenToLocalMKHz9U(pointerInputChangeEventProducer$PointerInputData.positionOnScreen);
                j = j3;
                z = z2;
            }
            long j4 = pointerInputEventData.id;
            List list2 = list;
            int i2 = size;
            longSparseArray2.put(j4, new PointerInputChange(j4, pointerInputEventData.uptime, pointerInputEventData.position, pointerInputEventData.down, pointerInputEventData.pressure, j, jM591screenToLocalMKHz9U, z, pointerInputEventData.type, pointerInputEventData.historical, pointerInputEventData.scrollDelta, pointerInputEventData.scaleGestureFactor, pointerInputEventData.panGestureOffset, pointerInputEventData.originalEventPosition));
            boolean z3 = pointerInputEventData.down;
            if (z3) {
                longSparseArray.put(j2, new PointerInputChangeEventProducer$PointerInputData(pointerInputEventData.uptime, pointerInputEventData.positionOnScreen, z3));
            } else {
                longSparseArray.remove(j2);
            }
            i++;
            list = list2;
            size = i2;
        }
        return new RealStrongMemoryCache(10, longSparseArray2, requestService, false);
    }

    @Override // androidx.core.provider.FontProvider.ContentQueryWrapper
    public Cursor query(Uri uri, String[] strArr, String[] strArr2) {
        ContentProviderClient contentProviderClient = (ContentProviderClient) this.weakMemoryCache;
        if (contentProviderClient == null) {
            return null;
        }
        try {
            return contentProviderClient.query(uri, strArr, "query = ?", strArr2, null, null);
        } catch (RemoteException e) {
            Log.w("FontsProvider", "Unable to query the content provider", e);
            return null;
        }
    }

    @Override // com.github.kr328.clash.core.bridge.LogcatInterface
    public void received(String str) {
        ((BufferedChannel) this.weakMemoryCache).mo851trySendJP2dKIU(Json.Default.decodeFromString(str, LogMessage.Companion.serializer()));
    }

    public boolean remove(LayoutNode layoutNode) {
        if (!layoutNode.isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("DepthSortedSet.remove called on an unattached node");
        }
        return ((SortedSet) this.weakMemoryCache).remove(layoutNode);
    }

    @Override // coil.memory.StrongMemoryCache
    public void set(MemoryCache$Key memoryCache$Key, Bitmap bitmap, Map map) {
        ((RealWeakMemoryCache) this.weakMemoryCache).set(memoryCache$Key, bitmap, map, Bitmaps.getAllocationByteCountCompat(bitmap));
    }

    @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
    public void setExtras(Bundle bundle) {
        ((ContentInfo.Builder) this.weakMemoryCache).setExtras(bundle);
    }

    @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
    public void setFlags(int i) {
        ((ContentInfo.Builder) this.weakMemoryCache).setFlags(i);
    }

    @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
    public void setLinkUri(Uri uri) {
        ((ContentInfo.Builder) this.weakMemoryCache).setLinkUri(uri);
    }

    public void show() {
        View viewFindViewById;
        View view = (View) this.weakMemoryCache;
        if (view == null) {
            return;
        }
        if (view.isInEditMode() || view.onCheckIsTextEditor()) {
            view.requestFocus();
            viewFindViewById = view;
        } else {
            viewFindViewById = view.getRootView().findFocus();
        }
        if (viewFindViewById == null) {
            viewFindViewById = view.getRootView().findViewById(R.id.content);
        }
        if (viewFindViewById == null || !viewFindViewById.hasWindowFocus()) {
            return;
        }
        viewFindViewById.post(new CoroutineWorker$$ExternalSyntheticLambda0(2, viewFindViewById));
    }

    @Override // coil.size.SizeResolver
    public Object size(RealImageLoader$executeMain$1 realImageLoader$executeMain$1) {
        return FlowKt.first(new ConstraintsSizeResolver$size$$inlined$mapNotNull$1(((AsyncImagePainter) this.weakMemoryCache).drawSize, 1), realImageLoader$executeMain$1);
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 5:
                return ((SortedSet) this.weakMemoryCache).toString();
            default:
                return super.toString();
        }
    }

    @Override // javax.inject.Provider
    public Object get() {
        switch (this.$r8$classId) {
            case 24:
                int i = 15;
                return new SVG((Context) ((InteractionSet) this.weakMemoryCache).setOrValue, new Path.Companion(16), new ByteString.Companion(i), i);
            default:
                Context context = (Context) ((Provider) this.weakMemoryCache).get();
                List list = SchemaManager.INCREMENTAL_MIGRATIONS;
                return new SchemaManager(4, context, "com.google.android.datatransport.events");
        }
    }

    public /* synthetic */ EmptyStrongMemoryCache(int i, Object obj) {
        this.$r8$classId = i;
        this.weakMemoryCache = obj;
    }

    public /* synthetic */ EmptyStrongMemoryCache(zay zayVar, ApiFeatureRequest apiFeatureRequest) {
        this.$r8$classId = 28;
        this.weakMemoryCache = apiFeatureRequest;
    }

    public EmptyStrongMemoryCache(Trackers trackers) {
        this.$r8$classId = 17;
        BatteryNotLowController batteryNotLowController = new BatteryNotLowController(trackers.batteryChargingTracker, 1);
        BatteryNotLowController batteryNotLowController2 = new BatteryNotLowController(trackers.batteryNotLowTracker, 0);
        BatteryNotLowController batteryNotLowController3 = new BatteryNotLowController(trackers.storageNotLowTracker, 4);
        NavDestinationBuilder navDestinationBuilder = trackers.networkStateTracker;
        this.weakMemoryCache = MatrixExt.listOf(batteryNotLowController, batteryNotLowController2, batteryNotLowController3, new BatteryNotLowController(navDestinationBuilder, 2), new BatteryNotLowController(navDestinationBuilder, 3), new NetworkNotRoamingController(navDestinationBuilder), new NetworkMeteredController(navDestinationBuilder));
    }

    public EmptyStrongMemoryCache(final TextView textView) {
        this.$r8$classId = 14;
        this.weakMemoryCache = new zzaw(textView) { // from class: androidx.emoji2.viewsintegration.EmojiTextViewHelper$SkippingHelper19
            public final EmojiTextViewHelper$HelperInternal19 mHelperDelegate;

            {
                this.mHelperDelegate = new EmojiTextViewHelper$HelperInternal19(textView);
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzaw
            public final InputFilter[] getFilters(InputFilter[] inputFilterArr) {
                return !EmojiCompat.isConfigured() ? inputFilterArr : this.mHelperDelegate.getFilters(inputFilterArr);
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzaw
            public final boolean isEnabled() {
                return this.mHelperDelegate.mEnabled;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzaw
            public final void setAllCaps(boolean z) {
                if (EmojiCompat.isConfigured()) {
                    this.mHelperDelegate.setAllCaps(z);
                }
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzaw
            public final void setEnabled(boolean z) {
                boolean zIsConfigured = EmojiCompat.isConfigured();
                EmojiTextViewHelper$HelperInternal19 emojiTextViewHelper$HelperInternal19 = this.mHelperDelegate;
                if (zIsConfigured) {
                    emojiTextViewHelper$HelperInternal19.setEnabled(z);
                } else {
                    emojiTextViewHelper$HelperInternal19.mEnabled = z;
                }
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzaw
            public final TransformationMethod wrapTransformationMethod(TransformationMethod transformationMethod) {
                return !EmojiCompat.isConfigured() ? transformationMethod : this.mHelperDelegate.wrapTransformationMethod(transformationMethod);
            }
        };
    }

    public EmptyStrongMemoryCache(long[] jArr) {
        MutableLongList mutableLongList;
        this.$r8$classId = 1;
        if (jArr != null) {
            long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
            mutableLongList = new MutableLongList(jArrCopyOf.length);
            int i = mutableLongList._size;
            if (i >= 0) {
                if (jArrCopyOf.length != 0) {
                    int length = jArrCopyOf.length + i;
                    long[] jArr2 = mutableLongList.content;
                    if (jArr2.length < length) {
                        mutableLongList.content = Arrays.copyOf(jArr2, Math.max(length, (jArr2.length * 3) / 2));
                    }
                    long[] jArr3 = mutableLongList.content;
                    int i2 = mutableLongList._size;
                    if (i != i2) {
                        ArraysKt.copyInto(jArr3, jArr3, jArrCopyOf.length + i, i, i2);
                    }
                    System.arraycopy(jArrCopyOf, 0, jArr3, i, jArrCopyOf.length);
                    mutableLongList._size += jArrCopyOf.length;
                }
            } else {
                RuntimeHelpersKt.throwIndexOutOfBoundsException("");
                throw null;
            }
        } else {
            mutableLongList = new MutableLongList();
        }
        this.weakMemoryCache = mutableLongList;
    }

    @Override // coil.memory.StrongMemoryCache
    public void trimMemory(int i) {
    }

    public EmptyStrongMemoryCache(Uri uri, ClipDescription clipDescription, Uri uri2) {
        this.$r8$classId = 12;
        if (Build.VERSION.SDK_INT >= 25) {
            this.weakMemoryCache = new InputContentInfoCompat$InputContentInfoCompatApi25Impl(uri, clipDescription, uri2);
        } else {
            this.weakMemoryCache = new ImageLoader$Builder(uri, clipDescription, uri2, 11);
        }
    }

    public EmptyStrongMemoryCache(Context context, Uri uri) {
        this.$r8$classId = 9;
        this.weakMemoryCache = context.getContentResolver().acquireUnstableContentProviderClient(uri);
    }

    public EmptyStrongMemoryCache(ClipData clipData, int i) {
        this.$r8$classId = 10;
        this.weakMemoryCache = CanvasCompatS$$ExternalSyntheticApiModelOutline0.m(clipData, i);
    }
}
