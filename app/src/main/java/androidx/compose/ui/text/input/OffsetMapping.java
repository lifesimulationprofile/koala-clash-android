package androidx.compose.ui.text.input;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface OffsetMapping {

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Companion {
        public static final VisualTransformation$Companion Identity = new VisualTransformation$Companion();
    }

    int originalToTransformed(int i);

    int transformedToOriginal(int i);
}
