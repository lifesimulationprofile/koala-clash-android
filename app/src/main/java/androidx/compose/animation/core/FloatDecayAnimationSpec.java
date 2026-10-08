package androidx.compose.animation.core;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface FloatDecayAnimationSpec {
    float getAbsVelocityThreshold();

    long getDurationNanos(float f);

    float getTargetValue(float f, float f2);

    float getValueFromNanos(float f, float f2, long j);

    float getVelocityFromNanos(float f, long j);
}
