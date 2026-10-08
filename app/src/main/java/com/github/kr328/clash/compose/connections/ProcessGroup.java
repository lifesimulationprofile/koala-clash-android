package com.github.kr328.clash.compose.connections;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ProcessGroup {
    public final ArrayList activeConnections;
    public final ArrayList closedConnections;
    public final String process;

    public ProcessGroup(String str, ArrayList arrayList, ArrayList arrayList2) {
        this.process = str;
        this.activeConnections = arrayList;
        this.closedConnections = arrayList2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProcessGroup)) {
            return false;
        }
        ProcessGroup processGroup = (ProcessGroup) obj;
        return Intrinsics.areEqual(this.process, processGroup.process) && this.activeConnections.equals(processGroup.activeConnections) && this.closedConnections.equals(processGroup.closedConnections);
    }

    public final int hashCode() {
        return this.closedConnections.hashCode() + ((this.activeConnections.hashCode() + (this.process.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "ProcessGroup(process=" + this.process + ", activeConnections=" + this.activeConnections + ", closedConnections=" + this.closedConnections + ")";
    }
}
