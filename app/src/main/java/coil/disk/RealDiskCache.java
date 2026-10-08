package coil.disk;

import android.content.ClipData;
import android.content.ContentProviderClient;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import android.view.ContentInfo;
import android.view.View;
import android.view.ViewGroup;
import android.view.autofill.AutofillManager;
import android.widget.EditText;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.camera.core.streamsharing.VirtualCameraCaptureResult;
import androidx.compose.material3.DelegatingThemeAwareRippleNode;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.RippleNodeFactory;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.retain.ManagedRetainedValuesStore;
import androidx.compose.runtime.retain.RetainedValuesStore;
import androidx.compose.runtime.retain.impl.PreconditionsKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.input.pointer.util.VelocityTracker1D;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.text.platform.ImmutableBool;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import androidx.core.os.CancellationSignal;
import androidx.core.os.HandlerCompat;
import androidx.core.os.LocaleListPlatformWrapper$$ExternalSyntheticApiModelOutline0;
import androidx.core.provider.FontProvider;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.SoftwareKeyboardControllerCompat$Impl30;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi19;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi26;
import androidx.emoji2.text.EmojiCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity$HostCallbacks;
import androidx.fragment.app.FragmentManager$LaunchedFragmentInfo;
import androidx.fragment.app.FragmentManagerImpl;
import androidx.fragment.app.SpecialEffectsController$FragmentStateManagerOperation;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.ViewBoundsCheck$Callback;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.impl.WorkLauncherImpl;
import coil.compose.AsyncImagePainter;
import coil.memory.EmptyStrongMemoryCache;
import coil.target.Target;
import com.caverock.androidsvg.SVG;
import com.google.android.gms.common.internal.zzp$$ExternalSyntheticApiModelOutline0;
import java.io.Closeable;
import java.util.concurrent.ExecutorService;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import okio.AsyncTimeout;
import okio.ByteString;
import okio.FileSystem;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class RealDiskCache {
    public final DiskLruCache cache;
    public final FileSystem fileSystem;

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public class RealEditor implements ColorProducer, RetainedValuesStore, FontProvider.ContentQueryWrapper, ContentInfoCompat.Compat, ActivityResultCallback, CancellationSignal.OnCancelListener, ViewBoundsCheck$Callback, SupportSQLiteQuery, Target {
        public final /* synthetic */ int $r8$classId;
        public Object editor;

        public /* synthetic */ RealEditor(int i, Object obj) {
            this.$r8$classId = i;
            this.editor = obj;
        }

        /*  JADX ERROR: Type inference failed
            jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 9241. Try increasing type updates limit count.
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
            */
        public static java.util.ArrayList pathStringToNodes$default(coil.disk.RealDiskCache.RealEditor r22, java.lang.String r23) {
            /*
                Method dump skipped, instruction units count: 924
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: coil.disk.RealDiskCache.RealEditor.pathStringToNodes$default(coil.disk.RealDiskCache$RealEditor, java.lang.String):java.util.ArrayList");
        }

        /* JADX INFO: renamed from: calculateVelocity-AH228Gc, reason: not valid java name */
        public long m783calculateVelocityAH228Gc(long j) {
            VirtualCameraCaptureResult virtualCameraCaptureResult = (VirtualCameraCaptureResult) this.editor;
            virtualCameraCaptureResult.getClass();
            if (Velocity.m731getXimpl(j) <= 0.0f || Velocity.m732getYimpl(j) <= 0.0f) {
                InlineClassHelperKt.throwIllegalStateException("maximumVelocity should be a positive value. You specified=" + ((Object) Velocity.m736toStringimpl(j)));
            }
            return VelocityKt.Velocity(((VelocityTracker1D) virtualCameraCaptureResult.mBaseCameraCaptureResult).calculateVelocity(Velocity.m731getXimpl(j)), ((VelocityTracker1D) virtualCameraCaptureResult.mTagBundle).calculateVelocity(Velocity.m732getYimpl(j)));
        }

        /* JADX INFO: renamed from: clipRect-N_I0leg, reason: not valid java name */
        public void m784clipRectN_I0leg(float f, float f2, float f3, float f4, int i) {
            ((SVG) this.editor).getCanvas().mo391clipRectN_I0leg(f, f2, f3, f4, i);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.core.provider.FontProvider.ContentQueryWrapper
        public void close() throws Exception {
            ContentProviderClient contentProviderClient = (ContentProviderClient) this.editor;
            if (contentProviderClient != 0) {
                if (contentProviderClient instanceof AutoCloseable) {
                    contentProviderClient.close();
                } else if (contentProviderClient instanceof ExecutorService) {
                    LocaleListPlatformWrapper$$ExternalSyntheticApiModelOutline0.m((ExecutorService) contentProviderClient);
                } else {
                    contentProviderClient.release();
                }
            }
        }

        public RealSnapshot commitAndOpenSnapshot$1() {
            DiskLruCache.Snapshot snapshot;
            DiskLruCache.Editor editor = (DiskLruCache.Editor) this.editor;
            DiskLruCache diskLruCache = (DiskLruCache) editor.this$0;
            synchronized (diskLruCache) {
                editor.complete(true);
                snapshot = diskLruCache.get(((DiskLruCache.Entry) editor.entry).key);
            }
            if (snapshot != null) {
                return new RealSnapshot(snapshot);
            }
            return null;
        }

        public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i) {
            return null;
        }

        public void current() {
            ((CompositionContext) this.editor).getClass();
        }

        public AccessibilityNodeInfoCompat findFocus(int i) {
            return null;
        }

        @Override // androidx.recyclerview.widget.ViewBoundsCheck$Callback
        public View getChildAt(int i) {
            return ((RecyclerView.LayoutManager) this.editor).getChildAt(i);
        }

        @Override // androidx.recyclerview.widget.ViewBoundsCheck$Callback
        public int getChildEnd(View view) {
            return view.getBottom() + ((RecyclerView.LayoutParams) view.getLayoutParams()).mDecorInsets.bottom + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.ViewBoundsCheck$Callback
        public int getChildStart(View view) {
            return (view.getTop() - ((RecyclerView.LayoutParams) view.getLayoutParams()).mDecorInsets.top) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public ClipData getClip() {
            return ((ContentInfo) this.editor).getClip();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int getFlags() {
            return ((ContentInfo) this.editor).getFlags();
        }

        public State getFontLoadState() {
            EmojiCompat emojiCompat = EmojiCompat.get();
            if (emojiCompat.getLoadState() == 1) {
                return new ImmutableBool(true);
            }
            final ParcelableSnapshotMutableState parcelableSnapshotMutableStateMutableStateOf$default = Stack.mutableStateOf$default(Boolean.FALSE);
            emojiCompat.registerInitCallback(new EmojiCompat.InitCallback() { // from class: androidx.compose.ui.text.platform.DefaultImpl$getFontLoadState$initCallback$1
                @Override // androidx.emoji2.text.EmojiCompat.InitCallback
                public final void onFailed() {
                    this.editor = AndroidTextPaint_androidKt.Falsey;
                }

                @Override // androidx.emoji2.text.EmojiCompat.InitCallback
                public final void onInitialized() {
                    parcelableSnapshotMutableStateMutableStateOf$default.setValue(Boolean.TRUE);
                    this.editor = new ImmutableBool(true);
                }
            });
            return parcelableSnapshotMutableStateMutableStateOf$default;
        }

        @Override // androidx.recyclerview.widget.ViewBoundsCheck$Callback
        public int getParentEnd() {
            RecyclerView.LayoutManager layoutManager = (RecyclerView.LayoutManager) this.editor;
            return layoutManager.mHeight - layoutManager.getPaddingBottom();
        }

        @Override // androidx.recyclerview.widget.ViewBoundsCheck$Callback
        public int getParentStart() {
            return ((RecyclerView.LayoutManager) this.editor).getPaddingTop();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int getSource() {
            return ((ContentInfo) this.editor).getSource();
        }

        @Override // androidx.sqlite.db.SupportSQLiteQuery
        public String getSql() {
            return (String) this.editor;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public ContentInfo getWrapped() {
            return (ContentInfo) this.editor;
        }

        public void inset(float f, float f2, float f3, float f4) {
            SVG svg = (SVG) this.editor;
            Canvas canvas = svg.getCanvas();
            float fIntBitsToFloat = Float.intBitsToFloat((int) (svg.m795getSizeNHjbRc() >> 32)) - (f3 + f);
            long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (svg.m795getSizeNHjbRc() & 4294967295L)) - (f4 + f2))) & 4294967295L) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32);
            if (!(Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32)) >= 0.0f && Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L)) >= 0.0f)) {
                androidx.compose.ui.graphics.InlineClassHelperKt.throwIllegalArgumentException("Width and height must be greater than or equal to zero");
            }
            svg.m797setSizeuvyYCjk(jFloatToRawIntBits);
            canvas.translate(f, f2);
        }

        @Override // androidx.compose.ui.graphics.ColorProducer
        /* JADX INFO: renamed from: invoke-0d7_KjU */
        public long mo244invoke0d7_KjU() {
            switch (this.$r8$classId) {
                case 1:
                    DelegatingThemeAwareRippleNode delegatingThemeAwareRippleNode = (DelegatingThemeAwareRippleNode) this.editor;
                    return ((MaterialTheme$Values) HitTestResultKt.currentValueOf(delegatingThemeAwareRippleNode, MaterialThemeKt._localMaterialTheme)).colorScheme.onSecondary;
                default:
                    return ((RippleNodeFactory) this.editor).color;
            }
        }

        public void noteStateNotSaved() {
            ((FragmentActivity$HostCallbacks) this.editor).mFragmentManager.noteStateNotSaved();
        }

        public void notifyViewVisibilityChanged(View view, int i, boolean z) {
            if (Build.VERSION.SDK_INT >= 27) {
                ((AutofillManager) this.editor).notifyViewVisibilityChanged(view, i, z);
            }
        }

        @Override // androidx.activity.result.ActivityResultCallback
        public void onActivityResult(Object obj) {
            ActivityResult activityResult = (ActivityResult) obj;
            FragmentManagerImpl fragmentManagerImpl = (FragmentManagerImpl) this.editor;
            FragmentManager$LaunchedFragmentInfo fragmentManager$LaunchedFragmentInfo = (FragmentManager$LaunchedFragmentInfo) fragmentManagerImpl.mLaunchedFragments.pollFirst();
            if (fragmentManager$LaunchedFragmentInfo == null) {
                Log.w("FragmentManager", "No Activities were started for result for " + this);
                return;
            }
            String str = fragmentManager$LaunchedFragmentInfo.mWho;
            int i = fragmentManager$LaunchedFragmentInfo.mRequestCode;
            Fragment fragmentFindFragmentByWho = fragmentManagerImpl.mFragmentStore.findFragmentByWho(str);
            if (fragmentFindFragmentByWho != null) {
                fragmentFindFragmentByWho.onActivityResult(i, activityResult.resultCode, activityResult.data);
                return;
            }
            Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
        }

        @Override // androidx.core.os.CancellationSignal.OnCancelListener
        public void onCancel() {
            ((SpecialEffectsController$FragmentStateManagerOperation) this.editor).cancel();
        }

        @Override // coil.target.Target
        public void onStart(Drawable drawable) {
            AsyncImagePainter asyncImagePainter = (AsyncImagePainter) this.editor;
            asyncImagePainter.updateState(new AsyncImagePainter.State.Loading(drawable != null ? asyncImagePainter.toPainter(drawable) : null));
        }

        public boolean performAction(int i, int i2, Bundle bundle) {
            return false;
        }

        @Override // androidx.core.provider.FontProvider.ContentQueryWrapper
        public Cursor query(Uri uri, String[] strArr, String[] strArr2) {
            ContentProviderClient contentProviderClient = (ContentProviderClient) this.editor;
            if (contentProviderClient == null) {
                return null;
            }
            try {
                return contentProviderClient.query(uri, strArr, "query = ?", strArr2, null, null);
            } catch (RemoteException e) {
                Log.w("FontsProvider", "Unable to query the content provider", e);
                return null;
            }
        }

        /* JADX INFO: renamed from: rotate-Uv8p0NA, reason: not valid java name */
        public void m785rotateUv8p0NA(float f, long j) {
            Canvas canvas = ((SVG) this.editor).getCanvas();
            int i = (int) (j >> 32);
            int i2 = (int) (j & 4294967295L);
            canvas.translate(Float.intBitsToFloat(i), Float.intBitsToFloat(i2));
            canvas.rotate(f);
            canvas.translate(-Float.intBitsToFloat(i), -Float.intBitsToFloat(i2));
        }

        /* JADX INFO: renamed from: scale-0AR0LA0, reason: not valid java name */
        public void m786scale0AR0LA0(float f, float f2, long j) {
            Canvas canvas = ((SVG) this.editor).getCanvas();
            int i = (int) (j >> 32);
            int i2 = (int) (j & 4294967295L);
            canvas.translate(Float.intBitsToFloat(i), Float.intBitsToFloat(i2));
            canvas.scale(f, f2);
            canvas.translate(-Float.intBitsToFloat(i), -Float.intBitsToFloat(i2));
        }

        public void set(IntRect intRect) {
            ((Region) this.editor).set(intRect.left, intRect.top, intRect.right, intRect.bottom);
        }

        public String toString() {
            switch (this.$r8$classId) {
                case 16:
                    return "ContentInfoCompat{" + ((ContentInfo) this.editor) + "}";
                default:
                    return super.toString();
            }
        }

        public void translate(float f, float f2) {
            ((SVG) this.editor).getCanvas().translate(f, f2);
        }

        public /* synthetic */ RealEditor(int i, boolean z) {
            this.$r8$classId = i;
        }

        public RealEditor(View view) {
            this.$r8$classId = 17;
            if (Build.VERSION.SDK_INT >= 30) {
                SoftwareKeyboardControllerCompat$Impl30 softwareKeyboardControllerCompat$Impl30 = new SoftwareKeyboardControllerCompat$Impl30(11, view);
                softwareKeyboardControllerCompat$Impl30.mView = view;
                this.editor = softwareKeyboardControllerCompat$Impl30;
                return;
            }
            this.editor = new EmptyStrongMemoryCache(11, view);
        }

        public RealEditor(int i) {
            Object companion;
            this.$r8$classId = i;
            switch (i) {
                case 9:
                    ManagedRetainedValuesStore managedRetainedValuesStore = new ManagedRetainedValuesStore();
                    this.editor = managedRetainedValuesStore;
                    if (!managedRetainedValuesStore.isDisposed) {
                        if (managedRetainedValuesStore.isContentComposed) {
                            PreconditionsKt.throwIllegalStateException("ManagedValuesStore tried to enter composition twice. Did you attempt to install the same store multiple times or into two compositions?");
                        }
                        managedRetainedValuesStore.purgeUnusedExitedValues();
                        managedRetainedValuesStore.isContentComposed = true;
                        break;
                    }
                    break;
                case 11:
                    this.editor = new Region();
                    break;
                case 12:
                    if (Build.VERSION.SDK_INT >= 28) {
                        companion = new AsyncTimeout.Companion(7);
                    } else {
                        companion = new ByteString.Companion(7);
                    }
                    this.editor = companion;
                    break;
                case 18:
                    if (Build.VERSION.SDK_INT >= 26) {
                        this.editor = new AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi26(this);
                    } else {
                        this.editor = new AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi19(this);
                    }
                    break;
                case 27:
                    this.editor = HandlerCompat.createAsync(Looper.getMainLooper());
                    break;
                default:
                    this.editor = new VirtualCameraCaptureResult();
                    break;
            }
        }

        public RealEditor(EditText editText) {
            this.$r8$classId = 20;
            this.editor = new WorkLauncherImpl(editText);
        }

        @Override // androidx.sqlite.db.SupportSQLiteQuery
        public void bindTo(SupportSQLiteProgram supportSQLiteProgram) {
        }

        public RealEditor(Context context, Uri uri) {
            this.$r8$classId = 15;
            this.editor = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }

        public RealEditor(ContentInfo contentInfo) {
            this.$r8$classId = 16;
            contentInfo.getClass();
            this.editor = zzp$$ExternalSyntheticApiModelOutline0.m((Object) contentInfo);
        }

        public void addExtraDataToAccessibilityNodeInfo(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, String str, Bundle bundle) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class RealSnapshot implements Closeable {
        public final DiskLruCache.Snapshot snapshot;

        public RealSnapshot(DiskLruCache.Snapshot snapshot) {
            this.snapshot = snapshot;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            this.snapshot.close();
        }
    }

    public RealDiskCache(long j, FileSystem fileSystem, Path path) {
        DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
        this.fileSystem = fileSystem;
        this.cache = new DiskLruCache(j, fileSystem, path);
    }
}
