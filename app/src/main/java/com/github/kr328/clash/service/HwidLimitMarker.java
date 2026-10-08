package com.github.kr328.clash.service;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class HwidLimitMarker {
    public final String supportURL;

    public HwidLimitMarker(String str) {
        this.supportURL = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof HwidLimitMarker) && Intrinsics.areEqual(this.supportURL, ((HwidLimitMarker) obj).supportURL);
    }

    public final int hashCode() {
        String str = this.supportURL;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public final String toString() {
        return ImageAnalysis$$ExternalSyntheticLambda1.m$1("HwidLimitMarker(supportURL=", this.supportURL, ")");
    }
}
