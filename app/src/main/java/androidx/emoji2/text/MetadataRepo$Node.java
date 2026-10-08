package androidx.emoji2.text;

import android.util.SparseArray;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class MetadataRepo$Node {
    public final SparseArray mChildren;
    public TypefaceEmojiRasterizer mData;

    public MetadataRepo$Node(int i) {
        this.mChildren = new SparseArray(i);
    }

    public final void put(TypefaceEmojiRasterizer typefaceEmojiRasterizer, int i, int i2) {
        int codepointAt = typefaceEmojiRasterizer.getCodepointAt(i);
        SparseArray sparseArray = this.mChildren;
        MetadataRepo$Node metadataRepo$Node = sparseArray == null ? null : (MetadataRepo$Node) sparseArray.get(codepointAt);
        if (metadataRepo$Node == null) {
            metadataRepo$Node = new MetadataRepo$Node(1);
            sparseArray.put(typefaceEmojiRasterizer.getCodepointAt(i), metadataRepo$Node);
        }
        if (i2 > i) {
            metadataRepo$Node.put(typefaceEmojiRasterizer, i + 1, i2);
        } else {
            metadataRepo$Node.mData = typefaceEmojiRasterizer;
        }
    }
}
