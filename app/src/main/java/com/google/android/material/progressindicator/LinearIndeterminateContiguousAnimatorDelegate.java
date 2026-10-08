package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import androidx.activity.compose.BackHandlerKt;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.room.SharedSQLiteStatement;
import androidx.transition.Transition;
import androidx.transition.ViewUtils;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class LinearIndeterminateContiguousAnimatorDelegate extends SharedSQLiteStatement {
    public static final ViewUtils.AnonymousClass1 ANIMATION_FRACTION = new ViewUtils.AnonymousClass1(Float.class, "animationFraction", 9);
    public float animationFraction;
    public ObjectAnimator animator;
    public final LinearProgressIndicatorSpec baseSpec;
    public boolean dirtyColors;
    public final FastOutSlowInInterpolator interpolator;
    public int newIndicatorColorIndex;

    public LinearIndeterminateContiguousAnimatorDelegate(LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(3);
        this.newIndicatorColorIndex = 1;
        this.baseSpec = linearProgressIndicatorSpec;
        this.interpolator = new FastOutSlowInInterpolator(0);
    }

    @Override // androidx.room.SharedSQLiteStatement
    public final void cancelAnimatorImmediately() {
        ObjectAnimator objectAnimator = this.animator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // androidx.room.SharedSQLiteStatement
    public final void invalidateSpecValues() {
        this.dirtyColors = true;
        this.newIndicatorColorIndex = 1;
        Arrays.fill((int[]) this.stmt$delegate, BackHandlerKt.compositeARGBWithAlpha(this.baseSpec.indicatorColors[0], ((IndeterminateDrawable) this.database).totalAlpha));
    }

    @Override // androidx.room.SharedSQLiteStatement
    public final void startAnimator() {
        if (this.animator == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, ANIMATION_FRACTION, 0.0f, 1.0f);
            this.animator = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(333L);
            this.animator.setInterpolator(null);
            this.animator.setRepeatCount(-1);
            this.animator.addListener(new Transition.AnonymousClass3(4, this));
        }
        this.dirtyColors = true;
        this.newIndicatorColorIndex = 1;
        Arrays.fill((int[]) this.stmt$delegate, BackHandlerKt.compositeARGBWithAlpha(this.baseSpec.indicatorColors[0], ((IndeterminateDrawable) this.database).totalAlpha));
        this.animator.start();
    }

    @Override // androidx.room.SharedSQLiteStatement
    public final void requestCancelAnimatorAfterCurrentCycle() {
    }

    @Override // androidx.room.SharedSQLiteStatement
    public final void unregisterAnimatorsCompleteCallback() {
    }

    @Override // androidx.room.SharedSQLiteStatement
    public final void registerAnimatorsCompleteCallback(BaseProgressIndicator.AnonymousClass3 anonymousClass3) {
    }
}
