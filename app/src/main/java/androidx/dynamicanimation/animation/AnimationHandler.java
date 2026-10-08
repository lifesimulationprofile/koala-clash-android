package androidx.dynamicanimation.animation;

import androidx.collection.SimpleArrayMap;
import coil.memory.EmptyStrongMemoryCache;
import coil.network.RealNetworkObserver;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AnimationHandler {
    public static final ThreadLocal sAnimatorHandler = new ThreadLocal();
    public RealNetworkObserver mProvider;
    public final SimpleArrayMap mDelayedCallbackStartTime = new SimpleArrayMap(0);
    public final ArrayList mAnimationCallbacks = new ArrayList();
    public final EmptyStrongMemoryCache mCallbackDispatcher = new EmptyStrongMemoryCache(13, this);
    public boolean mListDirty = false;
}
