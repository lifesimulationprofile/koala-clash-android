package okio.internal;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class EocdRecord {
    public final long centralDirectoryOffset;
    public final long entryCount;

    public EocdRecord(long j, long j2, int i) {
        this.entryCount = j;
        this.centralDirectoryOffset = j2;
    }
}
