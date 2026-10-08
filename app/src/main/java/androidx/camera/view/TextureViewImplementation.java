package androidx.camera.view;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.util.Size;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.activity.OnBackPressedDispatcher$$ExternalSyntheticLambda0;
import androidx.camera.camera2.interop.CaptureRequestOptions$Builder$$ExternalSyntheticLambda0;
import androidx.camera.core.Preview$$ExternalSyntheticLambda1;
import androidx.camera.core.SurfaceRequest;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.content.ContextCompat;
import androidx.work.WorkRequest;
import androidx.work.Worker;
import androidx.work.impl.Schedulers$$ExternalSyntheticLambda1;
import coil.memory.RealStrongMemoryCache;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.LazyKt__LazyJVMKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class TextureViewImplementation extends WorkRequest.Builder {
    public SurfaceTexture mDetachedSurfaceTexture;
    public boolean mIsSurfaceTextureDetachedFromView;
    public AtomicReference mNextFrameCompleter;
    public PreviewView$1$$ExternalSyntheticLambda2 mOnSurfaceNotInUseListener;
    public CallbackToFutureAdapter.SafeFuture mSurfaceReleaseFuture;
    public SurfaceRequest mSurfaceRequest;
    public SurfaceTexture mSurfaceTexture;
    public TextureView mTextureView;

    /* JADX INFO: renamed from: androidx.camera.view.TextureViewImplementation$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class AnonymousClass1 implements TextureView.SurfaceTextureListener {
        public AnonymousClass1() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            LazyKt__LazyJVMKt.d("TextureViewImpl", "SurfaceTexture available. Size: " + i + "x" + i2);
            TextureViewImplementation textureViewImplementation = TextureViewImplementation.this;
            textureViewImplementation.mSurfaceTexture = surfaceTexture;
            if (textureViewImplementation.mSurfaceReleaseFuture == null) {
                textureViewImplementation.tryToProvidePreviewSurface();
                return;
            }
            textureViewImplementation.mSurfaceRequest.getClass();
            LazyKt__LazyJVMKt.d("TextureViewImpl", "Surface invalidated " + textureViewImplementation.mSurfaceRequest);
            textureViewImplementation.mSurfaceRequest.mInternalDeferrableSurface.close();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            TextureViewImplementation textureViewImplementation = TextureViewImplementation.this;
            textureViewImplementation.mSurfaceTexture = null;
            CallbackToFutureAdapter.SafeFuture safeFuture = textureViewImplementation.mSurfaceReleaseFuture;
            if (safeFuture == null) {
                LazyKt__LazyJVMKt.d("TextureViewImpl", "SurfaceTexture about to be destroyed");
                return true;
            }
            RealStrongMemoryCache realStrongMemoryCache = new RealStrongMemoryCache(7, this, surfaceTexture);
            safeFuture.addListener(new Worker.AnonymousClass2(1, safeFuture, realStrongMemoryCache), ContextCompat.getMainExecutor(textureViewImplementation.mTextureView.getContext()));
            textureViewImplementation.mDetachedSurfaceTexture = surfaceTexture;
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            LazyKt__LazyJVMKt.d("TextureViewImpl", "SurfaceTexture size changed: " + i + "x" + i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            CallbackToFutureAdapter.Completer completer = (CallbackToFutureAdapter.Completer) TextureViewImplementation.this.mNextFrameCompleter.getAndSet(null);
            if (completer != null) {
                completer.set(null);
            }
        }
    }

    @Override // androidx.work.WorkRequest.Builder
    public final View getPreview() {
        return this.mTextureView;
    }

    @Override // androidx.work.WorkRequest.Builder
    public final Bitmap getPreviewBitmap() {
        TextureView textureView = this.mTextureView;
        if (textureView == null || !textureView.isAvailable()) {
            return null;
        }
        return this.mTextureView.getBitmap();
    }

    @Override // androidx.work.WorkRequest.Builder
    public final void onAttachedToWindow() {
        if (!this.mIsSurfaceTextureDetachedFromView || this.mDetachedSurfaceTexture == null) {
            return;
        }
        SurfaceTexture surfaceTexture = this.mTextureView.getSurfaceTexture();
        SurfaceTexture surfaceTexture2 = this.mDetachedSurfaceTexture;
        if (surfaceTexture != surfaceTexture2) {
            this.mTextureView.setSurfaceTexture(surfaceTexture2);
            this.mDetachedSurfaceTexture = null;
            this.mIsSurfaceTextureDetachedFromView = false;
        }
    }

    @Override // androidx.work.WorkRequest.Builder
    public final void onDetachedFromWindow() {
        this.mIsSurfaceTextureDetachedFromView = true;
    }

    @Override // androidx.work.WorkRequest.Builder
    public final void onSurfaceRequested(SurfaceRequest surfaceRequest, PreviewView$1$$ExternalSyntheticLambda2 previewView$1$$ExternalSyntheticLambda2) {
        Size size = surfaceRequest.mResolution;
        this.id = size;
        this.mOnSurfaceNotInUseListener = previewView$1$$ExternalSyntheticLambda2;
        FrameLayout frameLayout = (FrameLayout) this.workSpec;
        size.getClass();
        TextureView textureView = new TextureView(frameLayout.getContext());
        this.mTextureView = textureView;
        textureView.setLayoutParams(new FrameLayout.LayoutParams(((Size) this.id).getWidth(), ((Size) this.id).getHeight()));
        this.mTextureView.setSurfaceTextureListener(new AnonymousClass1());
        frameLayout.removeAllViews();
        frameLayout.addView(this.mTextureView);
        SurfaceRequest surfaceRequest2 = this.mSurfaceRequest;
        if (surfaceRequest2 != null) {
            surfaceRequest2.willNotProvideSurface();
        }
        this.mSurfaceRequest = surfaceRequest;
        Executor mainExecutor = ContextCompat.getMainExecutor(this.mTextureView.getContext());
        Preview$$ExternalSyntheticLambda1 preview$$ExternalSyntheticLambda1 = new Preview$$ExternalSyntheticLambda1(22, this, surfaceRequest);
        ResolvableFuture resolvableFuture = surfaceRequest.mRequestCancellationCompleter.cancellationFuture;
        if (resolvableFuture != null) {
            resolvableFuture.addListener(preview$$ExternalSyntheticLambda1, mainExecutor);
        }
        tryToProvidePreviewSurface();
    }

    public final void tryToProvidePreviewSurface() {
        SurfaceTexture surfaceTexture;
        Size size = (Size) this.id;
        if (size == null || (surfaceTexture = this.mSurfaceTexture) == null || this.mSurfaceRequest == null) {
            return;
        }
        surfaceTexture.setDefaultBufferSize(size.getWidth(), ((Size) this.id).getHeight());
        Surface surface = new Surface(this.mSurfaceTexture);
        SurfaceRequest surfaceRequest = this.mSurfaceRequest;
        CallbackToFutureAdapter.SafeFuture future = CallbackToFutureAdapter.getFuture(new CaptureRequestOptions$Builder$$ExternalSyntheticLambda0(12, this, surface));
        this.mSurfaceReleaseFuture = future;
        future.delegate.addListener(new Schedulers$$ExternalSyntheticLambda1(this, surface, future, surfaceRequest, 4), ContextCompat.getMainExecutor(this.mTextureView.getContext()));
        this.backoffCriteriaSet = true;
        redrawPreview();
    }

    @Override // androidx.work.WorkRequest.Builder
    public final ListenableFuture waitForNextFrame() {
        return CallbackToFutureAdapter.getFuture(new OnBackPressedDispatcher$$ExternalSyntheticLambda0(12, this));
    }
}
