package androidx.profileinstaller;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class WritableFileSection {
    public final byte[] mContents;
    public final boolean mNeedsCompression;
    public final int mType;

    public WritableFileSection(int i, byte[] bArr, boolean z) {
        this.mType = i;
        this.mContents = bArr;
        this.mNeedsCompression = z;
    }
}
