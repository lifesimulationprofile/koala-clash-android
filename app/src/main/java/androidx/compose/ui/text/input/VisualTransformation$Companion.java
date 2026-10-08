package androidx.compose.ui.text.input;

import androidx.camera.camera2.internal.ZslControlImpl$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class VisualTransformation$Companion implements OffsetMapping {
    public static final ZslControlImpl$$ExternalSyntheticLambda0 None = new ZslControlImpl$$ExternalSyntheticLambda0(20);

    @Override // androidx.compose.ui.text.input.OffsetMapping
    public int originalToTransformed(int i) {
        return i;
    }

    @Override // androidx.compose.ui.text.input.OffsetMapping
    public int transformedToOriginal(int i) {
        return i;
    }
}
