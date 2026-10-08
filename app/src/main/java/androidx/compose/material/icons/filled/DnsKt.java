package androidx.compose.material.icons.filled;

import androidx.compose.ui.graphics.vector.ImageVector;
import kotlin.reflect.KClass;
import kotlinx.serialization.descriptors.ContextDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.SerialDescriptorForNullable;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class DnsKt {
    public static ImageVector _dns;

    public static final KClass getCapturedKClass(SerialDescriptor serialDescriptor) {
        if (!(serialDescriptor instanceof ContextDescriptor) && (serialDescriptor instanceof SerialDescriptorForNullable)) {
            return getCapturedKClass(((SerialDescriptorForNullable) serialDescriptor).original);
        }
        return null;
    }
}
