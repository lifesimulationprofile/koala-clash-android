package com.github.kr328.clash.compose.newprofile;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import com.github.kr328.clash.service.HwidLimitMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ProfileAddResult {

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Error extends ProfileAddResult {
        public final String message;

        public Error(String str) {
            this.message = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Error) && Intrinsics.areEqual(this.message, ((Error) obj).message);
        }

        public final int hashCode() {
            return this.message.hashCode();
        }

        public final String toString() {
            return ImageAnalysis$$ExternalSyntheticLambda1.m$1("Error(message=", this.message, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class HwidLimitHit extends ProfileAddResult {
        public final HwidLimitMarker marker;

        public HwidLimitHit(HwidLimitMarker hwidLimitMarker) {
            this.marker = hwidLimitMarker;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof HwidLimitHit) && Intrinsics.areEqual(this.marker, ((HwidLimitHit) obj).marker);
        }

        public final int hashCode() {
            return this.marker.hashCode();
        }

        public final String toString() {
            return "HwidLimitHit(marker=" + this.marker + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Success extends ProfileAddResult {
        public static final Success INSTANCE = new Success();

        public final boolean equals(Object obj) {
            return this == obj || (obj instanceof Success);
        }

        public final int hashCode() {
            return 1225499000;
        }

        public final String toString() {
            return "Success";
        }
    }
}
