package kotlinx.serialization.json.internal;

import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import coil.request.RequestService;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class CharArrayPoolBase {
    public Object arrays;
    public int charsTotal;

    public CharArrayPoolBase(int i) {
        this.charsTotal = i;
    }

    public abstract WindowInsetsCompat onProgress(WindowInsetsCompat windowInsetsCompat, List list);

    public abstract RequestService onStart(WindowInsetsAnimationCompat windowInsetsAnimationCompat, RequestService requestService);

    public void onPrepare() {
    }

    public void onEnd(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
    }
}
