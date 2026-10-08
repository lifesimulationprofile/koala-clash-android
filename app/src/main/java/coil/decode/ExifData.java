package coil.decode;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ExifData {
    public static final ExifData NONE = new ExifData(0, false);
    public final boolean isFlipped;
    public final int rotationDegrees;

    public ExifData(int i, boolean z) {
        this.isFlipped = z;
        this.rotationDegrees = i;
    }
}
