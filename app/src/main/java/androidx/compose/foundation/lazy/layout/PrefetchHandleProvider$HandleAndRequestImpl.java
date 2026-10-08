package androidx.compose.foundation.lazy.layout;

import android.os.Trace;
import androidx.appcompat.app.TwilightManager$TwilightState;
import androidx.camera.camera2.interop.CaptureRequestOptions$Builder$$ExternalSyntheticLambda0;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda3;
import androidx.compose.ui.layout.LayoutNodeSubcompositionsState;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.util.AndroidTrace_androidKt;
import androidx.work.impl.StartStopTokens;
import androidx.work.impl.WorkLauncherImpl;
import coil.disk.DiskLruCache;
import coil.network.HttpException;
import coil.network.RealNetworkObserver;
import com.github.kr328.clash.log.LogcatReader$$ExternalSyntheticLambda3;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlin.time.MonotonicTimeSource;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class PrefetchHandleProvider$HandleAndRequestImpl implements LazyLayoutPrefetchState.PrefetchHandle {
    public long availableTimeNanos;
    public long elapsedTimeNanos;
    public boolean hasResolvedNestedPrefetches;
    public final int index;
    public boolean isApplied;
    public boolean isCanceled;
    public boolean isMeasured;
    public boolean isUrgent;
    public Object keyUsedForComposition;
    public NestedPrefetchController nestedPrefetchController;
    public final Function1 onItemPremeasured;
    public boolean pauseRequested;
    public SubcomposeLayoutState.PausedPrecomposition pausedPrecomposition;
    public SubcomposeLayoutState.PrecomposedSlotHandle precomposeHandle;
    public final RealNetworkObserver prefetchMetrics;
    public Constraints premeasureConstraints;
    public long startTime;
    public final /* synthetic */ DiskLruCache.Editor this$0;

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class NestedPrefetchController {
        public boolean executedNestedPrefetch;
        public int requestIndex;
        public final List[] requestsByState;
        public int stateIndex;
        public final List states;

        public NestedPrefetchController(List list) {
            this.states = list;
            this.requestsByState = new List[list.size()];
            if (list.isEmpty()) {
                InlineClassHelperKt.throwIllegalArgumentException("NestedPrefetchController shouldn't be created with no states");
            }
        }
    }

    public PrefetchHandleProvider$HandleAndRequestImpl(DiskLruCache.Editor editor, int i, RealNetworkObserver realNetworkObserver, BasicTextKt$$ExternalSyntheticLambda3 basicTextKt$$ExternalSyntheticLambda3) {
        this.this$0 = editor;
        this.index = i;
        this.prefetchMetrics = realNetworkObserver;
        this.onItemPremeasured = basicTextKt$$ExternalSyntheticLambda3;
        int i2 = MonotonicTimeSource.$r8$clinit;
        this.startTime = System.nanoTime() - MonotonicTimeSource.zero;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.PrefetchHandle
    public final void cancel() {
        if (this.isCanceled) {
            return;
        }
        this.isCanceled = true;
        cleanUp();
    }

    public final void cleanUp() {
        SubcomposeLayoutState.PausedPrecomposition pausedPrecomposition = this.pausedPrecomposition;
        if (pausedPrecomposition != null) {
            pausedPrecomposition.cancel();
        }
        this.pausedPrecomposition = null;
        SubcomposeLayoutState.PrecomposedSlotHandle precomposedSlotHandle = this.precomposeHandle;
        if (precomposedSlotHandle != null) {
            precomposedSlotHandle.dispose();
        }
        this.precomposeHandle = null;
        this.nestedPrefetchController = null;
    }

    public final boolean execute(TwilightManager$TwilightState twilightManager$TwilightState) {
        boolean zExecuteRequest;
        if (!this.this$0.closed) {
            return false;
        }
        if (this.isUrgent) {
            Trace.beginSection("compose:lazy:prefetch:execute:urgent");
            try {
                zExecuteRequest = executeRequest(twilightManager$TwilightState);
                Trace.endSection();
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        } else {
            zExecuteRequest = executeRequest(twilightManager$TwilightState);
        }
        AndroidTrace_androidKt.traceValue("compose:lazy:prefetch:execute:item", -1L);
        return zExecuteRequest;
    }

    /* JADX WARN: Failed to calculate best type for var: r15v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v3 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r15v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v3 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r15v4 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v4 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v3 ??, new type: char
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 5 more
        */
    public final boolean executeRequest(androidx.appcompat.app.TwilightManager$TwilightState r26) {
        /*
            Method dump skipped, instruction units count: 778
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.PrefetchHandleProvider$HandleAndRequestImpl.executeRequest(androidx.appcompat.app.TwilightManager$TwilightState):boolean");
    }

    public final boolean isComposed() {
        SubcomposeLayoutState.PausedPrecomposition pausedPrecomposition;
        return this.isApplied || ((pausedPrecomposition = this.pausedPrecomposition) != null && pausedPrecomposition.isComplete());
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.PrefetchHandle
    public final void markAsUrgent() {
        this.isUrgent = true;
    }

    /* JADX INFO: renamed from: performMeasure-BRTryo0, reason: not valid java name */
    public final void m151performMeasureBRTryo0(long j) {
        if (this.isCanceled) {
            InlineClassHelperKt.throwIllegalArgumentException("Callers should check whether the request is still valid before calling performMeasure()");
        }
        if (this.isMeasured) {
            InlineClassHelperKt.throwIllegalArgumentException("Request was already measured!");
        }
        this.isMeasured = true;
        SubcomposeLayoutState.PrecomposedSlotHandle precomposedSlotHandle = this.precomposeHandle;
        if (precomposedSlotHandle == null) {
            InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("performComposition() must be called before performMeasure()");
            throw new HttpException();
        }
        int placeablesCount = precomposedSlotHandle.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            precomposedSlotHandle.mo530premeasure0kLqBqw(i, j);
        }
    }

    public final void performPausableComposition(Object obj, Object obj2, Averages averages) {
        SubcomposeLayoutState.PausedPrecomposition workLauncherImpl;
        SubcomposeLayoutState.PausedPrecomposition pausedPrecomposition = this.pausedPrecomposition;
        if (pausedPrecomposition == null) {
            DiskLruCache.Editor editor = this.this$0;
            Function2 content = ((LazyLayoutItemContentFactory) editor.entry).getContent(this.index, obj, obj2);
            LayoutNodeSubcompositionsState state = ((SubcomposeLayoutState) editor.written).getState();
            if (state.root.isAttached()) {
                state.precompose(obj, content, true);
                workLauncherImpl = new WorkLauncherImpl(11, state, obj);
            } else {
                workLauncherImpl = new StartStopTokens(11, state, obj);
            }
            pausedPrecomposition = workLauncherImpl;
            this.pausedPrecomposition = pausedPrecomposition;
            this.keyUsedForComposition = obj;
        }
        this.pauseRequested = false;
        while (!pausedPrecomposition.isComplete() && !this.pauseRequested) {
            pausedPrecomposition.resume(new CaptureRequestOptions$Builder$$ExternalSyntheticLambda0(13, this, averages));
        }
        updateElapsedAndAvailableTime();
        if (this.pauseRequested) {
            averages.pauseTimeNanos = Averages.calculateAverageTime(this.elapsedTimeNanos, averages.pauseTimeNanos);
        } else {
            averages.resumeTimeNanos = Averages.calculateAverageTime(this.elapsedTimeNanos, averages.resumeTimeNanos);
        }
    }

    public final NestedPrefetchController resolveNestedPrefetchStates() {
        SubcomposeLayoutState.PrecomposedSlotHandle precomposedSlotHandle = this.precomposeHandle;
        if (precomposedSlotHandle == null) {
            InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("Should precompose before resolving nested prefetch states");
            throw new HttpException();
        }
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        precomposedSlotHandle.traverseDescendants(new LogcatReader$$ExternalSyntheticLambda3(ref$ObjectRef, 1));
        List list = (List) ref$ObjectRef.element;
        if (list != null) {
            return new NestedPrefetchController(list);
        }
        return null;
    }

    public final boolean shouldExecute(long j, long j2) {
        if (this.isUrgent) {
            j2 = 0;
        }
        return j > j2;
    }

    public final String toString() {
        return "HandleAndRequestImpl { index = " + this.index + ", constraints = " + this.premeasureConstraints + ", isComposed = " + isComposed() + ", isMeasured = " + this.isMeasured + ", isCanceled = " + this.isCanceled + " }";
    }

    public final void updateElapsedAndAvailableTime() {
        long j;
        int i = MonotonicTimeSource.$r8$clinit;
        long jNanoTime = System.nanoTime() - MonotonicTimeSource.zero;
        long j2 = this.startTime;
        DurationUnit durationUnit = DurationUnit.NANOSECONDS;
        long duration = 0;
        if (((j2 - 1) | 1) == Long.MAX_VALUE) {
            if (jNanoTime == j2) {
                int i2 = Duration.$r8$clinit;
            } else {
                duration = Duration.m846unaryMinusUwyO8pc(j2 < 0 ? Duration.NEG_INFINITE : Duration.INFINITE);
            }
        } else if (((jNanoTime - 1) | 1) == Long.MAX_VALUE) {
            duration = jNanoTime < 0 ? Duration.NEG_INFINITE : Duration.INFINITE;
        } else {
            long j3 = jNanoTime - j2;
            if (((~(j3 ^ j2)) & (j3 ^ jNanoTime)) < 0) {
                DurationUnit durationUnit2 = DurationUnit.MILLISECONDS;
                if (durationUnit.compareTo(durationUnit2) < 0) {
                    long jConvert = durationUnit.timeUnit.convert(1L, durationUnit2.timeUnit);
                    long j4 = (jNanoTime / jConvert) - (j2 / jConvert);
                    long j5 = (jNanoTime % jConvert) - (j2 % jConvert);
                    int i3 = Duration.$r8$clinit;
                    duration = Duration.m844plusLRDsOJo(DurationKt.toDuration(j4, durationUnit2), DurationKt.toDuration(j5, durationUnit));
                } else {
                    duration = Duration.m846unaryMinusUwyO8pc(j3 < 0 ? Duration.NEG_INFINITE : Duration.INFINITE);
                }
            } else {
                duration = DurationKt.toDuration(j3, durationUnit);
            }
        }
        long j6 = duration >> 1;
        int i4 = Duration.$r8$clinit;
        if ((1 & ((int) duration)) == 0) {
            j = j6;
        } else if (j6 > 9223372036854L) {
            j = Long.MAX_VALUE;
        } else {
            j = j6 < -9223372036854L ? Long.MIN_VALUE : j6 * ((long) 1000000);
        }
        this.elapsedTimeNanos = j;
        long j7 = this.availableTimeNanos - j;
        this.availableTimeNanos = j7;
        this.startTime = jNanoTime;
        AndroidTrace_androidKt.traceValue("compose:lazy:prefetch:available_time_nanos", j7);
    }
}
