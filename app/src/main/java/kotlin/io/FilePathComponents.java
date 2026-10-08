package kotlin.io;

import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class FilePathComponents {
    public final File root;
    public final Object segments;

    public FilePathComponents(File file, List list) {
        this.root = file;
        this.segments = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FilePathComponents)) {
            return false;
        }
        FilePathComponents filePathComponents = (FilePathComponents) obj;
        return this.root.equals(filePathComponents.root) && this.segments.equals(filePathComponents.segments);
    }

    public final int hashCode() {
        return this.segments.hashCode() + (this.root.hashCode() * 31);
    }

    public final String toString() {
        return "FilePathComponents(root=" + this.root + ", segments=" + this.segments + ')';
    }
}
