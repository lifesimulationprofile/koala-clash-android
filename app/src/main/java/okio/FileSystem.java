package okio;

import java.io.FileNotFoundException;
import java.util.List;
import okio.internal.ResourceFileSystem;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class FileSystem {
    public static final JvmSystemFileSystem SYSTEM;

    static {
        JvmSystemFileSystem jvmSystemFileSystem;
        try {
            Class.forName("java.nio.file.Files");
            jvmSystemFileSystem = new NioSystemFileSystem();
        } catch (ClassNotFoundException unused) {
            jvmSystemFileSystem = new JvmSystemFileSystem();
        }
        SYSTEM = jvmSystemFileSystem;
        String str = Path.DIRECTORY_SEPARATOR;
        Path.Companion.get$default(System.getProperty("java.io.tmpdir"));
        new ResourceFileSystem(ResourceFileSystem.class.getClassLoader());
    }

    public abstract Sink appendingSink(Path path);

    public abstract void atomicMove(Path path, Path path2);

    public abstract void createDirectory(Path path);

    public abstract void delete(Path path);

    public final boolean exists(Path path) {
        return metadataOrNull(path) != null;
    }

    public abstract List list(Path path);

    public final FileMetadata metadata(Path path) throws FileNotFoundException {
        FileMetadata fileMetadataMetadataOrNull = metadataOrNull(path);
        if (fileMetadataMetadataOrNull != null) {
            return fileMetadataMetadataOrNull;
        }
        throw new FileNotFoundException("no such file: " + path);
    }

    public abstract FileMetadata metadataOrNull(Path path);

    public abstract JvmFileHandle openReadOnly(Path path);

    public abstract Sink sink(Path path);

    public abstract Source source(Path path);
}
