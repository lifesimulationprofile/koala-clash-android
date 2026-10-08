package kotlin.ranges;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorKt;
import okhttp3.Headers;

/* JADX INFO: loaded from: classes.dex */
public abstract class RangesKt {
    public static ImageVector _arrowBack;

    public static int coerceIn(int i, int i2, int i3) {
        if (i2 <= i3) {
            if (i < i2) {
                return i2;
            }
            return i > i3 ? i3 : i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i3 + " is less than minimum " + i2 + '.');
    }

    public static final ImageVector getArrowBack() {
        ImageVector imageVector = _arrowBack;
        if (imageVector != null) {
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("AutoMirrored.Filled.ArrowBack", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, true, 96);
        int i = VectorKt.$r8$clinit;
        SolidColor solidColor = new SolidColor(Color.Black);
        Headers.Builder builder2 = new Headers.Builder(2);
        builder2.moveTo(20.0f, 11.0f);
        builder2.horizontalLineTo(7.83f);
        builder2.lineToRelative(5.59f, -5.59f);
        builder2.lineTo(12.0f, 4.0f);
        builder2.lineToRelative(-8.0f, 8.0f);
        builder2.lineToRelative(8.0f, 8.0f);
        builder2.lineToRelative(1.41f, -1.41f);
        builder2.lineTo(7.83f, 13.0f);
        builder2.horizontalLineTo(20.0f);
        builder2.verticalLineToRelative(-2.0f);
        builder2.close();
        ImageVector.Builder.m500addPathoIyEayM$default(builder, builder2.namesAndValues, solidColor);
        ImageVector imageVectorBuild = builder.build();
        _arrowBack = imageVectorBuild;
        return imageVectorBuild;
    }

    public static IntProgression step(IntRange intRange, int i) {
        boolean z = i > 0;
        Integer numValueOf = Integer.valueOf(i);
        if (!z) {
            throw new IllegalArgumentException("Step must be positive, was: " + numValueOf + '.');
        }
        int i2 = intRange.first;
        int i3 = intRange.last;
        if (intRange.step <= 0) {
            i = -i;
        }
        return new IntProgression(i2, i3, i);
    }

    public static IntRange until(int i, int i2) {
        if (i2 > Integer.MIN_VALUE) {
            return new IntRange(i, i2 - 1, 1);
        }
        IntRange intRange = IntRange.EMPTY;
        return IntRange.EMPTY;
    }

    public static long coerceIn(long j, long j2, long j3) {
        if (j2 <= j3) {
            if (j < j2) {
                return j2;
            }
            return j > j3 ? j3 : j;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j3 + " is less than minimum " + j2 + '.');
    }

    public static float coerceIn(float f, float f2, float f3) {
        if (f2 <= f3) {
            if (f < f2) {
                return f2;
            }
            return f > f3 ? f3 : f;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f3 + " is less than minimum " + f2 + '.');
    }

    public static double coerceIn(double d, double d2, double d3) {
        if (d2 <= d3) {
            if (d < d2) {
                return d2;
            }
            return d > d3 ? d3 : d;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + d3 + " is less than minimum " + d2 + '.');
    }
}
