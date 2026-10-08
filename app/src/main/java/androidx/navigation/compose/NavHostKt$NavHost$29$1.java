package androidx.navigation.compose;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import android.provider.DocumentsContract;
import android.util.Log;
import android.view.ScrollCaptureSession;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.MutatorMutex;
import androidx.compose.animation.core.SeekableTransitionState;
import androidx.compose.animation.core.SeekableTransitionState$snapTo$2;
import androidx.compose.animation.core.Transition;
import androidx.compose.foundation.gestures.TrackpadScrollingLogic;
import androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter;
import androidx.compose.foundation.text.input.internal.LegacyAdaptingPlatformTextInputModifierNode;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl;
import androidx.compose.foundation.text.selection.SelectionManager;
import androidx.compose.material3.BottomSheetKt$$ExternalSyntheticLambda13;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.internal.ripple.AndroidRippleNode;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.AndroidPlatformTextInputSession;
import androidx.compose.ui.platform.AndroidUriHandler;
import androidx.compose.ui.platform.ComposeViewContext;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2;
import androidx.compose.ui.platform.WrappedComposition;
import androidx.compose.ui.platform.WrappedComposition$setContent$1$2$1$1;
import androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.NavBackStackEntry;
import com.github.kr328.clash.PropertiesActivity;
import com.github.kr328.clash.ProvidersActivity;
import com.github.kr328.clash.UpdateChecker$check$2;
import com.github.kr328.clash.common.constants.Authorities;
import com.github.kr328.clash.compose.proxy.ProxyViewModel;
import com.github.kr328.clash.core.bridge.Bridge;
import com.github.kr328.clash.core.model.Provider;
import com.github.kr328.clash.remote.FilesClient;
import com.github.kr328.clash.service.ClashService;
import com.github.kr328.clash.service.FilesProvider;
import com.github.kr328.clash.service.clash.ClashRuntimeKt;
import com.github.kr328.clash.service.clash.ClashRuntimeKt$clashRuntime$1$launch$1$1$scope$1;
import com.github.kr328.clash.service.document.Document;
import com.github.kr328.clash.service.document.FileDocument;
import com.github.kr328.clash.service.document.Path;
import com.github.kr328.clash.service.document.Paths;
import com.github.kr328.clash.service.document.Picker;
import com.github.kr328.clash.service.model.Profile;
import com.github.kr328.clash.service.remote.IClashManagerDelegate;
import com.github.kr328.clash.service.remote.ILogObserver;
import com.github.kr328.clash.service.remote.IProfileManager;
import com.github.kr328.clash.util.ContentKt;
import java.io.File;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.NonCancellable;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class NavHostKt$NavHost$29$1 extends SuspendLambda implements Function2 {
    public Object $backStackEntry;
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object $transition;
    public Object $transitionState;
    public Object L$0;
    public int label;

    /* JADX INFO: renamed from: androidx.navigation.compose.NavHostKt$NavHost$29$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class AnonymousClass1 extends Lambda implements Function2 {
        public final /* synthetic */ Object $$this$LaunchedEffect;
        public final /* synthetic */ Object $backStackEntry;
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ Object $transitionState;

        /* JADX INFO: renamed from: androidx.navigation.compose.NavHostKt$NavHost$29$1$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
        public final class C00031 extends SuspendLambda implements Function2 {
            public final /* synthetic */ Object $backStackEntry;
            public final /* synthetic */ int $r8$classId = 0;
            public /* synthetic */ Object $transitionState;
            public float $value;
            public int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00031(float f, SeekableTransitionState seekableTransitionState, NavBackStackEntry navBackStackEntry, Continuation continuation) {
                super(2, continuation);
                this.$value = f;
                this.$transitionState = seekableTransitionState;
                this.$backStackEntry = navBackStackEntry;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                switch (this.$r8$classId) {
                    case 0:
                        return new C00031(this.$value, (SeekableTransitionState) this.$transitionState, (NavBackStackEntry) this.$backStackEntry, continuation);
                    case 1:
                        C00031 c00031 = new C00031((Transition) this.$backStackEntry, continuation);
                        c00031.$transitionState = obj;
                        return c00031;
                    default:
                        return new C00031((AndroidRippleNode) this.$transitionState, this.$value, (AnimationSpec) this.$backStackEntry, continuation);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                CoroutineScope coroutineScope = (CoroutineScope) obj;
                Continuation continuation = (Continuation) obj2;
                switch (this.$r8$classId) {
                    case 0:
                        break;
                    case 1:
                        break;
                }
                return ((C00031) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object objMutate$default;
                float durationScale;
                CoroutineScope coroutineScope;
                switch (this.$r8$classId) {
                    case 0:
                        SeekableTransitionState seekableTransitionState = (SeekableTransitionState) this.$transitionState;
                        float f = this.$value;
                        int i = this.label;
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (i != 0) {
                            if (i == 1) {
                                ResultKt.throwOnFailure(obj);
                            } else {
                                if (i != 2) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                            }
                            return Unit.INSTANCE;
                        }
                        ResultKt.throwOnFailure(obj);
                        if (f > 0.0f) {
                            this.label = 1;
                            if (seekableTransitionState.seekTo(f, seekableTransitionState.targetState$delegate.getValue(), this) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        }
                        if (f == 0.0f) {
                            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) this.$backStackEntry;
                            this.label = 2;
                            Transition transition = seekableTransitionState.transition;
                            if (transition == null) {
                                objMutate$default = Unit.INSTANCE;
                            } else if ((Intrinsics.areEqual(seekableTransitionState.currentState$delegate.getValue(), navBackStackEntry) && Intrinsics.areEqual(seekableTransitionState.targetState$delegate.getValue(), navBackStackEntry)) || (objMutate$default = MutatorMutex.mutate$default(seekableTransitionState.mutatorMutex, new SeekableTransitionState$snapTo$2(seekableTransitionState, navBackStackEntry, transition, (Continuation) null), this)) != coroutineSingletons) {
                                objMutate$default = Unit.INSTANCE;
                            }
                            if (objMutate$default == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        }
                        return Unit.INSTANCE;
                    case 1:
                        int i2 = this.label;
                        if (i2 == 0) {
                            ResultKt.throwOnFailure(obj);
                            CoroutineScope coroutineScope2 = (CoroutineScope) this.$transitionState;
                            durationScale = ArcSplineKt.getDurationScale(coroutineScope2.getCoroutineContext());
                            coroutineScope = coroutineScope2;
                        } else {
                            if (i2 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            durationScale = this.$value;
                            coroutineScope = (CoroutineScope) this.$transitionState;
                            ResultKt.throwOnFailure(obj);
                        }
                        while (JobKt.isActive(coroutineScope)) {
                            BottomSheetKt$$ExternalSyntheticLambda13 bottomSheetKt$$ExternalSyntheticLambda13 = new BottomSheetKt$$ExternalSyntheticLambda13((Transition) this.$backStackEntry, durationScale, 1);
                            this.$transitionState = coroutineScope;
                            this.$value = durationScale;
                            this.label = 1;
                            Object objWithFrameNanos = Stack.getMonotonicFrameClock(this._context).withFrameNanos(bottomSheetKt$$ExternalSyntheticLambda13, this);
                            CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                            if (objWithFrameNanos == coroutineSingletons2) {
                                return coroutineSingletons2;
                            }
                        }
                        return Unit.INSTANCE;
                    default:
                        int i3 = this.label;
                        if (i3 == 0) {
                            ResultKt.throwOnFailure(obj);
                            Animatable animatable = ((AndroidRippleNode) this.$transitionState).animatedAlpha;
                            Float f2 = new Float(this.$value);
                            AnimationSpec animationSpec = (AnimationSpec) this.$backStackEntry;
                            this.label = 1;
                            Object objAnimateTo$default = Animatable.animateTo$default(animatable, f2, animationSpec, null, this, 12);
                            CoroutineSingletons coroutineSingletons3 = CoroutineSingletons.COROUTINE_SUSPENDED;
                            if (objAnimateTo$default == coroutineSingletons3) {
                                return coroutineSingletons3;
                            }
                        } else {
                            if (i3 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00031(Transition transition, Continuation continuation) {
                super(2, continuation);
                this.$backStackEntry = transition;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00031(AndroidRippleNode androidRippleNode, float f, AnimationSpec animationSpec, Continuation continuation) {
                super(2, continuation);
                this.$transitionState = androidRippleNode;
                this.$value = f;
                this.$backStackEntry = animationSpec;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(NavBackStackEntry navBackStackEntry, SaveableStateHolder saveableStateHolder, ComposableLambdaImpl composableLambdaImpl, int i) {
            super(2);
            this.$r8$classId = 4;
            this.$backStackEntry = navBackStackEntry;
            this.$$this$LaunchedEffect = saveableStateHolder;
            this.$transitionState = composableLambdaImpl;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            switch (this.$r8$classId) {
                case 0:
                    float fFloatValue = ((Number) obj).floatValue();
                    ((Number) obj2).floatValue();
                    JobKt.launch$default((CoroutineScope) this.$$this$LaunchedEffect, null, new C00031(fFloatValue, (SeekableTransitionState) this.$transitionState, (NavBackStackEntry) this.$backStackEntry, (Continuation) null), 3);
                    break;
                case 1:
                    ((Number) obj2).intValue();
                    CompositionLocalsKt.ProvideCommonCompositionLocals((Owner) this.$$this$LaunchedEffect, (AndroidUriHandler) this.$transitionState, (Function2) this.$backStackEntry, (GapComposer) obj, Stack.updateChangedFlags(1));
                    break;
                case 2:
                    GapComposer gapComposer = (GapComposer) obj;
                    int iIntValue = ((Number) obj2).intValue();
                    WrappedComposition wrappedComposition = (WrappedComposition) this.$$this$LaunchedEffect;
                    if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                        AndroidComposeView androidComposeView = wrappedComposition.owner;
                        boolean zChangedInstance = gapComposer.changedInstance(wrappedComposition);
                        Object objRememberedValue = gapComposer.rememberedValue();
                        Continuation continuation = null;
                        NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
                        if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = new WrappedComposition$setContent$1$2$1$1(wrappedComposition, continuation, 0);
                            gapComposer.updateRememberedValue(objRememberedValue);
                        }
                        Stack.LaunchedEffect(gapComposer, androidComposeView, (Function2) objRememberedValue);
                        boolean zChangedInstance2 = gapComposer.changedInstance(wrappedComposition);
                        Object objRememberedValue2 = gapComposer.rememberedValue();
                        if (zChangedInstance2 || objRememberedValue2 == neverEqualPolicy) {
                            objRememberedValue2 = new WrappedComposition$setContent$1$2$1$1(wrappedComposition, continuation, 1);
                            gapComposer.updateRememberedValue(objRememberedValue2);
                        }
                        Stack.LaunchedEffect(gapComposer, androidComposeView, (Function2) objRememberedValue2);
                        ((ComposeViewContext) this.$transitionState).ProvideCompositionLocals$ui(androidComposeView, (Function2) this.$backStackEntry, gapComposer, 0);
                    } else {
                        gapComposer.skipToGroupEnd();
                    }
                    break;
                case 3:
                    ((Number) obj2).intValue();
                    AndroidDialog_androidKt.Dialog((Function0) this.$$this$LaunchedEffect, (DialogProperties) this.$transitionState, (ComposableLambdaImpl) this.$backStackEntry, (GapComposer) obj, Stack.updateChangedFlags(385));
                    break;
                default:
                    ((Number) obj2).intValue();
                    NavBackStackEntryProviderKt.LocalOwnersProvider((NavBackStackEntry) this.$backStackEntry, (SaveableStateHolder) this.$$this$LaunchedEffect, (ComposableLambdaImpl) this.$transitionState, (GapComposer) obj, Stack.updateChangedFlags(385));
                    break;
            }
            return Unit.INSTANCE;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(Object obj, Object obj2, Object obj3, int i) {
            super(2);
            this.$r8$classId = i;
            this.$$this$LaunchedEffect = obj;
            this.$transitionState = obj2;
            this.$backStackEntry = obj3;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(Object obj, Object obj2, Function2 function2, int i, int i2) {
            super(2);
            this.$r8$classId = i2;
            this.$$this$LaunchedEffect = obj;
            this.$transitionState = obj2;
            this.$backStackEntry = function2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NavHostKt$NavHost$29$1(PlatformSelectionBehaviorsImpl platformSelectionBehaviorsImpl, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = 5;
        this.$backStackEntry = platformSelectionBehaviorsImpl;
        this.$transition = (SuspendLambda) function2;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0087  */
    /* JADX WARN: Code duplicated, block: B:31:0x0089 A[Catch: Exception -> 0x0021, PHI: r4 r11
      0x0089: PHI (r4v3 com.github.kr328.clash.core.model.TunnelState$Mode) = (r4v2 com.github.kr328.clash.core.model.TunnelState$Mode), (r4v5 com.github.kr328.clash.core.model.TunnelState$Mode) binds: [B:29:0x0085, B:21:0x0056] A[DONT_GENERATE, DONT_INLINE]
      0x0089: PHI (r11v11 java.lang.Object) = (r11v10 java.lang.Object), (r11v0 java.lang.Object) binds: [B:29:0x0085, B:21:0x0056] A[DONT_GENERATE, DONT_INLINE], TryCatch #1 {Exception -> 0x0021, blocks: (B:6:0x001c, B:59:0x0130, B:61:0x014b, B:63:0x0152, B:62:0x014e, B:64:0x015c, B:65:0x0161, B:16:0x0044, B:17:0x0049, B:49:0x00d5, B:51:0x00e3, B:66:0x0162, B:18:0x004e, B:43:0x00ad, B:45:0x00bf, B:46:0x00c5, B:21:0x0056, B:31:0x0089, B:34:0x008e, B:36:0x0094, B:37:0x0097, B:39:0x009d, B:40:0x00a0, B:22:0x005a, B:28:0x0072, B:25:0x0061, B:11:0x0030, B:58:0x0109, B:55:0x00f9), top: B:75:0x0011, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x008d  */
    /* JADX WARN: Code duplicated, block: B:36:0x0094 A[Catch: Exception -> 0x0021, TryCatch #1 {Exception -> 0x0021, blocks: (B:6:0x001c, B:59:0x0130, B:61:0x014b, B:63:0x0152, B:62:0x014e, B:64:0x015c, B:65:0x0161, B:16:0x0044, B:17:0x0049, B:49:0x00d5, B:51:0x00e3, B:66:0x0162, B:18:0x004e, B:43:0x00ad, B:45:0x00bf, B:46:0x00c5, B:21:0x0056, B:31:0x0089, B:34:0x008e, B:36:0x0094, B:37:0x0097, B:39:0x009d, B:40:0x00a0, B:22:0x005a, B:28:0x0072, B:25:0x0061, B:11:0x0030, B:58:0x0109, B:55:0x00f9), top: B:75:0x0011, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x009d A[Catch: Exception -> 0x0021, TryCatch #1 {Exception -> 0x0021, blocks: (B:6:0x001c, B:59:0x0130, B:61:0x014b, B:63:0x0152, B:62:0x014e, B:64:0x015c, B:65:0x0161, B:16:0x0044, B:17:0x0049, B:49:0x00d5, B:51:0x00e3, B:66:0x0162, B:18:0x004e, B:43:0x00ad, B:45:0x00bf, B:46:0x00c5, B:21:0x0056, B:31:0x0089, B:34:0x008e, B:36:0x0094, B:37:0x0097, B:39:0x009d, B:40:0x00a0, B:22:0x005a, B:28:0x0072, B:25:0x0061, B:11:0x0030, B:58:0x0109, B:55:0x00f9), top: B:75:0x0011, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:43:0x00ad A[Catch: Exception -> 0x0021, PHI: r11
      0x00ad: PHI (r11v17 java.lang.Object) = (r11v15 java.lang.Object), (r11v0 java.lang.Object) binds: [B:41:0x00a9, B:18:0x004e] A[DONT_GENERATE, DONT_INLINE], TryCatch #1 {Exception -> 0x0021, blocks: (B:6:0x001c, B:59:0x0130, B:61:0x014b, B:63:0x0152, B:62:0x014e, B:64:0x015c, B:65:0x0161, B:16:0x0044, B:17:0x0049, B:49:0x00d5, B:51:0x00e3, B:66:0x0162, B:18:0x004e, B:43:0x00ad, B:45:0x00bf, B:46:0x00c5, B:21:0x0056, B:31:0x0089, B:34:0x008e, B:36:0x0094, B:37:0x0097, B:39:0x009d, B:40:0x00a0, B:22:0x005a, B:28:0x0072, B:25:0x0061, B:11:0x0030, B:58:0x0109, B:55:0x00f9), top: B:75:0x0011, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00bf A[Catch: Exception -> 0x0021, TryCatch #1 {Exception -> 0x0021, blocks: (B:6:0x001c, B:59:0x0130, B:61:0x014b, B:63:0x0152, B:62:0x014e, B:64:0x015c, B:65:0x0161, B:16:0x0044, B:17:0x0049, B:49:0x00d5, B:51:0x00e3, B:66:0x0162, B:18:0x004e, B:43:0x00ad, B:45:0x00bf, B:46:0x00c5, B:21:0x0056, B:31:0x0089, B:34:0x008e, B:36:0x0094, B:37:0x0097, B:39:0x009d, B:40:0x00a0, B:22:0x005a, B:28:0x0072, B:25:0x0061, B:11:0x0030, B:58:0x0109, B:55:0x00f9), top: B:75:0x0011, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:49:0x00d5 A[Catch: Exception -> 0x0021, PHI: r11
      0x00d5: PHI (r11v21 java.lang.Object) = (r11v20 java.lang.Object), (r11v0 java.lang.Object) binds: [B:47:0x00d1, B:17:0x0049] A[DONT_GENERATE, DONT_INLINE], TryCatch #1 {Exception -> 0x0021, blocks: (B:6:0x001c, B:59:0x0130, B:61:0x014b, B:63:0x0152, B:62:0x014e, B:64:0x015c, B:65:0x0161, B:16:0x0044, B:17:0x0049, B:49:0x00d5, B:51:0x00e3, B:66:0x0162, B:18:0x004e, B:43:0x00ad, B:45:0x00bf, B:46:0x00c5, B:21:0x0056, B:31:0x0089, B:34:0x008e, B:36:0x0094, B:37:0x0097, B:39:0x009d, B:40:0x00a0, B:22:0x005a, B:28:0x0072, B:25:0x0061, B:11:0x0030, B:58:0x0109, B:55:0x00f9), top: B:75:0x0011, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00e3 A[Catch: Exception -> 0x0021, TRY_LEAVE, TryCatch #1 {Exception -> 0x0021, blocks: (B:6:0x001c, B:59:0x0130, B:61:0x014b, B:63:0x0152, B:62:0x014e, B:64:0x015c, B:65:0x0161, B:16:0x0044, B:17:0x0049, B:49:0x00d5, B:51:0x00e3, B:66:0x0162, B:18:0x004e, B:43:0x00ad, B:45:0x00bf, B:46:0x00c5, B:21:0x0056, B:31:0x0089, B:34:0x008e, B:36:0x0094, B:37:0x0097, B:39:0x009d, B:40:0x00a0, B:22:0x005a, B:28:0x0072, B:25:0x0061, B:11:0x0030, B:58:0x0109, B:55:0x00f9), top: B:75:0x0011, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:57:0x0108  */
    /* JADX WARN: Code duplicated, block: B:61:0x014b A[Catch: Exception -> 0x0021, TryCatch #1 {Exception -> 0x0021, blocks: (B:6:0x001c, B:59:0x0130, B:61:0x014b, B:63:0x0152, B:62:0x014e, B:64:0x015c, B:65:0x0161, B:16:0x0044, B:17:0x0049, B:49:0x00d5, B:51:0x00e3, B:66:0x0162, B:18:0x004e, B:43:0x00ad, B:45:0x00bf, B:46:0x00c5, B:21:0x0056, B:31:0x0089, B:34:0x008e, B:36:0x0094, B:37:0x0097, B:39:0x009d, B:40:0x00a0, B:22:0x005a, B:28:0x0072, B:25:0x0061, B:11:0x0030, B:58:0x0109, B:55:0x00f9), top: B:75:0x0011, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x014e A[Catch: Exception -> 0x0021, TryCatch #1 {Exception -> 0x0021, blocks: (B:6:0x001c, B:59:0x0130, B:61:0x014b, B:63:0x0152, B:62:0x014e, B:64:0x015c, B:65:0x0161, B:16:0x0044, B:17:0x0049, B:49:0x00d5, B:51:0x00e3, B:66:0x0162, B:18:0x004e, B:43:0x00ad, B:45:0x00bf, B:46:0x00c5, B:21:0x0056, B:31:0x0089, B:34:0x008e, B:36:0x0094, B:37:0x0097, B:39:0x009d, B:40:0x00a0, B:22:0x005a, B:28:0x0072, B:25:0x0061, B:11:0x0030, B:58:0x0109, B:55:0x00f9), top: B:75:0x0011, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x0162 A[Catch: Exception -> 0x0021, TRY_LEAVE, TryCatch #1 {Exception -> 0x0021, blocks: (B:6:0x001c, B:59:0x0130, B:61:0x014b, B:63:0x0152, B:62:0x014e, B:64:0x015c, B:65:0x0161, B:16:0x0044, B:17:0x0049, B:49:0x00d5, B:51:0x00e3, B:66:0x0162, B:18:0x004e, B:43:0x00ad, B:45:0x00bf, B:46:0x00c5, B:21:0x0056, B:31:0x0089, B:34:0x008e, B:36:0x0094, B:37:0x0097, B:39:0x009d, B:40:0x00a0, B:22:0x005a, B:28:0x0072, B:25:0x0061, B:11:0x0030, B:58:0x0109, B:55:0x00f9), top: B:75:0x0011, inners: #0 }] */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0169, code lost:
    
        if (com.github.kr328.clash.compose.proxy.ProxyViewModel.access$reloadAllGroups(r0, r10) == r8) goto L68;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [kotlinx.coroutines.flow.StateFlowImpl] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object invokeSuspend$com$github$kr328$clash$compose$proxy$ProxyViewModel$reload$1(java.lang.Object r11) {
        /*
            Method dump skipped, instruction units count: 410
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.NavHostKt$NavHost$29$1.invokeSuspend$com$github$kr328$clash$compose$proxy$ProxyViewModel$reload$1(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x005a, code lost:
    
        if (com.github.kr328.clash.compose.proxy.ProxyViewModel.access$reloadGroup(r3, r1, r9) == r7) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object invokeSuspend$com$github$kr328$clash$compose$proxy$ProxyViewModel$testProxy$1(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = r9.$transition
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r1 = r9.$transitionState
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r9.$backStackEntry
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r3 = r9.L$0
            com.github.kr328.clash.compose.proxy.ProxyViewModel r3 = (com.github.kr328.clash.compose.proxy.ProxyViewModel) r3
            int r4 = r9.label
            r5 = 2
            r6 = 1
            kotlin.coroutines.intrinsics.CoroutineSingletons r7 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r4 == 0) goto L2e
            if (r4 == r6) goto L2a
            if (r4 != r5) goto L22
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L99
            goto L5d
        L20:
            r10 = move-exception
            goto L84
        L22:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L2a:
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L99
            goto L54
        L2e:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlinx.coroutines.flow.StateFlowImpl r10 = r3._testingNodes
        L33:
            java.lang.Object r4 = r10.getValue()
            r8 = r4
            java.util.Set r8 = (java.util.Set) r8
            java.util.LinkedHashSet r8 = kotlin.collections.SetsKt.plus(r8, r2)
            boolean r4 = r10.compareAndSet(r4, r8)
            if (r4 == 0) goto L33
            com.github.kr328.clash.compose.proxy.ProxyViewModel$testProxy$1$2 r10 = new com.github.kr328.clash.compose.proxy.ProxyViewModel$testProxy$1$2     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L99
            r4 = 0
            r8 = 0
            r10.<init>(r1, r0, r8, r4)     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L99
            r9.label = r6     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L99
            java.lang.Object r10 = com.github.kr328.clash.util.RemoteKt.withClash$default(r10, r9)     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L99
            if (r10 != r7) goto L54
            goto L5c
        L54:
            r9.label = r5     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L99
            java.lang.Object r10 = com.github.kr328.clash.compose.proxy.ProxyViewModel.access$reloadGroup(r3, r1, r9)     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L99
            if (r10 != r7) goto L5d
        L5c:
            return r7
        L5d:
            kotlinx.coroutines.flow.StateFlowImpl r10 = r3._testedProxies     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L99
        L5f:
            java.lang.Object r1 = r10.getValue()     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L99
            r4 = r1
            java.util.Set r4 = (java.util.Set) r4     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L99
            java.util.LinkedHashSet r4 = kotlin.collections.SetsKt.plus(r4, r0)     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L99
            boolean r1 = r10.compareAndSet(r1, r4)     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L99
            if (r1 == 0) goto L5f
            kotlinx.coroutines.flow.StateFlowImpl r1 = r3._testingNodes
        L72:
            java.lang.Object r10 = r1.getValue()
            r0 = r10
            java.util.Set r0 = (java.util.Set) r0
            java.util.LinkedHashSet r0 = kotlin.collections.SetsKt.minus(r0, r2)
            boolean r10 = r1.compareAndSet(r10, r0)
            if (r10 == 0) goto L72
            goto Lac
        L84:
            kotlinx.coroutines.flow.StateFlowImpl r0 = r3._testingNodes
        L86:
            java.lang.Object r1 = r0.getValue()
            r3 = r1
            java.util.Set r3 = (java.util.Set) r3
            java.util.LinkedHashSet r3 = kotlin.collections.SetsKt.minus(r3, r2)
            boolean r1 = r0.compareAndSet(r1, r3)
            if (r1 != 0) goto L98
            goto L86
        L98:
            throw r10
        L99:
            kotlinx.coroutines.flow.StateFlowImpl r4 = r3._testingNodes
        L9b:
            java.lang.Object r10 = r4.getValue()
            r0 = r10
            java.util.Set r0 = (java.util.Set) r0
            java.util.LinkedHashSet r0 = kotlin.collections.SetsKt.minus(r0, r2)
            boolean r10 = r4.compareAndSet(r10, r0)
            if (r10 == 0) goto L9b
        Lac:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.NavHostKt$NavHost$29$1.invokeSuspend$com$github$kr328$clash$compose$proxy$ProxyViewModel$testProxy$1(java.lang.Object):java.lang.Object");
    }

    private final Object invokeSuspend$com$github$kr328$clash$remote$FilesClient$importDocument$2(Object obj) {
        FilesClient filesClient = (FilesClient) this.L$0;
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String str = ((String) this.$transitionState) + "/" + ((String) this.$backStackEntry);
            filesClient.getClass();
            Uri uriBuildDocumentUri = DocumentsContract.buildDocumentUri(Authorities.FILES_PROVIDER, str);
            ContentResolver contentResolver = filesClient.context.getContentResolver();
            Uri uri = (Uri) this.$transition;
            this.label = 1;
            Object objCopyContentTo = ContentKt.copyContentTo(contentResolver, uri, uriBuildDocumentUri, this);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objCopyContentTo == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004e A[Catch: all -> 0x003c, Exception -> 0x003e, CancellationException -> 0x00ae, TryCatch #3 {CancellationException -> 0x00ae, Exception -> 0x003e, blocks: (B:14:0x0038, B:26:0x0060, B:21:0x0048, B:23:0x004e), top: B:46:0x0038, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x005f  */
    /* JADX WARN: Code duplicated, block: B:26:0x0060 A[Catch: all -> 0x003c, Exception -> 0x003e, CancellationException -> 0x00ae, PHI: r1 r9 r11
      0x0060: PHI (r1v8 com.github.kr328.clash.service.remote.ILogObserver) = (r1v7 com.github.kr328.clash.service.remote.ILogObserver), (r1v10 com.github.kr328.clash.service.remote.ILogObserver) binds: [B:24:0x005d, B:14:0x0038] A[DONT_GENERATE, DONT_INLINE]
      0x0060: PHI (r9v2 kotlinx.coroutines.CoroutineScope) = (r9v1 kotlinx.coroutines.CoroutineScope), (r9v4 kotlinx.coroutines.CoroutineScope) binds: [B:24:0x005d, B:14:0x0038] A[DONT_GENERATE, DONT_INLINE]
      0x0060: PHI (r11v14 java.lang.Object) = (r11v13 java.lang.Object), (r11v0 java.lang.Object) binds: [B:24:0x005d, B:14:0x0038] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #3 {CancellationException -> 0x00ae, Exception -> 0x003e, blocks: (B:14:0x0038, B:26:0x0060, B:21:0x0048, B:23:0x004e), top: B:46:0x0038, outer: #2 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x005d -> B:26:0x0060). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private final java.lang.Object invokeSuspend$com$github$kr328$clash$service$ClashManager$setLogObserver$1$2$1(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = r10.$transition
            kotlinx.coroutines.channels.BufferedChannel r0 = (kotlinx.coroutines.channels.BufferedChannel) r0
            int r1 = r10.label
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            kotlin.coroutines.intrinsics.CoroutineSingletons r8 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r1 == 0) goto L40
            if (r1 == r6) goto L30
            if (r1 == r5) goto L2b
            if (r1 == r4) goto L2b
            if (r1 == r3) goto L2b
            if (r1 == r2) goto L22
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L22:
            java.lang.Object r0 = r10.L$0
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            kotlin.ResultKt.throwOnFailure(r11)
            goto Lad
        L2b:
            kotlin.ResultKt.throwOnFailure(r11)
            goto Lc3
        L30:
            java.lang.Object r1 = r10.$transitionState
            com.github.kr328.clash.service.remote.ILogObserver r1 = (com.github.kr328.clash.service.remote.ILogObserver) r1
            java.lang.Object r9 = r10.L$0
            kotlinx.coroutines.CoroutineScope r9 = (kotlinx.coroutines.CoroutineScope) r9
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e java.util.concurrent.CancellationException -> Lae
            goto L60
        L3c:
            r11 = move-exception
            goto L97
        L3e:
            r11 = move-exception
            goto L7b
        L40:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.Object r11 = r10.L$0
            kotlinx.coroutines.CoroutineScope r11 = (kotlinx.coroutines.CoroutineScope) r11
            r9 = r11
        L48:
            boolean r11 = kotlinx.coroutines.JobKt.isActive(r9)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e java.util.concurrent.CancellationException -> Lae
            if (r11 == 0) goto L66
            java.lang.Object r11 = r10.$backStackEntry     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e java.util.concurrent.CancellationException -> Lae
            r1 = r11
            com.github.kr328.clash.service.remote.ILogObserver r1 = (com.github.kr328.clash.service.remote.ILogObserver) r1     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e java.util.concurrent.CancellationException -> Lae
            r10.L$0 = r9     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e java.util.concurrent.CancellationException -> Lae
            r10.$transitionState = r1     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e java.util.concurrent.CancellationException -> Lae
            r10.label = r6     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e java.util.concurrent.CancellationException -> Lae
            java.lang.Object r11 = r0.receive(r10)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e java.util.concurrent.CancellationException -> Lae
            if (r11 != r8) goto L60
            goto Lc2
        L60:
            com.github.kr328.clash.core.model.LogMessage r11 = (com.github.kr328.clash.core.model.LogMessage) r11     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e java.util.concurrent.CancellationException -> Lae
            r1.newItem(r11)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e java.util.concurrent.CancellationException -> Lae
            goto L48
        L66:
            kotlinx.coroutines.NonCancellable r11 = kotlinx.coroutines.NonCancellable.INSTANCE
            coil.disk.DiskLruCache$launchCleanup$1 r1 = new coil.disk.DiskLruCache$launchCleanup$1
            r2 = 7
            r1.<init>(r0, r7, r2)
            r10.L$0 = r7
            r10.$transitionState = r7
            r10.label = r5
            java.lang.Object r11 = kotlinx.coroutines.JobKt.withContext(r11, r1, r10)
            if (r11 != r8) goto Lc3
            goto Lc2
        L7b:
            java.lang.String r1 = "UI crashed"
            java.lang.String r4 = "KoalaClash"
            android.util.Log.w(r4, r1, r11)     // Catch: java.lang.Throwable -> L3c
            kotlinx.coroutines.NonCancellable r11 = kotlinx.coroutines.NonCancellable.INSTANCE
            coil.disk.DiskLruCache$launchCleanup$1 r1 = new coil.disk.DiskLruCache$launchCleanup$1
            r2 = 7
            r1.<init>(r0, r7, r2)
            r10.L$0 = r7
            r10.$transitionState = r7
            r10.label = r3
            java.lang.Object r11 = kotlinx.coroutines.JobKt.withContext(r11, r1, r10)
            if (r11 != r8) goto Lc3
            goto Lc2
        L97:
            kotlinx.coroutines.NonCancellable r1 = kotlinx.coroutines.NonCancellable.INSTANCE
            coil.disk.DiskLruCache$launchCleanup$1 r3 = new coil.disk.DiskLruCache$launchCleanup$1
            r4 = 7
            r3.<init>(r0, r7, r4)
            r10.L$0 = r11
            r10.$transitionState = r7
            r10.label = r2
            java.lang.Object r0 = kotlinx.coroutines.JobKt.withContext(r1, r3, r10)
            if (r0 != r8) goto Lac
            goto Lc2
        Lac:
            r0 = r11
        Lad:
            throw r0
        Lae:
            kotlinx.coroutines.NonCancellable r11 = kotlinx.coroutines.NonCancellable.INSTANCE
            coil.disk.DiskLruCache$launchCleanup$1 r1 = new coil.disk.DiskLruCache$launchCleanup$1
            r2 = 7
            r1.<init>(r0, r7, r2)
            r10.L$0 = r7
            r10.$transitionState = r7
            r10.label = r4
            java.lang.Object r11 = kotlinx.coroutines.JobKt.withContext(r11, r1, r10)
            if (r11 != r8) goto Lc3
        Lc2:
            return r8
        Lc3:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.NavHostKt$NavHost$29$1.invokeSuspend$com$github$kr328$clash$service$ClashManager$setLogObserver$1$2$1(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00a0 A[Catch: all -> 0x0040, Exception -> 0x0043, PHI: r1 r9 r10
      0x00a0: PHI (r1v15 com.github.kr328.clash.service.clash.module.NetworkObserveModule) = 
      (r1v9 com.github.kr328.clash.service.clash.module.NetworkObserveModule)
      (r1v16 com.github.kr328.clash.service.clash.module.NetworkObserveModule)
     binds: [B:23:0x0084, B:30:0x00f0] A[DONT_GENERATE, DONT_INLINE]
      0x00a0: PHI (r9v3 com.github.kr328.clash.service.clash.module.ConfigurationModule) = 
      (r9v2 com.github.kr328.clash.service.clash.module.ConfigurationModule)
      (r9v4 com.github.kr328.clash.service.clash.module.ConfigurationModule)
     binds: [B:23:0x0084, B:30:0x00f0] A[DONT_GENERATE, DONT_INLINE]
      0x00a0: PHI (r10v2 com.github.kr328.clash.service.clash.module.CloseModule) = 
      (r10v1 com.github.kr328.clash.service.clash.module.CloseModule)
      (r10v3 com.github.kr328.clash.service.clash.module.CloseModule)
     binds: [B:23:0x0084, B:30:0x00f0] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #1 {Exception -> 0x0043, blocks: (B:13:0x003b, B:29:0x00ea, B:24:0x00a0, B:26:0x00a6), top: B:46:0x003b, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x00a6 A[Catch: all -> 0x0040, Exception -> 0x0043, TryCatch #1 {Exception -> 0x0043, blocks: (B:13:0x003b, B:29:0x00ea, B:24:0x00a0, B:26:0x00a6), top: B:46:0x003b, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:29:0x00ea A[Catch: all -> 0x0040, Exception -> 0x0043, PHI: r1 r9 r10 r15
      0x00ea: PHI (r1v16 com.github.kr328.clash.service.clash.module.NetworkObserveModule) = 
      (r1v15 com.github.kr328.clash.service.clash.module.NetworkObserveModule)
      (r1v18 com.github.kr328.clash.service.clash.module.NetworkObserveModule)
     binds: [B:27:0x00e7, B:13:0x003b] A[DONT_GENERATE, DONT_INLINE]
      0x00ea: PHI (r9v4 com.github.kr328.clash.service.clash.module.ConfigurationModule) = 
      (r9v3 com.github.kr328.clash.service.clash.module.ConfigurationModule)
      (r9v6 com.github.kr328.clash.service.clash.module.ConfigurationModule)
     binds: [B:27:0x00e7, B:13:0x003b] A[DONT_GENERATE, DONT_INLINE]
      0x00ea: PHI (r10v3 com.github.kr328.clash.service.clash.module.CloseModule) = 
      (r10v2 com.github.kr328.clash.service.clash.module.CloseModule)
      (r10v5 com.github.kr328.clash.service.clash.module.CloseModule)
     binds: [B:27:0x00e7, B:13:0x003b] A[DONT_GENERATE, DONT_INLINE]
      0x00ea: PHI (r15v13 java.lang.Object) = (r15v12 java.lang.Object), (r15v0 java.lang.Object) binds: [B:27:0x00e7, B:13:0x003b] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #1 {Exception -> 0x0043, blocks: (B:13:0x003b, B:29:0x00ea, B:24:0x00a0, B:26:0x00a6), top: B:46:0x003b, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x00f2  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00e7 -> B:29:0x00ea). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private final java.lang.Object invokeSuspend$com$github$kr328$clash$service$ClashService$runtime$1(java.lang.Object r15) {
        /*
            Method dump skipped, instruction units count: 345
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.NavHostKt$NavHost$29$1.invokeSuspend$com$github$kr328$clash$service$ClashService$runtime$1(java.lang.Object):java.lang.Object");
    }

    private final Object invokeSuspend$com$github$kr328$clash$service$FilesProvider$renameDocument$1(Object obj) {
        Path path;
        String str = (String) this.$transition;
        String str2 = (String) this.$transitionState;
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Path pathResolve = Paths.resolve(str2 == null ? "/" : str2);
            if (pathResolve.relative == null) {
                throw new IllegalArgumentException(CaptureSession$State$EnumUnboxingLocalUtility.m("unable to rename ", str2));
            }
            Picker picker = (Picker) ((FilesProvider) this.$backStackEntry).picker$delegate.getValue();
            this.L$0 = pathResolve;
            this.label = 1;
            Object objPick = picker.pick(pathResolve, true, this);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objPick == coroutineSingletons) {
                return coroutineSingletons;
            }
            path = pathResolve;
            obj = objPick;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            path = (Path) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        Document document = (Document) obj;
        if (!(document instanceof FileDocument)) {
            throw new IllegalArgumentException("unable to rename " + document);
        }
        File file = ((FileDocument) document).file;
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            file.renameTo(FilesKt.resolve(parentFile, str));
            return Path.copy$default(path, null, null, CollectionsKt.plus(CollectionsKt.dropLast(path.relative), str), 3).toString();
        }
        throw new IllegalArgumentException("unable to rename " + document);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:49:0x00e2  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v5 */
    private final Object invokeSuspend$com$github$kr328$clash$service$clash$ClashRuntimeKt$clashRuntime$1$launch$1(Object obj) throws Throwable {
        CoroutineScope coroutineScope;
        Mutex mutex;
        ?? r0;
        Mutex mutex2;
        CoroutineScope coroutineScope2;
        Throwable th;
        NonCancellable nonCancellable;
        UpdateChecker$check$2 updateChecker$check$2;
        NonCancellable nonCancellable2;
        UpdateChecker$check$2 updateChecker$check$3;
        Mutex mutex3;
        int i = this.label;
        ?? r1 = 9;
        char c = '\t';
        char c2 = '\t';
        int i2 = 2;
        Continuation continuation = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        coroutineScope = (CoroutineScope) this.$backStackEntry;
                        MutexImpl mutexImpl = ClashRuntimeKt.globalLock;
                        SuspendLambda suspendLambda = (SuspendLambda) this.$transition;
                        this.$backStackEntry = coroutineScope;
                        this.L$0 = mutexImpl;
                        this.$transitionState = suspendLambda;
                        this.label = 1;
                        if (mutexImpl.lock(this) != coroutineSingletons) {
                            mutex = mutexImpl;
                            r0 = suspendLambda;
                        }
                        return coroutineSingletons;
                    }
                    if (i != 1) {
                        if (i == 2) {
                            mutex2 = (Mutex) this.L$0;
                            coroutineScope2 = (CoroutineScope) this.$backStackEntry;
                            try {
                                ResultKt.throwOnFailure(obj);
                                JobKt.cancel(coroutineScope2, (CancellationException) null);
                                try {
                                    nonCancellable2 = NonCancellable.INSTANCE;
                                    updateChecker$check$3 = new UpdateChecker$check$2(i2, continuation, c2);
                                    this.$backStackEntry = mutex2;
                                    this.L$0 = null;
                                    this.label = 3;
                                    if (JobKt.withContext(nonCancellable2, updateChecker$check$3, this) != coroutineSingletons) {
                                        mutex3 = mutex2;
                                    }
                                    return coroutineSingletons;
                                } catch (Throwable th2) {
                                    th = th2;
                                    r1 = mutex2;
                                    ((MutexImpl) r1).unlock(null);
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                mutex = mutex2;
                                th = th;
                                nonCancellable = NonCancellable.INSTANCE;
                                updateChecker$check$2 = new UpdateChecker$check$2(i2, continuation, c);
                                this.$backStackEntry = mutex;
                                this.L$0 = th;
                                this.$transitionState = null;
                                this.label = 4;
                                if (JobKt.withContext(nonCancellable, updateChecker$check$2, this) != coroutineSingletons) {
                                    throw th;
                                }
                            }
                        } else {
                            if (i != 3) {
                                if (i != 4) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                Throwable th4 = (Throwable) this.L$0;
                                ResultKt.throwOnFailure(obj);
                                throw th4;
                            }
                            mutex3 = (Mutex) this.$backStackEntry;
                            ResultKt.throwOnFailure(obj);
                        }
                        Unit unit = Unit.INSTANCE;
                        ((MutexImpl) mutex3).unlock(null);
                        return Unit.INSTANCE;
                    }
                    Function2 function2 = (Function2) ((SuspendLambda) this.$transitionState);
                    mutex = (Mutex) this.L$0;
                    CoroutineScope coroutineScope3 = (CoroutineScope) this.$backStackEntry;
                    ResultKt.throwOnFailure(obj);
                    coroutineScope = coroutineScope3;
                    r0 = function2;
                    ArrayList arrayList = new ArrayList();
                    Bridge bridge = Bridge.INSTANCE;
                    bridge.nativeReset();
                    bridge.nativeWriteOverrideMode("");
                    ClashRuntimeKt$clashRuntime$1$launch$1$1$scope$1 clashRuntimeKt$clashRuntime$1$launch$1$1$scope$1 = new ClashRuntimeKt$clashRuntime$1$launch$1$1$scope$1(coroutineScope, arrayList);
                    this.$backStackEntry = coroutineScope;
                    this.L$0 = mutex;
                    this.$transitionState = null;
                    this.label = 2;
                    if (r0.invoke(clashRuntimeKt$clashRuntime$1$launch$1$1$scope$1, this) != coroutineSingletons) {
                        mutex2 = mutex;
                        coroutineScope2 = coroutineScope;
                        JobKt.cancel(coroutineScope2, (CancellationException) null);
                        nonCancellable2 = NonCancellable.INSTANCE;
                        updateChecker$check$3 = new UpdateChecker$check$2(i2, continuation, c2);
                        this.$backStackEntry = mutex2;
                        this.L$0 = null;
                        this.label = 3;
                        if (JobKt.withContext(nonCancellable2, updateChecker$check$3, this) != coroutineSingletons) {
                            mutex3 = mutex2;
                            Unit unit2 = Unit.INSTANCE;
                            ((MutexImpl) mutex3).unlock(null);
                            return Unit.INSTANCE;
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    th = th;
                    nonCancellable = NonCancellable.INSTANCE;
                    updateChecker$check$2 = new UpdateChecker$check$2(i2, continuation, c);
                    this.$backStackEntry = mutex;
                    this.L$0 = th;
                    this.$transitionState = null;
                    this.label = 4;
                    if (JobKt.withContext(nonCancellable, updateChecker$check$2, this) != coroutineSingletons) {
                        throw th;
                    }
                }
                Log.d("KoalaClash", "ClashRuntime: initialize", null);
                return coroutineSingletons;
            } catch (Throwable th6) {
                th = th6;
                r1 = mutex;
                ((MutexImpl) r1).unlock(null);
                throw th;
            }
        } catch (Throwable th7) {
            th = th7;
        }
    }

    private final Object invokeSuspend$com$github$kr328$clash$service$remote$IClashManagerDelegate$onTransact$3(Object obj) {
        Parcel parcel;
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            parcel = (Parcel) this.L$0;
            IClashManagerDelegate iClashManagerDelegate = (IClashManagerDelegate) this.$transitionState;
            String str = (String) this.$backStackEntry;
            String str2 = (String) this.$transition;
            this.L$0 = parcel;
            this.label = 1;
            Object objHealthCheckProxy = iClashManagerDelegate.$$delegate_0.healthCheckProxy(str, str2, this);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objHealthCheckProxy == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            parcel = (Parcel) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        parcel.writeNoException();
        return Unit.INSTANCE;
    }

    private final Object invokeSuspend$com$github$kr328$clash$service$remote$IClashManagerDelegate$onTransact$4(Object obj) {
        Parcel parcel;
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            parcel = (Parcel) this.L$0;
            IClashManagerDelegate iClashManagerDelegate = (IClashManagerDelegate) this.$transitionState;
            Provider.Type type = (Provider.Type) this.$backStackEntry;
            String str = (String) this.$transition;
            this.L$0 = parcel;
            this.label = 1;
            Object objUpdateProvider = iClashManagerDelegate.$$delegate_0.updateProvider(type, str, this);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objUpdateProvider == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            parcel = (Parcel) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        parcel.writeNoException();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r0v19, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r0v24, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r0v6, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r0v8, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r2v4, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                NavHostKt$NavHost$29$1 navHostKt$NavHost$29$1 = new NavHostKt$NavHost$29$1((SeekableTransitionState) this.$transitionState, (NavBackStackEntry) this.$backStackEntry, (Transition) this.$transition, continuation, 0);
                navHostKt$NavHost$29$1.L$0 = obj;
                return navHostKt$NavHost$29$1;
            case 1:
                return new NavHostKt$NavHost$29$1(this.L$0, (Animatable) this.$transitionState, (MutableState) this.$backStackEntry, (MutableState) this.$transition, continuation, 1);
            case 2:
                NavHostKt$NavHost$29$1 navHostKt$NavHost$29$2 = new NavHostKt$NavHost$29$1((MutableState) this.$backStackEntry, (InfiniteTransition) this.$transition, continuation, 2);
                navHostKt$NavHost$29$2.L$0 = obj;
                return navHostKt$NavHost$29$2;
            case 3:
                NavHostKt$NavHost$29$1 navHostKt$NavHost$29$3 = new NavHostKt$NavHost$29$1((TrackpadScrollingLogic) this.$transition, continuation, 3);
                navHostKt$NavHost$29$3.L$0 = obj;
                return navHostKt$NavHost$29$3;
            case 4:
                NavHostKt$NavHost$29$1 navHostKt$NavHost$29$4 = new NavHostKt$NavHost$29$1((Function1) this.$transitionState, (AndroidLegacyPlatformTextInputServiceAdapter) this.$backStackEntry, (LegacyAdaptingPlatformTextInputModifierNode) this.$transition, continuation, 4);
                navHostKt$NavHost$29$4.L$0 = obj;
                return navHostKt$NavHost$29$4;
            case 5:
                return new NavHostKt$NavHost$29$1((PlatformSelectionBehaviorsImpl) this.$backStackEntry, (Function2) this.$transition, continuation);
            case 6:
                return new NavHostKt$NavHost$29$1((SelectionManager) this.L$0, (Ref$ObjectRef) this.$transitionState, (Ref$ObjectRef) this.$backStackEntry, (Ref$LongRef) this.$transition, continuation, 6);
            case 7:
                NavHostKt$NavHost$29$1 navHostKt$NavHost$29$5 = new NavHostKt$NavHost$29$1((Function1) this.$transitionState, (AtomicReference) this.$backStackEntry, (Function2) this.$transition, continuation);
                navHostKt$NavHost$29$5.L$0 = obj;
                return navHostKt$NavHost$29$5;
            case 8:
                return new NavHostKt$NavHost$29$1((Ref$ObjectRef) this.L$0, (Recomposer) this.$transitionState, (LifecycleOwner) this.$backStackEntry, (WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2) this.$transition, continuation, 8);
            case 9:
                return new NavHostKt$NavHost$29$1((ComposeScrollCaptureCallback) this.L$0, (ScrollCaptureSession) this.$transitionState, (Rect) this.$backStackEntry, (Consumer) this.$transition, continuation, 9);
            case 10:
                return new NavHostKt$NavHost$29$1((MutexImpl) this.$backStackEntry, (Function2) this.$transition, continuation);
            case 11:
                NavHostKt$NavHost$29$1 navHostKt$NavHost$29$6 = new NavHostKt$NavHost$29$1((Lifecycle) this.$transitionState, (Lifecycle.State) this.$backStackEntry, (Function2) this.$transition, continuation);
                navHostKt$NavHost$29$6.L$0 = obj;
                return navHostKt$NavHost$29$6;
            case 12:
                return new NavHostKt$NavHost$29$1((PropertiesActivity) this.L$0, (MutableState) this.$transitionState, (MutableState) this.$backStackEntry, (MutableState) this.$transition, continuation, 12);
            case 13:
                return new NavHostKt$NavHost$29$1((PropertiesActivity) this.L$0, (Profile) this.$transitionState, (MutableState) this.$backStackEntry, (MutableState) this.$transition, continuation, 13);
            case 14:
                return new NavHostKt$NavHost$29$1((UUID) this.L$0, (IProfileManager) this.$transitionState, (Profile) this.$backStackEntry, (Function1) this.$transition, continuation, 14);
            case 15:
                NavHostKt$NavHost$29$1 navHostKt$NavHost$29$7 = new NavHostKt$NavHost$29$1((UUID) this.$transitionState, (Profile) this.$backStackEntry, (Function1) this.$transition, continuation, 15);
                navHostKt$NavHost$29$7.L$0 = obj;
                return navHostKt$NavHost$29$7;
            case 16:
                return new NavHostKt$NavHost$29$1((Provider) this.L$0, (SnackbarHostState) this.$transitionState, (ProvidersActivity) this.$backStackEntry, (MutableState) this.$transition, continuation, 16);
            case 17:
                return new NavHostKt$NavHost$29$1((ProxyViewModel) this.$transition, continuation, 17);
            case 18:
                NavHostKt$NavHost$29$1 navHostKt$NavHost$29$8 = new NavHostKt$NavHost$29$1((ArrayList) this.$transitionState, (ProxyViewModel) this.$backStackEntry, (String) this.$transition, continuation, 18);
                navHostKt$NavHost$29$8.L$0 = obj;
                return navHostKt$NavHost$29$8;
            case 19:
                return new NavHostKt$NavHost$29$1((ProxyViewModel) this.L$0, (String) this.$transitionState, (String) this.$backStackEntry, (String) this.$transition, continuation, 19);
            case 20:
                return new NavHostKt$NavHost$29$1((SnackbarHostState) this.L$0, (Context) this.$transitionState, (MutableState) this.$backStackEntry, (MutableState) this.$transition, continuation, 20);
            case 21:
                return new NavHostKt$NavHost$29$1((FilesClient) this.L$0, (String) this.$transitionState, (String) this.$backStackEntry, (Uri) this.$transition, continuation, 21);
            case 22:
                NavHostKt$NavHost$29$1 navHostKt$NavHost$29$9 = new NavHostKt$NavHost$29$1((ILogObserver) this.$backStackEntry, (BufferedChannel) this.$transition, continuation, 22);
                navHostKt$NavHost$29$9.L$0 = obj;
                return navHostKt$NavHost$29$9;
            case 23:
                NavHostKt$NavHost$29$1 navHostKt$NavHost$29$10 = new NavHostKt$NavHost$29$1((ClashService) this.$transition, continuation, 23);
                navHostKt$NavHost$29$10.L$0 = obj;
                return navHostKt$NavHost$29$10;
            case 24:
                return new NavHostKt$NavHost$29$1((String) this.$transitionState, (FilesProvider) this.$backStackEntry, (String) this.$transition, continuation, 24);
            case 25:
                NavHostKt$NavHost$29$1 navHostKt$NavHost$29$11 = new NavHostKt$NavHost$29$1((SuspendLambda) this.$transition, continuation);
                navHostKt$NavHost$29$11.$backStackEntry = obj;
                return navHostKt$NavHost$29$11;
            case 26:
                NavHostKt$NavHost$29$1 navHostKt$NavHost$29$12 = new NavHostKt$NavHost$29$1((IClashManagerDelegate) this.$transitionState, (String) this.$backStackEntry, (String) this.$transition, continuation, 26);
                navHostKt$NavHost$29$12.L$0 = obj;
                return navHostKt$NavHost$29$12;
            case 27:
                NavHostKt$NavHost$29$1 navHostKt$NavHost$29$13 = new NavHostKt$NavHost$29$1((IClashManagerDelegate) this.$transitionState, (Provider.Type) this.$backStackEntry, (String) this.$transition, continuation, 27);
                navHostKt$NavHost$29$13.L$0 = obj;
                return navHostKt$NavHost$29$13;
            default:
                return new NavHostKt$NavHost$29$1((Function2) this.$transitionState, (IBinder) this.$backStackEntry, (Ref$ObjectRef) this.$transition, continuation);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws Throwable {
        switch (this.$r8$classId) {
            case 0:
                return ((NavHostKt$NavHost$29$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 1:
                return ((NavHostKt$NavHost$29$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 2:
                ((NavHostKt$NavHost$29$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                return CoroutineSingletons.COROUTINE_SUSPENDED;
            case 3:
                return ((NavHostKt$NavHost$29$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 4:
                ((NavHostKt$NavHost$29$1) create((AndroidPlatformTextInputSession) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                return CoroutineSingletons.COROUTINE_SUSPENDED;
            case 5:
                return ((NavHostKt$NavHost$29$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 6:
                return ((NavHostKt$NavHost$29$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 7:
                return ((NavHostKt$NavHost$29$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 8:
                return ((NavHostKt$NavHost$29$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 9:
                return ((NavHostKt$NavHost$29$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 10:
                return ((NavHostKt$NavHost$29$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 11:
                return ((NavHostKt$NavHost$29$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 12:
                return ((NavHostKt$NavHost$29$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 13:
                return ((NavHostKt$NavHost$29$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 14:
                return ((NavHostKt$NavHost$29$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 15:
                return ((NavHostKt$NavHost$29$1) create((IProfileManager) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 16:
                return ((NavHostKt$NavHost$29$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 17:
                return ((NavHostKt$NavHost$29$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 18:
                return ((NavHostKt$NavHost$29$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 19:
                return ((NavHostKt$NavHost$29$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 20:
                return ((NavHostKt$NavHost$29$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 21:
                return ((NavHostKt$NavHost$29$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 22:
                return ((NavHostKt$NavHost$29$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 23:
                return ((NavHostKt$NavHost$29$1) create((ClashRuntimeKt$clashRuntime$1$launch$1$1$scope$1) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 24:
                return ((NavHostKt$NavHost$29$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 25:
                return ((NavHostKt$NavHost$29$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 26:
                return ((NavHostKt$NavHost$29$1) create((Parcel) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 27:
                return ((NavHostKt$NavHost$29$1) create((Parcel) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            default:
                return ((NavHostKt$NavHost$29$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: Code duplicated, block: B:452:0x086b A[PHI: r0 r1
      0x086b: PHI (r0v25 kotlinx.coroutines.CoroutineScope) = 
      (r0v23 kotlinx.coroutines.CoroutineScope)
      (r0v24 kotlinx.coroutines.CoroutineScope)
      (r0v24 kotlinx.coroutines.CoroutineScope)
      (r0v33 kotlinx.coroutines.CoroutineScope)
     binds: [B:451:0x085b, B:458:0x089d, B:460:0x08b7, B:447:0x0833] A[DONT_GENERATE, DONT_INLINE]
      0x086b: PHI (r1v10 kotlin.jvm.internal.Ref$FloatRef) = 
      (r1v8 kotlin.jvm.internal.Ref$FloatRef)
      (r1v9 kotlin.jvm.internal.Ref$FloatRef)
      (r1v9 kotlin.jvm.internal.Ref$FloatRef)
      (r1v16 kotlin.jvm.internal.Ref$FloatRef)
     binds: [B:451:0x085b, B:458:0x089d, B:460:0x08b7, B:447:0x0833] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:454:0x0889  */
    /* JADX WARN: Code duplicated, block: B:457:0x0898 A[PHI: r0 r1
      0x0898: PHI (r0v24 kotlinx.coroutines.CoroutineScope) = (r0v25 kotlinx.coroutines.CoroutineScope), (r0v29 kotlinx.coroutines.CoroutineScope) binds: [B:455:0x0895, B:450:0x084a] A[DONT_GENERATE, DONT_INLINE]
      0x0898: PHI (r1v9 kotlin.jvm.internal.Ref$FloatRef) = (r1v10 kotlin.jvm.internal.Ref$FloatRef), (r1v13 kotlin.jvm.internal.Ref$FloatRef) binds: [B:455:0x0895, B:450:0x084a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:459:0x089f  */
    /* JADX WARN: Code duplicated, block: B:462:0x08ba  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v270, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r12v6, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v100, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v103, types: [android.os.Parcel] */
    /* JADX WARN: Type inference failed for: r1v104 */
    /* JADX WARN: Type inference failed for: r1v105 */
    /* JADX WARN: Type inference failed for: r1v106 */
    /* JADX WARN: Type inference failed for: r1v108 */
    /* JADX WARN: Type inference failed for: r1v109 */
    /* JADX WARN: Type inference failed for: r1v110 */
    /* JADX WARN: Type inference failed for: r1v111 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v48 */
    /* JADX WARN: Type inference failed for: r1v54 */
    /* JADX WARN: Type inference failed for: r1v90, types: [android.os.IBinder, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v91 */
    /* JADX WARN: Type inference failed for: r1v92 */
    /* JADX WARN: Type inference failed for: r1v93 */
    /* JADX WARN: Type inference failed for: r1v94 */
    /* JADX WARN: Type inference failed for: r1v95 */
    /* JADX WARN: Type inference failed for: r1v96, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v98, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v37, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v82 */
    /* JADX WARN: Type inference failed for: r2v83 */
    /* JADX WARN: Type inference failed for: r3v22, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v27, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r5v16, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r8v0, types: [kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:438:0x0821 -> B:429:0x07ef). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:458:0x089d -> B:452:0x086b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:460:0x08b7 -> B:452:0x086b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r37) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 2542
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.NavHostKt$NavHost$29$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NavHostKt$NavHost$29$1(Lifecycle lifecycle, Lifecycle.State state, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = 11;
        this.$transitionState = lifecycle;
        this.$backStackEntry = state;
        this.$transition = (SuspendLambda) function2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NavHostKt$NavHost$29$1(Object obj, Object obj2, Object obj3, Object obj4, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.L$0 = obj;
        this.$transitionState = obj2;
        this.$backStackEntry = obj3;
        this.$transition = obj4;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NavHostKt$NavHost$29$1(Object obj, Object obj2, Object obj3, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.$transitionState = obj;
        this.$backStackEntry = obj2;
        this.$transition = obj3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NavHostKt$NavHost$29$1(Object obj, Object obj2, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.$backStackEntry = obj;
        this.$transition = obj2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NavHostKt$NavHost$29$1(Object obj, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.$transition = obj;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NavHostKt$NavHost$29$1(Function1 function1, AtomicReference atomicReference, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = 7;
        this.$transitionState = (Lambda) function1;
        this.$backStackEntry = atomicReference;
        this.$transition = function2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NavHostKt$NavHost$29$1(Function2 function2, IBinder iBinder, Ref$ObjectRef ref$ObjectRef, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = 28;
        this.$transitionState = (SuspendLambda) function2;
        this.$backStackEntry = iBinder;
        this.$transition = ref$ObjectRef;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NavHostKt$NavHost$29$1(Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = 25;
        this.$transition = (SuspendLambda) function2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NavHostKt$NavHost$29$1(MutexImpl mutexImpl, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = 10;
        this.$backStackEntry = mutexImpl;
        this.$transition = (SuspendLambda) function2;
    }
}
