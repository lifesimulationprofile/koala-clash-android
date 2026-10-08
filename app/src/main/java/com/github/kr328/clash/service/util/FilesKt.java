package com.github.kr328.clash.service.util;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;
import kotlin.Unit;
import kotlin.collections.ArraysKt__ArraysJVMKt;
import kotlin.collections.IntIterator;
import kotlin.io.CloseableKt;
import kotlin.ranges.IntProgressionIterator;
import kotlin.ranges.IntRange;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class FilesKt {
    public static final byte[] UTF8_BOM = {-17, -69, -65};
    public static final byte[] SVG_TAG = "<svg".getBytes(Charsets.US_ASCII);

    public static final File getImportedDir(Context context) {
        return kotlin.io.FilesKt.resolve(context.getFilesDir(), "imported");
    }

    public static final void writeProfileLogo(Context context, UUID uuid, byte[] bArr) throws IOException {
        int i;
        int iNextInt;
        byte b;
        File fileResolve = kotlin.io.FilesKt.resolve(kotlin.io.FilesKt.resolve(getImportedDir(context), uuid.toString()), "profile-logo");
        if (bArr == null || bArr.length == 0) {
            fileResolve.delete();
            return;
        }
        File parentFile = fileResolve.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        int i2 = 3;
        if (bArr.length < 3) {
            i2 = 0;
            break;
        }
        Iterable intRange = new IntRange(0, 2, 1);
        if (!(intRange instanceof Collection) || !((Collection) intRange).isEmpty()) {
            Iterator it = intRange.iterator();
            while (((IntProgressionIterator) it).hasNext) {
                int iNextInt2 = ((IntIterator) it).nextInt();
                if (bArr[iNextInt2] != UTF8_BOM[iNextInt2]) {
                    i2 = 0;
                    break;
                }
            }
        }
        while (i2 < bArr.length && ((b = bArr[i2]) == 32 || b == 10 || b == 13 || b == 9)) {
            i2++;
        }
        if (i2 != 0 && i2 < bArr.length && bArr[i2] == 60) {
            int length = bArr.length;
            byte[] bArr2 = SVG_TAG;
            int iMin = Math.min(i2 + 1024, length - bArr2.length);
            if (i2 > iMin) {
                i = -1;
                break;
            }
            i = i2;
            loop1: while (true) {
                Iterable intRange2 = new IntRange(0, bArr2.length - 1, 1);
                if (!(intRange2 instanceof Collection) || !((Collection) intRange2).isEmpty()) {
                    Iterator it2 = intRange2.iterator();
                    do {
                        if (!((IntProgressionIterator) it2).hasNext) {
                            break loop1;
                        } else {
                            iNextInt = ((IntIterator) it2).nextInt();
                        }
                    } while (bArr[i + iNextInt] == bArr2[iNextInt]);
                    if (i == iMin) {
                        i = -1;
                        break;
                    }
                    i++;
                } else {
                    break;
                }
            }
            if (i >= 0) {
                int length2 = bArr.length;
                ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(length2, bArr.length);
                bArr = Arrays.copyOfRange(bArr, i2, length2);
            }
        }
        FileOutputStream fileOutputStream = new FileOutputStream(fileResolve);
        try {
            fileOutputStream.write(bArr);
            Unit unit = Unit.INSTANCE;
            fileOutputStream.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(fileOutputStream, th);
                throw th2;
            }
        }
    }
}
