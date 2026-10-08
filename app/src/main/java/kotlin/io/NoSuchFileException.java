package kotlin.io;

import java.io.File;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class NoSuchFileException extends FileSystemException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoSuchFileException(File file, int i) {
        super(file, null, "The source file doesn't exist.");
        switch (i) {
            case 1:
                super(file, null, "Cannot list files in a directory");
                break;
            default:
                break;
        }
    }
}
