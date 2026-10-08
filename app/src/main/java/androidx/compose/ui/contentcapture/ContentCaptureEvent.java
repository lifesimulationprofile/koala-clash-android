package androidx.compose.ui.contentcapture;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import coil.disk.RealDiskCache;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ContentCaptureEvent {
    public final int id;
    public final RealDiskCache.RealEditor structureCompat;
    public final long timestamp;
    public final int type;

    public ContentCaptureEvent(int i, long j, int i2, RealDiskCache.RealEditor realEditor) {
        this.id = i;
        this.timestamp = j;
        this.type = i2;
        this.structureCompat = realEditor;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ContentCaptureEvent)) {
            return false;
        }
        ContentCaptureEvent contentCaptureEvent = (ContentCaptureEvent) obj;
        return this.id == contentCaptureEvent.id && this.timestamp == contentCaptureEvent.timestamp && this.type == contentCaptureEvent.type && Intrinsics.areEqual(this.structureCompat, contentCaptureEvent.structureCompat);
    }

    public final int hashCode() {
        int i = this.id * 31;
        long j = this.timestamp;
        int iM = ImageAnalysis$$ExternalSyntheticLambda1.m(this.type, (i + ((int) (j ^ (j >>> 32)))) * 31, 31);
        RealDiskCache.RealEditor realEditor = this.structureCompat;
        return iM + (realEditor == null ? 0 : realEditor.hashCode());
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("ContentCaptureEvent(id=");
        sb.append(this.id);
        sb.append(", timestamp=");
        sb.append(this.timestamp);
        sb.append(", type=");
        int i = this.type;
        if (i != 1) {
            str = i != 2 ? "null" : "VIEW_DISAPPEAR";
        } else {
            str = "VIEW_APPEAR";
        }
        sb.append(str);
        sb.append(", structureCompat=");
        sb.append(this.structureCompat);
        sb.append(')');
        return sb.toString();
    }
}
