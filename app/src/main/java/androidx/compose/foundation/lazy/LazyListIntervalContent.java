package androidx.compose.foundation.lazy;

import androidx.compose.runtime.internal.ComposableLambdaImpl;
import coil.ImageLoader$Builder;
import kotlin.jvm.functions.Function1;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class LazyListIntervalContent {
    public final StatusLine intervals = new StatusLine(2);

    public LazyListIntervalContent(Function1 function1) {
        function1.invoke(this);
    }

    public final void items(int i, Function1 function1, Function1 function2, ComposableLambdaImpl composableLambdaImpl) {
        this.intervals.addInterval(i, new ImageLoader$Builder(function1, function2, composableLambdaImpl, 5));
    }
}
