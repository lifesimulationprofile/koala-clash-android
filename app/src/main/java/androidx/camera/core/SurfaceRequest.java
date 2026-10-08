package androidx.camera.core;

import android.util.Range;
import android.util.Size;
import android.view.Surface;
import androidx.appcompat.widget.Toolbar;
import androidx.camera.camera2.interop.CaptureRequestOptions$Builder$$ExternalSyntheticLambda0;
import androidx.camera.core.impl.AutoValue_StreamSpec;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.processing.SurfaceEdge$$ExternalSyntheticLambda0;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import androidx.work.Worker;
import androidx.work.impl.StartStopTokens;
import androidx.work.impl.WorkLauncherImpl;
import coil.ImageLoader$Builder;
import com.google.android.gms.tasks.zzt;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.zxing.WriterException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.collections.SetsKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class SurfaceRequest {
    public final CameraInternal mCamera;
    public final DynamicRange mDynamicRange;
    public final AnonymousClass2 mInternalDeferrableSurface;
    public final boolean mIsPrimary;
    public final Object mLock = new Object();
    public final CallbackToFutureAdapter.Completer mRequestCancellationCompleter;
    public final Size mResolution;
    public final CallbackToFutureAdapter.SafeFuture mSessionStatusFuture;
    public final CallbackToFutureAdapter.Completer mSurfaceCompleter;
    public final CallbackToFutureAdapter.SafeFuture mSurfaceFuture;
    public final CallbackToFutureAdapter.Completer mSurfaceRecreationCompleter;
    public AutoValue_SurfaceRequest_TransformationInfo mTransformationInfo;
    public Executor mTransformationInfoExecutor;
    public TransformationInfoListener mTransformationInfoListener;

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class RequestCancelledException extends RuntimeException {
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public interface TransformationInfoListener {
        void onTransformationInfoUpdate(AutoValue_SurfaceRequest_TransformationInfo autoValue_SurfaceRequest_TransformationInfo);
    }

    static {
        Range range = AutoValue_StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
    }

    public SurfaceRequest(Size size, CameraInternal cameraInternal, boolean z, DynamicRange dynamicRange, SurfaceEdge$$ExternalSyntheticLambda0 surfaceEdge$$ExternalSyntheticLambda0) {
        this.mResolution = size;
        this.mCamera = cameraInternal;
        this.mIsPrimary = z;
        this.mDynamicRange = dynamicRange;
        final String str = "SurfaceRequest[size: " + size + ", id: " + hashCode() + "]";
        final AtomicReference atomicReference = new AtomicReference(null);
        final int i = 0;
        CallbackToFutureAdapter.SafeFuture future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.SurfaceRequest$$ExternalSyntheticLambda1
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                switch (i) {
                    case 0:
                        atomicReference.set(completer);
                        return str + "-cancellation";
                    case 1:
                        atomicReference.set(completer);
                        return str + "-status";
                    default:
                        atomicReference.set(completer);
                        return str + "-Surface";
                }
            }
        });
        CallbackToFutureAdapter.Completer completer = (CallbackToFutureAdapter.Completer) atomicReference.get();
        completer.getClass();
        this.mRequestCancellationCompleter = completer;
        final AtomicReference atomicReference2 = new AtomicReference(null);
        final int i2 = 1;
        CallbackToFutureAdapter.SafeFuture future2 = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.SurfaceRequest$$ExternalSyntheticLambda1
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer2) {
                switch (i2) {
                    case 0:
                        atomicReference2.set(completer2);
                        return str + "-cancellation";
                    case 1:
                        atomicReference2.set(completer2);
                        return str + "-status";
                    default:
                        atomicReference2.set(completer2);
                        return str + "-Surface";
                }
            }
        });
        this.mSessionStatusFuture = future2;
        future2.addListener(new Worker.AnonymousClass2(1, future2, new StartStopTokens(5, completer, future, false)), SetsKt.directExecutor());
        CallbackToFutureAdapter.Completer completer2 = (CallbackToFutureAdapter.Completer) atomicReference2.get();
        completer2.getClass();
        final AtomicReference atomicReference3 = new AtomicReference(null);
        final int i3 = 2;
        CallbackToFutureAdapter.SafeFuture future3 = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.SurfaceRequest$$ExternalSyntheticLambda1
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer3) {
                switch (i3) {
                    case 0:
                        atomicReference3.set(completer3);
                        return str + "-cancellation";
                    case 1:
                        atomicReference3.set(completer3);
                        return str + "-status";
                    default:
                        atomicReference3.set(completer3);
                        return str + "-Surface";
                }
            }
        });
        this.mSurfaceFuture = future3;
        CallbackToFutureAdapter.Completer completer3 = (CallbackToFutureAdapter.Completer) atomicReference3.get();
        completer3.getClass();
        this.mSurfaceCompleter = completer3;
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(this, size);
        this.mInternalDeferrableSurface = anonymousClass2;
        ListenableFuture listenableFutureNonCancellationPropagating = Futures.nonCancellationPropagating(anonymousClass2.mTerminationFuture);
        future3.addListener(new Worker.AnonymousClass2(1, future3, new ImageLoader$Builder(listenableFutureNonCancellationPropagating, completer2, str, 3)), SetsKt.directExecutor());
        listenableFutureNonCancellationPropagating.addListener(new SurfaceRequest$$ExternalSyntheticLambda4(this, 0), SetsKt.directExecutor());
        zzt zztVarDirectExecutor = SetsKt.directExecutor();
        AtomicReference atomicReference4 = new AtomicReference(null);
        CallbackToFutureAdapter.SafeFuture future4 = CallbackToFutureAdapter.getFuture(new CaptureRequestOptions$Builder$$ExternalSyntheticLambda0(5, this, atomicReference4));
        future4.addListener(new Worker.AnonymousClass2(1, future4, new Toolbar.AnonymousClass1(17, surfaceEdge$$ExternalSyntheticLambda0)), zztVarDirectExecutor);
        CallbackToFutureAdapter.Completer completer4 = (CallbackToFutureAdapter.Completer) atomicReference4.get();
        completer4.getClass();
        this.mSurfaceRecreationCompleter = completer4;
    }

    public final void provideSurface(final Surface surface, Executor executor, final Consumer consumer) {
        if (!this.mSurfaceCompleter.set(surface)) {
            CallbackToFutureAdapter.SafeFuture safeFuture = this.mSurfaceFuture;
            if (!safeFuture.isCancelled()) {
                Preconditions.checkState(null, safeFuture.delegate.isDone());
                try {
                    safeFuture.get();
                    final int i = 0;
                    executor.execute(new Runnable() { // from class: androidx.camera.core.SurfaceRequest$$ExternalSyntheticLambda7
                        @Override // java.lang.Runnable
                        public final void run() {
                            switch (i) {
                                case 0:
                                    consumer.accept(new AutoValue_SurfaceRequest_Result(3, surface));
                                    break;
                                default:
                                    consumer.accept(new AutoValue_SurfaceRequest_Result(4, surface));
                                    break;
                            }
                        }
                    });
                    return;
                } catch (InterruptedException | ExecutionException unused) {
                    final int i2 = 1;
                    executor.execute(new Runnable() { // from class: androidx.camera.core.SurfaceRequest$$ExternalSyntheticLambda7
                        @Override // java.lang.Runnable
                        public final void run() {
                            switch (i2) {
                                case 0:
                                    consumer.accept(new AutoValue_SurfaceRequest_Result(3, surface));
                                    break;
                                default:
                                    consumer.accept(new AutoValue_SurfaceRequest_Result(4, surface));
                                    break;
                            }
                        }
                    });
                    return;
                }
            }
        }
        WorkLauncherImpl workLauncherImpl = new WorkLauncherImpl(5, consumer, surface);
        CallbackToFutureAdapter.SafeFuture safeFuture2 = this.mSessionStatusFuture;
        safeFuture2.addListener(new Worker.AnonymousClass2(1, safeFuture2, workLauncherImpl), executor);
    }

    public final void setTransformationInfoListener(Executor executor, TransformationInfoListener transformationInfoListener) {
        AutoValue_SurfaceRequest_TransformationInfo autoValue_SurfaceRequest_TransformationInfo;
        synchronized (this.mLock) {
            this.mTransformationInfoListener = transformationInfoListener;
            this.mTransformationInfoExecutor = executor;
            autoValue_SurfaceRequest_TransformationInfo = this.mTransformationInfo;
        }
        if (autoValue_SurfaceRequest_TransformationInfo != null) {
            executor.execute(new SurfaceRequest$$ExternalSyntheticLambda0(transformationInfoListener, autoValue_SurfaceRequest_TransformationInfo, 1));
        }
    }

    public final void willNotProvideSurface() {
        this.mSurfaceCompleter.setException(new WriterException("Surface request will not complete."));
    }

    /* JADX INFO: renamed from: androidx.camera.core.SurfaceRequest$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class AnonymousClass2 extends DeferrableSurface {
        public final /* synthetic */ int $r8$classId = 1;
        public final Object this$0;

        public AnonymousClass2(Surface surface, Size size, int i) {
            super(size, i);
            this.this$0 = surface;
        }

        @Override // androidx.camera.core.impl.DeferrableSurface
        public final ListenableFuture provideSurface() {
            switch (this.$r8$classId) {
                case 0:
                    return ((SurfaceRequest) this.this$0).mSurfaceFuture;
                default:
                    return Futures.immediateFuture((Surface) this.this$0);
            }
        }

        public AnonymousClass2(Surface surface) {
            super(DeferrableSurface.SIZE_UNDEFINED, 0);
            this.this$0 = surface;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(SurfaceRequest surfaceRequest, Size size) {
            super(size, 34);
            this.this$0 = surfaceRequest;
        }
    }
}
