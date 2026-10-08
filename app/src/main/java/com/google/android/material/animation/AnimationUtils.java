package com.google.android.material.animation;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AnimationUtils {
    public static final LinearInterpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    public static final FastOutSlowInInterpolator FAST_OUT_SLOW_IN_INTERPOLATOR = new FastOutSlowInInterpolator(0);
    public static final FastOutSlowInInterpolator FAST_OUT_LINEAR_IN_INTERPOLATOR = new FastOutSlowInInterpolator(1);
    public static final FastOutSlowInInterpolator LINEAR_OUT_SLOW_IN_INTERPOLATOR = new FastOutSlowInInterpolator(FastOutSlowInInterpolator.VALUES$2);

    static {
        new DecelerateInterpolator();
    }

    public static float lerp(float f, float f2, float f3) {
        return ImageAnalysis$$ExternalSyntheticLambda1.m(f2, f, f3, f);
    }
}
