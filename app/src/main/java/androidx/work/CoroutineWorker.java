package androidx.work;

import android.content.Context;
import androidx.compose.animation.core.SeekableTransitionState;
import androidx.compose.foundation.DefaultDebugIndication;
import androidx.compose.foundation.FocusableNode;
import androidx.compose.foundation.MagnifierNode;
import androidx.compose.foundation.gestures.MouseWheelScrollingLogic;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.text.input.internal.CursorAnimationState;
import androidx.compose.foundation.text.selection.SelectionManager;
import androidx.compose.material3.ThumbNode;
import androidx.compose.material3.TooltipStateImpl$show$cancellableShow$1;
import androidx.compose.material3.internal.ripple.AndroidRippleNode;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableLongState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import androidx.navigation.compose.NavHostKt$NavHost$28$1;
import androidx.work.impl.utils.futures.SettableFuture;
import coil.compose.AsyncImagePainter;
import coil.memory.RealStrongMemoryCache;
import com.github.kr328.clash.FilesActivity$Content$3$1$1;
import com.github.kr328.clash.LogcatActivity;
import com.github.kr328.clash.MainActivity;
import com.github.kr328.clash.compose.home.HomeViewModel;
import com.github.kr328.clash.compose.newprofile.NewProfileViewModel;
import com.github.kr328.clash.compose.proxy.ProxyViewModel;
import com.google.common.util.concurrent.ListenableFuture;
import dev.chrisbanes.haze.HazeSourceNode;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobImpl;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class CoroutineWorker extends ListenableWorker {
    public final DefaultScheduler coroutineContext;
    public final SettableFuture future;
    public final JobImpl job;

    /* JADX INFO: renamed from: androidx.work.CoroutineWorker$startWork$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class AnonymousClass1 extends SuspendLambda implements Function2 {
        public final /* synthetic */ int $r8$classId;
        public int label;
        public final /* synthetic */ Object this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(LazyListState lazyListState, int i, Continuation continuation) {
            super(2, continuation);
            this.$r8$classId = 6;
            this.this$0 = lazyListState;
            this.label = i;
        }

        /* JADX WARN: Type inference failed for: r0v21, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function1] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            switch (this.$r8$classId) {
                case 0:
                    return new AnonymousClass1((CoroutineWorker) this.this$0, continuation, 0);
                case 1:
                    return new AnonymousClass1((SeekableTransitionState) this.this$0, continuation, 1);
                case 2:
                    return new AnonymousClass1((DefaultDebugIndication.DefaultDebugIndicationInstance) this.this$0, continuation, 2);
                case 3:
                    return new AnonymousClass1((FocusableNode) this.this$0, continuation, 3);
                case 4:
                    return new AnonymousClass1((MagnifierNode) this.this$0, continuation, 4);
                case 5:
                    return new AnonymousClass1((MouseWheelScrollingLogic) this.this$0, continuation, 5);
                case 6:
                    return new AnonymousClass1((LazyListState) this.this$0, this.label, continuation);
                case 7:
                    return new AnonymousClass1((RealStrongMemoryCache) this.this$0, continuation, 7);
                case 8:
                    return new AnonymousClass1((CursorAnimationState) this.this$0, continuation, 8);
                case 9:
                    return new AnonymousClass1((SelectionManager) this.this$0, continuation, 9);
                case 10:
                    return new AnonymousClass1((SuspendLambda) this.this$0, continuation);
                case 11:
                    return new AnonymousClass1((ThumbNode) this.this$0, continuation, 11);
                case 12:
                    return new AnonymousClass1((TooltipStateImpl$show$cancellableShow$1) this.this$0, continuation, 12);
                case 13:
                    return new AnonymousClass1((AndroidRippleNode) this.this$0, continuation, 13);
                case 14:
                    return new AnonymousClass1((SuspendingPointerInputModifierNodeImpl) this.this$0, continuation, 14);
                case 15:
                    return new AnonymousClass1((AsyncImagePainter) this.this$0, continuation, 15);
                case 16:
                    return new AnonymousClass1((FilesActivity$Content$3$1$1) this.this$0, continuation, 16);
                case 17:
                    return new AnonymousClass1((LogcatActivity) this.this$0, continuation, 17);
                case 18:
                    return new AnonymousClass1((MainActivity) this.this$0, continuation, 18);
                case 19:
                    return new AnonymousClass1((MutableState) this.this$0, continuation, 19);
                case 20:
                    return new AnonymousClass1((ParcelableSnapshotMutableLongState) this.this$0, continuation, 20);
                case 21:
                    return new AnonymousClass1((HomeViewModel) this.this$0, continuation, 21);
                case 22:
                    return new AnonymousClass1((NewProfileViewModel) this.this$0, continuation, 22);
                case 23:
                    return new AnonymousClass1((ProxyViewModel) this.this$0, continuation, 23);
                case 24:
                    return new AnonymousClass1((CoroutineScope) this.this$0, continuation, 24);
                default:
                    return new AnonymousClass1((HazeSourceNode) this.this$0, continuation, 25);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) throws Throwable {
            switch (this.$r8$classId) {
                case 0:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                case 1:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                case 2:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                case 3:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                case 4:
                    ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                    return CoroutineSingletons.COROUTINE_SUSPENDED;
                case 5:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                case 6:
                    return ((AnonymousClass1) create((ScrollScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                case 7:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                case 8:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                case 9:
                    long j = ((Offset) obj).packedValue;
                    return new AnonymousClass1((SelectionManager) this.this$0, (Continuation) obj2, 9).invokeSuspend(Unit.INSTANCE);
                case 10:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                case 11:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                case 12:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                case 13:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                case 14:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                case 15:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                case 16:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                case 17:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                case 18:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                case 19:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                case 20:
                    ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                    return CoroutineSingletons.COROUTINE_SUSPENDED;
                case 21:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                case 22:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                case 23:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                case 24:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                default:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: Code duplicated, block: B:258:0x03f2  */
        /* JADX WARN: Code duplicated, block: B:260:0x03f6  */
        /* JADX WARN: Code duplicated, block: B:263:0x03ff  */
        /* JADX WARN: Code duplicated, block: B:265:0x0403  */
        /* JADX WARN: Type inference failed for: r9v9, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function1] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:264:0x0401 -> B:258:0x03f2). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:266:0x0419 -> B:268:0x041c). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r19) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 1290
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.work.CoroutineWorker.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(Object obj, Continuation continuation, int i) {
            super(2, continuation);
            this.$r8$classId = i;
            this.this$0 = obj;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function1 function1, Continuation continuation) {
            super(2, continuation);
            this.$r8$classId = 10;
            this.this$0 = (SuspendLambda) function1;
        }
    }

    public CoroutineWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.job = JobKt.Job$default();
        SettableFuture settableFuture = new SettableFuture();
        this.future = settableFuture;
        settableFuture.addListener(new CoroutineWorker$$ExternalSyntheticLambda0(0, this), workerParameters.mWorkTaskExecutor.mBackgroundExecutor);
        this.coroutineContext = Dispatchers.Default;
    }

    public abstract Object doWork(ContinuationImpl continuationImpl);

    @Override // androidx.work.ListenableWorker
    public final ListenableFuture getForegroundInfoAsync() {
        JobImpl jobImplJob$default = JobKt.Job$default();
        DefaultScheduler defaultScheduler = this.coroutineContext;
        defaultScheduler.getClass();
        ContextScope contextScopeCoroutineScope = JobKt.CoroutineScope(CoroutineContext.DefaultImpls.plus(defaultScheduler, jobImplJob$default));
        JobListenableFuture jobListenableFuture = new JobListenableFuture(jobImplJob$default);
        JobKt.launch$default(contextScopeCoroutineScope, null, new NavHostKt$NavHost$28$1(jobListenableFuture, this, (Continuation) null, 25), 3);
        return jobListenableFuture;
    }

    @Override // androidx.work.ListenableWorker
    public final void onStopped() {
        this.future.cancel(false);
    }

    @Override // androidx.work.ListenableWorker
    public final SettableFuture startWork() {
        DefaultScheduler defaultScheduler = this.coroutineContext;
        defaultScheduler.getClass();
        JobKt.launch$default(JobKt.CoroutineScope(CoroutineContext.DefaultImpls.plus(defaultScheduler, this.job)), null, new AnonymousClass1(this, (Continuation) null, 0), 3);
        return this.future;
    }
}
