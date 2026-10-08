package com.github.kr328.clash.compose.connections;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ProcessAppInfo {
    public final Drawable icon;
    public final String label;

    public ProcessAppInfo(String str, Drawable drawable) {
        this.label = str;
        this.icon = drawable;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProcessAppInfo)) {
            return false;
        }
        ProcessAppInfo processAppInfo = (ProcessAppInfo) obj;
        return Intrinsics.areEqual(this.label, processAppInfo.label) && Intrinsics.areEqual(this.icon, processAppInfo.icon);
    }

    public final int hashCode() {
        int iHashCode = this.label.hashCode() * 31;
        Drawable drawable = this.icon;
        return iHashCode + (drawable == null ? 0 : drawable.hashCode());
    }

    public final String toString() {
        return "ProcessAppInfo(label=" + this.label + ", icon=" + this.icon + ")";
    }
}
