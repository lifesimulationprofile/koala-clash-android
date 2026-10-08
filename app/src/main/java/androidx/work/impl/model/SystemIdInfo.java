package androidx.work.impl.model;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class SystemIdInfo {
    public final int generation;
    public final int systemId;
    public final String workSpecId;

    public SystemIdInfo(int i, int i2, String str) {
        this.workSpecId = str;
        this.generation = i;
        this.systemId = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SystemIdInfo)) {
            return false;
        }
        SystemIdInfo systemIdInfo = (SystemIdInfo) obj;
        return Intrinsics.areEqual(this.workSpecId, systemIdInfo.workSpecId) && this.generation == systemIdInfo.generation && this.systemId == systemIdInfo.systemId;
    }

    public final int hashCode() {
        return (((this.workSpecId.hashCode() * 31) + this.generation) * 31) + this.systemId;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SystemIdInfo(workSpecId=");
        sb.append(this.workSpecId);
        sb.append(", generation=");
        sb.append(this.generation);
        sb.append(", systemId=");
        return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, this.systemId, ')');
    }
}
