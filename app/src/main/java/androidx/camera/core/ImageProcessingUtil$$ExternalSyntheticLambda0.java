package androidx.camera.core;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ImageProcessingUtil$$ExternalSyntheticLambda0 implements ForwardingImageProxy.OnImageCloseListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ ImageProxy f$1;

    public /* synthetic */ ImageProcessingUtil$$ExternalSyntheticLambda0(ImageProxy imageProxy, ImageProxy imageProxy2, int i) {
        this.$r8$classId = i;
        this.f$1 = imageProxy2;
    }

    @Override // androidx.camera.core.ForwardingImageProxy.OnImageCloseListener
    public final void onImageClose(ForwardingImageProxy forwardingImageProxy) throws Exception {
        int i = this.$r8$classId;
        ImageProxy imageProxy = this.f$1;
        switch (i) {
            case 0:
                int i2 = ImageProcessingUtil.sImageCount;
                if (imageProxy != null) {
                    imageProxy.close();
                }
                break;
            default:
                int i3 = ImageProcessingUtil.sImageCount;
                imageProxy.close();
                break;
        }
    }
}
