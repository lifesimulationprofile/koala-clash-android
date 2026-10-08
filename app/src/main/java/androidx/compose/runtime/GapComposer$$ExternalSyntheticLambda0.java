package androidx.compose.runtime;

import androidx.appcompat.widget.Toolbar;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.gestures.BringIntoViewSpec;
import androidx.compose.foundation.gestures.ContentInViewNode;
import androidx.compose.foundation.gestures.ContentInViewNodeKt;
import androidx.compose.foundation.gestures.UpdatableAnimationState;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.foundation.lazy.LazyListItemProviderImpl;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.layout.LazyLayoutNearestRangeState;
import androidx.compose.foundation.relocation.BringIntoViewResponderNode;
import androidx.compose.material3.BottomSheetKt$BottomSheetImpl$6$1$1$1$1;
import androidx.compose.material3.DelegatingThemeAwareRippleNode;
import androidx.compose.material3.DelegatingThemeAwareRippleNode$attachNewRipple$calculateColor$1;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.MotionScheme;
import androidx.compose.material3.RippleKt;
import androidx.compose.material3.RippleThemeConfiguration;
import androidx.compose.material3.RippleThemeConfiguration$Focus$InsetRing;
import androidx.compose.material3.RippleThemeConfiguration$Focus$Opacity;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.SheetState;
import androidx.compose.material3.SheetValue;
import androidx.compose.material3.TooltipStateImpl;
import androidx.compose.material3.internal.ripple.RippleNodeConfig;
import androidx.compose.material3.internal.ripple.RippleNodeConfig$Drag$None;
import androidx.compose.material3.internal.ripple.RippleNodeConfig$Drag$Opacity;
import androidx.compose.material3.internal.ripple.RippleNodeConfig$Focus$InsetRing;
import androidx.compose.material3.internal.ripple.RippleNodeConfig$Focus$None;
import androidx.compose.material3.internal.ripple.RippleNodeConfig$Focus$Opacity;
import androidx.compose.material3.internal.ripple.RippleNodeConfig$Hover$None;
import androidx.compose.material3.internal.ripple.RippleNodeConfig$Hover$Opacity;
import androidx.compose.material3.internal.ripple.RippleNodeConfig$Press$None;
import androidx.compose.material3.internal.ripple.RippleNodeConfig$Press$Opacity;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.composer.gapbuffer.GapAnchor;
import androidx.compose.runtime.composer.gapbuffer.SlotReader;
import androidx.compose.runtime.composer.gapbuffer.SlotWriter;
import androidx.compose.runtime.composer.gapbuffer.changelist.ChangeList;
import androidx.compose.runtime.composer.gapbuffer.changelist.ComposerChangeListWriter;
import androidx.compose.runtime.composer.gapbuffer.changelist.OperationErrorContext;
import androidx.compose.runtime.internal.AtomicInt;
import androidx.compose.runtime.internal.AwaiterQueue$Awaiter;
import androidx.compose.runtime.tooling.ComposeStackTrace;
import androidx.compose.runtime.tooling.ComposeStackTraceFrame;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.IntSize;
import androidx.lifecycle.ViewModelKt;
import androidx.navigation.compose.DialogHostKt$DialogHost$1$1$1;
import coil.disk.DiskLruCache;
import coil.disk.RealDiskCache;
import com.github.kr328.clash.FilesActivity$showError$1;
import com.github.kr328.clash.LogcatActivity;
import com.github.kr328.clash.compose.profiles.ProfilesViewModel;
import com.github.kr328.clash.compose.profiles.ProfilesViewModel$delete$1;
import com.github.kr328.clash.compose.proxy.ProxyScreenState;
import com.github.kr328.clash.core.model.ConnectionInfo;
import com.github.kr328.clash.design.model.LogFile;
import com.github.kr328.clash.service.model.Profile;
import com.google.android.gms.internal.mlkit_vision_barcode.zzsd;
import com.google.android.gms.internal.mlkit_vision_barcode.zzsf;
import com.google.android.gms.internal.mlkit_vision_barcode.zzss;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import okhttp3.Request;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class GapComposer$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ GapComposer$$ExternalSyntheticLambda0(Object obj, Object obj2, Object obj3, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        zzsd rippleNodeConfig$Focus$InsetRing;
        int i;
        int i2 = this.$r8$classId;
        int i3 = 3;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object obj = this.f$2;
        Object obj2 = this.f$1;
        Object obj3 = this.f$0;
        switch (i2) {
            case 0:
                GapComposer gapComposer = (GapComposer) obj3;
                ChangeList changeList = (ChangeList) obj2;
                SlotReader slotReader = (SlotReader) obj;
                ComposerChangeListWriter composerChangeListWriter = gapComposer.changeListWriter;
                ChangeList changeList2 = composerChangeListWriter.changeList;
                try {
                    composerChangeListWriter.changeList = changeList;
                    SlotReader slotReader2 = gapComposer.reader;
                    int[] iArr = gapComposer.nodeCountOverrides;
                    MutableIntObjectMap mutableIntObjectMap = gapComposer.providerUpdates;
                    gapComposer.nodeCountOverrides = null;
                    gapComposer.providerUpdates = null;
                    try {
                        gapComposer.reader = slotReader;
                        boolean z = composerChangeListWriter.implicitRootStart;
                        try {
                            composerChangeListWriter.implicitRootStart = false;
                            throw null;
                        } catch (Throwable th) {
                            composerChangeListWriter.implicitRootStart = z;
                            throw th;
                        }
                    } catch (Throwable th2) {
                        gapComposer.reader = slotReader2;
                        gapComposer.nodeCountOverrides = iArr;
                        gapComposer.providerUpdates = mutableIntObjectMap;
                        throw th2;
                    }
                } catch (Throwable th3) {
                    composerChangeListWriter.changeList = changeList2;
                    throw th3;
                }
            case 1:
                ContentInViewNode contentInViewNode = (ContentInViewNode) obj3;
                UpdatableAnimationState updatableAnimationState = (UpdatableAnimationState) obj2;
                BringIntoViewSpec bringIntoViewSpec = (BringIntoViewSpec) obj;
                Toolbar.AnonymousClass1 anonymousClass1 = contentInViewNode.bringIntoViewRequests;
                while (true) {
                    MutableVector mutableVector = (MutableVector) anonymousClass1.this$0;
                    int i4 = mutableVector.size;
                    if (i4 != 0) {
                        if (i4 == 0) {
                            throw new NoSuchElementException("MutableVector is empty.");
                        }
                        Rect rect = (Rect) ((ContentInViewNode.Request) mutableVector.content[i4 - 1]).currentBounds.invoke();
                        if (rect == null ? true : ContentInViewNode.m60isMaxVisibleEQwtKw$default(contentInViewNode, rect, 0L, 0L, 3)) {
                            MutableVector mutableVector2 = (MutableVector) anonymousClass1.this$0;
                            ((ContentInViewNode.Request) mutableVector2.removeAt(mutableVector2.size - 1)).continuation.resumeWith(Unit.INSTANCE);
                        }
                    }
                }
                if (contentInViewNode.trackingFocusedChild) {
                    Rect rect2 = (Rect) contentInViewNode.getFocusedRect.invoke();
                    if (rect2 != null && ContentInViewNode.m60isMaxVisibleEQwtKw$default(contentInViewNode, rect2, 0L, 0L, 3)) {
                        contentInViewNode.trackingFocusedChild = false;
                    }
                }
                updatableAnimationState.value = ContentInViewNode.m59access$calculateScrollDeltaI_oMVgE(contentInViewNode, bringIntoViewSpec, 0L);
                return Unit.INSTANCE;
            case 2:
                LazyListState lazyListState = (LazyListState) obj2;
                LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) ((DerivedSnapshotState) obj3).getValue();
                return new LazyListItemProviderImpl(lazyListState, lazyListIntervalContent, (LazyItemScopeImpl) obj, new StatusLine((IntRange) ((LazyLayoutNearestRangeState) lazyListState.scrollPosition.connection).getValue(), lazyListIntervalContent));
            case 3:
                BringIntoViewResponderNode bringIntoViewResponderNode = (BringIntoViewResponderNode) obj3;
                Rect rectBringIntoView$localRect = BringIntoViewResponderNode.bringIntoView$localRect(bringIntoViewResponderNode, (NodeCoordinator) obj2, (DialogHostKt$DialogHost$1$1$1) obj);
                if (rectBringIntoView$localRect == null) {
                    return null;
                }
                ContentInViewNode contentInViewNode2 = bringIntoViewResponderNode.responder;
                if (IntSize.m717equalsimpl0(contentInViewNode2.viewportSize, ContentInViewNodeKt.UnspecifiedIntSize)) {
                    InlineClassHelperKt.throwIllegalStateException("Expected BringIntoViewRequester to not be used before parents are placed.");
                }
                return rectBringIntoView$localRect.m379translatek4lQ0M(contentInViewNode2.m64relocationOffsetfbGrOKE(rectBringIntoView$localRect, contentInViewNode2.m61getViewportSizeOrZeroYbymL2g$foundation(), 0L) ^ (-9223372034707292160L));
            case 4:
                SheetState sheetState = (SheetState) obj3;
                sheetState.showMotionSpec = (FiniteAnimationSpec) obj2;
                sheetState.hideMotionSpec = (FiniteAnimationSpec) obj;
                return Unit.INSTANCE;
            case 5:
                CoroutineScope coroutineScope = (CoroutineScope) obj2;
                SheetState sheetState2 = (SheetState) obj;
                if (((Boolean) ((SheetState) obj3).confirmValueChange.invoke(SheetValue.Expanded)).booleanValue()) {
                    JobKt.launch$default(coroutineScope, null, new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(sheetState2, objArr == true ? 1 : 0, 4), 3);
                }
                return Boolean.TRUE;
            case 6:
                DelegatingThemeAwareRippleNode delegatingThemeAwareRippleNode = (DelegatingThemeAwareRippleNode) obj3;
                DelegatingThemeAwareRippleNode$attachNewRipple$calculateColor$1 delegatingThemeAwareRippleNode$attachNewRipple$calculateColor$1 = (DelegatingThemeAwareRippleNode$attachNewRipple$calculateColor$1) obj2;
                RealDiskCache.RealEditor realEditor = (RealDiskCache.RealEditor) obj;
                MotionScheme motionScheme = ((MaterialTheme$Values) HitTestResultKt.currentValueOf(delegatingThemeAwareRippleNode, MaterialThemeKt._localMaterialTheme)).motionScheme;
                RippleThemeConfiguration rippleThemeConfiguration = (RippleThemeConfiguration) HitTestResultKt.currentValueOf(delegatingThemeAwareRippleNode, RippleKt.LocalRippleThemeConfiguration);
                zzsf rippleNodeConfig$Press$Opacity = delegatingThemeAwareRippleNode.enablePressIndication ? new RippleNodeConfig$Press$Opacity() : RippleNodeConfig$Press$None.INSTANCE;
                if (delegatingThemeAwareRippleNode.enableFocusIndication) {
                    ScrimKt scrimKt = rippleThemeConfiguration.focus;
                    if (scrimKt instanceof RippleThemeConfiguration$Focus$Opacity) {
                        rippleNodeConfig$Focus$InsetRing = new RippleNodeConfig$Focus$Opacity();
                    } else {
                        if (!(scrimKt instanceof RippleThemeConfiguration$Focus$InsetRing)) {
                            throw new IllegalStateException("Unknown focus ripple theme configuration");
                        }
                        RippleThemeConfiguration$Focus$InsetRing rippleThemeConfiguration$Focus$InsetRing = (RippleThemeConfiguration$Focus$InsetRing) scrimKt;
                        rippleNodeConfig$Focus$InsetRing = new RippleNodeConfig$Focus$InsetRing(delegatingThemeAwareRippleNode.focusRingShape, rippleThemeConfiguration$Focus$InsetRing.outerStrokeInset, rippleThemeConfiguration$Focus$InsetRing.outerStrokeWidth, delegatingThemeAwareRippleNode$attachNewRipple$calculateColor$1, rippleThemeConfiguration$Focus$InsetRing.innerStrokeInset, rippleThemeConfiguration$Focus$InsetRing.innerStrokeWidth, realEditor, motionScheme.fastSpatialSpec(), motionScheme.fastEffectsSpec());
                    }
                } else {
                    rippleNodeConfig$Focus$InsetRing = RippleNodeConfig$Focus$None.INSTANCE;
                }
                return new RippleNodeConfig(rippleNodeConfig$Press$Opacity, rippleNodeConfig$Focus$InsetRing, delegatingThemeAwareRippleNode.enableHoverIndication ? new RippleNodeConfig$Hover$Opacity() : RippleNodeConfig$Hover$None.INSTANCE, delegatingThemeAwareRippleNode.enableDragIndication ? new RippleNodeConfig$Drag$Opacity() : RippleNodeConfig$Drag$None.INSTANCE);
            case 7:
                TooltipStateImpl tooltipStateImpl = (TooltipStateImpl) obj3;
                CoroutineScope coroutineScope2 = (CoroutineScope) obj2;
                MutableState mutableState = (MutableState) obj;
                if (tooltipStateImpl.isVisible()) {
                    JobKt.launch$default(coroutineScope2, null, new DiskLruCache.AnonymousClass1(tooltipStateImpl, objArr2 == true ? 1 : 0, i3), 3);
                    mutableState.setValue(Boolean.FALSE);
                }
                return Unit.INSTANCE;
            case 8:
                GapAnchor gapAnchor = (GapAnchor) obj3;
                SlotWriter slotWriter = (SlotWriter) obj2;
                OperationErrorContext operationErrorContext = (OperationErrorContext) obj;
                if (gapAnchor != null) {
                    slotWriter.advanceBy(slotWriter.anchorIndex(gapAnchor) - slotWriter.currentGroup);
                }
                List listBuildTrace = zzss.buildTrace(slotWriter, null, slotWriter.currentGroup, null);
                ComposeStackTraceFrame composeStackTraceFrame = (ComposeStackTraceFrame) CollectionsKt.lastOrNull(listBuildTrace);
                Integer num = composeStackTraceFrame != null ? composeStackTraceFrame.groupOffset : null;
                List listBuildStackTrace = operationErrorContext.buildStackTrace(num);
                if (num != null && !listBuildStackTrace.isEmpty()) {
                    ComposeStackTraceFrame composeStackTraceFrame2 = (ComposeStackTraceFrame) CollectionsKt.first(listBuildStackTrace);
                    List listDrop = CollectionsKt.drop(1, listBuildStackTrace);
                    int i5 = composeStackTraceFrame2.groupKey;
                    Exchange exchange = composeStackTraceFrame2.sourceInfo;
                    composeStackTraceFrame2.getClass();
                    listBuildStackTrace = CollectionsKt.plus((Collection) Collections.singletonList(new ComposeStackTraceFrame(i5, exchange, num)), listDrop);
                }
                return new ComposeStackTrace(CollectionsKt.plus((Collection) listBuildTrace, listBuildStackTrace), operationErrorContext.getSourceInformationEnabled());
            case 9:
                ((AwaiterQueue$Awaiter) obj3).cancel();
                AtomicInt atomicInt = (AtomicInt) ((Request) obj2).headers;
                int i6 = ((Ref$IntRef) obj).element;
                do {
                    i = atomicInt.get();
                } while (!atomicInt.compareAndSet(i, ((i >>> 27) & 15) == i6 ? i - 1 : i));
                return Unit.INSTANCE;
            case 10:
                int i7 = LogcatActivity.$r8$clinit;
                JobKt.launch$default((CoroutineScope) obj3, null, new FilesActivity$showError$1((LogcatActivity) obj2, (LogFile) obj, objArr3 == true ? 1 : 0, i3), 3);
                return Unit.INSTANCE;
            case 11:
                JobKt.launch$default((CoroutineScope) obj3, null, new FilesActivity$showError$1((ConnectionInfo) obj2, objArr4 == true ? 1 : 0, 8), 3);
                ((MutableState) obj).setValue(null);
                return Unit.INSTANCE;
            case 12:
                ProfilesViewModel profilesViewModel = (ProfilesViewModel) obj3;
                JobKt.launch$default(ViewModelKt.getViewModelScope(profilesViewModel), null, new ProfilesViewModel$delete$1(profilesViewModel, (Profile) obj2, (Continuation) null), 3);
                ((MutableState) obj).setValue(null);
                return Unit.INSTANCE;
            default:
                ProxyScreenState proxyScreenState = (ProxyScreenState) obj3;
                Function0 function0 = (Function0) obj2;
                Function0 function1 = (Function0) obj;
                List list = proxyScreenState.groupNames;
                if (list.isEmpty() || !proxyScreenState.expandedGroups.containsAll(list)) {
                    function1.invoke();
                } else {
                    function0.invoke();
                }
                return Unit.INSTANCE;
        }
    }

    public /* synthetic */ GapComposer$$ExternalSyntheticLambda0(Object obj, Object obj2, Object obj3, Object obj4, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
    }
}
