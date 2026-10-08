package com.google.android.datatransport.cct.internal;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_BatchedLogRequest extends BatchedLogRequest {
    public final ArrayList logRequests;

    public AutoValue_BatchedLogRequest(ArrayList arrayList) {
        this.logRequests = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BatchedLogRequest)) {
            return false;
        }
        return this.logRequests.equals(((AutoValue_BatchedLogRequest) ((BatchedLogRequest) obj)).logRequests);
    }

    public final int hashCode() {
        return this.logRequests.hashCode() ^ 1000003;
    }

    public final String toString() {
        return "BatchedLogRequest{logRequests=" + this.logRequests + "}";
    }
}
