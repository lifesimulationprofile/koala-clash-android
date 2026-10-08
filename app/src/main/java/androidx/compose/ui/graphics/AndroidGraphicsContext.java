package androidx.compose.ui.graphics;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import androidx.collection.MutableScatterMap;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerImpl;
import androidx.compose.ui.graphics.layer.GraphicsLayerV23;
import androidx.compose.ui.graphics.layer.GraphicsLayerV29;
import androidx.compose.ui.graphics.layer.GraphicsViewLayer;
import androidx.compose.ui.graphics.layer.view.DrawChildContainer;
import androidx.compose.ui.graphics.layer.view.ViewLayerContainer;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.fragment.app.FragmentStateManager;
import coil.ImageLoader$Builder;
import com.koala.clash.R;
import kotlin.Unit;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidGraphicsContext implements GraphicsContext {
    public static boolean isRenderNodeCompatible = true;
    public final AnonymousClass1 componentCallback;
    public boolean componentCallbackRegistered;
    public final Object lock = new Object();
    public final AndroidComposeView ownerView;
    public ImageLoader$Builder shadowCache;
    public ViewLayerContainer viewLayerContainer;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.content.ComponentCallbacks, androidx.compose.ui.graphics.AndroidGraphicsContext$1] */
    public AndroidGraphicsContext(AndroidComposeView androidComposeView) {
        this.ownerView = androidComposeView;
        ?? r0 = new ComponentCallbacks2() { // from class: androidx.compose.ui.graphics.AndroidGraphicsContext.1
            @Override // android.content.ComponentCallbacks2
            public final void onTrimMemory(int i) {
                if (i >= 40) {
                    AndroidGraphicsContext.access$clearShadowCache(AndroidGraphicsContext.this);
                }
            }

            @Override // android.content.ComponentCallbacks
            public final void onLowMemory() {
            }

            @Override // android.content.ComponentCallbacks
            public final void onConfigurationChanged(Configuration configuration) {
            }
        };
        this.componentCallback = r0;
        if (androidComposeView.isAttachedToWindow()) {
            Context context = androidComposeView.getContext();
            if (!this.componentCallbackRegistered) {
                context.getApplicationContext().registerComponentCallbacks(r0);
                this.componentCallbackRegistered = true;
            }
        }
        androidComposeView.addOnAttachStateChangeListener(new FragmentStateManager.AnonymousClass1(3, this));
    }

    public static final void access$clearShadowCache(AndroidGraphicsContext androidGraphicsContext) {
        ImageLoader$Builder imageLoader$Builder = androidGraphicsContext.shadowCache;
        if (imageLoader$Builder != null) {
            synchronized (imageLoader$Builder) {
                try {
                    MutableScatterMap mutableScatterMap = (MutableScatterMap) imageLoader$Builder.applicationContext;
                    if (mutableScatterMap != null) {
                        mutableScatterMap.clear();
                    }
                    MutableScatterMap mutableScatterMap2 = (MutableScatterMap) imageLoader$Builder.defaults;
                    if (mutableScatterMap2 != null) {
                        mutableScatterMap2.clear();
                    }
                    imageLoader$Builder.options = null;
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        androidGraphicsContext.shadowCache = null;
    }

    @Override // androidx.compose.ui.graphics.GraphicsContext
    public final GraphicsLayer createGraphicsLayer() {
        GraphicsLayerImpl graphicsViewLayer;
        GraphicsLayer graphicsLayer;
        synchronized (this.lock) {
            try {
                AndroidComposeView androidComposeView = this.ownerView;
                int i = Build.VERSION.SDK_INT;
                if (i >= 29) {
                    androidComposeView.getUniqueDrawingId();
                }
                if (i >= 29) {
                    graphicsViewLayer = new GraphicsLayerV29();
                } else if (isRenderNodeCompatible) {
                    try {
                        graphicsViewLayer = new GraphicsLayerV23(this.ownerView, new CanvasHolder(), new CanvasDrawScope());
                    } catch (Throwable unused) {
                        isRenderNodeCompatible = false;
                        graphicsViewLayer = new GraphicsViewLayer(obtainViewLayerContainer(this.ownerView));
                    }
                } else {
                    graphicsViewLayer = new GraphicsViewLayer(obtainViewLayerContainer(this.ownerView));
                }
                graphicsLayer = new GraphicsLayer(graphicsViewLayer);
            } catch (Throwable th) {
                throw th;
            }
        }
        return graphicsLayer;
    }

    @Override // androidx.compose.ui.graphics.GraphicsContext
    public final ImageLoader$Builder getShadowContext() {
        ImageLoader$Builder imageLoader$Builder = this.shadowCache;
        if (imageLoader$Builder != null) {
            return imageLoader$Builder;
        }
        ImageLoader$Builder imageLoader$Builder2 = new ImageLoader$Builder(8);
        this.shadowCache = imageLoader$Builder2;
        return imageLoader$Builder2;
    }

    public final DrawChildContainer obtainViewLayerContainer(AndroidComposeView androidComposeView) {
        ViewLayerContainer viewLayerContainer = this.viewLayerContainer;
        if (viewLayerContainer != null) {
            return viewLayerContainer;
        }
        ViewLayerContainer viewLayerContainer2 = new ViewLayerContainer(androidComposeView.getContext());
        viewLayerContainer2.setClipChildren(false);
        viewLayerContainer2.setClipToPadding(false);
        viewLayerContainer2.setTag(R.id.hide_graphics_layer_in_inspector_tag, Boolean.TRUE);
        androidComposeView.addView(viewLayerContainer2, -1);
        this.viewLayerContainer = viewLayerContainer2;
        return viewLayerContainer2;
    }

    @Override // androidx.compose.ui.graphics.GraphicsContext
    public final void releaseGraphicsLayer(GraphicsLayer graphicsLayer) {
        synchronized (this.lock) {
            if (!graphicsLayer.isReleased) {
                graphicsLayer.isReleased = true;
                graphicsLayer.discardContentIfReleasedAndHaveNoParentLayerUsages();
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
