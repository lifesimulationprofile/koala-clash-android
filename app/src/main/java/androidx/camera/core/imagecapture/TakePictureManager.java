package androidx.camera.core.imagecapture;

import android.util.Log;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.LayoutSettings;
import androidx.camera.core.Preview$$ExternalSyntheticLambda0;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.core.util.Preconditions;
import coil.intercept.RealInterceptorChain;
import coil.memory.RealStrongMemoryCache;
import com.google.zxing.WriterException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class TakePictureManager implements ForwardingImageProxy.OnImageCloseListener {
    public Dispatcher mImagePipeline;
    public final ArrayList mIncompleteRequests;
    public final ArrayDeque mNewRequests = new ArrayDeque();
    public boolean mPaused = false;

    public TakePictureManager(LayoutSettings layoutSettings) {
        MapsKt__MapsKt.checkMainThread();
        this.mIncompleteRequests = new ArrayList();
    }

    public final void abortRequests() {
        MapsKt__MapsKt.checkMainThread();
        new WriterException("Camera is closed.", null);
        ArrayDeque arrayDeque = this.mNewRequests;
        Iterator it = arrayDeque.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
        arrayDeque.clear();
        Iterator it2 = new ArrayList(this.mIncompleteRequests).iterator();
        if (it2.hasNext()) {
            it2.next().getClass();
            throw new ClassCastException();
        }
    }

    public final void issueNextRequest() {
        int maxImages;
        MapsKt__MapsKt.checkMainThread();
        Log.d("TakePictureManager", "Issue the next TakePictureRequest.");
        if (this.mPaused) {
            Log.d("TakePictureManager", "The class is paused.");
            return;
        }
        Dispatcher dispatcher = this.mImagePipeline;
        dispatcher.getClass();
        MapsKt__MapsKt.checkMainThread();
        RealStrongMemoryCache realStrongMemoryCache = (RealStrongMemoryCache) dispatcher.readyAsyncCalls;
        realStrongMemoryCache.getClass();
        MapsKt__MapsKt.checkMainThread();
        Preconditions.checkState("The ImageReader is not initialized.", ((RealInterceptorChain) realStrongMemoryCache.weakMemoryCache) != null);
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) realStrongMemoryCache.weakMemoryCache;
        synchronized (realInterceptorChain.initialRequest) {
            maxImages = ((ImageReaderProxy) realInterceptorChain.request).getMaxImages() - realInterceptorChain.index;
        }
        if (maxImages == 0) {
            Log.d("TakePictureManager", "Too many acquire images. Close image to be able to process next.");
        } else {
            if (this.mNewRequests.poll() != null) {
                throw new ClassCastException();
            }
            Log.d("TakePictureManager", "No new request.");
        }
    }

    @Override // androidx.camera.core.ForwardingImageProxy.OnImageCloseListener
    public final void onImageClose(ForwardingImageProxy forwardingImageProxy) {
        SetsKt.mainThreadExecutor().execute(new Preview$$ExternalSyntheticLambda0(12, this));
    }
}
