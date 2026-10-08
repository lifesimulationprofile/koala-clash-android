package kotlinx.serialization.json.internal;

import androidx.compose.foundation.FocusableNode$focusTargetNode$1;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.ElementMarker;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class JsonElementMarker {
    public boolean isUnmarkedNull;
    public final ElementMarker origin;

    public JsonElementMarker(SerialDescriptor serialDescriptor) {
        this.origin = new ElementMarker(serialDescriptor, new FocusableNode$focusTargetNode$1(2, this, JsonElementMarker.class, "readIfAbsent", "readIfAbsent(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", 0, 0, 3));
    }
}
