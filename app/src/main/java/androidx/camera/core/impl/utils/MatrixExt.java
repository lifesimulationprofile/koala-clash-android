package androidx.camera.core.impl.utils;

import android.opengl.Matrix;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.collections.ArrayAsCollection;
import kotlin.collections.EmptyList;
import kotlin.collections.builders.ListBuilder;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class MatrixExt {
    public static ArrayList arrayListOf(Object... objArr) {
        return objArr.length == 0 ? new ArrayList() : new ArrayList(new ArrayAsCollection(objArr, true));
    }

    public static int binarySearch$default(ArrayList arrayList, Comparable comparable) {
        int size = arrayList.size();
        int size2 = arrayList.size();
        int i = 0;
        if (size < 0) {
            throw new IllegalArgumentException("fromIndex (0) is greater than toIndex (" + size + ").");
        }
        if (size > size2) {
            throw new IndexOutOfBoundsException("toIndex (" + size + ") is greater than size (" + size2 + ").");
        }
        int i2 = size - 1;
        while (i <= i2) {
            int i3 = (i + i2) >>> 1;
            int iCompareValues = ComparisonsKt__ComparisonsKt.compareValues((Comparable) arrayList.get(i3), comparable);
            if (iCompareValues < 0) {
                i = i3 + 1;
            } else {
                if (iCompareValues <= 0) {
                    return i3;
                }
                i2 = i3 - 1;
            }
        }
        return -(i + 1);
    }

    public static ListBuilder build(ListBuilder listBuilder) {
        listBuilder.checkIsMutable$1();
        listBuilder.isReadOnly = true;
        return listBuilder.length > 0 ? listBuilder : ListBuilder.Empty;
    }

    public static ListBuilder createListBuilder() {
        return new ListBuilder(10);
    }

    public static int getLastIndex(List list) {
        return list.size() - 1;
    }

    public static List listOf(Object... objArr) {
        return objArr.length > 0 ? Arrays.asList(objArr) : EmptyList.INSTANCE;
    }

    public static ArrayList mutableListOf(Object... objArr) {
        return objArr.length == 0 ? new ArrayList() : new ArrayList(new ArrayAsCollection(objArr, true));
    }

    public static final List optimizeReadOnlyList(List list) {
        int size = list.size();
        if (size != 0) {
            return size != 1 ? list : Collections.singletonList(list.get(0));
        }
        return EmptyList.INSTANCE;
    }

    public static void preRotate(float[] fArr, float f) {
        Matrix.translateM(fArr, 0, 0.5f, 0.5f, 0.0f);
        Matrix.rotateM(fArr, 0, f, 0.0f, 0.0f, 1.0f);
        Matrix.translateM(fArr, 0, -0.5f, -0.5f, 0.0f);
    }

    public static void preVerticalFlip(float[] fArr) {
        Matrix.translateM(fArr, 0, 0.0f, 0.5f, 0.0f);
        Matrix.scaleM(fArr, 0, 1.0f, -1.0f, 1.0f);
        Matrix.translateM(fArr, 0, -0.0f, -0.5f, 0.0f);
    }

    public static void throwIndexOverflow() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
