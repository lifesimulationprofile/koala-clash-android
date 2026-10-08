package androidx.compose.runtime.tooling;

import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.connection.Exchange;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ComposeStackTraceFrame {
    public final int groupKey;
    public final Integer groupOffset;
    public final Exchange sourceInfo;

    public ComposeStackTraceFrame(int i, Exchange exchange, Integer num) {
        this.groupKey = i;
        this.sourceInfo = exchange;
        this.groupOffset = num;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ComposeStackTraceFrame)) {
            return false;
        }
        ComposeStackTraceFrame composeStackTraceFrame = (ComposeStackTraceFrame) obj;
        return this.groupKey == composeStackTraceFrame.groupKey && Intrinsics.areEqual(this.sourceInfo, composeStackTraceFrame.sourceInfo) && Intrinsics.areEqual(this.groupOffset, composeStackTraceFrame.groupOffset);
    }

    public final int hashCode() {
        int i = this.groupKey * 31;
        Exchange exchange = this.sourceInfo;
        int iHashCode = (i + (exchange == null ? 0 : exchange.hashCode())) * 31;
        Integer num = this.groupOffset;
        return iHashCode + (num != null ? num.hashCode() : 0);
    }

    public final String toString() {
        return "ComposeStackTraceFrame(groupKey=" + this.groupKey + ", sourceInfo=" + this.sourceInfo + ", groupOffset=" + this.groupOffset + ')';
    }
}
