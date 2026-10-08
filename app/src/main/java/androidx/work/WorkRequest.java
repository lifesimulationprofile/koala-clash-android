package androidx.work;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.os.Build;
import android.util.Size;
import android.view.Display;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.view.PreviewTransformation;
import androidx.camera.view.PreviewView$1$$ExternalSyntheticLambda2;
import androidx.work.impl.model.WorkSpec;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.AbstractList;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class WorkRequest {
    public final UUID id;
    public final Set tags;
    public final WorkSpec workSpec;

    public WorkRequest(UUID uuid, WorkSpec workSpec, LinkedHashSet linkedHashSet) {
        this.id = uuid;
        this.workSpec = workSpec;
        this.tags = linkedHashSet;
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public abstract class Builder {
        public boolean backoffCriteriaSet;
        public Object id;
        public final Object tags;
        public Object workSpec;

        public Builder(FrameLayout frameLayout, PreviewTransformation previewTransformation) {
            this.backoffCriteriaSet = false;
            this.workSpec = frameLayout;
            this.tags = previewTransformation;
        }

        public WorkRequest build() {
            WorkRequest workRequestBuildInternal$work_runtime_release = buildInternal$work_runtime_release();
            Constraints constraints = ((WorkSpec) this.workSpec).constraints;
            boolean z = (Build.VERSION.SDK_INT >= 24 && constraints.hasContentUriTriggers()) || constraints.requiresBatteryNotLow || constraints.requiresCharging || constraints.requiresDeviceIdle;
            WorkSpec workSpec = (WorkSpec) this.workSpec;
            if (workSpec.expedited) {
                if (z) {
                    throw new IllegalArgumentException("Expedited jobs only support network and storage constraints");
                }
                if (workSpec.initialDelay > 0) {
                    throw new IllegalArgumentException("Expedited jobs cannot be delayed");
                }
            }
            UUID uuidRandomUUID = UUID.randomUUID();
            this.id = uuidRandomUUID;
            String string = uuidRandomUUID.toString();
            WorkSpec workSpec2 = (WorkSpec) this.workSpec;
            this.workSpec = new WorkSpec(string, workSpec2.state, workSpec2.workerClassName, workSpec2.inputMergerClassName, new Data(workSpec2.input), new Data(workSpec2.output), workSpec2.initialDelay, workSpec2.intervalDuration, workSpec2.flexDuration, new Constraints(workSpec2.constraints), workSpec2.runAttemptCount, workSpec2.backoffPolicy, workSpec2.backoffDelayDuration, workSpec2.lastEnqueueTime, workSpec2.minimumRetentionDuration, workSpec2.scheduleRequestedAt, workSpec2.expedited, workSpec2.outOfQuotaPolicy, workSpec2.periodCount, workSpec2.nextScheduleTimeOverride, workSpec2.nextScheduleTimeOverrideGeneration, workSpec2.stopReason, 524288);
            return workRequestBuildInternal$work_runtime_release;
        }

        public abstract WorkRequest buildInternal$work_runtime_release();

        public abstract View getPreview();

        public abstract Bitmap getPreviewBitmap();

        public abstract Builder getThisObject$work_runtime_release();

        public abstract void onAttachedToWindow();

        public abstract void onDetachedFromWindow();

        public abstract void onSurfaceRequested(SurfaceRequest surfaceRequest, PreviewView$1$$ExternalSyntheticLambda2 previewView$1$$ExternalSyntheticLambda2);

        public void redrawPreview() {
            FrameLayout frameLayout = (FrameLayout) this.workSpec;
            View preview = getPreview();
            if (preview == null || !this.backoffCriteriaSet) {
                return;
            }
            PreviewTransformation previewTransformation = (PreviewTransformation) this.tags;
            Size size = new Size(frameLayout.getWidth(), frameLayout.getHeight());
            int layoutDirection = frameLayout.getLayoutDirection();
            previewTransformation.getClass();
            if (size.getHeight() == 0 || size.getWidth() == 0) {
                LazyKt__LazyJVMKt.w("PreviewTransform", "Transform not applied due to PreviewView size: " + size);
                return;
            }
            if (previewTransformation.isTransformationInfoReady()) {
                if (preview instanceof TextureView) {
                    ((TextureView) preview).setTransform(previewTransformation.getTextureViewCorrectionMatrix());
                } else {
                    Display display = preview.getDisplay();
                    boolean z = false;
                    boolean z2 = (!previewTransformation.mHasCameraTransform || display == null || display.getRotation() == previewTransformation.mTargetRotation) ? false : true;
                    boolean z3 = previewTransformation.mHasCameraTransform;
                    if (!z3) {
                        if ((!z3 ? previewTransformation.mPreviewRotationDegrees : -AbstractList.Companion.surfaceRotationToDegrees(previewTransformation.mTargetRotation)) != 0) {
                            z = true;
                        }
                    }
                    if (z2 || z) {
                        LazyKt__LazyJVMKt.e("PreviewTransform", "Custom rotation not supported with SurfaceView/PERFORMANCE mode.");
                    }
                }
                RectF transformedSurfaceRect = previewTransformation.getTransformedSurfaceRect(size, layoutDirection);
                preview.setPivotX(0.0f);
                preview.setPivotY(0.0f);
                preview.setScaleX(transformedSurfaceRect.width() / previewTransformation.mResolution.getWidth());
                preview.setScaleY(transformedSurfaceRect.height() / previewTransformation.mResolution.getHeight());
                preview.setTranslationX(transformedSurfaceRect.left - preview.getLeft());
                preview.setTranslationY(transformedSurfaceRect.top - preview.getTop());
            }
        }

        public Builder setBackoffCriteria(long j) {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.backoffCriteriaSet = true;
            WorkSpec workSpec = (WorkSpec) this.workSpec;
            workSpec.backoffPolicy = 1;
            long millis = timeUnit.toMillis(j);
            String str = WorkSpec.TAG;
            if (millis > 18000000) {
                Logger$LogcatLogger.get().warning(str, "Backoff delay duration exceeds maximum value");
            }
            if (millis < 10000) {
                Logger$LogcatLogger.get().warning(str, "Backoff delay duration less than minimum value");
            }
            workSpec.backoffDelayDuration = RangesKt.coerceIn(millis, 10000L, 18000000L);
            return getThisObject$work_runtime_release();
        }

        public abstract ListenableFuture waitForNextFrame();

        public Builder(Class cls) {
            this.id = UUID.randomUUID();
            this.workSpec = new WorkSpec(((UUID) this.id).toString(), 0, cls.getName(), (String) null, (Data) null, (Data) null, 0L, 0L, 0L, (Constraints) null, 0, 0, 0L, 0L, 0L, 0L, false, 0, 0, 0L, 0, 0, 8388602);
            String[] strArr = {cls.getName()};
            LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt__MapsKt.mapCapacity(1));
            linkedHashSet.add(strArr[0]);
            this.tags = linkedHashSet;
        }
    }
}
