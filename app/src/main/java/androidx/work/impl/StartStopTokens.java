package androidx.work.impl;

import android.content.Context;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.SparseIntArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.SupportActionModeWrapper;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuWrapperICS;
import androidx.appcompat.widget.TooltipPopup;
import androidx.camera.camera2.internal.Camera2CameraImpl;
import androidx.camera.camera2.internal.CameraBurstCaptureCallback;
import androidx.camera.camera2.internal.ZoomControl;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompatBaseImpl$CameraCaptureSessionCompatParamsApi21;
import androidx.camera.camera2.interop.CaptureRequestOptions$Builder$$ExternalSyntheticLambda0;
import androidx.camera.core.Preview$$ExternalSyntheticLambda1;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.LiveDataObservable$LiveDataObserverAdapter;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.utils.executor.SequentialExecutor;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.collection.ArraySetKt;
import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda0;
import androidx.compose.material3.SheetValue;
import androidx.compose.material3.internal.MaterialAnchoredDraggableState$anchoredDrag$3;
import androidx.compose.material3.internal.MaterialAnchoredDraggableState$anchoredDrag$4;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.composer.gapbuffer.SlotWriter;
import androidx.compose.runtime.composer.gapbuffer.changelist.OperationErrorContext;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutNodeSubcompositionsState;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.DepthSortedSetKt$DepthComparator$1;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.text.android.selection.SegmentFinder;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.graphics.Insets;
import androidx.core.util.Preconditions;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.emoji2.text.EmojiProcessor$EmojiProcessCallback;
import androidx.emoji2.text.TypefaceEmojiRasterizer;
import androidx.emoji2.text.TypefaceEmojiSpan;
import androidx.emoji2.text.UnprecomputeTextOnModificationSpannable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManagerImpl;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.NavOptions;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.ViewInfoStore$InfoRecord;
import androidx.work.impl.model.WorkGenerationalId;
import coil.network.RealNetworkObserver;
import coil.util.ContinuationCallback;
import com.github.kr328.clash.core.bridge.TunInterface;
import com.github.kr328.clash.core.util.NetKt;
import com.github.kr328.clash.log.LogcatCache;
import com.github.kr328.clash.remote.Resource$get$2$callback$1;
import com.github.kr328.clash.service.clash.module.TunModule$attach$2;
import com.github.kr328.clash.service.remote.IRemoteService;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.mlkit_vision_barcode.zzgn;
import com.google.android.gms.internal.mlkit_vision_barcode.zzss;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.ViewUtils;
import fi.iki.elonen.NanoHTTPD;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.JobKt__JobKt$invokeOnCompletion$1;
import kotlinx.serialization.json.internal.Composer;
import okhttp3.Request;
import okio.AsyncTimeout;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public class StartStopTokens implements FutureCallback, Observable, OperationErrorContext, SubcomposeLayoutState.PausedPrecomposition, SegmentFinder, EmojiProcessor$EmojiProcessCallback, TunInterface, SynchronizationGuard.CriticalSection, OnApplyWindowInsetsListener {
    public final /* synthetic */ int $r8$classId;
    public Object lock;
    public Object runs;

    public /* synthetic */ StartStopTokens(int i, Object obj, Object obj2) {
        this.$r8$classId = i;
        this.runs = obj;
        this.lock = obj2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v5 */
    public static void dispatchHierarchy(LayoutNode layoutNode) {
        if (layoutNode.globallyPositionedObservers > 0) {
            if (layoutNode.layoutDelegate.layoutState == 5 && !layoutNode.getLayoutPending$ui() && !layoutNode.getMeasurePending$ui() && !layoutNode.isDeactivated && layoutNode.isPlaced()) {
                Modifier.Node node = (Modifier.Node) layoutNode.nodes.head;
                if ((node.aggregateChildKindSet & 256) != 0) {
                    while (node != null) {
                        if ((node.kindSet & 256) != 0) {
                            ?? Access$pop = node;
                            ?? mutableVector = 0;
                            while (Access$pop != 0) {
                                if (Access$pop instanceof GlobalPositionAwareModifierNode) {
                                    GlobalPositionAwareModifierNode globalPositionAwareModifierNode = (GlobalPositionAwareModifierNode) Access$pop;
                                    globalPositionAwareModifierNode.onGloballyPositioned(HitTestResultKt.m545requireCoordinator64DMado(globalPositionAwareModifierNode, 256));
                                } else if ((Access$pop.kindSet & 256) != 0 && (Access$pop instanceof DelegatingNode)) {
                                    Modifier.Node node2 = ((DelegatingNode) Access$pop).delegate;
                                    int i = 0;
                                    Access$pop = Access$pop;
                                    mutableVector = mutableVector;
                                    while (node2 != null) {
                                        if ((node2.kindSet & 256) != 0) {
                                            i++;
                                            if (i == 1) {
                                                mutableVector = mutableVector;
                                                Access$pop = node2;
                                            } else {
                                                if (mutableVector == 0) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16]);
                                                }
                                                if (Access$pop != 0) {
                                                    mutableVector.add(Access$pop);
                                                    Access$pop = 0;
                                                }
                                                mutableVector.add(node2);
                                            }
                                        }
                                        node2 = node2.child;
                                        Access$pop = Access$pop;
                                        mutableVector = mutableVector;
                                    }
                                    if (i == 1) {
                                    }
                                }
                                Access$pop = HitTestResultKt.access$pop(mutableVector);
                            }
                        }
                        if ((node.aggregateChildKindSet & 256) == 0) {
                            break;
                        } else {
                            node = node.child;
                        }
                    }
                }
            }
            layoutNode.needsOnGloballyPositionedDispatch = false;
            MutableVector mutableVector2 = layoutNode.get_children$ui();
            Object[] objArr = mutableVector2.content;
            int i2 = mutableVector2.size;
            for (int i3 = 0; i3 < i2; i3++) {
                dispatchHierarchy((LayoutNode) objArr[i3]);
            }
        }
    }

    @Override // androidx.camera.core.impl.Observable
    public void addObserver(Executor executor, Observable.Observer observer) {
        synchronized (((HashMap) this.runs)) {
            LiveDataObservable$LiveDataObserverAdapter liveDataObservable$LiveDataObserverAdapter = (LiveDataObservable$LiveDataObserverAdapter) ((HashMap) this.runs).get(observer);
            if (liveDataObservable$LiveDataObserverAdapter != null) {
                liveDataObservable$LiveDataObserverAdapter.mActive.set(false);
            }
            LiveDataObservable$LiveDataObserverAdapter liveDataObservable$LiveDataObserverAdapter2 = new LiveDataObservable$LiveDataObserverAdapter(executor, (ZoomControl) observer);
            ((HashMap) this.runs).put(observer, liveDataObservable$LiveDataObserverAdapter2);
            SetsKt.mainThreadExecutor().execute(new Processor$$ExternalSyntheticLambda1(this, liveDataObservable$LiveDataObserverAdapter, liveDataObservable$LiveDataObserverAdapter2, 4));
        }
    }

    public void addToPostLayout(RecyclerView.ViewHolder viewHolder, NavOptions.Builder builder) {
        SimpleArrayMap simpleArrayMap = (SimpleArrayMap) this.lock;
        ViewInfoStore$InfoRecord viewInfoStore$InfoRecordObtain = (ViewInfoStore$InfoRecord) simpleArrayMap.get(viewHolder);
        if (viewInfoStore$InfoRecordObtain == null) {
            viewInfoStore$InfoRecordObtain = ViewInfoStore$InfoRecord.obtain();
            simpleArrayMap.put(viewHolder, viewInfoStore$InfoRecordObtain);
        }
        viewInfoStore$InfoRecordObtain.postInfo = builder;
        viewInfoStore$InfoRecordObtain.flags |= 8;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public Object anchoredDrag$material3(FlingBehavior flingBehavior, float f, ContinuationImpl continuationImpl) {
        MaterialAnchoredDraggableState$anchoredDrag$3 materialAnchoredDraggableState$anchoredDrag$3;
        Ref$FloatRef ref$FloatRef;
        if (continuationImpl instanceof MaterialAnchoredDraggableState$anchoredDrag$3) {
            materialAnchoredDraggableState$anchoredDrag$3 = (MaterialAnchoredDraggableState$anchoredDrag$3) continuationImpl;
            int i = materialAnchoredDraggableState$anchoredDrag$3.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                materialAnchoredDraggableState$anchoredDrag$3.label = i - Integer.MIN_VALUE;
            } else {
                materialAnchoredDraggableState$anchoredDrag$3 = new MaterialAnchoredDraggableState$anchoredDrag$3(this, continuationImpl);
            }
        } else {
            materialAnchoredDraggableState$anchoredDrag$3 = new MaterialAnchoredDraggableState$anchoredDrag$3(this, continuationImpl);
        }
        Object obj = materialAnchoredDraggableState$anchoredDrag$3.result;
        int i2 = materialAnchoredDraggableState$anchoredDrag$3.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref$FloatRef ref$FloatRef2 = new Ref$FloatRef();
            NodeChain nodeChain = (NodeChain) this.lock;
            MaterialAnchoredDraggableState$anchoredDrag$4 materialAnchoredDraggableState$anchoredDrag$4 = new MaterialAnchoredDraggableState$anchoredDrag$4(ref$FloatRef2, flingBehavior, this, f, null);
            materialAnchoredDraggableState$anchoredDrag$3.L$0 = ref$FloatRef2;
            materialAnchoredDraggableState$anchoredDrag$3.label = 1;
            Object objAnchoredDrag$default = NodeChain.anchoredDrag$default(nodeChain, materialAnchoredDraggableState$anchoredDrag$4, materialAnchoredDraggableState$anchoredDrag$3);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objAnchoredDrag$default == coroutineSingletons) {
                return coroutineSingletons;
            }
            ref$FloatRef = ref$FloatRef2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ref$FloatRef = materialAnchoredDraggableState$anchoredDrag$3.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return new Float(ref$FloatRef.element);
    }

    @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PausedPrecomposition
    public SubcomposeLayoutState.PrecomposedSlotHandle apply() {
        return ((LayoutNodeSubcompositionsState) this.runs).createPrecomposedSlotHandle(this.lock);
    }

    public void at(SheetValue sheetValue, float f) {
        ArrayList arrayList = (ArrayList) this.lock;
        arrayList.add(sheetValue);
        if (((float[]) this.runs).length < arrayList.size()) {
            this.runs = Arrays.copyOf((float[]) this.runs, arrayList.size() + 2);
        }
        ((float[]) this.runs)[arrayList.size() - 1] = f;
    }

    @Override // androidx.compose.runtime.composer.gapbuffer.changelist.OperationErrorContext
    public List buildStackTrace(Integer num) {
        List listBuildStackTrace = ((OperationErrorContext) this.lock).buildStackTrace(null);
        SlotWriter slotWriter = (SlotWriter) this.runs;
        int i = slotWriter.parent;
        return i < 0 ? listBuildStackTrace : CollectionsKt.plus((Collection) zzss.buildTrace(slotWriter, num, i, Integer.valueOf(slotWriter.parent(slotWriter.groups, i))), listBuildStackTrace);
    }

    @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PausedPrecomposition
    public void cancel() {
        switch (this.$r8$classId) {
            case 3:
                RealNetworkObserver realNetworkObserver = (RealNetworkObserver) this.lock;
                if (realNetworkObserver != null) {
                    ((AtomicBoolean) realNetworkObserver.listener).set(true);
                    ((ScheduledFuture) realNetworkObserver.connectivityManager).cancel(true);
                }
                this.lock = null;
                break;
        }
    }

    public int captureBurstRequests(ArrayList arrayList, SequentialExecutor sequentialExecutor, CameraCaptureSession.CaptureCallback captureCallback) {
        return ((CameraCaptureSession) this.runs).captureBurst(arrayList, new CameraBurstCaptureCallback(sequentialExecutor, captureCallback), ((CameraCaptureSessionCompatBaseImpl$CameraCaptureSessionCompatParamsApi21) this.lock).mCompatHandler);
    }

    public void clear() {
        ArrayList arrayList = (ArrayList) this.runs;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            NanoHTTPD.DefaultTempFile defaultTempFile = (NanoHTTPD.DefaultTempFile) obj;
            try {
                NanoHTTPD.safeClose(defaultTempFile.fstream);
                File file = defaultTempFile.file;
                if (!file.delete()) {
                    throw new Exception("could not delete temporary file: " + file.getAbsolutePath());
                }
            } catch (Exception e) {
                NanoHTTPD.LOG.log(Level.WARNING, "could not delete file ", (Throwable) e);
            }
        }
        arrayList.clear();
    }

    public boolean contains(WorkGenerationalId workGenerationalId) {
        boolean zContainsKey;
        synchronized (this.lock) {
            zContainsKey = ((LinkedHashMap) this.runs).containsKey(workGenerationalId);
        }
        return zContainsKey;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void dispatch() {
        Object[] objArr;
        MutableVector mutableVector = (MutableVector) this.lock;
        Arrays.sort(mutableVector.content, 0, mutableVector.size, DepthSortedSetKt$DepthComparator$1.INSTANCE);
        int i = mutableVector.size;
        LayoutNode[] layoutNodeArr = (LayoutNode[]) this.runs;
        if (layoutNodeArr == null || layoutNodeArr.length < i) {
            objArr = layoutNodeArr;
            objArr = new LayoutNode[Math.max(16, i)];
        }
        objArr = layoutNodeArr;
        this.runs = null;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = mutableVector.content[i2];
        }
        mutableVector.clear();
        while (true) {
            i--;
            if (-1 >= i) {
                this.runs = objArr;
                return;
            }
            LayoutNode layoutNode = objArr[i];
            if (layoutNode.needsOnGloballyPositionedDispatch) {
                dispatchHierarchy(layoutNode);
            }
            objArr[i] = 0;
        }
    }

    public void dispatchOnFragmentActivityCreated(boolean z) {
        Fragment fragment = ((FragmentManagerImpl) this.runs).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentActivityCreated(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.lock).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void dispatchOnFragmentAttached(boolean z) {
        FragmentManagerImpl fragmentManagerImpl = (FragmentManagerImpl) this.runs;
        AppCompatActivity appCompatActivity = fragmentManagerImpl.mHost.mContext;
        Fragment fragment = fragmentManagerImpl.mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentAttached(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.lock).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void dispatchOnFragmentCreated(boolean z) {
        Fragment fragment = ((FragmentManagerImpl) this.runs).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentCreated(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.lock).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void dispatchOnFragmentDestroyed(boolean z) {
        Fragment fragment = ((FragmentManagerImpl) this.runs).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentDestroyed(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.lock).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void dispatchOnFragmentDetached(boolean z) {
        Fragment fragment = ((FragmentManagerImpl) this.runs).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentDetached(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.lock).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void dispatchOnFragmentPaused(boolean z) {
        Fragment fragment = ((FragmentManagerImpl) this.runs).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentPaused(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.lock).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void dispatchOnFragmentPreAttached(boolean z) {
        FragmentManagerImpl fragmentManagerImpl = (FragmentManagerImpl) this.runs;
        AppCompatActivity appCompatActivity = fragmentManagerImpl.mHost.mContext;
        Fragment fragment = fragmentManagerImpl.mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentPreAttached(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.lock).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void dispatchOnFragmentPreCreated(boolean z) {
        Fragment fragment = ((FragmentManagerImpl) this.runs).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentPreCreated(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.lock).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void dispatchOnFragmentResumed(boolean z) {
        Fragment fragment = ((FragmentManagerImpl) this.runs).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentResumed(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.lock).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void dispatchOnFragmentSaveInstanceState(boolean z) {
        Fragment fragment = ((FragmentManagerImpl) this.runs).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentSaveInstanceState(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.lock).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void dispatchOnFragmentStarted(boolean z) {
        Fragment fragment = ((FragmentManagerImpl) this.runs).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentStarted(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.lock).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void dispatchOnFragmentStopped(boolean z) {
        Fragment fragment = ((FragmentManagerImpl) this.runs).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentStopped(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.lock).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void dispatchOnFragmentViewCreated(boolean z) {
        Fragment fragment = ((FragmentManagerImpl) this.runs).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentViewCreated(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.lock).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public void dispatchOnFragmentViewDestroyed(boolean z) {
        Fragment fragment = ((FragmentManagerImpl) this.runs).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentViewDestroyed(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.lock).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object execute() {
        TooltipPopup tooltipPopup = (TooltipPopup) this.lock;
        AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) this.runs;
        SQLiteEventStore sQLiteEventStore = (SQLiteEventStore) ((EventStore) tooltipPopup.mMessageView);
        sQLiteEventStore.getClass();
        return (Iterable) sQLiteEventStore.inTransaction(new WorkLauncherImpl(18, sQLiteEventStore, autoValue_TransportContext));
    }

    public Object get(ContinuationImpl continuationImpl) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, zzgn.intercepted(continuationImpl));
        cancellableContinuationImpl.initCancellability();
        Resource$get$2$callback$1 resource$get$2$callback$1 = new Resource$get$2$callback$1(cancellableContinuationImpl);
        cancellableContinuationImpl.invokeOnCancellation(new ContinuationCallback(8, this, resource$get$2$callback$1));
        synchronized (this) {
            try {
                Object obj = this.lock;
                if (obj == null) {
                    ((LinkedHashSet) this.runs).add(resource$get$2$callback$1);
                } else {
                    cancellableContinuationImpl.resumeWith(obj);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cancellableContinuationImpl.getResult();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    public InputMethodManager getImm() {
        return (InputMethodManager) this.lock.getValue();
    }

    @Override // androidx.emoji2.text.EmojiProcessor$EmojiProcessCallback
    public Object getResult() {
        return (UnprecomputeTextOnModificationSpannable) this.lock;
    }

    @Override // androidx.compose.runtime.composer.gapbuffer.changelist.OperationErrorContext
    public boolean getSourceInformationEnabled() {
        return ((OperationErrorContext) this.lock).getSourceInformationEnabled();
    }

    @Override // androidx.emoji2.text.EmojiProcessor$EmojiProcessCallback
    public boolean handleEmoji(CharSequence charSequence, int i, int i2, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
        if ((typefaceEmojiRasterizer.mCache & 4) > 0) {
            return true;
        }
        if (((UnprecomputeTextOnModificationSpannable) this.lock) == null) {
            this.lock = new UnprecomputeTextOnModificationSpannable(charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence));
        }
        ((AsyncTimeout.Companion) this.runs).getClass();
        ((UnprecomputeTextOnModificationSpannable) this.lock).setSpan(new TypefaceEmojiSpan(typefaceEmojiRasterizer), i, i2, 33);
        return true;
    }

    @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PausedPrecomposition
    public boolean isComplete() {
        return true;
    }

    @Override // com.github.kr328.clash.core.bridge.TunInterface
    public void markSocket(int i) {
        ((JobKt__JobKt$invokeOnCompletion$1) this.lock).invoke(Integer.valueOf(i));
    }

    @Override // androidx.compose.ui.text.android.selection.SegmentFinder
    public int nextEndBoundary(int i) {
        do {
            i = ((LogcatCache) this.runs).nextBoundary(i);
            if (i == -1) {
                return -1;
            }
        } while (Character.isWhitespace(((CharSequence) this.lock).charAt(i - 1)));
        return i;
    }

    @Override // androidx.compose.ui.text.android.selection.SegmentFinder
    public int nextStartBoundary(int i) {
        CharSequence charSequence = (CharSequence) this.lock;
        do {
            i = ((LogcatCache) this.runs).nextBoundary(i);
            if (i == -1 || i == charSequence.length()) {
                return -1;
            }
        } while (Character.isWhitespace(charSequence.charAt(i)));
        return i;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x008a  */
    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        boolean z;
        Composer composer = (Composer) this.lock;
        ViewUtils.RelativePadding relativePadding = (ViewUtils.RelativePadding) this.runs;
        int i = relativePadding.start;
        int i2 = relativePadding.end;
        int i3 = relativePadding.bottom;
        WindowInsetsCompat.Impl impl = windowInsetsCompat.mImpl;
        Insets insets = impl.getInsets(519);
        Insets insets2 = impl.getInsets(32);
        BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) composer.writer;
        int i4 = insets.top;
        int i5 = insets.right;
        int i6 = insets.left;
        bottomSheetBehavior.insetTop = i4;
        boolean zIsLayoutRtl = ViewUtils.isLayoutRtl(view);
        int paddingBottom = view.getPaddingBottom();
        int paddingLeft = view.getPaddingLeft();
        int paddingRight = view.getPaddingRight();
        boolean z2 = bottomSheetBehavior.paddingBottomSystemWindowInsets;
        if (z2) {
            int systemWindowInsetBottom = windowInsetsCompat.getSystemWindowInsetBottom();
            bottomSheetBehavior.insetBottom = systemWindowInsetBottom;
            paddingBottom = systemWindowInsetBottom + i3;
        }
        if (bottomSheetBehavior.paddingLeftSystemWindowInsets) {
            paddingLeft = (zIsLayoutRtl ? i2 : i) + i6;
        }
        if (bottomSheetBehavior.paddingRightSystemWindowInsets) {
            if (!zIsLayoutRtl) {
                i = i2;
            }
            paddingRight = i + i5;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        boolean z3 = true;
        if (!bottomSheetBehavior.marginLeftSystemWindowInsets || marginLayoutParams.leftMargin == i6) {
            z = false;
        } else {
            marginLayoutParams.leftMargin = i6;
            z = true;
        }
        if (bottomSheetBehavior.marginRightSystemWindowInsets && marginLayoutParams.rightMargin != i5) {
            marginLayoutParams.rightMargin = i5;
            z = true;
        }
        if (bottomSheetBehavior.marginTopSystemWindowInsets) {
            int i7 = marginLayoutParams.topMargin;
            int i8 = insets.top;
            if (i7 != i8) {
                marginLayoutParams.topMargin = i8;
            } else {
                z3 = z;
            }
        } else {
            z3 = z;
        }
        if (z3) {
            view.setLayoutParams(marginLayoutParams);
        }
        view.setPadding(paddingLeft, view.getPaddingTop(), paddingRight, paddingBottom);
        boolean z4 = composer.writingFirst;
        if (z4) {
            bottomSheetBehavior.gestureInsetBottom = insets2.bottom;
        }
        if (!z2 && !z4) {
            return windowInsetsCompat;
        }
        bottomSheetBehavior.updatePeekHeight();
        return windowInsetsCompat;
    }

    public void onDestroyActionMode(ActionMode actionMode) {
        Request.Builder builder = (Request.Builder) this.lock;
        ((android.view.ActionMode.Callback) builder.url).onDestroyActionMode(builder.getActionModeWrapper(actionMode));
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) this.runs;
        if (appCompatDelegateImpl.mActionModePopup != null) {
            appCompatDelegateImpl.mWindow.getDecorView().removeCallbacks(appCompatDelegateImpl.mShowActionModePopup);
        }
        if (appCompatDelegateImpl.mActionModeView != null) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = appCompatDelegateImpl.mFadeAnim;
            if (viewPropertyAnimatorCompat != null) {
                viewPropertyAnimatorCompat.cancel();
            }
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompatAnimate = ViewCompat.animate(appCompatDelegateImpl.mActionModeView);
            viewPropertyAnimatorCompatAnimate.alpha(0.0f);
            appCompatDelegateImpl.mFadeAnim = viewPropertyAnimatorCompatAnimate;
            viewPropertyAnimatorCompatAnimate.setListener(new AppCompatDelegateImpl.AnonymousClass7(2, this));
        }
        appCompatDelegateImpl.mActionMode = null;
        ViewGroup viewGroup = appCompatDelegateImpl.mSubDecor;
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        ViewCompat.Api20Impl.requestApplyInsets(viewGroup);
        appCompatDelegateImpl.updateBackInvokedCallbackState();
    }

    @Override // androidx.camera.core.impl.utils.futures.FutureCallback
    public void onFailure(Throwable th) {
        if (th instanceof SurfaceRequest.RequestCancelledException) {
            Preconditions.checkState(null, ((CallbackToFutureAdapter.SafeFuture) this.runs).cancel(false));
        } else {
            Preconditions.checkState(null, ((CallbackToFutureAdapter.Completer) this.lock).set(null));
        }
    }

    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        ViewGroup viewGroup = ((AppCompatDelegateImpl) this.runs).mSubDecor;
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        ViewCompat.Api20Impl.requestApplyInsets(viewGroup);
        Request.Builder builder = (Request.Builder) this.lock;
        android.view.ActionMode.Callback callback = (android.view.ActionMode.Callback) builder.url;
        SupportActionModeWrapper actionModeWrapper = builder.getActionModeWrapper(actionMode);
        SimpleArrayMap simpleArrayMap = (SimpleArrayMap) builder.tags;
        Menu menuWrapperICS = (Menu) simpleArrayMap.get(menu);
        if (menuWrapperICS == null) {
            menuWrapperICS = new MenuWrapperICS((Context) builder.method, (MenuBuilder) menu);
            simpleArrayMap.put(menu, menuWrapperICS);
        }
        return callback.onPrepareActionMode(actionModeWrapper, menuWrapperICS);
    }

    @Override // androidx.camera.core.impl.utils.futures.FutureCallback
    public void onSuccess(Object obj) {
        Preconditions.checkState(null, ((CallbackToFutureAdapter.Completer) this.lock).set(null));
    }

    public NavOptions.Builder popFromLayoutStep(RecyclerView.ViewHolder viewHolder, int i) {
        ViewInfoStore$InfoRecord viewInfoStore$InfoRecord;
        NavOptions.Builder builder;
        SimpleArrayMap simpleArrayMap = (SimpleArrayMap) this.lock;
        int iIndexOfKey = simpleArrayMap.indexOfKey(viewHolder);
        if (iIndexOfKey >= 0 && (viewInfoStore$InfoRecord = (ViewInfoStore$InfoRecord) simpleArrayMap.valueAt(iIndexOfKey)) != null) {
            int i2 = viewInfoStore$InfoRecord.flags;
            if ((i2 & i) != 0) {
                int i3 = i2 & (~i);
                viewInfoStore$InfoRecord.flags = i3;
                if (i == 4) {
                    builder = viewInfoStore$InfoRecord.preInfo;
                } else {
                    if (i != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    builder = viewInfoStore$InfoRecord.postInfo;
                }
                if ((i3 & 12) == 0) {
                    simpleArrayMap.removeAt(iIndexOfKey);
                    viewInfoStore$InfoRecord.flags = 0;
                    viewInfoStore$InfoRecord.preInfo = null;
                    viewInfoStore$InfoRecord.postInfo = null;
                    ViewInfoStore$InfoRecord.sPool.release(viewInfoStore$InfoRecord);
                }
                return builder;
            }
        }
        return null;
    }

    @Override // androidx.compose.ui.text.android.selection.SegmentFinder
    public int previousEndBoundary(int i) {
        do {
            i = ((LogcatCache) this.runs).prevBoundary(i);
            if (i == -1 || i == 0) {
                return -1;
            }
        } while (Character.isWhitespace(((CharSequence) this.lock).charAt(i - 1)));
        return i;
    }

    @Override // androidx.compose.ui.text.android.selection.SegmentFinder
    public int previousStartBoundary(int i) {
        do {
            i = ((LogcatCache) this.runs).prevBoundary(i);
            if (i == -1) {
                return -1;
            }
        } while (Character.isWhitespace(((CharSequence) this.lock).charAt(i)));
        return i;
    }

    @Override // com.github.kr328.clash.core.bridge.TunInterface
    public int querySocketUid(int i, String str, String str2) {
        return ((Number) ((TunModule$attach$2) this.runs).invoke(Integer.valueOf(i), NetKt.parseInetSocketAddress(str), NetKt.parseInetSocketAddress(str2))).intValue();
    }

    public StartStopToken remove(WorkGenerationalId workGenerationalId) {
        StartStopToken startStopToken;
        synchronized (this.lock) {
            startStopToken = (StartStopToken) ((LinkedHashMap) this.runs).remove(workGenerationalId);
        }
        return startStopToken;
    }

    public void removeFromDisappearedInLayout(RecyclerView.ViewHolder viewHolder) {
        ViewInfoStore$InfoRecord viewInfoStore$InfoRecord = (ViewInfoStore$InfoRecord) ((SimpleArrayMap) this.lock).get(viewHolder);
        if (viewInfoStore$InfoRecord == null) {
            return;
        }
        viewInfoStore$InfoRecord.flags &= -2;
    }

    @Override // androidx.camera.core.impl.Observable
    public void removeObserver(Observable.Observer observer) {
        synchronized (((HashMap) this.runs)) {
            try {
                LiveDataObservable$LiveDataObserverAdapter liveDataObservable$LiveDataObserverAdapter = (LiveDataObservable$LiveDataObserverAdapter) ((HashMap) this.runs).remove(observer);
                if (liveDataObservable$LiveDataObserverAdapter != null) {
                    liveDataObservable$LiveDataObserverAdapter.mActive.set(false);
                    SetsKt.mainThreadExecutor().execute(new Preview$$ExternalSyntheticLambda1(14, this, liveDataObservable$LiveDataObserverAdapter));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void removeViewHolder(RecyclerView.ViewHolder viewHolder) {
        LongSparseArray longSparseArray = (LongSparseArray) this.runs;
        for (int size = longSparseArray.size() - 1; size >= 0; size--) {
            if (viewHolder == longSparseArray.valueAt(size)) {
                Object[] objArr = longSparseArray.values;
                Object obj = objArr[size];
                Object obj2 = ArraySetKt.DELETED;
                if (obj == obj2) {
                    break;
                }
                objArr[size] = obj2;
                longSparseArray.garbage = true;
                break;
            }
        }
        ViewInfoStore$InfoRecord viewInfoStore$InfoRecord = (ViewInfoStore$InfoRecord) ((SimpleArrayMap) this.lock).remove(viewHolder);
        if (viewInfoStore$InfoRecord != null) {
            viewInfoStore$InfoRecord.flags = 0;
            viewInfoStore$InfoRecord.preInfo = null;
            viewInfoStore$InfoRecord.postInfo = null;
            ViewInfoStore$InfoRecord.sPool.release(viewInfoStore$InfoRecord);
        }
    }

    @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PausedPrecomposition
    public boolean resume(CaptureRequestOptions$Builder$$ExternalSyntheticLambda0 captureRequestOptions$Builder$$ExternalSyntheticLambda0) {
        return true;
    }

    public void set(IRemoteService iRemoteService) {
        synchronized (this) {
            try {
                this.lock = iRemoteService;
                if (iRemoteService != null) {
                    Iterator it = ((LinkedHashSet) this.runs).iterator();
                    while (it.hasNext()) {
                        ((Resource$get$2$callback$1) it.next()).$ctx.resumeWith(iRemoteService);
                    }
                    ((LinkedHashSet) this.runs).clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int setSingleRepeatingRequest(CaptureRequest captureRequest, SequentialExecutor sequentialExecutor, CameraCaptureSession.CaptureCallback captureCallback) {
        return ((CameraCaptureSession) this.runs).setRepeatingRequest(captureRequest, new CameraBurstCaptureCallback(sequentialExecutor, captureCallback), ((CameraCaptureSessionCompatBaseImpl$CameraCaptureSessionCompatParamsApi21) this.lock).mCompatHandler);
    }

    public StartStopToken tokenFor(WorkGenerationalId workGenerationalId) {
        StartStopToken startStopToken;
        synchronized (this.lock) {
            try {
                LinkedHashMap linkedHashMap = (LinkedHashMap) this.runs;
                Object startStopToken2 = linkedHashMap.get(workGenerationalId);
                if (startStopToken2 == null) {
                    startStopToken2 = new StartStopToken(workGenerationalId);
                    linkedHashMap.put(workGenerationalId, startStopToken2);
                }
                startStopToken = (StartStopToken) startStopToken2;
            } catch (Throwable th) {
                throw th;
            }
        }
        return startStopToken;
    }

    public void zah(boolean z, Status status) {
        HashMap map;
        HashMap map2;
        synchronized (((Map) this.lock)) {
            map = new HashMap((Map) this.lock);
        }
        synchronized (((Map) this.runs)) {
            map2 = new HashMap((Map) this.runs);
        }
        for (Map.Entry entry : map.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                entry.getKey().getClass();
                throw new ClassCastException();
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((TaskCompletionSource) entry2.getKey()).trySetException(new ApiException(status));
            }
        }
    }

    public /* synthetic */ StartStopTokens(int i, Object obj, Object obj2, boolean z) {
        this.$r8$classId = i;
        this.lock = obj;
        this.runs = obj2;
    }

    public /* synthetic */ StartStopTokens(int i, boolean z) {
        this.$r8$classId = i;
    }

    public StartStopTokens(int i) {
        this.$r8$classId = i;
        switch (i) {
            case 6:
                this.lock = new MutableLiveData();
                this.runs = new HashMap();
                break;
            case 8:
                this.lock = new ArrayList();
                float[] fArr = new float[5];
                for (int i2 = 0; i2 < 5; i2++) {
                    fArr[i2] = Float.NaN;
                }
                this.runs = fArr;
                break;
            case 12:
                this.lock = new MutableVector(new LayoutNode[16]);
                break;
            case 17:
                this.lock = new SimpleArrayMap(0);
                this.runs = new LongSparseArray((Object) null);
                break;
            case 19:
                this.runs = new LinkedHashSet();
                break;
            case 21:
                this.lock = Collections.synchronizedMap(new WeakHashMap());
                this.runs = Collections.synchronizedMap(new WeakHashMap());
                break;
            case 22:
                GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.zab;
                this.lock = new SparseIntArray();
                this.runs = googleApiAvailability;
                break;
            case 24:
                File file = new File(System.getProperty("java.io.tmpdir"));
                this.lock = file;
                if (!file.exists()) {
                    file.mkdirs();
                }
                this.runs = new ArrayList();
                break;
            default:
                this.lock = new Object();
                this.runs = new LinkedHashMap();
                break;
        }
    }

    public List remove(String str) {
        List list;
        synchronized (this.lock) {
            try {
                LinkedHashMap linkedHashMap = (LinkedHashMap) this.runs;
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    if (Intrinsics.areEqual(((WorkGenerationalId) entry.getKey()).workSpecId, str)) {
                        linkedHashMap2.put(entry.getKey(), entry.getValue());
                    }
                }
                Iterator it = linkedHashMap2.keySet().iterator();
                while (it.hasNext()) {
                    ((LinkedHashMap) this.runs).remove((WorkGenerationalId) it.next());
                }
                list = CollectionsKt.toList(linkedHashMap2.values());
            } catch (Throwable th) {
                throw th;
            }
        }
        return list;
    }

    private final void cancel$androidx$compose$ui$layout$LayoutNodeSubcompositionsState$precomposePaused$1() {
    }

    public StartStopTokens(CameraCaptureSession cameraCaptureSession, CameraCaptureSessionCompatBaseImpl$CameraCaptureSessionCompatParamsApi21 cameraCaptureSessionCompatBaseImpl$CameraCaptureSessionCompatParamsApi21) {
        this.$r8$classId = 4;
        cameraCaptureSession.getClass();
        this.runs = cameraCaptureSession;
        this.lock = cameraCaptureSessionCompatBaseImpl$CameraCaptureSessionCompatParamsApi21;
    }

    public StartStopTokens(FragmentManagerImpl fragmentManagerImpl) {
        this.$r8$classId = 16;
        this.lock = new CopyOnWriteArrayList();
        this.runs = fragmentManagerImpl;
    }

    public StartStopTokens(View view) {
        this.$r8$classId = 1;
        this.runs = view;
        this.lock = LazyKt__LazyJVMKt.lazy(3, new BasicTextKt$$ExternalSyntheticLambda0(15, this));
    }

    public StartStopTokens(SheetValue sheetValue, Function1 function1) {
        this.$r8$classId = 9;
        ArcSplineKt.spring$default(0.0f, 0.0f, null, 7);
        ArcSplineKt.exponentialDecay$default();
        this.lock = new NodeChain(sheetValue, function1);
        this.runs = Stack.derivedStateOf(new BasicTextKt$$ExternalSyntheticLambda0(21, this));
    }

    public StartStopTokens(Camera2CameraImpl camera2CameraImpl) {
        this.$r8$classId = 3;
        this.runs = camera2CameraImpl;
        this.lock = null;
    }
}
