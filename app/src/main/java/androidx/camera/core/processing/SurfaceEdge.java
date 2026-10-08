package androidx.camera.core.processing;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import androidx.activity.OnBackPressedDispatcher$$ExternalSyntheticLambda0;
import androidx.camera.core.AutoValue_SurfaceRequest_TransformationInfo;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.SurfaceRequest$$ExternalSyntheticLambda0;
import androidx.camera.core.impl.AutoValue_StreamSpec;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.Executor;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class SurfaceEdge {
    public final Rect mCropRect;
    public final int mFormat;
    public final boolean mHasCameraTransform;
    public final boolean mMirroring;
    public SurfaceRequest mProviderSurfaceRequest;
    public int mRotationDegrees;
    public final Matrix mSensorToBufferTransform;
    public SettableSurface mSettableSurface;
    public final AutoValue_StreamSpec mStreamSpec;
    public int mTargetRotation;
    public final int mTargets;
    public boolean mHasConsumer = false;
    public final HashSet mOnInvalidatedListeners = new HashSet();
    public boolean mIsClosed = false;
    public final ArrayList mTransformationUpdatesListeners = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class SettableSurface extends DeferrableSurface {
        public CallbackToFutureAdapter.Completer mCompleter;
        public SurfaceOutputImpl mConsumer;
        public DeferrableSurface mProvider;
        public final CallbackToFutureAdapter.SafeFuture mSurfaceFuture;

        public SettableSurface(Size size, int i) {
            super(size, i);
            this.mSurfaceFuture = CallbackToFutureAdapter.getFuture(new OnBackPressedDispatcher$$ExternalSyntheticLambda0(8, this));
        }

        @Override // androidx.camera.core.impl.DeferrableSurface
        public final void close() {
            super.close();
            MapsKt__MapsKt.runOnMain(new SurfaceEdge$$ExternalSyntheticLambda1(this, 2));
        }

        @Override // androidx.camera.core.impl.DeferrableSurface
        public final ListenableFuture provideSurface() {
            return this.mSurfaceFuture;
        }

        public final boolean setProvider(DeferrableSurface deferrableSurface, Runnable runnable) {
            boolean z;
            Size size = this.mPrescribedSize;
            MapsKt__MapsKt.checkMainThread();
            deferrableSurface.getClass();
            int i = deferrableSurface.mPrescribedStreamFormat;
            Size size2 = deferrableSurface.mPrescribedSize;
            DeferrableSurface deferrableSurface2 = this.mProvider;
            if (deferrableSurface2 == deferrableSurface) {
                return false;
            }
            Preconditions.checkState("A different provider has been set. To change the provider, call SurfaceEdge#invalidate before calling SurfaceEdge#setProvider", deferrableSurface2 == null);
            Preconditions.checkArgument("The provider's size(" + size + ") must match the parent(" + size2 + ")", size.equals(size2));
            int i2 = this.mPrescribedStreamFormat;
            Preconditions.checkArgument("The provider's format(" + i2 + ") must match the parent(" + i + ")", i2 == i);
            synchronized (this.mLock) {
                z = this.mClosed;
            }
            Preconditions.checkState("The parent is closed. Call SurfaceEdge#invalidate() before setting a new provider.", !z);
            this.mProvider = deferrableSurface;
            Futures.propagateTransform(true, deferrableSurface.getSurface(), this.mCompleter, SetsKt.directExecutor());
            deferrableSurface.incrementUseCount();
            Futures.nonCancellationPropagating(this.mTerminationFuture).addListener(new SurfaceEdge$$ExternalSyntheticLambda2(deferrableSurface, 1), SetsKt.directExecutor());
            Futures.nonCancellationPropagating(deferrableSurface.mCloseFuture).addListener(runnable, SetsKt.mainThreadExecutor());
            return true;
        }
    }

    public SurfaceEdge(int i, int i2, AutoValue_StreamSpec autoValue_StreamSpec, Matrix matrix, boolean z, Rect rect, int i3, int i4, boolean z2) {
        this.mTargets = i;
        this.mFormat = i2;
        this.mStreamSpec = autoValue_StreamSpec;
        this.mSensorToBufferTransform = matrix;
        this.mHasCameraTransform = z;
        this.mCropRect = rect;
        this.mRotationDegrees = i3;
        this.mTargetRotation = i4;
        this.mMirroring = z2;
        this.mSettableSurface = new SettableSurface(autoValue_StreamSpec.resolution, i2);
    }

    public final void checkNotClosed() {
        Preconditions.checkState("Edge is already closed.", !this.mIsClosed);
    }

    public final void close() {
        MapsKt__MapsKt.checkMainThread();
        this.mSettableSurface.close();
        this.mIsClosed = true;
    }

    public final SurfaceRequest createSurfaceRequest(CameraInternal cameraInternal, boolean z) {
        MapsKt__MapsKt.checkMainThread();
        checkNotClosed();
        AutoValue_StreamSpec autoValue_StreamSpec = this.mStreamSpec;
        SurfaceRequest surfaceRequest = new SurfaceRequest(autoValue_StreamSpec.resolution, cameraInternal, z, autoValue_StreamSpec.dynamicRange, new SurfaceEdge$$ExternalSyntheticLambda0(this, 0));
        try {
            SurfaceRequest.AnonymousClass2 anonymousClass2 = surfaceRequest.mInternalDeferrableSurface;
            SettableSurface settableSurface = this.mSettableSurface;
            Objects.requireNonNull(settableSurface);
            if (settableSurface.setProvider(anonymousClass2, new SurfaceEdge$$ExternalSyntheticLambda1(settableSurface, 0))) {
                Futures.nonCancellationPropagating(settableSurface.mTerminationFuture).addListener(new SurfaceEdge$$ExternalSyntheticLambda2(anonymousClass2, 0), SetsKt.directExecutor());
            }
            this.mProviderSurfaceRequest = surfaceRequest;
            notifyTransformationInfoUpdate();
            return surfaceRequest;
        } catch (DeferrableSurface.SurfaceClosedException e) {
            throw new AssertionError("Surface is somehow already closed", e);
        } catch (RuntimeException e2) {
            surfaceRequest.willNotProvideSurface();
            throw e2;
        }
    }

    public final void invalidate() {
        boolean z;
        MapsKt__MapsKt.checkMainThread();
        checkNotClosed();
        SettableSurface settableSurface = this.mSettableSurface;
        settableSurface.getClass();
        MapsKt__MapsKt.checkMainThread();
        if (settableSurface.mProvider == null) {
            synchronized (settableSurface.mLock) {
                z = settableSurface.mClosed;
            }
            if (!z) {
                return;
            }
        }
        this.mHasConsumer = false;
        this.mSettableSurface.close();
        this.mSettableSurface = new SettableSurface(this.mStreamSpec.resolution, this.mFormat);
        Iterator it = this.mOnInvalidatedListeners.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }

    public final void notifyTransformationInfoUpdate() {
        SurfaceRequest.TransformationInfoListener transformationInfoListener;
        Executor executor;
        MapsKt__MapsKt.checkMainThread();
        AutoValue_SurfaceRequest_TransformationInfo autoValue_SurfaceRequest_TransformationInfo = new AutoValue_SurfaceRequest_TransformationInfo(this.mCropRect, this.mRotationDegrees, this.mTargetRotation, this.mHasCameraTransform, this.mSensorToBufferTransform, this.mMirroring);
        SurfaceRequest surfaceRequest = this.mProviderSurfaceRequest;
        if (surfaceRequest != null) {
            synchronized (surfaceRequest.mLock) {
                surfaceRequest.mTransformationInfo = autoValue_SurfaceRequest_TransformationInfo;
                transformationInfoListener = surfaceRequest.mTransformationInfoListener;
                executor = surfaceRequest.mTransformationInfoExecutor;
            }
            if (transformationInfoListener != null && executor != null) {
                executor.execute(new SurfaceRequest$$ExternalSyntheticLambda0(transformationInfoListener, autoValue_SurfaceRequest_TransformationInfo, 0));
            }
        }
        ArrayList arrayList = this.mTransformationUpdatesListeners;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((Consumer) obj).accept(autoValue_SurfaceRequest_TransformationInfo);
        }
    }
}
