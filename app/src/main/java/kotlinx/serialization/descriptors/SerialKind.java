package kotlinx.serialization.descriptors;

import androidx.compose.ui.graphics.vector.ImageVector;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SerialKind {
    public static ImageVector _download;
    public final /* synthetic */ int $r8$classId = 0;

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class CONTEXTUAL extends SerialKind {
        public static final CONTEXTUAL INSTANCE = new CONTEXTUAL();
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class ENUM extends SerialKind {
        public static final ENUM INSTANCE = new ENUM();
    }

    public int hashCode() {
        switch (this.$r8$classId) {
            case 0:
                return toString().hashCode();
            default:
                return super.hashCode();
        }
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 0:
                return Reflection.getOrCreateKotlinClass(getClass()).getSimpleName();
            default:
                return super.toString();
        }
    }
}
