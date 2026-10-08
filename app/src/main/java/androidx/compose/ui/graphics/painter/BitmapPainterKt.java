package androidx.compose.ui.graphics.painter;

import android.graphics.Bitmap;
import androidx.compose.ui.graphics.AndroidImageBitmap;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class BitmapPainterKt {
    /* JADX INFO: renamed from: BitmapPainter-QZhYCtY$default, reason: not valid java name */
    public static BitmapPainter m491BitmapPainterQZhYCtY$default(AndroidImageBitmap androidImageBitmap, int i) {
        Bitmap bitmap = androidImageBitmap.bitmap;
        BitmapPainter bitmapPainter = new BitmapPainter(androidImageBitmap, (((long) bitmap.getWidth()) << 32) | (((long) bitmap.getHeight()) & 4294967295L));
        bitmapPainter.filterQuality = i;
        return bitmapPainter;
    }
}
