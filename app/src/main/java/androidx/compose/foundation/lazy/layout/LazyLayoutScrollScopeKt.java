package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.lazy.LazyListScrollScopeKt$LazyLayoutScrollScope$1;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class LazyLayoutScrollScopeKt {
    public static final float TargetDistance = 2500;
    public static final float BoundDistance = 1500;
    public static final float MinimumDistance = 50;

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutScrollScopeKt$animateScrollToItem$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public float F$0;
        public float F$1;
        public float F$2;
        public int I$0;
        public int I$2;
        public int I$3;
        public LazyListScrollScopeKt$LazyLayoutScrollScope$1 L$0;
        public Ref$BooleanRef L$1;
        public Ref$ObjectRef L$2;
        public Ref$IntRef L$3;
        public int label;
        public /* synthetic */ Object result;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LazyLayoutScrollScopeKt.animateScrollToItem(null, 0, 0, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00cc A[Catch: ItemFoundInScroll -> 0x0192, TRY_ENTER, TRY_LEAVE, TryCatch #7 {ItemFoundInScroll -> 0x0192, blocks: (B:33:0x00bc, B:37:0x00cc, B:50:0x00f2, B:52:0x0106, B:56:0x011b, B:60:0x0123), top: B:110:0x00bc }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:44:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:47:0x00ed A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:48:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:49:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:54:0x0118  */
    /* JADX WARN: Code duplicated, block: B:55:0x011a  */
    /* JADX WARN: Code duplicated, block: B:58:0x011e  */
    /* JADX WARN: Code duplicated, block: B:59:0x0121  */
    /* JADX WARN: Code duplicated, block: B:69:0x016c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code duplicated, block: B:99:0x00c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x016c -> B:106:0x0176). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object animateScrollToItem(androidx.compose.foundation.lazy.LazyListScrollScopeKt$LazyLayoutScrollScope$1 r27, int r28, int r29, androidx.compose.ui.unit.Density r30, kotlin.coroutines.jvm.internal.ContinuationImpl r31) {
        /*
            Method dump skipped, instruction units count: 519
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyLayoutScrollScopeKt.animateScrollToItem(androidx.compose.foundation.lazy.LazyListScrollScopeKt$LazyLayoutScrollScope$1, int, int, androidx.compose.ui.unit.Density, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public static final boolean animateScrollToItem$isOvershot(boolean z, LazyListScrollScopeKt$LazyLayoutScrollScope$1 lazyListScrollScopeKt$LazyLayoutScrollScope$1, int i) {
        if (z) {
            if (lazyListScrollScopeKt$LazyLayoutScrollScope$1.getFirstVisibleItemIndex() > i) {
                return true;
            }
            return lazyListScrollScopeKt$LazyLayoutScrollScope$1.getFirstVisibleItemIndex() == i && ((ParcelableSnapshotMutableIntState) ((LazyListState) lazyListScrollScopeKt$LazyLayoutScrollScope$1.$state).scrollPosition.finder).getIntValue() > 0;
        }
        if (lazyListScrollScopeKt$LazyLayoutScrollScope$1.getFirstVisibleItemIndex() < i) {
            return true;
        }
        return lazyListScrollScopeKt$LazyLayoutScrollScope$1.getFirstVisibleItemIndex() == i && ((ParcelableSnapshotMutableIntState) ((LazyListState) lazyListScrollScopeKt$LazyLayoutScrollScope$1.$state).scrollPosition.finder).getIntValue() < 0;
    }

    public static final boolean isItemVisible(LazyListScrollScopeKt$LazyLayoutScrollScope$1 lazyListScrollScopeKt$LazyLayoutScrollScope$1, int i) {
        return i <= lazyListScrollScopeKt$LazyLayoutScrollScope$1.getLastVisibleItemIndex() && lazyListScrollScopeKt$LazyLayoutScrollScope$1.getFirstVisibleItemIndex() <= i;
    }
}
