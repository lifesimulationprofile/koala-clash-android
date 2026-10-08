package com.github.kr328.clash.compose;

import com.github.kr328.clash.core.model.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ProviderItemState {
    public final Provider provider;
    public final long updatedAt;
    public final boolean updating;

    public ProviderItemState(Provider provider, long j, boolean z) {
        this.provider = provider;
        this.updatedAt = j;
        this.updating = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProviderItemState)) {
            return false;
        }
        ProviderItemState providerItemState = (ProviderItemState) obj;
        return Intrinsics.areEqual(this.provider, providerItemState.provider) && this.updatedAt == providerItemState.updatedAt && this.updating == providerItemState.updating;
    }

    public final int hashCode() {
        int iHashCode = this.provider.hashCode() * 31;
        long j = this.updatedAt;
        return ((iHashCode + ((int) (j ^ (j >>> 32)))) * 31) + (this.updating ? 1231 : 1237);
    }

    public final String toString() {
        return "ProviderItemState(provider=" + this.provider + ", updatedAt=" + this.updatedAt + ", updating=" + this.updating + ")";
    }
}
