package androidx.compose.ui.node;

import androidx.compose.ui.graphics.TransformOrigin;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class LayerPositionalProperties {
    public float rotationX;
    public float rotationY;
    public float rotationZ;
    public long transformOrigin;
    public float translationX;
    public float translationY;
    public float scaleX = 1.0f;
    public float scaleY = 1.0f;
    public float cameraDistance = 8.0f;

    public LayerPositionalProperties() {
        int i = TransformOrigin.$r8$clinit;
        this.transformOrigin = TransformOrigin.Center;
    }
}
