package androidx.work;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Application;
import android.app.job.JobParameters;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.appcompat.view.menu.CascadingMenuPopup$3$1;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.DropDownListView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.camera.camera2.internal.ZoomControl;
import androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService;
import androidx.camera.core.impl.utils.executor.SequentialExecutor;
import androidx.camera.core.impl.utils.futures.ChainingListenableFuture;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.impl.utils.futures.ListFuture;
import androidx.camera.core.processing.Edge;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.unit.Density;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.app.ActivityRecreator;
import androidx.core.content.res.CamUtils;
import androidx.core.view.ViewCompat;
import androidx.core.widget.AutoScrollHelper$ClampedScroller;
import androidx.core.widget.ListViewAutoScrollHelper;
import androidx.customview.widget.ViewDragHelper;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManagerImpl;
import androidx.fragment.app.SpecialEffectsController$FragmentStateManagerOperation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DefaultItemAnimator.AnonymousClass4;
import androidx.recyclerview.widget.FastScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.room.InvalidationTracker;
import androidx.room.TransactionExecutor;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import androidx.work.impl.WorkerWrapper;
import androidx.work.impl.background.greedy.DelayedWorkTracker;
import androidx.work.impl.constraints.WorkConstraintsTrackerKt;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.WorkForegroundRunnable;
import androidx.work.impl.utils.WorkForegroundUpdater;
import androidx.work.impl.utils.futures.AbstractFuture;
import androidx.work.impl.utils.futures.SettableFuture;
import coil.disk.RealDiskCache;
import coil.memory.RealWeakMemoryCache;
import coil.network.RealNetworkObserver;
import com.caverock.androidsvg.SVGAndroidRenderer;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api$Client;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.zaae;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.gms.common.api.internal.zact;
import com.google.android.gms.common.internal.AccountAccessor;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.internal.mlkit_vision_barcode.zzbg;
import com.google.android.gms.internal.mlkit_vision_barcode.zzbm;
import com.google.android.gms.internal.mlkit_vision_barcode.zzbq;
import com.google.android.gms.internal.mlkit_vision_barcode.zzbw;
import com.google.android.gms.internal.mlkit_vision_barcode.zzfi;
import com.google.android.gms.internal.mlkit_vision_barcode.zzft;
import com.google.android.gms.internal.mlkit_vision_barcode.zzfv;
import com.google.android.gms.internal.mlkit_vision_barcode.zzqd;
import com.google.android.gms.internal.mlkit_vision_barcode.zzra;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrc;
import com.google.android.gms.internal.mlkit_vision_barcode.zzwp;
import com.google.android.gms.signin.internal.zak;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.zzh;
import com.google.android.gms.tasks.zzp;
import com.google.android.gms.tasks.zzt;
import com.google.android.gms.tasks.zzw;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.textfield.ClearTextEndIconDelegate;
import com.google.android.material.textfield.DropdownMenuEndIconDelegate;
import com.google.android.material.textfield.PasswordToggleEndIconDelegate;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.components.ComponentRuntime$$Lambda$5;
import com.google.firebase.components.LazySet;
import com.google.firebase.components.OptionalProvider;
import com.google.firebase.components.OptionalProvider$$Lambda$4;
import com.google.firebase.inject.Provider;
import com.google.mlkit.common.sdkinternal.zzn;
import com.google.mlkit.vision.barcode.internal.zzl;
import com.google.zxing.qrcode.encoder.MinimalEncoder;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import kotlin.Unit;
import kotlin.collections.EmptySet;
import kotlin.collections.SetsKt;
import kotlin.collections.builders.SetBuilder;
import kotlin.io.CloseableKt;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskLoggerKt;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Worker extends ListenableWorker {
    public SettableFuture mFuture;

    /* JADX INFO: renamed from: androidx.work.Worker$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class AnonymousClass1 implements Runnable {
        public final /* synthetic */ int $r8$classId;
        public final Object this$0;

        public /* synthetic */ AnonymousClass1(int i, Object obj) {
            this.$r8$classId = i;
            this.this$0 = obj;
        }

        private final void run$androidx$camera$core$impl$utils$executor$SequentialExecutor$QueueWorker() {
            try {
                workOnQueue();
            } catch (Error e) {
                synchronized (((SequentialExecutor) this.this$0).mQueue) {
                    ((SequentialExecutor) this.this$0).mWorkerRunningState = 1;
                    throw e;
                }
            }
        }

        private final void run$androidx$room$InvalidationTracker$refreshRunnable$1() {
            Set setCheckUpdatedTable;
            ReentrantReadWriteLock.ReadLock lock = ((InvalidationTracker) this.this$0).database.readWriteLock.readLock();
            lock.lock();
            try {
                try {
                    if (!((InvalidationTracker) this.this$0).ensureInitialization$room_runtime_release()) {
                        lock.unlock();
                        return;
                    }
                    if (!((InvalidationTracker) this.this$0).pendingRefresh.compareAndSet(true, false)) {
                        lock.unlock();
                        return;
                    }
                    if (((InvalidationTracker) this.this$0).database.getOpenHelper().getWritableDatabase().inTransaction()) {
                        lock.unlock();
                        return;
                    }
                    FrameworkSQLiteDatabase writableDatabase = ((InvalidationTracker) this.this$0).database.getOpenHelper().getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        setCheckUpdatedTable = checkUpdatedTable();
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                        lock.unlock();
                        if (setCheckUpdatedTable.isEmpty()) {
                            return;
                        }
                        InvalidationTracker invalidationTracker = (InvalidationTracker) this.this$0;
                        synchronized (invalidationTracker.observerMap) {
                            try {
                                Iterator it = invalidationTracker.observerMap.iterator();
                                while (true) {
                                    SafeIterableMap.AscendingIterator ascendingIterator = (SafeIterableMap.AscendingIterator) it;
                                    if (ascendingIterator.hasNext()) {
                                        ((InvalidationTracker.ObserverWrapper) ((Map.Entry) ascendingIterator.next()).getValue()).notifyByTableInvalidStatus$room_runtime_release(setCheckUpdatedTable);
                                    } else {
                                        Unit unit = Unit.INSTANCE;
                                    }
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        writableDatabase.endTransaction();
                        throw th2;
                    }
                } catch (Throwable th3) {
                    lock.unlock();
                    throw th3;
                }
            } catch (SQLiteException e) {
                Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e);
                setCheckUpdatedTable = EmptySet.INSTANCE;
            } catch (IllegalStateException e2) {
                Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e2);
                setCheckUpdatedTable = EmptySet.INSTANCE;
            }
        }

        private final void run$com$google$android$gms$tasks$zzg() {
            synchronized (((zzh) this.this$0).zzb) {
                ((OnCanceledListener) ((zzh) this.this$0).zzc).onCanceled();
            }
        }

        public SetBuilder checkUpdatedTable() throws IOException {
            InvalidationTracker invalidationTracker = (InvalidationTracker) this.this$0;
            SetBuilder setBuilder = new SetBuilder();
            Cursor cursorQuery = invalidationTracker.database.query(new RealDiskCache.RealEditor(26, "SELECT * FROM room_table_modification_log WHERE invalidated = 1;"));
            while (cursorQuery.moveToNext()) {
                try {
                    setBuilder.add(Integer.valueOf(cursorQuery.getInt(0)));
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(cursorQuery, th);
                        throw th2;
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
            cursorQuery.close();
            SetBuilder setBuilderBuild = SetsKt.build(setBuilder);
            if (setBuilderBuild.backing.isEmpty()) {
                return setBuilderBuild;
            }
            if (((InvalidationTracker) this.this$0).cleanupStatement == null) {
                throw new IllegalStateException("Required value was null.");
            }
            FrameworkSQLiteStatement frameworkSQLiteStatement = ((InvalidationTracker) this.this$0).cleanupStatement;
            if (frameworkSQLiteStatement == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            frameworkSQLiteStatement.executeUpdateDelete();
            return setBuilderBuild;
        }

        /* JADX WARN: Code duplicated, block: B:95:0x0228  */
        @Override // java.lang.Runnable
        public final void run() {
            ActionMenuPresenter actionMenuPresenter;
            int actionMasked;
            int i;
            boolean z;
            Task taskAwaitTaskToRun;
            long jNanoTime;
            switch (this.$r8$classId) {
                case 0:
                    Worker worker = (Worker) this.this$0;
                    try {
                        worker.mFuture.set(worker.doWork());
                        return;
                    } catch (Throwable th) {
                        worker.mFuture.setException(th);
                        return;
                    }
                case 1:
                    AnimatedStateListDrawableCompat animatedStateListDrawableCompat = (AnimatedStateListDrawableCompat) this.this$0;
                    animatedStateListDrawableCompat.animate(true);
                    animatedStateListDrawableCompat.invalidateSelf();
                    return;
                case 2:
                    DropDownListView dropDownListView = (DropDownListView) this.this$0;
                    dropDownListView.mResolveHoverRunnable = null;
                    dropDownListView.drawableStateChanged();
                    return;
                case 3:
                    SearchView.SearchAutoComplete searchAutoComplete = (SearchView.SearchAutoComplete) this.this$0;
                    if (searchAutoComplete.mHasPendingShowSoftInputRequest) {
                        ((InputMethodManager) searchAutoComplete.getContext().getSystemService("input_method")).showSoftInput(searchAutoComplete, 0);
                        searchAutoComplete.mHasPendingShowSoftInputRequest = false;
                        return;
                    }
                    return;
                case 4:
                    ActionMenuView actionMenuView = ((Toolbar) this.this$0).mMenuView;
                    if (actionMenuView == null || (actionMenuPresenter = actionMenuView.mPresenter) == null) {
                        return;
                    }
                    actionMenuPresenter.showOverflowMenu();
                    return;
                case 5:
                    RealNetworkObserver realNetworkObserver = (RealNetworkObserver) this.this$0;
                    if (((HandlerScheduledExecutorService.HandlerScheduledFuture) realNetworkObserver.networkCallback).mCompleter.getAndSet(null) != null) {
                        ((Handler) realNetworkObserver.connectivityManager).removeCallbacks((HandlerScheduledExecutorService.HandlerScheduledFuture) realNetworkObserver.networkCallback);
                        return;
                    }
                    return;
                case 6:
                    run$androidx$camera$core$impl$utils$executor$SequentialExecutor$QueueWorker();
                    return;
                case 7:
                    ((ListenableFuture) this.this$0).cancel(true);
                    return;
                case 8:
                    ListFuture listFuture = (ListFuture) this.this$0;
                    listFuture.mValues = null;
                    listFuture.mFutures = null;
                    return;
                case 9:
                    AndroidComposeView androidComposeView = (AndroidComposeView) this.this$0;
                    androidComposeView.removeCallbacks(this);
                    MotionEvent motionEvent = androidComposeView.previousMotionEvent;
                    if (motionEvent == null || (actionMasked = motionEvent.getActionMasked()) == 10 || actionMasked == 1) {
                        return;
                    }
                    int i2 = (actionMasked == 7 || actionMasked == 9) ? 7 : 2;
                    AndroidComposeView androidComposeView2 = (AndroidComposeView) this.this$0;
                    androidComposeView2.sendSimulatedEvent(motionEvent, i2, androidComposeView2.relayoutTime, false);
                    return;
                case 10:
                    ListViewAutoScrollHelper listViewAutoScrollHelper = (ListViewAutoScrollHelper) this.this$0;
                    DropDownListView dropDownListView2 = listViewAutoScrollHelper.mTarget$1;
                    AutoScrollHelper$ClampedScroller autoScrollHelper$ClampedScroller = listViewAutoScrollHelper.mScroller;
                    if (listViewAutoScrollHelper.mAnimating) {
                        if (listViewAutoScrollHelper.mNeedsReset) {
                            listViewAutoScrollHelper.mNeedsReset = false;
                            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                            autoScrollHelper$ClampedScroller.mStartTime = jCurrentAnimationTimeMillis;
                            autoScrollHelper$ClampedScroller.mStopTime = -1L;
                            autoScrollHelper$ClampedScroller.mDeltaTime = jCurrentAnimationTimeMillis;
                            autoScrollHelper$ClampedScroller.mStopValue = 0.5f;
                        }
                        if ((autoScrollHelper$ClampedScroller.mStopTime > 0 && AnimationUtils.currentAnimationTimeMillis() > autoScrollHelper$ClampedScroller.mStopTime + ((long) autoScrollHelper$ClampedScroller.mEffectiveRampDown)) || !listViewAutoScrollHelper.shouldAnimate()) {
                            listViewAutoScrollHelper.mAnimating = false;
                            return;
                        }
                        if (listViewAutoScrollHelper.mNeedsCancel) {
                            listViewAutoScrollHelper.mNeedsCancel = false;
                            long jUptimeMillis = android.os.SystemClock.uptimeMillis();
                            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                            dropDownListView2.onTouchEvent(motionEventObtain);
                            motionEventObtain.recycle();
                        }
                        if (autoScrollHelper$ClampedScroller.mDeltaTime == 0) {
                            throw new RuntimeException("Cannot compute scroll delta before calling start()");
                        }
                        long jCurrentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
                        float valueAt = autoScrollHelper$ClampedScroller.getValueAt(jCurrentAnimationTimeMillis2);
                        long j = jCurrentAnimationTimeMillis2 - autoScrollHelper$ClampedScroller.mDeltaTime;
                        autoScrollHelper$ClampedScroller.mDeltaTime = jCurrentAnimationTimeMillis2;
                        listViewAutoScrollHelper.mTarget.scrollListBy((int) (j * ((valueAt * 4.0f) + ((-4.0f) * valueAt * valueAt)) * autoScrollHelper$ClampedScroller.mTargetVelocityY));
                        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                        dropDownListView2.postOnAnimation(this);
                        return;
                    }
                    return;
                case 11:
                    ((ViewDragHelper) this.this$0).setDragState(0);
                    return;
                case 12:
                    DefaultSpecialEffectsController.AnonymousClass4 anonymousClass4 = (DefaultSpecialEffectsController.AnonymousClass4) this.this$0;
                    anonymousClass4.val$container.endViewTransition(anonymousClass4.val$viewToAnimate);
                    anonymousClass4.val$animationInfo.completeSpecialEffect();
                    return;
                case 13:
                    DialogFragment dialogFragment = (DialogFragment) this.this$0;
                    dialogFragment.mOnDismissListener.onDismiss(dialogFragment.mDialog);
                    return;
                case 14:
                    ((FragmentManagerImpl) this.this$0).execPendingActions(true);
                    return;
                case 15:
                    FastScroller fastScroller = (FastScroller) this.this$0;
                    ValueAnimator valueAnimator = fastScroller.mShowHideAnimator;
                    int i3 = fastScroller.mAnimationState;
                    if (i3 != 1) {
                        i = 2;
                        if (i3 != 2) {
                            return;
                        }
                    } else {
                        i = 2;
                        valueAnimator.cancel();
                    }
                    fastScroller.mAnimationState = 3;
                    float[] fArr = new float[i];
                    fArr[0] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    fArr[1] = 0.0f;
                    valueAnimator.setFloatValues(fArr);
                    valueAnimator.setDuration(500);
                    valueAnimator.start();
                    return;
                case 16:
                    RecyclerView recyclerView = (RecyclerView) this.this$0;
                    RecyclerView.ItemAnimator itemAnimator = recyclerView.mItemAnimator;
                    if (itemAnimator != null) {
                        final DefaultItemAnimator defaultItemAnimator = (DefaultItemAnimator) itemAnimator;
                        long j2 = defaultItemAnimator.mRemoveDuration;
                        ArrayList arrayList = defaultItemAnimator.mPendingRemovals;
                        boolean zIsEmpty = arrayList.isEmpty();
                        ArrayList arrayList2 = defaultItemAnimator.mPendingMoves;
                        boolean zIsEmpty2 = arrayList2.isEmpty();
                        ArrayList arrayList3 = defaultItemAnimator.mPendingChanges;
                        boolean zIsEmpty3 = arrayList3.isEmpty();
                        ArrayList arrayList4 = defaultItemAnimator.mPendingAdditions;
                        boolean zIsEmpty4 = arrayList4.isEmpty();
                        if (zIsEmpty && zIsEmpty2 && zIsEmpty4 && zIsEmpty3) {
                            z = false;
                        } else {
                            int size = arrayList.size();
                            for (int i4 = 0; i4 < size; i4++) {
                                RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) arrayList.get(i4);
                                View view = viewHolder.itemView;
                                boolean z2 = zIsEmpty4;
                                ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
                                defaultItemAnimator.mRemoveAnimations.add(viewHolder);
                                viewPropertyAnimatorAnimate.setDuration(j2).alpha(0.0f).setListener(defaultItemAnimator.new AnonymousClass4(viewHolder, viewPropertyAnimatorAnimate, view)).start();
                                zIsEmpty4 = z2;
                                size = size;
                            }
                            boolean z3 = zIsEmpty4;
                            arrayList.clear();
                            if (!zIsEmpty2) {
                                final ArrayList arrayList5 = new ArrayList();
                                arrayList5.addAll(arrayList2);
                                defaultItemAnimator.mMovesList.add(arrayList5);
                                arrayList2.clear();
                                final int i5 = 0;
                                Runnable runnable = new Runnable() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.1
                                    public final /* synthetic */ int $r8$classId;
                                    public final /* synthetic */ DefaultItemAnimator this$0;
                                    public final /* synthetic */ ArrayList val$moves;

                                    public /* synthetic */ AnonymousClass1() {
                                        i = i5;
                                        defaultItemAnimator = defaultItemAnimator;
                                        arrayList = arrayList5;
                                    }

                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        switch (i) {
                                            case 0:
                                                ArrayList arrayList6 = arrayList;
                                                int size2 = arrayList6.size();
                                                int i6 = 0;
                                                while (true) {
                                                    DefaultItemAnimator defaultItemAnimator2 = defaultItemAnimator;
                                                    if (i6 >= size2) {
                                                        arrayList6.clear();
                                                        defaultItemAnimator2.mMovesList.remove(arrayList6);
                                                    } else {
                                                        Object obj = arrayList6.get(i6);
                                                        i6++;
                                                        MoveInfo moveInfo = (MoveInfo) obj;
                                                        RecyclerView.ViewHolder viewHolder2 = moveInfo.holder;
                                                        int i7 = moveInfo.fromX;
                                                        int i8 = moveInfo.fromY;
                                                        int i9 = moveInfo.toX;
                                                        int i10 = moveInfo.toY;
                                                        defaultItemAnimator2.getClass();
                                                        View view2 = viewHolder2.itemView;
                                                        int i11 = i9 - i7;
                                                        int i12 = i10 - i8;
                                                        if (i11 != 0) {
                                                            view2.animate().translationX(0.0f);
                                                        }
                                                        if (i12 != 0) {
                                                            view2.animate().translationY(0.0f);
                                                        }
                                                        ViewPropertyAnimator viewPropertyAnimatorAnimate2 = view2.animate();
                                                        defaultItemAnimator2.mMoveAnimations.add(viewHolder2);
                                                        viewPropertyAnimatorAnimate2.setDuration(defaultItemAnimator2.mMoveDuration).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.6
                                                            public final /* synthetic */ ViewPropertyAnimator val$animation;
                                                            public final /* synthetic */ int val$deltaX;
                                                            public final /* synthetic */ int val$deltaY;
                                                            public final /* synthetic */ RecyclerView.ViewHolder val$holder;
                                                            public final /* synthetic */ View val$view;

                                                            public AnonymousClass6() {
                                                                viewHolder = viewHolder2;
                                                                i = i11;
                                                                view = view2;
                                                                i = i12;
                                                                viewPropertyAnimator = viewPropertyAnimatorAnimate2;
                                                            }

                                                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                            public final void onAnimationCancel(Animator animator) {
                                                                int i13 = i;
                                                                View view3 = view;
                                                                if (i13 != 0) {
                                                                    view3.setTranslationX(0.0f);
                                                                }
                                                                if (i != 0) {
                                                                    view3.setTranslationY(0.0f);
                                                                }
                                                            }

                                                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                            public final void onAnimationEnd(Animator animator) {
                                                                viewPropertyAnimator.setListener(null);
                                                                DefaultItemAnimator defaultItemAnimator3 = DefaultItemAnimator.this;
                                                                RecyclerView.ViewHolder viewHolder3 = viewHolder;
                                                                defaultItemAnimator3.dispatchAnimationFinished(viewHolder3);
                                                                defaultItemAnimator3.mMoveAnimations.remove(viewHolder3);
                                                                defaultItemAnimator3.dispatchFinishedWhenDone();
                                                            }

                                                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                            public final void onAnimationStart(Animator animator) {
                                                                DefaultItemAnimator.this.getClass();
                                                            }
                                                        }).start();
                                                    }
                                                    break;
                                                }
                                                break;
                                            case 1:
                                                ArrayList arrayList7 = arrayList;
                                                int size3 = arrayList7.size();
                                                int i13 = 0;
                                                while (true) {
                                                    DefaultItemAnimator defaultItemAnimator3 = defaultItemAnimator;
                                                    if (i13 >= size3) {
                                                        arrayList7.clear();
                                                        defaultItemAnimator3.mChangesList.remove(arrayList7);
                                                        break;
                                                    } else {
                                                        Object obj2 = arrayList7.get(i13);
                                                        i13++;
                                                        ChangeInfo changeInfo = (ChangeInfo) obj2;
                                                        ArrayList arrayList8 = defaultItemAnimator3.mChangeAnimations;
                                                        long j3 = defaultItemAnimator3.mChangeDuration;
                                                        RecyclerView.ViewHolder viewHolder3 = changeInfo.oldHolder;
                                                        View view3 = viewHolder3 == null ? null : viewHolder3.itemView;
                                                        RecyclerView.ViewHolder viewHolder4 = changeInfo.newHolder;
                                                        View view4 = viewHolder4 != null ? viewHolder4.itemView : null;
                                                        if (view3 != null) {
                                                            ViewPropertyAnimator duration = view3.animate().setDuration(j3);
                                                            arrayList8.add(changeInfo.oldHolder);
                                                            duration.translationX(changeInfo.toX - changeInfo.fromX);
                                                            duration.translationY(changeInfo.toY - changeInfo.fromY);
                                                            duration.alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.7
                                                                public final /* synthetic */ int $r8$classId;
                                                                public final /* synthetic */ DefaultItemAnimator this$0;
                                                                public final /* synthetic */ ChangeInfo val$changeInfo;
                                                                public final /* synthetic */ ViewPropertyAnimator val$oldViewAnim;
                                                                public final /* synthetic */ View val$view;

                                                                public /* synthetic */ AnonymousClass7() {
                                                                    i = i;
                                                                    defaultItemAnimator = defaultItemAnimator3;
                                                                    changeInfo = changeInfo;
                                                                    viewPropertyAnimator = duration;
                                                                    view = view3;
                                                                }

                                                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                public final void onAnimationEnd(Animator animator) {
                                                                    switch (i) {
                                                                        case 0:
                                                                            viewPropertyAnimator.setListener(null);
                                                                            View view5 = view;
                                                                            view5.setAlpha(1.0f);
                                                                            view5.setTranslationX(0.0f);
                                                                            view5.setTranslationY(0.0f);
                                                                            ChangeInfo changeInfo2 = changeInfo;
                                                                            RecyclerView.ViewHolder viewHolder5 = changeInfo2.oldHolder;
                                                                            DefaultItemAnimator defaultItemAnimator4 = defaultItemAnimator;
                                                                            defaultItemAnimator4.dispatchAnimationFinished(viewHolder5);
                                                                            defaultItemAnimator4.mChangeAnimations.remove(changeInfo2.oldHolder);
                                                                            defaultItemAnimator4.dispatchFinishedWhenDone();
                                                                            break;
                                                                        default:
                                                                            viewPropertyAnimator.setListener(null);
                                                                            View view6 = view;
                                                                            view6.setAlpha(1.0f);
                                                                            view6.setTranslationX(0.0f);
                                                                            view6.setTranslationY(0.0f);
                                                                            ChangeInfo changeInfo3 = changeInfo;
                                                                            RecyclerView.ViewHolder viewHolder6 = changeInfo3.newHolder;
                                                                            DefaultItemAnimator defaultItemAnimator5 = defaultItemAnimator;
                                                                            defaultItemAnimator5.dispatchAnimationFinished(viewHolder6);
                                                                            defaultItemAnimator5.mChangeAnimations.remove(changeInfo3.newHolder);
                                                                            defaultItemAnimator5.dispatchFinishedWhenDone();
                                                                            break;
                                                                    }
                                                                }

                                                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                public final void onAnimationStart(Animator animator) {
                                                                    switch (i) {
                                                                        case 0:
                                                                            RecyclerView.ViewHolder viewHolder5 = changeInfo.oldHolder;
                                                                            defaultItemAnimator.getClass();
                                                                            break;
                                                                        default:
                                                                            RecyclerView.ViewHolder viewHolder6 = changeInfo.newHolder;
                                                                            defaultItemAnimator.getClass();
                                                                            break;
                                                                    }
                                                                }
                                                            }).start();
                                                        }
                                                        if (view4 != null) {
                                                            ViewPropertyAnimator viewPropertyAnimatorAnimate3 = view4.animate();
                                                            arrayList8.add(changeInfo.newHolder);
                                                            viewPropertyAnimatorAnimate3.translationX(0.0f).translationY(0.0f).setDuration(j3).alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.7
                                                                public final /* synthetic */ int $r8$classId;
                                                                public final /* synthetic */ DefaultItemAnimator this$0;
                                                                public final /* synthetic */ ChangeInfo val$changeInfo;
                                                                public final /* synthetic */ ViewPropertyAnimator val$oldViewAnim;
                                                                public final /* synthetic */ View val$view;

                                                                public /* synthetic */ AnonymousClass7() {
                                                                    i = i;
                                                                    defaultItemAnimator = defaultItemAnimator3;
                                                                    changeInfo = changeInfo;
                                                                    viewPropertyAnimator = viewPropertyAnimatorAnimate3;
                                                                    view = view4;
                                                                }

                                                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                public final void onAnimationEnd(Animator animator) {
                                                                    switch (i) {
                                                                        case 0:
                                                                            viewPropertyAnimator.setListener(null);
                                                                            View view5 = view;
                                                                            view5.setAlpha(1.0f);
                                                                            view5.setTranslationX(0.0f);
                                                                            view5.setTranslationY(0.0f);
                                                                            ChangeInfo changeInfo2 = changeInfo;
                                                                            RecyclerView.ViewHolder viewHolder5 = changeInfo2.oldHolder;
                                                                            DefaultItemAnimator defaultItemAnimator4 = defaultItemAnimator;
                                                                            defaultItemAnimator4.dispatchAnimationFinished(viewHolder5);
                                                                            defaultItemAnimator4.mChangeAnimations.remove(changeInfo2.oldHolder);
                                                                            defaultItemAnimator4.dispatchFinishedWhenDone();
                                                                            break;
                                                                        default:
                                                                            viewPropertyAnimator.setListener(null);
                                                                            View view6 = view;
                                                                            view6.setAlpha(1.0f);
                                                                            view6.setTranslationX(0.0f);
                                                                            view6.setTranslationY(0.0f);
                                                                            ChangeInfo changeInfo3 = changeInfo;
                                                                            RecyclerView.ViewHolder viewHolder6 = changeInfo3.newHolder;
                                                                            DefaultItemAnimator defaultItemAnimator5 = defaultItemAnimator;
                                                                            defaultItemAnimator5.dispatchAnimationFinished(viewHolder6);
                                                                            defaultItemAnimator5.mChangeAnimations.remove(changeInfo3.newHolder);
                                                                            defaultItemAnimator5.dispatchFinishedWhenDone();
                                                                            break;
                                                                    }
                                                                }

                                                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                public final void onAnimationStart(Animator animator) {
                                                                    switch (i) {
                                                                        case 0:
                                                                            RecyclerView.ViewHolder viewHolder5 = changeInfo.oldHolder;
                                                                            defaultItemAnimator.getClass();
                                                                            break;
                                                                        default:
                                                                            RecyclerView.ViewHolder viewHolder6 = changeInfo.newHolder;
                                                                            defaultItemAnimator.getClass();
                                                                            break;
                                                                    }
                                                                }
                                                            }).start();
                                                        }
                                                    }
                                                }
                                                break;
                                            default:
                                                ArrayList arrayList9 = arrayList;
                                                int size4 = arrayList9.size();
                                                int i14 = 0;
                                                while (true) {
                                                    DefaultItemAnimator defaultItemAnimator4 = defaultItemAnimator;
                                                    if (i14 >= size4) {
                                                        arrayList9.clear();
                                                        defaultItemAnimator4.mAdditionsList.remove(arrayList9);
                                                    } else {
                                                        Object obj3 = arrayList9.get(i14);
                                                        i14++;
                                                        RecyclerView.ViewHolder viewHolder5 = (RecyclerView.ViewHolder) obj3;
                                                        defaultItemAnimator4.getClass();
                                                        View view5 = viewHolder5.itemView;
                                                        ViewPropertyAnimator viewPropertyAnimatorAnimate4 = view5.animate();
                                                        defaultItemAnimator4.mAddAnimations.add(viewHolder5);
                                                        viewPropertyAnimatorAnimate4.alpha(1.0f).setDuration(defaultItemAnimator4.mAddDuration).setListener(defaultItemAnimator4.new AnonymousClass4(viewHolder5, view5, viewPropertyAnimatorAnimate4)).start();
                                                    }
                                                    break;
                                                }
                                                break;
                                        }
                                    }
                                };
                                if (zIsEmpty) {
                                    runnable.run();
                                } else {
                                    View view2 = ((DefaultItemAnimator.MoveInfo) arrayList5.get(0)).holder.itemView;
                                    WeakHashMap weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
                                    view2.postOnAnimationDelayed(runnable, j2);
                                }
                            }
                            if (!zIsEmpty3) {
                                final ArrayList arrayList6 = new ArrayList();
                                arrayList6.addAll(arrayList3);
                                defaultItemAnimator.mChangesList.add(arrayList6);
                                arrayList3.clear();
                                final int i6 = 1;
                                Runnable runnable2 = new Runnable() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.1
                                    public final /* synthetic */ int $r8$classId;
                                    public final /* synthetic */ DefaultItemAnimator this$0;
                                    public final /* synthetic */ ArrayList val$moves;

                                    public /* synthetic */ AnonymousClass1() {
                                        i = i6;
                                        defaultItemAnimator = defaultItemAnimator;
                                        arrayList = arrayList6;
                                    }

                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        switch (i) {
                                            case 0:
                                                ArrayList arrayList7 = arrayList;
                                                int size2 = arrayList7.size();
                                                int i7 = 0;
                                                while (true) {
                                                    DefaultItemAnimator defaultItemAnimator2 = defaultItemAnimator;
                                                    if (i7 >= size2) {
                                                        arrayList7.clear();
                                                        defaultItemAnimator2.mMovesList.remove(arrayList7);
                                                    } else {
                                                        Object obj = arrayList7.get(i7);
                                                        i7++;
                                                        MoveInfo moveInfo = (MoveInfo) obj;
                                                        RecyclerView.ViewHolder viewHolder2 = moveInfo.holder;
                                                        int i8 = moveInfo.fromX;
                                                        int i9 = moveInfo.fromY;
                                                        int i10 = moveInfo.toX;
                                                        int i11 = moveInfo.toY;
                                                        defaultItemAnimator2.getClass();
                                                        View view3 = viewHolder2.itemView;
                                                        int i12 = i10 - i8;
                                                        int i13 = i11 - i9;
                                                        if (i12 != 0) {
                                                            view3.animate().translationX(0.0f);
                                                        }
                                                        if (i13 != 0) {
                                                            view3.animate().translationY(0.0f);
                                                        }
                                                        ViewPropertyAnimator viewPropertyAnimatorAnimate2 = view3.animate();
                                                        defaultItemAnimator2.mMoveAnimations.add(viewHolder2);
                                                        viewPropertyAnimatorAnimate2.setDuration(defaultItemAnimator2.mMoveDuration).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.6
                                                            public final /* synthetic */ ViewPropertyAnimator val$animation;
                                                            public final /* synthetic */ int val$deltaX;
                                                            public final /* synthetic */ int val$deltaY;
                                                            public final /* synthetic */ RecyclerView.ViewHolder val$holder;
                                                            public final /* synthetic */ View val$view;

                                                            public AnonymousClass6() {
                                                                viewHolder = viewHolder2;
                                                                i = i12;
                                                                view = view3;
                                                                i = i13;
                                                                viewPropertyAnimator = viewPropertyAnimatorAnimate2;
                                                            }

                                                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                            public final void onAnimationCancel(Animator animator) {
                                                                int i14 = i;
                                                                View view4 = view;
                                                                if (i14 != 0) {
                                                                    view4.setTranslationX(0.0f);
                                                                }
                                                                if (i != 0) {
                                                                    view4.setTranslationY(0.0f);
                                                                }
                                                            }

                                                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                            public final void onAnimationEnd(Animator animator) {
                                                                viewPropertyAnimator.setListener(null);
                                                                DefaultItemAnimator defaultItemAnimator3 = DefaultItemAnimator.this;
                                                                RecyclerView.ViewHolder viewHolder3 = viewHolder;
                                                                defaultItemAnimator3.dispatchAnimationFinished(viewHolder3);
                                                                defaultItemAnimator3.mMoveAnimations.remove(viewHolder3);
                                                                defaultItemAnimator3.dispatchFinishedWhenDone();
                                                            }

                                                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                            public final void onAnimationStart(Animator animator) {
                                                                DefaultItemAnimator.this.getClass();
                                                            }
                                                        }).start();
                                                    }
                                                    break;
                                                }
                                                break;
                                            case 1:
                                                ArrayList arrayList8 = arrayList;
                                                int size3 = arrayList8.size();
                                                int i14 = 0;
                                                while (true) {
                                                    DefaultItemAnimator defaultItemAnimator3 = defaultItemAnimator;
                                                    if (i14 >= size3) {
                                                        arrayList8.clear();
                                                        defaultItemAnimator3.mChangesList.remove(arrayList8);
                                                        break;
                                                    } else {
                                                        Object obj2 = arrayList8.get(i14);
                                                        i14++;
                                                        ChangeInfo changeInfo = (ChangeInfo) obj2;
                                                        ArrayList arrayList9 = defaultItemAnimator3.mChangeAnimations;
                                                        long j3 = defaultItemAnimator3.mChangeDuration;
                                                        RecyclerView.ViewHolder viewHolder3 = changeInfo.oldHolder;
                                                        View view4 = viewHolder3 == null ? null : viewHolder3.itemView;
                                                        RecyclerView.ViewHolder viewHolder4 = changeInfo.newHolder;
                                                        View view5 = viewHolder4 != null ? viewHolder4.itemView : null;
                                                        if (view4 != null) {
                                                            ViewPropertyAnimator duration = view4.animate().setDuration(j3);
                                                            arrayList9.add(changeInfo.oldHolder);
                                                            duration.translationX(changeInfo.toX - changeInfo.fromX);
                                                            duration.translationY(changeInfo.toY - changeInfo.fromY);
                                                            duration.alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.7
                                                                public final /* synthetic */ int $r8$classId;
                                                                public final /* synthetic */ DefaultItemAnimator this$0;
                                                                public final /* synthetic */ ChangeInfo val$changeInfo;
                                                                public final /* synthetic */ ViewPropertyAnimator val$oldViewAnim;
                                                                public final /* synthetic */ View val$view;

                                                                public /* synthetic */ AnonymousClass7() {
                                                                    i = i;
                                                                    defaultItemAnimator = defaultItemAnimator3;
                                                                    changeInfo = changeInfo;
                                                                    viewPropertyAnimator = duration;
                                                                    view = view4;
                                                                }

                                                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                public final void onAnimationEnd(Animator animator) {
                                                                    switch (i) {
                                                                        case 0:
                                                                            viewPropertyAnimator.setListener(null);
                                                                            View view6 = view;
                                                                            view6.setAlpha(1.0f);
                                                                            view6.setTranslationX(0.0f);
                                                                            view6.setTranslationY(0.0f);
                                                                            ChangeInfo changeInfo2 = changeInfo;
                                                                            RecyclerView.ViewHolder viewHolder5 = changeInfo2.oldHolder;
                                                                            DefaultItemAnimator defaultItemAnimator4 = defaultItemAnimator;
                                                                            defaultItemAnimator4.dispatchAnimationFinished(viewHolder5);
                                                                            defaultItemAnimator4.mChangeAnimations.remove(changeInfo2.oldHolder);
                                                                            defaultItemAnimator4.dispatchFinishedWhenDone();
                                                                            break;
                                                                        default:
                                                                            viewPropertyAnimator.setListener(null);
                                                                            View view7 = view;
                                                                            view7.setAlpha(1.0f);
                                                                            view7.setTranslationX(0.0f);
                                                                            view7.setTranslationY(0.0f);
                                                                            ChangeInfo changeInfo3 = changeInfo;
                                                                            RecyclerView.ViewHolder viewHolder6 = changeInfo3.newHolder;
                                                                            DefaultItemAnimator defaultItemAnimator5 = defaultItemAnimator;
                                                                            defaultItemAnimator5.dispatchAnimationFinished(viewHolder6);
                                                                            defaultItemAnimator5.mChangeAnimations.remove(changeInfo3.newHolder);
                                                                            defaultItemAnimator5.dispatchFinishedWhenDone();
                                                                            break;
                                                                    }
                                                                }

                                                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                public final void onAnimationStart(Animator animator) {
                                                                    switch (i) {
                                                                        case 0:
                                                                            RecyclerView.ViewHolder viewHolder5 = changeInfo.oldHolder;
                                                                            defaultItemAnimator.getClass();
                                                                            break;
                                                                        default:
                                                                            RecyclerView.ViewHolder viewHolder6 = changeInfo.newHolder;
                                                                            defaultItemAnimator.getClass();
                                                                            break;
                                                                    }
                                                                }
                                                            }).start();
                                                        }
                                                        if (view5 != null) {
                                                            ViewPropertyAnimator viewPropertyAnimatorAnimate3 = view5.animate();
                                                            arrayList9.add(changeInfo.newHolder);
                                                            viewPropertyAnimatorAnimate3.translationX(0.0f).translationY(0.0f).setDuration(j3).alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.7
                                                                public final /* synthetic */ int $r8$classId;
                                                                public final /* synthetic */ DefaultItemAnimator this$0;
                                                                public final /* synthetic */ ChangeInfo val$changeInfo;
                                                                public final /* synthetic */ ViewPropertyAnimator val$oldViewAnim;
                                                                public final /* synthetic */ View val$view;

                                                                public /* synthetic */ AnonymousClass7() {
                                                                    i = i;
                                                                    defaultItemAnimator = defaultItemAnimator3;
                                                                    changeInfo = changeInfo;
                                                                    viewPropertyAnimator = viewPropertyAnimatorAnimate3;
                                                                    view = view5;
                                                                }

                                                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                public final void onAnimationEnd(Animator animator) {
                                                                    switch (i) {
                                                                        case 0:
                                                                            viewPropertyAnimator.setListener(null);
                                                                            View view6 = view;
                                                                            view6.setAlpha(1.0f);
                                                                            view6.setTranslationX(0.0f);
                                                                            view6.setTranslationY(0.0f);
                                                                            ChangeInfo changeInfo2 = changeInfo;
                                                                            RecyclerView.ViewHolder viewHolder5 = changeInfo2.oldHolder;
                                                                            DefaultItemAnimator defaultItemAnimator4 = defaultItemAnimator;
                                                                            defaultItemAnimator4.dispatchAnimationFinished(viewHolder5);
                                                                            defaultItemAnimator4.mChangeAnimations.remove(changeInfo2.oldHolder);
                                                                            defaultItemAnimator4.dispatchFinishedWhenDone();
                                                                            break;
                                                                        default:
                                                                            viewPropertyAnimator.setListener(null);
                                                                            View view7 = view;
                                                                            view7.setAlpha(1.0f);
                                                                            view7.setTranslationX(0.0f);
                                                                            view7.setTranslationY(0.0f);
                                                                            ChangeInfo changeInfo3 = changeInfo;
                                                                            RecyclerView.ViewHolder viewHolder6 = changeInfo3.newHolder;
                                                                            DefaultItemAnimator defaultItemAnimator5 = defaultItemAnimator;
                                                                            defaultItemAnimator5.dispatchAnimationFinished(viewHolder6);
                                                                            defaultItemAnimator5.mChangeAnimations.remove(changeInfo3.newHolder);
                                                                            defaultItemAnimator5.dispatchFinishedWhenDone();
                                                                            break;
                                                                    }
                                                                }

                                                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                public final void onAnimationStart(Animator animator) {
                                                                    switch (i) {
                                                                        case 0:
                                                                            RecyclerView.ViewHolder viewHolder5 = changeInfo.oldHolder;
                                                                            defaultItemAnimator.getClass();
                                                                            break;
                                                                        default:
                                                                            RecyclerView.ViewHolder viewHolder6 = changeInfo.newHolder;
                                                                            defaultItemAnimator.getClass();
                                                                            break;
                                                                    }
                                                                }
                                                            }).start();
                                                        }
                                                    }
                                                }
                                                break;
                                            default:
                                                ArrayList arrayList10 = arrayList;
                                                int size4 = arrayList10.size();
                                                int i15 = 0;
                                                while (true) {
                                                    DefaultItemAnimator defaultItemAnimator4 = defaultItemAnimator;
                                                    if (i15 >= size4) {
                                                        arrayList10.clear();
                                                        defaultItemAnimator4.mAdditionsList.remove(arrayList10);
                                                    } else {
                                                        Object obj3 = arrayList10.get(i15);
                                                        i15++;
                                                        RecyclerView.ViewHolder viewHolder5 = (RecyclerView.ViewHolder) obj3;
                                                        defaultItemAnimator4.getClass();
                                                        View view6 = viewHolder5.itemView;
                                                        ViewPropertyAnimator viewPropertyAnimatorAnimate4 = view6.animate();
                                                        defaultItemAnimator4.mAddAnimations.add(viewHolder5);
                                                        viewPropertyAnimatorAnimate4.alpha(1.0f).setDuration(defaultItemAnimator4.mAddDuration).setListener(defaultItemAnimator4.new AnonymousClass4(viewHolder5, view6, viewPropertyAnimatorAnimate4)).start();
                                                    }
                                                    break;
                                                }
                                                break;
                                        }
                                    }
                                };
                                if (zIsEmpty) {
                                    runnable2.run();
                                } else {
                                    View view3 = ((DefaultItemAnimator.ChangeInfo) arrayList6.get(0)).oldHolder.itemView;
                                    WeakHashMap weakHashMap3 = ViewCompat.sViewPropertyAnimatorMap;
                                    view3.postOnAnimationDelayed(runnable2, j2);
                                }
                            }
                            if (z3) {
                                z = false;
                            } else {
                                final ArrayList arrayList7 = new ArrayList();
                                arrayList7.addAll(arrayList4);
                                defaultItemAnimator.mAdditionsList.add(arrayList7);
                                arrayList4.clear();
                                final int i7 = 2;
                                Runnable runnable3 = new Runnable() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.1
                                    public final /* synthetic */ int $r8$classId;
                                    public final /* synthetic */ DefaultItemAnimator this$0;
                                    public final /* synthetic */ ArrayList val$moves;

                                    public /* synthetic */ AnonymousClass1() {
                                        i = i7;
                                        defaultItemAnimator = defaultItemAnimator;
                                        arrayList = arrayList7;
                                    }

                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        switch (i) {
                                            case 0:
                                                ArrayList arrayList8 = arrayList;
                                                int size2 = arrayList8.size();
                                                int i8 = 0;
                                                while (true) {
                                                    DefaultItemAnimator defaultItemAnimator2 = defaultItemAnimator;
                                                    if (i8 >= size2) {
                                                        arrayList8.clear();
                                                        defaultItemAnimator2.mMovesList.remove(arrayList8);
                                                    } else {
                                                        Object obj = arrayList8.get(i8);
                                                        i8++;
                                                        MoveInfo moveInfo = (MoveInfo) obj;
                                                        RecyclerView.ViewHolder viewHolder2 = moveInfo.holder;
                                                        int i9 = moveInfo.fromX;
                                                        int i10 = moveInfo.fromY;
                                                        int i11 = moveInfo.toX;
                                                        int i12 = moveInfo.toY;
                                                        defaultItemAnimator2.getClass();
                                                        View view4 = viewHolder2.itemView;
                                                        int i13 = i11 - i9;
                                                        int i14 = i12 - i10;
                                                        if (i13 != 0) {
                                                            view4.animate().translationX(0.0f);
                                                        }
                                                        if (i14 != 0) {
                                                            view4.animate().translationY(0.0f);
                                                        }
                                                        ViewPropertyAnimator viewPropertyAnimatorAnimate2 = view4.animate();
                                                        defaultItemAnimator2.mMoveAnimations.add(viewHolder2);
                                                        viewPropertyAnimatorAnimate2.setDuration(defaultItemAnimator2.mMoveDuration).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.6
                                                            public final /* synthetic */ ViewPropertyAnimator val$animation;
                                                            public final /* synthetic */ int val$deltaX;
                                                            public final /* synthetic */ int val$deltaY;
                                                            public final /* synthetic */ RecyclerView.ViewHolder val$holder;
                                                            public final /* synthetic */ View val$view;

                                                            public AnonymousClass6() {
                                                                viewHolder = viewHolder2;
                                                                i = i13;
                                                                view = view4;
                                                                i = i14;
                                                                viewPropertyAnimator = viewPropertyAnimatorAnimate2;
                                                            }

                                                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                            public final void onAnimationCancel(Animator animator) {
                                                                int i15 = i;
                                                                View view5 = view;
                                                                if (i15 != 0) {
                                                                    view5.setTranslationX(0.0f);
                                                                }
                                                                if (i != 0) {
                                                                    view5.setTranslationY(0.0f);
                                                                }
                                                            }

                                                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                            public final void onAnimationEnd(Animator animator) {
                                                                viewPropertyAnimator.setListener(null);
                                                                DefaultItemAnimator defaultItemAnimator3 = DefaultItemAnimator.this;
                                                                RecyclerView.ViewHolder viewHolder3 = viewHolder;
                                                                defaultItemAnimator3.dispatchAnimationFinished(viewHolder3);
                                                                defaultItemAnimator3.mMoveAnimations.remove(viewHolder3);
                                                                defaultItemAnimator3.dispatchFinishedWhenDone();
                                                            }

                                                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                            public final void onAnimationStart(Animator animator) {
                                                                DefaultItemAnimator.this.getClass();
                                                            }
                                                        }).start();
                                                    }
                                                    break;
                                                }
                                                break;
                                            case 1:
                                                ArrayList arrayList9 = arrayList;
                                                int size3 = arrayList9.size();
                                                int i15 = 0;
                                                while (true) {
                                                    DefaultItemAnimator defaultItemAnimator3 = defaultItemAnimator;
                                                    if (i15 >= size3) {
                                                        arrayList9.clear();
                                                        defaultItemAnimator3.mChangesList.remove(arrayList9);
                                                        break;
                                                    } else {
                                                        Object obj2 = arrayList9.get(i15);
                                                        i15++;
                                                        ChangeInfo changeInfo = (ChangeInfo) obj2;
                                                        ArrayList arrayList10 = defaultItemAnimator3.mChangeAnimations;
                                                        long j3 = defaultItemAnimator3.mChangeDuration;
                                                        RecyclerView.ViewHolder viewHolder3 = changeInfo.oldHolder;
                                                        View view5 = viewHolder3 == null ? null : viewHolder3.itemView;
                                                        RecyclerView.ViewHolder viewHolder4 = changeInfo.newHolder;
                                                        View view6 = viewHolder4 != null ? viewHolder4.itemView : null;
                                                        if (view5 != null) {
                                                            ViewPropertyAnimator duration = view5.animate().setDuration(j3);
                                                            arrayList10.add(changeInfo.oldHolder);
                                                            duration.translationX(changeInfo.toX - changeInfo.fromX);
                                                            duration.translationY(changeInfo.toY - changeInfo.fromY);
                                                            duration.alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.7
                                                                public final /* synthetic */ int $r8$classId;
                                                                public final /* synthetic */ DefaultItemAnimator this$0;
                                                                public final /* synthetic */ ChangeInfo val$changeInfo;
                                                                public final /* synthetic */ ViewPropertyAnimator val$oldViewAnim;
                                                                public final /* synthetic */ View val$view;

                                                                public /* synthetic */ AnonymousClass7() {
                                                                    i = i;
                                                                    defaultItemAnimator = defaultItemAnimator3;
                                                                    changeInfo = changeInfo;
                                                                    viewPropertyAnimator = duration;
                                                                    view = view5;
                                                                }

                                                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                public final void onAnimationEnd(Animator animator) {
                                                                    switch (i) {
                                                                        case 0:
                                                                            viewPropertyAnimator.setListener(null);
                                                                            View view7 = view;
                                                                            view7.setAlpha(1.0f);
                                                                            view7.setTranslationX(0.0f);
                                                                            view7.setTranslationY(0.0f);
                                                                            ChangeInfo changeInfo2 = changeInfo;
                                                                            RecyclerView.ViewHolder viewHolder5 = changeInfo2.oldHolder;
                                                                            DefaultItemAnimator defaultItemAnimator4 = defaultItemAnimator;
                                                                            defaultItemAnimator4.dispatchAnimationFinished(viewHolder5);
                                                                            defaultItemAnimator4.mChangeAnimations.remove(changeInfo2.oldHolder);
                                                                            defaultItemAnimator4.dispatchFinishedWhenDone();
                                                                            break;
                                                                        default:
                                                                            viewPropertyAnimator.setListener(null);
                                                                            View view8 = view;
                                                                            view8.setAlpha(1.0f);
                                                                            view8.setTranslationX(0.0f);
                                                                            view8.setTranslationY(0.0f);
                                                                            ChangeInfo changeInfo3 = changeInfo;
                                                                            RecyclerView.ViewHolder viewHolder6 = changeInfo3.newHolder;
                                                                            DefaultItemAnimator defaultItemAnimator5 = defaultItemAnimator;
                                                                            defaultItemAnimator5.dispatchAnimationFinished(viewHolder6);
                                                                            defaultItemAnimator5.mChangeAnimations.remove(changeInfo3.newHolder);
                                                                            defaultItemAnimator5.dispatchFinishedWhenDone();
                                                                            break;
                                                                    }
                                                                }

                                                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                public final void onAnimationStart(Animator animator) {
                                                                    switch (i) {
                                                                        case 0:
                                                                            RecyclerView.ViewHolder viewHolder5 = changeInfo.oldHolder;
                                                                            defaultItemAnimator.getClass();
                                                                            break;
                                                                        default:
                                                                            RecyclerView.ViewHolder viewHolder6 = changeInfo.newHolder;
                                                                            defaultItemAnimator.getClass();
                                                                            break;
                                                                    }
                                                                }
                                                            }).start();
                                                        }
                                                        if (view6 != null) {
                                                            ViewPropertyAnimator viewPropertyAnimatorAnimate3 = view6.animate();
                                                            arrayList10.add(changeInfo.newHolder);
                                                            viewPropertyAnimatorAnimate3.translationX(0.0f).translationY(0.0f).setDuration(j3).alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.7
                                                                public final /* synthetic */ int $r8$classId;
                                                                public final /* synthetic */ DefaultItemAnimator this$0;
                                                                public final /* synthetic */ ChangeInfo val$changeInfo;
                                                                public final /* synthetic */ ViewPropertyAnimator val$oldViewAnim;
                                                                public final /* synthetic */ View val$view;

                                                                public /* synthetic */ AnonymousClass7() {
                                                                    i = i;
                                                                    defaultItemAnimator = defaultItemAnimator3;
                                                                    changeInfo = changeInfo;
                                                                    viewPropertyAnimator = viewPropertyAnimatorAnimate3;
                                                                    view = view6;
                                                                }

                                                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                public final void onAnimationEnd(Animator animator) {
                                                                    switch (i) {
                                                                        case 0:
                                                                            viewPropertyAnimator.setListener(null);
                                                                            View view7 = view;
                                                                            view7.setAlpha(1.0f);
                                                                            view7.setTranslationX(0.0f);
                                                                            view7.setTranslationY(0.0f);
                                                                            ChangeInfo changeInfo2 = changeInfo;
                                                                            RecyclerView.ViewHolder viewHolder5 = changeInfo2.oldHolder;
                                                                            DefaultItemAnimator defaultItemAnimator4 = defaultItemAnimator;
                                                                            defaultItemAnimator4.dispatchAnimationFinished(viewHolder5);
                                                                            defaultItemAnimator4.mChangeAnimations.remove(changeInfo2.oldHolder);
                                                                            defaultItemAnimator4.dispatchFinishedWhenDone();
                                                                            break;
                                                                        default:
                                                                            viewPropertyAnimator.setListener(null);
                                                                            View view8 = view;
                                                                            view8.setAlpha(1.0f);
                                                                            view8.setTranslationX(0.0f);
                                                                            view8.setTranslationY(0.0f);
                                                                            ChangeInfo changeInfo3 = changeInfo;
                                                                            RecyclerView.ViewHolder viewHolder6 = changeInfo3.newHolder;
                                                                            DefaultItemAnimator defaultItemAnimator5 = defaultItemAnimator;
                                                                            defaultItemAnimator5.dispatchAnimationFinished(viewHolder6);
                                                                            defaultItemAnimator5.mChangeAnimations.remove(changeInfo3.newHolder);
                                                                            defaultItemAnimator5.dispatchFinishedWhenDone();
                                                                            break;
                                                                    }
                                                                }

                                                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                public final void onAnimationStart(Animator animator) {
                                                                    switch (i) {
                                                                        case 0:
                                                                            RecyclerView.ViewHolder viewHolder5 = changeInfo.oldHolder;
                                                                            defaultItemAnimator.getClass();
                                                                            break;
                                                                        default:
                                                                            RecyclerView.ViewHolder viewHolder6 = changeInfo.newHolder;
                                                                            defaultItemAnimator.getClass();
                                                                            break;
                                                                    }
                                                                }
                                                            }).start();
                                                        }
                                                    }
                                                }
                                                break;
                                            default:
                                                ArrayList arrayList11 = arrayList;
                                                int size4 = arrayList11.size();
                                                int i16 = 0;
                                                while (true) {
                                                    DefaultItemAnimator defaultItemAnimator4 = defaultItemAnimator;
                                                    if (i16 >= size4) {
                                                        arrayList11.clear();
                                                        defaultItemAnimator4.mAdditionsList.remove(arrayList11);
                                                    } else {
                                                        Object obj3 = arrayList11.get(i16);
                                                        i16++;
                                                        RecyclerView.ViewHolder viewHolder5 = (RecyclerView.ViewHolder) obj3;
                                                        defaultItemAnimator4.getClass();
                                                        View view7 = viewHolder5.itemView;
                                                        ViewPropertyAnimator viewPropertyAnimatorAnimate4 = view7.animate();
                                                        defaultItemAnimator4.mAddAnimations.add(viewHolder5);
                                                        viewPropertyAnimatorAnimate4.alpha(1.0f).setDuration(defaultItemAnimator4.mAddDuration).setListener(defaultItemAnimator4.new AnonymousClass4(viewHolder5, view7, viewPropertyAnimatorAnimate4)).start();
                                                    }
                                                    break;
                                                }
                                                break;
                                        }
                                    }
                                };
                                if (zIsEmpty && zIsEmpty2 && zIsEmpty3) {
                                    runnable3.run();
                                    z = false;
                                } else {
                                    if (zIsEmpty) {
                                        j2 = 0;
                                    }
                                    long jMax = Math.max(!zIsEmpty2 ? defaultItemAnimator.mMoveDuration : 0L, !zIsEmpty3 ? defaultItemAnimator.mChangeDuration : 0L) + j2;
                                    z = false;
                                    View view4 = ((RecyclerView.ViewHolder) arrayList7.get(0)).itemView;
                                    WeakHashMap weakHashMap4 = ViewCompat.sViewPropertyAnimatorMap;
                                    view4.postOnAnimationDelayed(runnable3, jMax);
                                }
                            }
                        }
                    } else {
                        z = false;
                    }
                    recyclerView.mPostedAnimatorRunner = z;
                    return;
                case 17:
                    ((StaggeredGridLayoutManager) this.this$0).checkForGaps();
                    return;
                case 18:
                    run$androidx$room$InvalidationTracker$refreshRunnable$1();
                    return;
                case 19:
                    Dispatcher dispatcher = (Dispatcher) this.this$0;
                    ((SQLiteEventStore) ((SynchronizationGuard) dispatcher.runningSyncCalls)).runCriticalSection(new ConnectionPool(5, dispatcher));
                    return;
                case 20:
                    ((zabq) this.this$0).zaH();
                    return;
                case 21:
                    Api$Client api$Client = ((zabq) ((ConnectionPool) this.this$0).delegate).zac;
                    api$Client.disconnect(api$Client.getClass().getName().concat(" disconnecting because it was signed out."));
                    return;
                case 22:
                    ((zact) this.this$0).zah.zae(new ConnectionResult(4));
                    return;
                case 23:
                    throw null;
                case 24:
                    run$com$google$android$gms$tasks$zzg();
                    return;
                case 25:
                    MinimalEncoder minimalEncoder = (MinimalEncoder) this.this$0;
                    minimalEncoder.isGS1 = false;
                    BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) minimalEncoder.encoders;
                    ViewDragHelper viewDragHelper = bottomSheetBehavior.viewDragHelper;
                    if (viewDragHelper != null && viewDragHelper.continueSettling()) {
                        minimalEncoder.continueSettlingToState(minimalEncoder.ecLevel);
                        return;
                    } else {
                        if (bottomSheetBehavior.state == 2) {
                            bottomSheetBehavior.setStateInternal(minimalEncoder.ecLevel);
                            return;
                        }
                        return;
                    }
                case 26:
                    View view5 = (View) this.this$0;
                    ((InputMethodManager) view5.getContext().getSystemService("input_method")).showSoftInput(view5, 1);
                    return;
            }
            while (true) {
                TaskRunner taskRunner = (TaskRunner) this.this$0;
                synchronized (taskRunner) {
                    taskAwaitTaskToRun = taskRunner.awaitTaskToRun();
                }
                if (taskAwaitTaskToRun == null) {
                    return;
                }
                TaskQueue taskQueue = taskAwaitTaskToRun.queue;
                TaskRunner taskRunner2 = (TaskRunner) this.this$0;
                boolean zIsLoggable = TaskRunner.logger.isLoggable(Level.FINE);
                if (zIsLoggable) {
                    TaskRunner taskRunner3 = taskQueue.taskRunner;
                    jNanoTime = System.nanoTime();
                    TaskRunner.logger.fine(taskQueue.name + ' ' + String.format("%-22s", Arrays.copyOf(new Object[]{"starting"}, 1)) + ": " + taskAwaitTaskToRun.name);
                } else {
                    jNanoTime = -1;
                }
                try {
                    TaskRunner.access$runTask(taskRunner2, taskAwaitTaskToRun);
                    try {
                        Unit unit = Unit.INSTANCE;
                        if (zIsLoggable) {
                            TaskRunner taskRunner4 = taskQueue.taskRunner;
                            TaskRunner.logger.fine(taskQueue.name + ' ' + String.format("%-22s", Arrays.copyOf(new Object[]{"finished run in ".concat(TaskLoggerKt.formatDuration(System.nanoTime() - jNanoTime))}, 1)) + ": " + taskAwaitTaskToRun.name);
                        }
                    } catch (Throwable th2) {
                        if (zIsLoggable) {
                            TaskRunner taskRunner5 = taskQueue.taskRunner;
                            TaskRunner.logger.fine(taskQueue.name + ' ' + String.format("%-22s", Arrays.copyOf(new Object[]{"failed a run in ".concat(TaskLoggerKt.formatDuration(System.nanoTime() - jNanoTime))}, 1)) + ": " + taskAwaitTaskToRun.name);
                        }
                        throw th2;
                    }
                } catch (Throwable th3) {
                    ((ThreadPoolExecutor) taskRunner2.backend.delegate).execute(this);
                    throw th3;
                }
            }
        }

        /* JADX WARN: Code duplicated, block: B:42:0x003a A[SYNTHETIC] */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
        
            if (r1 == false) goto L47;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x004a, code lost:
        
            r1 = r1 | java.lang.Thread.interrupted();
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x004b, code lost:
        
            r4.run();
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0051, code lost:
        
            r2 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0052, code lost:
        
            kotlin.LazyKt__LazyJVMKt.e("SequentialExecutor", "Exception while executing runnable " + r4, r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void workOnQueue() {
            /*
                r10 = this;
                r0 = 0
                r1 = r0
            L2:
                java.lang.Object r2 = r10.this$0     // Catch: java.lang.Throwable -> L4f
                androidx.camera.core.impl.utils.executor.SequentialExecutor r2 = (androidx.camera.core.impl.utils.executor.SequentialExecutor) r2     // Catch: java.lang.Throwable -> L4f
                java.util.ArrayDeque r2 = r2.mQueue     // Catch: java.lang.Throwable -> L4f
                monitor-enter(r2)     // Catch: java.lang.Throwable -> L4f
                r3 = 1
                if (r0 != 0) goto L2c
                java.lang.Object r0 = r10.this$0     // Catch: java.lang.Throwable -> L20
                androidx.camera.core.impl.utils.executor.SequentialExecutor r0 = (androidx.camera.core.impl.utils.executor.SequentialExecutor) r0     // Catch: java.lang.Throwable -> L20
                int r4 = r0.mWorkerRunningState     // Catch: java.lang.Throwable -> L20
                r5 = 4
                if (r4 != r5) goto L22
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
                if (r1 == 0) goto L44
            L18:
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.interrupt()
                goto L44
            L20:
                r0 = move-exception
                goto L69
            L22:
                long r6 = r0.mWorkerRunCount     // Catch: java.lang.Throwable -> L20
                r8 = 1
                long r6 = r6 + r8
                r0.mWorkerRunCount = r6     // Catch: java.lang.Throwable -> L20
                r0.mWorkerRunningState = r5     // Catch: java.lang.Throwable -> L20
                r0 = r3
            L2c:
                java.lang.Object r4 = r10.this$0     // Catch: java.lang.Throwable -> L20
                androidx.camera.core.impl.utils.executor.SequentialExecutor r4 = (androidx.camera.core.impl.utils.executor.SequentialExecutor) r4     // Catch: java.lang.Throwable -> L20
                java.util.ArrayDeque r4 = r4.mQueue     // Catch: java.lang.Throwable -> L20
                java.lang.Object r4 = r4.poll()     // Catch: java.lang.Throwable -> L20
                java.lang.Runnable r4 = (java.lang.Runnable) r4     // Catch: java.lang.Throwable -> L20
                if (r4 != 0) goto L45
                java.lang.Object r0 = r10.this$0     // Catch: java.lang.Throwable -> L20
                androidx.camera.core.impl.utils.executor.SequentialExecutor r0 = (androidx.camera.core.impl.utils.executor.SequentialExecutor) r0     // Catch: java.lang.Throwable -> L20
                r0.mWorkerRunningState = r3     // Catch: java.lang.Throwable -> L20
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
                if (r1 == 0) goto L44
                goto L18
            L44:
                return
            L45:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
                boolean r2 = java.lang.Thread.interrupted()     // Catch: java.lang.Throwable -> L4f
                r1 = r1 | r2
                r4.run()     // Catch: java.lang.Throwable -> L4f java.lang.RuntimeException -> L51
                goto L2
            L4f:
                r0 = move-exception
                goto L6b
            L51:
                r2 = move-exception
                java.lang.String r3 = "SequentialExecutor"
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4f
                r5.<init>()     // Catch: java.lang.Throwable -> L4f
                java.lang.String r6 = "Exception while executing runnable "
                r5.append(r6)     // Catch: java.lang.Throwable -> L4f
                r5.append(r4)     // Catch: java.lang.Throwable -> L4f
                java.lang.String r4 = r5.toString()     // Catch: java.lang.Throwable -> L4f
                kotlin.LazyKt__LazyJVMKt.e(r3, r4, r2)     // Catch: java.lang.Throwable -> L4f
                goto L2
            L69:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
                throw r0     // Catch: java.lang.Throwable -> L4f
            L6b:
                if (r1 == 0) goto L74
                java.lang.Thread r1 = java.lang.Thread.currentThread()
                r1.interrupt()
            L74:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.work.Worker.AnonymousClass1.workOnQueue():void");
        }

        public AnonymousClass1(zaae zaaeVar, RealWeakMemoryCache realWeakMemoryCache) {
            this.$r8$classId = 23;
            this.this$0 = realWeakMemoryCache;
        }
    }

    /* JADX INFO: renamed from: androidx.work.Worker$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class AnonymousClass2 implements Runnable {
        public final /* synthetic */ int $r8$classId;
        public final Object this$0;
        public final Object val$future;

        public /* synthetic */ AnonymousClass2(int i, Object obj, Object obj2) {
            this.$r8$classId = i;
            this.val$future = obj;
            this.this$0 = obj2;
        }

        private final void run$androidx$work$impl$foreground$SystemForegroundDispatcher$1() {
            WorkSpec runningWorkSpec = ((SystemForegroundDispatcher) this.this$0).mWorkManagerImpl.mProcessor.getRunningWorkSpec((String) this.val$future);
            if (runningWorkSpec == null || !runningWorkSpec.hasConstraints()) {
                return;
            }
            synchronized (((SystemForegroundDispatcher) this.this$0).mLock) {
                ((SystemForegroundDispatcher) this.this$0).mWorkSpecById.put(WorkSpecKt.generationalId(runningWorkSpec), runningWorkSpec);
                SystemForegroundDispatcher systemForegroundDispatcher = (SystemForegroundDispatcher) this.this$0;
                ((SystemForegroundDispatcher) this.this$0).mTrackedWorkSpecs.put(WorkSpecKt.generationalId(runningWorkSpec), WorkConstraintsTrackerKt.listen(systemForegroundDispatcher.mConstraintsTracker, runningWorkSpec, systemForegroundDispatcher.mTaskExecutor.mTaskDispatcher, systemForegroundDispatcher));
            }
        }

        private final void run$androidx$work$impl$utils$SerialExecutorImpl$Task() {
            try {
                ((Runnable) this.this$0).run();
                synchronized (((TransactionExecutor) this.val$future).syncLock) {
                    ((TransactionExecutor) this.val$future).scheduleNext();
                }
            } catch (Throwable th) {
                synchronized (((TransactionExecutor) this.val$future).syncLock) {
                    ((TransactionExecutor) this.val$future).scheduleNext();
                    throw th;
                }
            }
        }

        private final void run$com$google$android$gms$tasks$zzi() {
            synchronized (((zzh) this.this$0).zzb) {
                ((OnCompleteListener) ((zzh) this.this$0).zzc).onComplete((zzw) this.val$future);
            }
        }

        private final void run$com$google$android$gms$tasks$zzk() {
            synchronized (((zzh) this.this$0).zzb) {
                OnFailureListener onFailureListener = (OnFailureListener) ((zzh) this.this$0).zzc;
                Exception exception = ((zzw) this.val$future).getException();
                zzah.checkNotNull(exception);
                onFailureListener.onFailure(exception);
            }
        }

        private final void run$com$google$android$gms$tasks$zzm() {
            synchronized (((zzh) this.this$0).zzb) {
                ((OnSuccessListener) ((zzh) this.this$0).zzc).onSuccess(((zzw) this.val$future).getResult());
            }
        }

        private final void run$com$google$firebase$components$ComponentRuntime$$Lambda$3() {
            OptionalProvider$$Lambda$4 optionalProvider$$Lambda$4;
            OptionalProvider optionalProvider = (OptionalProvider) this.val$future;
            Provider provider = (Provider) this.this$0;
            if (optionalProvider.delegate != ComponentRuntime$$Lambda$5.instance$1) {
                throw new IllegalStateException("provide() can be called only once.");
            }
            synchronized (optionalProvider) {
                optionalProvider$$Lambda$4 = optionalProvider.handler;
                optionalProvider.handler = null;
                optionalProvider.delegate = provider;
            }
            optionalProvider$$Lambda$4.getClass();
        }

        @Override // java.lang.Runnable
        public final void run() {
            IAccountAccessor iAccountAccessor;
            IAccountAccessor zzwVar;
            int i = 3;
            zzbq zzbqVar = null;
            try {
                switch (this.$r8$classId) {
                    case 0:
                        try {
                            ((Worker) this.this$0).getClass();
                            throw new IllegalStateException("Expedited WorkRequests require a Worker to provide an implementation for \n `getForegroundInfo()`");
                        } catch (Throwable th) {
                            ((SettableFuture) this.val$future).setException(th);
                            return;
                        }
                    case 1:
                        FutureCallback futureCallback = (FutureCallback) this.this$0;
                        try {
                            futureCallback.onSuccess(Futures.getDone((Future) this.val$future));
                            return;
                        } catch (Error e) {
                            e = e;
                            futureCallback.onFailure(e);
                            return;
                        } catch (RuntimeException e2) {
                            e = e2;
                            futureCallback.onFailure(e);
                            return;
                        } catch (ExecutionException e3) {
                            Throwable cause = e3.getCause();
                            if (cause == null) {
                                futureCallback.onFailure(e3);
                                return;
                            } else {
                                futureCallback.onFailure(cause);
                                return;
                            }
                        }
                    case 2:
                        try {
                            ChainingListenableFuture chainingListenableFuture = (ChainingListenableFuture) this.this$0;
                            Object uninterruptibly = Futures.getUninterruptibly((ListenableFuture) this.val$future);
                            CallbackToFutureAdapter.Completer completer = chainingListenableFuture.mCompleter;
                            if (completer != null) {
                                completer.set(uninterruptibly);
                            }
                            break;
                        } catch (CancellationException unused) {
                            ((ChainingListenableFuture) this.this$0).cancel(false);
                        } catch (ExecutionException e4) {
                            ChainingListenableFuture chainingListenableFuture2 = (ChainingListenableFuture) this.this$0;
                            Throwable cause2 = e4.getCause();
                            CallbackToFutureAdapter.Completer completer2 = chainingListenableFuture2.mCompleter;
                            if (completer2 != null) {
                                completer2.setException(cause2);
                            }
                        }
                        return;
                    case 3:
                        ((ActivityRecreator.LifecycleCheckCallbacks) this.val$future).currentlyRecreatingToken = this.this$0;
                        return;
                    case 4:
                        ((Application) this.val$future).unregisterActivityLifecycleCallbacks((ActivityRecreator.LifecycleCheckCallbacks) this.this$0);
                        return;
                    case 5:
                        Object obj = this.this$0;
                        Object obj2 = this.val$future;
                        try {
                            Method method = ActivityRecreator.performStopActivity3ParamsMethod;
                            if (method != null) {
                                method.invoke(obj2, obj, Boolean.FALSE, "AppCompat recreation");
                            } else {
                                ActivityRecreator.performStopActivity2ParamsMethod.invoke(obj2, obj, Boolean.FALSE);
                            }
                            return;
                        } catch (RuntimeException e5) {
                            if (e5.getClass() == RuntimeException.class && e5.getMessage() != null && e5.getMessage().startsWith("Unable to stop")) {
                                throw e5;
                            }
                            return;
                        } catch (Throwable th2) {
                            Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th2);
                            return;
                        }
                    case 6:
                        RealDiskCache.RealEditor realEditor = (RealDiskCache.RealEditor) this.val$future;
                        Typeface typeface = (Typeface) this.this$0;
                        CamUtils camUtils = (CamUtils) realEditor.editor;
                        if (camUtils != null) {
                            camUtils.onFontRetrieved(typeface);
                            return;
                        }
                        return;
                    case 7:
                        ((Edge) this.val$future).accept(this.this$0);
                        return;
                    case 8:
                        ArrayList arrayList = (ArrayList) this.val$future;
                        SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = (SpecialEffectsController$FragmentStateManagerOperation) this.this$0;
                        if (arrayList.contains(specialEffectsController$FragmentStateManagerOperation)) {
                            arrayList.remove(specialEffectsController$FragmentStateManagerOperation);
                            Density.CC._applyState(specialEffectsController$FragmentStateManagerOperation.mFragment.mView, specialEffectsController$FragmentStateManagerOperation.mFinalState);
                            return;
                        }
                        return;
                    case 9:
                        if (((WorkerWrapper) this.this$0).mWorkerResultFuture.value instanceof AbstractFuture.Cancellation) {
                            return;
                        }
                        try {
                            ((ListenableFuture) this.val$future).get();
                            Logger$LogcatLogger.get().debug(WorkerWrapper.TAG, "Starting work for " + ((WorkerWrapper) this.this$0).mWorkSpec.workerClassName);
                            WorkerWrapper workerWrapper = (WorkerWrapper) this.this$0;
                            workerWrapper.mWorkerResultFuture.setFuture(workerWrapper.mWorker.startWork());
                            return;
                        } catch (Throwable th3) {
                            ((WorkerWrapper) this.this$0).mWorkerResultFuture.setException(th3);
                            return;
                        }
                    case 10:
                        String str = (String) this.val$future;
                        WorkerWrapper workerWrapper2 = (WorkerWrapper) this.this$0;
                        WorkSpec workSpec = workerWrapper2.mWorkSpec;
                        try {
                            try {
                                ListenableWorker.Result result = (ListenableWorker.Result) workerWrapper2.mWorkerResultFuture.get();
                                if (result == null) {
                                    Logger$LogcatLogger.get().error(WorkerWrapper.TAG, workSpec.workerClassName + " returned a null result. Treating it as a failure.");
                                } else {
                                    Logger$LogcatLogger.get().debug(WorkerWrapper.TAG, workSpec.workerClassName + " returned a " + result + ".");
                                    workerWrapper2.mResult = result;
                                }
                            } catch (Throwable th4) {
                                workerWrapper2.onWorkFinished();
                                throw th4;
                            }
                            break;
                        } catch (InterruptedException e6) {
                            e = e6;
                            Logger$LogcatLogger.get().error(WorkerWrapper.TAG, str + " failed because it threw an exception/error", e);
                        } catch (CancellationException e7) {
                            Logger$LogcatLogger logger$LogcatLogger = Logger$LogcatLogger.get();
                            String str2 = WorkerWrapper.TAG;
                            String str3 = str + " was cancelled";
                            if (logger$LogcatLogger.mLoggingLevel <= 4) {
                                Log.i(str2, str3, e7);
                            }
                        } catch (ExecutionException e8) {
                            e = e8;
                            Logger$LogcatLogger.get().error(WorkerWrapper.TAG, str + " failed because it threw an exception/error", e);
                        }
                        workerWrapper2.onWorkFinished();
                        return;
                    case 11:
                        Logger$LogcatLogger logger$LogcatLogger2 = Logger$LogcatLogger.get();
                        String str4 = DelayedWorkTracker.TAG;
                        StringBuilder sb = new StringBuilder("Scheduling work ");
                        WorkSpec workSpec2 = (WorkSpec) this.val$future;
                        sb.append(workSpec2.id);
                        logger$LogcatLogger2.debug(str4, sb.toString());
                        ((DelayedWorkTracker) this.this$0).mImmediateScheduler.schedule(workSpec2);
                        return;
                    case 12:
                        run$androidx$work$impl$foreground$SystemForegroundDispatcher$1();
                        return;
                    case 13:
                        run$androidx$work$impl$utils$SerialExecutorImpl$Task();
                        return;
                    case 14:
                        if (((WorkForegroundRunnable) this.this$0).mFuture.value instanceof AbstractFuture.Cancellation) {
                            return;
                        }
                        try {
                            ForegroundInfo foregroundInfo = (ForegroundInfo) ((SettableFuture) this.val$future).get();
                            if (foregroundInfo == null) {
                                throw new IllegalStateException("Worker was marked important (" + ((WorkForegroundRunnable) this.this$0).mWorkSpec.workerClassName + ") but did not provide ForegroundInfo");
                            }
                            Logger$LogcatLogger.get().debug(WorkForegroundRunnable.TAG, "Updating notification for " + ((WorkForegroundRunnable) this.this$0).mWorkSpec.workerClassName);
                            WorkForegroundRunnable workForegroundRunnable = (WorkForegroundRunnable) this.this$0;
                            SettableFuture settableFuture = workForegroundRunnable.mFuture;
                            WorkForegroundUpdater workForegroundUpdater = workForegroundRunnable.mForegroundUpdater;
                            Context context = workForegroundRunnable.mContext;
                            UUID uuid = workForegroundRunnable.mWorker.mWorkerParams.mId;
                            workForegroundUpdater.getClass();
                            SettableFuture settableFuture2 = new SettableFuture();
                            workForegroundUpdater.mTaskExecutor.executeOnTaskThread(new zzn(workForegroundUpdater, settableFuture2, uuid, foregroundInfo, context));
                            settableFuture.setFuture(settableFuture2);
                            return;
                        } catch (Throwable th5) {
                            ((WorkForegroundRunnable) this.this$0).mFuture.setException(th5);
                            return;
                        }
                    case 15:
                        JobInfoSchedulerService jobInfoSchedulerService = (JobInfoSchedulerService) this.val$future;
                        JobParameters jobParameters = (JobParameters) this.this$0;
                        int i2 = JobInfoSchedulerService.$r8$clinit;
                        jobInfoSchedulerService.jobFinished(jobParameters, false);
                        return;
                    case 16:
                        ConnectionResult connectionResult = (ConnectionResult) this.val$future;
                        ZoomControl zoomControl = (ZoomControl) this.this$0;
                        Api$Client api$Client = (Api$Client) zoomControl.mCamera2CameraControlImpl;
                        zabq zabqVar = (zabq) ((GoogleApiManager) zoomControl.mCaptureResultListener).zan.get((ApiKey) zoomControl.mCurrentZoomState);
                        if (zabqVar == null) {
                            return;
                        }
                        if (connectionResult.zzb != 0) {
                            zabqVar.zar(connectionResult, null);
                            return;
                        }
                        zoomControl.mIsActive = true;
                        if (api$Client.requiresSignIn()) {
                            if (!zoomControl.mIsActive || (iAccountAccessor = (IAccountAccessor) zoomControl.mZoomStateLiveData) == null) {
                                return;
                            }
                            api$Client.getRemoteService(iAccountAccessor, (Set) zoomControl.mZoomImpl);
                            return;
                        }
                        try {
                            api$Client.getRemoteService(null, api$Client.getScopesForConnectionlessNonSignIn());
                            return;
                        } catch (SecurityException e9) {
                            Log.e("GoogleApiManager", "Failed to get service from broker. ", e9);
                            api$Client.disconnect("Failed to get service from broker.");
                            zabqVar.zar(new ConnectionResult(10), null);
                            return;
                        }
                    case 17:
                        zact zactVar = (zact) this.this$0;
                        zak zakVar = (zak) this.val$future;
                        ConnectionResult connectionResult2 = zakVar.zab;
                        if (connectionResult2.zzb == 0) {
                            zav zavVar = zakVar.zac;
                            zzah.checkNotNull(zavVar);
                            ConnectionResult connectionResult3 = zavVar.zac;
                            if (connectionResult3.zzb != 0) {
                                Log.wtf("SignInCoordinator", "Sign-in succeeded with resolve account failure: ".concat(String.valueOf(connectionResult3)), new Exception());
                                zactVar.zah.zae(connectionResult3);
                                zactVar.zag.disconnect();
                                return;
                            }
                            ZoomControl zoomControl2 = zactVar.zah;
                            IBinder iBinder = zavVar.zab;
                            if (iBinder == null) {
                                zzwVar = null;
                            } else {
                                int i3 = AccountAccessor.$r8$clinit;
                                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                                zzwVar = iInterfaceQueryLocalInterface instanceof IAccountAccessor ? (IAccountAccessor) iInterfaceQueryLocalInterface : new com.google.android.gms.common.internal.zzw(iBinder, "com.google.android.gms.common.internal.IAccountAccessor", 1);
                            }
                            Set set = zactVar.zae;
                            zoomControl2.getClass();
                            if (zzwVar == null || set == null) {
                                Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                                zoomControl2.zae(new ConnectionResult(4));
                            } else {
                                zoomControl2.mZoomStateLiveData = zzwVar;
                                zoomControl2.mZoomImpl = set;
                                if (zoomControl2.mIsActive) {
                                    ((Api$Client) zoomControl2.mCamera2CameraControlImpl).getRemoteService(zzwVar, set);
                                }
                            }
                        } else {
                            zactVar.zah.zae(connectionResult2);
                        }
                        zactVar.zag.disconnect();
                        return;
                    case 18:
                        zzwp zzwpVar = (zzwp) this.val$future;
                        zzrc zzrcVar = zzrc.zzbe;
                        ConnectionPool connectionPool = (ConnectionPool) this.this$0;
                        HashMap map = zzwpVar.zzl;
                        zzbw zzbwVar = (zzbw) map.get(zzrcVar);
                        if (zzbwVar != null) {
                            for (Object obj3 : (zzbg) zzbwVar.zzw()) {
                                Object arrayList2 = (Collection) zzbwVar.zza.get(obj3);
                                if (arrayList2 == null) {
                                    arrayList2 = new ArrayList(i);
                                }
                                List list = (List) arrayList2;
                                ArrayList arrayList3 = new ArrayList(list instanceof RandomAccess ? new zzbm(zzbwVar, obj3, list, zzbqVar) : new zzbq(zzbwVar, obj3, list, zzbqVar));
                                Collections.sort(arrayList3);
                                SVGAndroidRenderer sVGAndroidRenderer = new SVGAndroidRenderer();
                                int size = arrayList3.size();
                                long jLongValue = 0;
                                int i4 = 0;
                                while (i4 < size) {
                                    Object obj4 = arrayList3.get(i4);
                                    i4++;
                                    jLongValue = ((Long) obj4).longValue() + jLongValue;
                                }
                                sVGAndroidRenderer.state = Long.valueOf((jLongValue / ((long) arrayList3.size())) & Long.MAX_VALUE);
                                sVGAndroidRenderer.canvas = Long.valueOf(zzwp.zza(arrayList3, 100.0d) & Long.MAX_VALUE);
                                sVGAndroidRenderer.matrixStack = Long.valueOf(zzwp.zza(arrayList3, 75.0d) & Long.MAX_VALUE);
                                sVGAndroidRenderer.parentStack = Long.valueOf(zzwp.zza(arrayList3, 50.0d) & Long.MAX_VALUE);
                                sVGAndroidRenderer.stateStack = Long.valueOf(zzwp.zza(arrayList3, 25.0d) & Long.MAX_VALUE);
                                sVGAndroidRenderer.document = Long.valueOf(Long.MAX_VALUE & zzwp.zza(arrayList3, 0.0d));
                                zzqd zzqdVar = new zzqd(sVGAndroidRenderer);
                                int size2 = arrayList3.size();
                                zzl zzlVar = (zzl) connectionPool.delegate;
                                zzft zzftVar = (zzft) obj3;
                                AppCompatDrawableManager.AnonymousClass1 anonymousClass1 = new AppCompatDrawableManager.AnonymousClass1();
                                anonymousClass1.COLORFILTER_COLOR_CONTROL_ACTIVATED = zzlVar.zzh ? zzra.zzc : zzra.zzb;
                                zzfi zzfiVar = new zzfi();
                                zzfiVar.zzd = Integer.valueOf(size2 & Integer.MAX_VALUE);
                                zzfiVar.zzc = zzftVar;
                                zzfiVar.zze = zzqdVar;
                                anonymousClass1.TINT_CHECKABLE_BUTTON_LIST = new zzfv(zzfiVar);
                                com.google.mlkit.common.sdkinternal.zzh.zza.execute(new CascadingMenuPopup$3$1(zzwpVar, new StatusLine(anonymousClass1, 0), zzrcVar, zzwpVar.zzj(), 2));
                                i = 3;
                                zzbqVar = null;
                            }
                            map.remove(zzrcVar);
                            return;
                        }
                        return;
                    case 19:
                        run$com$google$android$gms$tasks$zzi();
                        return;
                    case 20:
                        run$com$google$android$gms$tasks$zzk();
                        return;
                    case 21:
                        run$com$google$android$gms$tasks$zzm();
                        return;
                    case 22:
                        zzp zzpVar = (zzp) this.this$0;
                        try {
                            List list2 = (List) ((zzw) this.val$future).getResult();
                            zzw zzwVar2 = new zzw();
                            zzwVar2.zzb(list2);
                            zzt zztVar = TaskExecutors.zza;
                            zzwVar2.addOnSuccessListener(zztVar, zzpVar);
                            zzwVar2.addOnFailureListener(zztVar, zzpVar);
                            zzwVar2.zzb.zza(new zzh((Executor) zztVar, (OnCanceledListener) zzpVar));
                            zzwVar2.zzi();
                            return;
                        } catch (RuntimeExecutionException e10) {
                            if (e10.getCause() instanceof Exception) {
                                zzpVar.onFailure((Exception) e10.getCause());
                                return;
                            } else {
                                zzpVar.onFailure(e10);
                                return;
                            }
                        } catch (CancellationException unused2) {
                            zzpVar.onCanceled();
                            return;
                        } catch (Exception e11) {
                            zzpVar.onFailure(e11);
                            return;
                        }
                    case 23:
                        ViewDragHelper viewDragHelper = ((SwipeDismissBehavior) this.this$0).viewDragHelper;
                        if (viewDragHelper == null || !viewDragHelper.continueSettling()) {
                            return;
                        }
                        View view = (View) this.val$future;
                        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                        view.postOnAnimation(this);
                        return;
                    case 24:
                        EditText editText = (EditText) this.val$future;
                        ClearTextEndIconDelegate clearTextEndIconDelegate = (ClearTextEndIconDelegate) ((ClearTextEndIconDelegate.AnonymousClass4) this.this$0).this$0;
                        editText.removeTextChangedListener(clearTextEndIconDelegate.clearTextEndIconTextWatcher);
                        clearTextEndIconDelegate.animateIcon(true);
                        return;
                    case 25:
                        boolean zIsPopupShowing = ((AutoCompleteTextView) this.val$future).isPopupShowing();
                        DropdownMenuEndIconDelegate.AnonymousClass1 anonymousClass2 = (DropdownMenuEndIconDelegate.AnonymousClass1) this.this$0;
                        ((DropdownMenuEndIconDelegate) anonymousClass2.this$0).setEndIconChecked(zIsPopupShowing);
                        ((DropdownMenuEndIconDelegate) anonymousClass2.this$0).dropdownPopupDirty = zIsPopupShowing;
                        return;
                    case 26:
                        ((AutoCompleteTextView) this.val$future).removeTextChangedListener(((DropdownMenuEndIconDelegate) ((ClearTextEndIconDelegate.AnonymousClass4) this.this$0).this$0).exposedDropdownEndIconTextWatcher);
                        return;
                    case 27:
                        ((EditText) this.val$future).removeTextChangedListener(((PasswordToggleEndIconDelegate) ((ClearTextEndIconDelegate.AnonymousClass4) this.this$0).this$0).textWatcher);
                        return;
                    case 28:
                        run$com$google$firebase$components$ComponentRuntime$$Lambda$3();
                        return;
                    default:
                        LazySet lazySet = (LazySet) this.val$future;
                        Provider provider = (Provider) this.this$0;
                        synchronized (lazySet) {
                            try {
                                if (lazySet.actualSet == null) {
                                    lazySet.providers.add(provider);
                                } else {
                                    lazySet.actualSet.add(provider.get());
                                }
                            } catch (Throwable th6) {
                                throw th6;
                            }
                        }
                        return;
                }
            } finally {
                ((ChainingListenableFuture) this.this$0).mOutputFuture = null;
            }
            ((ChainingListenableFuture) this.this$0).mOutputFuture = null;
        }

        public String toString() {
            switch (this.$r8$classId) {
                case 1:
                    return AnonymousClass2.class.getSimpleName() + "," + ((FutureCallback) this.this$0);
                default:
                    return super.toString();
            }
        }

        public /* synthetic */ AnonymousClass2(int i, Object obj, Object obj2, boolean z) {
            this.$r8$classId = i;
            this.this$0 = obj;
            this.val$future = obj2;
        }

        public /* synthetic */ AnonymousClass2(zzwp zzwpVar, ConnectionPool connectionPool) {
            this.$r8$classId = 18;
            zzrc zzrcVar = zzrc.zza;
            this.val$future = zzwpVar;
            this.this$0 = connectionPool;
        }

        public AnonymousClass2(DefaultSpecialEffectsController defaultSpecialEffectsController, ArrayList arrayList, SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation) {
            this.$r8$classId = 8;
            this.val$future = arrayList;
            this.this$0 = specialEffectsController$FragmentStateManagerOperation;
        }

        public AnonymousClass2(SwipeDismissBehavior swipeDismissBehavior, View view, boolean z) {
            this.$r8$classId = 23;
            this.this$0 = swipeDismissBehavior;
            this.val$future = view;
        }
    }

    public Worker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public abstract ListenableWorker.Result.Success doWork();

    @Override // androidx.work.ListenableWorker
    public final ListenableFuture getForegroundInfoAsync() {
        SettableFuture settableFuture = new SettableFuture();
        this.mWorkerParams.mBackgroundExecutor.execute(new AnonymousClass2(0, this, settableFuture, false));
        return settableFuture;
    }

    @Override // androidx.work.ListenableWorker
    public final SettableFuture startWork() {
        this.mFuture = new SettableFuture();
        this.mWorkerParams.mBackgroundExecutor.execute(new AnonymousClass1(0, this));
        return this.mFuture;
    }
}
