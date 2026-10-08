package com.google.android.datatransport.runtime.scheduling.persistence;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.barcode.ModuleDescriptor;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_EventStoreConfig {
    public static final AutoValue_EventStoreConfig DEFAULT = new AutoValue_EventStoreConfig(10485760, 200, ModuleDescriptor.MODULE_VERSION, 604800000, 81920);
    public final int criticalSectionEnterTimeoutMs;
    public final long eventCleanUpAge;
    public final int loadBatchSize;
    public final int maxBlobByteSizePerRow;
    public final long maxStorageSizeInBytes;

    public AutoValue_EventStoreConfig(long j, int i, int i2, long j2, int i3) {
        this.maxStorageSizeInBytes = j;
        this.loadBatchSize = i;
        this.criticalSectionEnterTimeoutMs = i2;
        this.eventCleanUpAge = j2;
        this.maxBlobByteSizePerRow = i3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AutoValue_EventStoreConfig) {
            AutoValue_EventStoreConfig autoValue_EventStoreConfig = (AutoValue_EventStoreConfig) obj;
            if (this.maxStorageSizeInBytes == autoValue_EventStoreConfig.maxStorageSizeInBytes && this.loadBatchSize == autoValue_EventStoreConfig.loadBatchSize && this.criticalSectionEnterTimeoutMs == autoValue_EventStoreConfig.criticalSectionEnterTimeoutMs && this.eventCleanUpAge == autoValue_EventStoreConfig.eventCleanUpAge && this.maxBlobByteSizePerRow == autoValue_EventStoreConfig.maxBlobByteSizePerRow) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.maxStorageSizeInBytes;
        int i = (((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.loadBatchSize) * 1000003) ^ this.criticalSectionEnterTimeoutMs) * 1000003;
        long j2 = this.eventCleanUpAge;
        return ((i ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.maxBlobByteSizePerRow;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("EventStoreConfig{maxStorageSizeInBytes=");
        sb.append(this.maxStorageSizeInBytes);
        sb.append(", loadBatchSize=");
        sb.append(this.loadBatchSize);
        sb.append(", criticalSectionEnterTimeoutMs=");
        sb.append(this.criticalSectionEnterTimeoutMs);
        sb.append(", eventCleanUpAge=");
        sb.append(this.eventCleanUpAge);
        sb.append(", maxBlobByteSizePerRow=");
        return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, this.maxBlobByteSizePerRow, "}");
    }
}
