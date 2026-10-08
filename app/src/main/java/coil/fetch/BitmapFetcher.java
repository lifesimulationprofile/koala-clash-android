package coil.fetch;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import coil.decode.SourceImageSource;
import coil.request.Options;
import coil.util.DrawableUtils;
import coil.util.Utils;
import java.nio.ByteBuffer;
import kotlin.coroutines.Continuation;
import okio.Buffer;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class BitmapFetcher implements Fetcher {
    public final /* synthetic */ int $r8$classId;
    public final Object data;
    public final Options options;

    public /* synthetic */ BitmapFetcher(Object obj, Options options, int i) {
        this.$r8$classId = i;
        this.data = obj;
        this.options = options;
    }

    @Override // coil.fetch.Fetcher
    public final Object fetch(Continuation continuation) {
        int i = this.$r8$classId;
        Object obj = this.data;
        Options options = this.options;
        switch (i) {
            case 0:
                return new DrawableResult(new BitmapDrawable(options.context.getResources(), (Bitmap) obj), false, 2);
            case 1:
                ByteBuffer byteBuffer = (ByteBuffer) obj;
                try {
                    Buffer buffer = new Buffer();
                    buffer.write(byteBuffer);
                    byteBuffer.position(0);
                    Context context = options.context;
                    return new SourceResult(new SourceImageSource(buffer, null), null, 2);
                } catch (Throwable th) {
                    byteBuffer.position(0);
                    throw th;
                }
            default:
                Drawable bitmapDrawable = (Drawable) obj;
                Bitmap.Config[] configArr = Utils.VALID_TRANSFORMATION_CONFIGS;
                boolean z = (bitmapDrawable instanceof VectorDrawable) || (bitmapDrawable instanceof VectorDrawableCompat);
                if (z) {
                    bitmapDrawable = new BitmapDrawable(options.context.getResources(), DrawableUtils.convertToBitmap(bitmapDrawable, options.config, options.size, options.scale, options.allowInexactSize));
                }
                return new DrawableResult(bitmapDrawable, z, 2);
        }
    }
}
