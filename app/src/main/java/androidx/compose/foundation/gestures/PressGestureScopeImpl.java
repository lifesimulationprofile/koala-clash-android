package androidx.compose.foundation.gestures;

import androidx.compose.ui.unit.Density;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class PressGestureScopeImpl implements Density {
    public final /* synthetic */ Density $$delegate_0;
    public boolean isCanceled;
    public boolean isReleased;
    public final MutexImpl mutex = new MutexImpl();

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.PressGestureScopeImpl$reset$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PressGestureScopeImpl.this.reset(this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.PressGestureScopeImpl$tryAwaitRelease$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class C00061 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public C00061(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PressGestureScopeImpl.this.tryAwaitRelease(this);
        }
    }

    public PressGestureScopeImpl(Density density) {
        this.$$delegate_0 = density;
    }

    public final void cancel() {
        this.isCanceled = true;
        MutexImpl mutexImpl = this.mutex;
        if (mutexImpl.isLocked()) {
            mutexImpl.unlock(null);
        }
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getDensity() {
        return this.$$delegate_0.getDensity();
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getFontScale() {
        return this.$$delegate_0.getFontScale();
    }

    public final void release() {
        this.isReleased = true;
        MutexImpl mutexImpl = this.mutex;
        if (mutexImpl.isLocked()) {
            mutexImpl.unlock(null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object reset(ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object obj = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            anonymousClass1.label = 1;
            Object objLock = this.mutex.lock(anonymousClass1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objLock == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.isReleased = false;
        this.isCanceled = false;
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
    public final int mo83roundToPx0680j_4(float f) {
        return this.$$delegate_0.mo83roundToPx0680j_4(f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
    public final float mo84toDpGaN1DYA(long j) {
        return this.$$delegate_0.mo84toDpGaN1DYA(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
    public final float mo85toDpu2uoSUM(float f) {
        return this.$$delegate_0.mo85toDpu2uoSUM(f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
    public final long mo87toDpSizekrfVVM(long j) {
        return this.$$delegate_0.mo87toDpSizekrfVVM(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
    public final float mo88toPxR2X_6o(long j) {
        return this.$$delegate_0.mo88toPxR2X_6o(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
    public final float mo89toPx0680j_4(float f) {
        return this.$$delegate_0.mo89toPx0680j_4(f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
    public final long mo90toSizeXkaWNTQ(long j) {
        return this.$$delegate_0.mo90toSizeXkaWNTQ(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
    public final long mo91toSpkPz2Gy4(float f) {
        return this.$$delegate_0.mo91toSpkPz2Gy4(f);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object tryAwaitRelease(ContinuationImpl continuationImpl) {
        C00061 c00061;
        if (continuationImpl instanceof C00061) {
            c00061 = (C00061) continuationImpl;
            int i = c00061.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00061.label = i - Integer.MIN_VALUE;
            } else {
                c00061 = new C00061(continuationImpl);
            }
        } else {
            c00061 = new C00061(continuationImpl);
        }
        Object obj = c00061.result;
        int i2 = c00061.label;
        MutexImpl mutexImpl = this.mutex;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (!this.isReleased && !this.isCanceled) {
                c00061.label = 1;
                Object objLock = mutexImpl.lock(c00061);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objLock == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            return Boolean.valueOf(this.isReleased);
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        mutexImpl.unlock(null);
        return Boolean.valueOf(this.isReleased);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
    public final float mo86toDpu2uoSUM(int i) {
        return this.$$delegate_0.mo86toDpu2uoSUM(i);
    }
}
