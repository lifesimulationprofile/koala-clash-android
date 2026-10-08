package androidx.work.impl.model;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Density;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.Logger$LogcatLogger;
import androidx.work.OverwritingInputMerger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class WorkSpec {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("WorkSpec");
    public long backoffDelayDuration;
    public int backoffPolicy;
    public Constraints constraints;
    public boolean expedited;
    public long flexDuration;
    public final int generation;
    public final String id;
    public final long initialDelay;
    public Data input;
    public final String inputMergerClassName;
    public long intervalDuration;
    public long lastEnqueueTime;
    public final long minimumRetentionDuration;
    public long nextScheduleTimeOverride;
    public int nextScheduleTimeOverrideGeneration;
    public final int outOfQuotaPolicy;
    public final Data output;
    public final int periodCount;
    public final int runAttemptCount;
    public final long scheduleRequestedAt;
    public int state;
    public final int stopReason;
    public final String workerClassName;

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class IdAndState {
        public String id;
        public int state;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IdAndState)) {
                return false;
            }
            IdAndState idAndState = (IdAndState) obj;
            return Intrinsics.areEqual(this.id, idAndState.id) && this.state == idAndState.state;
        }

        public final int hashCode() {
            return CaptureSession$State$EnumUnboxingLocalUtility.ordinal(this.state) + (this.id.hashCode() * 31);
        }

        public final String toString() {
            return "IdAndState(id=" + this.id + ", state=" + Density.CC.stringValueOf$5(this.state) + ')';
        }
    }

    public WorkSpec(String str, int i, String str2, String str3, Data data, Data data2, long j, long j2, long j3, Constraints constraints, int i2, int i3, long j4, long j5, long j6, long j7, boolean z, int i4, int i5, int i6, long j8, int i7, int i8) {
        this.id = str;
        this.state = i;
        this.workerClassName = str2;
        this.inputMergerClassName = str3;
        this.input = data;
        this.output = data2;
        this.initialDelay = j;
        this.intervalDuration = j2;
        this.flexDuration = j3;
        this.constraints = constraints;
        this.runAttemptCount = i2;
        this.backoffPolicy = i3;
        this.backoffDelayDuration = j4;
        this.lastEnqueueTime = j5;
        this.minimumRetentionDuration = j6;
        this.scheduleRequestedAt = j7;
        this.expedited = z;
        this.outOfQuotaPolicy = i4;
        this.periodCount = i5;
        this.generation = i6;
        this.nextScheduleTimeOverride = j8;
        this.nextScheduleTimeOverrideGeneration = i7;
        this.stopReason = i8;
    }

    public static WorkSpec copy$default(WorkSpec workSpec, String str, int i, String str2, Data data, int i2, long j, int i3, int i4, long j2, int i5, int i6) {
        String str3 = (i6 & 1) != 0 ? workSpec.id : str;
        int i7 = (i6 & 2) != 0 ? workSpec.state : i;
        String str4 = (i6 & 4) != 0 ? workSpec.workerClassName : str2;
        String str5 = workSpec.inputMergerClassName;
        Data data2 = (i6 & 16) != 0 ? workSpec.input : data;
        Data data3 = workSpec.output;
        long j3 = workSpec.initialDelay;
        long j4 = workSpec.intervalDuration;
        long j5 = workSpec.flexDuration;
        Constraints constraints = workSpec.constraints;
        int i8 = (i6 & 1024) != 0 ? workSpec.runAttemptCount : i2;
        int i9 = workSpec.backoffPolicy;
        long j6 = workSpec.backoffDelayDuration;
        long j7 = (i6 & 8192) != 0 ? workSpec.lastEnqueueTime : j;
        long j8 = workSpec.minimumRetentionDuration;
        long j9 = workSpec.scheduleRequestedAt;
        boolean z = workSpec.expedited;
        int i10 = workSpec.outOfQuotaPolicy;
        int i11 = (i6 & 262144) != 0 ? workSpec.periodCount : i3;
        int i12 = (i6 & 524288) != 0 ? workSpec.generation : i4;
        long j10 = (i6 & 1048576) != 0 ? workSpec.nextScheduleTimeOverride : j2;
        int i13 = (i6 & 2097152) != 0 ? workSpec.nextScheduleTimeOverrideGeneration : i5;
        int i14 = workSpec.stopReason;
        workSpec.getClass();
        return new WorkSpec(str3, i7, str4, str5, data2, data3, j3, j4, j5, constraints, i8, i9, j6, j7, j8, j9, z, i10, i11, i12, j10, i13, i14);
    }

    public final long calculateNextRunTime() {
        int i = this.state;
        int i2 = this.runAttemptCount;
        boolean z = i == 1 && i2 > 0;
        int i3 = this.backoffPolicy;
        long j = this.backoffDelayDuration;
        long j2 = this.lastEnqueueTime;
        boolean zIsPeriodic = isPeriodic();
        long j3 = this.flexDuration;
        long j4 = this.intervalDuration;
        long j5 = this.nextScheduleTimeOverride;
        int i4 = this.periodCount;
        if (j5 != Long.MAX_VALUE && zIsPeriodic) {
            if (i4 != 0) {
                long j6 = j2 + 900000;
                if (j5 < j6) {
                    return j6;
                }
            }
            return j5;
        }
        if (z) {
            long jScalb = i3 == 2 ? j * ((long) i2) : (long) Math.scalb(j, i2 - 1);
            if (jScalb > 18000000) {
                jScalb = 18000000;
            }
            return j2 + jScalb;
        }
        long j7 = this.initialDelay;
        if (zIsPeriodic) {
            long j8 = i4 == 0 ? j2 + j7 : j2 + j4;
            return (j3 == j4 || i4 != 0) ? j8 : (j4 - j3) + j8;
        }
        if (j2 == -1) {
            return Long.MAX_VALUE;
        }
        return j2 + j7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WorkSpec)) {
            return false;
        }
        WorkSpec workSpec = (WorkSpec) obj;
        return Intrinsics.areEqual(this.id, workSpec.id) && this.state == workSpec.state && Intrinsics.areEqual(this.workerClassName, workSpec.workerClassName) && Intrinsics.areEqual(this.inputMergerClassName, workSpec.inputMergerClassName) && Intrinsics.areEqual(this.input, workSpec.input) && Intrinsics.areEqual(this.output, workSpec.output) && this.initialDelay == workSpec.initialDelay && this.intervalDuration == workSpec.intervalDuration && this.flexDuration == workSpec.flexDuration && Intrinsics.areEqual(this.constraints, workSpec.constraints) && this.runAttemptCount == workSpec.runAttemptCount && this.backoffPolicy == workSpec.backoffPolicy && this.backoffDelayDuration == workSpec.backoffDelayDuration && this.lastEnqueueTime == workSpec.lastEnqueueTime && this.minimumRetentionDuration == workSpec.minimumRetentionDuration && this.scheduleRequestedAt == workSpec.scheduleRequestedAt && this.expedited == workSpec.expedited && this.outOfQuotaPolicy == workSpec.outOfQuotaPolicy && this.periodCount == workSpec.periodCount && this.generation == workSpec.generation && this.nextScheduleTimeOverride == workSpec.nextScheduleTimeOverride && this.nextScheduleTimeOverrideGeneration == workSpec.nextScheduleTimeOverrideGeneration && this.stopReason == workSpec.stopReason;
    }

    public final boolean hasConstraints() {
        return !Constraints.NONE.equals(this.constraints);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v27, types: [int] */
    /* JADX WARN: Type inference failed for: r2v35, types: [int] */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v44 */
    public final int hashCode() {
        int iHashCode = (this.output.hashCode() + ((this.input.hashCode() + Modifier.CC.m(Modifier.CC.m(ImageAnalysis$$ExternalSyntheticLambda1.m(this.state, this.id.hashCode() * 31, 31), 31, this.workerClassName), 31, this.inputMergerClassName)) * 31)) * 31;
        long j = this.initialDelay;
        int i = (iHashCode + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.intervalDuration;
        int i2 = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.flexDuration;
        int iM = ImageAnalysis$$ExternalSyntheticLambda1.m(this.backoffPolicy, (((this.constraints.hashCode() + ((i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31)) * 31) + this.runAttemptCount) * 31, 31);
        long j4 = this.backoffDelayDuration;
        int i3 = (iM + ((int) (j4 ^ (j4 >>> 32)))) * 31;
        long j5 = this.lastEnqueueTime;
        int i4 = (i3 + ((int) (j5 ^ (j5 >>> 32)))) * 31;
        long j6 = this.minimumRetentionDuration;
        int i5 = (i4 + ((int) (j6 ^ (j6 >>> 32)))) * 31;
        long j7 = this.scheduleRequestedAt;
        int i6 = (i5 + ((int) (j7 ^ (j7 >>> 32)))) * 31;
        boolean z = this.expedited;
        ?? r2 = z;
        if (z) {
            r2 = 1;
        }
        int iM2 = (((ImageAnalysis$$ExternalSyntheticLambda1.m(this.outOfQuotaPolicy, (i6 + r2) * 31, 31) + this.periodCount) * 31) + this.generation) * 31;
        long j8 = this.nextScheduleTimeOverride;
        return ((((iM2 + ((int) (j8 ^ (j8 >>> 32)))) * 31) + this.nextScheduleTimeOverrideGeneration) * 31) + this.stopReason;
    }

    public final boolean isPeriodic() {
        return this.intervalDuration != 0;
    }

    public final String toString() {
        return Modifier.CC.m(new StringBuilder("{WorkSpec: "), this.id, '}');
    }

    public /* synthetic */ WorkSpec(String str, int i, String str2, String str3, Data data, Data data2, long j, long j2, long j3, Constraints constraints, int i2, int i3, long j4, long j5, long j6, long j7, boolean z, int i4, int i5, long j8, int i6, int i7, int i8) {
        this(str, (i8 & 2) != 0 ? 1 : i, str2, (i8 & 8) != 0 ? OverwritingInputMerger.class.getName() : str3, (i8 & 16) != 0 ? Data.EMPTY : data, (i8 & 32) != 0 ? Data.EMPTY : data2, (i8 & 64) != 0 ? 0L : j, (i8 & 128) != 0 ? 0L : j2, (i8 & 256) != 0 ? 0L : j3, (i8 & 512) != 0 ? Constraints.NONE : constraints, (i8 & 1024) != 0 ? 0 : i2, (i8 & 2048) != 0 ? 1 : i3, (i8 & 4096) != 0 ? 30000L : j4, (i8 & 8192) != 0 ? -1L : j5, (i8 & 16384) == 0 ? j6 : 0L, (32768 & i8) != 0 ? -1L : j7, (65536 & i8) != 0 ? false : z, (131072 & i8) != 0 ? 1 : i4, (262144 & i8) != 0 ? 0 : i5, 0, (1048576 & i8) != 0 ? Long.MAX_VALUE : j8, (2097152 & i8) != 0 ? 0 : i6, (i8 & 4194304) != 0 ? -256 : i7);
    }
}
