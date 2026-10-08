package okhttp3;

import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.appcompat.widget.Toolbar;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.imagecapture.AutoValue_CaptureNode_In;
import androidx.camera.core.imagecapture.CaptureNode$$ExternalSyntheticLambda4;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.compose.animation.core.AnimationVector;
import androidx.compose.animation.core.Animations;
import androidx.compose.animation.core.FloatAnimationSpec;
import androidx.compose.animation.core.VectorizedFiniteAnimationSpec;
import androidx.compose.ui.autofill.Autofill;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.MetadataRepo$Node;
import androidx.emoji2.text.TypefaceEmojiRasterizer;
import androidx.emoji2.text.flatbuffer.MetadataItem;
import androidx.emoji2.text.flatbuffer.MetadataList;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManagerImpl;
import androidx.fragment.app.FragmentManagerViewModel;
import androidx.fragment.app.FragmentStateManager;
import androidx.navigationevent.NavigationEvent;
import androidx.navigationevent.NavigationEventHandler;
import androidx.navigationevent.NavigationEventInput;
import androidx.navigationevent.NavigationEventProcessor;
import androidx.navigationevent.NavigationEventTransitionState;
import androidx.navigationevent.OnBackInvokedDefaultInput;
import androidx.room.CoroutinesRoom;
import androidx.room.RoomSQLiteQuery;
import coil.intercept.RealInterceptorChain;
import coil.memory.RealStrongMemoryCache;
import coil.util.ContinuationCallback;
import com.github.kr328.clash.service.data.Database_Impl;
import com.github.kr328.clash.service.data.ImportedDao_Impl$7;
import java.io.InterruptedIOException;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.serialization.json.internal.Composer;
import okhttp3.internal.Util;
import okhttp3.internal.Util$$ExternalSyntheticLambda1;
import okhttp3.internal.connection.RealCall;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class Dispatcher implements VectorizedFiniteAnimationSpec, Autofill {
    public Object executorServiceOrNull;
    public Object readyAsyncCalls;
    public Object runningAsyncCalls;
    public Object runningSyncCalls;

    public /* synthetic */ Dispatcher(Object obj, Object obj2, Object obj3, Object obj4) {
        this.executorServiceOrNull = obj;
        this.readyAsyncCalls = obj2;
        this.runningAsyncCalls = obj3;
        this.runningSyncCalls = obj4;
    }

    public static void addHandler$default(Dispatcher dispatcher, NavigationEventHandler navigationEventHandler) {
        dispatcher.getClass();
        if (((LinkedHashSet) dispatcher.runningAsyncCalls).add(navigationEventHandler)) {
            NavigationEventProcessor navigationEventProcessor = (NavigationEventProcessor) dispatcher.readyAsyncCalls;
            navigationEventProcessor.getClass();
            if (navigationEventHandler.dispatcher == null) {
                navigationEventProcessor.defaultHandlers.addFirst(navigationEventHandler);
                navigationEventHandler.dispatcher = dispatcher;
                navigationEventProcessor.refreshEnabledHandlers();
            } else {
                throw new IllegalArgumentException(("Handler '" + navigationEventHandler + "' is already registered with a dispatcher").toString());
            }
        }
    }

    public void addFragment(Fragment fragment) {
        if (((ArrayList) this.executorServiceOrNull).contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (((ArrayList) this.executorServiceOrNull)) {
            ((ArrayList) this.executorServiceOrNull).add(fragment);
        }
        fragment.mAdded = true;
    }

    public void addInput(NavigationEventInput navigationEventInput) {
        if (((LinkedHashSet) this.runningSyncCalls).add(navigationEventInput)) {
            ((NavigationEventProcessor) this.readyAsyncCalls).addInput(this, navigationEventInput, -1);
        }
    }

    public void close() {
        MapsKt__MapsKt.checkMainThread();
        RealStrongMemoryCache realStrongMemoryCache = (RealStrongMemoryCache) this.readyAsyncCalls;
        realStrongMemoryCache.getClass();
        MapsKt__MapsKt.checkMainThread();
        AutoValue_CaptureNode_In autoValue_CaptureNode_In = (AutoValue_CaptureNode_In) realStrongMemoryCache.cache;
        Objects.requireNonNull(autoValue_CaptureNode_In);
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) realStrongMemoryCache.weakMemoryCache;
        Objects.requireNonNull(realInterceptorChain);
        SurfaceRequest.AnonymousClass2 anonymousClass2 = autoValue_CaptureNode_In.mSurface;
        Objects.requireNonNull(anonymousClass2);
        anonymousClass2.close();
        SurfaceRequest.AnonymousClass2 anonymousClass3 = autoValue_CaptureNode_In.mSurface;
        Objects.requireNonNull(anonymousClass3);
        Futures.nonCancellationPropagating(anonymousClass3.mTerminationFuture).addListener(new CaptureNode$$ExternalSyntheticLambda4(realInterceptorChain, 0), SetsKt.mainThreadExecutor());
        SurfaceRequest.AnonymousClass2 anonymousClass4 = autoValue_CaptureNode_In.mPostviewSurface;
        if (anonymousClass4 != null) {
            anonymousClass4.close();
            Futures.nonCancellationPropagating(autoValue_CaptureNode_In.mPostviewSurface.mTerminationFuture).addListener(new CaptureNode$$ExternalSyntheticLambda4(null, 2), SetsKt.mainThreadExecutor());
        }
        ((Composer) this.runningAsyncCalls).getClass();
    }

    public void dispatchOnStarted$navigationevent(NavigationEventInput navigationEventInput, NavigationEvent navigationEvent) {
        NavigationEventProcessor navigationEventProcessor = (NavigationEventProcessor) this.readyAsyncCalls;
        if (navigationEventProcessor.inProgressDirection != 0) {
            return;
        }
        NavigationEventHandler navigationEventHandlerResolveEnabledHandler = navigationEventProcessor.resolveEnabledHandler(-1);
        navigationEventProcessor.inProgressHandler = navigationEventHandlerResolveEnabledHandler;
        navigationEventProcessor.inProgressDirection = -1;
        navigationEventProcessor.inProgressInput = navigationEventInput;
        if (navigationEvent != null) {
            if (navigationEventHandlerResolveEnabledHandler != null) {
                navigationEventHandlerResolveEnabledHandler.onBackStarted(navigationEvent);
            }
            StateFlowImpl stateFlowImpl = navigationEventProcessor._transitionState;
            NavigationEventTransitionState.InProgress inProgress = new NavigationEventTransitionState.InProgress(navigationEvent);
            stateFlowImpl.getClass();
            stateFlowImpl.updateState(null, inProgress);
        }
    }

    public synchronized ExecutorService executorService() {
        try {
            if (((ThreadPoolExecutor) this.executorServiceOrNull) == null) {
                this.executorServiceOrNull = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new Util$$ExternalSyntheticLambda1(Util.okHttpName + " Dispatcher", false));
            }
        } catch (Throwable th) {
            throw th;
        }
        return (ThreadPoolExecutor) this.executorServiceOrNull;
    }

    public Object exists(UUID uuid, ContinuationImpl continuationImpl) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT EXISTS(SELECT 1 FROM imported WHERE uuid = ?)", 1);
        roomSQLiteQueryAcquire.bindString(uuid.toString(), 1);
        return CoroutinesRoom.execute((Database_Impl) this.executorServiceOrNull, new CancellationSignal(), new ImportedDao_Impl$7(this, roomSQLiteQueryAcquire, 2), continuationImpl);
    }

    public Fragment findActiveFragment(String str) {
        FragmentStateManager fragmentStateManager = (FragmentStateManager) ((HashMap) this.readyAsyncCalls).get(str);
        if (fragmentStateManager != null) {
            return fragmentStateManager.mFragment;
        }
        return null;
    }

    public Fragment findFragmentByWho(String str) {
        for (FragmentStateManager fragmentStateManager : ((HashMap) this.readyAsyncCalls).values()) {
            if (fragmentStateManager != null) {
                Fragment fragmentFindFragmentByWho = fragmentStateManager.mFragment;
                if (!str.equals(fragmentFindFragmentByWho.mWho)) {
                    fragmentFindFragmentByWho = fragmentFindFragmentByWho.mChildFragmentManager.mFragmentStore.findFragmentByWho(str);
                }
                if (fragmentFindFragmentByWho != null) {
                    return fragmentFindFragmentByWho;
                }
            }
        }
        return null;
    }

    public void finished(ArrayDeque arrayDeque, Object obj) {
        synchronized (this) {
            if (!arrayDeque.remove(obj)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            Unit unit = Unit.INSTANCE;
        }
        promoteAndExecute();
    }

    public void finished$okhttp(RealCall.AsyncCall asyncCall) {
        asyncCall.callsPerHost.decrementAndGet();
        finished((ArrayDeque) this.runningAsyncCalls, asyncCall);
    }

    public ArrayList getActiveFragmentStateManagers() {
        ArrayList arrayList = new ArrayList();
        for (FragmentStateManager fragmentStateManager : ((HashMap) this.readyAsyncCalls).values()) {
            if (fragmentStateManager != null) {
                arrayList.add(fragmentStateManager);
            }
        }
        return arrayList;
    }

    public ArrayList getActiveFragments() {
        ArrayList arrayList = new ArrayList();
        for (FragmentStateManager fragmentStateManager : ((HashMap) this.readyAsyncCalls).values()) {
            if (fragmentStateManager != null) {
                arrayList.add(fragmentStateManager.mFragment);
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public long getDurationNanos(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        int size$animation_core = animationVector.getSize$animation_core();
        long jMax = 0;
        for (int i = 0; i < size$animation_core; i++) {
            jMax = Math.max(jMax, ((Animations) this.executorServiceOrNull).get(i).getDurationNanos(animationVector.get$animation_core(i), animationVector2.get$animation_core(i), animationVector3.get$animation_core(i)));
        }
        return jMax;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector getEndVelocity(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        if (((AnimationVector) this.runningSyncCalls) == null) {
            this.runningSyncCalls = animationVector3.newVector$animation_core();
        }
        AnimationVector animationVector4 = (AnimationVector) this.runningSyncCalls;
        if (animationVector4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endVelocityVector");
            throw null;
        }
        int size$animation_core = animationVector4.getSize$animation_core();
        for (int i = 0; i < size$animation_core; i++) {
            AnimationVector animationVector5 = (AnimationVector) this.runningSyncCalls;
            if (animationVector5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("endVelocityVector");
                throw null;
            }
            animationVector5.set$animation_core(i, ((Animations) this.executorServiceOrNull).get(i).getEndVelocity(animationVector.get$animation_core(i), animationVector2.get$animation_core(i), animationVector3.get$animation_core(i)));
        }
        AnimationVector animationVector6 = (AnimationVector) this.runningSyncCalls;
        if (animationVector6 != null) {
            return animationVector6;
        }
        Intrinsics.throwUninitializedPropertyAccessException("endVelocityVector");
        throw null;
    }

    public List getFragments() {
        ArrayList arrayList;
        if (((ArrayList) this.executorServiceOrNull).isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        synchronized (((ArrayList) this.executorServiceOrNull)) {
            arrayList = new ArrayList((ArrayList) this.executorServiceOrNull);
        }
        return arrayList;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector getValueFromNanos(long j, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        if (((AnimationVector) this.readyAsyncCalls) == null) {
            this.readyAsyncCalls = animationVector.newVector$animation_core();
        }
        AnimationVector animationVector4 = (AnimationVector) this.readyAsyncCalls;
        if (animationVector4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("valueVector");
            throw null;
        }
        int size$animation_core = animationVector4.getSize$animation_core();
        for (int i = 0; i < size$animation_core; i++) {
            AnimationVector animationVector5 = (AnimationVector) this.readyAsyncCalls;
            if (animationVector5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("valueVector");
                throw null;
            }
            animationVector5.set$animation_core(i, ((Animations) this.executorServiceOrNull).get(i).getValueFromNanos(j, animationVector.get$animation_core(i), animationVector2.get$animation_core(i), animationVector3.get$animation_core(i)));
        }
        AnimationVector animationVector6 = (AnimationVector) this.readyAsyncCalls;
        if (animationVector6 != null) {
            return animationVector6;
        }
        Intrinsics.throwUninitializedPropertyAccessException("valueVector");
        throw null;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector getVelocityFromNanos(long j, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        if (((AnimationVector) this.runningAsyncCalls) == null) {
            this.runningAsyncCalls = animationVector3.newVector$animation_core();
        }
        AnimationVector animationVector4 = (AnimationVector) this.runningAsyncCalls;
        if (animationVector4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
            throw null;
        }
        int size$animation_core = animationVector4.getSize$animation_core();
        for (int i = 0; i < size$animation_core; i++) {
            AnimationVector animationVector5 = (AnimationVector) this.runningAsyncCalls;
            if (animationVector5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
                throw null;
            }
            animationVector5.set$animation_core(i, ((Animations) this.executorServiceOrNull).get(i).getVelocityFromNanos(j, animationVector.get$animation_core(i), animationVector2.get$animation_core(i), animationVector3.get$animation_core(i)));
        }
        AnimationVector animationVector6 = (AnimationVector) this.runningAsyncCalls;
        if (animationVector6 != null) {
            return animationVector6;
        }
        Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
        throw null;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public /* synthetic */ boolean isInfinite() {
        return false;
    }

    public void makeActive(FragmentStateManager fragmentStateManager) {
        Fragment fragment = fragmentStateManager.mFragment;
        String str = fragment.mWho;
        HashMap map = (HashMap) this.readyAsyncCalls;
        if (map.get(str) != null) {
            return;
        }
        map.put(fragment.mWho, fragmentStateManager);
        if (FragmentManagerImpl.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + fragment);
        }
    }

    public void makeInactive(FragmentStateManager fragmentStateManager) {
        Fragment fragment = fragmentStateManager.mFragment;
        if (fragment.mRetainInstance) {
            ((FragmentManagerViewModel) this.runningSyncCalls).removeRetainedFragment(fragment);
        }
        if (((FragmentStateManager) ((HashMap) this.readyAsyncCalls).put(fragment.mWho, null)) != null && FragmentManagerImpl.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + fragment);
        }
    }

    public void promoteAndExecute() {
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                Iterator it = ((ArrayDeque) this.readyAsyncCalls).iterator();
                while (it.hasNext()) {
                    RealCall.AsyncCall asyncCall = (RealCall.AsyncCall) it.next();
                    if (((ArrayDeque) this.runningAsyncCalls).size() >= 64) {
                        break;
                    }
                    if (asyncCall.callsPerHost.get() < 5) {
                        it.remove();
                        asyncCall.callsPerHost.incrementAndGet();
                        arrayList.add(asyncCall);
                        ((ArrayDeque) this.runningAsyncCalls).add(asyncCall);
                    }
                }
                runningCallsCount();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            RealCall.AsyncCall asyncCall2 = (RealCall.AsyncCall) arrayList.get(i);
            ExecutorService executorService = executorService();
            RealCall realCall = RealCall.this;
            byte[] bArr2 = Util.EMPTY_BYTE_ARRAY;
            try {
                try {
                    ((ThreadPoolExecutor) executorService).execute(asyncCall2);
                } catch (Throwable th2) {
                    realCall.client.dispatcher.finished$okhttp(asyncCall2);
                    throw th2;
                }
            } catch (RejectedExecutionException e) {
                InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                interruptedIOException.initCause(e);
                realCall.noMoreExchanges$okhttp(interruptedIOException);
                ContinuationCallback continuationCallback = asyncCall2.responseCallback;
                if (!realCall.canceled) {
                    ((CancellableContinuationImpl) continuationCallback.continuation).resumeWith(new Result.Failure(interruptedIOException));
                }
                realCall.client.dispatcher.finished$okhttp(asyncCall2);
            }
        }
    }

    public Object queryAllUUIDs(ContinuationImpl continuationImpl) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT uuid FROM imported ORDER BY createdAt", 0);
        return CoroutinesRoom.execute((Database_Impl) this.executorServiceOrNull, new CancellationSignal(), new ImportedDao_Impl$7(this, roomSQLiteQueryAcquire, 1), continuationImpl);
    }

    public Object queryByUUID(UUID uuid, ContinuationImpl continuationImpl) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM imported WHERE uuid = ?", 1);
        roomSQLiteQueryAcquire.bindString(uuid.toString(), 1);
        return CoroutinesRoom.execute((Database_Impl) this.executorServiceOrNull, new CancellationSignal(), new ImportedDao_Impl$7(this, roomSQLiteQueryAcquire, 0), continuationImpl);
    }

    public synchronized int runningCallsCount() {
        return ((ArrayDeque) this.runningAsyncCalls).size() + ((ArrayDeque) this.runningSyncCalls).size();
    }

    public Dispatcher(int i) {
        switch (i) {
            case 7:
                this.executorServiceOrNull = new ArrayList();
                this.readyAsyncCalls = new HashMap();
                this.runningAsyncCalls = new HashMap();
                break;
            default:
                this.readyAsyncCalls = new ArrayDeque();
                this.runningAsyncCalls = new ArrayDeque();
                this.runningSyncCalls = new ArrayDeque();
                break;
        }
    }

    public void addInput(OnBackInvokedDefaultInput onBackInvokedDefaultInput, int i) {
        if (i != 1 && i != 0) {
            throw new IllegalArgumentException(ImageAnalysis$$ExternalSyntheticLambda1.m("Unsupported priority value: ", i).toString());
        }
        if (((LinkedHashSet) this.runningSyncCalls).add(onBackInvokedDefaultInput)) {
            ((NavigationEventProcessor) this.readyAsyncCalls).addInput(this, onBackInvokedDefaultInput, i);
        }
    }

    public Dispatcher(Typeface typeface, MetadataList metadataList) {
        int i;
        int i2;
        int i3;
        int i4;
        this.runningSyncCalls = typeface;
        this.executorServiceOrNull = metadataList;
        this.runningAsyncCalls = new MetadataRepo$Node(1024);
        int i__offset = metadataList.__offset(6);
        if (i__offset != 0) {
            int i5 = i__offset + metadataList.bb_pos;
            i = ((ByteBuffer) metadataList.bb).getInt(((ByteBuffer) metadataList.bb).getInt(i5) + i5);
        } else {
            i = 0;
        }
        this.readyAsyncCalls = new char[i * 2];
        int i__offset2 = metadataList.__offset(6);
        if (i__offset2 != 0) {
            int i6 = i__offset2 + metadataList.bb_pos;
            i2 = ((ByteBuffer) metadataList.bb).getInt(((ByteBuffer) metadataList.bb).getInt(i6) + i6);
        } else {
            i2 = 0;
        }
        for (int i7 = 0; i7 < i2; i7++) {
            TypefaceEmojiRasterizer typefaceEmojiRasterizer = new TypefaceEmojiRasterizer(this, i7);
            MetadataItem metadataItem = typefaceEmojiRasterizer.getMetadataItem();
            int i__offset3 = metadataItem.__offset(4);
            Character.toChars(i__offset3 != 0 ? ((ByteBuffer) metadataItem.bb).getInt(i__offset3 + metadataItem.bb_pos) : 0, (char[]) this.readyAsyncCalls, i7 * 2);
            MetadataItem metadataItem2 = typefaceEmojiRasterizer.getMetadataItem();
            int i__offset4 = metadataItem2.__offset(16);
            if (i__offset4 != 0) {
                int i8 = i__offset4 + metadataItem2.bb_pos;
                i3 = ((ByteBuffer) metadataItem2.bb).getInt(((ByteBuffer) metadataItem2.bb).getInt(i8) + i8);
            } else {
                i3 = 0;
            }
            Preconditions.checkArgument("invalid metadata codepoint length", i3 > 0);
            MetadataRepo$Node metadataRepo$Node = (MetadataRepo$Node) this.runningAsyncCalls;
            MetadataItem metadataItem3 = typefaceEmojiRasterizer.getMetadataItem();
            int i__offset5 = metadataItem3.__offset(16);
            if (i__offset5 != 0) {
                int i9 = i__offset5 + metadataItem3.bb_pos;
                i4 = ((ByteBuffer) metadataItem3.bb).getInt(((ByteBuffer) metadataItem3.bb).getInt(i9) + i9);
            } else {
                i4 = 0;
            }
            metadataRepo$Node.put(typefaceEmojiRasterizer, 0, i4 - 1);
        }
    }

    public Dispatcher(Animations animations) {
        this.executorServiceOrNull = animations;
    }

    public Dispatcher(FloatAnimationSpec floatAnimationSpec) {
        this(new Toolbar.AnonymousClass1(24, floatAnimationSpec));
    }
}
