package androidx.camera.core.impl;

import androidx.camera.core.RetryPolicy;
import androidx.core.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class TimeoutRetryPolicy implements RetryPolicy {
    public final RetryPolicy mDelegatePolicy;
    public final long mTimeoutInMillis;

    public TimeoutRetryPolicy(long j, RetryPolicy retryPolicy) {
        Preconditions.checkArgument("Timeout must be non-negative.", j >= 0);
        this.mTimeoutInMillis = j;
        this.mDelegatePolicy = retryPolicy;
    }

    @Override // androidx.camera.core.RetryPolicy
    public final long getTimeoutInMillis() {
        return this.mTimeoutInMillis;
    }

    @Override // androidx.camera.core.RetryPolicy
    public final RetryPolicy.RetryConfig onRetryDecisionRequested(CameraProviderExecutionState cameraProviderExecutionState) {
        RetryPolicy.RetryConfig retryConfigOnRetryDecisionRequested = this.mDelegatePolicy.onRetryDecisionRequested(cameraProviderExecutionState);
        long j = this.mTimeoutInMillis;
        return (j <= 0 || cameraProviderExecutionState.mTaskExecutedTimeInMillis < j - retryConfigOnRetryDecisionRequested.mDelayInMillis) ? retryConfigOnRetryDecisionRequested : RetryPolicy.RetryConfig.NOT_RETRY;
    }
}
