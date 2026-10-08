package okio;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorKt;
import java.util.ArrayList;
import okhttp3.Headers;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Options$Companion {
    public static ImageVector _swapHoriz;

    public static void buildTrieRecursive(long j, Buffer buffer, int i, ArrayList arrayList, int i2, int i3, ArrayList arrayList2) {
        int i4;
        int i5;
        ArrayList arrayList3;
        long j2;
        int i6;
        int i7 = i;
        ArrayList arrayList4 = arrayList;
        ArrayList arrayList5 = arrayList2;
        if (i2 >= i3) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        for (int i8 = i2; i8 < i3; i8++) {
            if (((ByteString) arrayList4.get(i8)).getSize$okio() < i7) {
                throw new IllegalArgumentException("Failed requirement.");
            }
        }
        ByteString byteString = (ByteString) arrayList.get(i2);
        ByteString byteString2 = (ByteString) arrayList4.get(i3 - 1);
        if (i7 == byteString.getSize$okio()) {
            int iIntValue = ((Number) arrayList5.get(i2)).intValue();
            int i9 = i2 + 1;
            ByteString byteString3 = (ByteString) arrayList4.get(i9);
            i4 = i9;
            i5 = iIntValue;
            byteString = byteString3;
        } else {
            i4 = i2;
            i5 = -1;
        }
        if (byteString.internalGet$okio(i7) == byteString2.internalGet$okio(i7)) {
            int iMin = Math.min(byteString.getSize$okio(), byteString2.getSize$okio());
            int i10 = 0;
            for (int i11 = i7; i11 < iMin && byteString.internalGet$okio(i11) == byteString2.internalGet$okio(i11); i11++) {
                i10++;
            }
            long j3 = 4;
            long j4 = (buffer.size / j3) + j + ((long) 2) + ((long) i10) + 1;
            buffer.m866writeInt(-i10);
            buffer.m866writeInt(i5);
            int i12 = i7 + i10;
            while (i7 < i12) {
                buffer.m866writeInt(byteString.internalGet$okio(i7) & 255);
                i7++;
            }
            if (i4 + 1 == i3) {
                if (i12 != ((ByteString) arrayList4.get(i4)).getSize$okio()) {
                    throw new IllegalStateException("Check failed.");
                }
                buffer.m866writeInt(((Number) arrayList5.get(i4)).intValue());
                return;
            } else {
                Buffer buffer2 = new Buffer();
                buffer.m866writeInt(((int) ((buffer2.size / j3) + j4)) * (-1));
                buildTrieRecursive(j4, buffer2, i12, arrayList4, i4, i3, arrayList5);
                buffer.writeAll(buffer2);
                return;
            }
        }
        int i13 = 1;
        for (int i14 = i4 + 1; i14 < i3; i14++) {
            if (((ByteString) arrayList4.get(i14 - 1)).internalGet$okio(i7) != ((ByteString) arrayList4.get(i14)).internalGet$okio(i7)) {
                i13++;
            }
        }
        long j5 = 4;
        long j6 = (buffer.size / j5) + j + ((long) 2) + ((long) (i13 * 2));
        buffer.m866writeInt(i13);
        buffer.m866writeInt(i5);
        for (int i15 = i4; i15 < i3; i15++) {
            int iInternalGet$okio = ((ByteString) arrayList4.get(i15)).internalGet$okio(i7);
            if (i15 == i4 || iInternalGet$okio != ((ByteString) arrayList4.get(i15 - 1)).internalGet$okio(i7)) {
                buffer.m866writeInt(iInternalGet$okio & 255);
            }
        }
        Buffer buffer3 = new Buffer();
        int i16 = i4;
        while (i16 < i3) {
            byte bInternalGet$okio = ((ByteString) arrayList4.get(i16)).internalGet$okio(i7);
            int i17 = i16 + 1;
            int i18 = i17;
            while (true) {
                if (i18 >= i3) {
                    i18 = i3;
                    break;
                } else if (bInternalGet$okio != ((ByteString) arrayList4.get(i18)).internalGet$okio(i7)) {
                    break;
                } else {
                    i18++;
                }
            }
            if (i17 == i18 && i7 + 1 == ((ByteString) arrayList4.get(i16)).getSize$okio()) {
                buffer.m866writeInt(((Number) arrayList5.get(i16)).intValue());
                arrayList3 = arrayList5;
                j2 = j6;
                i6 = i18;
            } else {
                buffer.m866writeInt(((int) ((buffer3.size / j5) + j6)) * (-1));
                arrayList3 = arrayList5;
                j2 = j6;
                i6 = i18;
                buildTrieRecursive(j2, buffer3, i7 + 1, arrayList, i16, i6, arrayList3);
                arrayList4 = arrayList;
            }
            j6 = j2;
            i16 = i6;
            arrayList5 = arrayList3;
        }
        buffer.writeAll(buffer3);
    }

    public static final ImageVector getSwapHoriz() {
        ImageVector imageVector = _swapHoriz;
        if (imageVector != null) {
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Filled.SwapHoriz", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
        int i = VectorKt.$r8$clinit;
        SolidColor solidColor = new SolidColor(Color.Black);
        Headers.Builder builder2 = new Headers.Builder(2);
        builder2.moveTo(6.99f, 11.0f);
        builder2.lineTo(3.0f, 15.0f);
        builder2.lineToRelative(3.99f, 4.0f);
        builder2.verticalLineToRelative(-3.0f);
        builder2.horizontalLineTo(14.0f);
        builder2.verticalLineToRelative(-2.0f);
        builder2.horizontalLineTo(6.99f);
        builder2.verticalLineToRelative(-3.0f);
        builder2.close();
        builder2.moveTo(21.0f, 9.0f);
        builder2.lineToRelative(-3.99f, -4.0f);
        builder2.verticalLineToRelative(3.0f);
        builder2.horizontalLineTo(10.0f);
        builder2.verticalLineToRelative(2.0f);
        builder2.horizontalLineToRelative(7.01f);
        builder2.verticalLineToRelative(3.0f);
        builder2.lineTo(21.0f, 9.0f);
        builder2.close();
        ImageVector.Builder.m500addPathoIyEayM$default(builder, builder2.namesAndValues, solidColor);
        ImageVector imageVectorBuild = builder.build();
        _swapHoriz = imageVectorBuild;
        return imageVectorBuild;
    }
}
