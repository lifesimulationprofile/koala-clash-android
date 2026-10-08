package okio;

import androidx.compose.ui.graphics.vector.ImageVector;
import java.io.InputStream;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public abstract class Okio {
    public static ImageVector _supportAgent;

    public static final InputStreamSource source(InputStream inputStream) {
        Logger logger = Okio__JvmOkioKt.logger;
        return new InputStreamSource(0, inputStream, new Timeout());
    }
}
