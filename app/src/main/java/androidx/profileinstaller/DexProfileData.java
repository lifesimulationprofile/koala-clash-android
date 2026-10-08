package androidx.profileinstaller;

import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class DexProfileData {
    public final String apkName;
    public int classSetSize;
    public int[] classes;
    public final long dexChecksum;
    public final String dexName;
    public final int hotMethodRegionSize;
    public long mTypeIdCount = 0;
    public final TreeMap methods;
    public final int numMethodIds;

    public DexProfileData(String str, String str2, long j, int i, int i2, int i3, int[] iArr, TreeMap treeMap) {
        this.apkName = str;
        this.dexName = str2;
        this.dexChecksum = j;
        this.classSetSize = i;
        this.hotMethodRegionSize = i2;
        this.numMethodIds = i3;
        this.classes = iArr;
        this.methods = treeMap;
    }
}
